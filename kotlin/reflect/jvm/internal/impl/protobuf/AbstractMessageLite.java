/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public abstract class AbstractMessageLite
implements MessageLite {
    protected int memoizedHashCode = 0;

    @Override
    public byte[] toByteArray() {
        try {
            byte[] result = new byte[this.getSerializedSize()];
            CodedOutputStream output = CodedOutputStream.newInstance(result);
            this.writeTo(output);
            output.checkNoSpaceLeft();
            return result;
        }
        catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public void writeDelimitedTo(OutputStream output) throws IOException {
        int serialized = this.getSerializedSize();
        int bufferSize = CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serialized) + serialized);
        CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, bufferSize);
        codedOutput.writeRawVarint32(serialized);
        this.writeTo(codedOutput);
        codedOutput.flush();
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public static abstract class Builder<BuilderType extends Builder>
    implements MessageLite.Builder {
        public abstract BuilderType clone();

        public abstract BuilderType mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) throws IOException;

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite message) {
            return new UninitializedMessageException(message);
        }

        protected static <T> void addAll(Iterable<T> values, Collection<? super T> list) {
            if (values instanceof LazyStringList) {
                Builder.checkForNullValues(((LazyStringList)values).getUnderlyingElements());
                list.addAll((Collection)values);
            } else if (values instanceof Collection) {
                Builder.checkForNullValues(values);
                list.addAll((Collection)values);
            } else {
                for (T value : values) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    list.add(value);
                }
            }
        }

        private static void checkForNullValues(Iterable<?> values) {
            for (Object value : values) {
                if (value != null) continue;
                throw new NullPointerException();
            }
        }

        static final class LimitedInputStream
        extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream in, int limit) {
                super(in);
                this.limit = limit;
            }

            @Override
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override
            public int read() throws IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int result = super.read();
                if (result >= 0) {
                    --this.limit;
                }
                return result;
            }

            @Override
            public int read(byte[] b2, int off, int len) throws IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int result = super.read(b2, off, len = Math.min(len, this.limit));
                if (result >= 0) {
                    this.limit -= result;
                }
                return result;
            }

            @Override
            public long skip(long n2) throws IOException {
                long result = super.skip(Math.min(n2, (long)this.limit));
                if (result >= 0L) {
                    this.limit = (int)((long)this.limit - result);
                }
                return result;
            }
        }
    }
}


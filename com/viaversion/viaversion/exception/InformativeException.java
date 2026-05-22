/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.exception;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.util.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={DataEntry.class})
public class InformativeException
extends RuntimeException {
    private static final int MAX_MESSAGE_LENGTH = 5000;
    private final List<DataEntry> dataEntries = new ArrayList<DataEntry>();
    private boolean shouldBePrinted = true;
    private int sources;

    public InformativeException(Throwable cause) {
        super(cause);
    }

    public InformativeException set(String key, @Nullable Object value) {
        this.dataEntries.add(new DataEntry(key, value));
        return this;
    }

    public InformativeException addSource(Class<?> sourceClazz) {
        return this.set(InformativeException.jvmdowngrader$concat$addSource$1(this.sources++), this.getSource(sourceClazz));
    }

    private String getSource(Class<?> sourceClazz) {
        return sourceClazz.isAnonymousClass() ? InformativeException.jvmdowngrader$concat$getSource$1(sourceClazz.getName()) : sourceClazz.getName();
    }

    public boolean shouldBePrinted() {
        return this.shouldBePrinted;
    }

    public void setShouldBePrinted(boolean shouldBePrinted) {
        this.shouldBePrinted = shouldBePrinted;
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder("Please report this on the Via support Discord or open an issue on the relevant GitHub repository\n");
        boolean first = true;
        for (DataEntry entry : this.dataEntries) {
            if (!first) {
                builder.append(", ");
            } else {
                first = false;
            }
            builder.append(entry.name()).append(": ");
            String s2 = String.valueOf(entry.value());
            if (!Via.getManager().isDebug() && s2.length() > 10 && builder.length() + s2.length() > 5000) {
                s2 = InformativeException.jvmdowngrader$concat$getMessage$1(s2.substring(0, 5000 - builder.length()));
            }
            builder.append(StringUtil.forLogging(s2));
        }
        return builder.toString();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    private static String jvmdowngrader$concat$addSource$1(int n2) {
        return "Source " + n2;
    }

    private static String jvmdowngrader$concat$getSource$1(String string) {
        return string + " (Anonymous)";
    }

    private static String jvmdowngrader$concat$getMessage$1(String string) {
        return string + "...";
    }

    @RecordComponents(value={@RecordComponents.Value(name="name", type=String.class), @RecordComponents.Value(name="value", type=Object.class)})
    @NestHost(value=InformativeException.class)
    private static final class DataEntry
    extends J_L_Record {
        private final String name;
        private final @Nullable Object value;

        DataEntry(String name, @Nullable Object value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public final String toString() {
            return DataEntry.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return DataEntry.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return DataEntry.jvmdowngrader$equals$equals(this, o2);
        }

        public String name() {
            return this.name;
        }

        public @Nullable Object value() {
            return this.value;
        }

        private static String jvmdowngrader$toString$toString(DataEntry dataEntry) {
            DataEntry dataEntry2 = dataEntry;
            return "InformativeException$DataEntry[" + "name=" + dataEntry.name + ", " + "value=" + dataEntry.value + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(DataEntry dataEntry) {
            Object[] objectArray = new Object[]{dataEntry.name, dataEntry.value};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(DataEntry dataEntry, Object object) {
            if (dataEntry == object) {
                return true;
            }
            if (object != null && object instanceof DataEntry) {
                DataEntry dataEntry2 = (DataEntry)object;
                if (Objects.equals(dataEntry.name, dataEntry2.name) && Objects.equals(dataEntry.value, dataEntry2.value)) {
                    return true;
                }
            }
            return false;
        }
    }
}


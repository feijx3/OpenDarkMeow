/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.darkmeow.irc.lib.io.netty.handler.codec.DefaultHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.Headers;
import net.darkmeow.irc.lib.io.netty.handler.codec.ValueConverter;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaderNames;
import net.darkmeow.irc.lib.io.netty.util.AsciiString;
import net.darkmeow.irc.lib.io.netty.util.HashingStrategy;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

public class CombinedHttpHeaders
extends DefaultHttpHeaders {
    @Deprecated
    public CombinedHttpHeaders(boolean validate) {
        super(new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, CombinedHttpHeaders.valueConverter(), CombinedHttpHeaders.nameValidator(validate), CombinedHttpHeaders.valueValidator(validate)));
    }

    CombinedHttpHeaders(DefaultHeaders.NameValidator<CharSequence> nameValidator, DefaultHeaders.ValueValidator<CharSequence> valueValidator) {
        super(new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, CombinedHttpHeaders.valueConverter(), ObjectUtil.checkNotNull(nameValidator, "nameValidator"), ObjectUtil.checkNotNull(valueValidator, "valueValidator")));
    }

    CombinedHttpHeaders(DefaultHeaders.NameValidator<CharSequence> nameValidator, DefaultHeaders.ValueValidator<CharSequence> valueValidator, int sizeHint) {
        super(new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, CombinedHttpHeaders.valueConverter(), ObjectUtil.checkNotNull(nameValidator, "nameValidator"), ObjectUtil.checkNotNull(valueValidator, "valueValidator"), sizeHint));
    }

    @Override
    public boolean containsValue(CharSequence name, CharSequence value, boolean ignoreCase) {
        return super.containsValue(name, StringUtil.trimOws(value), ignoreCase);
    }

    private static final class CombinedHttpHeadersImpl
    extends DefaultHeaders<CharSequence, CharSequence, CombinedHttpHeadersImpl> {
        private static final int VALUE_LENGTH_ESTIMATE = 10;
        private CsvValueEscaper<Object> objectEscaper;
        private CsvValueEscaper<CharSequence> charSequenceEscaper;

        private CsvValueEscaper<Object> objectEscaper() {
            if (this.objectEscaper == null) {
                this.objectEscaper = new CsvValueEscaper<Object>(){

                    @Override
                    public CharSequence escape(CharSequence name, Object value) {
                        CharSequence converted;
                        try {
                            converted = (CharSequence)this.valueConverter().convertObject(value);
                        }
                        catch (IllegalArgumentException e2) {
                            throw new IllegalArgumentException("Failed to convert object value for header '" + name + '\'', e2);
                        }
                        return StringUtil.escapeCsv(converted, true);
                    }
                };
            }
            return this.objectEscaper;
        }

        private CsvValueEscaper<CharSequence> charSequenceEscaper() {
            if (this.charSequenceEscaper == null) {
                this.charSequenceEscaper = new CsvValueEscaper<CharSequence>(){

                    @Override
                    public CharSequence escape(CharSequence name, CharSequence value) {
                        return StringUtil.escapeCsv(value, true);
                    }
                };
            }
            return this.charSequenceEscaper;
        }

        CombinedHttpHeadersImpl(HashingStrategy<CharSequence> nameHashingStrategy, ValueConverter<CharSequence> valueConverter, DefaultHeaders.NameValidator<CharSequence> nameValidator, DefaultHeaders.ValueValidator<CharSequence> valueValidator) {
            this(nameHashingStrategy, valueConverter, nameValidator, valueValidator, 16);
        }

        CombinedHttpHeadersImpl(HashingStrategy<CharSequence> nameHashingStrategy, ValueConverter<CharSequence> valueConverter, DefaultHeaders.NameValidator<CharSequence> nameValidator, DefaultHeaders.ValueValidator<CharSequence> valueValidator, int sizeHint) {
            super(nameHashingStrategy, valueConverter, nameValidator, sizeHint, valueValidator);
        }

        @Override
        public Iterator<CharSequence> valueIterator(CharSequence name) {
            Iterator<CharSequence> itr = super.valueIterator(name);
            if (!itr.hasNext() || CombinedHttpHeadersImpl.cannotBeCombined(name)) {
                return itr;
            }
            Iterator<CharSequence> unescapedItr = StringUtil.unescapeCsvFields(itr.next()).iterator();
            if (itr.hasNext()) {
                throw new IllegalStateException("CombinedHttpHeaders should only have one value");
            }
            return unescapedItr;
        }

        @Override
        public List<CharSequence> getAll(CharSequence name) {
            List<CharSequence> values = super.getAll(name);
            if (values.isEmpty() || CombinedHttpHeadersImpl.cannotBeCombined(name)) {
                return values;
            }
            if (values.size() != 1) {
                throw new IllegalStateException("CombinedHttpHeaders should only have one value");
            }
            return StringUtil.unescapeCsvFields(values.get(0));
        }

        @Override
        public CombinedHttpHeadersImpl add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                throw new IllegalArgumentException("can't add to itself.");
            }
            if (headers instanceof CombinedHttpHeadersImpl) {
                if (this.isEmpty()) {
                    this.addImpl(headers);
                } else {
                    for (Map.Entry<CharSequence, CharSequence> entry : headers) {
                        this.addEscapedValue(entry.getKey(), entry.getValue());
                    }
                }
            } else {
                for (Map.Entry<CharSequence, CharSequence> entry : headers) {
                    this.add(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        @Override
        public CombinedHttpHeadersImpl set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            this.clear();
            return this.add((Headers)headers);
        }

        @Override
        public CombinedHttpHeadersImpl setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            for (CharSequence charSequence : headers.names()) {
                this.remove(charSequence);
            }
            return this.add(headers);
        }

        @Override
        public CombinedHttpHeadersImpl add(CharSequence name, CharSequence value) {
            return this.addEscapedValue(name, this.charSequenceEscaper().escape(name, value));
        }

        @Override
        public CombinedHttpHeadersImpl add(CharSequence name, CharSequence ... values) {
            return this.addEscapedValue(name, CombinedHttpHeadersImpl.commaSeparate(name, this.charSequenceEscaper(), values));
        }

        @Override
        public CombinedHttpHeadersImpl add(CharSequence name, Iterable<? extends CharSequence> values) {
            return this.addEscapedValue(name, CombinedHttpHeadersImpl.commaSeparate(name, this.charSequenceEscaper(), values));
        }

        @Override
        public CombinedHttpHeadersImpl addObject(CharSequence name, Object value) {
            return this.addEscapedValue(name, CombinedHttpHeadersImpl.commaSeparate(name, this.objectEscaper(), value));
        }

        @Override
        public CombinedHttpHeadersImpl addObject(CharSequence name, Iterable<?> values) {
            return this.addEscapedValue(name, CombinedHttpHeadersImpl.commaSeparate(name, this.objectEscaper(), values));
        }

        @Override
        public CombinedHttpHeadersImpl addObject(CharSequence name, Object ... values) {
            return this.addEscapedValue(name, CombinedHttpHeadersImpl.commaSeparate(name, this.objectEscaper(), values));
        }

        @Override
        public CombinedHttpHeadersImpl set(CharSequence name, CharSequence ... values) {
            this.set(name, CombinedHttpHeadersImpl.commaSeparate(name, this.charSequenceEscaper(), values));
            return this;
        }

        @Override
        public CombinedHttpHeadersImpl set(CharSequence name, Iterable<? extends CharSequence> values) {
            this.set(name, CombinedHttpHeadersImpl.commaSeparate(name, this.charSequenceEscaper(), values));
            return this;
        }

        @Override
        public CombinedHttpHeadersImpl setObject(CharSequence name, Object value) {
            this.set(name, CombinedHttpHeadersImpl.commaSeparate(name, this.objectEscaper(), value));
            return this;
        }

        @Override
        public CombinedHttpHeadersImpl setObject(CharSequence name, Object ... values) {
            this.set(name, CombinedHttpHeadersImpl.commaSeparate(name, this.objectEscaper(), values));
            return this;
        }

        @Override
        public CombinedHttpHeadersImpl setObject(CharSequence name, Iterable<?> values) {
            this.set(name, CombinedHttpHeadersImpl.commaSeparate(name, this.objectEscaper(), values));
            return this;
        }

        private static boolean cannotBeCombined(CharSequence name) {
            return HttpHeaderNames.SET_COOKIE.contentEqualsIgnoreCase(name);
        }

        private CombinedHttpHeadersImpl addEscapedValue(CharSequence name, CharSequence escapedValue) {
            CharSequence currentValue = (CharSequence)this.get(name);
            if (currentValue == null || CombinedHttpHeadersImpl.cannotBeCombined(name)) {
                super.add(name, escapedValue);
            } else {
                this.set(name, CombinedHttpHeadersImpl.commaSeparateEscapedValues(currentValue, escapedValue));
            }
            return this;
        }

        private static <T> CharSequence commaSeparate(CharSequence name, CsvValueEscaper<T> escaper, T ... values) {
            StringBuilder sb = new StringBuilder(values.length * 10);
            if (values.length > 0) {
                int end = values.length - 1;
                for (int i2 = 0; i2 < end; ++i2) {
                    sb.append(escaper.escape(name, values[i2])).append(',');
                }
                sb.append(escaper.escape(name, values[end]));
            }
            return sb;
        }

        private static <T> CharSequence commaSeparate(CharSequence name, CsvValueEscaper<T> escaper, Iterable<? extends T> values) {
            StringBuilder sb = values instanceof Collection ? new StringBuilder(((Collection)values).size() * 10) : new StringBuilder();
            Iterator<T> iterator2 = values.iterator();
            if (iterator2.hasNext()) {
                T next = iterator2.next();
                while (iterator2.hasNext()) {
                    sb.append(escaper.escape(name, next)).append(',');
                    next = iterator2.next();
                }
                sb.append(escaper.escape(name, next));
            }
            return sb;
        }

        private static CharSequence commaSeparateEscapedValues(CharSequence currentValue, CharSequence value) {
            return new StringBuilder(currentValue.length() + 1 + value.length()).append(currentValue).append(',').append(value);
        }

        private static interface CsvValueEscaper<T> {
            public CharSequence escape(CharSequence var1, T var2);
        }
    }
}


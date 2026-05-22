/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12;

import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;

public class StringReader_v1_12 {
    private final String s;
    private int index;

    public StringReader_v1_12(String s2) {
        this.s = s2;
    }

    public String getString() {
        return this.s;
    }

    public int getIndex() {
        return this.index;
    }

    public char read() {
        return this.s.charAt(this.index++);
    }

    public char charAt(int offset) {
        return this.s.charAt(this.index + offset);
    }

    public char peek() {
        return this.charAt(0);
    }

    public void skip() {
        ++this.index;
    }

    public boolean canRead() {
        return this.canRead(0);
    }

    public boolean canRead(int count) {
        return this.index + count < this.s.length();
    }

    public void skipWhitespaces() {
        while (this.canRead() && Character.isWhitespace(this.peek())) {
            ++this.index;
        }
    }

    public int readInt() throws SNbtDeserializeException {
        int start = this.index;
        while (this.canRead() && this.isNumerical(this.peek())) {
            ++this.index;
        }
        String number = this.s.substring(start, this.index);
        if (number.isEmpty()) {
            throw new SNbtDeserializeException("Expected double but got nothing", this.s, this.index);
        }
        try {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e2) {
            throw new SNbtDeserializeException("Expected double but got '" + number + "'", this.s, start);
        }
    }

    public double readDouble() throws SNbtDeserializeException {
        int start = this.index;
        while (this.canRead() && this.isNumerical(this.peek())) {
            ++this.index;
        }
        String number = this.s.substring(start, this.index);
        if (number.isEmpty()) {
            throw new SNbtDeserializeException("Expected double but got nothing", this.s, this.index);
        }
        try {
            return Double.parseDouble(number);
        }
        catch (NumberFormatException e2) {
            throw new SNbtDeserializeException("Expected double but got '" + number + "'", this.s, start);
        }
    }

    public String readString() throws SNbtDeserializeException {
        this.skipWhitespaces();
        if (!this.canRead()) {
            return null;
        }
        return this.isQuote(this.peek()) ? this.readQuotedString() : this.readUnquotedString();
    }

    public String readUnquotedString() {
        int start = this.index;
        while (this.canRead() && this.isAlphanumeric(this.peek())) {
            ++this.index;
        }
        return this.s.substring(start, this.index);
    }

    public String readQuotedString() throws SNbtDeserializeException {
        char quoteStart = this.read();
        int start = this.index;
        StringBuilder out = null;
        boolean escaped = false;
        while (this.canRead()) {
            char c2 = this.read();
            if (escaped) {
                if (c2 != '\\' && c2 != quoteStart) {
                    throw new SNbtDeserializeException("Invalid escape of '" + c2 + "'");
                }
                escaped = false;
            } else {
                if (c2 == '\\') {
                    escaped = true;
                    if (out != null) continue;
                    out = new StringBuilder(this.s.substring(start, this.index - 1));
                    continue;
                }
                if (c2 == quoteStart) {
                    return out == null ? this.s.substring(start, this.index - 1) : out.toString();
                }
            }
            if (out == null) continue;
            out.append(c2);
        }
        throw new SNbtDeserializeException("Missing termination quote", this.s, start - 1);
    }

    public void jumpTo(char wanted) throws SNbtDeserializeException {
        this.skipWhitespaces();
        boolean canRead = this.canRead();
        if (canRead && this.peek() == wanted) {
            ++this.index;
        } else {
            throw new SNbtDeserializeException("Expected '" + wanted + "' but got '" + (canRead ? Character.valueOf(this.peek()) : "<EOL>") + "'", this.s, this.index + 1);
        }
    }

    protected boolean isQuote(char c2) {
        return c2 == '\"';
    }

    private boolean isNumerical(char c2) {
        return c2 >= '0' && c2 <= '9' || c2 == '.' || c2 == '-';
    }

    private boolean isAlphanumeric(char c2) {
        return c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || c2 == '_' || c2 == '-' || c2 == '.' || c2 == '+';
    }
}


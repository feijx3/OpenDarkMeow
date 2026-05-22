/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat;

public class TextStringReader {
    private final String s;
    private int index;
    private int mark;

    public TextStringReader(String s2) {
        this.s = s2;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLength() {
        return this.s.length();
    }

    public TextStringReader mark() {
        this.mark = this.index;
        return this;
    }

    public TextStringReader reset() {
        this.index = this.mark;
        return this;
    }

    public String getMark() {
        return this.s.substring(this.mark, this.index);
    }

    public boolean canRead() {
        return this.canRead(1);
    }

    public boolean canRead(int count) {
        return this.index + count <= this.s.length();
    }

    public char peek() {
        this.verifyIndex(1);
        return this.s.charAt(this.index);
    }

    public String peek(int length) {
        this.verifyIndex(length);
        return this.s.substring(this.index, Math.min(this.index + length, this.s.length()));
    }

    public char peekAt(int offset) {
        this.verifyIndex(offset);
        return this.s.charAt(this.index + offset);
    }

    public TextStringReader skip() {
        this.verifyIndex(1);
        ++this.index;
        return this;
    }

    public TextStringReader skip(int count) {
        this.verifyIndex(count);
        this.index += count;
        return this;
    }

    public char read() {
        this.verifyIndex(1);
        return this.s.charAt(this.index++);
    }

    public String read(int length) {
        this.verifyIndex(length);
        String result = this.s.substring(this.index, Math.min(this.index + length, this.s.length()));
        this.index += length;
        return result;
    }

    public String readUntil(char c2) {
        char read;
        StringBuilder builder = new StringBuilder();
        while (this.canRead() && (read = this.peek()) != c2) {
            this.skip();
            builder.append(read);
        }
        return builder.toString();
    }

    private void verifyIndex(int offset) {
        if (!this.canRead(offset)) {
            throw new IndexOutOfBoundsException("Index " + (this.index + offset + 1) + " out of bounds for length " + this.s.length());
        }
    }
}


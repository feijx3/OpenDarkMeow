/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.util;

import com.twelvemonkeys.util.AbstractTokenIterator;
import java.util.NoSuchElementException;

public class StringTokenIterator
extends AbstractTokenIterator {
    private final String string;
    private final char[] delimiters;
    private int position;
    private final int maxPosition;
    private String next;
    private String nextDelimiter;
    private final boolean includeDelimiters;
    private final boolean includeEmpty;
    private final boolean reverse;
    public static final int FORWARD = 1;
    public static final int REVERSE = -1;
    private final char maxDelimiter;

    public StringTokenIterator(String string) {
        this(string, " \t\n\r\f".toCharArray(), 1, false, false);
    }

    public StringTokenIterator(String string, String string2) {
        this(string, StringTokenIterator.toCharArray(string2), 1, false, false);
    }

    public StringTokenIterator(String string, String string2, int n2) {
        this(string, StringTokenIterator.toCharArray(string2), n2, false, false);
    }

    public StringTokenIterator(String string, String string2, boolean bl2) {
        this(string, StringTokenIterator.toCharArray(string2), 1, bl2, false);
    }

    public StringTokenIterator(String string, String string2, int n2, boolean bl2, boolean bl3) {
        this(string, StringTokenIterator.toCharArray(string2), n2, bl2, bl3);
    }

    private StringTokenIterator(String string, char[] cArray, int n2, boolean bl2, boolean bl3) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        this.string = string;
        this.maxPosition = string.length();
        this.delimiters = cArray;
        this.includeDelimiters = bl2;
        this.reverse = n2 == -1;
        this.includeEmpty = bl3;
        this.maxDelimiter = StringTokenIterator.initMaxDelimiter(cArray);
        this.reset();
    }

    private static char[] toCharArray(String string) {
        if (string == null) {
            throw new IllegalArgumentException("delimiters == null");
        }
        return string.toCharArray();
    }

    private static char initMaxDelimiter(char[] cArray) {
        if (cArray == null) {
            return '\u0000';
        }
        char c2 = '\u0000';
        for (char c3 : cArray) {
            if (c2 >= c3) continue;
            c2 = c3;
        }
        return c2;
    }

    @Override
    public void reset() {
        this.position = 0;
        this.next = null;
        this.nextDelimiter = null;
    }

    @Override
    public boolean hasNext() {
        return this.next != null || this.fetchNext() != null;
    }

    private String fetchNext() {
        if (this.nextDelimiter != null) {
            this.next = this.nextDelimiter;
            this.nextDelimiter = null;
            return this.next;
        }
        if (this.position >= this.maxPosition) {
            return null;
        }
        return this.reverse ? this.fetchReverse() : this.fetchForward();
    }

    private String fetchReverse() {
        int n2 = this.scanForPrev();
        this.next = this.string.substring(n2 + 1, this.maxPosition - this.position);
        if (this.includeDelimiters && n2 >= 0 && n2 < this.maxPosition) {
            this.nextDelimiter = this.string.substring(n2, n2 + 1);
        }
        this.position = this.maxPosition - n2;
        if (this.next.length() == 0 && !this.includeEmpty) {
            return this.fetchNext();
        }
        return this.next;
    }

    private String fetchForward() {
        int n2 = this.scanForNext();
        this.next = this.string.substring(this.position, n2);
        if (this.includeDelimiters && n2 >= 0 && n2 < this.maxPosition) {
            this.nextDelimiter = this.string.substring(n2, n2 + 1);
        }
        this.position = ++n2;
        if (this.next.length() == 0 && !this.includeEmpty) {
            return this.fetchNext();
        }
        return this.next;
    }

    private int scanForNext() {
        int n2;
        for (n2 = this.position; n2 < this.maxPosition; ++n2) {
            char c2 = this.string.charAt(n2);
            if (c2 > this.maxDelimiter) continue;
            for (char c3 : this.delimiters) {
                if (c2 != c3) continue;
                return n2;
            }
        }
        return n2;
    }

    private int scanForPrev() {
        int n2;
        for (n2 = this.maxPosition - 1 - this.position; n2 >= 0; --n2) {
            char c2 = this.string.charAt(n2);
            if (c2 > this.maxDelimiter) continue;
            for (char c3 : this.delimiters) {
                if (c2 != c3) continue;
                return n2;
            }
        }
        return n2;
    }

    @Override
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        String string = this.next;
        this.next = this.fetchNext();
        return string;
    }
}


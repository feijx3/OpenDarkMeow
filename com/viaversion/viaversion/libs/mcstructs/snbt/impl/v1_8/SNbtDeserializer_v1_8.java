/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_8;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtDeserializer;
import java.util.Arrays;
import java.util.Stack;

public class SNbtDeserializer_v1_8
implements SNbtDeserializer<CompoundTag> {
    private static final String ARRAY_PATTERN = "\\[[-+\\d|,\\s]+]";
    private static final String BYTE_PATTERN = "[-+]?[0-9]+[b|B]";
    private static final String SHORT_PATTERN = "[-+]?[0-9]+[s|S]";
    private static final String INT_PATTERN = "[-+]?[0-9]+";
    private static final String LONG_PATTERN = "[-+]?[0-9]+[l|L]";
    private static final String FLOAT_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[f|F]";
    private static final String DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[d|D]";
    private static final String SHORT_DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+";

    @Override
    public CompoundTag deserialize(String s2) throws SNbtDeserializeException {
        if (!(s2 = s2.trim()).startsWith("{")) {
            throw new SNbtDeserializeException("Invalid tag encountered, expected '{' as first char.");
        }
        if (this.getTagCount(s2) != 1) {
            throw new SNbtDeserializeException("Encountered multiple top tags, only one expected");
        }
        return (CompoundTag)this.parseTag(s2);
    }

    @Override
    public Tag deserializeValue(String s2) throws SNbtDeserializeException {
        return this.parseTag(s2);
    }

    private Tag parseTag(String value) throws SNbtDeserializeException {
        if ((value = value.trim()).startsWith("{")) {
            value = value.substring(1, value.length() - 1);
            CompoundTag compound = new CompoundTag();
            while (value.length() > 0) {
                String pair = this.findPair(value, false);
                if (pair.length() > 0) {
                    String subName = this.find(pair, true, false);
                    String subValue = this.find(pair, false, false);
                    compound.put(subName, this.parseTag(subValue));
                }
                if (value.length() < pair.length() + 1) break;
                char nextChar = value.charAt(pair.length());
                if (nextChar != ',' && nextChar != '{' && nextChar != '}' && nextChar != '[' && nextChar != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + nextChar + "' at: " + value.substring(pair.length()));
                }
                value = value.substring(pair.length() + 1);
            }
            return compound;
        }
        if (value.startsWith("[") && !value.matches(ARRAY_PATTERN)) {
            value = value.substring(1, value.length() - 1);
            ListTag<Tag> list = new ListTag<Tag>();
            while (value.length() > 0) {
                String pair = this.findPair(value, true);
                if (pair.length() > 0) {
                    String subValue = this.find(pair, false, true);
                    try {
                        list.add(this.parseTag(subValue));
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        // empty catch block
                    }
                }
                if (value.length() < pair.length() + 1) break;
                char nextChar = value.charAt(pair.length());
                if (nextChar != ',' && nextChar != '{' && nextChar != '}' && nextChar != '[' && nextChar != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + nextChar + "' at: " + value.substring(pair.length()));
                }
                value = value.substring(pair.length() + 1);
            }
            return list;
        }
        return this.parsePrimitive(value);
    }

    private Tag parsePrimitive(String value) {
        try {
            if (value.matches(DOUBLE_PATTERN)) {
                return new DoubleTag(Double.parseDouble(value.substring(0, value.length() - 1)));
            }
            if (value.matches(FLOAT_PATTERN)) {
                return new FloatTag(Float.parseFloat(value.substring(0, value.length() - 1)));
            }
            if (value.matches(BYTE_PATTERN)) {
                return new ByteTag(Byte.parseByte(value.substring(0, value.length() - 1)));
            }
            if (value.matches(LONG_PATTERN)) {
                return new LongTag(Long.parseLong(value.substring(0, value.length() - 1)));
            }
            if (value.matches(SHORT_PATTERN)) {
                return new ShortTag(Short.parseShort(value.substring(0, value.length() - 1)));
            }
            if (value.matches(INT_PATTERN)) {
                return new IntTag(Integer.parseInt(value));
            }
            if (value.matches(SHORT_DOUBLE_PATTERN)) {
                return new DoubleTag(Double.parseDouble(value));
            }
            if (value.equalsIgnoreCase("false")) {
                return new ByteTag(0);
            }
            if (value.equalsIgnoreCase("true")) {
                return new ByteTag(1);
            }
        }
        catch (NumberFormatException e2) {
            return new StringTag(value.replace("\\\"", "\""));
        }
        if (value.startsWith("[") && value.endsWith("]")) {
            String arrayContent = value.substring(1, value.length() - 1);
            String[] parts = this.trimSplit(arrayContent);
            try {
                int[] ints = new int[parts.length];
                for (int i2 = 0; i2 < parts.length; ++i2) {
                    ints[i2] = Integer.parseInt(parts[i2].trim());
                }
                return new IntArrayTag(ints);
            }
            catch (NumberFormatException e3) {
                return new StringTag(value);
            }
        }
        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
        value = value.replace("\\\"", "\"");
        StringBuilder out = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i3 = 0; i3 < chars.length; ++i3) {
            char c2 = chars[i3];
            if (i3 < chars.length - 1 && c2 == '\\' && chars[i3 + 1] == '\\') {
                out.append("\\");
                ++i3;
                continue;
            }
            out.append(c2);
        }
        return new StringTag(out.toString());
    }

    private int getTagCount(String s2) throws SNbtDeserializeException {
        Stack<Character> brackets = new Stack<Character>();
        boolean quoted = false;
        int count = 0;
        char[] chars = s2.toCharArray();
        for (int i2 = 0; i2 < chars.length; ++i2) {
            char c2 = chars[i2];
            if (c2 == '\"') {
                if (this.isEscaped(s2, i2)) {
                    if (quoted) continue;
                    throw new SNbtDeserializeException("Illegal use of \\\": " + s2);
                }
                quoted = !quoted;
                continue;
            }
            if (quoted) continue;
            if (c2 == '{' || c2 == '[') {
                if (brackets.isEmpty()) {
                    ++count;
                }
                brackets.push(Character.valueOf(c2));
                continue;
            }
            this.checkBrackets(s2, c2, brackets);
        }
        if (quoted) {
            throw new SNbtDeserializeException("Unbalanced quotation: " + s2);
        }
        if (!brackets.isEmpty()) {
            throw new SNbtDeserializeException("Unbalanced brackets " + this.quotesToString(brackets) + ": " + s2);
        }
        if (count == 0 && !s2.isEmpty()) {
            return 1;
        }
        return count;
    }

    private String findPair(String s2, boolean isArray) throws SNbtDeserializeException {
        int i2;
        int separatorIndex = this.getCharIndex(s2, ':');
        if (separatorIndex == -1 && !isArray) {
            throw new SNbtDeserializeException("Unable to locate name/value separator for string: " + s2);
        }
        int pairSeparator = this.getCharIndex(s2, ',');
        if (pairSeparator != -1 && pairSeparator < separatorIndex && !isArray) {
            throw new SNbtDeserializeException("Name error at: " + s2);
        }
        if (isArray && (separatorIndex == -1 || separatorIndex > pairSeparator)) {
            separatorIndex = -1;
        }
        Stack<Character> brackets = new Stack<Character>();
        int quoteEnd = 0;
        boolean quoted = false;
        boolean hasContent = false;
        boolean isString = false;
        char[] chars = s2.toCharArray();
        for (i2 = separatorIndex + 1; i2 < chars.length; ++i2) {
            char c2 = chars[i2];
            if (c2 == '\"') {
                if (this.isEscaped(s2, i2)) {
                    if (!quoted) {
                        throw new SNbtDeserializeException("Illegal use of \\\": " + s2);
                    }
                } else {
                    boolean bl2 = quoted = !quoted;
                    if (quoted && !hasContent) {
                        isString = true;
                    }
                    if (!quoted) {
                        quoteEnd = i2;
                    }
                }
            } else if (!quoted) {
                if (c2 == '{' || c2 == '[') {
                    brackets.push(Character.valueOf(c2));
                } else {
                    this.checkBrackets(s2, c2, brackets);
                    if (c2 == ',' && brackets.isEmpty()) {
                        return s2.substring(0, i2);
                    }
                }
            }
            if (Character.isWhitespace(c2)) continue;
            if (!quoted && isString && quoteEnd != i2) {
                return s2.substring(0, quoteEnd + 1);
            }
            hasContent = true;
        }
        return s2.substring(0, i2);
    }

    private String find(String s2, boolean name, boolean isArray) throws SNbtDeserializeException {
        if (isArray && ((s2 = s2.trim()).startsWith("{") || s2.startsWith("["))) {
            if (name) {
                return "";
            }
            return s2;
        }
        int separatorIndex = this.getCharIndex(s2, ':');
        if (separatorIndex == -1) {
            if (isArray) {
                if (name) {
                    return "";
                }
                return s2;
            }
            throw new SNbtDeserializeException("Unable to locate name/value separator for string: " + s2);
        }
        if (name) {
            return s2.substring(0, separatorIndex).trim();
        }
        return s2.substring(separatorIndex + 1).trim();
    }

    private int getCharIndex(String s2, char wanted) {
        boolean quoted = true;
        char[] chars = s2.toCharArray();
        for (int i2 = 0; i2 < chars.length; ++i2) {
            char c2 = chars[i2];
            if (c2 == '\"') {
                if (this.isEscaped(s2, i2)) continue;
                quoted = !quoted;
                continue;
            }
            if (!quoted) continue;
            if (c2 == wanted) {
                return i2;
            }
            if (c2 != '{' && c2 != '[') continue;
            return -1;
        }
        return -1;
    }

    private String[] trimSplit(String s2) {
        String[] split = s2.split(",");
        String[] clean = new String[split.length];
        int index = 0;
        for (String value : split) {
            if (value.isEmpty()) continue;
            clean[index++] = value;
        }
        return Arrays.copyOfRange(clean, 0, index);
    }

    private boolean isEscaped(String s2, int index) {
        return index > 0 && s2.charAt(index - 1) == '\\' && !this.isEscaped(s2, index - 1);
    }

    private void checkBrackets(String s2, char close, Stack<Character> brackets) throws SNbtDeserializeException {
        if (close == '}' && (brackets.isEmpty() || brackets.pop().charValue() != '{')) {
            throw new SNbtDeserializeException("Unbalanced curly brackets {}: " + s2);
        }
        if (close == ']' && (brackets.isEmpty() || brackets.pop().charValue() != '[')) {
            throw new SNbtDeserializeException("Unbalanced square brackets []: " + s2);
        }
    }

    private String quotesToString(Stack<Character> quotes) {
        StringBuilder s2 = new StringBuilder();
        for (Character c2 : quotes) {
            s2.append(c2);
        }
        return s2.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_7;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.snbt.exceptions.SNbtDeserializeException;
import com.viaversion.viaversion.libs.mcstructs.snbt.impl.SNbtDeserializer;
import java.util.Stack;

public class SNbtDeserializer_v1_7
implements SNbtDeserializer<Tag> {
    private static final String ARRAY_PATTERN = "\\[[-\\d|,\\s]+]";
    private static final String BYTE_PATTERN = "[-+]?[0-9]+[b|B]";
    private static final String SHORT_PATTERN = "[-+]?[0-9]+[s|S]";
    private static final String INT_PATTERN = "[-+]?[0-9]+";
    private static final String LONG_PATTERN = "[-+]?[0-9]+[l|L]";
    private static final String FLOAT_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[f|F]";
    private static final String DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+[d|D]";
    private static final String SHORT_DOUBLE_PATTERN = "[-+]?[0-9]*\\.?[0-9]+";

    @Override
    public Tag deserialize(String s2) throws SNbtDeserializeException {
        int tagCount = this.getTagCount(s2 = s2.trim());
        if (tagCount != 1) {
            throw new SNbtDeserializeException("Encountered multiple top tags, only one expected");
        }
        Tag tag = s2.startsWith("{") ? this.parse("tag", s2) : this.parse(this.find(s2, true, false), this.find(s2, false, false));
        return tag;
    }

    @Override
    public Tag deserializeValue(String s2) throws SNbtDeserializeException {
        return this.parse("tag", s2);
    }

    private Tag parse(String name, String value) throws SNbtDeserializeException {
        value = value.trim();
        this.getTagCount(value);
        if (value.startsWith("{")) {
            if (!value.endsWith("}")) {
                throw new SNbtDeserializeException("Unable to locate ending bracket } for: " + value);
            }
            value = value.substring(1, value.length() - 1);
            CompoundTag compound = new CompoundTag();
            while (!value.isEmpty()) {
                String pair = this.findPair(value, false);
                if (pair.isEmpty()) continue;
                String subName = this.find(pair, true, false);
                String subValue = this.find(pair, false, false);
                compound.put(subName, this.parse(subName, subValue));
                if (value.length() < pair.length() + 1) break;
                char next = value.charAt(pair.length());
                if (next != ',' && next != '{' && next != '}' && next != '[' && next != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + name + "' at: " + value.substring(pair.length()));
                }
                value = value.substring(pair.length() + 1);
            }
            return compound;
        }
        if (value.startsWith("[") && !value.matches(ARRAY_PATTERN)) {
            if (!value.endsWith("]")) {
                throw new SNbtDeserializeException("Unable to locate ending bracket ] for: " + value);
            }
            value = value.substring(1, value.length() - 1);
            ListTag<Tag> list = new ListTag<Tag>();
            while (!value.isEmpty()) {
                String pair = this.findPair(value, true);
                if (pair.isEmpty()) continue;
                String subName = this.find(pair, true, true);
                String subValue = this.find(pair, false, true);
                try {
                    list.add(this.parse(subName, subValue));
                }
                catch (IllegalArgumentException next) {
                    // empty catch block
                }
                if (value.length() < pair.length() + 1) break;
                char next = value.charAt(pair.length());
                if (next != ',' && next != '{' && next != '}' && next != '[' && next != ']') {
                    throw new SNbtDeserializeException("Unexpected token '" + name + "' at: " + value.substring(pair.length()));
                }
                value = value.substring(pair.length() + 1);
            }
            return list;
        }
        return this.parsePrimitive(value);
    }

    /*
     * Exception decompiling
     */
    private Tag parsePrimitive(String value) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK], 0[TRYBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private int getTagCount(String s2) throws SNbtDeserializeException {
        Stack<Character> brackets = new Stack<Character>();
        boolean quoted = false;
        int count = 0;
        char[] chars = s2.toCharArray();
        for (int i2 = 0; i2 < chars.length; ++i2) {
            char c2 = chars[i2];
            if (c2 == '\"') {
                if (i2 > 0 && chars[i2 - 1] == '\\') {
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
        if (separatorIndex < 0 && !isArray) {
            throw new SNbtDeserializeException("Unable to locate name/value for string: " + s2);
        }
        int pairSeparator = this.getCharIndex(s2, ',');
        if (pairSeparator >= 0 && pairSeparator < separatorIndex && !isArray) {
            throw new SNbtDeserializeException("Name error at: " + s2);
        }
        if (isArray && (separatorIndex < 0 || separatorIndex > pairSeparator)) {
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
                if (i2 > 0 && chars[i2 - 1] == '\\') {
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
        int separatorIndex = s2.indexOf(":");
        if (separatorIndex < 0) {
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
        boolean quoted = false;
        char[] chars = s2.toCharArray();
        for (int i2 = 0; i2 < chars.length; ++i2) {
            char c2 = chars[i2];
            if (c2 == '\"') {
                if (i2 > 0 && chars[i2 - 1] == '\\') continue;
                quoted = !quoted;
                continue;
            }
            if (quoted) continue;
            if (c2 == wanted) {
                return i2;
            }
            if (c2 != '{' && c2 != '[') continue;
            return -1;
        }
        return -1;
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


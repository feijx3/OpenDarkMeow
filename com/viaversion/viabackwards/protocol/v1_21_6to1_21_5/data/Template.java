/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_U_S_Stream;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="segments", type=List.class), @RecordComponents.Value(name="variables", type=List.class)})
public final class Template
extends J_L_Record {
    private final List<String> segments;
    private final List<String> variables;
    private static final int MAX_LENGTH = 2000000;

    public Template(List<String> segments, List<String> variables) {
        this.segments = segments;
        this.variables = variables;
    }

    public static Template fromString(String string) {
        ImmutableList.Builder segmentsBuilder = ImmutableList.builder();
        ImmutableList.Builder variablesBuilder = ImmutableList.builder();
        int currentIndex = 0;
        int dollarIndex = string.indexOf(36);
        while (dollarIndex != -1) {
            if (dollarIndex != string.length() - 1 && string.charAt(dollarIndex + 1) == '(') {
                segmentsBuilder.add((Object)string.substring(currentIndex, dollarIndex));
                int closingParenIndex = string.indexOf(41, dollarIndex + 1);
                if (closingParenIndex == -1) {
                    throw new IllegalArgumentException("Unterminated macro variable");
                }
                String variableName = string.substring(dollarIndex + 2, closingParenIndex);
                if (!Template.isValidVariableName(variableName)) {
                    throw new IllegalArgumentException(Template.jvmdowngrader$concat$fromString$1(variableName));
                }
                variablesBuilder.add((Object)variableName);
                currentIndex = closingParenIndex + 1;
                dollarIndex = string.indexOf(36, currentIndex);
                continue;
            }
            dollarIndex = string.indexOf(36, dollarIndex + 1);
        }
        if (currentIndex == 0) {
            throw new IllegalArgumentException("No variables in macro");
        }
        if (currentIndex != string.length()) {
            segmentsBuilder.add((Object)string.substring(currentIndex));
        }
        return new Template((List<String>)segmentsBuilder.build(), (List<String>)variablesBuilder.build());
    }

    private static boolean isValidVariableName(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isLetterOrDigit(c2) || c2 == '_') continue;
            return false;
        }
        return true;
    }

    public String instantiate(Map<String, String> map) {
        return this.substitute(J_U_S_Stream.toList(this.variables().stream().map(string -> map.getOrDefault(string, ""))));
    }

    private String substitute(List<String> list) {
        StringBuilder out = new StringBuilder();
        for (int i2 = 0; i2 < this.variables.size(); ++i2) {
            out.append(this.segments.get(i2)).append(list.get(i2));
            if (out.length() <= 2000000) continue;
            throw new IllegalArgumentException("Output too long (> 2000000)");
        }
        if (this.segments.size() > this.variables.size()) {
            out.append(this.segments.get(this.segments.size() - 1));
            if (out.length() > 2000000) {
                throw new IllegalArgumentException("Output too long (> 2000000)");
            }
        }
        return out.toString();
    }

    @Override
    public final String toString() {
        return Template.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Template.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Template.jvmdowngrader$equals$equals(this, o2);
    }

    public List<String> segments() {
        return this.segments;
    }

    public List<String> variables() {
        return this.variables;
    }

    private static String jvmdowngrader$toString$toString(Template template) {
        Template template2 = template;
        return "Template[" + "segments=" + template.segments + ", " + "variables=" + template.variables + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Template template) {
        Object[] objectArray = new Object[]{template.segments, template.variables};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Template template, Object object) {
        if (template == object) {
            return true;
        }
        if (object != null && object instanceof Template) {
            Template template2 = (Template)object;
            if (Objects.equals(template.segments, template2.segments) && Objects.equals(template.variables, template2.variables)) {
                return true;
            }
        }
        return false;
    }

    private static String jvmdowngrader$concat$fromString$1(String string) {
        return "Invalid macro variable name '" + string + "'";
    }
}


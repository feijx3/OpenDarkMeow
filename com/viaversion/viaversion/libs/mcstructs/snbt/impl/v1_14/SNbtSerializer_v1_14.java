/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_14;

import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.SNbtSerializer_v1_12;

public class SNbtSerializer_v1_14
extends SNbtSerializer_v1_12 {
    @Override
    protected String escape(String s2) {
        char[] chars;
        StringBuilder out = new StringBuilder(" ");
        int openQuotation = 0;
        for (int n2 : chars = s2.toCharArray()) {
            if (n2 == 92) {
                out.append("\\");
            } else if (n2 == 34 || n2 == 39) {
                if (openQuotation == 0) {
                    openQuotation = n2 == 34 ? 39 : 34;
                }
                if (openQuotation == n2) {
                    out.append("\\");
                }
            }
            out.append((char)n2);
        }
        if (openQuotation == 0) {
            openQuotation = 34;
        }
        out.setCharAt(0, (char)openQuotation);
        out.append((char)openQuotation);
        return out.toString();
    }
}


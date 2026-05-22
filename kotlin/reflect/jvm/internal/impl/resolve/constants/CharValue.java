/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueConstant;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class CharValue
extends IntegerValueConstant<Character> {
    public CharValue(char value) {
        super(Character.valueOf(value));
    }

    @Override
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType simpleType = module.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getCharType(...)");
        return simpleType;
    }

    @Override
    @NotNull
    public String toString() {
        String string = "\\u%04X ('%s')";
        Object[] objectArray = new Object[]{(int)((Character)this.getValue()).charValue(), this.getPrintablePart(((Character)this.getValue()).charValue())};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        return string2;
    }

    private final String getPrintablePart(char c2) {
        String string;
        switch (c2) {
            case '\b': {
                string = "\\b";
                break;
            }
            case '\t': {
                string = "\\t";
                break;
            }
            case '\n': {
                string = "\\n";
                break;
            }
            case '\f': {
                string = "\\f";
                break;
            }
            case '\r': {
                string = "\\r";
                break;
            }
            default: {
                string = this.isPrintableUnicode(c2) ? String.valueOf(c2) : "?";
            }
        }
        return string;
    }

    private final boolean isPrintableUnicode(char c2) {
        byte t2 = (byte)Character.getType(c2);
        return t2 != 0 && t2 != 13 && t2 != 14 && t2 != 15 && t2 != 16 && t2 != 18 && t2 != 19;
    }
}


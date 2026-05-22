/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

public final class TypeVariance
extends Enum<TypeVariance> {
    @NotNull
    private final String presentation;
    public static final /* enum */ TypeVariance IN = new TypeVariance("in");
    public static final /* enum */ TypeVariance OUT = new TypeVariance("out");
    public static final /* enum */ TypeVariance INV = new TypeVariance("");
    private static final /* synthetic */ TypeVariance[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private TypeVariance(String presentation) {
        this.presentation = presentation;
    }

    @NotNull
    public String toString() {
        return this.presentation;
    }

    public static TypeVariance[] values() {
        return (TypeVariance[])$VALUES.clone();
    }

    public static TypeVariance valueOf(String value) {
        return Enum.valueOf(TypeVariance.class, value);
    }

    static {
        $VALUES = typeVarianceArray = new TypeVariance[]{TypeVariance.IN, TypeVariance.OUT, TypeVariance.INV};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}


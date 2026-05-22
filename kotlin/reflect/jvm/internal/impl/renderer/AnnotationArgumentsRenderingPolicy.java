/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AnnotationArgumentsRenderingPolicy
extends Enum<AnnotationArgumentsRenderingPolicy> {
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;
    public static final /* enum */ AnnotationArgumentsRenderingPolicy NO_ARGUMENTS = new AnnotationArgumentsRenderingPolicy("NO_ARGUMENTS", 0, false, false, 3, null);
    public static final /* enum */ AnnotationArgumentsRenderingPolicy UNLESS_EMPTY = new AnnotationArgumentsRenderingPolicy("UNLESS_EMPTY", 1, true, false, 2, null);
    public static final /* enum */ AnnotationArgumentsRenderingPolicy ALWAYS_PARENTHESIZED = new AnnotationArgumentsRenderingPolicy(true, true);
    private static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private AnnotationArgumentsRenderingPolicy(boolean includeAnnotationArguments, boolean includeEmptyAnnotationArguments) {
        this.includeAnnotationArguments = includeAnnotationArguments;
        this.includeEmptyAnnotationArguments = includeEmptyAnnotationArguments;
    }

    /* synthetic */ AnnotationArgumentsRenderingPolicy(String string, int n2, boolean bl2, boolean bl3, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            bl2 = false;
        }
        if ((n3 & 2) != 0) {
            bl3 = false;
        }
        this(bl2, bl3);
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    public static AnnotationArgumentsRenderingPolicy[] values() {
        return (AnnotationArgumentsRenderingPolicy[])$VALUES.clone();
    }

    public static AnnotationArgumentsRenderingPolicy valueOf(String value) {
        return Enum.valueOf(AnnotationArgumentsRenderingPolicy.class, value);
    }

    static {
        $VALUES = annotationArgumentsRenderingPolicyArray = new AnnotationArgumentsRenderingPolicy[]{AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS, AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY, AnnotationArgumentsRenderingPolicy.ALWAYS_PARENTHESIZED};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}


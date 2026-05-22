/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class ParameterNameRenderingPolicy
extends Enum<ParameterNameRenderingPolicy> {
    public static final /* enum */ ParameterNameRenderingPolicy ALL = new ParameterNameRenderingPolicy();
    public static final /* enum */ ParameterNameRenderingPolicy ONLY_NON_SYNTHESIZED = new ParameterNameRenderingPolicy();
    public static final /* enum */ ParameterNameRenderingPolicy NONE = new ParameterNameRenderingPolicy();
    private static final /* synthetic */ ParameterNameRenderingPolicy[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[])$VALUES.clone();
    }

    public static ParameterNameRenderingPolicy valueOf(String value) {
        return Enum.valueOf(ParameterNameRenderingPolicy.class, value);
    }

    static {
        $VALUES = parameterNameRenderingPolicyArray = new ParameterNameRenderingPolicy[]{ParameterNameRenderingPolicy.ALL, ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED, ParameterNameRenderingPolicy.NONE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}


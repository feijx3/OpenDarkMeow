/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class OverrideRenderingPolicy
extends Enum<OverrideRenderingPolicy> {
    public static final /* enum */ OverrideRenderingPolicy RENDER_OVERRIDE = new OverrideRenderingPolicy();
    public static final /* enum */ OverrideRenderingPolicy RENDER_OPEN = new OverrideRenderingPolicy();
    public static final /* enum */ OverrideRenderingPolicy RENDER_OPEN_OVERRIDE = new OverrideRenderingPolicy();
    private static final /* synthetic */ OverrideRenderingPolicy[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static OverrideRenderingPolicy[] values() {
        return (OverrideRenderingPolicy[])$VALUES.clone();
    }

    public static OverrideRenderingPolicy valueOf(String value) {
        return Enum.valueOf(OverrideRenderingPolicy.class, value);
    }

    static {
        $VALUES = overrideRenderingPolicyArray = new OverrideRenderingPolicy[]{OverrideRenderingPolicy.RENDER_OVERRIDE, OverrideRenderingPolicy.RENDER_OPEN, OverrideRenderingPolicy.RENDER_OPEN_OVERRIDE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}


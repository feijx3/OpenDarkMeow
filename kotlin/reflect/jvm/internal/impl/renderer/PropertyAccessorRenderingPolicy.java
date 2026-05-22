/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class PropertyAccessorRenderingPolicy
extends Enum<PropertyAccessorRenderingPolicy> {
    public static final /* enum */ PropertyAccessorRenderingPolicy PRETTY = new PropertyAccessorRenderingPolicy();
    public static final /* enum */ PropertyAccessorRenderingPolicy DEBUG = new PropertyAccessorRenderingPolicy();
    public static final /* enum */ PropertyAccessorRenderingPolicy NONE = new PropertyAccessorRenderingPolicy();
    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[])$VALUES.clone();
    }

    public static PropertyAccessorRenderingPolicy valueOf(String value) {
        return Enum.valueOf(PropertyAccessorRenderingPolicy.class, value);
    }

    static {
        $VALUES = propertyAccessorRenderingPolicyArray = new PropertyAccessorRenderingPolicy[]{PropertyAccessorRenderingPolicy.PRETTY, PropertyAccessorRenderingPolicy.DEBUG, PropertyAccessorRenderingPolicy.NONE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}


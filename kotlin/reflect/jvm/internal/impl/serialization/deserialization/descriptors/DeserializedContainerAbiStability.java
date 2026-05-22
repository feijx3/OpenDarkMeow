/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class DeserializedContainerAbiStability
extends Enum<DeserializedContainerAbiStability> {
    public static final /* enum */ DeserializedContainerAbiStability STABLE = new DeserializedContainerAbiStability();
    public static final /* enum */ DeserializedContainerAbiStability UNSTABLE = new DeserializedContainerAbiStability();
    private static final /* synthetic */ DeserializedContainerAbiStability[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[])$VALUES.clone();
    }

    public static DeserializedContainerAbiStability valueOf(String value) {
        return Enum.valueOf(DeserializedContainerAbiStability.class, value);
    }

    static {
        $VALUES = deserializedContainerAbiStabilityArray = new DeserializedContainerAbiStability[]{DeserializedContainerAbiStability.STABLE, DeserializedContainerAbiStability.UNSTABLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}


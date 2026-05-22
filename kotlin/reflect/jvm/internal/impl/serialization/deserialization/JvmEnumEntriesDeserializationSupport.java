/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport;
import org.jetbrains.annotations.NotNull;

public final class JvmEnumEntriesDeserializationSupport
implements EnumEntriesDeserializationSupport {
    @NotNull
    public static final JvmEnumEntriesDeserializationSupport INSTANCE = new JvmEnumEntriesDeserializationSupport();

    private JvmEnumEntriesDeserializationSupport() {
    }

    @Override
    @NotNull
    public Boolean canSynthesizeEnumEntries() {
        return true;
    }
}


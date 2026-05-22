/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface EnumEntriesDeserializationSupport {
    @Nullable
    public Boolean canSynthesizeEnumEntries();

    public static final class Default
    implements EnumEntriesDeserializationSupport {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override
        @Nullable
        public Boolean canSynthesizeEnumEntries() {
            return null;
        }
    }
}


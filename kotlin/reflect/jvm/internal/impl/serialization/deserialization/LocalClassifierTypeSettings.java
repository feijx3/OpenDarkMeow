/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LocalClassifierTypeSettings {
    @Nullable
    public SimpleType getReplacementTypeForLocalClassifiers();

    public static final class Default
    implements LocalClassifierTypeSettings {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override
        @Nullable
        public SimpleType getReplacementTypeForLocalClassifiers() {
            return null;
        }
    }
}


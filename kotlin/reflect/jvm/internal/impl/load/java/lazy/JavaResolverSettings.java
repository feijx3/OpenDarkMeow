/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;

public interface JavaResolverSettings {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings$Companion.$$INSTANCE;

    public boolean getCorrectNullabilityForNotNullTypeParameter();

    public boolean getTypeEnhancementImprovementsInStrictMode();

    public boolean getIgnoreNullabilityForErasedValueParameters();

    public boolean getEnhancePrimitiveArrays();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    public static final class Default
    implements JavaResolverSettings {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override
        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        @Override
        public boolean getTypeEnhancementImprovementsInStrictMode() {
            return false;
        }

        @Override
        public boolean getIgnoreNullabilityForErasedValueParameters() {
            return false;
        }

        @Override
        public boolean getEnhancePrimitiveArrays() {
            return false;
        }
    }
}


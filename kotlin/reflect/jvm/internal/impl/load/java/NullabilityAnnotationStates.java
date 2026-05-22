/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface NullabilityAnnotationStates<T> {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates$Companion.$$INSTANCE;

    @Nullable
    public T get(@NotNull FqName var1);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final NullabilityAnnotationStates EMPTY;

        private Companion() {
        }

        @NotNull
        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new NullabilityAnnotationStatesImpl(MapsKt.emptyMap());
        }
    }
}


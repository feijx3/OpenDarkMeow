/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import org.jetbrains.annotations.NotNull;

public interface NewKotlinTypeChecker
extends KotlinTypeChecker {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$Companion.$$INSTANCE;

    @NotNull
    public KotlinTypeRefiner getKotlinTypeRefiner();

    @NotNull
    public OverridingUtil getOverridingUtil();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final NewKotlinTypeCheckerImpl Default;

        private Companion() {
        }

        @NotNull
        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }

        static {
            $$INSTANCE = new Companion();
            Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, null, 2, null);
        }
    }
}


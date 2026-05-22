/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

public final class DefaultBuiltIns
extends KotlinBuiltIns {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<DefaultBuiltIns> Instance$delegate = LazyKt.lazy(DefaultBuiltIns$$Lambda$0.INSTANCE);

    public DefaultBuiltIns(boolean loadBuiltInsFromCurrentClassLoader) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (loadBuiltInsFromCurrentClassLoader) {
            this.createBuiltInsModule(false);
        }
    }

    public /* synthetic */ DefaultBuiltIns(boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        this(bl2);
    }

    private static final DefaultBuiltIns Instance_delegate$lambda$0() {
        return new DefaultBuiltIns(false, 1, null);
    }

    public DefaultBuiltIns() {
        this(false, 1, null);
    }

    static /* synthetic */ DefaultBuiltIns accessor$DefaultBuiltIns$lambda0() {
        return DefaultBuiltIns.Instance_delegate$lambda$0();
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DefaultBuiltIns getInstance() {
            Lazy lazy = Instance$delegate;
            return (DefaultBuiltIns)lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


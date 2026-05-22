/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class LazyScopeAdapter
extends AbstractScopeAdapter {
    @NotNull
    private final NotNullLazyValue<MemberScope> lazyScope;

    @JvmOverloads
    public LazyScopeAdapter(@NotNull StorageManager storageManager, @NotNull Function0<? extends MemberScope> getScope) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(getScope, "getScope");
        Function0<? extends MemberScope> function0 = getScope;
        this.lazyScope = storageManager.createLazyValue(new LazyScopeAdapter$$Lambda$0(function0));
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager storageManager, Function0 function0, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            StorageManager storageManager2 = LockBasedStorageManager.NO_LOCKS;
            Intrinsics.checkNotNullExpressionValue(storageManager2, "NO_LOCKS");
            storageManager = storageManager2;
        }
        this(storageManager, function0);
    }

    @Override
    @NotNull
    protected MemberScope getWorkerScope() {
        return (MemberScope)this.lazyScope.invoke();
    }

    @JvmOverloads
    public LazyScopeAdapter(@NotNull Function0<? extends MemberScope> getScope) {
        Intrinsics.checkNotNullParameter(getScope, "getScope");
        this(null, getScope, 1, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final MemberScope lazyScope$lambda$1(Function0 $getScope) {
        void var1_1;
        MemberScope it = (MemberScope)$getScope.invoke();
        boolean bl2 = false;
        return it instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter)it).getActualScope() : var1_1;
    }

    static /* synthetic */ MemberScope accessor$LazyScopeAdapter$lambda0(Function0 function0) {
        return LazyScopeAdapter.lazyScope$lambda$1(function0);
    }
}


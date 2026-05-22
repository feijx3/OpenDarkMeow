/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ScopesHolderForClass<T extends MemberScope> {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ClassDescriptor classDescriptor;
    @NotNull
    private final Function1<KotlinTypeRefiner, T> scopeFactory;
    @NotNull
    private final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    @NotNull
    private final NotNullLazyValue scopeForOwnerModule$delegate;

    private ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1<? super KotlinTypeRefiner, ? extends T> scopeFactory, KotlinTypeRefiner kotlinTypeRefinerForOwnerModule) {
        this.classDescriptor = classDescriptor;
        this.scopeFactory = scopeFactory;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefinerForOwnerModule;
        ScopesHolderForClass scopesHolderForClass = this;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new ScopesHolderForClass$$Lambda$0(scopesHolderForClass));
    }

    private final T getScopeForOwnerModule() {
        return (T)((MemberScope)StorageKt.getValue(this.scopeForOwnerModule$delegate, (Object)this, $$delegatedProperties[0]));
    }

    @NotNull
    public final T getScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor))) {
            return this.getScopeForOwnerModule();
        }
        TypeConstructor typeConstructor2 = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
        if (!kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor2)) {
            return this.getScopeForOwnerModule();
        }
        KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
        ScopesHolderForClass scopesHolderForClass = this;
        return (T)kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new ScopesHolderForClass$$Lambda$1(scopesHolderForClass, kotlinTypeRefiner2));
    }

    private static final MemberScope scopeForOwnerModule_delegate$lambda$0(ScopesHolderForClass this$0) {
        return (MemberScope)this$0.scopeFactory.invoke(this$0.kotlinTypeRefinerForOwnerModule);
    }

    private static final MemberScope getScope$lambda$1(ScopesHolderForClass this$0, KotlinTypeRefiner $kotlinTypeRefiner) {
        return (MemberScope)this$0.scopeFactory.invoke($kotlinTypeRefiner);
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 scopeFactory, KotlinTypeRefiner kotlinTypeRefinerForOwnerModule, DefaultConstructorMarker $constructor_marker) {
        this(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ScopesHolderForClass.class, "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
    }

    static /* synthetic */ MemberScope accessor$ScopesHolderForClass$lambda0(ScopesHolderForClass scopesHolderForClass) {
        return ScopesHolderForClass.scopeForOwnerModule_delegate$lambda$0(scopesHolderForClass);
    }

    static /* synthetic */ MemberScope accessor$ScopesHolderForClass$lambda1(ScopesHolderForClass scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
        return ScopesHolderForClass.getScope$lambda$1(scopesHolderForClass, kotlinTypeRefiner);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends MemberScope> ScopesHolderForClass<T> create(@NotNull ClassDescriptor classDescriptor, @NotNull StorageManager storageManager, @NotNull KotlinTypeRefiner kotlinTypeRefinerForOwnerModule, @NotNull Function1<? super KotlinTypeRefiner, ? extends T> scopeFactory) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(scopeFactory, "scopeFactory");
            return new ScopesHolderForClass(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


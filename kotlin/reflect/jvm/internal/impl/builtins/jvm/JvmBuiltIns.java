/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJvmBuiltIns.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltIns.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n*L\n1#1,103:1\n1#2:104\n19#3:105\n*S KotlinDebug\n*F\n+ 1 JvmBuiltIns.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns\n*L\n80#1:105\n*E\n"})
public final class JvmBuiltIns
extends KotlinBuiltIns {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Kind kind;
    @Nullable
    private Function0<Settings> settingsComputation;
    @NotNull
    private final NotNullLazyValue customizer$delegate;

    public JvmBuiltIns(@NotNull StorageManager storageManager, @NotNull Kind kind2) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter((Object)kind2, "kind");
        super(storageManager);
        this.kind = kind2;
        StorageManager storageManager2 = storageManager;
        JvmBuiltIns jvmBuiltIns = this;
        this.customizer$delegate = storageManager.createLazyValue(new JvmBuiltIns$$Lambda$0(jvmBuiltIns, storageManager2));
        switch (WhenMappings.$EnumSwitchMapping$0[this.kind.ordinal()]) {
            case 1: {
                break;
            }
            case 2: {
                this.createBuiltInsModule(false);
                break;
            }
            case 3: {
                this.createBuiltInsModule(true);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final void setPostponedSettingsComputation(@NotNull Function0<Settings> computation) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(computation, "computation");
        boolean bl3 = bl2 = this.settingsComputation == null;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "JvmBuiltins repeated initialization";
            throw new AssertionError((Object)string);
        }
        this.settingsComputation = computation;
    }

    public final void initialize(@NotNull ModuleDescriptor moduleDescriptor, boolean isAdditionalBuiltInsFeatureSupported) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        boolean bl2 = isAdditionalBuiltInsFeatureSupported;
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        this.setPostponedSettingsComputation(new JvmBuiltIns$$Lambda$1(moduleDescriptor2, bl2));
    }

    @NotNull
    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer)StorageKt.getValue(this.customizer$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.getCustomizer();
    }

    @Override
    @NotNull
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.getCustomizer();
    }

    @NotNull
    protected List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> iterable = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(iterable, "getClassDescriptorFactories(...)");
        StorageManager storageManager = this.getStorageManager();
        Intrinsics.checkNotNullExpressionValue(storageManager, "getStorageManager(...)");
        ModuleDescriptorImpl moduleDescriptorImpl = this.getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(moduleDescriptorImpl, "getBuiltInsModule(...)");
        return CollectionsKt.plus(iterable, new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptorImpl, null, 4, null));
    }

    private static final Settings initialize$lambda$1(ModuleDescriptor $moduleDescriptor, boolean $isAdditionalBuiltInsFeatureSupported) {
        return new Settings($moduleDescriptor, $isAdditionalBuiltInsFeatureSupported);
    }

    private static final Settings customizer_delegate$lambda$5$lambda$4(JvmBuiltIns this$0) {
        Settings settings;
        Function0<Settings> $this$sure$iv = this$0.settingsComputation;
        boolean $i$f$sure = false;
        Function0<Settings> function0 = $this$sure$iv;
        if (function0 == null) {
            boolean bl2 = false;
            String string = "JvmBuiltins instance has not been initialized properly";
            throw new AssertionError((Object)string);
        }
        Settings it = settings = function0.invoke();
        boolean bl3 = false;
        this$0.settingsComputation = null;
        return settings;
    }

    private static final JvmBuiltInsCustomizer customizer_delegate$lambda$5(JvmBuiltIns this$0, StorageManager $storageManager) {
        ModuleDescriptorImpl moduleDescriptorImpl = this$0.getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(moduleDescriptorImpl, "getBuiltInsModule(...)");
        JvmBuiltIns jvmBuiltIns = this$0;
        return new JvmBuiltInsCustomizer(moduleDescriptorImpl, $storageManager, new JvmBuiltIns$$Lambda$2(jvmBuiltIns));
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JvmBuiltIns.class, "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ JvmBuiltInsCustomizer accessor$JvmBuiltIns$lambda0(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        return JvmBuiltIns.customizer_delegate$lambda$5(jvmBuiltIns, storageManager);
    }

    static /* synthetic */ Settings accessor$JvmBuiltIns$lambda1(ModuleDescriptor moduleDescriptor, boolean bl2) {
        return JvmBuiltIns.initialize$lambda$1(moduleDescriptor, bl2);
    }

    static /* synthetic */ Settings accessor$JvmBuiltIns$lambda2(JvmBuiltIns jvmBuiltIns) {
        return JvmBuiltIns.customizer_delegate$lambda$5$lambda$4(jvmBuiltIns);
    }

    public static final class Kind
    extends Enum<Kind> {
        public static final /* enum */ Kind FROM_DEPENDENCIES = new Kind();
        public static final /* enum */ Kind FROM_CLASS_LOADER = new Kind();
        public static final /* enum */ Kind FALLBACK = new Kind();
        private static final /* synthetic */ Kind[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Kind[] values() {
            return (Kind[])$VALUES.clone();
        }

        public static Kind valueOf(String value) {
            return Enum.valueOf(Kind.class, value);
        }

        static {
            $VALUES = kindArray = new Kind[]{Kind.FROM_DEPENDENCIES, Kind.FROM_CLASS_LOADER, Kind.FALLBACK};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    public static final class Settings {
        @NotNull
        private final ModuleDescriptor ownerModuleDescriptor;
        private final boolean isAdditionalBuiltInsFeatureSupported;

        public Settings(@NotNull ModuleDescriptor ownerModuleDescriptor, boolean isAdditionalBuiltInsFeatureSupported) {
            Intrinsics.checkNotNullParameter(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = ownerModuleDescriptor;
            this.isAdditionalBuiltInsFeatureSupported = isAdditionalBuiltInsFeatureSupported;
        }

        @NotNull
        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Kind.values().length];
            try {
                nArray[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Kind.FALLBACK.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}


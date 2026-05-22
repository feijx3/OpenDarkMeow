/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nClassicBuiltinSpecialProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicBuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/ClassicBuiltinSpecialProperties\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1#2:37\n1761#3,3:38\n*S KotlinDebug\n*F\n+ 1 ClassicBuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/ClassicBuiltinSpecialProperties\n*L\n33#1:38,3\n*E\n"})
public final class ClassicBuiltinSpecialProperties {
    @NotNull
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    @Nullable
    public final String getBuiltinSpecialPropertyGetterName(@NotNull CallableMemberDescriptor $this$getBuiltinSpecialPropertyGetterName) {
        Intrinsics.checkNotNullParameter($this$getBuiltinSpecialPropertyGetterName, "<this>");
        boolean bl2 = KotlinBuiltIns.isBuiltIn($this$getBuiltinSpecialPropertyGetterName);
        if (_Assertions.ENABLED && !bl2) {
            boolean bl3 = false;
            String string = "This method is defined only for builtin members, but " + $this$getBuiltinSpecialPropertyGetterName + " found";
            throw new AssertionError((Object)string);
        }
        CallableMemberDescriptor callableMemberDescriptor = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor($this$getBuiltinSpecialPropertyGetterName), false, ClassicBuiltinSpecialProperties$$Lambda$0.INSTANCE, 1, null);
        if (callableMemberDescriptor == null) {
            return null;
        }
        CallableMemberDescriptor descriptor2 = callableMemberDescriptor;
        Name name = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(descriptor2));
        return name != null ? name.asString() : null;
    }

    public final boolean hasBuiltinSpecialPropertyFqName(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        if (!BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return false;
        }
        return this.hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor $this$hasBuiltinSpecialPropertyFqNameImpl) {
        boolean bl2;
        block5: {
            if (CollectionsKt.contains((Iterable)BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull($this$hasBuiltinSpecialPropertyFqNameImpl)) && $this$hasBuiltinSpecialPropertyFqNameImpl.getValueParameters().isEmpty()) {
                return true;
            }
            if (!KotlinBuiltIns.isBuiltIn($this$hasBuiltinSpecialPropertyFqNameImpl)) {
                return false;
            }
            Collection<? extends CallableMemberDescriptor> collection = $this$hasBuiltinSpecialPropertyFqNameImpl.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
            Iterable $this$any$iv = collection;
            boolean $i$f$any = false;
            if (((Collection)$this$any$iv).isEmpty()) {
                bl2 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    CallableMemberDescriptor it = (CallableMemberDescriptor)element$iv;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull(it);
                    if (!INSTANCE.hasBuiltinSpecialPropertyFqName(it)) continue;
                    bl2 = true;
                    break block5;
                }
                bl2 = false;
            }
        }
        return bl2;
    }

    private static final boolean getBuiltinSpecialPropertyGetterName$lambda$1(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.hasBuiltinSpecialPropertyFqName(it);
    }

    static /* synthetic */ boolean accessor$ClassicBuiltinSpecialProperties$lambda0(CallableMemberDescriptor callableMemberDescriptor) {
        return ClassicBuiltinSpecialProperties.getBuiltinSpecialPropertyGetterName$lambda$1(callableMemberDescriptor);
    }
}


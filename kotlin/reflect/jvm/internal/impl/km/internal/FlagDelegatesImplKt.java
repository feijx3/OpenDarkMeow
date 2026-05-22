/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.MemberKind;
import kotlin.reflect.jvm.internal.impl.km.Modality;
import kotlin.reflect.jvm.internal.impl.km.Visibility;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.EnumFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nFlagDelegatesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDelegatesImpl.kt\nkotlin/metadata/internal/FlagDelegatesImplKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1563#2:89\n1634#2,3:90\n1563#2:93\n1634#2,3:94\n1563#2:97\n1634#2,3:98\n*S KotlinDebug\n*F\n+ 1 FlagDelegatesImpl.kt\nkotlin/metadata/internal/FlagDelegatesImplKt\n*L\n50#1:89\n50#1:90,3\n53#1:93\n53#1:94,3\n56#1:97\n56#1:98,3\n*E\n"})
public final class FlagDelegatesImplKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <Node> EnumFlagDelegate<Node, Visibility> visibilityDelegate(@NotNull KMutableProperty1<Node, Integer> flags) {
        Collection<FlagImpl> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.Visibility> flagField = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(flagField, "VISIBILITY");
        Iterable iterable = Visibility.getEntries();
        EnumEntries<Visibility> enumEntries = Visibility.getEntries();
        Flags.FlagField<ProtoBuf.Visibility> flagField2 = flagField;
        KMutableProperty1<Node, Integer> kMutableProperty1 = flags;
        boolean $i$f$map = false;
        void var3_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Visibility visibility2 = (Visibility)((Object)item$iv$iv);
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.getFlag$kotlin_metadata());
        }
        Collection<FlagImpl> collection2 = collection = (List)destination$iv$iv;
        EnumEntries<Visibility> enumEntries2 = enumEntries;
        Flags.FlagField<ProtoBuf.Visibility> flagField3 = flagField2;
        KMutableProperty1<Node, Integer> kMutableProperty12 = kMutableProperty1;
        return new EnumFlagDelegate<Node, Visibility>(kMutableProperty12, (Flags.FlagField<Internal.EnumLite>)flagField3, enumEntries2, (List<FlagImpl>)collection2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <Node> EnumFlagDelegate<Node, Modality> modalityDelegate(@NotNull KMutableProperty1<Node, Integer> flags) {
        Collection<FlagImpl> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.Modality> flagField = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(flagField, "MODALITY");
        Iterable iterable = Modality.getEntries();
        EnumEntries<Modality> enumEntries = Modality.getEntries();
        Flags.FlagField<ProtoBuf.Modality> flagField2 = flagField;
        KMutableProperty1<Node, Integer> kMutableProperty1 = flags;
        boolean $i$f$map = false;
        void var3_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Modality modality2 = (Modality)((Object)item$iv$iv);
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.getFlag$kotlin_metadata());
        }
        Collection<FlagImpl> collection2 = collection = (List)destination$iv$iv;
        EnumEntries<Modality> enumEntries2 = enumEntries;
        Flags.FlagField<ProtoBuf.Modality> flagField3 = flagField2;
        KMutableProperty1<Node, Integer> kMutableProperty12 = kMutableProperty1;
        return new EnumFlagDelegate<Node, Modality>(kMutableProperty12, (Flags.FlagField<Internal.EnumLite>)flagField3, enumEntries2, (List<FlagImpl>)collection2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <Node> EnumFlagDelegate<Node, MemberKind> memberKindDelegate(@NotNull KMutableProperty1<Node, Integer> flags) {
        Collection<FlagImpl> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.MemberKind> flagField = Flags.MEMBER_KIND;
        Intrinsics.checkNotNullExpressionValue(flagField, "MEMBER_KIND");
        Iterable iterable = MemberKind.getEntries();
        EnumEntries<MemberKind> enumEntries = MemberKind.getEntries();
        Flags.FlagField<ProtoBuf.MemberKind> flagField2 = flagField;
        KMutableProperty1<Node, Integer> kMutableProperty1 = flags;
        boolean $i$f$map = false;
        void var3_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            MemberKind memberKind = (MemberKind)((Object)item$iv$iv);
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.getFlag$kotlin_metadata());
        }
        Collection<FlagImpl> collection2 = collection = (List)destination$iv$iv;
        EnumEntries<MemberKind> enumEntries2 = enumEntries;
        Flags.FlagField<ProtoBuf.MemberKind> flagField3 = flagField2;
        KMutableProperty1<Node, Integer> kMutableProperty12 = kMutableProperty1;
        return new EnumFlagDelegate<Node, MemberKind>(kMutableProperty12, (Flags.FlagField<Internal.EnumLite>)flagField3, enumEntries2, (List<FlagImpl>)collection2);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmClass> classBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmClass>(classBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmFunction> functionBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmFunction>(functionBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmConstructor> constructorBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmConstructor>(constructorBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmProperty> propertyBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmProperty>(propertyBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmPropertyAccessorAttributes> propertyAccessorBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmPropertyAccessorAttributes>(propertyAccessorBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmValueParameter> valueParameterBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmValueParameter>(valueParameterBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmTypeAlias> typeAliasBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmTypeAlias>(typeAliasBooleanFlag.1.INSTANCE, flag);
    }

    @NotNull
    public static final BooleanFlagDelegate<KmType> typeBooleanFlag(@NotNull FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<KmType>(typeBooleanFlag.1.INSTANCE, flag);
    }
}


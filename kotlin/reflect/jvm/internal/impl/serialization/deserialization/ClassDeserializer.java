/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nClassDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/ClassDeserializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1#2:92\n295#3,2:93\n*S KotlinDebug\n*F\n+ 1 ClassDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/ClassDeserializer\n*L\n57#1:93,2\n*E\n"})
public final class ClassDeserializer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final DeserializationComponents components;
    @NotNull
    private final Function1<ClassKey, ClassDescriptor> classes;
    @NotNull
    private static final Set<ClassId> BLACK_LIST = SetsKt.setOf(ClassId.Companion.topLevel(StandardNames.FqNames.cloneable.toSafe()));

    public ClassDeserializer(@NotNull DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
        ClassDeserializer classDeserializer = this;
        this.classes = this.components.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$$Lambda$0(classDeserializer));
    }

    @Nullable
    public final ClassDescriptor deserializeClass(@NotNull ClassId classId, @Nullable ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classData));
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int n2, Object object) {
        if ((n2 & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    private final ClassDescriptor createClass(ClassKey key) {
        DeserializationContext deserializationContext;
        ClassId classId = key.getClassId();
        for (ClassDescriptorFactory factory : this.components.getFictitiousClassDescriptorFactories()) {
            ClassDescriptor classDescriptor = factory.createClass(classId);
            if (classDescriptor == null) continue;
            ClassDescriptor it = classDescriptor;
            boolean bl2 = false;
            return it;
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        ClassData classData = key.getClassData();
        if (classData == null && (classData = this.components.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        ClassData classData2 = classData;
        NameResolver nameResolver = classData2.component1();
        ProtoBuf.Class classProto = classData2.component2();
        BinaryVersion metadataVersion = classData2.component3();
        SourceElement sourceElement = classData2.component4();
        ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            ClassDescriptor classDescriptor = ClassDeserializer.deserializeClass$default(this, outerClassId, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = classDescriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor)classDescriptor : null;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            DeserializedClassDescriptor outerClass = deserializedClassDescriptor;
            if (!outerClass.hasNestedClass$deserialization(classId.getShortClassName())) {
                return null;
            }
            deserializationContext = outerClass.getC();
        } else {
            Object v3;
            block9: {
                List<PackageFragmentDescriptor> fragments = PackageFragmentProviderKt.packageFragments(this.components.getPackageFragmentProvider(), classId.getPackageFqName());
                Iterable $this$firstOrNull$iv = fragments;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    PackageFragmentDescriptor it = (PackageFragmentDescriptor)element$iv;
                    boolean bl3 = false;
                    if (!(!(it instanceof DeserializedPackageFragment) || ((DeserializedPackageFragment)it).hasTopLevelClass(classId.getShortClassName()))) continue;
                    v3 = element$iv;
                    break block9;
                }
                v3 = null;
            }
            PackageFragmentDescriptor packageFragmentDescriptor = v3;
            if (packageFragmentDescriptor == null) {
                return null;
            }
            PackageFragmentDescriptor fragment = packageFragmentDescriptor;
            ProtoBuf.TypeTable typeTable = classProto.getTypeTable();
            Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
            TypeTable typeTable2 = new TypeTable(typeTable);
            ProtoBuf.VersionRequirementTable versionRequirementTable = classProto.getVersionRequirementTable();
            Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
            deserializationContext = this.components.createContext(fragment, nameResolver, typeTable2, VersionRequirementTable.Companion.create(versionRequirementTable), metadataVersion, null);
        }
        DeserializationContext outerContext = deserializationContext;
        return new DeserializedClassDescriptor(outerContext, classProto, nameResolver, metadataVersion, sourceElement);
    }

    private static final ClassDescriptor classes$lambda$0(ClassDeserializer this$0, ClassKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this$0.createClass(key);
    }

    static /* synthetic */ ClassDescriptor accessor$ClassDeserializer$lambda0(ClassDeserializer classDeserializer, ClassKey classKey) {
        return ClassDeserializer.classes$lambda$0(classDeserializer, classKey);
    }

    private static final class ClassKey {
        @NotNull
        private final ClassId classId;
        @Nullable
        private final ClassData classData;

        public ClassKey(@NotNull ClassId classId, @Nullable ClassData classData) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.classData = classData;
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        @Nullable
        public final ClassData getClassData() {
            return this.classData;
        }

        public boolean equals(@Nullable Object other) {
            return other instanceof ClassKey && Intrinsics.areEqual(this.classId, ((ClassKey)other).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Set<ClassId> getBLACK_LIST() {
            return BLACK_LIST;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


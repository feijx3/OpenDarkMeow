/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadContext;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteContext;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.WritersKt;
import kotlin.reflect.jvm.internal.impl.km.internal.common.KmModuleFragment;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmModuleFragmentExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignatureKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJvmMetadataExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmMetadataExtensions.kt\nkotlin/metadata/jvm/internal/JvmMetadataExtensions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,301:1\n1634#2,3:302\n1634#2,3:306\n1634#2,3:309\n1634#2,3:312\n1634#2,3:315\n1634#2,3:318\n1634#2,3:321\n1634#2,3:324\n1634#2,3:327\n1634#2,3:330\n1634#2,3:333\n1563#2:336\n1634#2,3:337\n1869#2,2:340\n1869#2,2:342\n1563#2:344\n1634#2,3:345\n1563#2:348\n1634#2,3:349\n1563#2:352\n1634#2,3:353\n1563#2:356\n1634#2,3:357\n1563#2:360\n1634#2,3:361\n1563#2:364\n1634#2,3:365\n1563#2:368\n1634#2,3:369\n1563#2:372\n1634#2,3:373\n1563#2:376\n1634#2,3:377\n1869#2,2:380\n1869#2,2:382\n1869#2,2:384\n1563#2:386\n1634#2,3:387\n1#3:305\n*S KotlinDebug\n*F\n+ 1 JvmMetadataExtensions.kt\nkotlin/metadata/jvm/internal/JvmMetadataExtensions\n*L\n25#1:302,3\n58#1:306,3\n59#1:309,3\n71#1:312,3\n72#1:315,3\n74#1:318,3\n76#1:321,3\n77#1:324,3\n78#1:327,3\n102#1:330,3\n130#1:333,3\n135#1:336\n135#1:337,3\n139#1:340,2\n151#1:342,2\n172#1:344\n172#1:345,3\n174#1:348\n174#1:349,3\n184#1:352\n184#1:353,3\n185#1:356\n185#1:357,3\n187#1:360\n187#1:361,3\n190#1:364\n190#1:365,3\n192#1:368\n192#1:369,3\n193#1:372\n193#1:373,3\n230#1:376\n230#1:377,3\n237#1:380,2\n243#1:382,2\n251#1:384,2\n267#1:386\n267#1:387,3\n*E\n"})
public final class JvmMetadataExtensions
implements MetadataExtensions {
    /*
     * WARNING - void declaration
     */
    @Override
    public void readClassExtensions(@NotNull KmClass kmClass, @NotNull ProtoBuf.Class proto, @NotNull ReadContext c2) {
        block8: {
            Object object;
            Object object2;
            JvmClassExtension ext;
            block7: {
                block6: {
                    void p0;
                    Object object3;
                    void $this$mapTo$iv;
                    Intrinsics.checkNotNullParameter(kmClass, "kmClass");
                    Intrinsics.checkNotNullParameter(proto, "proto");
                    Intrinsics.checkNotNullParameter(c2, "c");
                    ext = JvmExtensionNodesKt.getJvm(kmClass);
                    List<ProtoBuf.Annotation> list = proto.getAnnotationList();
                    Intrinsics.checkNotNullExpressionValue(list, "getAnnotationList(...)");
                    Iterable iterable = list;
                    Collection destination$iv = kmClass.getAnnotations();
                    boolean $i$f$mapTo = false;
                    for (Object item$iv : $this$mapTo$iv) {
                        void it;
                        ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv;
                        object3 = destination$iv;
                        boolean bl2 = false;
                        Intrinsics.checkNotNull(it);
                        object3.add(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation)it, c2.getStrings()));
                    }
                    GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
                    GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> generatedExtension = JvmProtoBuf.anonymousObjectOriginName;
                    Intrinsics.checkNotNullExpressionValue(generatedExtension, "anonymousObjectOriginName");
                    Integer anonymousObjectOriginName = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
                    if (anonymousObjectOriginName != null) {
                        ext.setAnonymousObjectOriginName(c2.get(anonymousObjectOriginName));
                    }
                    for (ProtoBuf.Property property : proto.getExtension(JvmProtoBuf.classLocalVariable)) {
                        List<KmProperty> list2 = ext.getLocalDelegatedProperties();
                        Intrinsics.checkNotNull(property);
                        list2.add(ReadersKt.toKmProperty(property, c2));
                    }
                    object2 = ext;
                    GeneratedMessageLite.ExtendableMessage extendableMessage2 = proto;
                    GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> generatedExtension2 = JvmProtoBuf.classModuleName;
                    Intrinsics.checkNotNullExpressionValue(generatedExtension2, "classModuleName");
                    object = ProtoBufUtilKt.getExtensionOrNull(extendableMessage2, generatedExtension2);
                    if (object == null) break block6;
                    int item$iv = ((Number)object).intValue();
                    object3 = object2;
                    boolean bl3 = false;
                    String string = c2.get((int)p0);
                    object2 = object3;
                    object = string;
                    if (string != null) break block7;
                }
                object = "main";
            }
            ((JvmClassExtension)object2).setModuleName((String)object);
            GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> generatedExtension = JvmProtoBuf.jvmClassFlags;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "jvmClassFlags");
            Integer n2 = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
            if (n2 == null) break block8;
            int it = ((Number)n2).intValue();
            boolean bl4 = false;
            ext.setJvmFlags(it);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void readPackageExtensions(@NotNull KmPackage kmPackage, @NotNull ProtoBuf.Package proto, @NotNull ReadContext c2) {
        Object object;
        JvmPackageExtension jvmPackageExtension;
        block4: {
            block3: {
                void p0;
                Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
                Intrinsics.checkNotNullParameter(proto, "proto");
                Intrinsics.checkNotNullParameter(c2, "c");
                JvmPackageExtension ext = JvmExtensionNodesKt.getJvm(kmPackage);
                for (ProtoBuf.Property property : proto.getExtension(JvmProtoBuf.packageLocalVariable)) {
                    List<KmProperty> list = ext.getLocalDelegatedProperties();
                    Intrinsics.checkNotNull(property);
                    list.add(ReadersKt.toKmProperty(property, c2));
                }
                jvmPackageExtension = ext;
                GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
                GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension = JvmProtoBuf.packageModuleName;
                Intrinsics.checkNotNullExpressionValue(generatedExtension, "packageModuleName");
                object = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
                if (object == null) break block3;
                int n2 = ((Number)object).intValue();
                JvmPackageExtension jvmPackageExtension2 = jvmPackageExtension;
                boolean bl2 = false;
                String string = c2.get((int)p0);
                jvmPackageExtension = jvmPackageExtension2;
                object = string;
                if (string != null) break block4;
            }
            object = "main";
        }
        jvmPackageExtension.setModuleName((String)object);
    }

    public void readModuleFragmentExtensions(@NotNull KmModuleFragment kmModuleFragment, @NotNull ProtoBuf.PackageFragment proto, @NotNull ReadContext c2) {
        Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
    }

    @Override
    public void readFunctionExtensions(@NotNull KmFunction kmFunction, @NotNull ProtoBuf.Function proto, @NotNull ReadContext c2) {
        ProtoBuf.Annotation it;
        Collection collection;
        Iterable $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmFunctionExtension ext = JvmExtensionNodesKt.getJvm(kmFunction);
        List<ProtoBuf.Annotation> list = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list, "getAnnotationList(...)");
        Iterable iterable = list;
        Collection destination$iv = kmFunction.getAnnotations();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv;
            collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        List<ProtoBuf.Annotation> list2 = proto.getExtensionReceiverAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list2, "getExtensionReceiverAnnotationList(...)");
        $this$mapTo$iv = list2;
        destination$iv = kmFunction.getExtensionReceiverParameterAnnotations();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Annotation)item$iv;
            collection = destination$iv;
            boolean bl3 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        JvmMemberSignature.Method method = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature(proto, c2.getStrings(), c2.getTypes());
        ext.setSignature(method != null ? JvmMemberSignatureKt.wrapAsPublic(method) : null);
        GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> generatedExtension = JvmProtoBuf.lambdaClassOriginName;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "lambdaClassOriginName");
        Integer lambdaClassOriginName = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
        if (lambdaClassOriginName != null) {
            ext.setLambdaClassOriginName(c2.get(lambdaClassOriginName));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void readPropertyExtensions(@NotNull KmProperty kmProperty, @NotNull ProtoBuf.Property proto, @NotNull ReadContext c2) {
        JvmMethodSignature jvmMethodSignature;
        JvmMethodSignature jvmMethodSignature2;
        JvmMethodSignature jvmMethodSignature3;
        JvmMethodSignature jvmMethodSignature4;
        JvmProtoBuf.JvmMethodSignature $this$readPropertyExtensions_u24lambda_u2412;
        Object destination$iv;
        GeneratedMessageLite it;
        Object object;
        Iterable $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmPropertyExtension ext = JvmExtensionNodesKt.getJvm(kmProperty);
        List<ProtoBuf.Annotation> list = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list, "getAnnotationList(...)");
        Iterable iterable = list;
        Collection destination$iv2 = kmProperty.getAnnotations();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv;
            object = destination$iv2;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            object.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        List<ProtoBuf.Annotation> list2 = proto.getGetterAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list2, "getGetterAnnotationList(...)");
        $this$mapTo$iv = list2;
        destination$iv2 = kmProperty.getGetter().getAnnotations();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Annotation)item$iv;
            object = destination$iv2;
            boolean bl3 = false;
            Intrinsics.checkNotNull(it);
            object.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = kmProperty.getSetter();
        if (kmPropertyAccessorAttributes != null) {
            void $this$mapTo$iv2;
            Object item$iv;
            KmPropertyAccessorAttributes setter = kmPropertyAccessorAttributes;
            boolean bl4 = false;
            List<ProtoBuf.Annotation> list3 = proto.getSetterAnnotationList();
            Intrinsics.checkNotNullExpressionValue(list3, "getSetterAnnotationList(...)");
            item$iv = list3;
            destination$iv = setter.getAnnotations();
            boolean $i$f$mapTo2 = false;
            for (Object item$iv2 : $this$mapTo$iv2) {
                void it2;
                ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv2;
                Collection collection = destination$iv;
                boolean bl5 = false;
                Intrinsics.checkNotNull(it2);
                collection.add(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation)it2, c2.getStrings()));
            }
            List cfr_ignored_0 = (List)destination$iv;
        }
        List<ProtoBuf.Annotation> list4 = proto.getExtensionReceiverAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list4, "getExtensionReceiverAnnotationList(...)");
        $this$mapTo$iv = list4;
        destination$iv2 = kmProperty.getExtensionReceiverParameterAnnotations();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            destination$iv = (ProtoBuf.Annotation)item$iv;
            object = destination$iv2;
            boolean bl6 = false;
            Intrinsics.checkNotNull(it);
            object.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        List<ProtoBuf.Annotation> list5 = proto.getBackingFieldAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list5, "getBackingFieldAnnotationList(...)");
        $this$mapTo$iv = list5;
        destination$iv2 = kmProperty.getBackingFieldAnnotations();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Annotation)item$iv;
            object = destination$iv2;
            boolean bl7 = false;
            Intrinsics.checkNotNull(it);
            object.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        List<ProtoBuf.Annotation> list6 = proto.getDelegateFieldAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list6, "getDelegateFieldAnnotationList(...)");
        $this$mapTo$iv = list6;
        destination$iv2 = kmProperty.getDelegateFieldAnnotations();
        $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            it = (ProtoBuf.Annotation)item$iv;
            object = destination$iv2;
            boolean bl8 = false;
            Intrinsics.checkNotNull(it);
            object.add(ReadUtilsKt.readAnnotation(it, c2.getStrings()));
        }
        JvmMemberSignature.Field fieldSignature = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, proto, c2.getStrings(), c2.getTypes(), false, 8, null);
        GeneratedMessageLite.ExtendableMessage extendableMessage = proto;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "propertySignature");
        JvmProtoBuf.JvmPropertySignature propertySignature = ProtoBufUtilKt.getExtensionOrNull(extendableMessage, generatedExtension);
        JvmProtoBuf.JvmMethodSignature getterSignature = propertySignature != null && propertySignature.hasGetter() ? propertySignature.getGetter() : null;
        JvmProtoBuf.JvmMethodSignature setterSignature = propertySignature != null && propertySignature.hasSetter() ? propertySignature.getSetter() : null;
        Integer n2 = proto.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(n2, "getExtension(...)");
        ext.setJvmFlags(((Number)n2).intValue());
        JvmMemberSignature.Field field = fieldSignature;
        ext.setFieldSignature(field != null ? JvmMemberSignatureKt.wrapAsPublic(field) : null);
        Object object2 = ext;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature5 = getterSignature;
        if (jvmMethodSignature5 != null) {
            it = jvmMethodSignature5;
            object = object2;
            boolean bl9 = false;
            jvmMethodSignature4 = new JvmMethodSignature(c2.get($this$readPropertyExtensions_u24lambda_u2412.getName()), c2.get($this$readPropertyExtensions_u24lambda_u2412.getDesc()));
            object2 = object;
        } else {
            jvmMethodSignature4 = null;
        }
        ((JvmPropertyExtension)object2).setGetterSignature(jvmMethodSignature4);
        Object object3 = ext;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature6 = setterSignature;
        if (jvmMethodSignature6 != null) {
            void $this$readPropertyExtensions_u24lambda_u2413;
            $this$readPropertyExtensions_u24lambda_u2412 = jvmMethodSignature6;
            object = object3;
            boolean bl10 = false;
            jvmMethodSignature3 = new JvmMethodSignature(c2.get($this$readPropertyExtensions_u24lambda_u2413.getName()), c2.get($this$readPropertyExtensions_u24lambda_u2413.getDesc()));
            object3 = object;
        } else {
            jvmMethodSignature3 = null;
        }
        ((JvmPropertyExtension)object3).setSetterSignature(jvmMethodSignature3);
        JvmProtoBuf.JvmMethodSignature syntheticMethod = propertySignature != null && propertySignature.hasSyntheticMethod() ? propertySignature.getSyntheticMethod() : null;
        Object object4 = ext;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature7 = syntheticMethod;
        if (jvmMethodSignature7 != null) {
            void $this$readPropertyExtensions_u24lambda_u2414;
            JvmProtoBuf.JvmMethodSignature bl10 = jvmMethodSignature7;
            object = object4;
            boolean bl11 = false;
            jvmMethodSignature2 = new JvmMethodSignature(c2.get($this$readPropertyExtensions_u24lambda_u2414.getName()), c2.get($this$readPropertyExtensions_u24lambda_u2414.getDesc()));
            object4 = object;
        } else {
            jvmMethodSignature2 = null;
        }
        ((JvmPropertyExtension)object4).setSyntheticMethodForAnnotations(jvmMethodSignature2);
        JvmProtoBuf.JvmMethodSignature delegateMethod = propertySignature != null && propertySignature.hasDelegateMethod() ? propertySignature.getDelegateMethod() : null;
        Object object5 = ext;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature8 = delegateMethod;
        if (jvmMethodSignature8 != null) {
            void $this$readPropertyExtensions_u24lambda_u2415;
            JvmProtoBuf.JvmMethodSignature bl11 = jvmMethodSignature8;
            object = object5;
            boolean bl12 = false;
            jvmMethodSignature = new JvmMethodSignature(c2.get($this$readPropertyExtensions_u24lambda_u2415.getName()), c2.get($this$readPropertyExtensions_u24lambda_u2415.getDesc()));
            object5 = object;
        } else {
            jvmMethodSignature = null;
        }
        ((JvmPropertyExtension)object5).setSyntheticMethodForDelegate(jvmMethodSignature);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void readConstructorExtensions(@NotNull KmConstructor kmConstructor, @NotNull ProtoBuf.Constructor proto, @NotNull ReadContext c2) {
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmConstructorExtension ext = JvmExtensionNodesKt.getJvm(kmConstructor);
        List<ProtoBuf.Annotation> list = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list, "getAnnotationList(...)");
        Iterable iterable = list;
        Collection destination$iv = kmConstructor.getAnnotations();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation)it, c2.getStrings()));
        }
        JvmMemberSignature.Method method = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature(proto, c2.getStrings(), c2.getTypes());
        ext.setSignature(method != null ? JvmMemberSignatureKt.wrapAsPublic(method) : null);
    }

    @Override
    public void readTypeParameterExtensions(@NotNull KmTypeParameter kmTypeParameter, @NotNull ProtoBuf.TypeParameter proto, @NotNull ReadContext c2) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmTypeParameterExtension ext = JvmExtensionNodesKt.getJvm(kmTypeParameter);
        for (ProtoBuf.Annotation annotation : proto.getExtension(JvmProtoBuf.typeParameterAnnotation)) {
            List<KmAnnotation> list = ext.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            list.add(ReadUtilsKt.readAnnotation(annotation, c2.getStrings()));
        }
    }

    @Override
    public void readEnumEntryExtensions(@NotNull KmEnumEntry kmEnumEntry, @NotNull ProtoBuf.EnumEntry proto, @NotNull ReadContext c2) {
        Intrinsics.checkNotNullParameter(kmEnumEntry, "kmEnumEntry");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        for (ProtoBuf.Annotation annotation : proto.getAnnotationList()) {
            List<KmAnnotation> list = kmEnumEntry.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            list.add(ReadUtilsKt.readAnnotation(annotation, c2.getStrings()));
        }
    }

    @Override
    public void readTypeExtensions(@NotNull KmType kmType, @NotNull ProtoBuf.Type proto, @NotNull ReadContext c2) {
        Intrinsics.checkNotNullParameter(kmType, "kmType");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmTypeExtension ext = JvmExtensionNodesKt.getJvm(kmType);
        Boolean bl2 = proto.getExtension(JvmProtoBuf.isRaw);
        Intrinsics.checkNotNullExpressionValue(bl2, "getExtension(...)");
        ext.setRaw(bl2);
        for (ProtoBuf.Annotation annotation : proto.getExtension(JvmProtoBuf.typeAnnotation)) {
            List<KmAnnotation> list = ext.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            list.add(ReadUtilsKt.readAnnotation(annotation, c2.getStrings()));
        }
    }

    @Override
    public void readTypeAliasExtensions(@NotNull KmTypeAlias kmTypeAlias, @NotNull ProtoBuf.TypeAlias proto, @NotNull ReadContext c2) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "kmTypeAlias");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void readValueParameterExtensions(@NotNull KmValueParameter kmValueParameter, @NotNull ProtoBuf.ValueParameter proto, @NotNull ReadContext c2) {
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(kmValueParameter, "kmValueParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        List<ProtoBuf.Annotation> list = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(list, "getAnnotationList(...)");
        Iterable iterable = list;
        Collection destination$iv = kmValueParameter.getAnnotations();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(ReadUtilsKt.readAnnotation((ProtoBuf.Annotation)it, c2.getStrings()));
        }
    }

    /*
     * WARNING - void declaration
     */
    public void writeClassExtensions(@NotNull KmClass kmClass, @NotNull ProtoBuf.Class.Builder proto, @NotNull WriteContext c2) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmClassExtension $this$writeClassExtensions_u24lambda_u2422 = JvmExtensionNodesKt.getJvm(kmClass);
        boolean bl2 = false;
        Iterable iterable = kmClass.getAnnotations();
        ProtoBuf.Class.Builder builder = proto;
        boolean $i$f$map = false;
        void var9_9 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            KmAnnotation kmAnnotation = (KmAnnotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(WriteUtilsKt.writeAnnotation((KmAnnotation)it, c2.getStrings()).build());
        }
        builder.addAllAnnotation((List)destination$iv$iv);
        String string = $this$writeClassExtensions_u24lambda_u2422.getAnonymousObjectOriginName();
        if (string != null) {
            String it = string;
            boolean bl4 = false;
            ProtoBuf.Class.Builder cfr_ignored_0 = (ProtoBuf.Class.Builder)proto.setExtension(JvmProtoBuf.anonymousObjectOriginName, c2.get(it));
        }
        Iterable $this$forEach$iv = $this$writeClassExtensions_u24lambda_u2422.getLocalDelegatedProperties();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmProperty it = (KmProperty)element$iv;
            boolean bl5 = false;
            proto.addExtension(JvmProtoBuf.classLocalVariable, WritersKt.writeProperty(c2, it).build());
        }
        String string2 = $this$writeClassExtensions_u24lambda_u2422.getModuleName();
        if (string2 != null) {
            String moduleName = string2;
            boolean bl6 = false;
            if (!Intrinsics.areEqual(moduleName, "main")) {
                proto.setExtension(JvmProtoBuf.classModuleName, c2.get(moduleName));
            }
        }
        if ($this$writeClassExtensions_u24lambda_u2422.getJvmFlags() != 0) {
            proto.setExtension(JvmProtoBuf.jvmClassFlags, $this$writeClassExtensions_u24lambda_u2422.getJvmFlags());
        }
    }

    public void writePackageExtensions(@NotNull KmPackage kmPackage, @NotNull ProtoBuf.Package.Builder proto, @NotNull WriteContext c2) {
        block2: {
            Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
            Intrinsics.checkNotNullParameter(proto, "proto");
            Intrinsics.checkNotNullParameter(c2, "c");
            JvmPackageExtension $this$writePackageExtensions_u24lambda_u2425 = JvmExtensionNodesKt.getJvm(kmPackage);
            boolean bl2 = false;
            Iterable $this$forEach$iv = $this$writePackageExtensions_u24lambda_u2425.getLocalDelegatedProperties();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                KmProperty it = (KmProperty)element$iv;
                boolean bl3 = false;
                proto.addExtension(JvmProtoBuf.packageLocalVariable, WritersKt.writeProperty(c2, it).build());
            }
            String string = $this$writePackageExtensions_u24lambda_u2425.getModuleName();
            if (string == null) break block2;
            String name = string;
            boolean bl4 = false;
            if (!Intrinsics.areEqual(name, "main")) {
                proto.setExtension(JvmProtoBuf.packageModuleName, c2.get(name));
            }
        }
    }

    public void writeModuleFragmentExtensions(@NotNull KmModuleFragment kmModuleFragment, @NotNull ProtoBuf.PackageFragment.Builder proto, @NotNull WriteContext c2) {
        Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
    }

    public void writeFunctionExtensions(@NotNull KmFunction kmFunction, @NotNull ProtoBuf.Function.Builder proto, @NotNull WriteContext c2) {
        block3: {
            Object it;
            KmAnnotation it2;
            Collection collection;
            Iterable $this$mapTo$iv$iv;
            Iterable $this$map$iv;
            Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
            Intrinsics.checkNotNullParameter(proto, "proto");
            Intrinsics.checkNotNullParameter(c2, "c");
            JvmFunctionExtension $this$writeFunctionExtensions_u24lambda_u2430 = JvmExtensionNodesKt.getJvm(kmFunction);
            boolean bl2 = false;
            Iterable iterable = kmFunction.getAnnotations();
            ProtoBuf.Function.Builder builder = proto;
            boolean $i$f$map = false;
            void var9_9 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                KmAnnotation kmAnnotation = (KmAnnotation)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add(WriteUtilsKt.writeAnnotation(it2, c2.getStrings()).build());
            }
            builder.addAllAnnotation((List)destination$iv$iv);
            $this$map$iv = kmFunction.getExtensionReceiverParameterAnnotations();
            builder = proto;
            $i$f$map = false;
            $this$mapTo$iv$iv = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                it2 = (KmAnnotation)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl4 = false;
                collection.add(WriteUtilsKt.writeAnnotation(it2, c2.getStrings()).build());
            }
            builder.addAllExtensionReceiverAnnotation((List)destination$iv$iv);
            JvmMethodSignature jvmMethodSignature = $this$writeFunctionExtensions_u24lambda_u2430.getSignature();
            if (jvmMethodSignature != null) {
                it = jvmMethodSignature;
                boolean bl5 = false;
                ProtoBuf.Function.Builder cfr_ignored_0 = (ProtoBuf.Function.Builder)proto.setExtension(JvmProtoBuf.methodSignature, this.toJvmMethodSignature((JvmMemberSignature)it, c2));
            }
            String string = $this$writeFunctionExtensions_u24lambda_u2430.getLambdaClassOriginName();
            if (string == null) break block3;
            it = string;
            boolean bl6 = false;
            ProtoBuf.Function.Builder cfr_ignored_1 = (ProtoBuf.Function.Builder)proto.setExtension(JvmProtoBuf.lambdaClassOriginName, c2.get((String)it));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void writePropertyExtensions(@NotNull KmProperty kmProperty, @NotNull ProtoBuf.Property.Builder proto, @NotNull WriteContext c2) {
        KmAnnotation $this$mapTo$iv$iv;
        Object setter;
        KmAnnotation it;
        Collection collection;
        Iterable $this$mapTo$iv$iv2;
        Iterable $this$map$iv;
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmPropertyExtension $this$writePropertyExtensions_u24lambda_u2439 = JvmExtensionNodesKt.getJvm(kmProperty);
        boolean bl2 = false;
        Iterable iterable = kmProperty.getAnnotations();
        GeneratedMessageLite.Builder builder = proto;
        boolean $i$f$map = false;
        JvmProtoBuf.JvmFieldSignature.Builder builder2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            KmAnnotation kmAnnotation = (KmAnnotation)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(WriteUtilsKt.writeAnnotation(it, c2.getStrings()).build());
        }
        ((ProtoBuf.Property.Builder)builder).addAllAnnotation((List)destination$iv$iv);
        $this$map$iv = kmProperty.getGetter().getAnnotations();
        builder = proto;
        $i$f$map = false;
        $this$mapTo$iv$iv2 = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            it = (KmAnnotation)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl4 = false;
            collection.add(WriteUtilsKt.writeAnnotation(it, c2.getStrings()).build());
        }
        ((ProtoBuf.Property.Builder)builder).addAllGetterAnnotation((List)destination$iv$iv);
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = kmProperty.getSetter();
        if (kmPropertyAccessorAttributes != null) {
            void $this$map$iv2;
            setter = kmPropertyAccessorAttributes;
            boolean bl5 = false;
            Iterable $i$f$mapTo2 = ((KmPropertyAccessorAttributes)setter).getAnnotations();
            Iterator iterator2 = proto;
            boolean $i$f$map2 = false;
            it = $this$map$iv2;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            boolean $i$f$mapTo3 = false;
            Iterator iterator3 = $this$mapTo$iv$iv.iterator();
            while (iterator3.hasNext()) {
                void it2;
                Object item$iv$iv = iterator3.next();
                KmAnnotation kmAnnotation = (KmAnnotation)item$iv$iv;
                Collection collection2 = destination$iv$iv2;
                boolean bl6 = false;
                collection2.add(WriteUtilsKt.writeAnnotation((KmAnnotation)it2, c2.getStrings()).build());
            }
            ((ProtoBuf.Property.Builder)((Object)iterator2)).addAllSetterAnnotation((List)destination$iv$iv2);
        }
        $this$map$iv = kmProperty.getExtensionReceiverParameterAnnotations();
        builder = proto;
        $i$f$map = false;
        setter = $this$map$iv;
        Object destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo4 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            $this$mapTo$iv$iv = (KmAnnotation)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl7 = false;
            collection.add(WriteUtilsKt.writeAnnotation(it, c2.getStrings()).build());
        }
        ((ProtoBuf.Property.Builder)builder).addAllExtensionReceiverAnnotation((List)destination$iv$iv2);
        $this$map$iv = kmProperty.getBackingFieldAnnotations();
        builder = proto;
        $i$f$map = false;
        $this$mapTo$iv$iv2 = $this$map$iv;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo4 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            it = (KmAnnotation)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl8 = false;
            collection.add(WriteUtilsKt.writeAnnotation(it, c2.getStrings()).build());
        }
        ((ProtoBuf.Property.Builder)builder).addAllBackingFieldAnnotation((List)destination$iv$iv2);
        $this$map$iv = kmProperty.getDelegateFieldAnnotations();
        builder = proto;
        $i$f$map = false;
        $this$mapTo$iv$iv2 = $this$map$iv;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo4 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            it = (KmAnnotation)item$iv$iv;
            collection = destination$iv$iv2;
            boolean bl9 = false;
            collection.add(WriteUtilsKt.writeAnnotation(it, c2.getStrings()).build());
        }
        ((ProtoBuf.Property.Builder)builder).addAllDelegateFieldAnnotation((List)destination$iv$iv2);
        JvmProtoBuf.JvmPropertySignature.Builder builder3 = JvmProtoBuf.JvmPropertySignature.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builder3, "newBuilder(...)");
        JvmProtoBuf.JvmPropertySignature.Builder composedSignature = builder3;
        boolean hasSignature = false;
        if ($this$writePropertyExtensions_u24lambda_u2439.getFieldSignature() != null) {
            void field;
            hasSignature = true;
            builder2 = JvmProtoBuf.JvmFieldSignature.newBuilder();
            destination$iv$iv2 = builder2;
            builder = composedSignature;
            boolean bl10 = false;
            JvmFieldSignature jvmFieldSignature = $this$writePropertyExtensions_u24lambda_u2439.getFieldSignature();
            Intrinsics.checkNotNull(jvmFieldSignature);
            field.setName(c2.get(jvmFieldSignature.getName()));
            JvmFieldSignature jvmFieldSignature2 = $this$writePropertyExtensions_u24lambda_u2439.getFieldSignature();
            Intrinsics.checkNotNull(jvmFieldSignature2);
            field.setDesc(c2.get(jvmFieldSignature2.getDescriptor()));
            ((JvmProtoBuf.JvmPropertySignature.Builder)builder).setField(builder2.build());
        }
        if ($this$writePropertyExtensions_u24lambda_u2439.getGetterSignature() != null) {
            hasSignature = true;
            JvmMethodSignature jvmMethodSignature = $this$writePropertyExtensions_u24lambda_u2439.getGetterSignature();
            Intrinsics.checkNotNull(jvmMethodSignature);
            composedSignature.setGetter(this.toJvmMethodSignature(jvmMethodSignature, c2));
        }
        if ($this$writePropertyExtensions_u24lambda_u2439.getSetterSignature() != null) {
            hasSignature = true;
            JvmMethodSignature jvmMethodSignature = $this$writePropertyExtensions_u24lambda_u2439.getSetterSignature();
            Intrinsics.checkNotNull(jvmMethodSignature);
            composedSignature.setSetter(this.toJvmMethodSignature(jvmMethodSignature, c2));
        }
        if (hasSignature && $this$writePropertyExtensions_u24lambda_u2439.getSyntheticMethodForAnnotations() != null) {
            JvmMethodSignature jvmMethodSignature = $this$writePropertyExtensions_u24lambda_u2439.getSyntheticMethodForAnnotations();
            Intrinsics.checkNotNull(jvmMethodSignature);
            composedSignature.setSyntheticMethod(this.toJvmMethodSignature(jvmMethodSignature, c2));
        }
        if (hasSignature && $this$writePropertyExtensions_u24lambda_u2439.getSyntheticMethodForDelegate() != null) {
            JvmMethodSignature jvmMethodSignature = $this$writePropertyExtensions_u24lambda_u2439.getSyntheticMethodForDelegate();
            Intrinsics.checkNotNull(jvmMethodSignature);
            composedSignature.setDelegateMethod(this.toJvmMethodSignature(jvmMethodSignature, c2));
        }
        Integer n2 = ProtoBuf.Property.getDefaultInstance().getExtension(JvmProtoBuf.flags);
        if (n2 == null || $this$writePropertyExtensions_u24lambda_u2439.getJvmFlags() != n2.intValue()) {
            proto.setExtension(JvmProtoBuf.flags, $this$writePropertyExtensions_u24lambda_u2439.getJvmFlags());
        }
        if (hasSignature) {
            proto.setExtension(JvmProtoBuf.propertySignature, composedSignature.build());
        }
    }

    /*
     * WARNING - void declaration
     */
    public void writeConstructorExtensions(@NotNull KmConstructor kmConstructor, @NotNull ProtoBuf.Constructor.Builder proto, @NotNull WriteContext c2) {
        block1: {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
            Intrinsics.checkNotNullParameter(proto, "proto");
            Intrinsics.checkNotNullParameter(c2, "c");
            JvmConstructorExtension $this$writeConstructorExtensions_u24lambda_u2442 = JvmExtensionNodesKt.getJvm(kmConstructor);
            boolean bl2 = false;
            Iterable iterable = kmConstructor.getAnnotations();
            ProtoBuf.Constructor.Builder builder = proto;
            boolean $i$f$map = false;
            void var9_9 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                KmAnnotation kmAnnotation = (KmAnnotation)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add(WriteUtilsKt.writeAnnotation((KmAnnotation)it, c2.getStrings()).build());
            }
            builder.addAllAnnotation((List)destination$iv$iv);
            JvmMethodSignature jvmMethodSignature = $this$writeConstructorExtensions_u24lambda_u2442.getSignature();
            if (jvmMethodSignature == null) break block1;
            JvmMethodSignature it = jvmMethodSignature;
            boolean bl4 = false;
            proto.setExtension(JvmProtoBuf.constructorSignature, this.toJvmMethodSignature(it, c2));
        }
    }

    @Override
    public void writeTypeParameterExtensions(@NotNull KmTypeParameter kmTypeParameter, @NotNull ProtoBuf.TypeParameter.Builder proto, @NotNull WriteContext c2) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmTypeParameterExtension $this$writeTypeParameterExtensions_u24lambda_u2444 = JvmExtensionNodesKt.getJvm(kmTypeParameter);
        boolean bl2 = false;
        Iterable $this$forEach$iv = $this$writeTypeParameterExtensions_u24lambda_u2444.getAnnotations();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmAnnotation annotation = (KmAnnotation)element$iv;
            boolean bl3 = false;
            proto.addExtension(JvmProtoBuf.typeParameterAnnotation, WriteUtilsKt.writeAnnotation(annotation, c2.getStrings()).build());
        }
    }

    public void writeEnumEntryExtensions(@NotNull KmEnumEntry enumEntry, @NotNull ProtoBuf.EnumEntry.Builder proto, @NotNull WriteContext c2) {
        Intrinsics.checkNotNullParameter(enumEntry, "enumEntry");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$forEach$iv = enumEntry.getAnnotations();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmAnnotation annotation = (KmAnnotation)element$iv;
            boolean bl2 = false;
            proto.addAnnotation(WriteUtilsKt.writeAnnotation(annotation, c2.getStrings()).build());
        }
    }

    @Override
    public void writeTypeExtensions(@NotNull KmType type, @NotNull ProtoBuf.Type.Builder proto, @NotNull WriteContext c2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        JvmTypeExtension $this$writeTypeExtensions_u24lambda_u2447 = JvmExtensionNodesKt.getJvm(type);
        boolean bl2 = false;
        if ($this$writeTypeExtensions_u24lambda_u2447.isRaw()) {
            proto.setExtension(JvmProtoBuf.isRaw, true);
        }
        Iterable $this$forEach$iv = $this$writeTypeExtensions_u24lambda_u2447.getAnnotations();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            KmAnnotation annotation = (KmAnnotation)element$iv;
            boolean bl3 = false;
            proto.addExtension(JvmProtoBuf.typeAnnotation, WriteUtilsKt.writeAnnotation(annotation, c2.getStrings()).build());
        }
    }

    public void writeTypeAliasExtensions(@NotNull KmTypeAlias typeAlias, @NotNull ProtoBuf.TypeAlias.Builder proto, @NotNull WriteContext c2) {
        Intrinsics.checkNotNullParameter(typeAlias, "typeAlias");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void writeValueParameterExtensions(@NotNull KmValueParameter valueParameter, @NotNull ProtoBuf.ValueParameter.Builder proto, @NotNull WriteContext c2) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(valueParameter, "valueParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable iterable = valueParameter.getAnnotations();
        ProtoBuf.ValueParameter.Builder builder = proto;
        boolean $i$f$map = false;
        void var6_7 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            KmAnnotation kmAnnotation = (KmAnnotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(WriteUtilsKt.writeAnnotation((KmAnnotation)it, c2.getStrings()).build());
        }
        builder.addAllAnnotation((List)destination$iv$iv);
    }

    @Override
    @NotNull
    public KmClassExtension createClassExtension() {
        return new JvmClassExtension();
    }

    @NotNull
    public KmPackageExtension createPackageExtension() {
        return new JvmPackageExtension();
    }

    @NotNull
    public KmModuleFragmentExtension createModuleFragmentExtensions() {
        return new KmModuleFragmentExtension(){
            private final KmExtensionType type;
            {
                this.type = new KmExtensionType(Reflection.getOrCreateKotlinClass(KmModuleFragmentExtension.class));
            }

            public KmExtensionType getType() {
                return this.type;
            }
        };
    }

    @Override
    @NotNull
    public KmFunctionExtension createFunctionExtension() {
        return new JvmFunctionExtension();
    }

    @Override
    @NotNull
    public KmPropertyExtension createPropertyExtension() {
        return new JvmPropertyExtension();
    }

    @Override
    @NotNull
    public KmConstructorExtension createConstructorExtension() {
        return new JvmConstructorExtension();
    }

    @Override
    @NotNull
    public KmTypeParameterExtension createTypeParameterExtension() {
        return new JvmTypeParameterExtension();
    }

    @Override
    @Nullable
    public KmEnumEntryExtension createEnumEntryExtension() {
        return null;
    }

    @Override
    @NotNull
    public KmTypeExtension createTypeExtension() {
        return new JvmTypeExtension();
    }

    @Override
    @Nullable
    public KmTypeAliasExtension createTypeAliasExtension() {
        return null;
    }

    @Override
    @Nullable
    public KmValueParameterExtension createValueParameterExtension() {
        return null;
    }

    private final JvmProtoBuf.JvmMethodSignature toJvmMethodSignature(JvmMemberSignature $this$toJvmMethodSignature, WriteContext c2) {
        JvmProtoBuf.JvmMethodSignature.Builder builder;
        JvmProtoBuf.JvmMethodSignature.Builder $this$toJvmMethodSignature_u24lambda_u2449 = builder = JvmProtoBuf.JvmMethodSignature.newBuilder();
        boolean bl2 = false;
        $this$toJvmMethodSignature_u24lambda_u2449.setName(c2.get($this$toJvmMethodSignature.getName()));
        $this$toJvmMethodSignature_u24lambda_u2449.setDesc(c2.get($this$toJvmMethodSignature.getDescriptor()));
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = builder.build();
        Intrinsics.checkNotNullExpressionValue(jvmMethodSignature, "build(...)");
        return jvmMethodSignature;
    }
}


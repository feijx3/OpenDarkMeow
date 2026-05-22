/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nAnnotationTypeQualifierResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AnnotationTypeQualifierResolver\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n77#2:58\n97#2,5:59\n1374#3:64\n1460#3,5:65\n*S KotlinDebug\n*F\n+ 1 AnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AnnotationTypeQualifierResolver\n*L\n43#1:58\n43#1:59,5\n52#1:64\n52#1:65,5\n*E\n"})
public final class AnnotationTypeQualifierResolver
extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    public AnnotationTypeQualifierResolver(@NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        super(javaTypeEnhancementState);
    }

    @Override
    public boolean isK2() {
        return false;
    }

    @Override
    @NotNull
    protected Iterable<AnnotationDescriptor> getMetaAnnotations(@NotNull AnnotationDescriptor $this$metaAnnotations) {
        Intrinsics.checkNotNullParameter($this$metaAnnotations, "<this>");
        Object object = DescriptorUtilsKt.getAnnotationClass($this$metaAnnotations);
        return object != null && (object = object.getAnnotations()) != null ? (Iterable)object : (Iterable)CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    protected Object getKey(@NotNull AnnotationDescriptor $this$key) {
        Intrinsics.checkNotNullParameter($this$key, "<this>");
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getAnnotationClass($this$key);
        Intrinsics.checkNotNull(classDescriptor);
        return classDescriptor;
    }

    @Override
    @Nullable
    protected FqName getFqName(@NotNull AnnotationDescriptor $this$fqName) {
        Intrinsics.checkNotNullParameter($this$fqName, "<this>");
        return $this$fqName.getFqName();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected Iterable<String> enumArguments(@NotNull AnnotationDescriptor $this$enumArguments, boolean onlyValue) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$enumArguments, "<this>");
        Map<Name, ConstantValue<?>> $this$flatMap$iv = $this$enumArguments.getAllValueArguments();
        boolean $i$f$flatMap = false;
        Map<Name, ConstantValue<?>> map = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        Iterator iterator2 = $this$flatMapTo$iv$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry entry = element$iv$iv = iterator2.next();
            boolean bl2 = false;
            Name parameter = (Name)entry.getKey();
            ConstantValue argument = (ConstantValue)entry.getValue();
            Iterable list$iv$iv = !onlyValue || Intrinsics.areEqual(parameter, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) ? this.toEnumNames(argument) : CollectionsKt.emptyList();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final List<String> toEnumNames(ConstantValue<?> $this$toEnumNames) {
        List<String> list;
        ConstantValue<?> constantValue = $this$toEnumNames;
        if (constantValue instanceof ArrayValue) {
            void $this$flatMapTo$iv$iv;
            Iterable $this$flatMap$iv = (Iterable)((ArrayValue)$this$toEnumNames).getValue();
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                ConstantValue it = (ConstantValue)element$iv$iv;
                boolean bl2 = false;
                Iterable list$iv$iv = this.toEnumNames(it);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            list = (List<String>)destination$iv$iv;
        } else {
            list = constantValue instanceof EnumValue ? CollectionsKt.listOf(((EnumValue)$this$toEnumNames).getEnumEntryName().getIdentifier()) : CollectionsKt.emptyList();
        }
        return list;
    }
}


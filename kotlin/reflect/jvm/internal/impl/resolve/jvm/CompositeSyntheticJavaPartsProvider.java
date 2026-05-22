/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nSyntheticJavaPartsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1374#2:109\n1460#2,5:110\n1869#2,2:115\n1374#2:117\n1460#2,5:118\n1869#2,2:123\n1869#2,2:125\n1374#2:127\n1460#2,5:128\n1869#2,2:133\n1803#2,3:135\n*S KotlinDebug\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n*L\n55#1:109\n55#1:110,5\n64#1:115,2\n68#1:117\n68#1:118,5\n76#1:123,2\n84#1:125,2\n88#1:127\n88#1:128,5\n97#1:133,2\n105#1:135,3\n*E\n"})
public final class CompositeSyntheticJavaPartsProvider
implements SyntheticJavaPartsProvider {
    @NotNull
    private final List<SyntheticJavaPartsProvider> inner;

    public CompositeSyntheticJavaPartsProvider(@NotNull List<? extends SyntheticJavaPartsProvider> inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<Name> getMethodNames(@NotNull ClassDescriptor thisDescriptor, @NotNull LazyJavaResolverContext c2) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$flatMap$iv = this.inner;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv$iv;
            boolean bl2 = false;
            Iterable list$iv$iv = it.getMethodNames(thisDescriptor, c2);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    public void generateMethods(@NotNull ClassDescriptor thisDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> result, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$forEach$iv = this.inner;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv;
            boolean bl2 = false;
            it.generateMethods(thisDescriptor, name, result, c2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<Name> getStaticFunctionNames(@NotNull ClassDescriptor thisDescriptor, @NotNull LazyJavaResolverContext c2) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$flatMap$iv = this.inner;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv$iv;
            boolean bl2 = false;
            Iterable list$iv$iv = it.getStaticFunctionNames(thisDescriptor, c2);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    public void generateStaticFunctions(@NotNull ClassDescriptor thisDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> result, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$forEach$iv = this.inner;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv;
            boolean bl2 = false;
            it.generateStaticFunctions(thisDescriptor, name, result, c2);
        }
    }

    @Override
    public void generateConstructors(@NotNull ClassDescriptor thisDescriptor, @NotNull List<ClassConstructorDescriptor> result, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$forEach$iv = this.inner;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv;
            boolean bl2 = false;
            it.generateConstructors(thisDescriptor, result, c2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<Name> getNestedClassNames(@NotNull ClassDescriptor thisDescriptor, @NotNull LazyJavaResolverContext c2) {
        void $this$flatMapTo$iv$iv;
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$flatMap$iv = this.inner;
        boolean $i$f$flatMap = false;
        Iterable iterable = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv$iv;
            boolean bl2 = false;
            Iterable list$iv$iv = it.getNestedClassNames(thisDescriptor, c2);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    public void generateNestedClass(@NotNull ClassDescriptor thisDescriptor, @NotNull Name name, @NotNull List<ClassDescriptor> result, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$forEach$iv = this.inner;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SyntheticJavaPartsProvider it = (SyntheticJavaPartsProvider)element$iv;
            boolean bl2 = false;
            it.generateNestedClass(thisDescriptor, name, result, c2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public PropertyDescriptorImpl modifyField(@NotNull ClassDescriptor thisDescriptor, @NotNull PropertyDescriptorImpl propertyDescriptor, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(propertyDescriptor, "propertyDescriptor");
        Intrinsics.checkNotNullParameter(c2, "c");
        Iterable $this$fold$iv = this.inner;
        boolean $i$f$fold = false;
        PropertyDescriptorImpl accumulator$iv = propertyDescriptor;
        for (Object element$iv : $this$fold$iv) {
            void provider;
            SyntheticJavaPartsProvider syntheticJavaPartsProvider = (SyntheticJavaPartsProvider)element$iv;
            PropertyDescriptorImpl property = accumulator$iv;
            boolean bl2 = false;
            accumulator$iv = provider.modifyField(thisDescriptor, property, c2);
        }
        return accumulator$iv;
    }
}


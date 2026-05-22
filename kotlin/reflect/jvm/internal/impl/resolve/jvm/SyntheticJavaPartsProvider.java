/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.CompositeSyntheticJavaPartsProvider;
import org.jetbrains.annotations.NotNull;

public interface SyntheticJavaPartsProvider {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider$Companion.$$INSTANCE;

    @NotNull
    public List<Name> getMethodNames(@NotNull ClassDescriptor var1, @NotNull LazyJavaResolverContext var2);

    public void generateMethods(@NotNull ClassDescriptor var1, @NotNull Name var2, @NotNull Collection<SimpleFunctionDescriptor> var3, @NotNull LazyJavaResolverContext var4);

    @NotNull
    public List<Name> getStaticFunctionNames(@NotNull ClassDescriptor var1, @NotNull LazyJavaResolverContext var2);

    public void generateStaticFunctions(@NotNull ClassDescriptor var1, @NotNull Name var2, @NotNull Collection<SimpleFunctionDescriptor> var3, @NotNull LazyJavaResolverContext var4);

    public void generateConstructors(@NotNull ClassDescriptor var1, @NotNull List<ClassConstructorDescriptor> var2, @NotNull LazyJavaResolverContext var3);

    @NotNull
    public List<Name> getNestedClassNames(@NotNull ClassDescriptor var1, @NotNull LazyJavaResolverContext var2);

    public void generateNestedClass(@NotNull ClassDescriptor var1, @NotNull Name var2, @NotNull List<ClassDescriptor> var3, @NotNull LazyJavaResolverContext var4);

    @NotNull
    public PropertyDescriptorImpl modifyField(@NotNull ClassDescriptor var1, @NotNull PropertyDescriptorImpl var2, @NotNull LazyJavaResolverContext var3);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final CompositeSyntheticJavaPartsProvider EMPTY;

        private Companion() {
        }

        @NotNull
        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());
        }
    }
}


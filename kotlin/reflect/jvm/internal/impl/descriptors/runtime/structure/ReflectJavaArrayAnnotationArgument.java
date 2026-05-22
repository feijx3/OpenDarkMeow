/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectJavaAnnotationArguments.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaAnnotationArguments.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaArrayAnnotationArgument\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,79:1\n11228#2:80\n11563#2,3:81\n*S KotlinDebug\n*F\n+ 1 ReflectJavaAnnotationArguments.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaArrayAnnotationArgument\n*L\n48#1:80\n48#1:81,3\n*E\n"})
public final class ReflectJavaArrayAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaArrayAnnotationArgument {
    @NotNull
    private final Object[] values;

    public ReflectJavaArrayAnnotationArgument(@Nullable Name name, @NotNull Object[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        super(name, null);
        this.values = values;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaAnnotationArgument> getElements() {
        void $this$mapTo$iv$iv;
        Object[] $this$map$iv = this.values;
        boolean $i$f$map = false;
        Object[] objectArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv$iv;
            void var9_9 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            void v0 = it;
            Intrinsics.checkNotNull(v0);
            collection.add(ReflectJavaAnnotationArgument.Factory.create(v0, null));
        }
        return (List)destination$iv$iv;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaRetentionAnnotationDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
public final class JavaRetentionAnnotationDescriptor
extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final NotNullLazyValue allValueArguments$delegate;

    public JavaRetentionAnnotationDescriptor(@NotNull JavaAnnotation annotation, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(c2, "c");
        super(c2, annotation, StandardNames.FqNames.retention);
        JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor = this;
        this.allValueArguments$delegate = c2.getStorageManager().createLazyValue(new JavaRetentionAnnotationDescriptor$$Lambda$0(javaRetentionAnnotationDescriptor));
    }

    @Override
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map)StorageKt.getValue(this.allValueArguments$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private static final Map allValueArguments_delegate$lambda$1(JavaRetentionAnnotationDescriptor this$0) {
        Map map;
        Map<Object, Object> map2;
        ConstantValue<?> retentionArgument;
        ConstantValue<?> constantValue = retentionArgument = JavaAnnotationTargetMapper.INSTANCE.mapJavaRetentionArgument$descriptors_jvm(this$0.getFirstArgument());
        if (constantValue != null) {
            ConstantValue<?> it = constantValue;
            boolean bl2 = false;
            map2 = MapsKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), it));
        } else {
            map2 = map = null;
        }
        if (map2 == null) {
            map = MapsKt.emptyMap();
        }
        return map;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JavaRetentionAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ Map accessor$JavaRetentionAnnotationDescriptor$lambda0(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        return JavaRetentionAnnotationDescriptor.allValueArguments_delegate$lambda$1(javaRetentionAnnotationDescriptor);
    }
}


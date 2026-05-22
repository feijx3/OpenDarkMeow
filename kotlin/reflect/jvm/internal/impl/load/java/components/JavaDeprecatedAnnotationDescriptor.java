/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaDeprecatedAnnotationDescriptor
extends JavaAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final NotNullLazyValue allValueArguments$delegate;

    public JavaDeprecatedAnnotationDescriptor(@Nullable JavaAnnotation annotation, @NotNull LazyJavaResolverContext c2) {
        Intrinsics.checkNotNullParameter(c2, "c");
        super(c2, annotation, StandardNames.FqNames.deprecated);
        this.allValueArguments$delegate = c2.getStorageManager().createLazyValue(JavaDeprecatedAnnotationDescriptor$$Lambda$0.INSTANCE);
    }

    @Override
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map)StorageKt.getValue(this.allValueArguments$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private static final Map allValueArguments_delegate$lambda$0() {
        return MapsKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm(), new StringValue("Deprecated in Java")));
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JavaDeprecatedAnnotationDescriptor.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ Map accessor$JavaDeprecatedAnnotationDescriptor$lambda0() {
        return JavaDeprecatedAnnotationDescriptor.allValueArguments_delegate$lambda$0();
    }
}


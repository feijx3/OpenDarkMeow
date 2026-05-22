/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
public class JavaAnnotationDescriptor
implements PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final FqName fqName;
    @NotNull
    private final SourceElement source;
    @NotNull
    private final NotNullLazyValue type$delegate;
    @Nullable
    private final JavaAnnotationArgument firstArgument;
    private final boolean isIdeExternalAnnotation;

    /*
     * Unable to fully structure code
     */
    public JavaAnnotationDescriptor(@NotNull LazyJavaResolverContext c, @Nullable JavaAnnotation annotation, @NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        super();
        this.fqName = fqName;
        v0 = this;
        v1 = annotation;
        if (v1 == null) ** GOTO lbl-1000
        var4_4 = v1;
        var6_5 = v0;
        $i$a$-let-JavaAnnotationDescriptor$source$1 = false;
        v2 = c.getComponents().getSourceElementFactory().source((JavaElement)it);
        v0 = var6_5;
        v1 = v2;
        if (v2 != null) {
            v3 = (SourceElement)v1;
        } else lbl-1000:
        // 2 sources

        {
            v4 = SourceElement.NO_SOURCE;
            v3 = v4;
            Intrinsics.checkNotNullExpressionValue(v4, "NO_SOURCE");
        }
        v0.source = v3;
        var7_7 = this;
        var8_8 = c;
        this.type$delegate = c.getStorageManager().createLazyValue(new JavaAnnotationDescriptor$$Lambda$0(var8_8, var7_7));
        v5 = annotation;
        this.firstArgument = v5 != null && (v5 = v5.getArguments()) != null ? (JavaAnnotationArgument)CollectionsKt.firstOrNull((Iterable)v5) : null;
        v6 = annotation;
        this.isIdeExternalAnnotation = v6 != null ? v6.isIdeExternalAnnotation() : false;
    }

    @Override
    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        return this.source;
    }

    @Override
    @NotNull
    public SimpleType getType() {
        return (SimpleType)StorageKt.getValue(this.type$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Nullable
    protected final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    @Override
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }

    @Override
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    private static final SimpleType type_delegate$lambda$1(LazyJavaResolverContext $c, JavaAnnotationDescriptor this$0) {
        SimpleType simpleType = $c.getModule().getBuiltIns().getBuiltInClassByFqName(this$0.getFqName()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(simpleType, "getDefaultType(...)");
        return simpleType;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(JavaAnnotationDescriptor.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ SimpleType accessor$JavaAnnotationDescriptor$lambda0(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        return JavaAnnotationDescriptor.type_delegate$lambda$1(lazyJavaResolverContext, javaAnnotationDescriptor);
    }
}


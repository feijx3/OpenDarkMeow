/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationTargetMapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n808#2,11:183\n1374#2:194\n1460#2,5:195\n1563#2:200\n1634#2,3:201\n*S KotlinDebug\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationTargetMapper\n*L\n153#1:183,11\n154#1:194\n154#1:195,5\n155#1:200\n155#1:201,3\n*E\n"})
public final class JavaAnnotationTargetMapper {
    @NotNull
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    @NotNull
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists;
    @NotNull
    private static final Map<String, KotlinRetention> retentionNameList;

    private JavaAnnotationTargetMapper() {
    }

    @NotNull
    public final Set<KotlinTarget> mapJavaTargetArgumentByName(@Nullable String argumentName) {
        EnumSet<KotlinTarget> enumSet = targetNameLists.get(argumentName);
        return enumSet != null ? (Set<KotlinTarget>)enumSet : SetsKt.emptySet();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(@NotNull List<? extends JavaAnnotationArgument> arguments) {
        void $this$mapTo$iv$iv;
        Object list$iv$iv;
        Iterable $this$flatMapTo$iv$iv;
        Iterable $this$filterIsInstanceTo$iv$iv;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Iterable $this$filterIsInstance$iv = arguments;
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof JavaEnumValueAnnotationArgument)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$flatMap$iv = (List)destination$iv$iv;
        boolean $i$f$flatMap = false;
        $this$filterIsInstanceTo$iv$iv = $this$flatMap$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            JavaEnumValueAnnotationArgument it = (JavaEnumValueAnnotationArgument)element$iv$iv;
            boolean bl2 = false;
            Name name = it.getEntryName();
            list$iv$iv = INSTANCE.mapJavaTargetArgumentByName(name != null ? name.asString() : null);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$flatMapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void kotlinTarget;
            list$iv$iv = (KotlinTarget)((Object)item$iv$iv);
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.annotationTarget);
            Name name = Name.identifier(kotlinTarget.name());
            Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
            collection.add(new EnumValue(classId, name));
        }
        List kotlinTargets = (List)destination$iv$iv;
        return new ArrayValue(kotlinTargets, JavaAnnotationTargetMapper$$Lambda$0.INSTANCE);
    }

    @Nullable
    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(@Nullable JavaAnnotationArgument element) {
        EnumValue enumValue;
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = element instanceof JavaEnumValueAnnotationArgument ? (JavaEnumValueAnnotationArgument)element : null;
        if (javaEnumValueAnnotationArgument != null) {
            JavaEnumValueAnnotationArgument it = javaEnumValueAnnotationArgument;
            boolean bl2 = false;
            Map<String, KotlinRetention> map = retentionNameList;
            Name name = it.getEntryName();
            KotlinRetention kotlinRetention = map.get(name != null ? name.asString() : null);
            if (kotlinRetention != null) {
                KotlinRetention retention = kotlinRetention;
                boolean bl3 = false;
                ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.annotationRetention);
                Name name2 = Name.identifier(retention.name());
                Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
                enumValue = new EnumValue(classId, name2);
            } else {
                enumValue = null;
            }
        } else {
            enumValue = null;
        }
        return enumValue;
    }

    private static final KotlinType mapJavaTargetArguments$lambda$2(ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        ValueParameterDescriptor parameterDescriptor = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), module.getBuiltIns().getBuiltInClassByFqName(StandardNames.FqNames.target));
        Annotated annotated = parameterDescriptor;
        if (annotated == null || (annotated = annotated.getType()) == null) {
            annotated = ErrorUtils.createErrorType(ErrorTypeKind.UNMAPPED_ANNOTATION_TARGET_TYPE, new String[0]);
        }
        return annotated;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of((Enum)KotlinTarget.CLASS, (Enum)KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of((Enum)KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of((Enum)KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of((Enum)KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of((Enum)KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of((Enum)KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of((Enum)KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of((Enum)KotlinTarget.FUNCTION, (Enum)KotlinTarget.PROPERTY_GETTER, (Enum)KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of((Enum)KotlinTarget.TYPE))};
        targetNameLists = MapsKt.mapOf(pairArray);
        pairArray = new Pair[]{TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE)};
        retentionNameList = MapsKt.mapOf(pairArray);
    }

    static /* synthetic */ KotlinType accessor$JavaAnnotationTargetMapper$lambda0(ModuleDescriptor moduleDescriptor) {
        return JavaAnnotationTargetMapper.mapJavaTargetArguments$lambda$2(moduleDescriptor);
    }
}


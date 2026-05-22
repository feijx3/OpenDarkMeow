/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureParts;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,296:1\n1563#2:297\n1634#2,3:298\n1563#2:301\n1634#2,3:302\n1563#2:306\n1634#2,3:307\n1761#2,3:310\n1761#2,3:313\n1573#2:316\n1604#2,4:317\n1563#2:321\n1634#2,3:322\n1563#2:325\n1634#2,3:326\n1#3:305\n*S KotlinDebug\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n*L\n55#1:297\n55#1:298,3\n66#1:301\n66#1:302,3\n123#1:306\n123#1:307,3\n144#1:310,3\n150#1:313,3\n156#1:316\n156#1:317,4\n170#1:321\n170#1:322,3\n220#1:325\n220#1:326,3\n*E\n"})
public final class SignatureEnhancement {
    @NotNull
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(@NotNull JavaTypeEnhancement typeEnhancement) {
        Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull LazyJavaResolverContext c2, @NotNull Collection<? extends D> platformSignatures) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        Iterable $this$map$iv = platformSignatures;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(this.enhanceSignature(it, c2));
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D $this$getDefaultAnnotations, LazyJavaResolverContext c2) {
        void $this$mapTo$iv$iv;
        ClassifierDescriptor classifierDescriptor = DescriptorUtilKt.getTopLevelContainingClassifier($this$getDefaultAnnotations);
        if (classifierDescriptor == null) {
            return ((Annotated)$this$getDefaultAnnotations).getAnnotations();
        }
        ClassifierDescriptor topLevelClassifier = classifierDescriptor;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelClassifier instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor)topLevelClassifier : null;
        List<JavaAnnotation> moduleAnnotations = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.getModuleAnnotations() : null;
        Collection collection = moduleAnnotations;
        if (collection == null || collection.isEmpty()) {
            return ((Annotated)$this$getDefaultAnnotations).getAnnotations();
        }
        Iterable $this$map$iv = moduleAnnotations;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            JavaAnnotation javaAnnotation = (JavaAnnotation)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl2 = false;
            collection2.add(new LazyJavaAnnotationDescriptor(c2, (JavaAnnotation)it, true));
        }
        List moduleAnnotationDescriptors = (List)destination$iv$iv;
        return Annotations.Companion.create(CollectionsKt.plus((Iterable)((Annotated)$this$getDefaultAnnotations).getAnnotations(), (Iterable)moduleAnnotationDescriptors));
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D $this$enhanceSignature, LazyJavaResolverContext c) {
        block35: {
            block34: {
                block30: {
                    block29: {
                        block33: {
                            block31: {
                                block32: {
                                    if (!($this$enhanceSignature instanceof JavaCallableMemberDescriptor)) {
                                        return $this$enhanceSignature;
                                    }
                                    if ($this$enhanceSignature.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && $this$enhanceSignature.getOriginal().getOverriddenDescriptors().size() == 1) {
                                        return $this$enhanceSignature;
                                    }
                                    memberContext = ContextKt.copyWithNewDefaultTypeQualifiers(c, this.getDefaultAnnotations($this$enhanceSignature, c));
                                    if (!($this$enhanceSignature instanceof JavaPropertyDescriptor)) ** GOTO lbl-1000
                                    v0 = ((PropertyDescriptorImpl)$this$enhanceSignature).getGetter();
                                    v1 = v0 != null ? !v0.isDefault() : false;
                                    if (v1) {
                                        v2 = ((PropertyDescriptorImpl)$this$enhanceSignature).getGetter();
                                        Intrinsics.checkNotNull(v2);
                                        v3 /* !! */  = v2;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        v3 /* !! */  = annotationOwnerForMember = $this$enhanceSignature;
                                    }
                                    if (((CallableDescriptor)$this$enhanceSignature).getExtensionReceiverParameter() != null) {
                                        var6_5 = annotationOwnerForMember instanceof FunctionDescriptor != false ? (FunctionDescriptor)annotationOwnerForMember : null;
                                        v4 = this.enhanceValueParameter($this$enhanceSignature, var6_5 != null ? var6_5.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER) : null, memberContext, null, false, SignatureEnhancement$$Lambda$0.INSTANCE);
                                    } else {
                                        v4 = null;
                                    }
                                    receiverTypeEnhancement = v4;
                                    v5 = var7_7 = $this$enhanceSignature instanceof JavaMethodDescriptor != false ? (JavaMethodDescriptor)$this$enhanceSignature : null;
                                    if (var7_7 == null) break block31;
                                    $this$enhanceSignature_u24lambda_u243 = var7_7;
                                    $i$a$-run-SignatureEnhancement$enhanceSignature$predefinedEnhancementInfo$1 = false;
                                    v6 = $this$enhanceSignature_u24lambda_u243.getContainingDeclaration();
                                    Intrinsics.checkNotNull(v6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                                    var8_15 = MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, (ClassDescriptor)v6, MethodSignatureMappingKt.computeJvmDescriptor$default($this$enhanceSignature_u24lambda_u243, false, false, 3, null));
                                    if (var8_15 == null) break block31;
                                    signature = var8_15;
                                    $i$a$-let-SignatureEnhancement$enhanceSignature$predefinedEnhancementInfo$2 = false;
                                    v7 = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(signature);
                                    if (v7 == null) break block32;
                                    it = v7;
                                    $i$a$-let-SignatureEnhancement$enhanceSignature$predefinedEnhancementInfo$2$1 = false;
                                    if (it.getErrorsSinceLanguageVersion() == null) ** GOTO lbl-1000
                                    v8 = it.getErrorsSinceLanguageVersion();
                                    v9 = v8 != null ? StringsKt.startsWith$default(v8, "2.", false, 2, null) : false;
                                    if (v9) lbl-1000:
                                    // 2 sources

                                    {
                                        v10 = true;
                                    } else {
                                        v10 = false;
                                    }
                                    if (!v10) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                    v11 = it.getErrorsSinceLanguageVersion() == null ? it : it.getWarningModeClone();
                                    break block33;
                                }
                                v11 = null;
                                break block33;
                            }
                            v11 = null;
                        }
                        v12 = predefinedEnhancementInfo = v11;
                        if (v12 != null) {
                            it = v12;
                            $i$a$-let-SignatureEnhancement$enhanceSignature$1 = false;
                            v13 = signature = it.getParametersInfo().size() == ((JavaMethodDescriptor)$this$enhanceSignature).getValueParameters().size();
                            if (_Assertions.ENABLED && !signature) {
                                $i$a$-assert-SignatureEnhancement$enhanceSignature$1$1 = false;
                                $i$a$-assert-SignatureEnhancement$enhanceSignature$1$1 = "Predefined enhancement info for " + $this$enhanceSignature + " has " + it.getParametersInfo().size() + ", but " + ((JavaMethodDescriptor)$this$enhanceSignature).getValueParameters().size() + " expected";
                                throw new AssertionError((Object)$i$a$-assert-SignatureEnhancement$enhanceSignature$1$1);
                            }
                        }
                        ignoreDeclarationNullabilityAnnotations = (UtilsKt.isJspecifyEnabledInStrictMode(c.getComponents().getJavaTypeEnhancementState()) != false || memberContext.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters() != false) && UtilsKt.hasErasedValueParameters($this$enhanceSignature) != false;
                        v14 = annotationOwnerForMember.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(v14, "getValueParameters(...)");
                        $this$map$iv = v14;
                        $i$f$map = false;
                        $i$a$-assert-SignatureEnhancement$enhanceSignature$1$1 = $this$map$iv;
                        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $i$f$mapTo = false;
                        for (T item$iv$iv : $this$mapTo$iv$iv /* !! */ ) {
                            var16_29 = (ValueParameterDescriptor)item$iv$iv;
                            var26_35 = destination$iv$iv;
                            $i$a$-map-SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1 = false;
                            v15 = predefinedEnhancementInfo;
                            predefined = v15 != null && (v15 = v15.getParametersInfo()) != null ? (TypeEnhancementInfo)CollectionsKt.getOrNull(v15, p.getIndex()) : null;
                            var29_36 = p;
                            var26_35.add(this.enhanceValueParameter($this$enhanceSignature, (ValueParameterDescriptor)p, memberContext, predefined, ignoreDeclarationNullabilityAnnotations, new SignatureEnhancement$$Lambda$1((ValueParameterDescriptor)var29_36)));
                        }
                        valueParameterEnhancements = (List)destination$iv$iv;
                        v16 = $this$enhanceSignature instanceof PropertyDescriptor != false ? (PropertyDescriptor)$this$enhanceSignature : null;
                        v17 = predefinedEnhancementInfo;
                        returnTypeEnhancement = SignatureEnhancement.enhance$default(this, $this$enhanceSignature, annotationOwnerForMember, true, memberContext, (v16 != null ? JavaDescriptorUtilKt.isJavaField(v16) : false) != false ? AnnotationQualifierApplicabilityType.FIELD : AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, v17 != null ? v17.getReturnTypeInfo() : null, false, SignatureEnhancement$$Lambda$2.INSTANCE, 32, null);
                        v18 = ((CallableDescriptor)$this$enhanceSignature).getReturnType();
                        Intrinsics.checkNotNull(v18);
                        if (this.containsFunctionN(v18) || ((v19 /* !! */  = ((CallableDescriptor)$this$enhanceSignature).getExtensionReceiverParameter()) != null && (v19 /* !! */  = v19 /* !! */ .getType()) != null ? this.containsFunctionN((KotlinType)v19 /* !! */ ) : false)) ** GOTO lbl-1000
                        $this$mapTo$iv$iv /* !! */  = ((CallableDescriptor)$this$enhanceSignature).getValueParameters();
                        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv$iv /* !! */ , "getValueParameters(...)");
                        $this$mapTo$iv$iv /* !! */  = $this$mapTo$iv$iv /* !! */ ;
                        $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            v20 = false;
                        } else {
                            for (Iterator<T> element$iv : $this$any$iv) {
                                it = (ValueParameterDescriptor)element$iv /* !! */ ;
                                $i$a$-any-SignatureEnhancement$enhanceSignature$containsFunctionN$1 = false;
                                v21 = it.getType();
                                Intrinsics.checkNotNullExpressionValue(v21, "getType(...)");
                                if (!this.containsFunctionN(v21)) continue;
                                v20 = true;
                                break block29;
                            }
                            v20 = false;
                        }
                    }
                    if (v20) lbl-1000:
                    // 2 sources

                    {
                        v22 = true;
                    } else {
                        v22 = false;
                    }
                    containsFunctionN = v22;
                    v23 = additionalUserData = containsFunctionN != false ? TuplesKt.to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo($this$enhanceSignature)) : null;
                    if (receiverTypeEnhancement != null || returnTypeEnhancement != null) break block34;
                    $this$any$iv = valueParameterEnhancements;
                    $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        v24 = false;
                    } else {
                        for (T element$iv : $this$any$iv) {
                            it = (KotlinType)element$iv;
                            $i$a$-any-SignatureEnhancement$enhanceSignature$2 = false;
                            if (!(it != null)) continue;
                            v24 = true;
                            break block30;
                        }
                        v24 = false;
                    }
                }
                if (!v24 && additionalUserData == null) break block35;
            }
            v25 = (JavaCallableMemberDescriptor)$this$enhanceSignature;
            v26 = receiverTypeEnhancement;
            if (v26 == null) {
                v27 = ((CallableDescriptor)$this$enhanceSignature).getExtensionReceiverParameter();
                v26 = v27 != null ? v27.getType() : null;
            }
            $i$f$any = valueParameterEnhancements;
            var27_37 = v26;
            var26_35 = v25;
            $i$f$mapIndexed = false;
            element$iv = $this$mapIndexed$iv;
            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            $i$f$mapIndexedTo = false;
            index$iv$iv = 0;
            for (T item$iv$iv : $this$mapIndexedTo$iv$iv) {
                if ((var21_40 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                var22_41 = (KotlinType)item$iv$iv;
                var23_42 = var21_40;
                var28_45 = destination$iv$iv;
                $i$a$-mapIndexed-SignatureEnhancement$enhanceSignature$3 = false;
                v28 = enhanced;
                if (v28 == null) {
                    var25_44 = ((CallableDescriptor)$this$enhanceSignature).getValueParameters().get((int)index).getType();
                    Intrinsics.checkNotNullExpressionValue(var25_44, "getType(...)");
                    v28 = var25_44;
                }
                var28_45.add((void)v28);
            }
            var28_45 = (List)destination$iv$iv;
            v29 = returnTypeEnhancement;
            if (v29 == null) {
                v30 = ((CallableDescriptor)$this$enhanceSignature).getReturnType();
                v29 = v30;
                Intrinsics.checkNotNull(v30);
            }
            var12_19 = var26_35.enhance(var27_37, (List<KotlinType>)var28_45, v29, additionalUserData);
            Intrinsics.checkNotNull(var12_19, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
            return (D)var12_19;
        }
        return $this$enhanceSignature;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<KotlinType> enhanceTypeParameterBounds(@NotNull TypeParameterDescriptor typeParameter, @NotNull List<? extends KotlinType> bounds, @NotNull LazyJavaResolverContext context) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(context, "context");
        Iterable $this$map$iv = bounds;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            KotlinType kotlinType;
            void bound;
            KotlinType kotlinType2 = (KotlinType)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            if (TypeUtilsKt.contains((KotlinType)bound, SignatureEnhancement$$Lambda$3.INSTANCE)) {
                kotlinType = bound;
            } else {
                kotlinType = SignatureEnhancement.enhance$default(this, new SignatureParts(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), (KotlinType)bound, CollectionsKt.emptyList(), null, false, 12, null);
                if (kotlinType == null) {
                    kotlinType = bound;
                }
            }
            collection.add(kotlinType);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public final KotlinType enhanceSuperType(@NotNull KotlinType type, @NotNull LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        KotlinType kotlinType = SignatureEnhancement.enhance$default(this, new SignatureParts(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, CollectionsKt.emptyList(), null, false, 12, null);
        if (kotlinType == null) {
            kotlinType = type;
        }
        return kotlinType;
    }

    private final boolean containsFunctionN(KotlinType $this$containsFunctionN) {
        return TypeUtils.contains($this$containsFunctionN, SignatureEnhancement$$Lambda$4.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    private final KotlinType enhanceValueParameter(CallableMemberDescriptor $this$enhanceValueParameter, ValueParameterDescriptor parameterDescriptor, LazyJavaResolverContext methodContext, TypeEnhancementInfo predefined, boolean ignoreDeclarationNullabilityAnnotations, Function1<? super CallableMemberDescriptor, ? extends KotlinType> collector) {
        Object object;
        boolean bl2;
        Annotated annotated;
        CallableMemberDescriptor callableMemberDescriptor;
        SignatureEnhancement signatureEnhancement;
        block3: {
            block2: {
                void it;
                signatureEnhancement = this;
                callableMemberDescriptor = $this$enhanceValueParameter;
                annotated = parameterDescriptor;
                bl2 = false;
                object = parameterDescriptor;
                if (object == null) break block2;
                ValueParameterDescriptor valueParameterDescriptor = object;
                boolean bl3 = bl2;
                Annotated annotated2 = annotated;
                CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
                SignatureEnhancement signatureEnhancement2 = signatureEnhancement;
                boolean bl4 = false;
                LazyJavaResolverContext lazyJavaResolverContext = ContextKt.copyWithNewDefaultTypeQualifiers(methodContext, it.getAnnotations());
                signatureEnhancement = signatureEnhancement2;
                callableMemberDescriptor = callableMemberDescriptor2;
                annotated = annotated2;
                bl2 = bl3;
                LazyJavaResolverContext lazyJavaResolverContext2 = lazyJavaResolverContext;
                object = lazyJavaResolverContext2;
                if (lazyJavaResolverContext2 != null) break block3;
            }
            object = methodContext;
        }
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, bl2, (LazyJavaResolverContext)object, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, predefined, ignoreDeclarationNullabilityAnnotations, collector);
    }

    /*
     * WARNING - void declaration
     */
    private final KotlinType enhance(CallableMemberDescriptor $this$enhance, Annotated typeContainer, boolean isCovariant, LazyJavaResolverContext containerContext, AnnotationQualifierApplicabilityType containerApplicabilityType, TypeEnhancementInfo predefined, boolean ignoreDeclarationNullabilityAnnotations, Function1<? super CallableMemberDescriptor, ? extends KotlinType> collector) {
        Collection<KotlinType> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        SignatureParts signatureParts = new SignatureParts(typeContainer, isCovariant, containerContext, containerApplicabilityType, false, 16, null);
        Collection<? extends CallableMemberDescriptor> collection2 = $this$enhance.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection2, "getOverriddenDescriptors(...)");
        Iterable iterable = collection2;
        KotlinType kotlinType = collector.invoke($this$enhance);
        SignatureParts signatureParts2 = signatureParts;
        SignatureEnhancement signatureEnhancement = this;
        boolean $i$f$map = false;
        void var11_14 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            collection.add(collector.invoke((CallableMemberDescriptor)it));
        }
        collection = (List)destination$iv$iv;
        return signatureEnhancement.enhance(signatureParts2, kotlinType, (List<? extends KotlinType>)collection, predefined, ignoreDeclarationNullabilityAnnotations);
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean bl2, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean bl3, Function1 function1, int n2, Object object) {
        if ((n2 & 0x20) != 0) {
            bl3 = false;
        }
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, bl2, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, bl3, function1);
    }

    private final KotlinType enhance(SignatureParts $this$enhance, KotlinType type, List<? extends KotlinType> overrides, TypeEnhancementInfo predefined, boolean ignoreDeclarationNullabilityAnnotations) {
        JavaTypeEnhancement $this$enhance_u24lambda_u2419 = this.typeEnhancement;
        boolean bl2 = false;
        return $this$enhance_u24lambda_u2419.enhance(type, $this$enhance.computeIndexedQualifiers(type, (Iterable<KotlinTypeMarker>)overrides, predefined, ignoreDeclarationNullabilityAnnotations), $this$enhance.getSkipRawTypeArguments());
    }

    static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            typeEnhancementInfo = null;
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo, bl2);
    }

    private static final KotlinType enhanceSignature$lambda$2(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ReceiverParameterDescriptor receiverParameterDescriptor = it.getExtensionReceiverParameter();
        Intrinsics.checkNotNull(receiverParameterDescriptor);
        KotlinType kotlinType = receiverParameterDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return kotlinType;
    }

    private static final KotlinType enhanceSignature$lambda$9$lambda$8(ValueParameterDescriptor $p, CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType kotlinType = it.getValueParameters().get($p.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        return kotlinType;
    }

    private static final KotlinType enhanceSignature$lambda$10(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType kotlinType = it.getReturnType();
        Intrinsics.checkNotNull(kotlinType);
        return kotlinType;
    }

    private static final boolean enhanceTypeParameterBounds$lambda$15$lambda$14(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof RawType;
    }

    private static final Boolean containsFunctionN$lambda$16(UnwrappedType it) {
        ClassifierDescriptor classifierDescriptor = it.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return false;
        }
        ClassifierDescriptor classifier = classifierDescriptor;
        return Intrinsics.areEqual(classifier.getName(), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(classifier), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME());
    }

    static /* synthetic */ KotlinType accessor$SignatureEnhancement$lambda0(CallableMemberDescriptor callableMemberDescriptor) {
        return SignatureEnhancement.enhanceSignature$lambda$2(callableMemberDescriptor);
    }

    static /* synthetic */ KotlinType accessor$SignatureEnhancement$lambda1(ValueParameterDescriptor valueParameterDescriptor, CallableMemberDescriptor callableMemberDescriptor) {
        return SignatureEnhancement.enhanceSignature$lambda$9$lambda$8(valueParameterDescriptor, callableMemberDescriptor);
    }

    static /* synthetic */ KotlinType accessor$SignatureEnhancement$lambda2(CallableMemberDescriptor callableMemberDescriptor) {
        return SignatureEnhancement.enhanceSignature$lambda$10(callableMemberDescriptor);
    }

    static /* synthetic */ boolean accessor$SignatureEnhancement$lambda3(UnwrappedType unwrappedType) {
        return SignatureEnhancement.enhanceTypeParameterBounds$lambda$15$lambda$14(unwrappedType);
    }

    static /* synthetic */ Boolean accessor$SignatureEnhancement$lambda4(UnwrappedType unwrappedType) {
        return SignatureEnhancement.containsFunctionN$lambda$16(unwrappedType);
    }
}


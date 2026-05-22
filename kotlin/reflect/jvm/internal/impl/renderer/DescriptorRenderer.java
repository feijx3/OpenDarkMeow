/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$10;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$8;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$9;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DescriptorRenderer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final DescriptorRenderer WITHOUT_MODIFIERS = Companion.withOptions(DescriptorRenderer$$Lambda$0.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS = Companion.withOptions(DescriptorRenderer$$Lambda$1.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT = Companion.withOptions(DescriptorRenderer$$Lambda$2.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES = Companion.withOptions(DescriptorRenderer$$Lambda$3.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES = Companion.withOptions(DescriptorRenderer$$Lambda$4.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES = Companion.withOptions(DescriptorRenderer$$Lambda$5.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES = Companion.withOptions(DescriptorRenderer$$Lambda$6.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = Companion.withOptions(DescriptorRenderer$$Lambda$7.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES = Companion.withOptions(DescriptorRenderer$$Lambda$8.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer DEBUG_TEXT = Companion.withOptions(DescriptorRenderer$$Lambda$9.INSTANCE);
    @JvmField
    @NotNull
    public static final DescriptorRenderer HTML = Companion.withOptions(DescriptorRenderer$$Lambda$10.INSTANCE);

    @NotNull
    public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
        Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl options = ((DescriptorRendererImpl)this).getOptions().copy();
        changeOptions.invoke(options);
        options.lock();
        return new DescriptorRendererImpl(options);
    }

    @NotNull
    public abstract String renderType(@NotNull KotlinType var1);

    @NotNull
    public abstract String renderFlexibleType(@NotNull String var1, @NotNull String var2, @NotNull KotlinBuiltIns var3);

    @NotNull
    public abstract String renderTypeProjection(@NotNull TypeProjection var1);

    @NotNull
    public abstract String renderAnnotation(@NotNull AnnotationDescriptor var1, @Nullable AnnotationUseSiteTarget var2);

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((n2 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
    }

    @NotNull
    public abstract String render(@NotNull DeclarationDescriptor var1);

    @NotNull
    public abstract String renderName(@NotNull Name var1, boolean var2);

    @NotNull
    public abstract String renderFqName(@NotNull FqNameUnsafe var1);

    private static final Unit WITHOUT_MODIFIERS$lambda$0(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITH_MODIFIERS$lambda$1(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setWithDefinedIn(false);
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT$lambda$2(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setWithDefinedIn(false);
        $this$withOptions.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITHOUT_SUPERTYPES$lambda$3(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setWithDefinedIn(false);
        $this$withOptions.setModifiers(SetsKt.emptySet());
        $this$withOptions.setWithoutSuperTypes(true);
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITH_SHORT_TYPES$lambda$4(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setModifiers(SetsKt.emptySet());
        $this$withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        $this$withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    private static final Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setWithDefinedIn(false);
        $this$withOptions.setModifiers(SetsKt.emptySet());
        $this$withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        $this$withOptions.setWithoutTypeParameters(true);
        $this$withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
        $this$withOptions.setReceiverAfterName(true);
        $this$withOptions.setRenderCompanionObjectName(true);
        $this$withOptions.setWithoutSuperTypes(true);
        $this$withOptions.setStartFromName(true);
        return Unit.INSTANCE;
    }

    private static final Unit FQ_NAMES_IN_TYPES$lambda$6(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return Unit.INSTANCE;
    }

    private static final Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit SHORT_NAMES_IN_TYPES$lambda$8(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        $this$withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    private static final Unit DEBUG_TEXT$lambda$9(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setDebugMode(true);
        $this$withOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        $this$withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit HTML$lambda$10(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        $this$withOptions.setTextFormat(RenderingFormat.HTML);
        $this$withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda0(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.WITHOUT_MODIFIERS$lambda$0(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda1(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.COMPACT_WITH_MODIFIERS$lambda$1(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda2(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.COMPACT$lambda$2(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda3(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.COMPACT_WITHOUT_SUPERTYPES$lambda$3(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda4(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.COMPACT_WITH_SHORT_TYPES$lambda$4(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda5(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda6(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES$lambda$6(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda7(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda8(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.SHORT_NAMES_IN_TYPES$lambda$8(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda9(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.DEBUG_TEXT$lambda$9(descriptorRendererOptions);
    }

    static /* synthetic */ Unit accessor$DescriptorRenderer$lambda10(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRenderer.HTML$lambda$10(descriptorRendererOptions);
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
            Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
            DescriptorRendererOptionsImpl options = new DescriptorRendererOptionsImpl();
            changeOptions.invoke(options);
            options.lock();
            return new DescriptorRendererImpl(options);
        }

        @NotNull
        public final String getClassifierKindPrefix(@NotNull ClassifierDescriptorWithTypeParameters classifier) {
            String string;
            block9: {
                block10: {
                    block11: {
                        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters;
                        block8: {
                            Intrinsics.checkNotNullParameter(classifier, "classifier");
                            classifierDescriptorWithTypeParameters = classifier;
                            if (!(classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor)) break block8;
                            string = "typealias";
                            break block9;
                        }
                        if (!(classifierDescriptorWithTypeParameters instanceof ClassDescriptor)) break block10;
                        if (!((ClassDescriptor)classifier).isCompanionObject()) break block11;
                        string = "companion object";
                        break block9;
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[((ClassDescriptor)classifier).getKind().ordinal()]) {
                        case 1: {
                            string = "class";
                            break block9;
                        }
                        case 2: {
                            string = "interface";
                            break block9;
                        }
                        case 3: {
                            string = "enum class";
                            break block9;
                        }
                        case 4: {
                            string = "object";
                            break block9;
                        }
                        case 5: {
                            string = "annotation class";
                            break block9;
                        }
                        case 6: {
                            string = "enum entry";
                            break block9;
                        }
                        default: {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                throw new AssertionError((Object)("Unexpected classifier: " + classifier));
            }
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[ClassKind.values().length];
                try {
                    nArray[ClassKind.CLASS.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ClassKind.INTERFACE.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ClassKind.ENUM_CLASS.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ClassKind.OBJECT.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    public static interface ValueParametersHandler {
        public void appendBeforeValueParameters(int var1, @NotNull StringBuilder var2);

        public void appendAfterValueParameters(int var1, @NotNull StringBuilder var2);

        public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor var1, int var2, int var3, @NotNull StringBuilder var4);

        public void appendAfterValueParameter(@NotNull ValueParameterDescriptor var1, int var2, int var3, @NotNull StringBuilder var4);

        public static final class DEFAULT
        implements ValueParametersHandler {
            @NotNull
            public static final DEFAULT INSTANCE = new DEFAULT();

            private DEFAULT() {
            }

            @Override
            public void appendBeforeValueParameters(int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append("(");
            }

            @Override
            public void appendAfterValueParameters(int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append(")");
            }

            @Override
            public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor parameter, int parameterIndex, int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                Intrinsics.checkNotNullParameter(builder, "builder");
            }

            @Override
            public void appendAfterValueParameter(@NotNull ValueParameterDescriptor parameter, int parameterIndex, int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                Intrinsics.checkNotNullParameter(builder, "builder");
                if (parameterIndex != parameterCount - 1) {
                    builder.append(", ");
                }
            }
        }
    }
}


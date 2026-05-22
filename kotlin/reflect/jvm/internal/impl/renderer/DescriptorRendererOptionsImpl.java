/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.renderer.ExcludedTypeAnnotations;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDescriptorRendererOptionsImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRendererOptionsImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererOptionsImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Delegates.kt\nkotlin/properties/Delegates\n*L\n1#1,137:1\n1#2:138\n51#3,3:139\n*S KotlinDebug\n*F\n+ 1 DescriptorRendererOptionsImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererOptionsImpl\n*L\n60#1:139,3\n*E\n"})
public final class DescriptorRendererOptionsImpl
implements DescriptorRendererOptions {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private boolean isLocked;
    @NotNull
    private final ReadWriteProperty classifierNamePolicy$delegate = this.property(ClassifierNamePolicy.SOURCE_CODE_QUALIFIED.INSTANCE);
    @NotNull
    private final ReadWriteProperty withDefinedIn$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty withSourceFileForTopLevel$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty modifiers$delegate = this.property(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
    @NotNull
    private final ReadWriteProperty startFromName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty startFromDeclarationKeyword$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty debugMode$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty classWithPrimaryConstructor$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty verbose$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty unitReturnType$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty withoutReturnType$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty enhancedTypes$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty normalizedVisibilities$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderDefaultVisibility$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty renderDefaultModality$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty renderConstructorDelegation$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderPrimaryConstructorParametersAsProperties$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty actualPropertiesInPrimaryConstructor$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty uninferredTypeParameterAsName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty includePropertyConstant$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty propertyConstantRenderer$delegate = this.property(null);
    @NotNull
    private final ReadWriteProperty withoutTypeParameters$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty withoutSuperTypes$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty typeNormalizer$delegate = this.property(DescriptorRendererOptionsImpl$$Lambda$0.INSTANCE);
    @NotNull
    private final ReadWriteProperty defaultParameterValueRenderer$delegate = this.property(DescriptorRendererOptionsImpl$$Lambda$1.INSTANCE);
    @NotNull
    private final ReadWriteProperty secondaryConstructorsAsPrimary$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty overrideRenderingPolicy$delegate = this.property(OverrideRenderingPolicy.RENDER_OPEN);
    @NotNull
    private final ReadWriteProperty valueParametersHandler$delegate = this.property(DescriptorRenderer.ValueParametersHandler.DEFAULT.INSTANCE);
    @NotNull
    private final ReadWriteProperty textFormat$delegate = this.property(RenderingFormat.PLAIN);
    @NotNull
    private final ReadWriteProperty parameterNameRenderingPolicy$delegate = this.property(ParameterNameRenderingPolicy.ALL);
    @NotNull
    private final ReadWriteProperty receiverAfterName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderCompanionObjectName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty propertyAccessorRenderingPolicy$delegate = this.property(PropertyAccessorRenderingPolicy.DEBUG);
    @NotNull
    private final ReadWriteProperty renderDefaultAnnotationArguments$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty eachAnnotationOnNewLine$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty excludedAnnotationClasses$delegate = this.property(SetsKt.emptySet());
    @NotNull
    private final ReadWriteProperty excludedTypeAnnotationClasses$delegate = this.property(ExcludedTypeAnnotations.INSTANCE.getInternalAnnotationsForResolve());
    @NotNull
    private final ReadWriteProperty annotationFilter$delegate = this.property(null);
    @NotNull
    private final ReadWriteProperty annotationArgumentsRenderingPolicy$delegate = this.property(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
    @NotNull
    private final ReadWriteProperty alwaysRenderModifiers$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderConstructorKeyword$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty renderUnabbreviatedType$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty renderTypeExpansions$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderAbbreviatedTypeComments$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty includeAdditionalModifiers$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty parameterNamesInFunctionalTypes$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty renderFunctionContracts$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty presentableUnresolvedTypes$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty boldOnlyForNamesInHtml$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty informativeErrorType$delegate = this.property(true);

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final void lock() {
        boolean bl2;
        boolean bl3 = bl2 = !this.isLocked;
        if (_Assertions.ENABLED && !bl2) {
            String string = "Assertion failed";
            throw new AssertionError((Object)string);
        }
        this.isLocked = true;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final DescriptorRendererOptionsImpl copy() {
        DescriptorRendererOptionsImpl copy = new DescriptorRendererOptionsImpl();
        Iterator<Field> iterator2 = ArrayIteratorKt.iterator(this.getClass().getDeclaredFields());
        while (iterator2.hasNext()) {
            Object object;
            boolean bl2;
            ObservableProperty property;
            Field field = iterator2.next();
            if ((field.getModifiers() & 8) != 0) continue;
            field.setAccessible(true);
            Object object2 = field.get(this);
            if ((object2 instanceof ObservableProperty ? (ObservableProperty)object2 : null) == null) continue;
            property = property;
            String string = field.getName();
            Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
            boolean bl3 = bl2 = !StringsKt.startsWith$default(string, "is", false, 2, null);
            if (_Assertions.ENABLED && !bl2) {
                boolean bl4 = false;
                String string2 = "Fields named is* are not supported here yet";
                throw new AssertionError((Object)string2);
            }
            ObservableProperty observableProperty = property;
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this;
            KDeclarationContainer kDeclarationContainer = Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class);
            String string3 = field.getName();
            StringBuilder stringBuilder = new StringBuilder().append("get");
            String string4 = field.getName();
            Intrinsics.checkNotNullExpressionValue(string4, "getName(...)");
            object2 = string4;
            if (((CharSequence)object2).length() > 0) {
                void p0;
                char c2 = ((String)object2).charAt(0);
                StringBuilder stringBuilder2 = stringBuilder;
                String string5 = string3;
                KDeclarationContainer kDeclarationContainer2 = kDeclarationContainer;
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = descriptorRendererOptionsImpl;
                ObservableProperty observableProperty2 = observableProperty;
                boolean bl5 = false;
                char c3 = Character.toUpperCase((char)p0);
                observableProperty = observableProperty2;
                descriptorRendererOptionsImpl = descriptorRendererOptionsImpl2;
                kDeclarationContainer = kDeclarationContainer2;
                string3 = string5;
                stringBuilder = stringBuilder2;
                c2 = c3;
                Object object3 = object2;
                int n2 = 1;
                String string6 = ((String)object3).substring(n2);
                Intrinsics.checkNotNullExpressionValue(string6, "substring(...)");
                object3 = string6;
                object = c2 + (String)object3;
            } else {
                object = object2;
            }
            String string7 = stringBuilder.append((String)object).toString();
            String string8 = string3;
            KDeclarationContainer kDeclarationContainer3 = kDeclarationContainer;
            Object value = observableProperty.getValue(descriptorRendererOptionsImpl, (KProperty<?>)new PropertyReference1Impl(kDeclarationContainer3, string8, string7));
            field.set(copy, copy.property(value));
        }
        return copy;
    }

    private final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> property(T initialValue) {
        Delegates this_$iv = Delegates.INSTANCE;
        boolean $i$f$vetoable = false;
        return new ObservableProperty<T>(initialValue, this){
            final /* synthetic */ DescriptorRendererOptionsImpl this$0;
            {
                this.this$0 = descriptorRendererOptionsImpl;
                super($initialValue);
            }

            protected boolean beforeChange(KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                boolean bl2 = false;
                if (this.this$0.isLocked()) {
                    throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
                }
                return true;
            }
        };
    }

    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return (ClassifierNamePolicy)this.classifierNamePolicy$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.classifierNamePolicy$delegate.setValue(this, $$delegatedProperties[0], classifierNamePolicy);
    }

    public boolean getWithDefinedIn() {
        return (Boolean)this.withDefinedIn$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override
    public void setWithDefinedIn(boolean bl2) {
        this.withDefinedIn$delegate.setValue(this, $$delegatedProperties[1], bl2);
    }

    public boolean getWithSourceFileForTopLevel() {
        return (Boolean)this.withSourceFileForTopLevel$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return (Set)this.modifiers$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @Override
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.modifiers$delegate.setValue(this, $$delegatedProperties[3], set);
    }

    public boolean getStartFromName() {
        return (Boolean)this.startFromName$delegate.getValue(this, $$delegatedProperties[4]);
    }

    @Override
    public void setStartFromName(boolean bl2) {
        this.startFromName$delegate.setValue(this, $$delegatedProperties[4], bl2);
    }

    public boolean getStartFromDeclarationKeyword() {
        return (Boolean)this.startFromDeclarationKeyword$delegate.getValue(this, $$delegatedProperties[5]);
    }

    @Override
    public boolean getDebugMode() {
        return (Boolean)this.debugMode$delegate.getValue(this, $$delegatedProperties[6]);
    }

    @Override
    public void setDebugMode(boolean bl2) {
        this.debugMode$delegate.setValue(this, $$delegatedProperties[6], bl2);
    }

    public boolean getClassWithPrimaryConstructor() {
        return (Boolean)this.classWithPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public boolean getVerbose() {
        return (Boolean)this.verbose$delegate.getValue(this, $$delegatedProperties[8]);
    }

    @Override
    public void setVerbose(boolean bl2) {
        this.verbose$delegate.setValue(this, $$delegatedProperties[8], bl2);
    }

    public boolean getUnitReturnType() {
        return (Boolean)this.unitReturnType$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public boolean getWithoutReturnType() {
        return (Boolean)this.withoutReturnType$delegate.getValue(this, $$delegatedProperties[10]);
    }

    @Override
    public boolean getEnhancedTypes() {
        return (Boolean)this.enhancedTypes$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public boolean getNormalizedVisibilities() {
        return (Boolean)this.normalizedVisibilities$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public boolean getRenderDefaultVisibility() {
        return (Boolean)this.renderDefaultVisibility$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public boolean getRenderDefaultModality() {
        return (Boolean)this.renderDefaultModality$delegate.getValue(this, $$delegatedProperties[14]);
    }

    public boolean getRenderConstructorDelegation() {
        return (Boolean)this.renderConstructorDelegation$delegate.getValue(this, $$delegatedProperties[15]);
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return (Boolean)this.renderPrimaryConstructorParametersAsProperties$delegate.getValue(this, $$delegatedProperties[16]);
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return (Boolean)this.actualPropertiesInPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[17]);
    }

    public boolean getUninferredTypeParameterAsName() {
        return (Boolean)this.uninferredTypeParameterAsName$delegate.getValue(this, $$delegatedProperties[18]);
    }

    public boolean getIncludePropertyConstant() {
        return (Boolean)this.includePropertyConstant$delegate.getValue(this, $$delegatedProperties[19]);
    }

    @Nullable
    public Function1<ConstantValue<?>, String> getPropertyConstantRenderer() {
        return (Function1)this.propertyConstantRenderer$delegate.getValue(this, $$delegatedProperties[20]);
    }

    public boolean getWithoutTypeParameters() {
        return (Boolean)this.withoutTypeParameters$delegate.getValue(this, $$delegatedProperties[21]);
    }

    @Override
    public void setWithoutTypeParameters(boolean bl2) {
        this.withoutTypeParameters$delegate.setValue(this, $$delegatedProperties[21], bl2);
    }

    public boolean getWithoutSuperTypes() {
        return (Boolean)this.withoutSuperTypes$delegate.getValue(this, $$delegatedProperties[22]);
    }

    @Override
    public void setWithoutSuperTypes(boolean bl2) {
        this.withoutSuperTypes$delegate.setValue(this, $$delegatedProperties[22], bl2);
    }

    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return (Function1)this.typeNormalizer$delegate.getValue(this, $$delegatedProperties[23]);
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return (Function1)this.defaultParameterValueRenderer$delegate.getValue(this, $$delegatedProperties[24]);
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return (Boolean)this.secondaryConstructorsAsPrimary$delegate.getValue(this, $$delegatedProperties[25]);
    }

    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return (OverrideRenderingPolicy)((Object)this.overrideRenderingPolicy$delegate.getValue(this, $$delegatedProperties[26]));
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return (DescriptorRenderer.ValueParametersHandler)this.valueParametersHandler$delegate.getValue(this, $$delegatedProperties[27]);
    }

    @NotNull
    public RenderingFormat getTextFormat() {
        return (RenderingFormat)((Object)this.textFormat$delegate.getValue(this, $$delegatedProperties[28]));
    }

    @Override
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter((Object)renderingFormat, "<set-?>");
        this.textFormat$delegate.setValue(this, $$delegatedProperties[28], renderingFormat);
    }

    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return (ParameterNameRenderingPolicy)((Object)this.parameterNameRenderingPolicy$delegate.getValue(this, $$delegatedProperties[29]));
    }

    @Override
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter((Object)parameterNameRenderingPolicy, "<set-?>");
        this.parameterNameRenderingPolicy$delegate.setValue(this, $$delegatedProperties[29], parameterNameRenderingPolicy);
    }

    public boolean getReceiverAfterName() {
        return (Boolean)this.receiverAfterName$delegate.getValue(this, $$delegatedProperties[30]);
    }

    @Override
    public void setReceiverAfterName(boolean bl2) {
        this.receiverAfterName$delegate.setValue(this, $$delegatedProperties[30], bl2);
    }

    public boolean getRenderCompanionObjectName() {
        return (Boolean)this.renderCompanionObjectName$delegate.getValue(this, $$delegatedProperties[31]);
    }

    @Override
    public void setRenderCompanionObjectName(boolean bl2) {
        this.renderCompanionObjectName$delegate.setValue(this, $$delegatedProperties[31], bl2);
    }

    @NotNull
    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return (PropertyAccessorRenderingPolicy)((Object)this.propertyAccessorRenderingPolicy$delegate.getValue(this, $$delegatedProperties[32]));
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return (Boolean)this.renderDefaultAnnotationArguments$delegate.getValue(this, $$delegatedProperties[33]);
    }

    public boolean getEachAnnotationOnNewLine() {
        return (Boolean)this.eachAnnotationOnNewLine$delegate.getValue(this, $$delegatedProperties[34]);
    }

    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return (Set)this.excludedAnnotationClasses$delegate.getValue(this, $$delegatedProperties[35]);
    }

    @Override
    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set)this.excludedTypeAnnotationClasses$delegate.getValue(this, $$delegatedProperties[36]);
    }

    @Override
    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.excludedTypeAnnotationClasses$delegate.setValue(this, $$delegatedProperties[36], set);
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return (Function1)this.annotationFilter$delegate.getValue(this, $$delegatedProperties[37]);
    }

    @Override
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (AnnotationArgumentsRenderingPolicy)((Object)this.annotationArgumentsRenderingPolicy$delegate.getValue(this, $$delegatedProperties[38]));
    }

    @Override
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter((Object)annotationArgumentsRenderingPolicy, "<set-?>");
        this.annotationArgumentsRenderingPolicy$delegate.setValue(this, $$delegatedProperties[38], annotationArgumentsRenderingPolicy);
    }

    public boolean getAlwaysRenderModifiers() {
        return (Boolean)this.alwaysRenderModifiers$delegate.getValue(this, $$delegatedProperties[39]);
    }

    public boolean getRenderConstructorKeyword() {
        return (Boolean)this.renderConstructorKeyword$delegate.getValue(this, $$delegatedProperties[40]);
    }

    public boolean getRenderUnabbreviatedType() {
        return (Boolean)this.renderUnabbreviatedType$delegate.getValue(this, $$delegatedProperties[41]);
    }

    public boolean getRenderTypeExpansions() {
        return (Boolean)this.renderTypeExpansions$delegate.getValue(this, $$delegatedProperties[42]);
    }

    public boolean getRenderAbbreviatedTypeComments() {
        return (Boolean)this.renderAbbreviatedTypeComments$delegate.getValue(this, $$delegatedProperties[43]);
    }

    public boolean getIncludeAdditionalModifiers() {
        return (Boolean)this.includeAdditionalModifiers$delegate.getValue(this, $$delegatedProperties[44]);
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return (Boolean)this.parameterNamesInFunctionalTypes$delegate.getValue(this, $$delegatedProperties[45]);
    }

    public boolean getPresentableUnresolvedTypes() {
        return (Boolean)this.presentableUnresolvedTypes$delegate.getValue(this, $$delegatedProperties[47]);
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return (Boolean)this.boldOnlyForNamesInHtml$delegate.getValue(this, $$delegatedProperties[48]);
    }

    public boolean getInformativeErrorType() {
        return (Boolean)this.informativeErrorType$delegate.getValue(this, $$delegatedProperties[49]);
    }

    public boolean getIncludeAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeEmptyAnnotationArguments(this);
    }

    private static final KotlinType typeNormalizer_delegate$lambda$2(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    private static final String defaultParameterValueRenderer_delegate$lambda$3(ValueParameterDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "...";
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "withDefinedIn", "getWithDefinedIn()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "modifiers", "getModifiers()Ljava/util/Set;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "startFromName", "getStartFromName()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "debugMode", "getDebugMode()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "verbose", "getVerbose()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "unitReturnType", "getUnitReturnType()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "withoutReturnType", "getWithoutReturnType()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "enhancedTypes", "getEnhancedTypes()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "normalizedVisibilities", "getNormalizedVisibilities()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderDefaultVisibility", "getRenderDefaultVisibility()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderDefaultModality", "getRenderDefaultModality()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderConstructorDelegation", "getRenderConstructorDelegation()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "includePropertyConstant", "getIncludePropertyConstant()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "withoutTypeParameters", "getWithoutTypeParameters()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "withoutSuperTypes", "getWithoutSuperTypes()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "receiverAfterName", "getReceiverAfterName()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderCompanionObjectName", "getRenderCompanionObjectName()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderConstructorKeyword", "getRenderConstructorKeyword()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderTypeExpansions", "getRenderTypeExpansions()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "renderFunctionContracts", "getRenderFunctionContracts()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DescriptorRendererOptionsImpl.class, "informativeErrorType", "getInformativeErrorType()Z", 0))};
        $$delegatedProperties = kPropertyArray;
    }

    static /* synthetic */ KotlinType accessor$DescriptorRendererOptionsImpl$lambda0(KotlinType kotlinType) {
        return DescriptorRendererOptionsImpl.typeNormalizer_delegate$lambda$2(kotlinType);
    }

    static /* synthetic */ String accessor$DescriptorRendererOptionsImpl$lambda1(ValueParameterDescriptor valueParameterDescriptor) {
        return DescriptorRendererOptionsImpl.defaultParameterValueRenderer_delegate$lambda$3(valueParameterDescriptor);
    }
}


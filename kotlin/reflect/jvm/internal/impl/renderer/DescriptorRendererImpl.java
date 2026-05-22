/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDescriptorRendererImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRendererImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1225:1\n152#1,10:1226\n152#1,10:1236\n2746#2,3:1246\n774#2:1249\n865#2,2:1250\n1563#2:1252\n1634#2,3:1253\n774#2:1256\n865#2,2:1257\n1563#2:1259\n1634#2,3:1260\n1563#2:1263\n1634#2,3:1264\n1617#2,9:1268\n1869#2:1277\n1870#2:1279\n1626#2:1280\n2746#2,3:1281\n2746#2,3:1284\n774#2:1287\n865#2,2:1288\n1634#2,3:1290\n1#3:1267\n1#3:1278\n*S KotlinDebug\n*F\n+ 1 DescriptorRendererImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererImpl\n*L\n138#1:1226,10\n145#1:1236,10\n200#1:1246,3\n501#1:1249\n501#1:1250,2\n502#1:1252\n502#1:1253,3\n504#1:1256\n504#1:1257,2\n504#1:1259\n504#1:1260,3\n506#1:1263\n506#1:1264,3\n515#1:1268,9\n515#1:1277\n515#1:1279\n515#1:1280\n606#1:1281,3\n608#1:1284,3\n824#1:1287\n824#1:1288,2\n847#1:1290,3\n515#1:1278\n*E\n"})
public final class DescriptorRendererImpl
extends DescriptorRenderer
implements DescriptorRendererOptions {
    @NotNull
    private final DescriptorRendererOptionsImpl options;
    @NotNull
    private final Lazy functionTypeAnnotationsRenderer$delegate;

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        boolean bl2 = this.options.isLocked();
        if (_Assertions.ENABLED && !bl2) {
            String string = "Assertion failed";
            throw new AssertionError((Object)string);
        }
        DescriptorRendererImpl descriptorRendererImpl = this;
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new DescriptorRendererImpl$$Lambda$0(descriptorRendererImpl));
    }

    @NotNull
    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        Lazy lazy = this.functionTypeAnnotationsRenderer$delegate;
        return (DescriptorRendererImpl)lazy.getValue();
    }

    private final String renderKeyword(String keyword) {
        String string;
        switch (WhenMappings.$EnumSwitchMapping$0[this.getTextFormat().ordinal()]) {
            case 1: {
                string = keyword;
                break;
            }
            case 2: {
                if (this.getBoldOnlyForNamesInHtml()) {
                    string = keyword;
                    break;
                }
                string = "<b>" + keyword + "</b>";
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return string;
    }

    private final String renderError(String keyword) {
        String string;
        switch (WhenMappings.$EnumSwitchMapping$0[this.getTextFormat().ordinal()]) {
            case 1: {
                string = keyword;
                break;
            }
            case 2: {
                string = "<font color=red><b>" + keyword + "</b></font>";
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return string;
    }

    private final String escape(String string) {
        return this.getTextFormat().escape(string);
    }

    private final String lt() {
        return this.escape("<");
    }

    private final String gt() {
        return this.escape(">");
    }

    private final String arrow() {
        String string;
        switch (WhenMappings.$EnumSwitchMapping$0[this.getTextFormat().ordinal()]) {
            case 1: {
                string = this.escape("->");
                break;
            }
            case 2: {
                string = "&rarr;";
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return string;
    }

    @NotNull
    public String renderMessage(@NotNull String message) {
        String string;
        Intrinsics.checkNotNullParameter(message, "message");
        switch (WhenMappings.$EnumSwitchMapping$0[this.getTextFormat().ordinal()]) {
            case 1: {
                string = message;
                break;
            }
            case 2: {
                string = "<i>" + message + "</i>";
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return string;
    }

    @Override
    @NotNull
    public String renderName(@NotNull Name name, boolean rootRenderedElement) {
        Intrinsics.checkNotNullParameter(name, "name");
        String escaped = this.escape(RenderingUtilsKt.render(name));
        return this.getBoldOnlyForNamesInHtml() && this.getTextFormat() == RenderingFormat.HTML && rootRenderedElement ? "<b>" + escaped + "</b>" : escaped;
    }

    private final void renderName(DeclarationDescriptor descriptor2, StringBuilder builder, boolean rootRenderedElement) {
        Name name = descriptor2.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        builder.append(this.renderName(name, rootRenderedElement));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor descriptor2, StringBuilder builder) {
        if (this.getRenderCompanionObjectName()) {
            if (this.getStartFromName()) {
                builder.append("companion object");
            }
            this.renderSpaceIfNeeded(builder);
            DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
            if (containingDeclaration != null) {
                builder.append("of ");
                Name name = containingDeclaration.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                builder.append(this.renderName(name, false));
            }
        }
        if (this.getVerbose() || !Intrinsics.areEqual(descriptor2.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!this.getStartFromName()) {
                this.renderSpaceIfNeeded(builder);
            }
            Name name = descriptor2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            builder.append(this.renderName(name, true));
        }
    }

    @Override
    @NotNull
    public String renderFqName(@NotNull FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.renderFqName(fqName.pathSegments());
    }

    private final String renderFqName(List<Name> pathSegments) {
        return this.escape(RenderingUtilsKt.renderFqName(pathSegments));
    }

    @NotNull
    public String renderClassifierName(@NotNull ClassifierDescriptor klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        return ErrorUtils.isError(klass) ? klass.getTypeConstructor().toString() : this.getClassifierNamePolicy().renderClassifier(klass, this);
    }

    @Override
    @NotNull
    public String renderType(@NotNull KotlinType type) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(type, "type");
        StringBuilder $this$renderType_u24lambda_u242 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        this.renderNormalizedType($this$renderType_u24lambda_u242, this.getTypeNormalizer().invoke(type));
        return stringBuilder.toString();
    }

    private final void renderNormalizedType(StringBuilder $this$renderNormalizedType, KotlinType type) {
        AbbreviatedType abbreviated;
        UnwrappedType unwrappedType = type.unwrap();
        AbbreviatedType abbreviatedType = abbreviated = unwrappedType instanceof AbbreviatedType ? (AbbreviatedType)unwrappedType : null;
        if (abbreviated != null) {
            if (this.getRenderTypeExpansions()) {
                this.renderNormalizedTypeAsIs($this$renderNormalizedType, abbreviated.getExpandedType());
                if (this.getRenderAbbreviatedTypeComments()) {
                    this.renderAbbreviatedTypeComment($this$renderNormalizedType, abbreviated);
                }
            } else {
                this.renderNormalizedTypeAsIs($this$renderNormalizedType, abbreviated.getAbbreviation());
                if (this.getRenderUnabbreviatedType()) {
                    this.renderExpandedTypeComment($this$renderNormalizedType, abbreviated);
                }
            }
            return;
        }
        this.renderNormalizedTypeAsIs($this$renderNormalizedType, type);
    }

    /*
     * WARNING - void declaration
     */
    private final void renderAbbreviatedTypeComment(StringBuilder $this$renderAbbreviatedTypeComment, AbbreviatedType abbreviated) {
        void this_$iv;
        DescriptorRendererImpl descriptorRendererImpl = this;
        StringBuilder $this$renderInBlockComment$iv = $this$renderAbbreviatedTypeComment;
        boolean $i$f$renderInBlockComment = false;
        if (this_$iv.getTextFormat() == RenderingFormat.HTML) {
            $this$renderInBlockComment$iv.append("<font color=\"808080\"><i>");
        }
        $this$renderInBlockComment$iv.append(" /* ");
        boolean bl2 = false;
        $this$renderAbbreviatedTypeComment.append("from: ");
        this.renderNormalizedTypeAsIs($this$renderAbbreviatedTypeComment, abbreviated.getAbbreviation());
        $this$renderInBlockComment$iv.append(" */");
        if (this_$iv.getTextFormat() == RenderingFormat.HTML) {
            $this$renderInBlockComment$iv.append("</i></font>");
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void renderExpandedTypeComment(StringBuilder $this$renderExpandedTypeComment, AbbreviatedType abbreviated) {
        void this_$iv;
        DescriptorRendererImpl descriptorRendererImpl = this;
        StringBuilder $this$renderInBlockComment$iv = $this$renderExpandedTypeComment;
        boolean $i$f$renderInBlockComment = false;
        if (this_$iv.getTextFormat() == RenderingFormat.HTML) {
            $this$renderInBlockComment$iv.append("<font color=\"808080\"><i>");
        }
        $this$renderInBlockComment$iv.append(" /* ");
        boolean bl2 = false;
        $this$renderExpandedTypeComment.append("= ");
        this.renderNormalizedTypeAsIs($this$renderExpandedTypeComment, abbreviated.getExpandedType());
        $this$renderInBlockComment$iv.append(" */");
        if (this_$iv.getTextFormat() == RenderingFormat.HTML) {
            $this$renderInBlockComment$iv.append("</i></font>");
        }
    }

    private final void renderNormalizedTypeAsIs(StringBuilder $this$renderNormalizedTypeAsIs, KotlinType type) {
        if (type instanceof WrappedType && this.getDebugMode() && !((WrappedType)type).isComputed()) {
            $this$renderNormalizedTypeAsIs.append("<Not computed yet>");
            return;
        }
        UnwrappedType unwrappedType = type.unwrap();
        if (unwrappedType instanceof FlexibleType) {
            $this$renderNormalizedTypeAsIs.append(((FlexibleType)unwrappedType).render(this, this));
        } else if (unwrappedType instanceof SimpleType) {
            this.renderSimpleType($this$renderNormalizedTypeAsIs, (SimpleType)unwrappedType);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void renderSimpleType(StringBuilder $this$renderSimpleType, SimpleType type) {
        if (Intrinsics.areEqual(type, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) || TypeUtils.isDontCarePlaceholder(type)) {
            $this$renderSimpleType.append("???");
            return;
        }
        if (ErrorUtils.isUninferredTypeVariable(type)) {
            StringBuilder stringBuilder;
            if (this.getUninferredTypeParameterAsName()) {
                TypeConstructor typeConstructor2 = type.getConstructor();
                Intrinsics.checkNotNull(typeConstructor2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                stringBuilder = $this$renderSimpleType.append(this.renderError(((ErrorTypeConstructor)typeConstructor2).getParam(0)));
            } else {
                stringBuilder = $this$renderSimpleType.append("???");
            }
            return;
        }
        if (KotlinTypeKt.isError(type)) {
            this.renderDefaultType($this$renderSimpleType, type);
            return;
        }
        if (this.shouldRenderAsPrettyFunctionType(type)) {
            this.renderFunctionType($this$renderSimpleType, type);
        } else {
            this.renderDefaultType($this$renderSimpleType, type);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean shouldRenderAsPrettyFunctionType(KotlinType type) {
        TypeProjection it;
        if (!FunctionTypesKt.isBuiltinFunctionalType(type)) return false;
        Iterable $this$none$iv = type.getArguments();
        boolean $i$f$none = false;
        if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
            return true;
        }
        Iterator iterator2 = $this$none$iv.iterator();
        do {
            if (!iterator2.hasNext()) return true;
            Object element$iv = iterator2.next();
            it = (TypeProjection)element$iv;
            boolean bl2 = false;
        } while (!it.isStarProjection());
        return false;
    }

    @Override
    @NotNull
    public String renderFlexibleType(@NotNull String lowerRendered, @NotNull String upperRendered, @NotNull KotlinBuiltIns builtIns) {
        String array;
        String mutableEntry;
        String simpleCollection;
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (RenderingUtilsKt.typeStringsDifferOnlyInNullability(lowerRendered, upperRendered)) {
            if (StringsKt.startsWith$default(upperRendered, "(", false, 2, null)) {
                return '(' + lowerRendered + ")!";
            }
            return lowerRendered + '!';
        }
        ClassifierNamePolicy classifierNamePolicy = this.getClassifierNamePolicy();
        ClassDescriptor classDescriptor = builtIns.getCollection();
        Intrinsics.checkNotNullExpressionValue(classDescriptor, "getCollection(...)");
        String kotlinCollectionsPrefix = StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(classDescriptor, this), "Collection", null, 2, null);
        String mutablePrefix = "Mutable";
        String string = simpleCollection = RenderingUtilsKt.replacePrefixesInTypeRepresentations(lowerRendered, kotlinCollectionsPrefix + mutablePrefix, upperRendered, kotlinCollectionsPrefix, kotlinCollectionsPrefix + '(' + mutablePrefix + ')');
        if (string != null) {
            return string;
        }
        String string2 = mutableEntry = RenderingUtilsKt.replacePrefixesInTypeRepresentations(lowerRendered, kotlinCollectionsPrefix + "MutableMap.MutableEntry", upperRendered, kotlinCollectionsPrefix + "Map.Entry", kotlinCollectionsPrefix + "(Mutable)Map.(Mutable)Entry");
        if (string2 != null) {
            return string2;
        }
        ClassifierNamePolicy classifierNamePolicy2 = this.getClassifierNamePolicy();
        ClassDescriptor classDescriptor2 = builtIns.getArray();
        Intrinsics.checkNotNullExpressionValue(classDescriptor2, "getArray(...)");
        String kotlinPrefix = StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(classDescriptor2, this), "Array", null, 2, null);
        String string3 = array = RenderingUtilsKt.replacePrefixesInTypeRepresentations(lowerRendered, kotlinPrefix + this.escape("Array<"), upperRendered, kotlinPrefix + this.escape("Array<out "), kotlinPrefix + this.escape("Array<(out) "));
        if (string3 != null) {
            return string3;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    @NotNull
    public String renderTypeArguments(@NotNull List<? extends TypeProjection> typeArguments) {
        String string;
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            string = "";
        } else {
            StringBuilder stringBuilder;
            StringBuilder $this$renderTypeArguments_u24lambda_u246 = stringBuilder = new StringBuilder();
            boolean bl2 = false;
            $this$renderTypeArguments_u24lambda_u246.append(this.lt());
            this.appendTypeProjections($this$renderTypeArguments_u24lambda_u246, typeArguments);
            $this$renderTypeArguments_u24lambda_u246.append(this.gt());
            string = stringBuilder.toString();
        }
        return string;
    }

    private final void renderDefaultType(StringBuilder $this$renderDefaultType, KotlinType type) {
        Object object;
        DescriptorRendererImpl.renderAnnotations$default(this, $this$renderDefaultType, type, null, 2, null);
        DefinitelyNotNullType definitelyNotNullType = type instanceof DefinitelyNotNullType ? (DefinitelyNotNullType)type : null;
        SimpleType originalTypeOfDefNotNullType = definitelyNotNullType != null ? definitelyNotNullType.getOriginal() : null;
        if (KotlinTypeKt.isError(type)) {
            if (TypeUtilsKt.isUnresolvedType(type) && this.getPresentableUnresolvedTypes()) {
                object = $this$renderDefaultType.append(this.renderError(ErrorUtils.INSTANCE.unresolvedTypeAsItIs(type)));
            } else {
                StringBuilder stringBuilder = type instanceof ErrorType && !this.getInformativeErrorType() ? $this$renderDefaultType.append(((ErrorType)type).getDebugMessage()) : $this$renderDefaultType.append(type.getConstructor().toString());
                object = $this$renderDefaultType.append(this.renderTypeArguments(type.getArguments()));
            }
        } else if (type instanceof StubTypeForBuilderInference) {
            object = $this$renderDefaultType.append(((StubTypeForBuilderInference)type).getOriginalTypeVariable().toString());
        } else if (originalTypeOfDefNotNullType instanceof StubTypeForBuilderInference) {
            object = $this$renderDefaultType.append(((StubTypeForBuilderInference)originalTypeOfDefNotNullType).getOriginalTypeVariable().toString());
        } else {
            DescriptorRendererImpl.renderTypeConstructorAndArguments$default(this, $this$renderDefaultType, type, null, 2, null);
            object = Unit.INSTANCE;
        }
        if (type.isMarkedNullable()) {
            $this$renderDefaultType.append("?");
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(type)) {
            $this$renderDefaultType.append(" & Any");
        }
    }

    private final void renderTypeConstructorAndArguments(StringBuilder $this$renderTypeConstructorAndArguments, KotlinType type, TypeConstructor typeConstructor2) {
        PossiblyInnerType possiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(type);
        if (possiblyInnerType == null) {
            $this$renderTypeConstructorAndArguments.append(this.renderTypeConstructor(typeConstructor2));
            $this$renderTypeConstructorAndArguments.append(this.renderTypeArguments(type.getArguments()));
            return;
        }
        this.renderPossiblyInnerType($this$renderTypeConstructorAndArguments, possiblyInnerType);
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder stringBuilder, KotlinType kotlinType, TypeConstructor typeConstructor2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            typeConstructor2 = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(stringBuilder, kotlinType, typeConstructor2);
    }

    private final void renderPossiblyInnerType(StringBuilder $this$renderPossiblyInnerType, PossiblyInnerType possiblyInnerType) {
        block3: {
            Object object;
            block2: {
                object = possiblyInnerType.getOuterType();
                if (object == null) break block2;
                PossiblyInnerType it = object;
                boolean bl2 = false;
                this.renderPossiblyInnerType($this$renderPossiblyInnerType, it);
                $this$renderPossiblyInnerType.append('.');
                Name name = possiblyInnerType.getClassifierDescriptor().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                StringBuilder stringBuilder = $this$renderPossiblyInnerType.append(this.renderName(name, false));
                object = stringBuilder;
                if (stringBuilder != null) break block3;
            }
            TypeConstructor typeConstructor2 = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
            object = $this$renderPossiblyInnerType.append(this.renderTypeConstructor(typeConstructor2));
        }
        $this$renderPossiblyInnerType.append(this.renderTypeArguments(possiblyInnerType.getArguments()));
    }

    @NotNull
    public String renderTypeConstructor(@NotNull TypeConstructor typeConstructor2) {
        String string;
        Intrinsics.checkNotNullParameter(typeConstructor2, "typeConstructor");
        ClassifierDescriptor cd2 = typeConstructor2.getDeclarationDescriptor();
        if (cd2 instanceof TypeParameterDescriptor || cd2 instanceof ClassDescriptor || cd2 instanceof TypeAliasDescriptor) {
            string = this.renderClassifierName(cd2);
        } else if (cd2 == null) {
            string = typeConstructor2 instanceof IntersectionTypeConstructor ? ((IntersectionTypeConstructor)typeConstructor2).makeDebugNameForIntersectionType(DescriptorRendererImpl$$Lambda$1.INSTANCE) : typeConstructor2.toString();
        } else {
            throw new IllegalStateException(("Unexpected classifier: " + cd2.getClass()).toString());
        }
        return string;
    }

    @Override
    @NotNull
    public String renderTypeProjection(@NotNull TypeProjection typeProjection) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder $this$renderTypeProjection_u24lambda_u249 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        this.appendTypeProjections($this$renderTypeProjection_u24lambda_u249, CollectionsKt.listOf(typeProjection));
        return stringBuilder.toString();
    }

    private final void appendTypeProjections(StringBuilder $this$appendTypeProjections, List<? extends TypeProjection> typeProjections) {
        DescriptorRendererImpl descriptorRendererImpl = this;
        CollectionsKt.joinTo$default(typeProjections, $this$appendTypeProjections, ", ", null, null, 0, null, new DescriptorRendererImpl$$Lambda$2(descriptorRendererImpl), 60, null);
    }

    private final void renderFunctionType(StringBuilder $this$renderFunctionType, KotlinType type) {
        boolean needParenthesis;
        int lengthBefore = $this$renderFunctionType.length();
        DescriptorRendererImpl $this$renderFunctionType_u24lambda_u2411 = this.getFunctionTypeAnnotationsRenderer();
        boolean bl2 = false;
        DescriptorRendererImpl.renderAnnotations$default($this$renderFunctionType_u24lambda_u2411, $this$renderFunctionType, type, null, 2, null);
        boolean hasAnnotations = $this$renderFunctionType.length() != lengthBefore;
        KotlinType receiverType = FunctionTypesKt.getReceiverTypeFromFunctionType(type);
        List<KotlinType> contextReceiversTypes = FunctionTypesKt.getContextReceiverTypesFromFunctionType(type);
        boolean isSuspend = FunctionTypesKt.isSuspendFunctionType(type);
        boolean isNullable = type.isMarkedNullable();
        boolean bl3 = needParenthesis = isNullable || hasAnnotations && receiverType != null;
        if (needParenthesis) {
            StringBuilder stringBuilder;
            if (isSuspend) {
                stringBuilder = $this$renderFunctionType.insert(lengthBefore, '(');
            } else {
                if (hasAnnotations) {
                    boolean bl4 = CharsKt.isWhitespace(StringsKt.last($this$renderFunctionType));
                    if (_Assertions.ENABLED && !bl4) {
                        String string = "Assertion failed";
                        throw new AssertionError((Object)string);
                    }
                    if ($this$renderFunctionType.charAt(StringsKt.getLastIndex($this$renderFunctionType) - 1) != ')') {
                        $this$renderFunctionType.insert(StringsKt.getLastIndex($this$renderFunctionType), "()");
                    }
                }
                stringBuilder = $this$renderFunctionType.append("(");
            }
        }
        this.renderModifier($this$renderFunctionType, isSuspend, "suspend");
        if (!((Collection)contextReceiversTypes).isEmpty()) {
            $this$renderFunctionType.append("context(");
            List<KotlinType> withoutLast = contextReceiversTypes.subList(0, CollectionsKt.getLastIndex(contextReceiversTypes));
            for (KotlinType contextReceiverType : withoutLast) {
                this.renderNormalizedType($this$renderFunctionType, contextReceiverType);
                $this$renderFunctionType.append(", ");
            }
            this.renderNormalizedType($this$renderFunctionType, CollectionsKt.last(contextReceiversTypes));
            $this$renderFunctionType.append(") ");
        }
        if (receiverType != null) {
            boolean surroundReceiver;
            boolean bl5 = surroundReceiver = this.shouldRenderAsPrettyFunctionType(receiverType) && !receiverType.isMarkedNullable() || this.hasModifiersOrAnnotations(receiverType) || receiverType instanceof DefinitelyNotNullType;
            if (surroundReceiver) {
                $this$renderFunctionType.append("(");
            }
            this.renderNormalizedType($this$renderFunctionType, receiverType);
            if (surroundReceiver) {
                $this$renderFunctionType.append(")");
            }
            $this$renderFunctionType.append(".");
        }
        $this$renderFunctionType.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(type) && type.getArguments().size() <= 1) {
            $this$renderFunctionType.append("???");
        } else {
            List<TypeProjection> parameterTypes = FunctionTypesKt.getValueParameterTypesFromFunctionType(type);
            Iterator<KotlinType> iterator2 = ((Iterable)parameterTypes).iterator();
            int n2 = 0;
            while (iterator2.hasNext()) {
                Name name;
                Name name2;
                int index = n2++;
                TypeProjection typeProjection = (TypeProjection)((Object)iterator2.next());
                if (index > 0) {
                    $this$renderFunctionType.append(", ");
                }
                if (this.getParameterNamesInFunctionalTypes()) {
                    KotlinType kotlinType = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                    name2 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(kotlinType);
                } else {
                    name2 = name = null;
                }
                if (name != null) {
                    $this$renderFunctionType.append(this.renderName(name, false));
                    $this$renderFunctionType.append(": ");
                }
                $this$renderFunctionType.append(this.renderTypeProjection(typeProjection));
            }
        }
        $this$renderFunctionType.append(") ").append(this.arrow()).append(" ");
        this.renderNormalizedType($this$renderFunctionType, FunctionTypesKt.getReturnTypeFromFunctionType(type));
        if (needParenthesis) {
            $this$renderFunctionType.append(")");
        }
        if (isNullable) {
            $this$renderFunctionType.append("?");
        }
    }

    private final boolean hasModifiersOrAnnotations(KotlinType $this$hasModifiersOrAnnotations) {
        return FunctionTypesKt.isSuspendFunctionType($this$hasModifiersOrAnnotations) || !$this$hasModifiersOrAnnotations.getAnnotations().isEmpty();
    }

    private final void appendDefinedIn(StringBuilder $this$appendDefinedIn, DeclarationDescriptor descriptor2) {
        block3: {
            if (descriptor2 instanceof PackageFragmentDescriptor || descriptor2 instanceof PackageViewDescriptor) {
                return;
            }
            DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
            if (containingDeclaration == null || containingDeclaration instanceof ModuleDescriptor) break block3;
            $this$appendDefinedIn.append(" ").append(this.renderMessage("defined in")).append(" ");
            FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName(containingDeclaration);
            Intrinsics.checkNotNullExpressionValue(fqNameUnsafe, "getFqName(...)");
            FqNameUnsafe fqName = fqNameUnsafe;
            $this$appendDefinedIn.append(fqName.isRoot() ? "root package" : this.renderFqName(fqName));
            if (this.getWithSourceFileForTopLevel() && containingDeclaration instanceof PackageFragmentDescriptor && descriptor2 instanceof DeclarationDescriptorWithSource) {
                String string = ((DeclarationDescriptorWithSource)descriptor2).getSource().getContainingFile().getName();
                if (string != null) {
                    String sourceFileName = string;
                    boolean bl2 = false;
                    $this$appendDefinedIn.append(" ").append(this.renderMessage("in file")).append(" ").append(sourceFileName);
                }
            }
        }
    }

    private final void renderAnnotations(StringBuilder $this$renderAnnotations, Annotated annotated, AnnotationUseSiteTarget target) {
        if (!this.getModifiers().contains((Object)DescriptorRendererModifier.ANNOTATIONS)) {
            return;
        }
        Set<FqName> excluded = annotated instanceof KotlinType ? this.getExcludedTypeAnnotationClasses() : this.getExcludedAnnotationClasses();
        Function1<AnnotationDescriptor, Boolean> annotationFilter = this.getAnnotationFilter();
        for (AnnotationDescriptor annotation : annotated.getAnnotations()) {
            if (CollectionsKt.contains((Iterable)excluded, annotation.getFqName()) || this.isParameterName(annotation) || annotationFilter != null && !annotationFilter.invoke(annotation).booleanValue()) continue;
            $this$renderAnnotations.append(this.renderAnnotation(annotation, target));
            StringBuilder stringBuilder = this.getEachAnnotationOnNewLine() ? $this$renderAnnotations.append('\n') : $this$renderAnnotations.append(" ");
        }
    }

    static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder stringBuilder, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int n2, Object object) {
        if ((n2 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(stringBuilder, annotated, annotationUseSiteTarget);
    }

    private final boolean isParameterName(AnnotationDescriptor $this$isParameterName) {
        return Intrinsics.areEqual($this$isParameterName.getFqName(), StandardNames.FqNames.parameterName);
    }

    @Override
    @NotNull
    public String renderAnnotation(@NotNull AnnotationDescriptor annotation, @Nullable AnnotationUseSiteTarget target) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        StringBuilder $this$renderAnnotation_u24lambda_u2413 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$renderAnnotation_u24lambda_u2413.append('@');
        if (target != null) {
            $this$renderAnnotation_u24lambda_u2413.append(target.getRenderName() + ':');
        }
        KotlinType annotationType = annotation.getType();
        $this$renderAnnotation_u24lambda_u2413.append(this.renderType(annotationType));
        if (this.getIncludeAnnotationArguments()) {
            List<String> arguments = this.renderAndSortAnnotationArguments(annotation);
            if (this.getIncludeEmptyAnnotationArguments() || !((Collection)arguments).isEmpty()) {
                CollectionsKt.joinTo$default(arguments, $this$renderAnnotation_u24lambda_u2413, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (this.getVerbose() && (KotlinTypeKt.isError(annotationType) || annotationType.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor)) {
            $this$renderAnnotation_u24lambda_u2413.append(" /* annotation class not found */");
        }
        return stringBuilder.toString();
    }

    /*
     * WARNING - void declaration
     */
    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor descriptor2) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        void $this$mapTo$iv$iv2;
        void $this$map$iv2;
        Name it;
        void $this$filterTo$iv$iv;
        List list;
        List list2;
        Object object;
        Iterable $this$map$iv3;
        List<ValueParameterDescriptor> list3;
        ClassConstructorDescriptor classConstructorDescriptor;
        ClassDescriptor classDescriptor;
        Map<Name, ConstantValue<?>> allValueArguments = descriptor2.getAllValueArguments();
        ClassDescriptor classDescriptor2 = classDescriptor = this.getRenderDefaultAnnotationArguments() ? DescriptorUtilsKt.getAnnotationClass(descriptor2) : null;
        if (classDescriptor != null && (classConstructorDescriptor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null && (list3 = classConstructorDescriptor.getValueParameters()) != null) {
            void $this$mapTo$iv$iv3;
            ValueParameterDescriptor it2;
            Iterable $this$filterTo$iv$iv2;
            Iterable $this$filter$iv;
            Iterable iterable = list3;
            boolean $i$f$filter = false;
            void var10_10 = $this$filter$iv;
            Object destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                it2 = (ValueParameterDescriptor)element$iv$iv;
                boolean bl2 = false;
                if (!it2.declaresDefaultValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$map = false;
            $this$filterTo$iv$iv2 = $this$map$iv3;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv3) {
                it2 = (ValueParameterDescriptor)item$iv$iv;
                object = destination$iv$iv;
                boolean bl3 = false;
                object.add(it2.getName());
            }
            list2 = (List)destination$iv$iv;
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        List parameterDescriptorsWithDefaultValue = list;
        Iterable $this$filter$iv = parameterDescriptorsWithDefaultValue;
        boolean $i$f$filter = false;
        $this$map$iv3 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (Name)element$iv$iv;
            boolean bl4 = false;
            if (!(!allValueArguments.containsKey(it))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$map22 = false;
        $this$filterTo$iv$iv = $this$map$iv2;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv2) {
            it = (Name)item$iv$iv;
            object = destination$iv$iv;
            boolean bl5 = false;
            object.add(it.asString() + " = ...");
        }
        List defaultList = (List)destination$iv$iv;
        Iterable $i$f$map22 = allValueArguments.entrySet();
        boolean $i$f$map = false;
        destination$iv$iv = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo2 = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Map.Entry entry = (Map.Entry)item$iv$iv;
            object = destination$iv$iv2;
            boolean bl6 = false;
            Name name = (Name)entry.getKey();
            ConstantValue value = (ConstantValue)entry.getValue();
            object.add(name.asString() + " = " + (!parameterDescriptorsWithDefaultValue.contains(name) ? this.renderConstant(value) : "..."));
        }
        List argumentList = (List)destination$iv$iv2;
        return CollectionsKt.sorted(CollectionsKt.plus((Collection)defaultList, (Iterable)argumentList));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String renderConstant(ConstantValue<?> value) {
        String string;
        Object object = this.options.getPropertyConstantRenderer();
        if (object != null) {
            Function1<ConstantValue<?>, String> it = object;
            return it.invoke(value);
        }
        object = value;
        if (object instanceof ArrayValue) {
            void $this$mapNotNullTo$iv$iv;
            Iterable $this$mapNotNull$iv = (Iterable)((ArrayValue)value).getValue();
            boolean $i$f$mapNotNull = false;
            Iterable iterable = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                String it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                boolean bl2 = false;
                ConstantValue it = (ConstantValue)element$iv$iv;
                boolean bl3 = false;
                if (this.renderConstant(it) == null) continue;
                boolean bl4 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            string = CollectionsKt.joinToString$default((List)destination$iv$iv, ", ", "{", "}", 0, null, null, 56, null);
            return string;
        } else if (object instanceof AnnotationValue) {
            string = StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor)((AnnotationValue)value).getValue(), null, 2, null), (CharSequence)"@");
            return string;
        } else if (object instanceof KClassValue) {
            KClassValue.Value classValue = (KClassValue.Value)((KClassValue)value).getValue();
            if (classValue instanceof KClassValue.Value.LocalClass) {
                string = ((KClassValue.Value.LocalClass)classValue).getType() + "::class";
                return string;
            } else {
                if (!(classValue instanceof KClassValue.Value.NormalClass)) throw new NoWhenBranchMatchedException();
                String type = null;
                type = ((KClassValue.Value.NormalClass)classValue).getClassId().asSingleFqName().asString();
                int n2 = ((KClassValue.Value.NormalClass)classValue).getArrayDimensions();
                int n3 = 0;
                while (n3 < n2) {
                    int it = n3++;
                    boolean bl5 = false;
                    type = "kotlin.Array<" + type + '>';
                }
                string = type + "::class";
            }
            return string;
        } else {
            string = value.toString();
        }
        return string;
    }

    private final boolean renderVisibility(DescriptorVisibility visibility2, StringBuilder builder) {
        DescriptorVisibility visibility3 = visibility2;
        if (!this.getModifiers().contains((Object)DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (this.getNormalizedVisibilities()) {
            visibility3 = visibility3.normalize();
        }
        if (!this.getRenderDefaultVisibility() && Intrinsics.areEqual(visibility3, DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        builder.append(this.renderKeyword(visibility3.getInternalDisplayName())).append(" ");
        return true;
    }

    private final void renderModality(Modality modality2, StringBuilder builder, Modality defaultModality) {
        if (!this.getRenderDefaultModality() && modality2 == defaultModality) {
            return;
        }
        this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality2.name()));
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor $this$implicitModalityWithoutExtensions) {
        if ($this$implicitModalityWithoutExtensions instanceof ClassDescriptor) {
            return ((ClassDescriptor)$this$implicitModalityWithoutExtensions).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor declarationDescriptor = $this$implicitModalityWithoutExtensions.getContainingDeclaration();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor)declarationDescriptor : null;
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        ClassDescriptor containingClassDescriptor = classDescriptor;
        if (!($this$implicitModalityWithoutExtensions instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        Collection<? extends CallableMemberDescriptor> collection = ((CallableMemberDescriptor)$this$implicitModalityWithoutExtensions).getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(collection, "getOverriddenDescriptors(...)");
        if (!collection.isEmpty() && containingClassDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        return containingClassDescriptor.getKind() == ClassKind.INTERFACE && !Intrinsics.areEqual(((CallableMemberDescriptor)$this$implicitModalityWithoutExtensions).getVisibility(), DescriptorVisibilities.PRIVATE) ? (((CallableMemberDescriptor)$this$implicitModalityWithoutExtensions).getModality() == Modality.ABSTRACT ? Modality.ABSTRACT : Modality.OPEN) : Modality.FINAL;
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callable, StringBuilder builder) {
        if (!DescriptorUtils.isTopLevelDeclaration(callable) || callable.getModality() != Modality.FINAL) {
            if (this.getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE && callable.getModality() == Modality.OPEN && this.overridesSomething(callable)) {
                return;
            }
            Modality modality2 = callable.getModality();
            Intrinsics.checkNotNullExpressionValue((Object)modality2, "getModality(...)");
            this.renderModality(modality2, builder, this.implicitModalityWithoutExtensions(callable));
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMember, StringBuilder builder) {
        if (!this.getModifiers().contains((Object)DescriptorRendererModifier.OVERRIDE)) {
            return;
        }
        if (this.overridesSomething(callableMember) && this.getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            this.renderModifier(builder, true, "override");
            if (this.getVerbose()) {
                builder.append("/*").append(callableMember.getOverriddenDescriptors().size()).append("*/ ");
            }
        }
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMember, StringBuilder builder) {
        if (!this.getModifiers().contains((Object)DescriptorRendererModifier.MEMBER_KIND)) {
            return;
        }
        if (this.getVerbose() && callableMember.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            builder.append("/*").append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMember.getKind().name())).append("*/ ");
        }
    }

    private final void renderModifier(StringBuilder builder, boolean value, String modifier) {
        if (value) {
            builder.append(this.renderKeyword(modifier));
            builder.append(" ");
        }
    }

    private final void renderMemberModifiers(MemberDescriptor descriptor2, StringBuilder builder) {
        this.renderModifier(builder, descriptor2.isExternal(), "external");
        this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.EXPECT) && descriptor2.isExpect(), "expect");
        this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.ACTUAL) && descriptor2.isActual(), "actual");
    }

    /*
     * Unable to fully structure code
     */
    private final void renderAdditionalModifiers(FunctionDescriptor functionDescriptor, StringBuilder builder) {
        block11: {
            block10: {
                if (!functionDescriptor.isOperator()) ** GOTO lbl-1000
                v0 = functionDescriptor.getOverriddenDescriptors();
                Intrinsics.checkNotNullExpressionValue(v0, "getOverriddenDescriptors(...)");
                $this$none$iv = v0;
                $i$f$none = false;
                if (((Collection)$this$none$iv).isEmpty()) {
                    v1 = true;
                } else {
                    for (T element$iv : $this$none$iv) {
                        it = (FunctionDescriptor)element$iv;
                        $i$a$-none-DescriptorRendererImpl$renderAdditionalModifiers$isOperator$1 = false;
                        if (!it.isOperator()) continue;
                        v1 = false;
                        break block10;
                    }
                    v1 = true;
                }
            }
            if (v1 || this.getAlwaysRenderModifiers()) {
                v2 = true;
            } else lbl-1000:
            // 2 sources

            {
                v2 = isOperator = false;
            }
            if (!functionDescriptor.isInfix()) ** GOTO lbl-1000
            v3 = functionDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(v3, "getOverriddenDescriptors(...)");
            $this$none$iv = v3;
            $i$f$none = false;
            if (((Collection)$this$none$iv).isEmpty()) {
                v4 = true;
            } else {
                for (T element$iv : $this$none$iv) {
                    it = (FunctionDescriptor)element$iv;
                    $i$a$-none-DescriptorRendererImpl$renderAdditionalModifiers$isInfix$1 = false;
                    if (!it.isInfix()) continue;
                    v4 = false;
                    break block11;
                }
                v4 = true;
            }
        }
        if (v4 || this.getAlwaysRenderModifiers()) {
            v5 = true;
        } else lbl-1000:
        // 2 sources

        {
            v5 = false;
        }
        isInfix = v5;
        this.renderModifier(builder, functionDescriptor.isTailrec(), "tailrec");
        this.renderSuspendModifier(functionDescriptor, builder);
        this.renderModifier(builder, functionDescriptor.isInline(), "inline");
        this.renderModifier(builder, isInfix, "infix");
        this.renderModifier(builder, isOperator, "operator");
    }

    private final void renderSuspendModifier(FunctionDescriptor functionDescriptor, StringBuilder builder) {
        this.renderModifier(builder, functionDescriptor.isSuspend(), "suspend");
    }

    @Override
    @NotNull
    public String render(@NotNull DeclarationDescriptor declarationDescriptor) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder $this$render_u24lambda_u2424 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), $this$render_u24lambda_u2424);
        if (this.getWithDefinedIn()) {
            this.appendDefinedIn($this$render_u24lambda_u2424, declarationDescriptor);
        }
        return stringBuilder.toString();
    }

    private final void renderTypeParameter(TypeParameterDescriptor typeParameter, StringBuilder builder, boolean topLevel) {
        if (topLevel) {
            builder.append(this.lt());
        }
        if (this.getVerbose()) {
            builder.append("/*").append(typeParameter.getIndex()).append("*/ ");
        }
        this.renderModifier(builder, typeParameter.isReified(), "reified");
        String variance = typeParameter.getVariance().getLabel();
        this.renderModifier(builder, ((CharSequence)variance).length() > 0, variance);
        DescriptorRendererImpl.renderAnnotations$default(this, builder, typeParameter, null, 2, null);
        this.renderName(typeParameter, builder, topLevel);
        int upperBoundsCount = typeParameter.getUpperBounds().size();
        if (upperBoundsCount > 1 && !topLevel || upperBoundsCount == 1) {
            KotlinType upperBound = typeParameter.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(upperBound)) {
                StringBuilder stringBuilder = builder.append(" : ");
                Intrinsics.checkNotNull(upperBound);
                stringBuilder.append(this.renderType(upperBound));
            }
        } else if (topLevel) {
            boolean first = true;
            for (KotlinType upperBound : typeParameter.getUpperBounds()) {
                if (KotlinBuiltIns.isDefaultBound(upperBound)) continue;
                StringBuilder stringBuilder = first ? builder.append(" : ") : builder.append(" & ");
                Intrinsics.checkNotNull(upperBound);
                builder.append(this.renderType(upperBound));
                first = false;
            }
        }
        if (topLevel) {
            builder.append(this.gt());
        }
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> typeParameters, StringBuilder builder, boolean withSpace) {
        if (this.getWithoutTypeParameters()) {
            return;
        }
        if (!((Collection)typeParameters).isEmpty()) {
            builder.append(this.lt());
            this.renderTypeParameterList(builder, typeParameters);
            builder.append(this.gt());
            if (withSpace) {
                builder.append(" ");
            }
        }
    }

    private final void renderTypeParameterList(StringBuilder builder, List<? extends TypeParameterDescriptor> typeParameters) {
        Iterator<? extends TypeParameterDescriptor> iterator2 = typeParameters.iterator();
        while (iterator2.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptor = iterator2.next();
            this.renderTypeParameter(typeParameterDescriptor, builder, false);
            if (!iterator2.hasNext()) continue;
            builder.append(", ");
        }
    }

    private final void renderFunction(FunctionDescriptor function, StringBuilder builder) {
        if (!this.getStartFromName()) {
            if (!this.getStartFromDeclarationKeyword()) {
                List<ReceiverParameterDescriptor> list = function.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getContextReceiverParameters(...)");
                this.renderContextReceivers(list, builder);
                DescriptorRendererImpl.renderAnnotations$default(this, builder, function, null, 2, null);
                DescriptorVisibility descriptorVisibility = function.getVisibility();
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
                this.renderVisibility(descriptorVisibility, builder);
                this.renderModalityForCallable(function, builder);
                if (this.getIncludeAdditionalModifiers()) {
                    this.renderMemberModifiers(function, builder);
                }
                this.renderOverride(function, builder);
                if (this.getIncludeAdditionalModifiers()) {
                    this.renderAdditionalModifiers(function, builder);
                } else {
                    this.renderSuspendModifier(function, builder);
                }
                this.renderMemberKind(function, builder);
                if (this.getVerbose()) {
                    if (function.isHiddenToOvercomeSignatureClash()) {
                        builder.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (function.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        builder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            builder.append(this.renderKeyword("fun")).append(" ");
            List<TypeParameterDescriptor> list = function.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
            this.renderTypeParameters(list, builder, true);
            this.renderReceiver(function, builder);
        }
        this.renderName(function, builder, true);
        List<ValueParameterDescriptor> list = function.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
        this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)list, function.hasSynthesizedParameterNames(), builder);
        this.renderReceiverAfterName(function, builder);
        KotlinType returnType = function.getReturnType();
        if (!(this.getWithoutReturnType() || !this.getUnitReturnType() && returnType != null && KotlinBuiltIns.isUnit(returnType))) {
            KotlinType kotlinType = returnType;
            builder.append(": ").append(kotlinType == null ? "[NULL]" : this.renderType(kotlinType));
        }
        List<TypeParameterDescriptor> list2 = function.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list2, "getTypeParameters(...)");
        this.renderWhereSuffix(list2, builder);
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder builder) {
        if (!this.getReceiverAfterName()) {
            return;
        }
        ReceiverParameterDescriptor receiver = callableDescriptor.getExtensionReceiverParameter();
        if (receiver != null) {
            StringBuilder stringBuilder = builder.append(" on ");
            KotlinType kotlinType = receiver.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            stringBuilder.append(this.renderType(kotlinType));
        }
    }

    private final String renderForReceiver(KotlinType $this$renderForReceiver) {
        String result = this.renderType($this$renderForReceiver);
        if (this.shouldRenderAsPrettyFunctionType($this$renderForReceiver) && !TypeUtils.isNullableType($this$renderForReceiver) || $this$renderForReceiver instanceof DefinitelyNotNullType) {
            result = '(' + result + ')';
        }
        return result;
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> contextReceivers, StringBuilder builder) {
        if (!(!((Collection)contextReceivers).isEmpty())) {
            return;
        }
        builder.append("context(");
        Iterator iterator2 = ((Iterable)contextReceivers).iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            int i2 = n2++;
            ReceiverParameterDescriptor contextReceiver = (ReceiverParameterDescriptor)iterator2.next();
            this.renderAnnotations(builder, contextReceiver, AnnotationUseSiteTarget.RECEIVER);
            KotlinType kotlinType = contextReceiver.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            String typeString = this.renderForReceiver(kotlinType);
            builder.append(typeString);
            StringBuilder stringBuilder = i2 == CollectionsKt.getLastIndex(contextReceivers) ? builder.append(") ") : builder.append(", ");
        }
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder builder) {
        ReceiverParameterDescriptor receiver = callableDescriptor.getExtensionReceiverParameter();
        if (receiver != null) {
            this.renderAnnotations(builder, receiver, AnnotationUseSiteTarget.RECEIVER);
            KotlinType kotlinType = receiver.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            String typeString = this.renderForReceiver(kotlinType);
            builder.append(typeString).append(".");
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void renderConstructor(ConstructorDescriptor constructor, StringBuilder builder) {
        DescriptorRendererImpl.renderAnnotations$default(this, builder, constructor, null, 2, null);
        if (!this.options.getRenderDefaultVisibility() && constructor.getConstructedClass().getModality() == Modality.SEALED) ** GOTO lbl-1000
        v0 = constructor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(v0, "getVisibility(...)");
        if (this.renderVisibility(v0, builder)) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = false;
        }
        visibilityRendered = v1;
        this.renderMemberKind(constructor, builder);
        v2 = constructorKeywordRendered = this.getRenderConstructorKeyword() != false || constructor.isPrimary() == false || visibilityRendered != false;
        if (constructorKeywordRendered) {
            builder.append(this.renderKeyword("constructor"));
        }
        v3 = constructor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(v3, "getContainingDeclaration(...)");
        classDescriptor = v3;
        if (this.getSecondaryConstructorsAsPrimary()) {
            if (constructorKeywordRendered) {
                builder.append(" ");
            }
            this.renderName(classDescriptor, builder, true);
            v4 = constructor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(v4, "getTypeParameters(...)");
            this.renderTypeParameters(v4, builder, false);
        }
        v5 = constructor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(v5, "getValueParameters(...)");
        this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)v5, constructor.hasSynthesizedParameterNames(), builder);
        if (this.getRenderConstructorDelegation() && !constructor.isPrimary() && classDescriptor instanceof ClassDescriptor && (primaryConstructor = ((ClassDescriptor)classDescriptor).getUnsubstitutedPrimaryConstructor()) != null) {
            v6 = primaryConstructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(v6, "getValueParameters(...)");
            $this$filter$iv = v6;
            $i$f$filter = false;
            var10_9 = $this$filter$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$filterTo = false;
            for (T element$iv$iv : $this$filterTo$iv$iv) {
                it = (ValueParameterDescriptor)element$iv$iv;
                $i$a$-filter-DescriptorRendererImpl$renderConstructor$parametersWithoutDefault$1 = false;
                if (!(it.declaresDefaultValue() == false && it.getVarargElementType() == null)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            parametersWithoutDefault = (List)destination$iv$iv;
            if (((Collection)parametersWithoutDefault).isEmpty() == false) {
                builder.append(" : ").append(this.renderKeyword("this"));
                builder.append(CollectionsKt.joinToString$default(parametersWithoutDefault, ", ", "(", ")", 0, null, DescriptorRendererImpl$$Lambda$3.INSTANCE, 24, null));
            }
        }
        if (this.getSecondaryConstructorsAsPrimary()) {
            v7 = constructor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(v7, "getTypeParameters(...)");
            this.renderWhereSuffix(v7, builder);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> typeParameters, StringBuilder builder) {
        if (this.getWithoutTypeParameters()) {
            return;
        }
        ArrayList upperBoundStrings = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
            void $this$mapTo$iv;
            List<KotlinType> list = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
            Iterable iterable = CollectionsKt.drop((Iterable)list, 1);
            boolean $i$f$mapTo = false;
            for (Object item$iv : $this$mapTo$iv) {
                void it;
                KotlinType kotlinType = (KotlinType)item$iv;
                Collection collection = upperBoundStrings;
                boolean bl2 = false;
                StringBuilder stringBuilder = new StringBuilder();
                Name name = typeParameterDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                StringBuilder stringBuilder2 = stringBuilder.append(this.renderName(name, false)).append(" : ");
                Intrinsics.checkNotNull(it);
                collection.add(stringBuilder2.append(this.renderType((KotlinType)it)).toString());
            }
        }
        if (!((Collection)upperBoundStrings).isEmpty()) {
            builder.append(" ").append(this.renderKeyword("where")).append(" ");
            CollectionsKt.joinTo$default(upperBoundStrings, builder, ", ", null, null, 0, null, null, 124, null);
        }
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> parameters, boolean synthesizedParameterNames, StringBuilder builder) {
        boolean includeNames = this.shouldRenderParameterNames(synthesizedParameterNames);
        int parameterCount = parameters.size();
        this.getValueParametersHandler().appendBeforeValueParameters(parameterCount, builder);
        Iterator iterator2 = ((Iterable)parameters).iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            int index = n2++;
            ValueParameterDescriptor parameter = (ValueParameterDescriptor)iterator2.next();
            this.getValueParametersHandler().appendBeforeValueParameter(parameter, index, parameterCount, builder);
            this.renderValueParameter(parameter, includeNames, builder, false);
            this.getValueParametersHandler().appendAfterValueParameter(parameter, index, parameterCount, builder);
        }
        this.getValueParametersHandler().appendAfterValueParameters(parameterCount, builder);
    }

    private final boolean shouldRenderParameterNames(boolean synthesizedParameterNames) {
        boolean bl2;
        switch (WhenMappings.$EnumSwitchMapping$1[this.getParameterNameRenderingPolicy().ordinal()]) {
            case 1: {
                bl2 = true;
                break;
            }
            case 2: {
                if (!synthesizedParameterNames) {
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 3: {
                bl2 = false;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private final void renderValueParameter(ValueParameterDescriptor valueParameter, boolean includeName, StringBuilder builder, boolean topLevel) {
        if (topLevel) {
            builder.append(this.renderKeyword("value-parameter")).append(" ");
        }
        if (this.getVerbose()) {
            builder.append("/*").append(valueParameter.getIndex()).append("*/ ");
        }
        DescriptorRendererImpl.renderAnnotations$default(this, builder, valueParameter, null, 2, null);
        this.renderModifier(builder, valueParameter.isCrossinline(), "crossinline");
        this.renderModifier(builder, valueParameter.isNoinline(), "noinline");
        if (!this.getRenderPrimaryConstructorParametersAsProperties()) ** GOTO lbl-1000
        var7_5 = valueParameter.getContainingDeclaration();
        v0 = var7_5 instanceof ClassConstructorDescriptor != false ? (ClassConstructorDescriptor)var7_5 : null;
        v1 = v0 != null ? v0.isPrimary() : false;
        if (v1) {
            v2 = true;
        } else lbl-1000:
        // 2 sources

        {
            v2 = isPrimaryConstructor = false;
        }
        if (isPrimaryConstructor) {
            this.renderModifier(builder, this.getActualPropertiesInPrimaryConstructor(), "actual");
        }
        this.renderVariable(valueParameter, includeName, builder, topLevel, isPrimaryConstructor);
        v3 = this.getDefaultParameterValueRenderer() != null && (this.getDebugMode() != false ? valueParameter.declaresDefaultValue() : DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameter)) != false ? true : (withDefaultValue = false);
        if (withDefaultValue) {
            v4 = new StringBuilder().append(" = ");
            v5 = this.getDefaultParameterValueRenderer();
            Intrinsics.checkNotNull(v5);
            builder.append(v4.append(v5.invoke(valueParameter)).toString());
        }
    }

    private final void renderValVarPrefix(VariableDescriptor variable, StringBuilder builder, boolean isInPrimaryConstructor) {
        if (isInPrimaryConstructor || !(variable instanceof ValueParameterDescriptor)) {
            builder.append(this.renderKeyword(variable.isVar() ? "var" : "val")).append(" ");
        }
    }

    static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder stringBuilder, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, stringBuilder, bl2);
    }

    private final void renderVariable(VariableDescriptor variable, boolean includeName, StringBuilder builder, boolean topLevel, boolean isInPrimaryConstructor) {
        KotlinType kotlinType = variable.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        KotlinType realType = kotlinType;
        ValueParameterDescriptor valueParameterDescriptor = variable instanceof ValueParameterDescriptor ? (ValueParameterDescriptor)variable : null;
        KotlinType varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        KotlinType kotlinType2 = varargElementType;
        if (kotlinType2 == null) {
            kotlinType2 = realType;
        }
        KotlinType typeToRender = kotlinType2;
        this.renderModifier(builder, varargElementType != null, "vararg");
        if (isInPrimaryConstructor || topLevel && !this.getStartFromName()) {
            this.renderValVarPrefix(variable, builder, isInPrimaryConstructor);
        }
        if (includeName) {
            this.renderName(variable, builder, topLevel);
            builder.append(": ");
        }
        builder.append(this.renderType(typeToRender));
        this.renderInitializer(variable, builder);
        if (this.getVerbose() && varargElementType != null) {
            builder.append(" /*").append(this.renderType(realType)).append("*/");
        }
    }

    private final void renderProperty(PropertyDescriptor property, StringBuilder builder) {
        if (!this.getStartFromName()) {
            if (!this.getStartFromDeclarationKeyword()) {
                List<ReceiverParameterDescriptor> list = property.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getContextReceiverParameters(...)");
                this.renderContextReceivers(list, builder);
                this.renderPropertyAnnotations(property, builder);
                DescriptorVisibility descriptorVisibility = property.getVisibility();
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
                this.renderVisibility(descriptorVisibility, builder);
                this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.CONST) && property.isConst(), "const");
                this.renderMemberModifiers(property, builder);
                this.renderModalityForCallable(property, builder);
                this.renderOverride(property, builder);
                this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.LATEINIT) && property.isLateInit(), "lateinit");
                this.renderMemberKind(property, builder);
            }
            DescriptorRendererImpl.renderValVarPrefix$default(this, property, builder, false, 4, null);
            List<TypeParameterDescriptor> list = property.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
            this.renderTypeParameters(list, builder, true);
            this.renderReceiver(property, builder);
        }
        this.renderName(property, builder, true);
        StringBuilder stringBuilder = builder.append(": ");
        KotlinType kotlinType = property.getType();
        Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
        stringBuilder.append(this.renderType(kotlinType));
        this.renderReceiverAfterName(property, builder);
        this.renderInitializer(property, builder);
        List<TypeParameterDescriptor> list = property.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getTypeParameters(...)");
        this.renderWhereSuffix(list, builder);
    }

    private final void renderPropertyAnnotations(PropertyDescriptor property, StringBuilder builder) {
        block5: {
            Annotated it;
            if (!this.getModifiers().contains((Object)DescriptorRendererModifier.ANNOTATIONS)) {
                return;
            }
            DescriptorRendererImpl.renderAnnotations$default(this, builder, property, null, 2, null);
            FieldDescriptor fieldDescriptor = property.getBackingField();
            if (fieldDescriptor != null) {
                it = fieldDescriptor;
                boolean bl2 = false;
                this.renderAnnotations(builder, it, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor fieldDescriptor2 = property.getDelegateField();
            if (fieldDescriptor2 != null) {
                it = fieldDescriptor2;
                boolean bl3 = false;
                this.renderAnnotations(builder, it, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (this.getPropertyAccessorRenderingPolicy() != PropertyAccessorRenderingPolicy.NONE) break block5;
            PropertyGetterDescriptor propertyGetterDescriptor = property.getGetter();
            if (propertyGetterDescriptor != null) {
                it = propertyGetterDescriptor;
                boolean bl4 = false;
                this.renderAnnotations(builder, it, AnnotationUseSiteTarget.PROPERTY_GETTER);
            }
            PropertySetterDescriptor propertySetterDescriptor = property.getSetter();
            if (propertySetterDescriptor != null) {
                PropertySetterDescriptor setter = propertySetterDescriptor;
                boolean bl5 = false;
                CallableDescriptor it2 = setter;
                boolean bl6 = false;
                this.renderAnnotations(builder, it2, AnnotationUseSiteTarget.PROPERTY_SETTER);
                List<ValueParameterDescriptor> list = setter.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(list, "getValueParameters(...)");
                it2 = CollectionsKt.single(list);
                boolean bl7 = false;
                Intrinsics.checkNotNull(it2);
                this.renderAnnotations(builder, it2, AnnotationUseSiteTarget.SETTER_PARAMETER);
            }
        }
    }

    private final void renderInitializer(VariableDescriptor variable, StringBuilder builder) {
        block2: {
            if (!this.getIncludePropertyConstant()) break block2;
            ConstantValue<?> constantValue = variable.getCompileTimeInitializer();
            if (constantValue != null) {
                ConstantValue<?> constant = constantValue;
                boolean bl2 = false;
                String renderedConstant = this.renderConstant(constant);
                if (renderedConstant != null) {
                    builder.append(" = ").append(this.escape(renderedConstant));
                }
            }
        }
    }

    private final void renderTypeAlias(TypeAliasDescriptor typeAlias, StringBuilder builder) {
        DescriptorRendererImpl.renderAnnotations$default(this, builder, typeAlias, null, 2, null);
        DescriptorVisibility descriptorVisibility = typeAlias.getVisibility();
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
        this.renderVisibility(descriptorVisibility, builder);
        this.renderMemberModifiers(typeAlias, builder);
        builder.append(this.renderKeyword("typealias")).append(" ");
        this.renderName(typeAlias, builder, true);
        List<TypeParameterDescriptor> list = typeAlias.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getDeclaredTypeParameters(...)");
        this.renderTypeParameters(list, builder, false);
        this.renderCapturedTypeParametersIfRequired(typeAlias, builder);
        builder.append(" = ").append(this.renderType(typeAlias.getUnderlyingType()));
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifier, StringBuilder builder) {
        List<TypeParameterDescriptor> list = classifier.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getDeclaredTypeParameters(...)");
        List<TypeParameterDescriptor> typeParameters = list;
        List<TypeParameterDescriptor> list2 = classifier.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(list2, "getParameters(...)");
        List<TypeParameterDescriptor> typeConstructorParameters = list2;
        if (this.getVerbose() && classifier.isInner() && typeConstructorParameters.size() > typeParameters.size()) {
            builder.append(" /*captured type parameters: ");
            this.renderTypeParameterList(builder, typeConstructorParameters.subList(typeParameters.size(), typeConstructorParameters.size()));
            builder.append("*/");
        }
    }

    private final void renderClass(ClassDescriptor klass, StringBuilder builder) {
        ClassConstructorDescriptor primaryConstructor;
        boolean isEnumEntry;
        boolean bl2 = isEnumEntry = klass.getKind() == ClassKind.ENUM_ENTRY;
        if (!this.getStartFromName()) {
            List<ReceiverParameterDescriptor> list = klass.getContextReceivers();
            Intrinsics.checkNotNullExpressionValue(list, "getContextReceivers(...)");
            this.renderContextReceivers(list, builder);
            DescriptorRendererImpl.renderAnnotations$default(this, builder, klass, null, 2, null);
            if (!isEnumEntry) {
                DescriptorVisibility descriptorVisibility = klass.getVisibility();
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
                this.renderVisibility(descriptorVisibility, builder);
            }
            if (!(klass.getKind() == ClassKind.INTERFACE && klass.getModality() == Modality.ABSTRACT || klass.getKind().isSingleton() && klass.getModality() == Modality.FINAL)) {
                Modality modality2 = klass.getModality();
                Intrinsics.checkNotNullExpressionValue((Object)modality2, "getModality(...)");
                this.renderModality(modality2, builder, this.implicitModalityWithoutExtensions(klass));
            }
            this.renderMemberModifiers(klass, builder);
            this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.INNER) && klass.isInner(), "inner");
            this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.DATA) && klass.isData(), "data");
            this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.INLINE) && klass.isInline(), "inline");
            this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.VALUE) && klass.isValue(), "value");
            this.renderModifier(builder, this.getModifiers().contains((Object)DescriptorRendererModifier.FUN) && klass.isFun(), "fun");
            this.renderClassKindPrefix(klass, builder);
        }
        if (!DescriptorUtils.isCompanionObject(klass)) {
            if (!this.getStartFromName()) {
                this.renderSpaceIfNeeded(builder);
            }
            this.renderName(klass, builder, true);
        } else {
            this.renderCompanionObjectName(klass, builder);
        }
        if (isEnumEntry) {
            return;
        }
        List<TypeParameterDescriptor> list = klass.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(list, "getDeclaredTypeParameters(...)");
        List<TypeParameterDescriptor> typeParameters = list;
        this.renderTypeParameters(typeParameters, builder, false);
        this.renderCapturedTypeParametersIfRequired(klass, builder);
        if (!klass.getKind().isSingleton() && this.getClassWithPrimaryConstructor() && (primaryConstructor = klass.getUnsubstitutedPrimaryConstructor()) != null) {
            builder.append(" ");
            DescriptorRendererImpl.renderAnnotations$default(this, builder, primaryConstructor, null, 2, null);
            DescriptorVisibility descriptorVisibility = primaryConstructor.getVisibility();
            Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "getVisibility(...)");
            this.renderVisibility(descriptorVisibility, builder);
            builder.append(this.renderKeyword("constructor"));
            List<ValueParameterDescriptor> list2 = primaryConstructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(list2, "getValueParameters(...)");
            this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)list2, primaryConstructor.hasSynthesizedParameterNames(), builder);
        }
        this.renderSuperTypes(klass, builder);
        this.renderWhereSuffix(typeParameters, builder);
    }

    private final void renderSuperTypes(ClassDescriptor klass, StringBuilder builder) {
        if (this.getWithoutSuperTypes()) {
            return;
        }
        if (KotlinBuiltIns.isNothing(klass.getDefaultType())) {
            return;
        }
        Collection<KotlinType> collection = klass.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
        Collection<KotlinType> supertypes = collection;
        if (supertypes.isEmpty() || supertypes.size() == 1 && KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next())) {
            return;
        }
        this.renderSpaceIfNeeded(builder);
        builder.append(": ");
        DescriptorRendererImpl descriptorRendererImpl = this;
        CollectionsKt.joinTo$default(supertypes, builder, ", ", null, null, 0, null, new DescriptorRendererImpl$$Lambda$4(descriptorRendererImpl), 60, null);
    }

    private final void renderClassKindPrefix(ClassDescriptor klass, StringBuilder builder) {
        builder.append(this.renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(klass)));
    }

    private final void renderPackageView(PackageViewDescriptor packageView, StringBuilder builder) {
        this.renderPackageHeader(packageView.getFqName(), "package", builder);
        if (this.getDebugMode()) {
            builder.append(" in context of ");
            this.renderName(packageView.getModule(), builder, false);
        }
    }

    private final void renderPackageFragment(PackageFragmentDescriptor fragment, StringBuilder builder) {
        this.renderPackageHeader(fragment.getFqName(), "package-fragment", builder);
        if (this.getDebugMode()) {
            builder.append(" in ");
            this.renderName(fragment.getContainingDeclaration(), builder, false);
        }
    }

    private final void renderPackageHeader(FqName fqName, String fragmentOrView, StringBuilder builder) {
        builder.append(this.renderKeyword(fragmentOrView));
        String fqNameString = this.renderFqName(fqName.toUnsafe());
        if (((CharSequence)fqNameString).length() > 0) {
            builder.append(" ");
            builder.append(fqNameString);
        }
    }

    private final void renderAccessorModifiers(PropertyAccessorDescriptor descriptor2, StringBuilder builder) {
        this.renderMemberModifiers(descriptor2, builder);
    }

    private final void renderSpaceIfNeeded(StringBuilder builder) {
        int length = builder.length();
        if (length == 0 || builder.charAt(length - 1) != ' ') {
            builder.append(' ');
        }
    }

    private final boolean overridesSomething(CallableMemberDescriptor callable) {
        return !callable.getOverriddenDescriptors().isEmpty();
    }

    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    @Override
    public void setWithDefinedIn(boolean bl2) {
        this.options.setWithDefinedIn(bl2);
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    @Override
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    @Override
    public void setStartFromName(boolean bl2) {
        this.options.setStartFromName(bl2);
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    @Override
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    @Override
    public void setDebugMode(boolean bl2) {
        this.options.setDebugMode(bl2);
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    @Override
    public void setVerbose(boolean bl2) {
        this.options.setVerbose(bl2);
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    @Override
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    @NotNull
    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    @Override
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter((Object)renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override
    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    @Override
    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    @Override
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter((Object)annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    @Override
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter((Object)parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override
    public void setWithoutTypeParameters(boolean bl2) {
        this.options.setWithoutTypeParameters(bl2);
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    @Override
    public void setReceiverAfterName(boolean bl2) {
        this.options.setReceiverAfterName(bl2);
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    @Override
    public void setRenderCompanionObjectName(boolean bl2) {
        this.options.setRenderCompanionObjectName(bl2);
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    @Override
    public void setWithoutSuperTypes(boolean bl2) {
        this.options.setWithoutSuperTypes(bl2);
    }

    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderAbbreviatedTypeComments() {
        return this.options.getRenderAbbreviatedTypeComments();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    private static final Unit functionTypeAnnotationsRenderer_delegate$lambda$1$lambda$0(DescriptorRendererOptions $this$withOptions) {
        Intrinsics.checkNotNullParameter($this$withOptions, "$this$withOptions");
        FqName[] fqNameArray = new FqName[]{StandardNames.FqNames.extensionFunctionType, StandardNames.FqNames.contextFunctionTypeParams};
        $this$withOptions.setExcludedTypeAnnotationClasses(SetsKt.plus($this$withOptions.getExcludedTypeAnnotationClasses(), (Iterable)CollectionsKt.listOf(fqNameArray)));
        return Unit.INSTANCE;
    }

    private static final DescriptorRendererImpl functionTypeAnnotationsRenderer_delegate$lambda$1(DescriptorRendererImpl this$0) {
        DescriptorRenderer descriptorRenderer = this$0.withOptions(DescriptorRendererImpl$$Lambda$5.INSTANCE);
        Intrinsics.checkNotNull(descriptorRenderer, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (DescriptorRendererImpl)descriptorRenderer;
    }

    private static final Object renderTypeConstructor$lambda$8(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof StubTypeForBuilderInference ? ((StubTypeForBuilderInference)it).getOriginalTypeVariable() : it;
    }

    private static final CharSequence appendTypeProjections$lambda$10(DescriptorRendererImpl this$0, TypeProjection it) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isStarProjection()) {
            charSequence = "*";
        } else {
            KotlinType kotlinType = it.getType();
            Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
            String type = this$0.renderType(kotlinType);
            charSequence = it.getProjectionKind() == Variance.INVARIANT ? type : (Object)((Object)it.getProjectionKind()) + ' ' + type;
        }
        return charSequence;
    }

    private static final CharSequence renderConstructor$lambda$26(ValueParameterDescriptor it) {
        return "";
    }

    private static final CharSequence renderSuperTypes$lambda$36(DescriptorRendererImpl this$0, KotlinType it) {
        Intrinsics.checkNotNull(it);
        return this$0.renderType(it);
    }

    static /* synthetic */ DescriptorRendererImpl accessor$DescriptorRendererImpl$lambda0(DescriptorRendererImpl descriptorRendererImpl) {
        return DescriptorRendererImpl.functionTypeAnnotationsRenderer_delegate$lambda$1(descriptorRendererImpl);
    }

    static /* synthetic */ Object accessor$DescriptorRendererImpl$lambda1(KotlinType kotlinType) {
        return DescriptorRendererImpl.renderTypeConstructor$lambda$8(kotlinType);
    }

    static /* synthetic */ CharSequence accessor$DescriptorRendererImpl$lambda2(DescriptorRendererImpl descriptorRendererImpl, TypeProjection typeProjection) {
        return DescriptorRendererImpl.appendTypeProjections$lambda$10(descriptorRendererImpl, typeProjection);
    }

    static /* synthetic */ CharSequence accessor$DescriptorRendererImpl$lambda3(ValueParameterDescriptor valueParameterDescriptor) {
        return DescriptorRendererImpl.renderConstructor$lambda$26(valueParameterDescriptor);
    }

    static /* synthetic */ CharSequence accessor$DescriptorRendererImpl$lambda4(DescriptorRendererImpl descriptorRendererImpl, KotlinType kotlinType) {
        return DescriptorRendererImpl.renderSuperTypes$lambda$36(descriptorRendererImpl, kotlinType);
    }

    static /* synthetic */ Unit accessor$DescriptorRendererImpl$lambda5(DescriptorRendererOptions descriptorRendererOptions) {
        return DescriptorRendererImpl.functionTypeAnnotationsRenderer_delegate$lambda$1$lambda$0(descriptorRendererOptions);
    }

    private final class RenderDeclarationDescriptorVisitor
    implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        @Override
        public void visitValueParameterDescriptor(@NotNull ValueParameterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderValueParameter(descriptor2, true, builder, true);
        }

        @Override
        public void visitPropertyDescriptor(@NotNull PropertyDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderProperty(descriptor2, builder);
        }

        @Override
        public void visitPropertyGetterDescriptor(@NotNull PropertyGetterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.visitPropertyAccessorDescriptor(descriptor2, builder, "getter");
        }

        @Override
        public void visitPropertySetterDescriptor(@NotNull PropertySetterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.visitPropertyAccessorDescriptor(descriptor2, builder, "setter");
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor descriptor2, StringBuilder builder, String kind2) {
            switch (WhenMappings.$EnumSwitchMapping$0[DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()]) {
                case 1: {
                    DescriptorRendererImpl.this.renderAccessorModifiers(descriptor2, builder);
                    builder.append(kind2 + " for ");
                    PropertyDescriptor propertyDescriptor = descriptor2.getCorrespondingProperty();
                    Intrinsics.checkNotNullExpressionValue(propertyDescriptor, "getCorrespondingProperty(...)");
                    DescriptorRendererImpl.this.renderProperty(propertyDescriptor, builder);
                    break;
                }
                case 2: {
                    this.visitFunctionDescriptor((FunctionDescriptor)descriptor2, builder);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        @Override
        public void visitFunctionDescriptor(@NotNull FunctionDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderFunction(descriptor2, builder);
        }

        @Override
        public void visitReceiverParameterDescriptor(@NotNull ReceiverParameterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            builder.append(descriptor2.getName());
        }

        @Override
        public void visitConstructorDescriptor(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, builder);
        }

        @Override
        public void visitTypeParameterDescriptor(@NotNull TypeParameterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderTypeParameter(descriptor2, builder, true);
        }

        @Override
        public void visitPackageFragmentDescriptor(@NotNull PackageFragmentDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderPackageFragment(descriptor2, builder);
        }

        @Override
        public void visitPackageViewDescriptor(@NotNull PackageViewDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderPackageView(descriptor2, builder);
        }

        @Override
        public void visitModuleDeclaration(@NotNull ModuleDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderName(descriptor2, builder, true);
        }

        @Override
        public void visitClassDescriptor(@NotNull ClassDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderClass(descriptor2, builder);
        }

        @Override
        public void visitTypeAliasDescriptor(@NotNull TypeAliasDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderTypeAlias(descriptor2, builder);
        }

        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[PropertyAccessorRenderingPolicy.values().length];
                try {
                    nArray[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[RenderingFormat.values().length];
            try {
                nArray[RenderingFormat.PLAIN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[RenderingFormat.HTML.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[ParameterNameRenderingPolicy.values().length];
            try {
                nArray[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nRawType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawType.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawTypeImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n1740#2,3:99\n1563#2:102\n1634#2,3:103\n*S KotlinDebug\n*F\n+ 1 RawType.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawTypeImpl\n*L\n80#1:99,3\n61#1:102\n61#1:103,3\n*E\n"})
public final class RawTypeImpl
extends FlexibleType
implements RawType {
    private RawTypeImpl(SimpleType lowerBound, SimpleType upperBound, boolean disableAssertion) {
        super(lowerBound, upperBound);
        if (!disableAssertion) {
            boolean bl2 = KotlinTypeChecker.DEFAULT.isSubtypeOf(lowerBound, upperBound);
            if (_Assertions.ENABLED && !bl2) {
                boolean bl3 = false;
                String string = "Lower bound " + lowerBound + " of a flexible type must be a subtype of the upper bound " + upperBound;
                throw new AssertionError((Object)string);
            }
        }
    }

    public RawTypeImpl(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        this(lowerBound, upperBound, false);
    }

    @Override
    @NotNull
    public SimpleType getDelegate() {
        return this.getLowerBound();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        ClassifierDescriptor classifierDescriptor = this.getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalStateException(("Incorrect classifier: " + this.getConstructor().getDeclarationDescriptor()).toString());
        }
        ClassDescriptor classDescriptor2 = classDescriptor;
        MemberScope memberScope = classDescriptor2.getMemberScope(new RawSubstitution(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
        return memberScope;
    }

    @Override
    @NotNull
    public RawTypeImpl replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new RawTypeImpl(this.getLowerBound().replaceAttributes(newAttributes), this.getUpperBound().replaceAttributes(newAttributes));
    }

    @Override
    @NotNull
    public RawTypeImpl makeNullableAsSpecified(boolean newNullability) {
        return new RawTypeImpl(this.getLowerBound().makeNullableAsSpecified(newNullability), this.getUpperBound().makeNullableAsSpecified(newNullability));
    }

    @Override
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        boolean bl2;
        String newArgs;
        String upperRendered;
        String lowerRendered;
        block6: {
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            Intrinsics.checkNotNullParameter(options, "options");
            lowerRendered = renderer.renderType(this.getLowerBound());
            upperRendered = renderer.renderType(this.getUpperBound());
            if (options.getDebugMode()) {
                return "raw (" + lowerRendered + ".." + upperRendered + ')';
            }
            if (this.getUpperBound().getArguments().isEmpty()) {
                return renderer.renderFlexibleType(lowerRendered, upperRendered, TypeUtilsKt.getBuiltIns(this));
            }
            List<String> lowerArgs = RawTypeImpl.render$renderArguments(renderer, this.getLowerBound());
            List<String> upperArgs = RawTypeImpl.render$renderArguments(renderer, this.getUpperBound());
            newArgs = CollectionsKt.joinToString$default(lowerArgs, ", ", null, null, 0, null, RawTypeImpl$$Lambda$0.INSTANCE, 30, null);
            Iterable $this$all$iv = CollectionsKt.zip((Iterable)lowerArgs, (Iterable)upperArgs);
            boolean $i$f$all = false;
            if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                bl2 = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    Pair it = (Pair)element$iv;
                    boolean bl3 = false;
                    if (RawTypeImpl.render$onlyOutDiffers((String)it.getFirst(), (String)it.getSecond())) continue;
                    bl2 = false;
                    break block6;
                }
                bl2 = true;
            }
        }
        String newUpper = bl2 ? RawTypeImpl.render$replaceArgs(upperRendered, newArgs) : upperRendered;
        String newLower = RawTypeImpl.render$replaceArgs(lowerRendered, newArgs);
        if (Intrinsics.areEqual(newLower, newUpper)) {
            return newLower;
        }
        return renderer.renderFlexibleType(newLower, newUpper, TypeUtilsKt.getBuiltIns(this));
    }

    @Override
    @NotNull
    public FlexibleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType kotlinType = kotlinTypeRefiner.refineType(this.getLowerBound());
        Intrinsics.checkNotNull(kotlinType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        SimpleType simpleType = (SimpleType)kotlinType;
        KotlinType kotlinType2 = kotlinTypeRefiner.refineType(this.getUpperBound());
        Intrinsics.checkNotNull(kotlinType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl(simpleType, (SimpleType)kotlinType2, true);
    }

    private static final boolean render$onlyOutDiffers(String first, String second) {
        return Intrinsics.areEqual(first, StringsKt.removePrefix(second, (CharSequence)"out ")) || Intrinsics.areEqual(second, "*");
    }

    /*
     * WARNING - void declaration
     */
    private static final List<String> render$renderArguments(DescriptorRenderer $renderer, KotlinType type) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = type.getArguments();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add($renderer.renderTypeProjection((TypeProjection)it));
        }
        return (List)destination$iv$iv;
    }

    private static final String render$replaceArgs(String $this$render_u24replaceArgs, String newArgs) {
        if (!StringsKt.contains$default((CharSequence)$this$render_u24replaceArgs, '<', false, 2, null)) {
            return $this$render_u24replaceArgs;
        }
        return StringsKt.substringBefore$default($this$render_u24replaceArgs, '<', null, 2, null) + '<' + newArgs + '>' + StringsKt.substringAfterLast$default($this$render_u24replaceArgs, '>', null, 2, null);
    }

    private static final CharSequence render$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "(raw) " + it;
    }

    static /* synthetic */ CharSequence accessor$RawTypeImpl$lambda0(String string) {
        return RawTypeImpl.render$lambda$2(string);
    }
}


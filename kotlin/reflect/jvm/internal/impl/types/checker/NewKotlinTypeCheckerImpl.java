/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public final class NewKotlinTypeCheckerImpl
implements NewKotlinTypeChecker {
    @NotNull
    private final KotlinTypeRefiner kotlinTypeRefiner;
    @NotNull
    private final KotlinTypePreparator kotlinTypePreparator;
    @NotNull
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(@NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull KotlinTypePreparator kotlinTypePreparator) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        OverridingUtil overridingUtil = OverridingUtil.createWithTypeRefiner(this.getKotlinTypeRefiner());
        Intrinsics.checkNotNullExpressionValue(overridingUtil, "createWithTypeRefiner(...)");
        this.overridingUtil = overridingUtil;
    }

    public /* synthetic */ NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            kotlinTypePreparator = KotlinTypePreparator.Default.INSTANCE;
        }
        this(kotlinTypeRefiner, kotlinTypePreparator);
    }

    @Override
    @NotNull
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    @NotNull
    public KotlinTypePreparator getKotlinTypePreparator() {
        return this.kotlinTypePreparator;
    }

    @Override
    @NotNull
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    @Override
    public boolean isSubtypeOf(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        Intrinsics.checkNotNullParameter(subtype, "subtype");
        Intrinsics.checkNotNullParameter(supertype, "supertype");
        KotlinTypeRefiner kotlinTypeRefiner = this.getKotlinTypeRefiner();
        KotlinTypePreparator kotlinTypePreparator = this.getKotlinTypePreparator();
        return this.isSubtypeOf(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, null, kotlinTypePreparator, kotlinTypeRefiner, 6, null), subtype.unwrap(), supertype.unwrap());
    }

    @Override
    public boolean equalTypes(@NotNull KotlinType a2, @NotNull KotlinType b2) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        KotlinTypeRefiner kotlinTypeRefiner = this.getKotlinTypeRefiner();
        KotlinTypePreparator kotlinTypePreparator = this.getKotlinTypePreparator();
        return this.equalTypes(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, null, kotlinTypePreparator, kotlinTypeRefiner, 6, null), a2.unwrap(), b2.unwrap());
    }

    public final boolean equalTypes(@NotNull TypeCheckerState $this$equalTypes, @NotNull UnwrappedType a2, @NotNull UnwrappedType b2) {
        Intrinsics.checkNotNullParameter($this$equalTypes, "<this>");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes($this$equalTypes, a2, b2);
    }

    public final boolean isSubtypeOf(@NotNull TypeCheckerState $this$isSubtypeOf, @NotNull UnwrappedType subType, @NotNull UnwrappedType superType) {
        Intrinsics.checkNotNullParameter($this$isSubtypeOf, "<this>");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, $this$isSubtypeOf, subType, superType, false, 8, null);
    }
}


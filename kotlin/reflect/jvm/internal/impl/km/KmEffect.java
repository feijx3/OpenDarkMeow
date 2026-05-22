/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.contracts.ExperimentalContracts
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmEffectExpression;
import kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind;
import kotlin.reflect.jvm.internal.impl.km.KmEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalContracts
public final class KmEffect {
    @NotNull
    private KmEffectType type;
    @Nullable
    private KmEffectInvocationKind invocationKind;
    @NotNull
    private final List<KmEffectExpression> constructorArguments;
    @Nullable
    private KmEffectExpression conclusion;

    public KmEffect(@NotNull KmEffectType type, @Nullable KmEffectInvocationKind invocationKind) {
        Intrinsics.checkNotNullParameter((Object)type, "type");
        this.type = type;
        this.invocationKind = invocationKind;
        this.constructorArguments = new ArrayList(1);
    }

    @NotNull
    public final List<KmEffectExpression> getConstructorArguments() {
        return this.constructorArguments;
    }

    public final void setConclusion(@Nullable KmEffectExpression kmEffectExpression) {
        this.conclusion = kmEffectExpression;
    }
}


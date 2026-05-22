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
import kotlin.reflect.jvm.internal.impl.km.KmConstantValue;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalContracts
public final class KmEffectExpression {
    private int flags;
    @Nullable
    private Integer parameterIndex;
    @Nullable
    private KmConstantValue constantValue;
    @Nullable
    private KmType isInstanceType;
    @NotNull
    private final List<KmEffectExpression> andArguments = new ArrayList(0);
    @NotNull
    private final List<KmEffectExpression> orArguments = new ArrayList(0);

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int n2) {
        this.flags = n2;
    }

    public final void setParameterIndex(@Nullable Integer n2) {
        this.parameterIndex = n2;
    }

    public final void setConstantValue(@Nullable KmConstantValue kmConstantValue) {
        this.constantValue = kmConstantValue;
    }

    public final void setInstanceType(@Nullable KmType kmType) {
        this.isInstanceType = kmType;
    }

    @NotNull
    public final List<KmEffectExpression> getAndArguments() {
        return this.andArguments;
    }

    @NotNull
    public final List<KmEffectExpression> getOrArguments() {
        return this.orArguments;
    }
}


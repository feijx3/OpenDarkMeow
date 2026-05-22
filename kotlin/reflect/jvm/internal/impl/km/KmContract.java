/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.contracts.ExperimentalContracts
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import kotlin.contracts.ExperimentalContracts;
import kotlin.reflect.jvm.internal.impl.km.KmEffect;
import org.jetbrains.annotations.NotNull;

@ExperimentalContracts
public final class KmContract {
    @NotNull
    private final List<KmEffect> effects = new ArrayList(1);

    @NotNull
    public final List<KmEffect> getEffects() {
        return this.effects;
    }
}


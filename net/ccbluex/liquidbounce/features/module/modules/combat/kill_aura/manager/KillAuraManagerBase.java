/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.manager;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/manager/KillAuraManagerBase;", "", "<init>", "()V", "module", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "setModule", "(Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "DarkMeow"})
public abstract class KillAuraManagerBase {
    public KillAura module;

    @NotNull
    public final KillAura getModule() {
        KillAura killAura = this.module;
        if (killAura != null) {
            return killAura;
        }
        Intrinsics.throwUninitializedPropertyAccessException("module");
        return null;
    }

    public final void setModule(@NotNull KillAura killAura) {
        Intrinsics.checkNotNullParameter(killAura, "<set-?>");
        this.module = killAura;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }
}


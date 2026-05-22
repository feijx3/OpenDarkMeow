/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="IQBoost", description="Improve your IQ.", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/IQBoost;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "iq", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
public final class IQBoost
extends Module {
    @NotNull
    private final FloatValue iq = new FloatValue("IQ", 114514.0f, 0.0f, 337522.0f);

    public IQBoost() {
        super(null, null, null, null, 15, null);
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(((Number)this.iq.get()).floatValue());
    }
}


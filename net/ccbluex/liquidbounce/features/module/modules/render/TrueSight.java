/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="TrueSight", description="Allows you to see invisible entities and barriers.", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/TrueSight;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "barriersValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getBarriersValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "entitiesValue", "getEntitiesValue", "DarkMeow"})
public final class TrueSight
extends Module {
    @NotNull
    private final BoolValue barriersValue = new BoolValue("Barriers", true);
    @NotNull
    private final BoolValue entitiesValue = new BoolValue("Entities", true);

    public TrueSight() {
        super(null, null, null, null, 15, null);
    }

    @NotNull
    public final BoolValue getBarriersValue() {
        return this.barriersValue;
    }

    @NotNull
    public final BoolValue getEntitiesValue() {
        return this.entitiesValue;
    }
}


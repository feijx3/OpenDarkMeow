/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketScoreboardObjective
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.server.SPacketScoreboardObjective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketScoreboardObjective.class})
public interface AccessorSPacketScoreboardObjective {
    @Accessor(value="objectiveName")
    public String func_149339_c();

    @Accessor(value="objectiveName")
    public void setObjectiveName(String var1);

    @Accessor(value="objectiveValue")
    public String func_149337_d();

    @Accessor(value="objectiveValue")
    public void setObjectiveValue(String var1);

    @Accessor(value="action")
    public int func_149338_e();

    @Accessor(value="action")
    public void setAction(int var1);
}


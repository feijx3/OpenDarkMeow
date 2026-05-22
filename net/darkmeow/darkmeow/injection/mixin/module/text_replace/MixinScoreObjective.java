/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.scoreboard.IScoreCriteria
 *  net.minecraft.scoreboard.ScoreObjective
 *  net.minecraft.scoreboard.Scoreboard
 */
package net.darkmeow.darkmeow.injection.mixin.module.text_replace;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.misc.TextReplace;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ScoreObjective.class})
public class MixinScoreObjective {
    @Shadow
    private String field_96683_d;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void init$replace(Scoreboard scoreboard, String nameIn, IScoreCriteria objectiveCriteriaIn, CallbackInfo ci2) {
        if (!DarkMeow.isStarting && TextReplace.INSTANCE.getState()) {
            this.field_96683_d = TextReplace.replace(nameIn);
        }
    }

    @Inject(method={"setDisplayName"}, at={@At(value="INVOKE", target="Lnet/minecraft/scoreboard/Scoreboard;onObjectiveDisplayNameChanged(Lnet/minecraft/scoreboard/ScoreObjective;)V")})
    public void setDisplayName$replace(String nameIn, CallbackInfo ci2) {
        if (!DarkMeow.isStarting && TextReplace.INSTANCE.getState()) {
            this.field_96683_d = TextReplace.replace(nameIn);
        }
    }
}


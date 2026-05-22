/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.scoreboard.Score
 *  net.minecraft.scoreboard.ScoreObjective
 *  net.minecraft.scoreboard.Scoreboard
 */
package net.darkmeow.darkmeow.injection.mixin.module.text_replace;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.misc.TextReplace;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Score.class})
public class MixinScore {
    @Mutable
    @Shadow
    @Final
    private String field_96654_d;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void init$replace(Scoreboard scoreboard, ScoreObjective objective, String playerName, CallbackInfo ci2) {
        if (!DarkMeow.isStarting && TextReplace.INSTANCE.getState()) {
            this.field_96654_d = TextReplace.replace(playerName);
        }
    }
}


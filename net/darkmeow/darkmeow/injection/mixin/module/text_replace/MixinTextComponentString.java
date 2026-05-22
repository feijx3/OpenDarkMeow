/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.TextComponentString
 */
package net.darkmeow.darkmeow.injection.mixin.module.text_replace;

import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.misc.TextReplace;
import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TextComponentString.class})
public class MixinTextComponentString {
    @Mutable
    @Shadow
    @Final
    private String field_150267_b;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void init$replace(String msg, CallbackInfo ci2) {
        if (!DarkMeow.isStarting && TextReplace.INSTANCE.getState()) {
            this.field_150267_b = TextReplace.replace(msg);
        }
    }
}


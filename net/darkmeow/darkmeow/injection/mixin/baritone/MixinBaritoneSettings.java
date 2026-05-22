/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.baritone;

import baritone.api.Settings;
import net.ccbluex.liquidbounce.DarkMeow;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={Settings.class}, remap=false)
public class MixinBaritoneSettings {
    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void baritoneSettingsInit(CallbackInfo ci2) {
        DarkMeow.baritoneManager.setInitialized(true);
    }
}


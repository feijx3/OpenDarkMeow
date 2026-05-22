/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.util.MovementInputFromOptions
 */
package net.ccbluex.liquidbounce.injection.access.utils;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MovementInputFromOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={MovementInputFromOptions.class})
public interface AccessorMovementInputFromOptions {
    @Accessor(value="gameSettings")
    public GameSettings getGameSettings();
}


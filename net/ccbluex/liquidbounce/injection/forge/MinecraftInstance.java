/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package net.ccbluex.liquidbounce.injection.forge;

import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
import net.minecraft.client.Minecraft;

@Deprecated
public class MinecraftInstance {
    @Deprecated
    public static final Minecraft mc_nowarp = Minecraft.func_71410_x();
    @Deprecated
    public static final MinecraftImpl mc = new MinecraftImpl(mc_nowarp);
}


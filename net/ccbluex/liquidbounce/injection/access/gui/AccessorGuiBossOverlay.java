/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.BossInfoClient
 *  net.minecraft.client.gui.GuiBossOverlay
 *  net.minecraft.world.BossInfo
 */
package net.ccbluex.liquidbounce.injection.access.gui;

import java.util.Map;
import java.util.UUID;
import net.minecraft.client.gui.BossInfoClient;
import net.minecraft.client.gui.GuiBossOverlay;
import net.minecraft.world.BossInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={GuiBossOverlay.class})
public interface AccessorGuiBossOverlay {
    @Accessor(value="mapBossInfos")
    public Map<UUID, BossInfoClient> getMapBossInfos();

    @Invoker(value="render")
    public void invokeRender(int var1, int var2, BossInfo var3);
}


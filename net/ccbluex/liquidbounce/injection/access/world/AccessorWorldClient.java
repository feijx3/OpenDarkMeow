/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.client.multiplayer.WorldClient
 */
package net.ccbluex.liquidbounce.injection.access.world;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={WorldClient.class})
public interface AccessorWorldClient {
    @Accessor(value="clientChunkProvider")
    public void setClientChunkProvider(ChunkProviderClient var1);
}


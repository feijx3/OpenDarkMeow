/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.world.chunk.Chunk
 */
package net.ccbluex.liquidbounce.injection.access.world;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ChunkProviderClient.class})
public interface AccessorChuckProviderClient {
    @Accessor(value="loadedChunks")
    public Long2ObjectMap<Chunk> getLoadedChunks();
}


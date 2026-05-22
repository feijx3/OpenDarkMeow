/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.IChunkProvider
 */
package net.ccbluex.liquidbounce.injection.access.world;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={World.class})
public interface AccessorWorld {
    @Accessor(value="chunkProvider")
    public void setChunkProvider(IChunkProvider var1);
}


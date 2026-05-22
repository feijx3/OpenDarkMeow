/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  net.minecraft.client.multiplayer.ChunkProviderClient
 *  net.minecraft.world.chunk.Chunk
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.world;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.world.AccessorChuckProviderClient;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.chunk.Chunk;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/world/ExtendChunkProviderClient;", "", "<init>", "()V", "loadedChunks", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "Lnet/minecraft/world/chunk/Chunk;", "Lnet/minecraft/client/multiplayer/ChunkProviderClient;", "getLoadedChunks", "(Lnet/minecraft/client/multiplayer/ChunkProviderClient;)Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "DarkMeow"})
public final class ExtendChunkProviderClient {
    @NotNull
    public static final ExtendChunkProviderClient INSTANCE = new ExtendChunkProviderClient();

    private ExtendChunkProviderClient() {
    }

    @NotNull
    public final Long2ObjectMap<Chunk> getLoadedChunks(@NotNull ChunkProviderClient $this$loadedChunks) {
        Intrinsics.checkNotNullParameter($this$loadedChunks, "<this>");
        Long2ObjectMap<Chunk> long2ObjectMap = ((AccessorChuckProviderClient)$this$loadedChunks).getLoadedChunks();
        Intrinsics.checkNotNullExpressionValue(long2ObjectMap, "getLoadedChunks(...)");
        return long2ObjectMap;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/event/events/world/WorldSetBlockStateEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "pos", "Lnet/minecraft/util/math/BlockPos;", "state", "Lnet/minecraft/block/state/IBlockState;", "flags", "", "<init>", "(Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)V", "getWorld", "()Lnet/minecraft/client/multiplayer/WorldClient;", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "getState", "()Lnet/minecraft/block/state/IBlockState;", "getFlags", "()I", "DarkMeow"})
public final class WorldSetBlockStateEvent
extends CancellableEvent {
    @NotNull
    private final WorldClient world;
    @NotNull
    private final BlockPos pos;
    @NotNull
    private final IBlockState state;
    private final int flags;

    public WorldSetBlockStateEvent(@NotNull WorldClient world, @NotNull BlockPos pos, @NotNull IBlockState state, int flags) {
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(state, "state");
        this.world = world;
        this.pos = pos;
        this.state = state;
        this.flags = flags;
    }

    @NotNull
    public final WorldClient getWorld() {
        return this.world;
    }

    @NotNull
    public final BlockPos getPos() {
        return this.pos;
    }

    @NotNull
    public final IBlockState getState() {
        return this.state;
    }

    public final int getFlags() {
        return this.flags;
    }
}


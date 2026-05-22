/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.world;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/event/events/world/WorldSetBlockActionEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "pos", "Lnet/minecraft/util/math/BlockPos;", "block", "Lnet/minecraft/block/Block;", "id", "", "param", "<init>", "(Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;II)V", "getWorld", "()Lnet/minecraft/client/multiplayer/WorldClient;", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "getBlock", "()Lnet/minecraft/block/Block;", "getId", "()I", "getParam", "DarkMeow"})
public final class WorldSetBlockActionEvent
extends CancellableEvent {
    @NotNull
    private final WorldClient world;
    @NotNull
    private final BlockPos pos;
    @NotNull
    private final Block block;
    private final int id;
    private final int param;

    public WorldSetBlockActionEvent(@NotNull WorldClient world, @NotNull BlockPos pos, @NotNull Block block, int id, int param) {
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(block, "block");
        this.world = world;
        this.pos = pos;
        this.block = block;
        this.id = id;
        this.param = param;
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
    public final Block getBlock() {
        return this.block;
    }

    public final int getId() {
        return this.id;
    }

    public final int getParam() {
        return this.param;
    }
}


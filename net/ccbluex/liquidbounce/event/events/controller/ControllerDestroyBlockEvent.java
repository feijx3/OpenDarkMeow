/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/controller/ControllerDestroyBlockEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "pos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "<init>", "(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)V", "getPos", "()Lnet/minecraft/util/math/BlockPos;", "getFacing", "()Lnet/minecraft/util/EnumFacing;", "DarkMeow"})
public final class ControllerDestroyBlockEvent
extends CancellableEvent {
    @NotNull
    private final BlockPos pos;
    @NotNull
    private final EnumFacing facing;

    public ControllerDestroyBlockEvent(@NotNull BlockPos pos, @NotNull EnumFacing facing) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(facing, "facing");
        this.pos = pos;
        this.facing = facing;
    }

    @NotNull
    public final BlockPos getPos() {
        return this.pos;
    }

    @NotNull
    public final EnumFacing getFacing() {
        return this.facing;
    }
}


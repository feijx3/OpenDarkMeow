/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.PacketBuffer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.network.buffer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/network/buffer/PacketBufferWriteEnumValueEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "buffer", "Lnet/minecraft/network/PacketBuffer;", "value", "", "<init>", "(Lnet/minecraft/network/PacketBuffer;Ljava/lang/Enum;)V", "getBuffer", "()Lnet/minecraft/network/PacketBuffer;", "getValue", "()Ljava/lang/Enum;", "DarkMeow"})
public final class PacketBufferWriteEnumValueEvent
extends CancellableEvent {
    @NotNull
    private final PacketBuffer buffer;
    @NotNull
    private final Enum<?> value;

    public PacketBufferWriteEnumValueEvent(@NotNull PacketBuffer buffer, @NotNull Enum<?> value) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(value, "value");
        this.buffer = buffer;
        this.value = value;
    }

    @NotNull
    public final PacketBuffer getBuffer() {
        return this.buffer;
    }

    @NotNull
    public final Enum<?> getValue() {
        return this.value;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.packet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.network.AccessorSPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityStatus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/packet/ExtendSPacketEntityStatus;", "", "<init>", "()V", "entityId", "", "Lnet/minecraft/network/play/server/SPacketEntityStatus;", "getEntityId", "(Lnet/minecraft/network/play/server/SPacketEntityStatus;)I", "DarkMeow"})
public final class ExtendSPacketEntityStatus {
    @NotNull
    public static final ExtendSPacketEntityStatus INSTANCE = new ExtendSPacketEntityStatus();

    private ExtendSPacketEntityStatus() {
    }

    public final int getEntityId(@NotNull SPacketEntityStatus $this$entityId) {
        Intrinsics.checkNotNullParameter($this$entityId, "<this>");
        return ((AccessorSPacketEntityStatus)$this$entityId).getEntityId();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.modules.base.NoSlowBaseModeGrimAC;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketWindowItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimACLegacy;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/modules/base/NoSlowBaseModeGrimAC;", "name", "", "<init>", "(Ljava/lang/String;)V", "handleSPacketSetSlot", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "packet", "Lnet/minecraft/network/play/server/SPacketSetSlot;", "handleSPacketWindowItems", "Lnet/minecraft/network/play/server/SPacketWindowItems;", "DarkMeow"})
public abstract class NoSlowBaseModeGrimACLegacy
extends NoSlowBaseModeGrimAC {
    public NoSlowBaseModeGrimACLegacy(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        super(name);
    }

    @Override
    public void handleSPacketSetSlot(@NotNull SafeListenerBase $this$handleSPacketSetSlot, @NotNull SPacketSetSlot packet) {
        Intrinsics.checkNotNullParameter($this$handleSPacketSetSlot, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.func_149175_c() == 0) {
            int n2 = packet.func_149173_d();
            if (n2 == $this$handleSPacketSetSlot.getPlayer().field_71071_by.field_70461_c + 36) {
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketSetSlot, 1, 0, false, 6, null);
            } else if (n2 == 45) {
                NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketSetSlot, 0, 1, false, 5, null);
            }
        }
    }

    @Override
    public void handleSPacketWindowItems(@NotNull SafeListenerBase $this$handleSPacketWindowItems, @NotNull SPacketWindowItems packet) {
        Intrinsics.checkNotNullParameter($this$handleSPacketWindowItems, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet.func_148911_c() == 0) {
            NoSlowBaseModeGrimAC.markAllowNoSlow$default(this, $this$handleSPacketWindowItems, 1, 1, false, 4, null);
        }
    }
}


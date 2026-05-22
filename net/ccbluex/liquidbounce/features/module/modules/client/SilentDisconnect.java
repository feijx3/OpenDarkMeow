/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.resources.I18n
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.network.DisconnectEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="SilentDisconnect", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/SilentDisconnect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "notificationValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "freezeGameValue", "isDisconnect", "", "onDisconnect", "", "event", "Lnet/ccbluex/liquidbounce/event/events/network/DisconnectEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class SilentDisconnect
extends Module {
    @NotNull
    private final BoolValue notificationValue = new BoolValue("Notification", true);
    @NotNull
    private final BoolValue freezeGameValue = new BoolValue("FreezeGame", true);
    @JvmField
    public boolean isDisconnect;

    public SilentDisconnect() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onDisconnect(@NotNull DisconnectEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (((Boolean)this.notificationValue.get()).booleanValue()) {
            DarkMeow.INSTANCE.getMessageManager().displayChatMessage(I18n.func_135052_a((String)"disconnect.lost", (Object[])new Object[0]) + ':');
            MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
            String string = event.getReason().func_150254_d();
            Intrinsics.checkNotNullExpressionValue(string, "getFormattedText(...)");
            messageManager.displayChatMessage(string);
        }
        this.isDisconnect = true;
        event.cancelEvent();
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.isDisconnect = false;
    }

    @EventTarget(priority=2500)
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isDisconnect && ((Boolean)this.freezeGameValue.get()).booleanValue()) {
            event.cancelEventAndNext();
        }
    }
}


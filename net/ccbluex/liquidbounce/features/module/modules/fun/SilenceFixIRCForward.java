/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.render.AddMessageEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="SilenceFixIRCForward", category=ModuleCategory.FUN)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixIRCForward;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onAddMessage", "", "event", "Lnet/ccbluex/liquidbounce/event/events/render/AddMessageEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSilenceFixIRCForward.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SilenceFixIRCForward.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixIRCForward\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,21:1\n1#2:22\n*E\n"})
public final class SilenceFixIRCForward
extends Module {
    public SilenceFixIRCForward() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onAddMessage(@NotNull AddMessageEvent event) {
        block1: {
            String string;
            String string2;
            Intrinsics.checkNotNullParameter(event, "event");
            String it = string2 = event.getMessage().func_150260_c();
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            String string3 = string = StringsKt.startsWith$default(it, "\u00a77[\u00a7bSilenceFix-IRC\u00a77] ", false, 2, null) ? string2 : null;
            if (string == null) break block1;
            it = string2 = string;
            boolean bl3 = false;
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient != null) {
                CharSequence charSequence = it;
                Regex regex = new Regex("\u00a7[0-9a-zA-Z]");
                String string4 = "";
                netHandlerPlayClient.func_147297_a((Packet)new CPacketChatMessage(regex.replace(charSequence, string4)));
            }
        }
    }
}


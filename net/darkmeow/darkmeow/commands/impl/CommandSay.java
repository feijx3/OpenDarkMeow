/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/CommandSay;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "DarkMeow"})
public final class CommandSay
extends Command {
    public CommandSay() {
        String[] stringArray = new String[]{"Say"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(args.length == 0)) {
            NetHandlerPlayClient netHandlerPlayClient = mc.func_147114_u();
            if (netHandlerPlayClient != null) {
                netHandlerPlayClient.func_147297_a((Packet)new CPacketChatMessage(ArraysKt.joinToString$default(args, (CharSequence)" ", null, null, 0, null, null, 62, null)));
            }
        } else {
            system.getMessageManager().display.displayDarkCommandSyntax("say <message>");
        }
    }
}


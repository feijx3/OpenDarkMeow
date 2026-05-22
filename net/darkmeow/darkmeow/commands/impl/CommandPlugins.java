/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketTabComplete
 *  net.minecraft.network.play.server.SPacketTabComplete
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.network.play.server.SPacketTabComplete;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/CommandPlugins;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "checking", "", "pluginNames", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandPlugins.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandPlugins.kt\nnet/darkmeow/darkmeow/commands/impl/CommandPlugins\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,58:1\n739#2,9:59\n37#3:68\n36#3,3:69\n*S KotlinDebug\n*F\n+ 1 CommandPlugins.kt\nnet/darkmeow/darkmeow/commands/impl/CommandPlugins\n*L\n42#1:59,9\n42#1:68\n42#1:69,3\n*E\n"})
public final class CommandPlugins
extends Command {
    private boolean checking;
    @NotNull
    private final ArrayList<String> pluginNames;

    public CommandPlugins() {
        String[] stringArray = new String[]{"Plugins", "pl"};
        super(stringArray);
        this.pluginNames = new ArrayList();
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Unit unit;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        NetHandlerPlayClient netHandlerPlayClient = mc.func_147114_u();
        if (netHandlerPlayClient == null) {
            return;
        }
        NetHandlerPlayClient connection = netHandlerPlayClient;
        if (!mc.func_71356_B()) {
            this.checking = true;
            this.pluginNames.clear();
            connection.func_147297_a((Packet)new CPacketTabComplete("/", null, false));
            unit = system.getMessageManager().display.displayInfo("\u5c1d\u8bd5\u8bf7\u6c42\u63d2\u4ef6\u5217\u8868...");
        } else {
            unit = system.getMessageManager().display.displayError("\u5355\u4eba\u6e38\u620f\u5e76\u4e0d\u4f1a\u6709\u63d2\u4ef6...");
        }
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.checking) {
            return;
        }
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketTabComplete) {
            this.checking = false;
            String[] commands = ((SPacketTabComplete)packet).func_149630_c();
            ArrayList<String> plugins = new ArrayList<String>();
            Iterator<String> iterator2 = ArrayIteratorKt.iterator(commands);
            while (iterator2.hasNext()) {
                String pluginName;
                void $this$toTypedArray$iv;
                List list;
                Collection $this$dropLastWhile$iv;
                String command = iterator2.next();
                Intrinsics.checkNotNull(command);
                Object object = command;
                Regex regex = new Regex(":");
                int n2 = 0;
                object = regex.split((CharSequence)object, n2);
                boolean $i$f$dropLastWhile = false;
                if (!$this$dropLastWhile$iv.isEmpty()) {
                    ListIterator iterator$iv = $this$dropLastWhile$iv.listIterator($this$dropLastWhile$iv.size());
                    while (iterator$iv.hasPrevious()) {
                        String it = (String)iterator$iv.previous();
                        boolean bl2 = false;
                        if (((CharSequence)it).length() == 0) continue;
                        list = CollectionsKt.take($this$dropLastWhile$iv, iterator$iv.nextIndex() + 1);
                        break;
                    }
                } else {
                    list = CollectionsKt.emptyList();
                }
                $this$dropLastWhile$iv = list;
                boolean $i$f$toTypedArray = false;
                void thisCollection$iv = $this$toTypedArray$iv;
                String[] parts = thisCollection$iv.toArray(new String[0]);
                if (parts.length <= 1 || plugins.contains(pluginName = StringsKt.replace$default(parts[0], "/", "", false, 4, null))) continue;
                plugins.add(pluginName);
            }
            CollectionsKt.sort((List)plugins);
            Unit unit = !((Collection)plugins).isEmpty() ? DarkMeow.INSTANCE.getMessageManager().display.displaySuccess("\u63d2\u4ef6\u5217\u8868(\u5171" + plugins.size() + "\u4e2a):" + CollectionsKt.joinToString$default(plugins, "\u00a77, \u00a7b", "\u00a7d\u00a7l", "\u00a7b", 0, null, null, 56, null)) : DarkMeow.INSTANCE.getMessageManager().display.displayError("\u672a\u627e\u5230\u63d2\u4ef6");
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0002J1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/CommandServer;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "getColorFormatTps", "", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandServer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandServer.kt\nnet/darkmeow/darkmeow/commands/impl/CommandServer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,40:1\n1#2:41\n3829#3:42\n4344#3,2:43\n*S KotlinDebug\n*F\n+ 1 CommandServer.kt\nnet/darkmeow/darkmeow/commands/impl/CommandServer\n*L\n35#1:42\n35#1:43,2\n*E\n"})
public final class CommandServer
extends Command {
    public CommandServer() {
        String[] stringArray = new String[]{"Server"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        String string;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        String string2 = string = args.length == 0 ? "" : args[0];
        if (Intrinsics.areEqual(string, "info")) {
            Minecraft minecraft;
            Minecraft minecraft2;
            Minecraft it = minecraft2 = mc;
            boolean bl2 = false;
            Object object = minecraft = !it.func_71356_B() ? minecraft2 : null;
            if (minecraft != null && (minecraft2 = minecraft.func_147104_D()) != null) {
                Minecraft minecraft3;
                Minecraft server = minecraft3 = minecraft2;
                boolean bl3 = false;
                system.getMessageManager().displayChatMessage("\u00a7f\u670d\u52a1\u5668\u5730\u5740: \u00a7a" + server.field_78845_b);
                system.getMessageManager().displayChatMessage("\u00a7f\u670d\u52a1\u5668\u540d\u79f0: \u00a7a" + server.field_78847_a);
                system.getMessageManager().displayChatMessage("\u00a7f\u6e38\u620f\u7248\u672c: \u00a7a" + server.field_82821_f);
                system.getMessageManager().displayChatMessage("\u00a7f\u7f51\u7edc\u5ef6\u8fdf: \u00a7a" + server.field_78844_e);
                system.getMessageManager().displayChatMessage("\u00a7f\u662f\u5426\u4e3a\u5c40\u57df\u7f51\u6e38\u620f: \u00a7a" + server.func_181041_d());
            }
        } else if (Intrinsics.areEqual(string, "tps")) {
            system.getMessageManager().displayChatMessage("\u00a7f\u5f53\u524d\u670d\u52a1\u5668 TPS: " + this.getColorFormatTps(system.getNetworkManager().serverManager.getCurrentTps()));
        } else {
            system.getMessageManager().display.displayDarkCommandSyntax("server <info/tps>");
        }
    }

    private final String getColorFormatTps(double $this$getColorFormatTps) {
        double d2 = $this$getColorFormatTps;
        StringBuilder stringBuilder = new StringBuilder().append((15.0 <= d2 ? d2 <= 19.5 : false) ? "\u00a7e" : ((0.0 <= d2 ? d2 <= 15.0 : false) ? "\u00a7c" : "\u00a7a"));
        String string = "%.2f";
        Object[] objectArray = new Object[]{$this$getColorFormatTps};
        String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string2, "format(...)");
        return stringBuilder.append(string2).toString();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        List<String> list;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length == 1) {
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            String[] stringArray = new String[]{"info", "tps"};
            boolean $i$f$filter = false;
            void var6_6 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            int n2 = ((void)$this$filterTo$iv$iv).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                void element$iv$iv;
                void it = element$iv$iv = $this$filterTo$iv$iv[i2];
                boolean bl2 = false;
                if (!StringsKt.startsWith((String)it, ArraysKt.last(args), true)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = CollectionsKt.toList((List)destination$iv$iv);
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }
}


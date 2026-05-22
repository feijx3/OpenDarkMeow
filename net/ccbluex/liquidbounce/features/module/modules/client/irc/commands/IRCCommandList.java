/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.irc.commands;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.irc.IRCCommand;
import net.darkmeow.irc.client.interfaces.data.IRCDataOtherSessionInfo;
import net.darkmeow.irc.data.DataUser;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandList;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/irc/IRCCommand;", "<init>", "()V", "execute", "", "args", "", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCCommandList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCCommandList.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,65:1\n2767#2:66\n1878#2,2:68\n1880#2:74\n1#3:67\n205#4,4:70\n*S KotlinDebug\n*F\n+ 1 IRCCommandList.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/irc/commands/IRCCommandList\n*L\n17#1:66\n17#1:68,2\n17#1:74\n17#1:67\n23#1:70,4\n*E\n"})
public final class IRCCommandList
extends IRCCommand {
    public IRCCommandList() {
        String[] stringArray = new String[]{"list"};
        super(stringArray, true);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void execute(@NotNull List<String> args) {
        Iterable iterable;
        TextComponentString textComponentString;
        Intrinsics.checkNotNullParameter(args, "args");
        TextComponentString b2 = textComponentString = new TextComponentString("\u00a7f\u5f53\u524d\u5728\u7ebf\u7528\u6237: ");
        boolean bl2 = false;
        Iterable $this$onEachIndexed$iv = this.getInstance().irc.getSessionManager().getSessions().values();
        boolean $i$f$onEachIndexed = false;
        Iterable $this$onEachIndexed_u24lambda_u2419$iv = iterable = $this$onEachIndexed$iv;
        boolean bl3 = false;
        Iterable $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$forEachIndexed$iv$iv) {
            DataUser info;
            int n2;
            void $this$count$iv;
            void user;
            int n3;
            if ((n3 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            IRCDataOtherSessionInfo iRCDataOtherSessionInfo = (IRCDataOtherSessionInfo)item$iv$iv;
            int index = n3;
            boolean bl4 = false;
            Intrinsics.checkNotNullExpressionValue(user.getInfo(), "getInfo(...)");
            StringBuilder stringBuilder = new StringBuilder();
            ConcurrentHashMap<UUID, ? extends IRCDataOtherSessionInfo> concurrentHashMap = this.getInstance().irc.getSessionManager().getSessions();
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "getSessions(...)");
            Map map = concurrentHashMap;
            StringBuilder stringBuilder2 = stringBuilder;
            boolean $i$f$count = false;
            if ($this$count$iv.isEmpty()) {
                n2 = 0;
            } else {
                int count$iv = 0;
                Iterator iterator2 = $this$count$iv.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry element$iv;
                    Map.Entry it = element$iv = iterator2.next();
                    boolean bl5 = false;
                    if (!Intrinsics.areEqual(((IRCDataOtherSessionInfo)it.getValue()).getInfo().getName(), info.getName())) continue;
                    ++count$iv;
                }
                n2 = count$iv;
            }
            int n4 = n2;
            String string = stringBuilder2.append(n4 > 1 ? "\u00a76" : "").append(info.getName()).toString();
            Map $this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u241 = map = new TextComponentString(string);
            boolean bl6 = false;
            $this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u241.func_150255_a($this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u241.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString("\u00a7f\u7528\u6237\u540d: " + info.getName() + '\n' + ("\u00a7f\u7528\u6237\u6240\u5728\u7ec4: " + info.getPremium().name()) + '\n' + ("\u00a7f\u4f1a\u8bdd\u552f\u4e00\u6807\u8bc6: " + user.getUniqueId()) + '\n' + ("\u00a7f\u6e38\u620f\u5185ID: " + info.getState().getProfile().getName() + " (" + info.getState().getProfile().getId() + ')') + '\n' + ("\u00a7f\u6e38\u73a9\u670d\u52a1\u5668: " + info.getState().getCurrentServer()) + '\n' + ("\u00a7f\u662f\u5426\u4f1a\u653b\u51fbIRC\u5185\u5176\u4ed6\u7528\u6237: " + !info.getState().isFriend()) + '\n' + '\n' + "\u00a7f\u70b9\u51fb\u4ee5\u53d1\u8d77\u79c1\u804a"))));
            $this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u241.func_150255_a($this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u241.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/irc:private " + info.getName() + ' ')));
            Map c2 = map;
            boolean bl7 = false;
            b2.func_150257_a((ITextComponent)c2);
            if (index == this.getInstance().irc.getSessionManager().getSessions().size() - 1) continue;
            b2.func_150258_a("\u00a77, ");
        }
        if (this.getInstance().irc.getSessionManager().getSessions().values().isEmpty()) {
            b2.func_150258_a("\u00a7c\u83b7\u53d6\u5f02\u5e38 (\u8bf7\u68c0\u67e5\u5ba2\u6237\u7aef\u5728\u7ebf\u72b6\u6001)");
        }
        TextComponentString it = textComponentString;
        boolean bl8 = false;
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage((ITextComponent)it);
    }
}


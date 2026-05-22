/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.events.player.SendMessageEvent;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketChat;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendChat;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "prefixValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSFExtendChat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SFExtendChat.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendChat\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n13#2,2:37\n1#3:39\n*S KotlinDebug\n*F\n+ 1 SFExtendChat.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendChat\n*L\n23#1:37,2\n*E\n"})
public final class SFExtendChat
extends SFExtend {
    @JvmField
    @NotNull
    public final TextValue prefixValue = new TextValue("Prefix", ".i");
    @JvmField
    @NotNull
    public final BoolValue colorValue = new BoolValue("Color", true);

    /*
     * WARNING - void declaration
     */
    public SFExtendChat() {
        super("Chat", true, false, 4, null);
        void priority$iv;
        void $this$listener$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        int n2 = 2000;
        Function2<ListenerBase, SendMessageEvent, Unit> function$iv = (arg_0, arg_1) -> SFExtendChat._init_$lambda$3(this, arg_0, arg_1);
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$this$listener$iv).add(new EventHookOwnerCheck<SendMessageEvent>((int)priority$iv, function$iv, Reflection.getOrCreateKotlinClass(SendMessageEvent.class), (ListenableOwner)$this$listener$iv));
    }

    private static final Unit _init_$lambda$3(SFExtendChat this$0, ListenerBase $this$listener, SendMessageEvent event) {
        block3: {
            String string;
            String string2;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            String string3 = (String)event.getReturnValue();
            if (string3 == null) break block3;
            String it = string2 = string3;
            boolean bl2 = false;
            String string4 = string = StringsKt.startsWith$default(it, (String)this$0.prefixValue.get(), false, 2, null) ? string2 : null;
            if (string != null && (string2 = StringsKt.removePrefix(string, (CharSequence)this$0.prefixValue.get())) != null) {
                String string5 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
                if (string5 != null) {
                    String it2 = string5;
                    boolean bl3 = false;
                    String string6 = ((Boolean)this$0.colorValue.get()).booleanValue() ? StringsKt.replace$default(it2, "&", "\u00a7", false, 4, null) : it2;
                    if (string6 != null) {
                        String string7;
                        it2 = string7 = string6;
                        boolean bl4 = false;
                        this$0.getInstance().getClient().sendPacket(new SFC2SPacketChat(it2));
                        event.cancelEvent();
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}


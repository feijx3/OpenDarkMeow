/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketChat
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DPlayerTabOverlayEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHook;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketChat;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixUserTag;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "formatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "formatStyleValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "blockADValue", "users", "", "", "formated", "name", "onDisable", "", "tag", "getTag", "()Ljava/lang/String;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSilenceFixUserTag.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SilenceFixUserTag.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixUserTag\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,93:1\n16#2,3:94\n13#2,2:97\n12#2,3:99\n1#3:102\n774#4:103\n865#4,2:104\n1869#4,2:106\n*S KotlinDebug\n*F\n+ 1 SilenceFixUserTag.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixUserTag\n*L\n50#1:94,3\n67#1:97,2\n75#1:99,3\n70#1:103\n70#1:104,2\n71#1:106,2\n*E\n"})
public final class SilenceFixUserTag
extends Module {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final BoolValue formatValue = new BoolValue("Format", false);
    @JvmField
    @NotNull
    public final TextValue formatStyleValue = new TextValue("FormatStyle", "%name \u00a7a(\u5b66\u751f\u515a)");
    @JvmField
    @NotNull
    public final BoolValue blockADValue = new BoolValue("BlockAD", true);
    @JvmField
    @NotNull
    public final Set<String> users = new LinkedHashSet();
    @NotNull
    private static final String SILENCE_AD_BASE = "@?(SilenceFix Best|\\[\u6b23\u6b23\u516c\u76ca|\u6b23\u6b23\u516c\u76ca|\\[\u6b23\u6b23\u63d0\u9192|\\[SilenceFix)";
    @NotNull
    private static final Regex[] MESSAGES;

    public SilenceFixUserTag() {
        super("SilenceFixUserTag", ModuleCategory.FUN, null, null, 12, null);
        ListenableOwner $this$listener$iv;
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> SilenceFixUserTag._init_$lambda$7(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listenerAlways = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHook<PacketEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 2000;
        function$iv = (arg_0, arg_1) -> SilenceFixUserTag._init_$lambda$11(this, arg_0, arg_1);
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<PacketEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DPlayerTabOverlayEvent.PRE.class), $this$listener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$listener$iv = this;
        function$iv = (arg_0, arg_1) -> SilenceFixUserTag._init_$lambda$15(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<PacketEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityNameEvent.class), $receiver$iv));
    }

    @NotNull
    public final String formated(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.replace$default((String)this.formatStyleValue.get(), "%name", name, false, 4, null);
    }

    @Override
    public void onDisable() {
        KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74311_E;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindSneak");
        if (KeyUtils.INSTANCE.isKeyDownSystem(keyBinding)) {
            this.users.clear();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(this.users.size());
    }

    private static final Unit _init_$lambda$7(SilenceFixUserTag this$0, ListenerBase $this$listenerAlways, PacketEvent event) {
        block8: {
            String string;
            String string2;
            Intrinsics.checkNotNullParameter($this$listenerAlways, "$this$listenerAlways");
            Intrinsics.checkNotNullParameter(event, "event");
            Packet<?> packet = event.getPacket();
            if (!(packet instanceof SPacketChat)) break block8;
            String it = string2 = ((SPacketChat)packet).func_148915_c().func_150260_c();
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            String string3 = string = !StringsKt.contains$default((CharSequence)it, "IRC", false, 2, null) ? string2 : null;
            if (string != null) {
                String string4;
                String string5;
                block7: {
                    String text = string2 = string;
                    boolean bl3 = false;
                    for (Regex regex : MESSAGES) {
                        String string6;
                        boolean bl4 = false;
                        if (Regex.find$default(regex, text, 0, 2, null) != null) {
                            MatchResult it2;
                            boolean bl5 = false;
                            string6 = it2.getGroupValues().get(1);
                        } else {
                            string6 = null;
                        }
                        string5 = string6;
                        if (string6 == null) {
                            continue;
                        }
                        break block7;
                    }
                    string5 = null;
                }
                if ((string4 = string5) != null) {
                    String string7;
                    String string8;
                    String it3 = string8 = string4;
                    boolean bl6 = false;
                    this$0.users.add(it3);
                    String it4 = string7 = string8;
                    boolean bl7 = false;
                    String string9 = string8 = (Boolean)this$0.blockADValue.get() != false && this$0.getState() ? string7 : null;
                    if (string8 != null) {
                        it4 = string7 = string8;
                        boolean bl8 = false;
                        event.cancelEvent();
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$11(SilenceFixUserTag this$0, ListenerBase $this$listener, Render2DPlayerTabOverlayEvent.PRE event) {
        List<NetworkPlayerInfo> list;
        List<NetworkPlayerInfo> list2;
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        Iterable<Object> it = list2 = event.getList();
        boolean bl2 = false;
        List<Object> list3 = list = (Boolean)this$0.formatValue.get() != false ? list2 : null;
        if (list != null) {
            void $this$forEach$iv;
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            it = list;
            boolean $i$f$filter = false;
            Iterator iterator2 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                NetworkPlayerInfo it2 = (NetworkPlayerInfo)element$iv$iv;
                boolean bl3 = false;
                if (!this$0.users.contains(it2.func_178845_a().getName())) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                NetworkPlayerInfo it3 = (NetworkPlayerInfo)element$iv;
                boolean bl4 = false;
                ((Map)event.getOverwriteNames()).put(it3, this$0.formated(event.getPlayerName(it3, false)));
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$15(SilenceFixUserTag this$0, ListenerBase $this$listener, RenderEntityNameEvent event) {
        block1: {
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2;
            EntityLivingBase entityLivingBase3;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            EntityLivingBase it = entityLivingBase3 = event.getEntity();
            boolean bl2 = false;
            Object object = entityLivingBase2 = (Boolean)this$0.formatValue.get() != false ? entityLivingBase3 : null;
            if (entityLivingBase2 == null) break block1;
            EntityLivingBase it2 = entityLivingBase = entityLivingBase2;
            boolean bl3 = false;
            EntityLivingBase entityLivingBase4 = event.getEntity();
            EntityPlayer entityPlayer = entityLivingBase4 instanceof EntityPlayer ? (EntityPlayer)entityLivingBase4 : null;
            Object object2 = entityLivingBase3 = CollectionsKt.contains((Iterable)this$0.users, entityPlayer != null && (entityPlayer = entityPlayer.func_146103_bH()) != null ? entityPlayer.getName() : null) ? entityLivingBase : null;
            if (entityLivingBase3 != null) {
                it2 = entityLivingBase = entityLivingBase3;
                boolean bl4 = false;
                event.setDisplayName(this$0.formated(event.getDisplayName()));
            }
        }
        return Unit.INSTANCE;
    }

    static {
        Regex[] regexArray = new Regex[]{new Regex("\u00a7e\\[lv.*?]\u00a7r\u00a7f\u00a77<\u00a7f(.*?)\u00a77> \u00a77@?(SilenceFix Best|\\[\u6b23\u6b23\u516c\u76ca|\u6b23\u6b23\u516c\u76ca|\\[\u6b23\u6b23\u63d0\u9192|\\[SilenceFix)"), new Regex("(.*?): @?(SilenceFix Best|\\[\u6b23\u6b23\u516c\u76ca|\u6b23\u6b23\u516c\u76ca|\\[\u6b23\u6b23\u63d0\u9192|\\[SilenceFix)"), new Regex("<.*?\u4e4b\u961f>(.*?): @?(SilenceFix Best|\\[\u6b23\u6b23\u516c\u76ca|\u6b23\u6b23\u516c\u76ca|\\[\u6b23\u6b23\u63d0\u9192|\\[SilenceFix)"), new Regex("(?:\\(.*?\\) {1,2})?<(.*?)> @?(SilenceFix Best|\\[\u6b23\u6b23\u516c\u76ca|\u6b23\u6b23\u516c\u76ca|\\[\u6b23\u6b23\u63d0\u9192|\\[SilenceFix)")};
        MESSAGES = regexArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixUserTag$Companion;", "", "<init>", "()V", "SILENCE_AD_BASE", "", "MESSAGES", "", "Lkotlin/text/Regex;", "getMESSAGES", "()[Lkotlin/text/Regex;", "[Lkotlin/text/Regex;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Regex[] getMESSAGES() {
            return MESSAGES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


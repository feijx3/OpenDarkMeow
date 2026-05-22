/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.modules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.HytModule;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.GermGameManager;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.games.GermGame;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.games.GermGameCategory;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.client.CPacketHytGermOpenGUI;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytGermSelectGame;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/HytModule;", "<init>", "()V", "manager", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/GermGameManager;", "getManager", "()Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/GermGameManager;", "opened", "", "onWorld", "", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "printGermElementCategory", "printGermElementSingle", "group", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nHytGermSelectGame.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HytGermSelectGame.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytGermSelectGame\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,121:1\n1#2:122\n1#2:127\n1#2:129\n774#3:123\n865#3,2:124\n2756#3:126\n640#4:128\n*S KotlinDebug\n*F\n+ 1 HytGermSelectGame.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytGermSelectGame\n*L\n91#1:127\n108#1:129\n90#1:123\n90#1:124,2\n91#1:126\n108#1:128\n*E\n"})
public final class HytGermSelectGame
extends HytModule {
    @NotNull
    private final GermGameManager manager = new GermGameManager();
    private boolean opened;

    public HytGermSelectGame() {
        super("SelectGame");
    }

    @NotNull
    public final GermGameManager getManager() {
        return this.manager;
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.opened = false;
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof CPacketPlayerTryUseItem) {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP != null) {
                EntityPlayerSP entityPlayerSP2;
                EntityPlayerSP entityPlayerSP3;
                EntityPlayerSP player = entityPlayerSP3 = entityPlayerSP;
                boolean bl2 = false;
                Object object = entityPlayerSP2 = Intrinsics.areEqual(player.func_184614_ca().func_82833_r(), "\u00a7a\u00a7l\u9009\u62e9\u6e38\u620f\u00a77 (\u9f20\u6807\u70b9\u51fb) ") && player.field_71071_by.field_70461_c == 0 ? entityPlayerSP3 : null;
                if (entityPlayerSP2 != null) {
                    EntityPlayerSP it = entityPlayerSP3 = entityPlayerSP2;
                    boolean bl3 = false;
                    this.opened = true;
                    this.printGermElementCategory();
                }
            }
        } else if (packet instanceof CPacketChatMessage) {
            NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
            if (netHandlerPlayClient == null) {
                return;
            }
            NetHandlerPlayClient connection = netHandlerPlayClient;
            String string = ((CPacketChatMessage)packet).func_149439_c();
            Intrinsics.checkNotNullExpressionValue(string, "getMessage(...)");
            Object object = new String[]{" "};
            List command = StringsKt.split$default((CharSequence)string, object, false, 0, 6, null);
            object = (String)command.get(0);
            if (Intrinsics.areEqual(object, "/hyt:germ-category-click")) {
                Object object2;
                if (command.size() != 2) {
                    object2 = DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u6307\u4ee4\u7528\u6cd5 /hyt:germ-category-click <group>");
                } else if (!this.opened) {
                    object2 = DarkMeow.INSTANCE.getMessageManager().display.displayWarn("\u8bf7\u5148\u6253\u5f00\u83dc\u5355\u518d\u4f7f\u7528\u8be5\u6307\u4ee4");
                } else {
                    HashMap<String, GermGame> hashMap = this.manager.getGames().get(command.get(1));
                    if (hashMap != null) {
                        HashMap<String, GermGame> hashMap2;
                        HashMap<String, GermGame> it = hashMap2 = hashMap;
                        boolean bl4 = false;
                        this.printGermElementSingle((String)command.get(1));
                        object2 = hashMap2;
                    } else {
                        HytGermSelectGame $this$onPacket_u24lambda_u243 = this;
                        boolean bl5 = false;
                        object2 = DarkMeow.INSTANCE.getMessageManager().display.displayWarn("\u5206\u7ec4\u4e0d\u5b58\u5728");
                    }
                }
            } else if (Intrinsics.areEqual(object, "/hyt:germ-sub-click")) {
                try {
                    Unit unit;
                    if (command.size() != 3) {
                        unit = DarkMeow.INSTANCE.getMessageManager().display.displayInfo("\u6307\u4ee4\u7528\u6cd5 /hyt:germ-sub-click <entry> <sid>");
                    } else if (!this.opened) {
                        unit = DarkMeow.INSTANCE.getMessageManager().display.displayWarn("\u8bf7\u5148\u6253\u5f00\u83dc\u5355\u518d\u4f7f\u7528\u8be5\u6307\u4ee4");
                    } else {
                        connection.func_147297_a(new CPacketHytGermOpenGUI().build());
                        connection.func_147297_a(new GermGame(null, null, Integer.parseInt((String)command.get(1)), (String)command.get(2), 3, null).build());
                        DarkMeow.INSTANCE.getMessageManager().display.displaySuccess("\u6267\u884c\u6210\u529f");
                        this.opened = false;
                        unit = Unit.INSTANCE;
                    }
                }
                catch (Throwable e2) {
                    DarkMeow.INSTANCE.getMessageManager().display.displayError("\u6267\u884c\u65f6\u53d1\u751f\u5f02\u5e38 \u8bf7\u68c0\u67e5\u6e38\u620f\u65e5\u5fd7");
                    ClientUtils.INSTANCE.logError("HytGerm \u6267\u884c\u65f6\u53d1\u751f\u5f02\u5e38", e2);
                }
                event.cancelEvent();
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void printGermElementCategory() {
        void $this$filterTo$iv$iv;
        TextComponentString component = null;
        component = new TextComponentString("");
        Iterable $this$filter$iv = GermGameCategory.getEntries();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            GermGameCategory it = (GermGameCategory)((Object)element$iv$iv);
            boolean bl2 = false;
            if (!(it != GermGameCategory.UNKNOWN)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$onEach$iv = (List)destination$iv$iv;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            TextComponentString textComponentString;
            GermGameCategory game = (GermGameCategory)((Object)element$iv);
            boolean bl4 = false;
            TextComponentString $this$printGermElementCategory_u24lambda_u247_u24lambda_u245 = textComponentString = new TextComponentString("\u00a78[\u00a7a" + game.getDisplayName() + "\u00a78]");
            boolean bl5 = false;
            $this$printGermElementCategory_u24lambda_u247_u24lambda_u245.func_150255_a($this$printGermElementCategory_u24lambda_u247_u24lambda_u245.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/hyt:germ-category-click " + game.name())));
            $this$printGermElementCategory_u24lambda_u247_u24lambda_u245.func_150255_a($this$printGermElementCategory_u24lambda_u247_u24lambda_u245.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString("\u5206\u7ec4: " + game.getDisplayName() + ", Gid: " + game.name()))));
            TextComponentString subComponent = textComponentString;
            boolean bl6 = false;
            Intrinsics.checkNotNullExpressionValue(((ITextComponent)component).func_150257_a((ITextComponent)subComponent).func_150258_a(" "), "appendText(...)");
        }
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage((ITextComponent)component);
    }

    private final void printGermElementSingle(String group) {
        TextComponentString component = null;
        component = new TextComponentString("");
        HashMap<String, GermGame> hashMap = this.manager.getGames().get(group);
        if (hashMap != null) {
            Map map;
            Map $this$onEach$iv = hashMap;
            boolean $i$f$onEach = false;
            Map $this$onEach_u24lambda_u242$iv = map = $this$onEach$iv;
            boolean bl2 = false;
            Iterator iterator2 = $this$onEach_u24lambda_u242$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                TextComponentString textComponentString;
                Map.Entry element$iv;
                Map.Entry game = element$iv = iterator2.next();
                boolean bl3 = false;
                TextComponentString $this$printGermElementSingle_u24lambda_u2410_u24lambda_u248 = textComponentString = new TextComponentString("\u00a78[\u00a7b" + (String)game.getKey() + "\u00a78]");
                boolean bl4 = false;
                $this$printGermElementSingle_u24lambda_u2410_u24lambda_u248.func_150255_a($this$printGermElementSingle_u24lambda_u2410_u24lambda_u248.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/hyt:germ-sub-click " + ((GermGame)game.getValue()).getEntry() + ' ' + ((GermGame)game.getValue()).getSid())));
                $this$printGermElementSingle_u24lambda_u2410_u24lambda_u248.func_150255_a($this$printGermElementSingle_u24lambda_u2410_u24lambda_u248.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString("\u540d\u79f0: " + ((GermGame)game.getValue()).getName() + ", Entry: " + ((GermGame)game.getValue()).getEntry() + ", Sid: " + ((GermGame)game.getValue()).getSid()))));
                TextComponentString subComponent = textComponentString;
                boolean bl5 = false;
                Intrinsics.checkNotNullExpressionValue(((ITextComponent)component).func_150257_a((ITextComponent)subComponent).func_150258_a(" "), "appendText(...)");
            }
            HashMap cfr_ignored_0 = (HashMap)map;
        }
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage((ITextComponent)component);
    }
}


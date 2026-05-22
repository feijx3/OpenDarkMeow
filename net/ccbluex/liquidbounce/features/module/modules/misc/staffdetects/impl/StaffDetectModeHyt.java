/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.item.ItemSkull
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.server.SPacketOpenWindow
 *  net.minecraft.network.play.server.SPacketSetSlot
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.staffdetects.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.misc.staffdetects.StaffDetectMode;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketWindowItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0010H\u0007J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/staffdetects/impl/StaffDetectModeHyt;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/staffdetects/StaffDetectMode;", "<init>", "()V", "windowId", "", "Ljava/lang/Integer;", "sortCount", "sendTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "onEnable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "handleStaffCheck", "names", "", "", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStaffDetectModeHyt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaffDetectModeHyt.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/staffdetects/impl/StaffDetectModeHyt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1878#2,2:150\n1880#2:153\n1869#2,2:154\n1#3:152\n*S KotlinDebug\n*F\n+ 1 StaffDetectModeHyt.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/staffdetects/impl/StaffDetectModeHyt\n*L\n119#1:150,2\n119#1:153\n144#1:154,2\n*E\n"})
public final class StaffDetectModeHyt
extends StaffDetectMode {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Integer windowId;
    private int sortCount;
    @NotNull
    private MSTimer sendTimer = new MSTimer();
    @NotNull
    public static final String STRING_REPORT_COMMAND = "/report";
    @NotNull
    public static final String STRING_CONTAINER_TITLE = "\u00a77\u4e3e\u62a5\u7cfb\u7edf-\u8bf7\u9009\u62e9\u4f60\u8981\u4e3e\u62a5\u7684\u73a9\u5bb6";
    public static final int USE_COMMAND_COOLDOWN = 15500;
    @NotNull
    private static final String[] STAFFS;

    public StaffDetectModeHyt() {
        super("Hyt");
    }

    @Override
    public void onEnable() {
        this.sendTimer.reset();
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.sendTimer.hasTimePassed(15500) && !DarkMeow.INSTANCE.getInventoryManager().containerIsOpen()) {
            PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketChatMessage(STRING_REPORT_COMMAND), false, null, 6, null);
            this.sendTimer.reset();
        }
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof SPacketOpenWindow) {
            if (Intrinsics.areEqual(((SPacketOpenWindow)packet).func_179840_c().func_150260_c(), STRING_CONTAINER_TITLE)) {
                this.windowId = ((SPacketOpenWindow)packet).func_148901_c();
                this.sortCount = ((SPacketOpenWindow)packet).func_148898_f();
                event.cancelEvent();
                event.cancelNext();
            }
        } else if (packet instanceof SPacketSetSlot) {
            Integer n2 = this.windowId;
            if (n2 != null && ((SPacketSetSlot)packet).func_149175_c() == n2.intValue()) {
                event.cancelEvent();
                event.cancelNext();
            }
        } else if (packet instanceof SPacketWindowItems) {
            Integer n3 = this.windowId;
            if (n3 != null && ((SPacketWindowItems)packet).func_148911_c() == n3.intValue()) {
                List names = new ArrayList();
                List list = ((SPacketWindowItems)packet).func_148910_d();
                Intrinsics.checkNotNullExpressionValue(list, "getItemStacks(...)");
                Iterable $this$forEachIndexed$iv = list;
                boolean $i$f$forEachIndexed = false;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    String string;
                    String string2;
                    void itemStack;
                    int n4;
                    if ((n4 = index$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ItemStack itemStack2 = (ItemStack)item$iv;
                    int index = n4;
                    boolean bl2 = false;
                    if (this.sortCount < index || !(itemStack.func_77973_b() instanceof ItemSkull)) continue;
                    String it = string2 = itemStack.func_82833_r();
                    boolean bl3 = false;
                    Intrinsics.checkNotNull(it);
                    String string3 = StringsKt.startsWith$default(it, "\u00a7a", false, 2, null) ? string2 : null;
                    if (string3 == null || (string2 = StringsKt.replace$default(string3, "\u00a7a", "", false, 4, null)) == null) continue;
                    String it2 = string = string2;
                    boolean bl4 = false;
                    names.add(it2);
                }
                this.handleStaffCheck(names);
                Integer n5 = this.windowId;
                if (n5 == null) {
                    return;
                }
                PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketCloseWindow(n5.intValue()), false, null, 6, null);
                event.cancelEvent();
                event.cancelNext();
            }
        }
    }

    private final void handleStaffCheck(List<String> names) {
        Iterable $this$forEach$iv = names;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String name = (String)element$iv;
            boolean bl2 = false;
            if (!ArraysKt.contains(STAFFS, name)) continue;
            this.getInstance().onDetectedStaff(name);
        }
        this.getInstance().debug("RealPlayerList: " + CollectionsKt.joinToString$default(names, ", ", null, null, 0, null, null, 62, null));
    }

    static {
        String[] stringArray = new String[]{"BACs", "BoogerTheCat", "\u5c0f\u5e03\u4e01qwq", "\u8840\u6a31\u4e36\u661f\u68a6", "Toxic_AslGy", "Cloudy_C", "\u4ed9\u9601\u706c\u7279\u8272", "\u5c0f\u7b26xfu360", "xPir4te_", "\u6b32\u751f\u5317\u8336\u4e3f\u5e74\u7cd5", "\u5200\u5ba2\u5854", "CK_87", "kllkkl12", "Toxic_Yuuki", "\u827e\u68ee\u554a", "\u7ffb\u6597\u82b1\u56edS\u725b\u7237\u7237", "_nb", "zoay", "McDreamer", "\u60b2\u51c9\u6bb5\u5ef6\u5e86\u63a2\u9669", "\u51cb\u96f6\u5c0f\u53ef", "hodwhdwodw", "LIST_\u8d77\u5e8a", "\u5c0f\u5c0f\u6c60\u9c7c", "\u9b54\u90fd\u9e3d\u5b50\u7684awm3", "cat", "Tourlsthigh", "\u52a0\u9876\u9876\u9876\u9876", "\u6d77\u76ae\u54b3\u55fd\u7262\u5927", "\u703a\u9f8d", "bmczsef", "\u5c0f\u7f57\u5c31\u61d2\u54c8\u54c8", "MCzhao2006", "\u4f0a\u4e3d\u838e\u767d\u4e8c\u4e16", "\u6700\u5f3a\u5927\u795e8842", "Steve\u534d\u6551\u4e16\u4e3b"};
        STAFFS = stringArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/staffdetects/impl/StaffDetectModeHyt$Companion;", "", "<init>", "()V", "STRING_REPORT_COMMAND", "", "STRING_CONTAINER_TITLE", "USE_COMMAND_COOLDOWN", "", "STAFFS", "", "getSTAFFS$annotations", "getSTAFFS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String[] getSTAFFS() {
            return STAFFS;
        }

        public static /* synthetic */ void getSTAFFS$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


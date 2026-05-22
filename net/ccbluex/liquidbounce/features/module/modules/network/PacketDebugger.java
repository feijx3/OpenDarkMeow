/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.server.SPacketEntity$S15PacketEntityRelMove
 *  net.minecraft.network.play.server.SPacketEntity$S16PacketEntityLook
 *  net.minecraft.network.play.server.SPacketEntity$S17PacketEntityLookMove
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network;

import com.google.gson.JsonElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.PacketUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketEntity;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="PacketDebugger", category=ModuleCategory.NETWORK)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0014\u0010\u0016\u001a\u00020\u00102\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002J\u0014\u0010\u0019\u001a\u00020\u000f2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketDebugger;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "printNameValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "printFieldsValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "printTimeValue", "printChannelValue", "printSenderValue", "printCancelledValue", "filterModeValue", "packetDebugStates", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "canDisplay", "packet", "Ljava/lang/Class;", "getPrintName", "getPacketName", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketDebugger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketDebugger.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/PacketDebugger\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,123:1\n13472#2,2:124\n2756#3:126\n1#4:127\n*S KotlinDebug\n*F\n+ 1 PacketDebugger.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/PacketDebugger\n*L\n76#1:124,2\n44#1:126\n44#1:127\n*E\n"})
public final class PacketDebugger
extends Module {
    @NotNull
    public static final PacketDebugger INSTANCE;
    @NotNull
    private static final ListValue printNameValue;
    @NotNull
    private static final BoolValue printFieldsValue;
    @NotNull
    private static final BoolValue printTimeValue;
    @NotNull
    private static final ListValue printChannelValue;
    @NotNull
    private static final BoolValue printSenderValue;
    @NotNull
    private static final BoolValue printCancelledValue;
    @NotNull
    private static final ListValue filterModeValue;
    @NotNull
    private static final HashMap<String, Boolean> packetDebugStates;

    private PacketDebugger() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isCancelled() && !((Boolean)printCancelledValue.get()).booleanValue()) {
            return;
        }
        Packet<?> packet = event.getPacket();
        Class<?> clazz = packet.getClass();
        String printInfo = null;
        if (this.canDisplay(clazz)) {
            printInfo = "\u00a7d" + this.getPrintName(clazz) + "\u00a7r " + (event.isCancelled() ? "\u00a7aCancelled\u00a7r " : "") + ((Boolean)printSenderValue.get() != false ? "\u00a76" + event.getSide().name() + "\u00a7r " : "") + ' ' + ((Boolean)printTimeValue.get() != false ? "\u00a7b" + System.currentTimeMillis() % (long)0xFFFFFF + "\u00a7r" : "");
            if (((Boolean)printFieldsValue.get()).booleanValue()) {
                if (clazz.isMemberClass()) {
                    Class<?> clazz2 = clazz.getDeclaringClass();
                    Intrinsics.checkNotNullExpressionValue(clazz2, "getDeclaringClass(...)");
                    clazz = clazz2;
                }
                Field[] fieldArray = clazz.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(fieldArray, "getDeclaredFields(...)");
                Object[] $this$forEach$iv = fieldArray;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    Field it = (Field)element$iv;
                    boolean bl2 = false;
                    it.setAccessible(true);
                    printInfo = printInfo + "\n    \u00a77" + it.getName() + "\u00a7r \u00a75:\u00a7r \u00a77\u00a7o" + it.get(packet) + "\u00a7r";
                }
            }
            if (((CharSequence)printInfo).length() > 0) {
                String string = (String)printChannelValue.get();
                if (Intrinsics.areEqual(string, "ChatMessage")) {
                    DarkMeow.INSTANCE.getMessageManager().displayChatMessage(printInfo);
                } else if (Intrinsics.areEqual(string, "Log4jOpt")) {
                    ClientUtils.logger.info(printInfo);
                }
            }
        }
    }

    /*
     * WARNING - bad return control flow
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean canDisplay(Class<?> packet) {
        String string = (String)filterModeValue.get();
        switch (string.hashCode()) {
            case -1899911469: {
                if (string.equals("Everything")) return true;
                return false;
            }
            case -691178891: {
                if (string.equals("ExcludeSelected")) break;
                return false;
            }
            case -934584697: {
                if (!string.equals("OnlySelected")) return false;
                boolean bl2 = Intrinsics.areEqual(packetDebugStates.get(packet.getName()), true);
                return bl2;
            }
        }
        if (Intrinsics.areEqual(packetDebugStates.get(packet.getName()), true)) return false;
        return true;
        return false;
    }

    private final String getPrintName(Class<?> packet) {
        String string;
        String string2 = (String)printNameValue.get();
        if (Intrinsics.areEqual(string2, "SimpleName")) {
            String string3 = packet.getSimpleName();
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "getSimpleName(...)");
        } else if (Intrinsics.areEqual(string2, "FullName")) {
            String string4 = packet.getName();
            string = string4;
            Intrinsics.checkNotNullExpressionValue(string4, "getName(...)");
        } else {
            String string5 = packet.getName();
            string = string5;
            Intrinsics.checkNotNullExpressionValue(string5, "getName(...)");
        }
        return string;
    }

    @NotNull
    public final String getPacketName(@NotNull Class<?> packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (Intrinsics.areEqual(packet, CPacketPlayer.Position.class)) {
            return "CPacketPlayerPosition";
        }
        if (Intrinsics.areEqual(packet, CPacketPlayer.PositionRotation.class)) {
            return "CPacketPlayerPositionRotation";
        }
        if (Intrinsics.areEqual(packet, CPacketPlayer.Rotation.class)) {
            return "CPacketPlayerRotation";
        }
        if (Intrinsics.areEqual(packet, SPacketEntity.S15PacketEntityRelMove.class)) {
            return "SPacketEntityRelMove";
        }
        if (Intrinsics.areEqual(packet, SPacketEntity.S16PacketEntityLook.class)) {
            return "SPacketEntityLook";
        }
        if (Intrinsics.areEqual(packet, SPacketEntity.S17PacketEntityLookMove.class)) {
            return "SPacketEntityLookMove";
        }
        String string = packet.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(string, "getSimpleName(...)");
        return string;
    }

    private static final boolean lambda$3$lambda$2() {
        return !Intrinsics.areEqual(filterModeValue.get(), "Everything");
    }

    public static final /* synthetic */ HashMap access$getPacketDebugStates$p() {
        return packetDebugStates;
    }

    static {
        Iterable iterable;
        INSTANCE = new PacketDebugger();
        Object object = new String[]{"SimpleName", "FullName"};
        printNameValue = new ListValue("PrintName", (String[])object, "SimpleName");
        printFieldsValue = new BoolValue("PrintFields", true);
        printTimeValue = new BoolValue("PrintTime", true);
        object = new String[]{"ChatMessage", "Log4jOpt"};
        printChannelValue = new ListValue("PrintChannel", (String[])object, "ChatMessage");
        printSenderValue = new BoolValue("PrintSender", false);
        printCancelledValue = new BoolValue("PrintCancelled", false);
        object = new String[]{"OnlySelected", "ExcludeSelected", "Everything"};
        filterModeValue = new ListValue("FilterMode", (String[])object, "OnlySelected");
        packetDebugStates = new HashMap();
        object = new Value[]{printNameValue, printFieldsValue, printTimeValue, printChannelValue, printSenderValue, printCancelledValue, filterModeValue};
        INSTANCE.getValues().addAll((Collection)CollectionsKt.mutableListOf(object));
        Object it = object = new ArrayList();
        boolean bl2 = false;
        ((ArrayList)it).addAll((Collection)PacketUtils.INSTANCE.getCLIENT_PACKETS());
        it = object;
        boolean bl3 = false;
        ((ArrayList)it).addAll((Collection)PacketUtils.INSTANCE.getSERVER_PACKETS());
        Iterable $this$onEach$iv = (Iterable)object;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl4 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            Class it2 = (Class)element$iv;
            boolean bl5 = false;
            String string = INSTANCE.getPacketName(it2);
            INSTANCE.getValues().add(new BoolValue(it2, string){
                private final Class<? extends Packet<?>> clazz;
                {
                    this.clazz = $it;
                }

                public final Class<? extends Packet<?>> getClazz() {
                    return this.clazz;
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    ((Map)PacketDebugger.access$getPacketDebugStates$p()).put(this.clazz.getName(), newValue);
                }

                public void fromJson(JsonElement element) {
                    Intrinsics.checkNotNullParameter(element, "element");
                    super.fromJson(element);
                    this.onChange((Boolean)this.getValue(), (Boolean)this.getValue());
                }
            }.displayable(PacketDebugger::lambda$3$lambda$2));
        }
    }
}


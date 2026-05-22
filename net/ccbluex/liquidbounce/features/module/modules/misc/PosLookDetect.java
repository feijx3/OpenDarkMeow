/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketPlayerPosLook$EnumFlags
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.injection.extend.ExtendKeyBinding;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/PosLookDetect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "messageValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "releaseUseItemValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "count", "", "onPosLook", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "packet", "Lnet/minecraft/network/play/server/SPacketPlayerPosLook;", "onEnable", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPosLookDetect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PosLookDetect.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/PosLookDetect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,72:1\n1#2:73\n12#3,3:74\n*S KotlinDebug\n*F\n+ 1 PosLookDetect.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/PosLookDetect\n*L\n61#1:74,3\n*E\n"})
public final class PosLookDetect
extends Module {
    @NotNull
    public static final PosLookDetect INSTANCE;
    @JvmField
    @NotNull
    public static final TextValue messageValue;
    @JvmField
    @NotNull
    public static final BoolValue releaseUseItemValue;
    @JvmField
    public static int count;

    private PosLookDetect() {
        super("PosLookDetect", ModuleCategory.MISC, null, null, 12, null);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static final void onPosLook(@NotNull EntityPlayerSP player, @NotNull SPacketPlayerPosLook packet) {
        block4: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2;
            EntityPlayerSP entityPlayerSP3;
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(packet, "packet");
            EntityPlayerSP it = entityPlayerSP3 = player;
            boolean bl2 = false;
            Object object = entityPlayerSP2 = it.field_70173_aa > 20 ? entityPlayerSP3 : null;
            if (entityPlayerSP2 == null) break block4;
            EntityPlayerSP it2 = entityPlayerSP = entityPlayerSP2;
            boolean bl3 = false;
            Object object2 = entityPlayerSP3 = it2.func_70089_S() ? entityPlayerSP : null;
            if (entityPlayerSP3 != null) {
                String string;
                String string2;
                void it3;
                String string3;
                it2 = entityPlayerSP = entityPlayerSP3;
                boolean bl4 = false;
                int n2 = count;
                count = n2 + 1;
                String string4 = StringsKt.replace$default((String)messageValue.get(), "%{total_count}", String.valueOf(count), false, 4, null);
                Set set = packet.func_179834_f();
                Intrinsics.checkNotNullExpressionValue(set, "getFlags(...)");
                String string5 = string3 = CollectionsKt.joinToString$default(set, null, null, null, 0, null, PosLookDetect::onPosLook$lambda$6$lambda$2, 31, null);
                String string6 = "%{flags}";
                String string7 = string4;
                boolean bl5 = false;
                boolean bl6 = ((CharSequence)it3).length() > 0;
                String string8 = bl6 ? string3 : null;
                if (string8 == null) {
                    string8 = "EMPTY";
                }
                String it4 = string2 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string7, string6, string8, false, 4, null), "%{x}", String.valueOf(packet.func_148932_c()), false, 4, null), "%{y}", String.valueOf(packet.func_148928_d()), false, 4, null), "%{z}", String.valueOf(packet.func_148933_e()), false, 4, null), "%{yaw}", String.valueOf(packet.func_148931_f()), false, 4, null), "%{pitch}", String.valueOf(packet.func_148930_g()), false, 4, null), "%{teleport_id}", String.valueOf(packet.func_186965_f()), false, 4, null);
                boolean bl7 = false;
                String string9 = string = ((CharSequence)it4).length() > 0 ? string2 : null;
                if (string != null) {
                    String message = string2 = string;
                    boolean bl8 = false;
                    DarkMeow.INSTANCE.getMessageManager().display.displayInfo(message);
                }
                if (((Boolean)releaseUseItemValue.get()).booleanValue()) {
                    KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74313_G;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindUseItem");
                    ExtendKeyBinding.INSTANCE.unPressKey(keyBinding);
                    player.field_71174_a.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
                }
            }
        }
    }

    @Override
    public void onEnable() {
        count = 0;
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(count);
    }

    private static final CharSequence onPosLook$lambda$6$lambda$2(SPacketPlayerPosLook.EnumFlags it) {
        return it.name();
    }

    private static final Unit _init_$lambda$7(ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.onEnable();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $receiver$iv;
        INSTANCE = new PosLookDetect();
        messageValue = new TextValue("Message", "PosLook x%{total_count} (%{flags})");
        releaseUseItemValue = new BoolValue("ReleaseUseItem", true);
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = INSTANCE;
        Function2<ListenerBase, WorldEvent, Unit> function$iv = PosLookDetect::_init_$lambda$7;
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), (ListenableOwner)$receiver$iv));
    }
}


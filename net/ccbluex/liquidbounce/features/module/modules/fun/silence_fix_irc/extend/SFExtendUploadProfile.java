/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.fun.SilenceFixIRC;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacketUpdateGameProfile;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendUploadProfile;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "spamValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onDisable", "", "uploadProfile", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixIRC;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSFExtendUploadProfile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SFExtendUploadProfile.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendUploadProfile\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,43:1\n20#2,3:44\n20#2,3:47\n*S KotlinDebug\n*F\n+ 1 SFExtendUploadProfile.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendUploadProfile\n*L\n25#1:44,3\n28#1:47,3\n*E\n"})
public final class SFExtendUploadProfile
extends SFExtend {
    @JvmField
    @NotNull
    public final BoolValue spamValue = new BoolValue("Spam", false);

    public SFExtendUploadProfile() {
        super("UploadProfile", true, false, 4, null);
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> SFExtendUploadProfile._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> SFExtendUploadProfile._init_$lambda$1(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(UpdateEvent.class), $receiver$iv));
    }

    @Override
    public void onDisable() {
        this.getInstance().getClient().sendPacket(new SFC2SPacketUpdateGameProfile(new UUID(0L, 0L), ""));
    }

    public final void uploadProfile(@NotNull SilenceFixIRC $this$uploadProfile, @NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter($this$uploadProfile, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        SFConnection sFConnection = $this$uploadProfile.getClient();
        UUID uUID = player.func_146103_bH().getId();
        Intrinsics.checkNotNullExpressionValue(uUID, "getId(...)");
        String string = player.func_146103_bH().getName();
        Intrinsics.checkNotNullExpressionValue(string, "getName(...)");
        sFConnection.sendPacket(new SFC2SPacketUpdateGameProfile(uUID, string));
    }

    private static final Unit _init_$lambda$0(SFExtendUploadProfile this$0, SafeListenerBase $this$safeListener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.uploadProfile(this$0.getInstance(), $this$safeListener.getPlayer());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(SFExtendUploadProfile this$0, SafeListenerBase $this$safeListener, UpdateEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (((Boolean)this$0.spamValue.get()).booleanValue() && event.getUpdateId() % 60L == 0L) {
            this$0.uploadProfile(this$0.getInstance(), $this$safeListener.getPlayer());
        }
        return Unit.INSTANCE;
    }
}


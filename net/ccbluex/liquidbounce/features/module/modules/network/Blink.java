/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 *  net.minecraft.network.play.client.CPacketKeepAlive
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameType
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.network;

import com.google.gson.JsonElement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.network.Blink;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketDebugger;
import net.ccbluex.liquidbounce.features.module.modules.network.blink.data.BlinkTickBreadcrumbsData;
import net.ccbluex.liquidbounce.features.module.modules.network.blink.data.BlinkTickData;
import net.ccbluex.liquidbounce.features.module.modules.network.blink.data.BlinkTickPositionData;
import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.ccbluex.liquidbounce.handler.network.packet.PacketManager;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketUseEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.PacketUtils;
import net.ccbluex.liquidbounce.utils.kotlin.HashMapExtensions;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.KeyValue;
import net.darkmeow.darkmeow.utils.network.PacketSide;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001FB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000201H\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H\u0007J\u0010\u0010:\u001a\u0002052\u0006\u00108\u001a\u00020;H\u0007J\u0010\u0010<\u001a\u0002052\u0006\u00108\u001a\u00020=H\u0007J\u0010\u0010>\u001a\u0002052\u0006\u00108\u001a\u00020?H\u0007J\u001c\u0010@\u001a\u0002052\b\b\u0002\u0010A\u001a\u00020\b2\b\b\u0002\u0010B\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0003R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001b00X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u0002018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006G"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/Blink;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "ENTITY_ID", "", "packets", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickData;", "fakePlayer", "Lnet/ccbluex/liquidbounce/features/module/modules/network/Blink$FakePlayer;", "autoReleaseOldPacketValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "autoReleaseOldPacketTickValue", "Lnet/ccbluex/liquidbounce/value/Value;", "autoOffValue", "autoOffOnAttackEntityValue", "autoOffOnInteractEntityValue", "autoOffOnUseItemValue", "autoOffOnUseItemOnBlockValue", "autoOffOnKnockBackValue", "autoOffOnTeleportValue", "renderValue", "net/ccbluex/liquidbounce/features/module/modules/network/Blink$renderValue$1", "Lnet/ccbluex/liquidbounce/features/module/modules/network/Blink$renderValue$1;", "renderFakePlayerValue", "", "renderFakePlayerItemsValue", "renderFakePlayerAlphaValue", "renderFakePlayerDisplayDistanceValue", "renderFakePlayerMoveReleaseOldPacketValue", "renderBreadcrumbsValue", "renderBreadcrumbsColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "cancelValue", "cancelKeyValue", "Lnet/ccbluex/liquidbounce/value/impl/KeyValue;", "getCancelKeyValue$annotations", "cancelSendEmptyCPacketPlayerValue", "cancelResendC0FC00Value", "blockFlyValue", "blockFlyLaunchTickValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "blockFlyReleaseTickValue", "blockFlyUse", "blockFlyRelease", "packetStates", "Ljava/util/HashMap;", "", "getDefaultMode", "packet", "onEnable", "", "onDisable", "onWorld", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "releasePacket", "tick", "onlyC00C0F", "tag", "getTag", "()Ljava/lang/String;", "FakePlayer", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nBlink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blink.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/Blink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,440:1\n1#2:441\n1#2:451\n216#3:442\n217#3:445\n1869#4,2:443\n1869#4,2:446\n1869#4,2:448\n2756#4:450\n*S KotlinDebug\n*F\n+ 1 Blink.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/Blink\n*L\n199#1:451\n396#1:442\n396#1:445\n397#1:443,2\n422#1:446,2\n425#1:448,2\n199#1:450\n*E\n"})
public final class Blink
extends Module {
    @NotNull
    public static final Blink INSTANCE;
    public static final int ENTITY_ID = -1337;
    @NotNull
    private static final LinkedHashMap<Long, BlinkTickData> packets;
    @Nullable
    private static FakePlayer fakePlayer;
    @NotNull
    private static final BoolValue autoReleaseOldPacketValue;
    @NotNull
    private static final Value<Integer> autoReleaseOldPacketTickValue;
    @NotNull
    private static final BoolValue autoOffValue;
    @NotNull
    private static final BoolValue autoOffOnAttackEntityValue;
    @NotNull
    private static final BoolValue autoOffOnInteractEntityValue;
    @NotNull
    private static final BoolValue autoOffOnUseItemValue;
    @NotNull
    private static final BoolValue autoOffOnUseItemOnBlockValue;
    @NotNull
    private static final BoolValue autoOffOnKnockBackValue;
    @NotNull
    private static final BoolValue autoOffOnTeleportValue;
    @NotNull
    private static final renderValue.1 renderValue;
    @NotNull
    private static final Value<Boolean> renderFakePlayerValue;
    @NotNull
    private static final Value<Boolean> renderFakePlayerItemsValue;
    @NotNull
    private static final Value<Boolean> renderFakePlayerAlphaValue;
    @NotNull
    private static final Value<Integer> renderFakePlayerDisplayDistanceValue;
    @NotNull
    private static final Value<Boolean> renderFakePlayerMoveReleaseOldPacketValue;
    @NotNull
    private static final Value<Boolean> renderBreadcrumbsValue;
    @NotNull
    private static final ColorValue renderBreadcrumbsColorValue;
    @NotNull
    private static final BoolValue cancelValue;
    @NotNull
    private static final KeyValue cancelKeyValue;
    @NotNull
    private static final Value<Boolean> cancelSendEmptyCPacketPlayerValue;
    @NotNull
    private static final Value<Boolean> cancelResendC0FC00Value;
    @JvmField
    @NotNull
    public static final BoolValue blockFlyValue;
    @JvmField
    @NotNull
    public static final IntegerValue blockFlyLaunchTickValue;
    @JvmField
    @NotNull
    public static final IntegerValue blockFlyReleaseTickValue;
    private static boolean blockFlyUse;
    private static boolean blockFlyRelease;
    @NotNull
    private static final HashMap<String, Boolean> packetStates;

    private Blink() {
        super("Blink", ModuleCategory.NETWORK, null, null, 12, null);
    }

    private static /* synthetic */ void getCancelKeyValue$annotations() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean getDefaultMode(String packet) {
        String string = packet;
        switch (string.hashCode()) {
            case -699306351: {
                if (string.equals("CPacketPlayerDigging")) return true;
                return false;
            }
            case 2106400265: {
                if (string.equals("CPacketConfirmTransaction")) return true;
                return false;
            }
            case 843339116: {
                if (string.equals("CPacketPlayer")) return true;
                return false;
            }
            case -2017782445: {
                if (string.equals("CPacketPlayerPositionRotation")) return true;
                return false;
            }
            case 1347571993: {
                if (string.equals("CPacketAnimation")) return true;
                return false;
            }
            case 1712457532: {
                if (string.equals("CPacketPlayerAbilities")) return true;
                return false;
            }
            case -1546445347: {
                if (string.equals("CPacketKeepAlive")) return true;
                return false;
            }
            case -20120093: {
                if (string.equals("CPacketPlayerTryUseItemOnBlock")) return true;
                return false;
            }
            case -1887735413: {
                if (string.equals("CPacketPlayerTryUseItem")) return true;
                return false;
            }
            case -512295356: {
                if (string.equals("CPacketEntityAction")) return true;
                return false;
            }
            case -403403453: {
                if (string.equals("CPacketHeldItemChange")) return true;
                return false;
            }
            case -177103606: {
                if (string.equals("CPacketPlayerRotation")) return true;
                return false;
            }
            case 611002037: {
                if (!string.equals("CPacketPlayerPosition")) return false;
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void onEnable() {
        v0 = MinecraftInstance.mc.getPlayer();
        if (v0 == null) {
            return;
        }
        player = v0;
        v1 = MinecraftInstance.mc.getWorld();
        if (v1 == null) {
            return;
        }
        world = v1;
        if (!((Boolean)Blink.blockFlyValue.get()).booleanValue()) ** GOTO lbl-1000
        v2 = DarkMeow.INSTANCE.getModuleManager().get(Scaffold.class);
        if (v2 != null ? v2.getState() : false) {
            v3 = true;
        } else lbl-1000:
        // 2 sources

        {
            v3 = false;
        }
        Blink.blockFlyUse = v3;
        Blink.blockFlyRelease = false;
        it = var3_3 = new FakePlayer(world, player);
        $i$a$-also-Blink$onEnable$1 = false;
        it.updateBlinkSettings();
        Blink.fakePlayer = var3_3;
    }

    @Override
    public void onDisable() {
        FakePlayer fakePlayer = Blink.fakePlayer;
        if (fakePlayer != null) {
            fakePlayer.remove();
        }
        Blink.fakePlayer = null;
        Blink.releasePacket$default(this, 0L, false, 3, null);
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.setState(false);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        block21: {
            block23: {
                BlinkTickData blinkTickData;
                long updateId;
                Packet<?> packet;
                EntityPlayerSP player;
                block22: {
                    BlinkTickData blinkTickData2;
                    long l2;
                    Intrinsics.checkNotNullParameter(event, "event");
                    EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                    if (entityPlayerSP == null) {
                        return;
                    }
                    player = entityPlayerSP;
                    packet = event.getPacket();
                    if (packet instanceof AccessorCPacketUseEntity) {
                        FakePlayer fakePlayer = Blink.fakePlayer;
                        if (((AccessorCPacketUseEntity)packet).getEntityId() == (fakePlayer != null ? fakePlayer.func_145782_y() : -1337)) {
                            event.cancelEvent();
                            return;
                        }
                    }
                    if (((Boolean)autoOffValue.get()).booleanValue()) {
                        boolean doAutoOff = false;
                        if (packet instanceof CPacketUseEntity) {
                            if (((Boolean)autoOffOnAttackEntityValue.get()).booleanValue() && ((CPacketUseEntity)packet).func_149565_c() == CPacketUseEntity.Action.ATTACK) {
                                doAutoOff = true;
                            }
                            if (((Boolean)autoOffOnInteractEntityValue.get()).booleanValue() && ((CPacketUseEntity)packet).func_149565_c() != CPacketUseEntity.Action.ATTACK) {
                                doAutoOff = true;
                            }
                        }
                        if (packet instanceof CPacketPlayerTryUseItem && ((Boolean)autoOffOnUseItemValue.get()).booleanValue()) {
                            doAutoOff = true;
                        }
                        if (packet instanceof CPacketPlayerTryUseItemOnBlock && ((Boolean)autoOffOnUseItemOnBlockValue.get()).booleanValue()) {
                            doAutoOff = true;
                        }
                        if (packet instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)packet).func_149412_c() == player.func_145782_y() && ((Boolean)autoOffOnKnockBackValue.get()).booleanValue()) {
                            doAutoOff = true;
                        }
                        if (packet instanceof SPacketPlayerPosLook && ((Boolean)autoOffOnTeleportValue.get()).booleanValue()) {
                            doAutoOff = true;
                        }
                        if (doAutoOff) {
                            this.setState(false);
                            return;
                        }
                    }
                    if (!Intrinsics.areEqual(packetStates.get(packet.getClass().getName()), true)) break block21;
                    if (event.isCancelled()) {
                        return;
                    }
                    updateId = l2 = DarkMeow.INSTANCE.getUpdateManager().getUpdateId();
                    boolean bl2 = false;
                    BlinkTickData blinkTickData3 = packets.get(updateId);
                    if (blinkTickData3 == null) break block22;
                    BlinkTickData $this$onPacket_u24lambda_u2426_u24lambda_u2422 = blinkTickData2 = blinkTickData3;
                    boolean bl3 = false;
                    switch (WhenMappings.$EnumSwitchMapping$0[event.getSide().ordinal()]) {
                        case 1: {
                            $this$onPacket_u24lambda_u2426_u24lambda_u2422.getPacketsClient().add(packet);
                            break;
                        }
                        case 2: {
                            $this$onPacket_u24lambda_u2426_u24lambda_u2422.getPacketsServer().add(packet);
                        }
                    }
                    break block23;
                }
                Blink $this$onPacket_u24lambda_u2426_u24lambda_u2425 = INSTANCE;
                boolean bl4 = false;
                Map map = packets;
                Long l3 = updateId;
                switch (WhenMappings.$EnumSwitchMapping$0[event.getSide().ordinal()]) {
                    case 1: {
                        LinkedBlockingQueue linkedBlockingQueue;
                        LinkedBlockingQueue it = linkedBlockingQueue = new LinkedBlockingQueue();
                        boolean bl5 = false;
                        it.add(packet);
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        int n2 = 6;
                        BlinkTickPositionData blinkTickPositionData = new BlinkTickPositionData(player);
                        LinkedList linkedList = null;
                        LinkedBlockingQueue linkedBlockingQueue2 = null;
                        LinkedBlockingQueue linkedBlockingQueue3 = linkedBlockingQueue;
                        blinkTickData = new BlinkTickData(linkedBlockingQueue3, linkedBlockingQueue2, linkedList, blinkTickPositionData, n2, defaultConstructorMarker);
                        break;
                    }
                    case 2: {
                        LinkedBlockingQueue linkedBlockingQueue;
                        LinkedBlockingQueue it = linkedBlockingQueue = new LinkedBlockingQueue();
                        LinkedBlockingQueue linkedBlockingQueue4 = null;
                        boolean bl6 = false;
                        it.add(packet);
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        int n3 = 5;
                        BlinkTickPositionData blinkTickPositionData = new BlinkTickPositionData(player);
                        LinkedList linkedList = null;
                        LinkedBlockingQueue linkedBlockingQueue5 = linkedBlockingQueue;
                        LinkedBlockingQueue linkedBlockingQueue6 = linkedBlockingQueue4;
                        blinkTickData = new BlinkTickData(linkedBlockingQueue6, linkedBlockingQueue5, linkedList, blinkTickPositionData, n3, defaultConstructorMarker);
                        break;
                    }
                    default: {
                        break block23;
                    }
                }
                BlinkTickData blinkTickData4 = blinkTickData;
                map.put(l3, blinkTickData4);
            }
            event.cancelEvent();
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        Blink.onUpdate$doBlockFly(event.getUpdateId());
        Blink.onUpdate$doUpdatePosition(player, event.getUpdateId());
        Blink.onUpdate$doUpdateCancel(player);
        Blink.onUpdate$doAutoRelease(event.getUpdateId());
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (((Boolean)renderValue.get()).booleanValue() && renderBreadcrumbsValue.get().booleanValue()) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179090_x();
            GlStateManager.func_179112_b((int)770, (int)771);
            GlStateManager.func_179147_l();
            GlStateManager.func_179097_i();
            MinecraftInstance.mc.getEntityRenderer().func_175072_h();
            GlStateManager.func_187447_r((int)3);
            Map $this$forEach$iv = packets;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv;
                Map.Entry it = element$iv = iterator2.next();
                boolean bl2 = false;
                Iterable $this$forEach$iv2 = ((BlinkTickData)it.getValue()).getBreadcrumbs();
                boolean $i$f$forEach2 = false;
                for (Object element$iv2 : $this$forEach$iv2) {
                    BlinkTickBreadcrumbsData breadcrumb = (BlinkTickBreadcrumbsData)element$iv2;
                    boolean bl3 = false;
                    ColorUtils.INSTANCE.setGlColor(breadcrumb.getColor());
                    GlStateManager.func_187435_e((float)((float)(breadcrumb.getPosition().field_72450_a - MinecraftInstance.mc.getRenderManager().field_78730_l)), (float)((float)(breadcrumb.getPosition().field_72448_b - MinecraftInstance.mc.getRenderManager().field_78731_m)), (float)((float)(breadcrumb.getPosition().field_72449_c - MinecraftInstance.mc.getRenderManager().field_78728_n)));
                }
            }
            GlStateManager.func_179117_G();
            GlStateManager.func_187437_J();
            GlStateManager.func_179126_j();
            GlStateManager.func_179084_k();
            GlStateManager.func_179098_w();
            GlStateManager.func_179121_F();
        }
    }

    private final void releasePacket(long tick, boolean onlyC00C0F) {
        Ref.BooleanRef doNextPosition = new Ref.BooleanRef();
        HashMapExtensions.INSTANCE.removeIf(packets, arg_0 -> Blink.releasePacket$lambda$33(doNextPosition, tick, onlyC00C0F, arg_0));
    }

    static /* synthetic */ void releasePacket$default(Blink blink, long l2, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = Long.MAX_VALUE;
        }
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        blink.releasePacket(l2, bl2);
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(packets.size());
    }

    private static final boolean autoReleaseOldPacketTickValue$lambda$0() {
        return (Boolean)autoReleaseOldPacketValue.get();
    }

    private static final boolean renderFakePlayerValue$lambda$7() {
        return (Boolean)renderValue.get();
    }

    private static final boolean renderFakePlayerItemsValue$lambda$8() {
        return (Boolean)renderValue.get() != false && renderFakePlayerValue.get() != false;
    }

    private static final boolean renderFakePlayerAlphaValue$lambda$9() {
        return (Boolean)renderValue.get() != false && renderFakePlayerValue.get() != false;
    }

    private static final boolean renderFakePlayerDisplayDistanceValue$lambda$10() {
        return (Boolean)renderValue.get() != false && renderFakePlayerValue.get() != false;
    }

    private static final boolean renderFakePlayerMoveReleaseOldPacketValue$lambda$11() {
        return (Boolean)renderValue.get() != false && renderFakePlayerValue.get() != false && (Boolean)autoReleaseOldPacketValue.get() != false;
    }

    private static final boolean renderBreadcrumbsValue$lambda$12() {
        return (Boolean)renderValue.get();
    }

    private static final boolean renderBreadcrumbsColorValue$lambda$13() {
        return (Boolean)renderValue.get() != false && renderBreadcrumbsValue.get() != false;
    }

    private static final boolean cancelKeyValue$lambda$14() {
        return (Boolean)cancelValue.get();
    }

    private static final boolean cancelSendEmptyCPacketPlayerValue$lambda$15() {
        return (Boolean)cancelValue.get();
    }

    private static final boolean cancelResendC0FC00Value$lambda$16() {
        return (Boolean)cancelValue.get();
    }

    private static final void onUpdate$doBlockFly(long updateId) {
        if (blockFlyUse) {
            if (blockFlyRelease) {
                Blink.releasePacket$default(INSTANCE, updateId - ((Number)blockFlyReleaseTickValue.get()).longValue(), false, 2, null);
            } else {
                Set<Map.Entry<Long, BlinkTickData>> set = packets.entrySet();
                Intrinsics.checkNotNullExpressionValue(set, "<get-entries>(...)");
                Object object = (Map.Entry)CollectionsKt.firstOrNull((Iterable)set);
                if ((object != null && (object = (Long)object.getKey()) != null ? (Long)object + ((Number)blockFlyLaunchTickValue.get()).longValue() : Long.MAX_VALUE) < updateId) {
                    blockFlyRelease = true;
                }
            }
        }
    }

    private static final void onUpdate$doAutoRelease(long updateId) {
        if (((Boolean)autoReleaseOldPacketValue.get()).booleanValue() && ((Number)autoReleaseOldPacketTickValue.get()).intValue() != 0) {
            Blink.releasePacket$default(INSTANCE, updateId - ((Number)autoReleaseOldPacketTickValue.get()).longValue(), false, 2, null);
        }
    }

    private static final void onUpdate$doUpdateCancel(EntityPlayerSP player) {
        if (((Boolean)cancelValue.get()).booleanValue() && cancelKeyValue.isKeyDown()) {
            Set<Map.Entry<Long, BlinkTickData>> set = packets.entrySet();
            Intrinsics.checkNotNullExpressionValue(set, "<get-entries>(...)");
            Object object = (Map.Entry)CollectionsKt.firstOrNull((Iterable)set);
            if (object != null && (object = (BlinkTickData)object.getValue()) != null && (object = ((BlinkTickData)object).getPosition()) != null) {
                ((BlinkTickPositionData)object).resetPlayer(player);
            }
            if (cancelSendEmptyCPacketPlayerValue.get().booleanValue()) {
                PacketManager.sendPacket$default(DarkMeow.INSTANCE.getNetworkManager().packetManager, (Packet)new CPacketPlayer(player.field_70122_E), true, null, 4, null);
            }
            if (cancelResendC0FC00Value.get().booleanValue()) {
                Blink.releasePacket$default(INSTANCE, 0L, true, 1, null);
            }
            packets.clear();
            INSTANCE.setState(false);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final void onUpdate$doUpdatePosition(EntityPlayerSP player, long updateId) {
        if (((Boolean)renderValue.get()).booleanValue() && renderBreadcrumbsValue.get().booleanValue()) {
            BlinkTickBreadcrumbsData position = new BlinkTickBreadcrumbsData(new Vec3d(player.field_70165_t, player.func_174813_aQ().field_72338_b, player.field_70161_v), ColorValue.getColor$default(renderBreadcrumbsColorValue, null, 1, null));
            Object object = packets.get(updateId);
            if (object != null && (object = ((BlinkTickData)object).getBreadcrumbs()) != null) {
                ((LinkedList)object).add(position);
            } else {
                void it;
                Blink $this$onUpdate_u24doUpdatePosition_u24lambda_u2428 = INSTANCE;
                boolean bl2 = false;
                Map map = packets;
                Long l2 = updateId;
                Object object2 = new LinkedList();
                LinkedList linkedList = object2;
                LinkedBlockingQueue linkedBlockingQueue = null;
                LinkedBlockingQueue linkedBlockingQueue2 = null;
                boolean bl3 = false;
                it.add(position);
                Unit unit = Unit.INSTANCE;
                DefaultConstructorMarker defaultConstructorMarker = null;
                int n2 = 3;
                BlinkTickPositionData blinkTickPositionData = new BlinkTickPositionData(player);
                LinkedList linkedList2 = object2;
                LinkedBlockingQueue linkedBlockingQueue3 = linkedBlockingQueue;
                LinkedBlockingQueue linkedBlockingQueue4 = linkedBlockingQueue2;
                object2 = new BlinkTickData(linkedBlockingQueue4, linkedBlockingQueue3, linkedList2, blinkTickPositionData, n2, defaultConstructorMarker);
                map.put(l2, object2);
            }
        }
    }

    private static final boolean releasePacket$lambda$33(Ref.BooleanRef $doNextPosition, long $tick, boolean $onlyC00C0F, Map.Entry entry) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if ($doNextPosition.element) {
            FakePlayer fakePlayer = Blink.fakePlayer;
            if (fakePlayer != null) {
                fakePlayer.updatePosition(((BlinkTickData)entry.getValue()).getPosition());
            }
        }
        if (((Number)entry.getKey()).longValue() <= $tick) {
            Packet packet;
            Iterable $this$forEach$iv = ((BlinkTickData)entry.getValue()).getPacketsServer();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                packet = (Packet)element$iv;
                boolean bl3 = false;
                PacketManager packetManager = DarkMeow.INSTANCE.getNetworkManager().packetManager;
                Intrinsics.checkNotNull(packet);
                PacketManager.sendPacketToClient$default(packetManager, packet, true, null, 4, null);
            }
            $this$forEach$iv = ((BlinkTickData)entry.getValue()).getPacketsClient();
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                packet = (Packet)element$iv;
                boolean bl4 = false;
                if ($onlyC00C0F && !(packet instanceof CPacketConfirmTransaction) && !(packet instanceof CPacketKeepAlive)) continue;
                PacketManager packetManager = DarkMeow.INSTANCE.getNetworkManager().packetManager;
                Intrinsics.checkNotNull(packet);
                PacketManager.sendPacket$default(packetManager, packet, true, null, 4, null);
            }
            $doNextPosition.element = true;
            bl2 = true;
        } else {
            $doNextPosition.element = false;
            bl2 = false;
        }
        return bl2;
    }

    public static final /* synthetic */ HashMap access$getPacketStates$p() {
        return packetStates;
    }

    public static final /* synthetic */ FakePlayer access$getFakePlayer$p() {
        return fakePlayer;
    }

    static {
        Iterable iterable;
        INSTANCE = new Blink();
        packets = new LinkedHashMap();
        autoReleaseOldPacketValue = new BoolValue("AutoReleaseOldPacket", false);
        autoReleaseOldPacketTickValue = new IntegerValue("AutoReleaseOldPacketTick", 20, 0, 200).displayable(Blink::autoReleaseOldPacketTickValue$lambda$0);
        autoOffValue = new BoolValue("AutoOff", false);
        Value[] valueArray = new BoolValue("AutoOffOnAttackEntity", false);
        BoolValue $this$autoOffOnAttackEntityValue_u24lambda_u241 = valueArray;
        boolean bl2 = false;
        $this$autoOffOnAttackEntityValue_u24lambda_u241.setSuperValue(autoOffValue);
        autoOffOnAttackEntityValue = valueArray;
        valueArray = new BoolValue("AutoOffOnInteractEntity", false);
        BoolValue $this$autoOffOnInteractEntityValue_u24lambda_u242 = valueArray;
        boolean bl3 = false;
        $this$autoOffOnInteractEntityValue_u24lambda_u242.setSuperValue(autoOffValue);
        autoOffOnInteractEntityValue = valueArray;
        valueArray = new BoolValue("AutoOffOnUseItem", false);
        BoolValue $this$autoOffOnUseItemValue_u24lambda_u243 = valueArray;
        boolean bl4 = false;
        $this$autoOffOnUseItemValue_u24lambda_u243.setSuperValue(autoOffValue);
        autoOffOnUseItemValue = valueArray;
        valueArray = new BoolValue("AutoOffOnUseItemOnBlock", false);
        BoolValue $this$autoOffOnUseItemOnBlockValue_u24lambda_u244 = valueArray;
        boolean bl5 = false;
        $this$autoOffOnUseItemOnBlockValue_u24lambda_u244.setSuperValue(autoOffValue);
        autoOffOnUseItemOnBlockValue = valueArray;
        valueArray = new BoolValue("AutoOffOnKnockBack", false);
        BoolValue $this$autoOffOnKnockBackValue_u24lambda_u245 = valueArray;
        boolean bl6 = false;
        $this$autoOffOnKnockBackValue_u24lambda_u245.setSuperValue(autoOffValue);
        autoOffOnKnockBackValue = valueArray;
        valueArray = new BoolValue("AutoOffOnTeleport", false);
        BoolValue $this$autoOffOnTeleportValue_u24lambda_u246 = valueArray;
        boolean bl7 = false;
        $this$autoOffOnTeleportValue_u24lambda_u246.setSuperValue(autoOffValue);
        autoOffOnTeleportValue = valueArray;
        renderValue = new BoolValue(){

            protected void onChanged(boolean oldValue, boolean newValue) {
                block0: {
                    FakePlayer fakePlayer = Blink.access$getFakePlayer$p();
                    if (fakePlayer == null) break block0;
                    fakePlayer.updateBlinkSettings();
                }
            }
        };
        renderFakePlayerValue = new BoolValue(){

            protected void onChanged(boolean oldValue, boolean newValue) {
                block0: {
                    FakePlayer fakePlayer = Blink.access$getFakePlayer$p();
                    if (fakePlayer == null) break block0;
                    fakePlayer.updateBlinkSettings();
                }
            }
        }.displayable(Blink::renderFakePlayerValue$lambda$7);
        renderFakePlayerItemsValue = new BoolValue(){

            protected void onChanged(boolean oldValue, boolean newValue) {
                block0: {
                    FakePlayer fakePlayer = Blink.access$getFakePlayer$p();
                    if (fakePlayer == null) break block0;
                    fakePlayer.updateBlinkSettings();
                }
            }
        }.displayable(Blink::renderFakePlayerItemsValue$lambda$8);
        renderFakePlayerAlphaValue = new BoolValue(){

            protected void onChanged(boolean oldValue, boolean newValue) {
                block0: {
                    FakePlayer fakePlayer = Blink.access$getFakePlayer$p();
                    if (fakePlayer == null) break block0;
                    fakePlayer.updateBlinkSettings();
                }
            }
        }.displayable(Blink::renderFakePlayerAlphaValue$lambda$9);
        renderFakePlayerDisplayDistanceValue = new IntegerValue("RenderFakePlayerDisplayDistance", 1, 0, 5).displayable(Blink::renderFakePlayerDisplayDistanceValue$lambda$10);
        renderFakePlayerMoveReleaseOldPacketValue = new BoolValue("RenderFakePlayerMoveReleaseOldPacket", false).displayable(Blink::renderFakePlayerMoveReleaseOldPacketValue$lambda$11);
        renderBreadcrumbsValue = new BoolValue("RenderBreadcrumbs", true).displayable(Blink::renderBreadcrumbsValue$lambda$12);
        Value value = new ColorValue("RenderBreadcrumbsColor", new ColorValueInfo(new Color(255, 180, 90, 230)), false, 4, null).displayable(Blink::renderBreadcrumbsColorValue$lambda$13);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type net.ccbluex.liquidbounce.value.impl.ColorValue");
        renderBreadcrumbsColorValue = (ColorValue)value;
        cancelValue = new BoolValue("Cancel", true);
        Value value2 = new KeyValue("CancelKey", "LALT").displayable(Blink::cancelKeyValue$lambda$14);
        Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type net.ccbluex.liquidbounce.value.impl.KeyValue");
        cancelKeyValue = (KeyValue)value2;
        cancelSendEmptyCPacketPlayerValue = new BoolValue("CancelSendEmptyCPacketPlayer", true).displayable(Blink::cancelSendEmptyCPacketPlayerValue$lambda$15);
        cancelResendC0FC00Value = new BoolValue("CancelResendC0FC00", true).displayable(Blink::cancelResendC0FC00Value$lambda$16);
        blockFlyValue = new BoolValue("BlockFly", false);
        valueArray = new IntegerValue("BlockFlyLaunchTick", 40, new IntRange(1, 120));
        Value $this$blockFlyLaunchTickValue_u24lambda_u2417 = valueArray;
        boolean bl8 = false;
        $this$blockFlyLaunchTickValue_u24lambda_u2417.setSuperValue(blockFlyValue);
        blockFlyLaunchTickValue = valueArray;
        valueArray = new IntegerValue("BlockFlyReleaseTick", 10, new IntRange(1, 120));
        Value $this$blockFlyReleaseTickValue_u24lambda_u2418 = valueArray;
        boolean bl9 = false;
        $this$blockFlyReleaseTickValue_u24lambda_u2418.setSuperValue(blockFlyValue);
        blockFlyReleaseTickValue = valueArray;
        packetStates = new HashMap();
        valueArray = new Value[]{autoReleaseOldPacketValue, autoReleaseOldPacketTickValue, autoOffValue, autoOffOnAttackEntityValue, autoOffOnInteractEntityValue, autoOffOnUseItemValue, autoOffOnUseItemOnBlockValue, autoOffOnKnockBackValue, autoOffOnTeleportValue, renderValue, renderBreadcrumbsValue, renderBreadcrumbsColorValue, renderFakePlayerValue, renderFakePlayerAlphaValue, renderFakePlayerItemsValue, renderFakePlayerDisplayDistanceValue, renderFakePlayerMoveReleaseOldPacketValue, cancelValue, cancelKeyValue, cancelResendC0FC00Value, cancelSendEmptyCPacketPlayerValue, blockFlyValue, blockFlyLaunchTickValue, blockFlyReleaseTickValue};
        INSTANCE.getValues().addAll(CollectionsKt.mutableListOf(valueArray));
        Value[] $this$_init__u24lambda_u2419 = valueArray = (List)new ArrayList();
        boolean bl10 = false;
        $this$_init__u24lambda_u2419.addAll((Collection)PacketUtils.INSTANCE.getCLIENT_PACKETS());
        $this$_init__u24lambda_u2419.addAll((Collection)PacketUtils.INSTANCE.getSERVER_PACKETS());
        Iterable $this$onEach$iv = (Iterable)valueArray;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl11 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            Class it = (Class)element$iv;
            boolean bl12 = false;
            String packetName = PacketDebugger.INSTANCE.getPacketName(it);
            boolean bl13 = INSTANCE.getDefaultMode(packetName);
            INSTANCE.getValues().add(new BoolValue(it, packetName, bl13){
                private final Class<? extends Packet<?>> clazz;
                {
                    this.clazz = $it;
                    this.onChanged(this.getValue(), this.getValue());
                }

                public final Class<? extends Packet<?>> getClazz() {
                    return this.clazz;
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    ((Map)Blink.access$getPacketStates$p()).put(this.clazz.getName(), newValue);
                }

                public void fromJson(JsonElement element) {
                    Intrinsics.checkNotNullParameter(element, "element");
                    super.fromJson(element);
                    this.onChange((Boolean)this.getValue(), (Boolean)this.getValue());
                }
            });
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/Blink$FakePlayer;", "Lnet/minecraft/client/entity/EntityOtherPlayerMP;", "Lnet/ccbluex/liquidbounce/handler/combat/IFakeEntity;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "<init>", "(Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/client/entity/EntityPlayerSP;)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "updateBlinkSettings", "", "updatePosition", "position", "Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickPositionData;", "remove", "isInvisibleToPlayer", "", "Lnet/minecraft/entity/player/EntityPlayer;", "getCollisionBoundingBox", "Lnet/minecraft/util/math/AxisAlignedBB;", "canBeCollidedWith", "setEntityBoundingBox", "bb", "Companion", "DarkMeow"})
    public static final class FakePlayer
    extends EntityOtherPlayerMP
    implements IFakeEntity {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final EntityPlayerSP player;
        @NotNull
        private static final AxisAlignedBB EMPTY_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

        public FakePlayer(@NotNull WorldClient world, @NotNull EntityPlayerSP player) {
            Intrinsics.checkNotNullParameter(world, "world");
            Intrinsics.checkNotNullParameter(player, "player");
            super((World)world, player.func_146103_bH());
            this.player = player;
            this.field_70145_X = true;
            this.func_82149_j((Entity)this.player);
            this.updateBlinkSettings();
            world.func_73027_a(-1337, (Entity)this);
        }

        @NotNull
        public final EntityPlayerSP getPlayer() {
            return this.player;
        }

        public final void updateBlinkSettings() {
            if (((Boolean)renderValue.get()).booleanValue() && ((Boolean)renderFakePlayerItemsValue.get()).booleanValue()) {
                this.field_71071_by.func_70455_b(this.player.field_71071_by);
            } else {
                this.field_71071_by.func_174888_l();
            }
            if (!((Boolean)renderValue.get()).booleanValue() || !((Boolean)renderFakePlayerValue.get()).booleanValue()) {
                this.func_82142_c(true);
            } else if (((Boolean)renderFakePlayerAlphaValue.get()).booleanValue()) {
                this.func_82142_c(true);
                this.func_71033_a(GameType.SPECTATOR);
            } else {
                this.func_82142_c(false);
                this.func_71033_a(GameType.CREATIVE);
            }
        }

        public final void updatePosition(@NotNull BlinkTickPositionData position) {
            Intrinsics.checkNotNullParameter(position, "position");
            if (((Boolean)renderFakePlayerMoveReleaseOldPacketValue.get()).booleanValue()) {
                position.resetPlayer((EntityPlayer)this);
            }
        }

        public final void remove() {
            this.field_70170_p.func_72900_e((Entity)this);
        }

        public boolean func_98034_c(@NotNull EntityPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return (Boolean)renderValue.get() == false || (Boolean)renderFakePlayerValue.get() == false;
        }

        @Nullable
        public AxisAlignedBB func_70046_E() {
            return null;
        }

        public boolean func_70067_L() {
            return false;
        }

        public void func_174826_a(@NotNull AxisAlignedBB bb2) {
            Intrinsics.checkNotNullParameter(bb2, "bb");
            super.func_174826_a((Boolean)renderFakePlayerValue.get() != false ? bb2 : EMPTY_AABB);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/Blink$FakePlayer$Companion;", "", "<init>", "()V", "EMPTY_AABB", "Lnet/minecraft/util/math/AxisAlignedBB;", "getEMPTY_AABB", "()Lnet/minecraft/util/math/AxisAlignedBB;", "DarkMeow"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final AxisAlignedBB getEMPTY_AABB() {
                return EMPTY_AABB;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PacketSide.values().length];
            try {
                nArray[PacketSide.CLIENT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PacketSide.SERVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}


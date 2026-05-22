/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.combat.allows;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.control.UpdateMouseOverEvent;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/allows/AllowAttackManager;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "manager", "Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;)V", "getManager", "()Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "allows", "", "Lnet/minecraft/entity/EntityLivingBase;", "lastAllow", "handleEvents", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAllowAttackManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllowAttackManager.kt\nnet/ccbluex/liquidbounce/handler/combat/allows/AllowAttackManager\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n20#2,3:67\n13#2,2:70\n1#3:72\n*S KotlinDebug\n*F\n+ 1 AllowAttackManager.kt\nnet/ccbluex/liquidbounce/handler/combat/allows/AllowAttackManager\n*L\n27#1:67,3\n47#1:70,2\n*E\n"})
public final class AllowAttackManager
implements ListenableOwner {
    @NotNull
    private final CombatManager manager;
    @JvmField
    @NotNull
    public final Set<EntityLivingBase> allows;
    @JvmField
    @Nullable
    public EntityLivingBase lastAllow;

    /*
     * WARNING - void declaration
     */
    public AllowAttackManager(@NotNull CombatManager manager) {
        void $this$listener$iv;
        ListenableOwner $receiver$iv;
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.manager = manager;
        this.allows = new LinkedHashSet();
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> AllowAttackManager._init_$lambda$8(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<UpdateMouseOverEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(UpdateMouseOverEvent.POST.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        priority$iv = 2000;
        function$iv = (arg_0, arg_1) -> AllowAttackManager._init_$lambda$14(this, arg_0, arg_1);
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$this$listener$iv).add(new EventHookOwnerCheck<UpdateMouseOverEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PacketEvent.class), (ListenableOwner)$this$listener$iv));
    }

    @NotNull
    public final CombatManager getManager() {
        return this.manager;
    }

    @Override
    public boolean handleEvents() {
        return true;
    }

    private static final Unit _init_$lambda$8(AllowAttackManager this$0, SafeListenerBase $this$safeListener, UpdateMouseOverEvent.POST event) {
        block5: {
            UpdateMouseOverEvent.POST pOST;
            UpdateMouseOverEvent.POST pOST2;
            UpdateMouseOverEvent.POST pOST3;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            UpdateMouseOverEvent.POST it = pOST3 = event;
            boolean bl2 = false;
            UpdateMouseOverEvent.POST pOST4 = pOST2 = Intrinsics.areEqual(it.getLookVec(), RotationUtils.INSTANCE.getVectorForRotation(it.getCurrentEntity(), this$0.manager.getSystem().getRotationManager().serverRotation)) ? pOST3 : null;
            if (pOST2 == null) break block5;
            UpdateMouseOverEvent.POST it2 = pOST = pOST2;
            boolean bl3 = false;
            UpdateMouseOverEvent.POST pOST5 = pOST3 = event.getCurrentEntity() instanceof EntityPlayerSP ? pOST : null;
            if (pOST3 != null && (pOST = (RayTraceResult)pOST3.getReturnValue()) != null) {
                UpdateMouseOverEvent.POST pOST6;
                UpdateMouseOverEvent.POST pOST7;
                UpdateMouseOverEvent.POST it3 = pOST7 = pOST;
                boolean bl4 = false;
                UpdateMouseOverEvent.POST pOST8 = pOST6 = ((RayTraceResult)it3).field_72313_a == RayTraceResult.Type.ENTITY ? pOST7 : null;
                if (pOST6 != null && (pOST7 = ((RayTraceResult)pOST6).field_72308_g) != null) {
                    UpdateMouseOverEvent.POST pOST9;
                    UpdateMouseOverEvent.POST pOST10;
                    UpdateMouseOverEvent.POST it4 = pOST10 = pOST7;
                    boolean bl5 = false;
                    UpdateMouseOverEvent.POST pOST11 = pOST9 = !(it4 instanceof IFakeEntity) ? pOST10 : null;
                    if (pOST9 != null) {
                        UpdateMouseOverEvent.POST pOST12;
                        UpdateMouseOverEvent.POST it5 = pOST12 = pOST9;
                        boolean bl6 = false;
                        UpdateMouseOverEvent.POST pOST13 = pOST10 = it5 instanceof EntityLivingBase ? pOST12 : null;
                        if (pOST10 != null) {
                            UpdateMouseOverEvent.POST pOST14;
                            UpdateMouseOverEvent.POST it6 = pOST14 = pOST10;
                            boolean bl7 = false;
                            UpdateMouseOverEvent.POST pOST15 = pOST12 = !(it6 instanceof EntityPlayerSP) ? pOST14 : null;
                            if (pOST12 != null) {
                                UpdateMouseOverEvent.POST it7 = pOST12;
                                boolean bl8 = false;
                                EntityLivingBase entityLivingBase = (EntityLivingBase)it7;
                                it7 = entityLivingBase;
                                boolean bl9 = false;
                                this$0.allows.add((EntityLivingBase)it7);
                                this$0.lastAllow = it7;
                            }
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$14(AllowAttackManager this$0, ListenerBase $this$listener, PacketEvent event) {
        block4: {
            WorldClient worldClient;
            WorldClient worldClient2;
            WorldClient worldClient3;
            Packet<?> packet;
            block3: {
                Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
                Intrinsics.checkNotNullParameter(event, "event");
                packet = event.getPacket();
                if (!(packet instanceof CPacketPlayer)) break block3;
                this$0.allows.clear();
                this$0.lastAllow = null;
                break block4;
            }
            if (!(packet instanceof SPacketEntityStatus) || (worldClient3 = this$0.manager.mc.field_71441_e) == null) break block4;
            WorldClient it = worldClient2 = worldClient3;
            boolean bl2 = false;
            Object object = worldClient = ((SPacketEntityStatus)packet).func_149160_c() == 3 ? worldClient2 : null;
            if (worldClient != null) {
                WorldClient it2 = worldClient;
                boolean bl3 = false;
                worldClient2 = ((SPacketEntityStatus)packet).func_149161_a((World)it2);
                if (worldClient2 != null) {
                    WorldClient worldClient4;
                    WorldClient worldClient5;
                    WorldClient it3 = worldClient5 = worldClient2;
                    boolean bl4 = false;
                    TypeIntrinsics.asMutableCollection(this$0.allows).remove(it3);
                    WorldClient it4 = worldClient4 = worldClient5;
                    boolean bl5 = false;
                    Object object2 = worldClient5 = Intrinsics.areEqual(this$0.lastAllow, it4) ? worldClient4 : null;
                    if (worldClient5 != null) {
                        it4 = worldClient4 = worldClient5;
                        boolean bl6 = false;
                        this$0.lastAllow = null;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}


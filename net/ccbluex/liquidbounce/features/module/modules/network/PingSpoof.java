/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClientStatus
 *  net.minecraft.network.play.client.CPacketKeepAlive
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.network;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketKeepAlive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="PingSpoof", description="Spoofs your ping to a given value.", category=ModuleCategory.NETWORK)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u0007\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/PingSpoof;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "maxDelayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "minDelayValue", "packetsMap", "Ljava/util/HashMap;", "Lnet/minecraft/network/Packet;", "", "Lkotlin/collections/HashMap;", "onDisable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "DarkMeow"})
public final class PingSpoof
extends Module {
    @NotNull
    private final IntegerValue maxDelayValue = new IntegerValue(this){
        final /* synthetic */ PingSpoof this$0;
        {
            this.this$0 = $receiver;
            super("MaxDelay", 1000, 0, 5000);
        }

        protected void onChanged(int oldValue, int newValue) {
            int minDelayValue2 = ((Number)PingSpoof.access$getMinDelayValue$p(this.this$0).get()).intValue();
            if (minDelayValue2 > newValue) {
                Value.set$default(this, minDelayValue2, false, 2, null);
            }
        }
    };
    @NotNull
    private final IntegerValue minDelayValue = new IntegerValue(this){
        final /* synthetic */ PingSpoof this$0;
        {
            this.this$0 = $receiver;
            super("MinDelay", 500, 0, 5000);
        }

        protected void onChanged(int oldValue, int newValue) {
            int maxDelayValue2 = ((Number)PingSpoof.access$getMaxDelayValue$p(this.this$0).get()).intValue();
            if (maxDelayValue2 < newValue) {
                Value.set$default(this, maxDelayValue2, false, 2, null);
            }
        }
    };
    @NotNull
    private final HashMap<Packet<?>, Long> packetsMap = new HashMap();

    public PingSpoof() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onDisable() {
        this.packetsMap.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof CPacketKeepAlive || packet instanceof CPacketClientStatus) {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            Intrinsics.checkNotNull(entityPlayerSP);
            if (!entityPlayerSP.field_70128_L) {
                EntityPlayerSP entityPlayerSP2 = MinecraftInstance.mc.getPlayer();
                Intrinsics.checkNotNull(entityPlayerSP2);
                if (!(entityPlayerSP2.func_110143_aJ() <= 0.0f) && !this.packetsMap.containsKey(packet)) {
                    event.cancelEvent();
                    HashMap<Packet<?>, Long> hashMap = this.packetsMap;
                    synchronized (hashMap) {
                        boolean bl2 = false;
                        Long l2 = this.packetsMap.put(packet, System.currentTimeMillis() + TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue()));
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @EventTarget(ignoreCondition=true)
    public final void onUpdate(@Nullable UpdateEvent event) {
        try {
            HashMap<Packet<?>, Long> hashMap = this.packetsMap;
            synchronized (hashMap) {
                boolean bl2 = false;
                Iterator<Map.Entry<Packet<?>, Long>> iterator2 = this.packetsMap.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Long value;
                    Map.Entry<Packet<?>, Long> entry = iterator2.next();
                    Packet<?> key = entry.getKey();
                    Long l2 = value = entry.getValue();
                    Intrinsics.checkNotNull(l2);
                    if (l2 >= System.currentTimeMillis()) continue;
                    NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
                    Intrinsics.checkNotNull(netHandlerPlayClient);
                    netHandlerPlayClient.func_147297_a(key);
                    iterator2.remove();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        catch (Throwable t2) {
            t2.printStackTrace();
        }
    }

    public static final /* synthetic */ IntegerValue access$getMinDelayValue$p(PingSpoof $this) {
        return $this.minDelayValue;
    }

    public static final /* synthetic */ IntegerValue access$getMaxDelayValue$p(PingSpoof $this) {
        return $this.maxDelayValue;
    }
}


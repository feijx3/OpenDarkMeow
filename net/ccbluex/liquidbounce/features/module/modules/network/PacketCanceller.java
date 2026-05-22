/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketDebugger;
import net.ccbluex.liquidbounce.utils.PacketUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="PacketCanceller", category=ModuleCategory.NETWORK)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketCanceller;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "packetStates", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPacketCanceller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PacketCanceller.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/PacketCanceller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n2756#2:53\n1#3:54\n*S KotlinDebug\n*F\n+ 1 PacketCanceller.kt\nnet/ccbluex/liquidbounce/features/module/modules/network/PacketCanceller\n*L\n28#1:53\n28#1:54\n*E\n"})
public final class PacketCanceller
extends Module {
    @NotNull
    private final HashMap<String, Boolean> packetStates = new HashMap();

    public PacketCanceller() {
        super(null, null, null, null, 15, null);
        Iterable iterable;
        List list;
        List $this$_init__u24lambda_u240 = list = (List)new ArrayList();
        boolean bl2 = false;
        $this$_init__u24lambda_u240.addAll((Collection)PacketUtils.INSTANCE.getCLIENT_PACKETS());
        $this$_init__u24lambda_u240.addAll((Collection)PacketUtils.INSTANCE.getSERVER_PACKETS());
        Iterable $this$onEach$iv = list;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            Class it = (Class)element$iv;
            boolean bl4 = false;
            String packetName = PacketDebugger.INSTANCE.getPacketName(it);
            this.getValues().add(new BoolValue(it, packetName, this){
                private final Class<? extends Packet<?>> clazz;
                final /* synthetic */ PacketCanceller this$0;
                {
                    this.this$0 = $receiver;
                    super($packetName, false);
                    this.clazz = $it;
                }

                public final Class<? extends Packet<?>> getClazz() {
                    return this.clazz;
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    ((Map)PacketCanceller.access$getPacketStates$p(this.this$0)).put(this.clazz.getName(), newValue);
                }

                public void fromJson(JsonElement element) {
                    Intrinsics.checkNotNullParameter(element, "element");
                    super.fromJson(element);
                    this.onChange((Boolean)this.getValue(), (Boolean)this.getValue());
                }
            });
        }
    }

    @EventTarget(ignoreCanceled=true, priority=2000)
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(this.packetStates.get(event.getPacket().getClass().getName()), true)) {
            event.cancelEvent();
        }
    }

    public static final /* synthetic */ HashMap access$getPacketStates$p(PacketCanceller $this) {
        return $this.packetStates;
    }
}


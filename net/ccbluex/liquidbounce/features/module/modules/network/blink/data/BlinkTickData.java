/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.network.blink.data;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.network.blink.data.BlinkTickBreadcrumbsData;
import net.ccbluex.liquidbounce.features.module.modules.network.blink.data.BlinkTickPositionData;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003H\u00c6\u0003J\u0013\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00c6\u0003JK\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickData;", "", "packetsClient", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lnet/minecraft/network/Packet;", "packetsServer", "breadcrumbs", "Ljava/util/LinkedList;", "Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickBreadcrumbsData;", "position", "Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickPositionData;", "<init>", "(Ljava/util/concurrent/LinkedBlockingQueue;Ljava/util/concurrent/LinkedBlockingQueue;Ljava/util/LinkedList;Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickPositionData;)V", "getPacketsClient", "()Ljava/util/concurrent/LinkedBlockingQueue;", "getPacketsServer", "getBreadcrumbs", "()Ljava/util/LinkedList;", "getPosition", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickPositionData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class BlinkTickData {
    @NotNull
    private final LinkedBlockingQueue<Packet<?>> packetsClient;
    @NotNull
    private final LinkedBlockingQueue<Packet<?>> packetsServer;
    @NotNull
    private final LinkedList<BlinkTickBreadcrumbsData> breadcrumbs;
    @NotNull
    private final BlinkTickPositionData position;

    public BlinkTickData(@NotNull LinkedBlockingQueue<Packet<?>> packetsClient, @NotNull LinkedBlockingQueue<Packet<?>> packetsServer, @NotNull LinkedList<BlinkTickBreadcrumbsData> breadcrumbs, @NotNull BlinkTickPositionData position) {
        Intrinsics.checkNotNullParameter(packetsClient, "packetsClient");
        Intrinsics.checkNotNullParameter(packetsServer, "packetsServer");
        Intrinsics.checkNotNullParameter(breadcrumbs, "breadcrumbs");
        Intrinsics.checkNotNullParameter(position, "position");
        this.packetsClient = packetsClient;
        this.packetsServer = packetsServer;
        this.breadcrumbs = breadcrumbs;
        this.position = position;
    }

    public /* synthetic */ BlinkTickData(LinkedBlockingQueue linkedBlockingQueue, LinkedBlockingQueue linkedBlockingQueue2, LinkedList linkedList, BlinkTickPositionData blinkTickPositionData, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        if ((n2 & 2) != 0) {
            linkedBlockingQueue2 = new LinkedBlockingQueue();
        }
        if ((n2 & 4) != 0) {
            linkedList = new LinkedList<BlinkTickBreadcrumbsData>();
        }
        this(linkedBlockingQueue, linkedBlockingQueue2, linkedList, blinkTickPositionData);
    }

    @NotNull
    public final LinkedBlockingQueue<Packet<?>> getPacketsClient() {
        return this.packetsClient;
    }

    @NotNull
    public final LinkedBlockingQueue<Packet<?>> getPacketsServer() {
        return this.packetsServer;
    }

    @NotNull
    public final LinkedList<BlinkTickBreadcrumbsData> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    @NotNull
    public final BlinkTickPositionData getPosition() {
        return this.position;
    }

    @NotNull
    public final LinkedBlockingQueue<Packet<?>> component1() {
        return this.packetsClient;
    }

    @NotNull
    public final LinkedBlockingQueue<Packet<?>> component2() {
        return this.packetsServer;
    }

    @NotNull
    public final LinkedList<BlinkTickBreadcrumbsData> component3() {
        return this.breadcrumbs;
    }

    @NotNull
    public final BlinkTickPositionData component4() {
        return this.position;
    }

    @NotNull
    public final BlinkTickData copy(@NotNull LinkedBlockingQueue<Packet<?>> packetsClient, @NotNull LinkedBlockingQueue<Packet<?>> packetsServer, @NotNull LinkedList<BlinkTickBreadcrumbsData> breadcrumbs, @NotNull BlinkTickPositionData position) {
        Intrinsics.checkNotNullParameter(packetsClient, "packetsClient");
        Intrinsics.checkNotNullParameter(packetsServer, "packetsServer");
        Intrinsics.checkNotNullParameter(breadcrumbs, "breadcrumbs");
        Intrinsics.checkNotNullParameter(position, "position");
        return new BlinkTickData(packetsClient, packetsServer, breadcrumbs, position);
    }

    public static /* synthetic */ BlinkTickData copy$default(BlinkTickData blinkTickData, LinkedBlockingQueue linkedBlockingQueue, LinkedBlockingQueue linkedBlockingQueue2, LinkedList linkedList, BlinkTickPositionData blinkTickPositionData, int n2, Object object) {
        if ((n2 & 1) != 0) {
            linkedBlockingQueue = blinkTickData.packetsClient;
        }
        if ((n2 & 2) != 0) {
            linkedBlockingQueue2 = blinkTickData.packetsServer;
        }
        if ((n2 & 4) != 0) {
            linkedList = blinkTickData.breadcrumbs;
        }
        if ((n2 & 8) != 0) {
            blinkTickPositionData = blinkTickData.position;
        }
        return blinkTickData.copy(linkedBlockingQueue, linkedBlockingQueue2, linkedList, blinkTickPositionData);
    }

    @NotNull
    public String toString() {
        return "BlinkTickData(packetsClient=" + this.packetsClient + ", packetsServer=" + this.packetsServer + ", breadcrumbs=" + this.breadcrumbs + ", position=" + this.position + ')';
    }

    public int hashCode() {
        int result = this.packetsClient.hashCode();
        result = result * 31 + this.packetsServer.hashCode();
        result = result * 31 + this.breadcrumbs.hashCode();
        result = result * 31 + this.position.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlinkTickData)) {
            return false;
        }
        BlinkTickData blinkTickData = (BlinkTickData)other;
        if (!Intrinsics.areEqual(this.packetsClient, blinkTickData.packetsClient)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.packetsServer, blinkTickData.packetsServer)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.breadcrumbs, blinkTickData.breadcrumbs)) {
            return false;
        }
        return Intrinsics.areEqual(this.position, blinkTickData.position);
    }
}


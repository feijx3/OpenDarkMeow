/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.event.listenable;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0002\b\f\u00a8\u0006\u000f"}, d2={"Lnet/darkmeow/darkmeow/event/listenable/ListenerBaseUtils;", "", "<init>", "()V", "get", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "mc", "Lnet/minecraft/client/Minecraft;", "execute", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "safeExecute", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "DarkMeow"})
public final class ListenerBaseUtils {
    @NotNull
    public static final ListenerBaseUtils INSTANCE = new ListenerBaseUtils();

    private ListenerBaseUtils() {
    }

    @NotNull
    public final ListenerBase get(@NotNull Minecraft mc) {
        Intrinsics.checkNotNullParameter(mc, "mc");
        EntityPlayerSP entityPlayerSP = mc.field_71439_g;
        if (entityPlayerSP == null) {
            return new ListenerBase(mc, null, null, null, null, null, 62, null);
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = mc.field_71441_e;
        if (worldClient == null) {
            return new ListenerBase(mc, null, null, null, null, null, 62, null);
        }
        WorldClient world = worldClient;
        Entity entity = mc.func_175606_aa();
        if (entity == null) {
            return new ListenerBase(mc, null, null, null, null, null, 62, null);
        }
        Entity renderViewEntity = entity;
        PlayerControllerMP playerControllerMP = mc.field_71442_b;
        Intrinsics.checkNotNullExpressionValue(playerControllerMP, "playerController");
        NetHandlerPlayClient netHandlerPlayClient = player.field_71174_a;
        Intrinsics.checkNotNullExpressionValue(netHandlerPlayClient, "connection");
        return new SafeListenerBase(mc, world, player, playerControllerMP, netHandlerPlayClient, renderViewEntity);
    }

    public static /* synthetic */ ListenerBase get$default(ListenerBaseUtils listenerBaseUtils, Minecraft minecraft, int n2, Object object) {
        if ((n2 & 1) != 0) {
            Minecraft minecraft2 = Minecraft.func_71410_x();
            Intrinsics.checkNotNullExpressionValue(minecraft2, "getMinecraft(...)");
            minecraft = minecraft2;
        }
        return listenerBaseUtils.get(minecraft);
    }

    public final void execute(@NotNull Function1<? super ListenerBase, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ListenerBase listenerBase = ListenerBaseUtils.get$default(this, null, 1, null);
        block.invoke(listenerBase);
    }

    public final void safeExecute(@NotNull Function1<? super SafeListenerBase, Unit> block) {
        block0: {
            Intrinsics.checkNotNullParameter(block, "block");
            ListenerBase listenerBase = ListenerBaseUtils.get$default(this, null, 1, null);
            SafeListenerBase safeListenerBase = listenerBase instanceof SafeListenerBase ? (SafeListenerBase)listenerBase : null;
            if (safeListenerBase == null) break block0;
            listenerBase = safeListenerBase;
            block.invoke((SafeListenerBase)listenerBase);
        }
    }
}


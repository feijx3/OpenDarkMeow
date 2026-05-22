/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.move.MoveEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="SafeWalk", description="Prevents you from falling down as if you were sneaking.", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/SafeWalk;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "groundCheckValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onlyVoidValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "allowSafeWalk", "", "Lkotlin/Function1;", "Lnet/ccbluex/liquidbounce/injection/backend/MinecraftImpl;", "Lkotlin/ParameterName;", "name", "mc", "", "isAllowSafeWalk", "onMove", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/move/MoveEvent;", "checkVoid", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSafeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeWalk.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/SafeWalk\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1869#2,2:59\n*S KotlinDebug\n*F\n+ 1 SafeWalk.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/SafeWalk\n*L\n21#1:59,2\n*E\n"})
public final class SafeWalk
extends Module {
    @NotNull
    private final ListValue groundCheckValue;
    @NotNull
    private final BoolValue onlyVoidValue;
    @NotNull
    private final List<Function1<MinecraftImpl, Boolean>> allowSafeWalk;

    public SafeWalk() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Always", "OnlyGround", "OnlyAir"};
        this.groundCheckValue = new ListValue("GroundCheck", stringArray, "Always");
        this.onlyVoidValue = new BoolValue("OnlyPredictVoid", false);
        this.allowSafeWalk = new ArrayList();
        this.allowSafeWalk.add(arg_0 -> SafeWalk._init_$lambda$1(this, arg_0));
        this.allowSafeWalk.add(arg_0 -> SafeWalk._init_$lambda$2(this, arg_0));
    }

    private final boolean isAllowSafeWalk() {
        Iterable $this$forEach$iv = this.allowSafeWalk;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1)element$iv;
            boolean bl2 = false;
            MinecraftImpl minecraftImpl = MinecraftInstance.mc;
            Intrinsics.checkNotNullExpressionValue(minecraftImpl, "mc");
            if (((Boolean)it.invoke(minecraftImpl)).booleanValue()) continue;
            return false;
        }
        return true;
    }

    @EventTarget
    public final void onMove(@NotNull MoveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.setSafeWalk(this.isAllowSafeWalk());
    }

    private final boolean checkVoid() {
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return false;
        }
        WorldClient world = worldClient;
        boolean dangerous = true;
        for (int i2 = (int)(-(player.field_70163_u - 1.4857625)); i2 <= 0; ++i2) {
            dangerous = world.func_184144_a((Entity)player, player.func_174813_aQ().func_72317_d(player.field_70159_w * 1.4, (double)i2, player.field_70179_y * 1.4)).isEmpty();
            if (dangerous) continue;
            break;
        }
        return dangerous;
    }

    private static final boolean _init_$lambda$1(SafeWalk this$0, MinecraftImpl it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (((Boolean)this$0.onlyVoidValue.get()).booleanValue()) {
            return !this$0.checkVoid();
        }
        return true;
    }

    private static final boolean _init_$lambda$2(SafeWalk this$0, MinecraftImpl it) {
        Intrinsics.checkNotNullParameter(it, "it");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return true;
        }
        boolean onGround = entityPlayerSP.field_70122_E;
        String string = (String)this$0.groundCheckValue.get();
        if (Intrinsics.areEqual(string, "OnlyGround")) {
            return onGround;
        }
        if (Intrinsics.areEqual(string, "OnlyAir")) {
            return !onGround;
        }
        return true;
    }
}


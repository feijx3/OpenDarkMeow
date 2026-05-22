/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.Slot
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000b\"\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\u000f*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0015\u0010\u0014\u001a\u00020\u000f*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011\"\u0015\u0010\u0016\u001a\u00020\u000f*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\u0018"}, d2={"getDistanceToEntityBox", "", "Lnet/minecraft/entity/Entity;", "entity", "getNearestPointBB", "Lnet/minecraft/util/math/Vec3d;", "eye", "box", "Lnet/minecraft/util/math/AxisAlignedBB;", "getPing", "", "Lnet/minecraft/entity/player/EntityPlayer;", "isClientFriend", "", "headSlot", "Lnet/minecraft/inventory/Slot;", "getHeadSlot", "(Lnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/inventory/Slot;", "chestSlot", "getChestSlot", "legsSlot", "getLegsSlot", "feetSlot", "getFeetSlot", "DarkMeow"})
public final class PlayerExtensionKt {
    public static final double getDistanceToEntityBox(@NotNull Entity $this$getDistanceToEntityBox, @NotNull Entity entity) {
        Intrinsics.checkNotNullParameter($this$getDistanceToEntityBox, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Vec3d eyes = $this$getDistanceToEntityBox.func_174824_e(1.0f);
        Intrinsics.checkNotNull(eyes);
        AxisAlignedBB axisAlignedBB = entity.func_174813_aQ();
        Intrinsics.checkNotNullExpressionValue(axisAlignedBB, "getEntityBoundingBox(...)");
        Vec3d pos = PlayerExtensionKt.getNearestPointBB(eyes, axisAlignedBB);
        double xDist = Math.abs(pos.field_72450_a - eyes.field_72450_a);
        double yDist = Math.abs(pos.field_72448_b - eyes.field_72448_b);
        double zDist = Math.abs(pos.field_72449_c - eyes.field_72449_c);
        return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2) + Math.pow(zDist, 2));
    }

    @NotNull
    public static final Vec3d getNearestPointBB(@NotNull Vec3d eye, @NotNull AxisAlignedBB box) {
        Intrinsics.checkNotNullParameter(eye, "eye");
        Intrinsics.checkNotNullParameter(box, "box");
        double[] dArray = new double[]{eye.field_72450_a, eye.field_72448_b, eye.field_72449_c};
        double[] origin = dArray;
        double[] dArray2 = new double[]{box.field_72340_a, box.field_72338_b, box.field_72339_c};
        double[] destMins = dArray2;
        double[] dArray3 = new double[]{box.field_72336_d, box.field_72337_e, box.field_72334_f};
        double[] destMaxs = dArray3;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (origin[i2] > destMaxs[i2]) {
                origin[i2] = destMaxs[i2];
                continue;
            }
            if (!(origin[i2] < destMins[i2])) continue;
            origin[i2] = destMins[i2];
        }
        return new Vec3d(origin[0], origin[1], origin[2]);
    }

    public static final int getPing(@NotNull EntityPlayer $this$getPing) {
        NetworkPlayerInfo playerInfo;
        Intrinsics.checkNotNullParameter($this$getPing, "<this>");
        NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc.getConnection();
        NetworkPlayerInfo networkPlayerInfo = playerInfo = netHandlerPlayClient != null ? netHandlerPlayClient.func_175102_a($this$getPing.func_110124_au()) : null;
        return networkPlayerInfo != null ? networkPlayerInfo.func_178853_c() : 0;
    }

    public static final boolean isClientFriend(@NotNull EntityPlayer $this$isClientFriend) {
        Intrinsics.checkNotNullParameter($this$isClientFriend, "<this>");
        String string = $this$isClientFriend.func_70005_c_();
        if (string == null) {
            return false;
        }
        String entityName = string;
        return DarkMeow.INSTANCE.getFileManager().getFriendsConfig().isFriend(ColorUtils.stripColor(entityName));
    }

    @NotNull
    public static final Slot getHeadSlot(@NotNull EntityPlayer $this$headSlot) {
        Intrinsics.checkNotNullParameter($this$headSlot, "<this>");
        Object e2 = $this$headSlot.field_71069_bz.field_75151_b.get(5);
        Intrinsics.checkNotNullExpressionValue(e2, "get(...)");
        return (Slot)e2;
    }

    @NotNull
    public static final Slot getChestSlot(@NotNull EntityPlayer $this$chestSlot) {
        Intrinsics.checkNotNullParameter($this$chestSlot, "<this>");
        Object e2 = $this$chestSlot.field_71069_bz.field_75151_b.get(6);
        Intrinsics.checkNotNullExpressionValue(e2, "get(...)");
        return (Slot)e2;
    }

    @NotNull
    public static final Slot getLegsSlot(@NotNull EntityPlayer $this$legsSlot) {
        Intrinsics.checkNotNullParameter($this$legsSlot, "<this>");
        Object e2 = $this$legsSlot.field_71069_bz.field_75151_b.get(7);
        Intrinsics.checkNotNullExpressionValue(e2, "get(...)");
        return (Slot)e2;
    }

    @NotNull
    public static final Slot getFeetSlot(@NotNull EntityPlayer $this$feetSlot) {
        Intrinsics.checkNotNullParameter($this$feetSlot, "<this>");
        Object e2 = $this$feetSlot.field_71069_bz.field_75151_b.get(8);
        Intrinsics.checkNotNullExpressionValue(e2, "get(...)");
        return (Slot)e2;
    }
}


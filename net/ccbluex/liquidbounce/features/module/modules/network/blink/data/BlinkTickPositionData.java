/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.blink.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0010\u0010\u0014J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010 R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010 \u00a8\u0006$"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/blink/data/BlinkTickPositionData;", "", "posX", "", "posY", "posZ", "rotationYaw", "", "rotationPitch", "fallDistance", "motionX", "motionY", "motionZ", "isSprinting", "", "isSneaking", "<init>", "(DDDFFFDDDZZ)V", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "(Lnet/minecraft/client/entity/EntityPlayerSP;)V", "getPosX", "()D", "getPosY", "getPosZ", "getRotationYaw", "()F", "getRotationPitch", "getFallDistance", "getMotionX", "getMotionY", "getMotionZ", "()Z", "resetPlayer", "", "Lnet/minecraft/entity/player/EntityPlayer;", "DarkMeow"})
public final class BlinkTickPositionData {
    private final double posX;
    private final double posY;
    private final double posZ;
    private final float rotationYaw;
    private final float rotationPitch;
    private final float fallDistance;
    private final double motionX;
    private final double motionY;
    private final double motionZ;
    private final boolean isSprinting;
    private final boolean isSneaking;

    public BlinkTickPositionData(double posX, double posY, double posZ, float rotationYaw, float rotationPitch, float fallDistance, double motionX, double motionY, double motionZ, boolean isSprinting, boolean isSneaking) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.rotationYaw = rotationYaw;
        this.rotationPitch = rotationPitch;
        this.fallDistance = fallDistance;
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        this.isSprinting = isSprinting;
        this.isSneaking = isSneaking;
    }

    public final double getPosX() {
        return this.posX;
    }

    public final double getPosY() {
        return this.posY;
    }

    public final double getPosZ() {
        return this.posZ;
    }

    public final float getRotationYaw() {
        return this.rotationYaw;
    }

    public final float getRotationPitch() {
        return this.rotationPitch;
    }

    public final float getFallDistance() {
        return this.fallDistance;
    }

    public final double getMotionX() {
        return this.motionX;
    }

    public final double getMotionY() {
        return this.motionY;
    }

    public final double getMotionZ() {
        return this.motionZ;
    }

    public final boolean isSprinting() {
        return this.isSprinting;
    }

    public final boolean isSneaking() {
        return this.isSneaking;
    }

    public BlinkTickPositionData(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this(player.field_70165_t, player.field_70163_u, player.field_70161_v, player.field_70177_z, player.field_70125_A, player.field_70143_R, player.field_70159_w, player.field_70181_x, player.field_70179_y, ExtendEntityPlayerSP.INSTANCE.getServerSprintState(player), ExtendEntityPlayerSP.INSTANCE.getServerSneakState(player));
    }

    public final void resetPlayer(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.resetPlayer((EntityPlayer)player);
        ExtendEntityPlayerSP.INSTANCE.setServerSprintState(player, this.isSprinting);
        ExtendEntityPlayerSP.INSTANCE.setServerSneakState(player, this.isSneaking);
    }

    public final void resetPlayer(@NotNull EntityPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        player.func_70107_b(this.posX, this.posY, this.posZ);
        player.field_70177_z = this.rotationYaw;
        player.field_70125_A = this.rotationPitch;
        player.field_70142_S = this.posX;
        player.field_70137_T = this.posY;
        player.field_70136_U = this.posZ;
        player.field_70143_R = this.fallDistance;
        player.field_70159_w = this.motionX;
        player.field_70181_x = this.motionY;
        player.field_70179_y = this.motionZ;
        player.func_70031_b(this.isSprinting);
        player.func_70095_a(this.isSneaking);
    }
}


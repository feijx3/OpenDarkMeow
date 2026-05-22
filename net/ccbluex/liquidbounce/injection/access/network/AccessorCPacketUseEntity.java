/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.Vec3d
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketUseEntity.class})
public interface AccessorCPacketUseEntity {
    @Accessor(value="entityId")
    public int getEntityId();

    @Accessor(value="entityId")
    public void setEntityId(int var1);

    @Accessor(value="action")
    public CPacketUseEntity.Action func_149565_c();

    @Accessor(value="action")
    public void setAction(CPacketUseEntity.Action var1);

    @Accessor(value="hitVec")
    public Vec3d func_179712_b();

    @Accessor(value="hitVec")
    public void setHitVec(Vec3d var1);

    @Accessor(value="hand")
    public EnumHand func_186994_b();

    @Accessor(value="hand")
    public void setHand(EnumHand var1);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAreaEffectCloud
 *  net.minecraft.entity.EntityLeashKnot
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityEnderEye
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityFallingBlock
 *  net.minecraft.entity.item.EntityFireworkRocket
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.item.EntityPainting
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.passive.IAnimals
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityDragonFireball
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.entity.projectile.EntityEvokerFangs
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.entity.projectile.EntityLlamaSpit
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.entity.projectile.EntitySpectralArrow
 *  net.minecraft.entity.projectile.EntityTippedArrow
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketSpawnExperienceOrb
 *  net.minecraft.network.play.server.SPacketSpawnMob
 *  net.minecraft.network.play.server.SPacketSpawnObject
 *  net.minecraft.network.play.server.SPacketSpawnPainting
 *  net.minecraft.network.play.server.SPacketSpawnPlayer
 *  net.minecraft.util.EnumFacing
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.util.EnumFacing;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/utils/PacketForwardEntityUtils;", "", "<init>", "()V", "createSpawnPacket", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/entity/Entity;", "DarkMeow"})
public final class PacketForwardEntityUtils {
    @NotNull
    public static final PacketForwardEntityUtils INSTANCE = new PacketForwardEntityUtils();

    private PacketForwardEntityUtils() {
    }

    @NotNull
    public final Packet<?> createSpawnPacket(@NotNull Entity $this$createSpawnPacket) {
        Packet packet;
        Intrinsics.checkNotNullParameter($this$createSpawnPacket, "<this>");
        Entity entity = $this$createSpawnPacket;
        if (entity instanceof EntityPlayer) {
            packet = (Packet)new SPacketSpawnPlayer((EntityPlayer)entity);
        } else if (entity instanceof IAnimals) {
            packet = (Packet)new SPacketSpawnMob((EntityLivingBase)entity);
        } else if (entity instanceof EntityPainting) {
            packet = (Packet)new SPacketSpawnPainting((EntityPainting)entity);
        } else if (entity instanceof EntityItem) {
            packet = (Packet)new SPacketSpawnObject(entity, 2, 1);
        } else if (entity instanceof EntityMinecart) {
            packet = (Packet)new SPacketSpawnObject(entity, 10, ((EntityMinecart)entity).func_184264_v().func_184956_a());
        } else if (entity instanceof EntityBoat) {
            packet = (Packet)new SPacketSpawnObject(entity, 1);
        } else if (entity instanceof EntityXPOrb) {
            packet = (Packet)new SPacketSpawnExperienceOrb((EntityXPOrb)entity);
        } else if (entity instanceof EntityFishHook) {
            EntityPlayer entityPlayer = ((EntityFishHook)entity).func_190619_l();
            packet = (Packet)new SPacketSpawnObject(entity, 90, entityPlayer != null ? entityPlayer.func_145782_y() : ((EntityFishHook)entity).func_145782_y());
        } else if (entity instanceof EntitySpectralArrow) {
            Entity entity2 = ((EntitySpectralArrow)entity).field_70250_c;
            packet = (Packet)new SPacketSpawnObject(entity, 91, 1 + (entity2 != null ? entity2.func_145782_y() : ((EntitySpectralArrow)entity).func_145782_y()));
        } else if (entity instanceof EntityTippedArrow) {
            Entity entity3 = ((EntityTippedArrow)entity).field_70250_c;
            packet = (Packet)new SPacketSpawnObject(entity, 60, 1 + (entity3 != null ? entity3.func_145782_y() : ((EntityTippedArrow)entity).func_145782_y()));
        } else if (entity instanceof EntitySnowball) {
            packet = (Packet)new SPacketSpawnObject(entity, 61);
        } else if (entity instanceof EntityLlamaSpit) {
            packet = (Packet)new SPacketSpawnObject(entity, 68);
        } else if (entity instanceof EntityPotion) {
            packet = (Packet)new SPacketSpawnObject(entity, 73);
        } else if (entity instanceof EntityExpBottle) {
            packet = (Packet)new SPacketSpawnObject(entity, 75);
        } else if (entity instanceof EntityEnderPearl) {
            packet = (Packet)new SPacketSpawnObject(entity, 65);
        } else if (entity instanceof EntityEnderEye) {
            packet = (Packet)new SPacketSpawnObject(entity, 72);
        } else if (entity instanceof EntityFireworkRocket) {
            packet = (Packet)new SPacketSpawnObject(entity, 76);
        } else if (entity instanceof EntityFireball) {
            EntityFireball entityFireball = (EntityFireball)entity;
            int n2 = entityFireball instanceof EntitySmallFireball ? 64 : (entityFireball instanceof EntityDragonFireball ? 93 : (entityFireball instanceof EntityWitherSkull ? 66 : 63));
            EntityLivingBase entityLivingBase = ((EntityFireball)entity).field_70235_a;
            EntityFireball $this$createSpawnPacket_u24lambda_u240 = entityFireball = new SPacketSpawnObject(entity, n2, entityLivingBase != null ? entityLivingBase.func_145782_y() : 0);
            boolean bl2 = false;
            $this$createSpawnPacket_u24lambda_u240.func_149003_d((int)(((EntityFireball)entity).field_70232_b * 8000.0));
            $this$createSpawnPacket_u24lambda_u240.func_149000_e((int)(((EntityFireball)entity).field_70233_c * 8000.0));
            $this$createSpawnPacket_u24lambda_u240.func_149007_f((int)(((EntityFireball)entity).field_70230_d * 8000.0));
            packet = (Packet)entityFireball;
        } else if (entity instanceof EntityShulkerBullet) {
            SPacketSpawnObject sPacketSpawnObject;
            SPacketSpawnObject $this$createSpawnPacket_u24lambda_u241 = sPacketSpawnObject = new SPacketSpawnObject(entity, 67, 0);
            boolean bl3 = false;
            $this$createSpawnPacket_u24lambda_u241.func_149003_d((int)(entity.field_70159_w * 8000.0));
            $this$createSpawnPacket_u24lambda_u241.func_149000_e((int)(entity.field_70181_x * 8000.0));
            $this$createSpawnPacket_u24lambda_u241.func_149007_f((int)(entity.field_70179_y * 8000.0));
            packet = (Packet)sPacketSpawnObject;
        } else if (entity instanceof EntityEgg) {
            packet = (Packet)new SPacketSpawnObject(entity, 62);
        } else if (entity instanceof EntityEvokerFangs) {
            packet = (Packet)new SPacketSpawnObject(entity, 79);
        } else if (entity instanceof EntityTNTPrimed) {
            packet = (Packet)new SPacketSpawnObject(entity, 50);
        } else if (entity instanceof EntityEnderCrystal) {
            packet = (Packet)new SPacketSpawnObject(entity, 51);
        } else if (entity instanceof EntityFallingBlock) {
            IBlockState iBlockState = ((EntityFallingBlock)entity).func_175131_l();
            Intrinsics.checkNotNull(iBlockState);
            packet = (Packet)new SPacketSpawnObject(entity, 70, Block.func_176210_f((IBlockState)iBlockState));
        } else if (entity instanceof EntityArmorStand) {
            packet = (Packet)new SPacketSpawnObject(entity, 78);
        } else if (entity instanceof EntityItemFrame) {
            EnumFacing enumFacing = ((EntityItemFrame)entity).field_174860_b;
            Intrinsics.checkNotNull(enumFacing);
            packet = (Packet)new SPacketSpawnObject(entity, 71, enumFacing.func_176736_b(), ((EntityItemFrame)entity).func_174857_n());
        } else if (entity instanceof EntityLeashKnot) {
            packet = (Packet)new SPacketSpawnObject(entity, 77, 0, ((EntityLeashKnot)entity).func_174857_n());
        } else if (entity instanceof EntityAreaEffectCloud) {
            packet = (Packet)new SPacketSpawnObject(entity, 3);
        } else {
            throw new IllegalArgumentException("Don't know how to add " + entity.getClass().getName() + '!');
        }
        return packet;
    }
}


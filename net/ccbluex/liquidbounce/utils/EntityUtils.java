/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAreaEffectCloud
 *  net.minecraft.entity.EntityLeashKnot
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityWither
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
 *  net.minecraft.entity.item.EntityMinecartChest
 *  net.minecraft.entity.item.EntityMinecartCommandBlock
 *  net.minecraft.entity.item.EntityMinecartEmpty
 *  net.minecraft.entity.item.EntityMinecartFurnace
 *  net.minecraft.entity.item.EntityMinecartHopper
 *  net.minecraft.entity.item.EntityMinecartMobSpawner
 *  net.minecraft.entity.item.EntityMinecartTNT
 *  net.minecraft.entity.item.EntityPainting
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCaveSpider
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityElderGuardian
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityEndermite
 *  net.minecraft.entity.monster.EntityEvoker
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityGiantZombie
 *  net.minecraft.entity.monster.EntityGuardian
 *  net.minecraft.entity.monster.EntityHusk
 *  net.minecraft.entity.monster.EntityIllusionIllager
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntityPolarBear
 *  net.minecraft.entity.monster.EntityShulker
 *  net.minecraft.entity.monster.EntitySilverfish
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.monster.EntitySnowman
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityStray
 *  net.minecraft.entity.monster.EntityVex
 *  net.minecraft.entity.monster.EntityVindicator
 *  net.minecraft.entity.monster.EntityWitch
 *  net.minecraft.entity.monster.EntityWitherSkeleton
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.entity.monster.EntityZombieVillager
 *  net.minecraft.entity.passive.EntityBat
 *  net.minecraft.entity.passive.EntityChicken
 *  net.minecraft.entity.passive.EntityCow
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMooshroom
 *  net.minecraft.entity.passive.EntityMule
 *  net.minecraft.entity.passive.EntityOcelot
 *  net.minecraft.entity.passive.EntityParrot
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.entity.passive.EntityRabbit
 *  net.minecraft.entity.passive.EntitySheep
 *  net.minecraft.entity.passive.EntitySkeletonHorse
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.passive.EntityZombieHorse
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityDragonFireball
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.entity.projectile.EntityEvokerFangs
 *  net.minecraft.entity.projectile.EntityLargeFireball
 *  net.minecraft.entity.projectile.EntityLlamaSpit
 *  net.minecraft.entity.projectile.EntityPotion
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.entity.projectile.EntitySmallFireball
 *  net.minecraft.entity.projectile.EntitySnowball
 *  net.minecraft.entity.projectile.EntitySpectralArrow
 *  net.minecraft.entity.projectile.EntityTippedArrow
 *  net.minecraft.entity.projectile.EntityWitherSkull
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
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
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartCommandBlock;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007R!\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/utils/EntityUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "ENTITY_CLASSES", "", "Ljava/lang/Class;", "Lnet/minecraft/entity/Entity;", "getENTITY_CLASSES", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "isSelected", "", "entityTarget", "canAttackCheck", "isFriend", "entity", "DarkMeow"})
public final class EntityUtils
extends MinecraftInstance {
    @NotNull
    public static final EntityUtils INSTANCE = new EntityUtils();
    @NotNull
    private static final Class<? extends Entity>[] ENTITY_CLASSES;

    private EntityUtils() {
    }

    @NotNull
    public final Class<? extends Entity>[] getENTITY_CLASSES() {
        return ENTITY_CLASSES;
    }

    @JvmStatic
    public static final boolean isSelected(@Nullable Entity entityTarget, boolean canAttackCheck) {
        EntityLivingBase entityLivingBase = entityTarget instanceof EntityLivingBase ? (EntityLivingBase)entityTarget : null;
        if (entityLivingBase == null) {
            return false;
        }
        return TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), entityLivingBase, canAttackCheck, false, 4, null);
    }

    public final boolean isFriend(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return entity instanceof EntityPlayer && DarkMeow.INSTANCE.getFileManager().getFriendsConfig().isFriend(ColorUtils.stripColor(((EntityPlayer)entity).func_70005_c_()));
    }

    static {
        Class[] classArray = new Class[]{EntityItem.class, EntityXPOrb.class, EntityAreaEffectCloud.class, EntityElderGuardian.class, EntityWitherSkeleton.class, EntityStray.class, EntityEgg.class, EntityLeashKnot.class, EntityPainting.class, EntityTippedArrow.class, EntitySnowball.class, EntityLargeFireball.class, EntitySmallFireball.class, EntityEnderPearl.class, EntityEnderEye.class, EntityPotion.class, EntityExpBottle.class, EntityItemFrame.class, EntityWitherSkull.class, EntityTNTPrimed.class, EntityFallingBlock.class, EntityFireworkRocket.class, EntityHusk.class, EntitySpectralArrow.class, EntityShulkerBullet.class, EntityDragonFireball.class, EntityZombieVillager.class, EntitySkeletonHorse.class, EntityZombieHorse.class, EntityArmorStand.class, EntityDonkey.class, EntityMule.class, EntityEvokerFangs.class, EntityEvoker.class, EntityVex.class, EntityVindicator.class, EntityIllusionIllager.class, EntityMinecartCommandBlock.class, EntityBoat.class, EntityMinecartEmpty.class, EntityMinecartChest.class, EntityMinecartFurnace.class, EntityMinecartTNT.class, EntityMinecartHopper.class, EntityMinecartMobSpawner.class, EntityCreeper.class, EntitySkeleton.class, EntitySpider.class, EntityGiantZombie.class, EntityZombie.class, EntitySlime.class, EntityGhast.class, EntityPigZombie.class, EntityEnderman.class, EntityCaveSpider.class, EntitySilverfish.class, EntityBlaze.class, EntityMagmaCube.class, EntityDragon.class, EntityWither.class, EntityBat.class, EntityWitch.class, EntityEndermite.class, EntityGuardian.class, EntityShulker.class, EntityPig.class, EntitySheep.class, EntityCow.class, EntityChicken.class, EntitySquid.class, EntityWolf.class, EntityMooshroom.class, EntitySnowman.class, EntityOcelot.class, EntityIronGolem.class, EntityHorse.class, EntityRabbit.class, EntityPolarBear.class, EntityLlama.class, EntityLlamaSpit.class, EntityParrot.class, EntityVillager.class, EntityEnderCrystal.class};
        ENTITY_CLASSES = classArray;
    }
}


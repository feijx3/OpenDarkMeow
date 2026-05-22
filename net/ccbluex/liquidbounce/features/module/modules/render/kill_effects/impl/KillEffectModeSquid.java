/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.render.kill_effects.KillEffectMode;
import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.ccbluex.liquidbounce.utils.math.RandomUtils;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/impl/KillEffectModeSquid;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/KillEffectMode;", "<init>", "()V", "livingTicksValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "yTickUpValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "render", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "EntitySquidEffect", "DarkMeow"})
public final class KillEffectModeSquid
extends KillEffectMode {
    @JvmField
    @NotNull
    public final IntegerValue livingTicksValue = new IntegerValue("LivingTicks", 30, new IntRange(10, 60));
    @JvmField
    @NotNull
    public final FloatValue yTickUpValue = new FloatValue("YTickUp", 0.2f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 1.0f));

    public KillEffectModeSquid() {
        super("Squid");
    }

    @Override
    public void render(@NotNull EntityPlayerSP player, @NotNull WorldClient world, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(world, "world");
        Intrinsics.checkNotNullParameter(entity, "entity");
        new EntitySquidEffect(world, ((Number)this.livingTicksValue.get()).intValue(), ((Number)this.yTickUpValue.get()).floatValue(), entity);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/kill_effects/impl/KillEffectModeSquid$EntitySquidEffect;", "Lnet/minecraft/entity/passive/EntitySquid;", "Lnet/ccbluex/liquidbounce/handler/combat/IFakeEntity;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "livingTicks", "", "yTickUp", "", "target", "Lnet/minecraft/entity/EntityLivingBase;", "<init>", "(Lnet/minecraft/client/multiplayer/WorldClient;IFLnet/minecraft/entity/EntityLivingBase;)V", "removeTick", "onUpdate", "", "getCollisionBoundingBox", "Lnet/minecraft/util/math/AxisAlignedBB;", "DarkMeow"})
    public static final class EntitySquidEffect
    extends EntitySquid
    implements IFakeEntity {
        private final float yTickUp;
        @JvmField
        public int removeTick;

        public EntitySquidEffect(@NotNull WorldClient world, int livingTicks, float yTickUp, @NotNull EntityLivingBase target) {
            Intrinsics.checkNotNullParameter(world, "world");
            Intrinsics.checkNotNullParameter(target, "target");
            super((World)world);
            this.yTickUp = yTickUp;
            this.removeTick = livingTicks;
            this.field_70145_X = true;
            world.func_73027_a(RandomUtils.INSTANCE.random(-10000, -9000), (Entity)this);
            this.func_82149_j((Entity)target);
        }

        public /* synthetic */ EntitySquidEffect(WorldClient worldClient, int n2, float f2, EntityLivingBase entityLivingBase, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 2) != 0) {
                n2 = 30;
            }
            if ((n3 & 4) != 0) {
                f2 = 0.2f;
            }
            this(worldClient, n2, f2, entityLivingBase);
        }

        public void func_70071_h_() {
            this.field_70163_u += (double)this.yTickUp;
            int n2 = this.removeTick;
            this.removeTick = n2 + -1;
            if (this.removeTick < 0) {
                this.field_70170_p.func_72900_e((Entity)this);
            }
        }

        @Nullable
        public AxisAlignedBB func_70046_E() {
            return null;
        }
    }
}


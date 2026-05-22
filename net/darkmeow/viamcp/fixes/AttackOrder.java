/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.viamcp.fixes;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/darkmeow/viamcp/fixes/AttackOrder;", "", "<init>", "()V", "mc", "Lnet/minecraft/client/Minecraft;", "isLegacyAttackMode", "", "sendConditionalSwing", "", "ray", "Lnet/minecraft/util/math/RayTraceResult;", "enumHand", "Lnet/minecraft/util/EnumHand;", "sendFixedAttack", "entityIn", "Lnet/minecraft/entity/player/EntityPlayer;", "target", "Lnet/minecraft/entity/Entity;", "DarkMeow"})
public final class AttackOrder {
    @NotNull
    public static final AttackOrder INSTANCE = new AttackOrder();
    @NotNull
    private static final Minecraft mc;

    private AttackOrder() {
    }

    private final boolean isLegacyAttackMode() {
        return ViaLoadingBase.getInstance().getTargetVersion().olderThanOrEqualTo(ProtocolVersion.v1_8);
    }

    @JvmStatic
    public static final void sendConditionalSwing(@Nullable RayTraceResult ray, @NotNull EnumHand enumHand) {
        Intrinsics.checkNotNullParameter(enumHand, "enumHand");
        RayTraceResult rayTraceResult = ray;
        if ((rayTraceResult != null ? rayTraceResult.field_72313_a : null) != RayTraceResult.Type.ENTITY) {
            AttackOrder.mc.field_71439_g.func_184609_a(enumHand);
        }
    }

    @JvmStatic
    public static final void sendFixedAttack(@NotNull EntityPlayer entityIn, @NotNull Entity target, @NotNull EnumHand enumHand) {
        Intrinsics.checkNotNullParameter(entityIn, "entityIn");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(enumHand, "enumHand");
        boolean bl2 = INSTANCE.isLegacyAttackMode();
        if (bl2) {
            AttackOrder.mc.field_71439_g.func_184609_a(enumHand);
            AttackOrder.mc.field_71442_b.func_78764_a(entityIn, target);
        } else if (!bl2) {
            AttackOrder.mc.field_71442_b.func_78764_a(entityIn, target);
            AttackOrder.mc.field_71439_g.func_184609_a(enumHand);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        Minecraft minecraft = Minecraft.func_71410_x();
        Intrinsics.checkNotNullExpressionValue(minecraft, "getMinecraft(...)");
        mc = minecraft;
    }
}


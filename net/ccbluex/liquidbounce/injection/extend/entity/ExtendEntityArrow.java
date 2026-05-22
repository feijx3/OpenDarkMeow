/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.entity.AccessorEntityArrow;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR(\u0010\u0010\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/entity/ExtendEntityArrow;", "", "<init>", "()V", "value", "", "ticksInGround", "Lnet/minecraft/entity/Entity;", "getTicksInGround", "(Lnet/minecraft/entity/Entity;)I", "setTicksInGround", "(Lnet/minecraft/entity/Entity;I)V", "ticksInAir", "getTicksInAir", "setTicksInAir", "", "damage", "getDamage", "(Lnet/minecraft/entity/Entity;)D", "setDamage", "(Lnet/minecraft/entity/Entity;D)V", "knockBackStrength", "getKnockBackStrength", "setKnockBackStrength", "DarkMeow"})
public final class ExtendEntityArrow {
    @NotNull
    public static final ExtendEntityArrow INSTANCE = new ExtendEntityArrow();

    private ExtendEntityArrow() {
    }

    public final int getTicksInGround(@NotNull Entity $this$ticksInGround) {
        Intrinsics.checkNotNullParameter($this$ticksInGround, "<this>");
        return ((AccessorEntityArrow)$this$ticksInGround).getTicksInGround();
    }

    public final void setTicksInGround(@NotNull Entity $this$ticksInGround, int value) {
        Intrinsics.checkNotNullParameter($this$ticksInGround, "<this>");
        ((AccessorEntityArrow)$this$ticksInGround).setTicksInGround(value);
    }

    public final int getTicksInAir(@NotNull Entity $this$ticksInAir) {
        Intrinsics.checkNotNullParameter($this$ticksInAir, "<this>");
        return ((AccessorEntityArrow)$this$ticksInAir).getTicksInAir();
    }

    public final void setTicksInAir(@NotNull Entity $this$ticksInAir, int value) {
        Intrinsics.checkNotNullParameter($this$ticksInAir, "<this>");
        ((AccessorEntityArrow)$this$ticksInAir).setTicksInAir(value);
    }

    public final double getDamage(@NotNull Entity $this$damage) {
        Intrinsics.checkNotNullParameter($this$damage, "<this>");
        return ((AccessorEntityArrow)$this$damage).func_70242_d();
    }

    public final void setDamage(@NotNull Entity $this$damage, double value) {
        Intrinsics.checkNotNullParameter($this$damage, "<this>");
        ((AccessorEntityArrow)$this$damage).func_70239_b(value);
    }

    public final int getKnockBackStrength(@NotNull Entity $this$knockBackStrength) {
        Intrinsics.checkNotNullParameter($this$knockBackStrength, "<this>");
        return ((AccessorEntityArrow)$this$knockBackStrength).getKnockbackStrength();
    }

    public final void setKnockBackStrength(@NotNull Entity $this$knockBackStrength, int value) {
        Intrinsics.checkNotNullParameter($this$knockBackStrength, "<this>");
        ((AccessorEntityArrow)$this$knockBackStrength).func_70240_a(value);
    }
}


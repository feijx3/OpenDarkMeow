/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.targets;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.combat.velocitys.grim.VelocityModeGrimVertical;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/targets/VelocityModeGrimVerticalTargetMode;", "", "name", "", "priority", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getPriority", "()I", "linkedStateValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getLinkedStateValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "setLinkedStateValue", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/combat/velocitys/grim/VelocityModeGrimVertical;)V", "findTarget", "Lnet/minecraft/entity/Entity;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "DarkMeow"})
public abstract class VelocityModeGrimVerticalTargetMode {
    @NotNull
    private final String name;
    private final int priority;
    public BoolValue linkedStateValue;
    public VelocityModeGrimVertical instance;

    public VelocityModeGrimVerticalTargetMode(@NotNull String name, int priority) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.priority = priority;
    }

    public /* synthetic */ VelocityModeGrimVerticalTargetMode(String string, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        this(string, n2);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final BoolValue getLinkedStateValue() {
        BoolValue boolValue = this.linkedStateValue;
        if (boolValue != null) {
            return boolValue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkedStateValue");
        return null;
    }

    public final void setLinkedStateValue(@NotNull BoolValue boolValue) {
        Intrinsics.checkNotNullParameter(boolValue, "<set-?>");
        this.linkedStateValue = boolValue;
    }

    @NotNull
    public final VelocityModeGrimVertical getInstance() {
        VelocityModeGrimVertical velocityModeGrimVertical = this.instance;
        if (velocityModeGrimVertical != null) {
            return velocityModeGrimVertical;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull VelocityModeGrimVertical velocityModeGrimVertical) {
        Intrinsics.checkNotNullParameter(velocityModeGrimVertical, "<set-?>");
        this.instance = velocityModeGrimVertical;
    }

    @Nullable
    public abstract Entity findTarget(@NotNull EntityPlayerSP var1);

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }
}


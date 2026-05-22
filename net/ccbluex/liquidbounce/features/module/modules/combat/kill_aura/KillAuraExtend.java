/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0014\u0010!\u001a\u00020\u0006*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u00020\u001f*\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraExtend;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "name", "", "defaultState", "", "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getDefaultState", "()Z", "linkedStatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getLinkedStatValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "setLinkedStatValue", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onEnable", "", "onDisable", "onAttackPre", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "onAttackPost", "handleEvents", "DarkMeow"})
public abstract class KillAuraExtend
extends MinecraftInstance
implements Listenable {
    @NotNull
    private final String name;
    private final boolean defaultState;
    public BoolValue linkedStatValue;
    public KillAura instance;

    public KillAuraExtend(@NotNull String name, boolean defaultState) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultState = defaultState;
    }

    public /* synthetic */ KillAuraExtend(String string, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        this(string, bl2);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getDefaultState() {
        return this.defaultState;
    }

    @NotNull
    public final BoolValue getLinkedStatValue() {
        BoolValue boolValue = this.linkedStatValue;
        if (boolValue != null) {
            return boolValue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkedStatValue");
        return null;
    }

    public final void setLinkedStatValue(@NotNull BoolValue boolValue) {
        Intrinsics.checkNotNullParameter(boolValue, "<set-?>");
        this.linkedStatValue = boolValue;
    }

    @NotNull
    public final KillAura getInstance() {
        KillAura killAura = this.instance;
        if (killAura != null) {
            return killAura;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull KillAura killAura) {
        Intrinsics.checkNotNullParameter(killAura, "<set-?>");
        this.instance = killAura;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public boolean onAttackPre(@NotNull SafeListenerBase $this$onAttackPre, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter($this$onAttackPre, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        return true;
    }

    public void onAttackPost(@NotNull SafeListenerBase $this$onAttackPost, @NotNull EntityLivingBase entity) {
        Intrinsics.checkNotNullParameter($this$onAttackPost, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    @Override
    public boolean handleEvents() {
        return this.getInstance().getState() && (Boolean)this.getLinkedStatValue().get() != false;
    }
}


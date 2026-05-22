/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.features.module.modules.combat.AutoBlock;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockCheck;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "modeName", "", "isForce", "", "<init>", "(Ljava/lang/String;Z)V", "getModeName", "()Ljava/lang/String;", "()Z", "linkedStatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getLinkedStatValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "setLinkedStatValue", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "valuePrefix", "getValuePrefix", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBlock;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBlock;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBlock;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "canBlock", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "handleEvents", "DarkMeow"})
public abstract class AutoBlockCheck
extends MinecraftInstance
implements Listenable {
    @NotNull
    private final String modeName;
    private final boolean isForce;
    public BoolValue linkedStatValue;
    @NotNull
    private final String valuePrefix;
    public AutoBlock instance;

    public AutoBlockCheck(@NotNull String modeName, boolean isForce) {
        Intrinsics.checkNotNullParameter(modeName, "modeName");
        this.modeName = modeName;
        this.isForce = isForce;
        this.valuePrefix = this.modeName + '-';
    }

    public /* synthetic */ AutoBlockCheck(String string, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        this(string, bl2);
    }

    @NotNull
    public final String getModeName() {
        return this.modeName;
    }

    public final boolean isForce() {
        return this.isForce;
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
    protected final String getValuePrefix() {
        return this.valuePrefix;
    }

    @NotNull
    public final AutoBlock getInstance() {
        AutoBlock autoBlock = this.instance;
        if (autoBlock != null) {
            return autoBlock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull AutoBlock autoBlock) {
        Intrinsics.checkNotNullParameter(autoBlock, "<set-?>");
        this.instance = autoBlock;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public boolean canBlock(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return false;
    }

    @Override
    public boolean handleEvents() {
        return (Boolean)this.getLinkedStatValue().get() != false && this.getInstance().getState();
    }
}


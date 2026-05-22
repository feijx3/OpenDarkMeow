/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.StuckModuleSyncMovement;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckSyncMovementModule;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "modeName", "", "<init>", "(Ljava/lang/String;)V", "getModeName", "()Ljava/lang/String;", "linkedStatValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getLinkedStatValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "setLinkedStatValue", "(Lnet/ccbluex/liquidbounce/value/impl/ListValue;)V", "valuePrefix", "getValuePrefix", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onEnable", "", "onDisable", "handleEvents", "", "DarkMeow"})
public abstract class StuckSyncMovementModule
extends MinecraftInstance
implements Listenable {
    @NotNull
    private final String modeName;
    public ListValue linkedStatValue;
    @NotNull
    private final String valuePrefix;
    public StuckModuleSyncMovement instance;

    public StuckSyncMovementModule(@NotNull String modeName) {
        Intrinsics.checkNotNullParameter(modeName, "modeName");
        this.modeName = modeName;
        this.valuePrefix = this.modeName + '-';
    }

    @NotNull
    public final String getModeName() {
        return this.modeName;
    }

    @NotNull
    public final ListValue getLinkedStatValue() {
        ListValue listValue = this.linkedStatValue;
        if (listValue != null) {
            return listValue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkedStatValue");
        return null;
    }

    public final void setLinkedStatValue(@NotNull ListValue listValue) {
        Intrinsics.checkNotNullParameter(listValue, "<set-?>");
        this.linkedStatValue = listValue;
    }

    @NotNull
    protected final String getValuePrefix() {
        return this.valuePrefix;
    }

    @NotNull
    public final StuckModuleSyncMovement getInstance() {
        StuckModuleSyncMovement stuckModuleSyncMovement = this.instance;
        if (stuckModuleSyncMovement != null) {
            return stuckModuleSyncMovement;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull StuckModuleSyncMovement stuckModuleSyncMovement) {
        Intrinsics.checkNotNullParameter(stuckModuleSyncMovement, "<set-?>");
        this.instance = stuckModuleSyncMovement;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    @Override
    public boolean handleEvents() {
        return this.getInstance().handleEvents();
    }
}


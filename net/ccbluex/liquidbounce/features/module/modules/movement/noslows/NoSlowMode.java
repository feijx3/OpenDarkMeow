/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.noslows;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.event.events.player.move.SlowDownEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.NoSlow;
import net.ccbluex.liquidbounce.features.module.modules.movement.noslows.NoSlowSubMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010 \u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0002\u0010\"J\u000f\u0010#\u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0002\u0010\"J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020%H\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020(H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006,"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowMode;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "modeCategory", "", "<init>", "(Ljava/lang/String;)V", "getModeCategory", "()Ljava/lang/String;", "subModes", "Ljava/util/LinkedHashMap;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowSubMode;", "Lkotlin/collections/LinkedHashMap;", "getSubModes", "()Ljava/util/LinkedHashMap;", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;)V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "setModeValue", "(Lnet/ccbluex/liquidbounce/value/impl/ListValue;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onEnable", "", "()Lkotlin/Unit;", "onDisable", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent;", "event", "isApplyNoSlow", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "handleEvents", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoSlowMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoSlowMode.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/noslows/NoSlowMode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public abstract class NoSlowMode
extends MinecraftInstance
implements Listenable {
    @NotNull
    private final String modeCategory;
    @NotNull
    private final LinkedHashMap<String, NoSlowSubMode> subModes;
    public NoSlow instance;
    public ListValue modeValue;

    public NoSlowMode(@NotNull String modeCategory) {
        Intrinsics.checkNotNullParameter(modeCategory, "modeCategory");
        this.modeCategory = modeCategory;
        this.subModes = new LinkedHashMap();
    }

    @NotNull
    public final String getModeCategory() {
        return this.modeCategory;
    }

    @NotNull
    public final LinkedHashMap<String, NoSlowSubMode> getSubModes() {
        return this.subModes;
    }

    @NotNull
    public final NoSlow getInstance() {
        NoSlow noSlow = this.instance;
        if (noSlow != null) {
            return noSlow;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull NoSlow noSlow) {
        Intrinsics.checkNotNullParameter(noSlow, "<set-?>");
        this.instance = noSlow;
    }

    @NotNull
    public final ListValue getModeValue() {
        ListValue listValue = this.modeValue;
        if (listValue != null) {
            return listValue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("modeValue");
        return null;
    }

    public final void setModeValue(@NotNull ListValue listValue) {
        Intrinsics.checkNotNullParameter(listValue, "<set-?>");
        this.modeValue = listValue;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    @Nullable
    public Unit onEnable() {
        Unit unit;
        NoSlowSubMode noSlowSubMode = this.subModes.get(this.getModeValue().get());
        if (noSlowSubMode != null) {
            noSlowSubMode.onEnable();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    @Nullable
    public Unit onDisable() {
        Unit unit;
        NoSlowSubMode noSlowSubMode = this.subModes.get(this.getModeValue().get());
        if (noSlowSubMode != null) {
            noSlowSubMode.onDisable();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    @EventTarget
    @Nullable
    public final SlowDownEvent onSlowDown(@NotNull SlowDownEvent event) {
        SlowDownEvent slowDownEvent;
        SlowDownEvent slowDownEvent2;
        SlowDownEvent slowDownEvent3;
        Intrinsics.checkNotNullParameter(event, "event");
        SlowDownEvent it = slowDownEvent3 = event;
        boolean bl2 = false;
        SlowDownEvent slowDownEvent4 = slowDownEvent2 = this.isApplyNoSlow(event.getPlayer()) ? slowDownEvent3 : null;
        if (slowDownEvent2 != null) {
            it = slowDownEvent3 = slowDownEvent2;
            boolean bl3 = false;
            NoSlowSubMode noSlowSubMode = this.subModes.get(this.getModeValue().get());
            if (noSlowSubMode != null) {
                noSlowSubMode.onSlowDown(it);
            }
            slowDownEvent = slowDownEvent3;
        } else {
            slowDownEvent = null;
        }
        return slowDownEvent;
    }

    public abstract boolean isApplyNoSlow(@NotNull EntityPlayerSP var1);

    @Override
    public boolean handleEvents() {
        return this.getInstance().getState();
    }
}


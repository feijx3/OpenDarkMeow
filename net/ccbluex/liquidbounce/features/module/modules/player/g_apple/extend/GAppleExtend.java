/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.GApple;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPostEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPreEvent;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\f\u0010 \u001a\u00020\u0005*\u00020!H\u0016J\f\u0010\"\u001a\u00020\u0005*\u00020!H\u0016J\u0014\u0010#\u001a\u00020\u001e*\u00020!2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020\u001e*\u00020!2\u0006\u0010$\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "name", "", "defaultState", "", "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getDefaultState", "()Z", "linkedStatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getLinkedStatValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "setLinkedStatValue", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/GApple;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onEnable", "", "onDisable", "preExecute", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "preEat", "doEatPre", "event", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPreEvent;", "doEatPost", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPostEvent;", "handleEvents", "DarkMeow"})
public abstract class GAppleExtend
implements ListenableOwner {
    @NotNull
    private final String name;
    private final boolean defaultState;
    public BoolValue linkedStatValue;
    public GApple instance;

    public GAppleExtend(@NotNull String name, boolean defaultState) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultState = defaultState;
    }

    public /* synthetic */ GAppleExtend(String string, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
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
    public final GApple getInstance() {
        GApple gApple = this.instance;
        if (gApple != null) {
            return gApple;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull GApple gApple) {
        Intrinsics.checkNotNullParameter(gApple, "<set-?>");
        this.instance = gApple;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public boolean preExecute(@NotNull SafeListenerBase $this$preExecute) {
        Intrinsics.checkNotNullParameter($this$preExecute, "<this>");
        return true;
    }

    public boolean preEat(@NotNull SafeListenerBase $this$preEat) {
        Intrinsics.checkNotNullParameter($this$preEat, "<this>");
        return true;
    }

    public void doEatPre(@NotNull SafeListenerBase $this$doEatPre, @NotNull GAppleDoEatPreEvent event) {
        Intrinsics.checkNotNullParameter($this$doEatPre, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void doEatPost(@NotNull SafeListenerBase $this$doEatPost, @NotNull GAppleDoEatPostEvent event) {
        Intrinsics.checkNotNullParameter($this$doEatPost, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override
    public boolean handleEvents() {
        return this.getInstance().handleEvents() && (Boolean)this.getLinkedStatValue().get() != false;
    }
}


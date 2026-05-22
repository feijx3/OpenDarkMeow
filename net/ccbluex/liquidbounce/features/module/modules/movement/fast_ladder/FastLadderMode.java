/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.fast_ladder;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.movement.FastLadder;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\f\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/fast_ladder/FastLadderMode;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/FastLadder;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/movement/FastLadder;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/movement/FastLadder;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onEnable", "", "onDisable", "handleFastClimb", "Lnet/minecraft/client/entity/EntityPlayerSP;", "handleFastFall", "", "handleEvents", "DarkMeow"})
public abstract class FastLadderMode
implements ListenableOwner {
    @NotNull
    private final String name;
    public FastLadder instance;

    public FastLadderMode(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final FastLadder getInstance() {
        FastLadder fastLadder = this.instance;
        if (fastLadder != null) {
            return fastLadder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull FastLadder fastLadder) {
        Intrinsics.checkNotNullParameter(fastLadder, "<set-?>");
        this.instance = fastLadder;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void handleFastClimb(@NotNull EntityPlayerSP $this$handleFastClimb) {
        Intrinsics.checkNotNullParameter($this$handleFastClimb, "<this>");
    }

    public boolean handleFastFall(@NotNull EntityPlayerSP $this$handleFastFall) {
        Intrinsics.checkNotNullParameter($this$handleFastFall, "<this>");
        return false;
    }

    @Override
    public boolean handleEvents() {
        return this.getInstance().handleEvents() && Intrinsics.areEqual(this.getInstance().getModeValue().get(), this.name);
    }
}


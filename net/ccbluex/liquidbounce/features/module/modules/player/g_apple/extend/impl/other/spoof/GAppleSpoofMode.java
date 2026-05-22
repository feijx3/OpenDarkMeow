/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.GAppleExtendSpoofCount;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0014\u0010\u001a\u001a\u00020\u0019*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/GAppleSpoofMode;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendSpoofCount;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendSpoofCount;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendSpoofCount;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "shouldActive", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "slot", "", "pre", "", "post", "handleEvents", "DarkMeow"})
public abstract class GAppleSpoofMode
implements ListenableOwner {
    @NotNull
    private final String name;
    public GAppleExtendSpoofCount instance;

    public GAppleSpoofMode(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final GAppleExtendSpoofCount getInstance() {
        GAppleExtendSpoofCount gAppleExtendSpoofCount = this.instance;
        if (gAppleExtendSpoofCount != null) {
            return gAppleExtendSpoofCount;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull GAppleExtendSpoofCount gAppleExtendSpoofCount) {
        Intrinsics.checkNotNullParameter(gAppleExtendSpoofCount, "<set-?>");
        this.instance = gAppleExtendSpoofCount;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public boolean shouldActive(@NotNull SafeListenerBase $this$shouldActive, int slot) {
        Intrinsics.checkNotNullParameter($this$shouldActive, "<this>");
        return true;
    }

    public abstract void pre(@NotNull SafeListenerBase var1, int var2);

    public void post(@NotNull SafeListenerBase $this$post, int slot) {
        Intrinsics.checkNotNullParameter($this$post, "<this>");
    }

    @Override
    public boolean handleEvents() {
        return this.getInstance().handleEvents() && Intrinsics.areEqual(this.getInstance().modeValue.get(), this.name);
    }
}


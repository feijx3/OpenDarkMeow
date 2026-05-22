/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.injection.extend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.access.AccessorKeyBinding;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0007R(\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u00020\f*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/injection/extend/ExtendKeyBinding;", "", "<init>", "()V", "value", "", "pressed", "Lnet/minecraft/client/settings/KeyBinding;", "getPressed", "(Lnet/minecraft/client/settings/KeyBinding;)Z", "setPressed", "(Lnet/minecraft/client/settings/KeyBinding;Z)V", "", "pressTime", "getPressTime", "(Lnet/minecraft/client/settings/KeyBinding;)I", "setPressTime", "(Lnet/minecraft/client/settings/KeyBinding;I)V", "unPressKey", "", "DarkMeow"})
public final class ExtendKeyBinding {
    @NotNull
    public static final ExtendKeyBinding INSTANCE = new ExtendKeyBinding();

    private ExtendKeyBinding() {
    }

    public final boolean getPressed(@NotNull KeyBinding $this$pressed) {
        Intrinsics.checkNotNullParameter($this$pressed, "<this>");
        return ((AccessorKeyBinding)$this$pressed).getPressed();
    }

    public final void setPressed(@NotNull KeyBinding $this$pressed, boolean value) {
        Intrinsics.checkNotNullParameter($this$pressed, "<this>");
        ((AccessorKeyBinding)$this$pressed).setPressed(value);
    }

    public final int getPressTime(@NotNull KeyBinding $this$pressTime) {
        Intrinsics.checkNotNullParameter($this$pressTime, "<this>");
        return ((AccessorKeyBinding)$this$pressTime).getPressTime();
    }

    public final void setPressTime(@NotNull KeyBinding $this$pressTime, int value) {
        Intrinsics.checkNotNullParameter($this$pressTime, "<this>");
        ((AccessorKeyBinding)$this$pressTime).setPressTime(value);
    }

    public final void unPressKey(@NotNull KeyBinding $this$unPressKey) {
        Intrinsics.checkNotNullParameter($this$unPressKey, "<this>");
        ((AccessorKeyBinding)$this$unPressKey).invokeUnpressKey();
    }
}


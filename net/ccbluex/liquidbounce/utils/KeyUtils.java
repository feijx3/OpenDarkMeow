/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rR\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/utils/KeyUtils;", "", "<init>", "()V", "isKeyDownSystem", "", "Lnet/minecraft/client/settings/KeyBinding;", "(Lnet/minecraft/client/settings/KeyBinding;)Z", "isSystemKeyDown", "keyBinding", "keyName", "", "keyCode", "", "DarkMeow"})
public final class KeyUtils {
    @NotNull
    public static final KeyUtils INSTANCE = new KeyUtils();

    private KeyUtils() {
    }

    public final boolean isKeyDownSystem(@NotNull KeyBinding $this$isKeyDownSystem) {
        Intrinsics.checkNotNullParameter($this$isKeyDownSystem, "<this>");
        return this.isSystemKeyDown($this$isKeyDownSystem);
    }

    public final boolean isSystemKeyDown(@NotNull KeyBinding keyBinding) {
        Intrinsics.checkNotNullParameter(keyBinding, "keyBinding");
        return this.isSystemKeyDown(keyBinding.func_151463_i());
    }

    public final boolean isSystemKeyDown(@NotNull String keyName) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        String string = keyName;
        return Intrinsics.areEqual(string, "NONE") || Intrinsics.areEqual(string, "") ? false : this.isSystemKeyDown(Keyboard.getKeyIndex((String)keyName));
    }

    public final boolean isSystemKeyDown(int keyCode) {
        int n2;
        try {
            n2 = keyCode;
            n2 = ((-100 <= n2 ? n2 < 0 : false) ? Mouse.isButtonDown((int)(keyCode + 100)) : Keyboard.isKeyDown((int)keyCode)) ? 1 : 0;
        }
        catch (Throwable throwable) {
            n2 = 0;
        }
        return n2 != 0;
    }
}


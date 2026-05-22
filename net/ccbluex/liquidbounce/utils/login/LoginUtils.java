/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.util.Session
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.login;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.SessionEvent;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.login.UserUtils;
import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
import net.minecraft.util.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0006\u0010\b\u001a\u00020\u0005\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/utils/login/LoginUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "loginCracked", "", "username", "", "randomCracked", "DarkMeow"})
public final class LoginUtils
extends MinecraftInstance {
    @NotNull
    public static final LoginUtils INSTANCE = new LoginUtils();

    private LoginUtils() {
    }

    @JvmStatic
    public static final void loginCracked(@Nullable String username) {
        String string = username;
        Intrinsics.checkNotNull(string);
        MinecraftInstance.mc.setSession(new Session(string, UserUtils.INSTANCE.getUUID(username), "-", "legacy"));
        EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), new SessionEvent(), null, 2, null);
    }

    public final void randomCracked() {
        LoginUtils.loginCracked(RandomUtils.randomString(6));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.exclusive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/exclusive/ExtendModuleExclusive;", "", "<init>", "()V", "registerExclusive", "", "Lnet/ccbluex/liquidbounce/features/module/Module;", "group", "", "unregisterExclusive", "DarkMeow"})
public final class ExtendModuleExclusive {
    @NotNull
    public static final ExtendModuleExclusive INSTANCE = new ExtendModuleExclusive();

    private ExtendModuleExclusive() {
    }

    public final boolean registerExclusive(@NotNull Module $this$registerExclusive, @NotNull String group) {
        Intrinsics.checkNotNullParameter($this$registerExclusive, "<this>");
        Intrinsics.checkNotNullParameter(group, "group");
        return DarkMeow.INSTANCE.getModuleManager().exclusiveManager.registerExclusive(group, $this$registerExclusive);
    }

    public final boolean unregisterExclusive(@NotNull Module $this$unregisterExclusive, @NotNull String group) {
        Intrinsics.checkNotNullParameter($this$unregisterExclusive, "<this>");
        Intrinsics.checkNotNullParameter(group, "group");
        return DarkMeow.INSTANCE.getModuleManager().exclusiveManager.unregisterExclusive(group, $this$unregisterExclusive);
    }
}


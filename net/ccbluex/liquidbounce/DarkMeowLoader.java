/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/DarkMeowLoader;", "", "<init>", "()V", "main", "", "args", "", "", "([Ljava/lang/String;)V", "DarkMeow"})
public final class DarkMeowLoader {
    @NotNull
    public static final DarkMeowLoader INSTANCE = new DarkMeowLoader();

    private DarkMeowLoader() {
    }

    @JvmStatic
    public static final void main(@NotNull String[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }
}


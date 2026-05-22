/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFStatic;", "", "<init>", "()V", "prefix", "Lnet/minecraft/util/text/TextComponentString;", "getPrefix", "()Lnet/minecraft/util/text/TextComponentString;", "DarkMeow"})
public final class SFStatic {
    @NotNull
    public static final SFStatic INSTANCE = new SFStatic();
    @NotNull
    private static final TextComponentString prefix = new TextComponentString("\u00a77[\u00a7bSilenceFix-IRC\u00a77] \u00a7f");

    private SFStatic() {
    }

    @NotNull
    public final TextComponentString getPrefix() {
        TextComponentString textComponentString = prefix.func_150259_f();
        Intrinsics.checkNotNullExpressionValue(textComponentString, "createCopy(...)");
        return textComponentString;
    }
}


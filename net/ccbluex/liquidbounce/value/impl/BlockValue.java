/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.impl;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="\u4e0d\u4f1a\u5f04")
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/value/impl/BlockValue;", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "name", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "DarkMeow"})
public final class BlockValue
extends IntegerValue {
    public BlockValue(@NotNull String name, int value) {
        Intrinsics.checkNotNullParameter(name, "name");
        super(name, value, 1, 197);
    }
}


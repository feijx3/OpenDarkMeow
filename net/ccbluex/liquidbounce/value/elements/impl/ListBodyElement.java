/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.elements.impl;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.value.elements.Element;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/ListBodyElement;", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "<init>", "()V", "getList", "", "", "()[Ljava/lang/String;", "getSelected", "onClicked", "", "value", "getExpandWidth", "", "DarkMeow"})
public abstract class ListBodyElement
extends Element {
    @NotNull
    public abstract String[] getList();

    @NotNull
    public abstract String getSelected();

    public abstract void onClicked(@NotNull String var1);

    @Override
    public int getExpandWidth() {
        return 8;
    }
}


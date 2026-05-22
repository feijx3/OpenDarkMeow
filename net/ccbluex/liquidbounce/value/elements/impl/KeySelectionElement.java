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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/KeySelectionElement;", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "<init>", "()V", "getTitle", "", "getSelected", "onClicked", "", "value", "DarkMeow"})
public abstract class KeySelectionElement
extends Element {
    @NotNull
    public abstract String getTitle();

    @NotNull
    public abstract String getSelected();

    public abstract void onClicked(@NotNull String var1);
}


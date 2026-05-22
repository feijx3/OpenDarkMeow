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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/SingleSeekBarElement;", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "<init>", "()V", "getTitle", "", "getLength", "", "getValue", "getOffset", "getIsInt", "", "onClicked", "", "value", "DarkMeow"})
public abstract class SingleSeekBarElement
extends Element {
    @NotNull
    public abstract String getTitle();

    public abstract float getLength();

    public abstract float getValue();

    public abstract float getOffset();

    public abstract boolean getIsInt();

    public abstract void onClicked(float var1);
}


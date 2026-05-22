/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.value.elements.impl;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.value.elements.Element;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/RectElement;", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "<init>", "()V", "getHeight", "", "getExpandWidth", "getNoDisplayInLast", "", "DarkMeow"})
public abstract class RectElement
extends Element {
    public int getHeight() {
        return 4;
    }

    @Override
    public int getExpandWidth() {
        return 0;
    }

    public boolean getNoDisplayInLast() {
        return true;
    }
}


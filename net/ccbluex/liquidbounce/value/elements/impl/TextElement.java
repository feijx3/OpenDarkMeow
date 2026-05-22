/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value.elements.impl;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.value.elements.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/TextElement;", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "<init>", "()V", "editingDisplayStatus", "", "getEditingDisplayStatus", "()I", "setEditingDisplayStatus", "(I)V", "editingString", "", "getEditingString", "()Ljava/lang/String;", "setEditingString", "(Ljava/lang/String;)V", "getTitle", "getValue", "onClicked", "", "value", "DarkMeow"})
public abstract class TextElement
extends Element {
    private int editingDisplayStatus;
    @Nullable
    private String editingString;

    public int getEditingDisplayStatus() {
        return this.editingDisplayStatus;
    }

    public void setEditingDisplayStatus(int n2) {
        this.editingDisplayStatus = n2;
    }

    @Nullable
    public String getEditingString() {
        return this.editingString;
    }

    public void setEditingString(@Nullable String string) {
        this.editingString = string;
    }

    @NotNull
    public abstract String getTitle();

    @NotNull
    public abstract String getValue();

    public abstract void onClicked(@NotNull String var1);
}


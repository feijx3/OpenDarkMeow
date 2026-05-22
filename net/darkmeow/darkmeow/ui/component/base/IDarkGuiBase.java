/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.ui.component.base;

import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import kotlin.Metadata;
import kotlin.Pair;
import net.darkmeow.darkmeow.ui.IDarkGui;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.theme.Theme;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0017\u00c0\u0006\u0001"}, d2={"Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;", "Lnet/darkmeow/darkmeow/ui/IDarkGui;", "components", "Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "getComponents", "()Lit/unimi/dsi/fastutil/objects/ObjectLinkedOpenHashSet;", "addComponent", "", "component", "removeComponent", "getRealPositionOffset", "Lkotlin/Pair;", "", "theme", "Lnet/darkmeow/darkmeow/ui/theme/Theme;", "getTheme", "()Lnet/darkmeow/darkmeow/ui/theme/Theme;", "focus", "getFocus", "()Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "setFocus", "(Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;)V", "DarkMeow"})
public interface IDarkGuiBase
extends IDarkGui {
    @NotNull
    public ObjectLinkedOpenHashSet<AbstractComponent> getComponents();

    public void addComponent(@NotNull AbstractComponent var1);

    public void removeComponent(@NotNull AbstractComponent var1);

    @NotNull
    public Pair<Integer, Integer> getRealPositionOffset();

    @NotNull
    public Theme getTheme();

    @Nullable
    public AbstractComponent getFocus();

    public void setFocus(@Nullable AbstractComponent var1);
}


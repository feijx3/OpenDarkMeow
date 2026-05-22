/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.manager.inventory;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.injection.extend.gui.ExtendGuiContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0013R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2={"Lnet/darkmeow/darkmeow/manager/inventory/ContainerManager;", "", "<init>", "()V", "value", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "screen", "getScreen", "()Lnet/minecraft/client/gui/inventory/GuiContainer;", "setScreen", "(Lnet/minecraft/client/gui/inventory/GuiContainer;)V", "readyWindowItems", "", "getReadyWindowItems", "()Z", "setReadyWindowItems", "(Z)V", "hasOpenContainer", "closeContainer", "", "DarkMeow"})
public final class ContainerManager {
    @Nullable
    private GuiContainer screen;
    private boolean readyWindowItems;

    @Nullable
    public final GuiContainer getScreen() {
        return this.screen;
    }

    public final void setScreen(@Nullable GuiContainer value) {
        this.readyWindowItems = false;
        this.screen = value;
    }

    public final boolean getReadyWindowItems() {
        return this.readyWindowItems;
    }

    public final void setReadyWindowItems(boolean bl2) {
        this.readyWindowItems = bl2;
    }

    public final boolean hasOpenContainer() {
        return this.screen != null;
    }

    public final void closeContainer() {
        block0: {
            GuiContainer guiContainer = this.screen;
            if (guiContainer == null) break block0;
            boolean bl2 = false;
            ExtendGuiContainer.INSTANCE.keyTyped(guiContainer, (char)(bl2 ? 1 : 0), 1);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiSlot
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.viamcp.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2={"Lnet/darkmeow/viamcp/gui/GuiProtocolSelector;", "Lnet/minecraft/client/gui/GuiScreen;", "parent", "<init>", "(Lnet/minecraft/client/gui/GuiScreen;)V", "list", "Lnet/darkmeow/viamcp/gui/GuiProtocolSelector$SlotList;", "getList", "()Lnet/darkmeow/viamcp/gui/GuiProtocolSelector$SlotList;", "setList", "(Lnet/darkmeow/viamcp/gui/GuiProtocolSelector$SlotList;)V", "initGui", "", "actionPerformed", "guiButton", "Lnet/minecraft/client/gui/GuiButton;", "handleMouseInput", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "SlotList", "DarkMeow"})
public final class GuiProtocolSelector
extends GuiScreen {
    @NotNull
    private final GuiScreen parent;
    @Nullable
    private SlotList list;

    public GuiProtocolSelector(@NotNull GuiScreen parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
    }

    @Nullable
    public final SlotList getList() {
        return this.list;
    }

    public final void setList(@Nullable SlotList slotList) {
        this.list = slotList;
    }

    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m - 25, 200, 20, "Back"));
        this.list = new SlotList(this.field_146297_k, this.field_146294_l, this.field_146295_m, 32, this.field_146295_m - 32);
    }

    protected void func_146284_a(@NotNull GuiButton guiButton) throws IOException {
        Intrinsics.checkNotNullParameter(guiButton, "guiButton");
        SlotList slotList = this.list;
        Intrinsics.checkNotNull((Object)slotList);
        slotList.func_148147_a(guiButton);
        if (guiButton.field_146127_k == 1) {
            this.field_146297_k.func_147108_a(this.parent);
        }
    }

    public void func_146274_d() throws IOException {
        SlotList slotList = this.list;
        Intrinsics.checkNotNull((Object)slotList);
        slotList.func_178039_p();
        super.func_146274_d();
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        SlotList slotList = this.list;
        Intrinsics.checkNotNull((Object)slotList);
        slotList.func_148128_a(mouseX, mouseY, partialTicks);
        GlStateManager.func_179094_E();
        GlStateManager.func_179139_a((double)2.0, (double)2.0, (double)2.0);
        String title = ChatFormatting.BOLD + "ProtocolSelector";
        this.func_73731_b(this.field_146289_q, title, (this.field_146294_l - this.field_146289_q.func_78256_a(title) * 2) / 4, 5, -1);
        GlStateManager.func_179121_F();
        super.func_73863_a(mouseX, mouseY, partialTicks);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\b\u0096\u0004\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0005H\u0014J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J@\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0014\u00a8\u0006\u001e"}, d2={"Lnet/darkmeow/viamcp/gui/GuiProtocolSelector$SlotList;", "Lnet/minecraft/client/gui/GuiSlot;", "mc", "Lnet/minecraft/client/Minecraft;", "width", "", "height", "top", "bottom", "<init>", "(Lnet/darkmeow/viamcp/gui/GuiProtocolSelector;Lnet/minecraft/client/Minecraft;IIII)V", "getSize", "elementClicked", "", "i", "b", "", "i1", "i2", "isSelected", "drawBackground", "drawSlot", "slotIndex", "xPos", "yPos", "heightIn", "mouseXIn", "mouseYIn", "partialTicks", "", "DarkMeow"})
    public class SlotList
    extends GuiSlot {
        public SlotList(Minecraft mc, int width, int height, int top, int bottom) {
            super(mc, width, height, top + 30, bottom, 18);
        }

        protected int func_148127_b() {
            return ViaLoadingBase.PROTOCOLS.size();
        }

        protected void func_148144_a(int i2, boolean b2, int i1, int i22) {
            ProtocolVersion protocolVersion = ViaLoadingBase.PROTOCOLS.get(i2);
            Intrinsics.checkNotNullExpressionValue(protocolVersion, "get(...)");
            ProtocolVersion protocolVersion2 = protocolVersion;
            ViaLoadingBase.getInstance().reload(protocolVersion2);
        }

        protected boolean func_148131_a(int i2) {
            return false;
        }

        protected void func_148123_a() {
            GuiProtocolSelector.this.func_146276_q_();
        }

        protected void func_192637_a(int slotIndex, int xPos, int yPos, int heightIn, int mouseXIn, int mouseYIn, float partialTicks) {
            String string;
            FontRenderer fontRenderer = this.field_148161_k.field_71466_p;
            StringBuilder stringBuilder = new StringBuilder();
            if (ViaLoadingBase.PROTOCOLS.indexOf(ViaLoadingBase.getInstance().getTargetVersion()) == slotIndex) {
                string = "" + ChatFormatting.GREEN + ChatFormatting.BOLD;
            } else {
                String string2 = ChatFormatting.GRAY.toString();
                string = string2;
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            }
            GuiProtocolSelector.this.func_73732_a(fontRenderer, stringBuilder.append(string).append(ViaLoadingBase.getProtocols().get(slotIndex).getName()).toString(), this.field_148155_a / 2, yPos + 2, -1);
            GlStateManager.func_179094_E();
            GlStateManager.func_179139_a((double)0.5, (double)0.5, (double)0.5);
            GuiProtocolSelector.this.func_73732_a(this.field_148161_k.field_71466_p, "PVN: " + ViaLoadingBase.PROTOCOLS.get(slotIndex).getVersion(), this.field_148155_a, (yPos + 2) * 2 + 20, -1);
            GlStateManager.func_179121_F();
        }
    }
}


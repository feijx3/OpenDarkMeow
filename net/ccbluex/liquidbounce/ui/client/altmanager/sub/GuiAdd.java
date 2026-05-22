/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 */
package net.ccbluex.liquidbounce.ui.client.altmanager.sub;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import me.liuli.elixir.account.MinecraftAccount;
import me.liuli.elixir.manage.AccountSerializer;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
import net.ccbluex.liquidbounce.utils.extensions.RendererExtensionKt;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0014J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0014J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/altmanager/sub/GuiAdd;", "Lnet/minecraft/client/gui/GuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;", "<init>", "(Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;)V", "username", "Lnet/minecraft/client/gui/GuiTextField;", "status", "", "initGui", "", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "actionPerformed", "button", "Lnet/minecraft/client/gui/GuiButton;", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseButton", "updateScreen", "onGuiClosed", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGuiAdd.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuiAdd.kt\nnet/ccbluex/liquidbounce/ui/client/altmanager/sub/GuiAdd\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1761#2,3:88\n1#3:91\n*S KotlinDebug\n*F\n+ 1 GuiAdd.kt\nnet/ccbluex/liquidbounce/ui/client/altmanager/sub/GuiAdd\n*L\n41#1:88,3\n*E\n"})
public final class GuiAdd
extends GuiScreen {
    @NotNull
    private final GuiAltManager prevGui;
    private GuiTextField username;
    @Nullable
    private String status;

    public GuiAdd(@NotNull GuiAltManager prevGui) {
        Intrinsics.checkNotNullParameter((Object)prevGui, "prevGui");
        this.prevGui = prevGui;
        this.status = "\u00a77Idle...";
    }

    public void func_73866_w_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 72, "Add"));
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, "Back"));
        this.username = new GuiTextField(2, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        GuiTextField guiTextField = this.username;
        if (guiTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            guiTextField = null;
        }
        guiTextField.func_146195_b(true);
        GuiTextField guiTextField2 = this.username;
        if (guiTextField2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            guiTextField2 = null;
        }
        guiTextField2.func_146203_f(Integer.MAX_VALUE);
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        this.func_146278_c(0);
        FontRenderer fontRenderer = this.field_146297_k.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
        RendererExtensionKt.drawCenteredString(fontRenderer, "Add", (float)this.field_146294_l / 2.0f, 34.0f, 0xFFFFFF);
        FontRenderer fontRenderer2 = this.field_146297_k.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer2, "fontRenderer");
        String string = this.status;
        if (string == null) {
            string = "";
        }
        RendererExtensionKt.drawCenteredString(fontRenderer2, string, (float)this.field_146294_l / 2.0f, (float)this.field_146295_m / 4.0f + 60.0f, 0xFFFFFF);
        GuiTextField guiTextField = this.username;
        if (guiTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            guiTextField = null;
        }
        guiTextField.func_146194_f();
        GuiTextField guiTextField2 = this.username;
        if (guiTextField2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            guiTextField2 = null;
        }
        String string2 = guiTextField2.func_146179_b();
        Intrinsics.checkNotNullExpressionValue(string2, "getText(...)");
        if (((CharSequence)string2).length() == 0) {
            GuiTextField guiTextField3 = this.username;
            if (guiTextField3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("username");
                guiTextField3 = null;
            }
            if (!guiTextField3.func_146206_l()) {
                FontRenderer fontRenderer3 = this.field_146297_k.field_71466_p;
                Intrinsics.checkNotNullExpressionValue(fontRenderer3, "fontRenderer");
                RendererExtensionKt.drawCenteredString(fontRenderer3, "\u00a77Username", (float)this.field_146294_l / 2.0f - 55.0f, 66.0f, 0xFFFFFF);
            }
        }
        super.func_73863_a(mouseX, mouseY, partialTicks);
    }

    /*
     * Unable to fully structure code
     */
    protected void func_146284_a(@NotNull GuiButton button) {
        Intrinsics.checkNotNullParameter(button, "button");
        if (!button.field_146124_l) {
            return;
        }
        switch (button.field_146127_k) {
            case 0: {
                this.field_146297_k.func_147108_a((GuiScreen)this.prevGui);
                break;
            }
            case 1: {
                $this$any$iv = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts();
                $i$f$any = false;
                if (!($this$any$iv instanceof Collection) || !((Collection)$this$any$iv).isEmpty()) ** GOTO lbl14
                v0 = false;
                ** GOTO lbl26
lbl14:
                // 2 sources

                for (T element$iv : $this$any$iv) {
                    it = (MinecraftAccount)element$iv;
                    $i$a$-any-GuiAdd$actionPerformed$1 = false;
                    v1 = it.getName();
                    v2 = this.username;
                    if (v2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("username");
                        v2 = null;
                    }
                    if (!Intrinsics.areEqual(v1, v2.func_146179_b())) continue;
                    v0 = true;
                    ** GOTO lbl26
                }
                v0 = false;
lbl26:
                // 3 sources

                if (v0) {
                    this.status = "\u00a7cThe account has already been added.";
                    return;
                }
                v3 = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts();
                v4 = this.username;
                if (v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("username");
                    v4 = null;
                }
                v5 = v4.func_146179_b();
                Intrinsics.checkNotNullExpressionValue(v5, "getText(...)");
                v3.add(AccountSerializer.INSTANCE.accountInstance(v5, ""));
                DarkMeow.INSTANCE.getFileManager().saveConfig(DarkMeow.INSTANCE.getFileManager().getAccountsConfig());
                v6 = this.field_146292_n;
                Intrinsics.checkNotNullExpressionValue(v6, "buttonList");
                $this$any$iv = v6;
                var9_15 = this;
                var3_5 = $this$any$iv;
                for (T var5_9 : var3_5) {
                    it = (GuiButton)var5_9;
                    $i$a$-find-GuiAdd$actionPerformed$2 = false;
                    if (!(it.field_146127_k == 0)) continue;
                    v7 = var5_9;
                    ** GOTO lbl51
                }
                v7 = null;
lbl51:
                // 2 sources

                Intrinsics.checkNotNull(v7);
                var9_15.func_146284_a(v7);
                break;
            }
            case 2: {
                v8 = GuiScreen.func_146277_j();
                Intrinsics.checkNotNullExpressionValue(v8, "getClipboardString(...)");
                var3_6 = new String[]{":"};
                args = StringsKt.split$default((CharSequence)v8, (String[])var3_6, false, 0, 6, null);
                v9 = this.username;
                if (v9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("username");
                    v9 = null;
                }
                v9.func_146180_a((String)args.get(0));
                v10 = this.field_146292_n;
                Intrinsics.checkNotNullExpressionValue(v10, "buttonList");
                var3_6 = v10;
                var9_16 = this;
                var4_8 = var3_6;
                var5_10 = var4_8.iterator();
                while (var5_10.hasNext()) {
                    var6_12 = var5_10.next();
                    it = (GuiButton)var6_12;
                    $i$a$-find-GuiAdd$actionPerformed$3 = false;
                    if (!(it.field_146127_k == 1)) continue;
                    v11 = var6_12;
                    ** GOTO lbl78
                }
                v11 = null;
lbl78:
                // 2 sources

                Intrinsics.checkNotNull(v11);
                var9_16.func_146284_a(v11);
            }
        }
        super.func_146284_a(button);
    }

    /*
     * Unable to fully structure code
     */
    protected void func_73869_a(char typedChar, int keyCode) {
        switch (keyCode) {
            case 1: {
                this.field_146297_k.func_147108_a((GuiScreen)this.prevGui);
                return;
            }
            case 28: {
                v0 = this.field_146292_n;
                Intrinsics.checkNotNullExpressionValue(v0, "buttonList");
                var3_3 = v0;
                var9_4 = this;
                var4_5 = var3_3;
                for (T var6_7 : var4_5) {
                    it = (GuiButton)var6_7;
                    $i$a$-find-GuiAdd$keyTyped$1 = false;
                    if (!(it.field_146127_k == 1)) continue;
                    v1 = var6_7;
                    ** GOTO lbl18
                }
                v1 = null;
lbl18:
                // 2 sources

                Intrinsics.checkNotNull(v1);
                var9_4.func_146284_a(v1);
                return;
            }
        }
        v2 = this.username;
        if (v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            v2 = null;
        }
        if (v2.func_146206_l()) {
            v3 = this.username;
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("username");
                v3 = null;
            }
            v3.func_146201_a(typedChar, keyCode);
        }
        super.func_73869_a(typedChar, keyCode);
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) {
        GuiTextField guiTextField = this.username;
        if (guiTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            guiTextField = null;
        }
        guiTextField.func_146192_a(mouseX, mouseY, mouseButton);
        super.func_73864_a(mouseX, mouseY, mouseButton);
    }

    public void func_73876_c() {
        GuiTextField guiTextField = this.username;
        if (guiTextField == null) {
            Intrinsics.throwUninitializedPropertyAccessException("username");
            guiTextField = null;
        }
        guiTextField.func_146178_a();
        super.func_73876_c();
    }

    public void func_146281_b() {
        Keyboard.enableRepeatEvents((boolean)false);
        super.func_146281_b();
    }
}


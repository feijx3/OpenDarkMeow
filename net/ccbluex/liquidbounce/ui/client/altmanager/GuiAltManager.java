/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiSlot
 *  net.minecraft.util.Session
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.altmanager;

import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.liuli.elixir.account.MinecraftAccount;
import me.liuli.elixir.compat.Session;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.SessionEvent;
import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.altmanager.sub.GuiAdd;
import net.ccbluex.liquidbounce.ui.client.altmanager.sub.GuiDirectLogin;
import net.ccbluex.liquidbounce.ui.client.altmanager.sub.GuiMicrosoftLoginPending;
import net.ccbluex.liquidbounce.utils.extensions.RendererExtensionKt;
import net.ccbluex.liquidbounce.utils.login.LoginUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0014J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;", "Lnet/minecraft/client/gui/GuiScreen;", "prevGui", "<init>", "(Lnet/minecraft/client/gui/GuiScreen;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "altsList", "Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager$GuiList;", "initGui", "", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "actionPerformed", "button", "Lnet/minecraft/client/gui/GuiButton;", "keyTyped", "typedChar", "", "keyCode", "handleMouseInput", "GuiList", "Companion", "DarkMeow"})
public final class GuiAltManager
extends GuiScreen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final GuiScreen prevGui;
    @NotNull
    private String status;
    private GuiList altsList;

    public GuiAltManager(@NotNull GuiScreen prevGui) {
        Intrinsics.checkNotNullParameter(prevGui, "prevGui");
        this.prevGui = prevGui;
        this.status = "\u00a77Idle...";
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.status = string;
    }

    public void func_73866_w_() {
        GuiList guiList;
        this.altsList = new GuiList(this);
        GuiList guiList2 = this.altsList;
        if (guiList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList2 = null;
        }
        guiList2.func_148134_d(7, 8);
        GuiList guiList3 = this.altsList;
        if (guiList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList3 = null;
        }
        guiList3.func_148144_a(-1, false, 0, 0);
        GuiList guiList4 = this.altsList;
        if (guiList4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList4 = null;
        }
        if ((guiList = this.altsList) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList = null;
        }
        guiList4.func_148145_f(-1 * guiList.field_148149_f);
        int j2 = 22;
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l - 80, j2 + 24, 70, 20, "Add"));
        this.field_146292_n.add(new GuiButton(2, this.field_146294_l - 80, j2 + 48, 70, 20, "Remove"));
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l - 80, this.field_146295_m - 65, 70, 20, "Back"));
        this.field_146292_n.add(new GuiButton(3, 5, j2 + 24, 90, 20, "Login"));
        this.field_146292_n.add(new GuiButton(6, 5, j2 + 48, 90, 20, "Direct"));
        this.field_146292_n.add(new GuiButton(11, 5, j2 + 72, 90, 20, "Microsoft"));
        this.field_146292_n.add(new GuiButton(4, 5, j2 + 96, 90, 20, "RandomAlt"));
        this.field_146292_n.add(new GuiButton(89, 5, j2 + 120, 90, 20, "RandomOffline"));
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        this.func_146278_c(0);
        GuiList guiList = this.altsList;
        if (guiList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList = null;
        }
        guiList.func_148128_a(mouseX, mouseY, partialTicks);
        FontRenderer fontRenderer = this.field_146297_k.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
        RendererExtensionKt.drawCenteredString(fontRenderer, "AltManager", this.field_146294_l / 2, 6.0f, 0xFFFFFF);
        FontRenderer fontRenderer2 = this.field_146297_k.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer2, "fontRenderer");
        RendererExtensionKt.drawCenteredString(fontRenderer2, DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().size() + " Alts", this.field_146294_l / 2, 18.0f, 0xFFFFFF);
        FontRenderer fontRenderer3 = this.field_146297_k.field_71466_p;
        Intrinsics.checkNotNullExpressionValue(fontRenderer3, "fontRenderer");
        RendererExtensionKt.drawCenteredString(fontRenderer3, this.status, this.field_146294_l / 2, 32.0f, 0xFFFFFF);
        this.field_146297_k.field_71466_p.func_175063_a("\u00a77User: \u00a7a" + this.field_146297_k.func_110432_I().func_111285_a(), 6.0f, 6.0f, 0xFFFFFF);
        this.field_146297_k.field_71466_p.func_175063_a("\u00a77Type: \u00a7a" + (this.field_146297_k.func_110432_I().func_148254_d().length() >= 32 ? "Premium" : "Cracked"), 6.0f, 15.0f, 0xFFFFFF);
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
                this.field_146297_k.func_147108_a(this.prevGui);
                break;
            }
            case 1: {
                this.field_146297_k.func_147108_a((GuiScreen)new GuiAdd(this));
                break;
            }
            case 2: {
                v0 = this.altsList;
                if (v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    v0 = null;
                }
                if (v0.getSelectedSlot() == -1) ** GOTO lbl-1000
                v1 = this.altsList;
                if (v1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    v1 = null;
                }
                v2 = v1.getSelectedSlot();
                v3 = this.altsList;
                if (v3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    v3 = null;
                }
                if (v2 < v3.func_148127_b()) {
                    v4 = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts();
                    v5 = this.altsList;
                    if (v5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("altsList");
                        v5 = null;
                    }
                    v4.remove(v5.getSelectedSlot());
                    DarkMeow.INSTANCE.getFileManager().saveConfig(DarkMeow.INSTANCE.getFileManager().getAccountsConfig());
                    v6 = "\u00a7aThe account has been removed.";
                } else lbl-1000:
                // 2 sources

                {
                    v6 = "\u00a7cSelect an account.";
                }
                this.status = v6;
                break;
            }
            case 3: {
                v7 = this.altsList;
                if (v7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    v7 = null;
                }
                if (v7.getSelectedSlot() != -1) {
                    v8 = this.altsList;
                    if (v8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("altsList");
                        v8 = null;
                    }
                    v9 = v8.getSelectedSlot();
                    v10 = this.altsList;
                    if (v10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("altsList");
                        v10 = null;
                    }
                    if (v9 < v10.func_148127_b()) {
                        new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, actionPerformed$lambda$0(net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager ), ()V)((GuiAltManager)this)).start();
                        break;
                    }
                }
                this.status = "\u00a7cSelect an account.";
                break;
            }
            case 4: {
                if (DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().size() <= 0) {
                    this.status = "\u00a7cThe list is empty.";
                    return;
                }
                randomInteger = new Random().nextInt(DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().size());
                v11 = this.altsList;
                if (v11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    v11 = null;
                }
                if (randomInteger < v11.func_148127_b()) {
                    v12 = this.altsList;
                    if (v12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("altsList");
                        v12 = null;
                    }
                    v12.setSelectedSlot(randomInteger);
                }
                new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, actionPerformed$lambda$1(int net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager ), ()V)((int)randomInteger, (GuiAltManager)this)).start();
                break;
            }
            case 6: {
                this.field_146297_k.func_147108_a((GuiScreen)new GuiDirectLogin(this));
                break;
            }
            case 89: {
                new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, actionPerformed$lambda$2(), ()V)()).start();
                break;
            }
            case 11: {
                this.field_146297_k.func_147108_a((GuiScreen)new GuiMicrosoftLoginPending(this));
            }
        }
    }

    protected void func_73869_a(char typedChar, int keyCode) {
        switch (keyCode) {
            case 1: {
                DarkMeow.INSTANCE.getFileManager().saveConfig(DarkMeow.INSTANCE.getFileManager().getSpecialConfig());
                this.field_146297_k.func_147108_a(this.prevGui);
                return;
            }
            case 200: {
                GuiList guiList;
                int i2;
                GuiList guiList2 = this.altsList;
                if (guiList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList2 = null;
                }
                if ((i2 = guiList2.getSelectedSlot() - 1) < 0) {
                    i2 = 0;
                }
                if ((guiList = this.altsList) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList = null;
                }
                guiList.func_148144_a(i2, false, 0, 0);
                break;
            }
            case 208: {
                GuiList guiList;
                GuiList guiList3 = this.altsList;
                if (guiList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList3 = null;
                }
                int i3 = guiList3.getSelectedSlot() + 1;
                GuiList guiList4 = this.altsList;
                if (guiList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList4 = null;
                }
                if (i3 >= guiList4.func_148127_b()) {
                    GuiList guiList5 = this.altsList;
                    if (guiList5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("altsList");
                        guiList5 = null;
                    }
                    i3 = guiList5.func_148127_b() - 1;
                }
                if ((guiList = this.altsList) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList = null;
                }
                guiList.func_148144_a(i3, false, 0, 0);
                break;
            }
            case 28: {
                GuiList guiList;
                GuiList guiList6 = this.altsList;
                if (guiList6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList6 = null;
                }
                if ((guiList = this.altsList) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList = null;
                }
                guiList6.func_148144_a(guiList.getSelectedSlot(), true, 0, 0);
                break;
            }
            case 209: {
                GuiList guiList = this.altsList;
                if (guiList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList = null;
                }
                guiList.func_148145_f(this.field_146295_m - 100);
                break;
            }
            case 201: {
                GuiList guiList = this.altsList;
                if (guiList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList = null;
                }
                guiList.func_148145_f(-this.field_146295_m + 100);
                return;
            }
        }
        super.func_73869_a(typedChar, keyCode);
    }

    public void func_146274_d() {
        super.func_146274_d();
        GuiList guiList = this.altsList;
        if (guiList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList = null;
        }
        guiList.func_178039_p();
    }

    private static final void actionPerformed$lambda$0(GuiAltManager this$0) {
        List<MinecraftAccount> list = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts();
        GuiList guiList = this$0.altsList;
        if (guiList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("altsList");
            guiList = null;
        }
        MinecraftAccount minecraftAccount = list.get(guiList.getSelectedSlot());
        this$0.status = "\u00a7aLogging in...";
        this$0.status = Companion.login(minecraftAccount);
    }

    private static final void actionPerformed$lambda$1(int $randomInteger, GuiAltManager this$0) {
        MinecraftAccount minecraftAccount = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().get($randomInteger);
        this$0.status = "\u00a7cThe list is empty.";
        this$0.status = Companion.login(minecraftAccount);
    }

    private static final void actionPerformed$lambda$2() {
        LoginUtils.INSTANCE.randomCracked();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager$Companion;", "", "<init>", "()V", "login", "", "account", "Lme/liuli/elixir/account/MinecraftAccount;", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nGuiAltManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuiAltManager.kt\nnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n1#2:185\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final String login(@NotNull MinecraftAccount account) {
            String string;
            Intrinsics.checkNotNullParameter(account, "account");
            try {
                void it;
                MinecraftImpl mc = MinecraftInstance.mc;
                Session session = account.getSession();
                MinecraftImpl minecraftImpl = mc;
                boolean bl2 = false;
                minecraftImpl.setSession(new net.minecraft.util.Session(it.getUsername(), it.getUuid(), it.getToken(), it.getType()));
                EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), new SessionEvent(), null, 2, null);
                StringBuilder stringBuilder = new StringBuilder().append("\u00a7cYour name is now \u00a78");
                Object object = mc.getSession();
                if (object == null || (object = object.func_111285_a()) == null) {
                    object = "null";
                }
                string = stringBuilder.append((String)object).append("\u00a7c.").toString();
            }
            catch (Exception e2) {
                e2.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder().append("Occurred an error: ");
                String string2 = e2.getMessage();
                if (string2 == null) {
                    string2 = "UNKNOWN";
                }
                string = stringBuilder.append(string2).toString();
            }
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0016J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J@\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0011H\u0014R\u001c\u0010\u0006\u001a\u00020\u00078FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager$GuiList;", "Lnet/minecraft/client/gui/GuiSlot;", "prevGui", "Lnet/minecraft/client/gui/GuiScreen;", "<init>", "(Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;Lnet/minecraft/client/gui/GuiScreen;)V", "selectedSlot", "", "getSelectedSlot", "()I", "setSelectedSlot", "(I)V", "isSelected", "", "id", "getSize", "elementClicked", "", "var1", "doubleClick", "var3", "var4", "drawSlot", "x", "y", "var5", "var6", "p6", "", "drawBackground", "DarkMeow"})
    private final class GuiList
    extends GuiSlot {
        private int selectedSlot;

        public GuiList(GuiScreen prevGui) {
            Intrinsics.checkNotNullParameter(prevGui, "prevGui");
            super(GuiAltManager.this.field_146297_k, prevGui.field_146294_l, prevGui.field_146295_m, 40, prevGui.field_146295_m - 40, 30);
        }

        public final int getSelectedSlot() {
            if (this.selectedSlot > DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().size()) {
                this.selectedSlot = -1;
            }
            return this.selectedSlot;
        }

        public final void setSelectedSlot(int n2) {
            this.selectedSlot = n2;
        }

        protected boolean func_148131_a(int id) {
            return this.getSelectedSlot() == id;
        }

        public int func_148127_b() {
            return DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().size();
        }

        /*
         * Enabled aggressive block sorting
         */
        public void func_148144_a(int var1, boolean doubleClick, int var3, int var4) {
            this.selectedSlot = var1;
            if (!doubleClick) return;
            GuiList guiList = GuiAltManager.this.altsList;
            if (guiList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("altsList");
                guiList = null;
            }
            if (guiList.getSelectedSlot() != -1) {
                GuiList guiList2 = GuiAltManager.this.altsList;
                if (guiList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList2 = null;
                }
                int n2 = guiList2.getSelectedSlot();
                GuiList guiList3 = GuiAltManager.this.altsList;
                if (guiList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("altsList");
                    guiList3 = null;
                }
                if (n2 < guiList3.func_148127_b()) {
                    new Thread(() -> GuiList.elementClicked$lambda$0(GuiAltManager.this)).start();
                    return;
                }
            }
            GuiAltManager.this.setStatus("\u00a7cSelect an account.");
        }

        protected void func_192637_a(int id, int x2, int y2, int var4, int var5, int var6, float p6) {
            MinecraftAccount minecraftAccount = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().get(id);
            FontRenderer fontRenderer = this.field_148161_k.field_71466_p;
            Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
            RendererExtensionKt.drawCenteredString(fontRenderer, minecraftAccount.getName(), (float)this.field_148155_a / 2.0f, (float)y2 + 2.0f, Color.WHITE.getRGB(), true);
            FontRenderer fontRenderer2 = this.field_148161_k.field_71466_p;
            Intrinsics.checkNotNullExpressionValue(fontRenderer2, "fontRenderer");
            RendererExtensionKt.drawCenteredString(fontRenderer2, minecraftAccount.getType(), (float)this.field_148155_a / 2.0f, (float)y2 + 15.0f, Color.LIGHT_GRAY.getRGB(), true);
        }

        protected void func_148123_a() {
        }

        private static final void elementClicked$lambda$0(GuiAltManager this$0) {
            List<MinecraftAccount> list = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts();
            GuiList guiList = this$0.altsList;
            if (guiList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("altsList");
                guiList = null;
            }
            MinecraftAccount minecraftAccount = list.get(guiList.getSelectedSlot());
            this$0.setStatus("\u00a7aLogging in...");
            this$0.setStatus("\u00a7c" + Companion.login(minecraftAccount));
        }
    }
}


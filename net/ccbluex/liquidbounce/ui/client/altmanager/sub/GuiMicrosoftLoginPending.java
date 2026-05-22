/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.altmanager.sub;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.liuli.elixir.account.MicrosoftAccount;
import me.liuli.elixir.account.MinecraftAccount;
import me.liuli.elixir.compat.OAuthServer;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.extensions.RendererExtensionKt;
import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/altmanager/sub/GuiMicrosoftLoginPending;", "Lnet/minecraft/client/gui/GuiScreen;", "prevGui", "<init>", "(Lnet/minecraft/client/gui/GuiScreen;)V", "stage", "", "server", "Lme/liuli/elixir/compat/OAuthServer;", "initGui", "", "actionPerformed", "button", "Lnet/minecraft/client/gui/GuiButton;", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "DarkMeow"})
public final class GuiMicrosoftLoginPending
extends GuiScreen {
    @NotNull
    private final GuiScreen prevGui;
    @NotNull
    private String stage;
    private OAuthServer server;

    public GuiMicrosoftLoginPending(@NotNull GuiScreen prevGui) {
        Intrinsics.checkNotNullParameter(prevGui, "prevGui");
        this.prevGui = prevGui;
        this.stage = "";
    }

    public void func_73866_w_() {
        if (!Intrinsics.areEqual(this.stage, "")) {
            return;
        }
        try {
            this.stage = "Initializing...";
            this.server = MicrosoftAccount.Companion.buildFromOpenBrowser$default(MicrosoftAccount.Companion, new MicrosoftAccount.OAuthHandler(this){
                final /* synthetic */ GuiMicrosoftLoginPending this$0;
                {
                    this.this$0 = $receiver;
                }

                public void openUrl(String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    GuiMicrosoftLoginPending.access$setStage$p(this.this$0, "Check your browser to continue. Browser didn't open? Check your minecraft log.");
                    ClientUtils.INSTANCE.logInfo("Opening URL: " + url);
                    MiscUtils.showURL(url);
                }

                public void authError(String error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    GuiMicrosoftLoginPending.access$setStage$p(this.this$0, "Error: " + error);
                }

                /*
                 * WARNING - void declaration
                 */
                public void authResult(MicrosoftAccount account) {
                    Boolean bl2;
                    Object v3;
                    block6: {
                        Intrinsics.checkNotNullParameter(account, "account");
                        Iterable $this$firstOrNull$iv = DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts();
                        boolean $i$f$firstOrNull = false;
                        for (T element$iv : $this$firstOrNull$iv) {
                            boolean bl3;
                            Object object;
                            boolean bl4;
                            Object object2;
                            MinecraftAccount configAccount;
                            block5: {
                                void $this$all$iv;
                                configAccount = (MinecraftAccount)element$iv;
                                boolean bl5 = false;
                                object2 = new Boolean[]{Intrinsics.areEqual(configAccount.getName(), account.getName()), Intrinsics.areEqual(configAccount.getType(), account.getType())};
                                boolean $i$f$all = false;
                                for (void element$iv2 : $this$all$iv) {
                                    boolean it = element$iv2.booleanValue();
                                    boolean bl6 = false;
                                    if (it) continue;
                                    bl4 = false;
                                    break block5;
                                }
                                bl4 = true;
                            }
                            object2 = bl4;
                            boolean it = (Boolean)object2;
                            boolean bl7 = false;
                            Object object3 = object = it ? object2 : null;
                            if (object != null) {
                                Object object4 = object;
                                boolean it2 = (Boolean)object4;
                                boolean bl8 = false;
                                JsonObject json = new JsonObject();
                                boolean bl9 = false;
                                account.toRawJson(json);
                                configAccount.fromRawJson(json);
                                boolean it3 = (Boolean)object4;
                                boolean bl10 = false;
                                bl3 = true;
                            } else {
                                bl3 = false;
                            }
                            if (!bl3) continue;
                            v3 = element$iv;
                            break block6;
                        }
                        v3 = null;
                    }
                    MinecraftAccount it = v3;
                    boolean bl11 = false;
                    Boolean bl12 = it == null;
                    boolean it2 = bl12;
                    boolean bl13 = false;
                    Boolean bl14 = bl2 = it2 ? bl12 : null;
                    if (bl2 != null) {
                        bl12 = bl2;
                        it2 = bl12;
                        boolean bl15 = false;
                        DarkMeow.INSTANCE.getFileManager().getAccountsConfig().getAltManagerMinecraftAccounts().add(account);
                    }
                    DarkMeow.INSTANCE.getFileManager().saveConfig(DarkMeow.INSTANCE.getFileManager().getAccountsConfig());
                    this.this$0.field_146297_k.func_147108_a(GuiMicrosoftLoginPending.access$getPrevGui$p(this.this$0));
                }
            }, null, 2, null);
        }
        catch (Throwable e2) {
            ClientUtils.INSTANCE.logError("Unable to load microsoft login pending.", e2);
        }
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 12, "Cancel"));
    }

    protected void func_146284_a(@NotNull GuiButton button) {
        Intrinsics.checkNotNullParameter(button, "button");
        if (button.field_146127_k == 0) {
            OAuthServer oAuthServer = this.server;
            if (oAuthServer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("server");
                oAuthServer = null;
            }
            oAuthServer.stop(true);
            this.field_146297_k.func_147108_a(this.prevGui);
        }
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        this.func_146276_q_();
        FontRenderer fontRenderer = this.field_146289_q;
        Intrinsics.checkNotNullExpressionValue(fontRenderer, "fontRenderer");
        RendererExtensionKt.drawCenteredString(fontRenderer, this.stage, (float)this.field_146294_l / 2.0f, (float)this.field_146295_m / 2.0f - (float)50, 0xFFFFFF);
        super.func_73863_a(mouseX, mouseY, partialTicks);
    }

    public static final /* synthetic */ void access$setStage$p(GuiMicrosoftLoginPending $this, String string) {
        $this.stage = string;
    }

    public static final /* synthetic */ GuiScreen access$getPrevGui$p(GuiMicrosoftLoginPending $this) {
        return $this.prevGui;
    }
}


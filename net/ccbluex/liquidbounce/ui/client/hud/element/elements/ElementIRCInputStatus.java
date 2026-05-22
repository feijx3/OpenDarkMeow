/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.client.IRC;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementIRCInputStatus;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "includeSelfValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "animationSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "displayText", "", "getDisplayText", "()Ljava/lang/String;", "setDisplayText", "(Ljava/lang/String;)V", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "updateElement", "", "getTypingSuffix", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementIRCInputStatus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementIRCInputStatus.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementIRCInputStatus\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1#2:74\n1#2:85\n1617#3,9:75\n1869#3:84\n1870#3:86\n1626#3:87\n774#3:88\n865#3,2:89\n*S KotlinDebug\n*F\n+ 1 ElementIRCInputStatus.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementIRCInputStatus\n*L\n53#1:85\n53#1:75,9\n53#1:84\n53#1:86\n53#1:87\n56#1:88\n56#1:89,2\n*E\n"})
public final class ElementIRCInputStatus
extends Element {
    @JvmField
    @NotNull
    public BoolValue includeSelfValue = new BoolValue("IncludeSelf", false);
    @JvmField
    @NotNull
    public IntegerValue animationSpeedValue = new IntegerValue("AnimationSpeed", 5, new IntRange(1, 20));
    @JvmField
    @NotNull
    public FontValue fontValue = new FontValue("Font", new FontValue.FontInfo(null, 0, 3, null));
    @Nullable
    private String displayText;

    public ElementIRCInputStatus() {
        super("IRCInputStatus", 4.0, 24.0, 0.0f, new ElementSide(ElementSide.Horizontal.LEFT, ElementSide.Vertical.DOWN), 0, 40, null);
    }

    @Nullable
    public final String getDisplayText() {
        return this.displayText;
    }

    public final void setDisplayText(@Nullable String string) {
        this.displayText = string;
    }

    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        String string = this.displayText;
        if (string != null) {
            String text = string;
            boolean bl2 = false;
            FontRenderer fontRenderer = this.fontValue.getFont();
            FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, text, Float.valueOf(0.0f), Float.valueOf(0.0f), null, false, 24, null);
            return new ElementBorder(-2.0f, -2.0f, (float)fontRenderer.func_78256_a(text) + 2.0f, fontRenderer.field_78288_b);
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void updateElement() {
        block10: {
            block11: {
                block13: {
                    block12: {
                        block9: {
                            v0 = this;
                            var1_1 = DarkMeow.INSTANCE.getModuleManager().get(IRC.class);
                            if (var1_1 == null) break block9;
                            var3_2 = var1_1;
                            var4_3 /* !! */  = var3_2;
                            var23_4 = v0;
                            $i$a$-takeIf-ElementIRCInputStatus$updateElement$1 = false;
                            var24_8 = it.getState();
                            v0 = var23_4;
                            v1 = var2_9 = var24_8 != false ? var3_2 : null;
                            if (var2_9 == null) break block9;
                            $i$a$-takeIf-ElementIRCInputStatus$updateElement$1 = var2_9;
                            var23_4 = v0;
                            $i$a$-let-ElementIRCInputStatus$updateElement$2 = false;
                            $this$updateElement_u24lambda_u248_u24lambda_u242 = var7_12 /* !! */  = (Set)new LinkedHashSet<E>();
                            $i$a$-apply-ElementIRCInputStatus$updateElement$2$1 = false;
                            $this$updateElement_u24lambda_u248_u24lambda_u242.addAll((Collection)module.getOtherTypingUsersPublic());
                            $this$updateElement_u24lambda_u248_u24lambda_u242.addAll((Collection)module.getOtherTypingUsersPrivate());
                            var7_12 /* !! */  = var7_12 /* !! */ ;
                            $i$f$mapNotNull = false;
                            $i$a$-apply-ElementIRCInputStatus$updateElement$2$1 = $this$mapNotNull$iv;
                            destination$iv$iv = new ArrayList<E>();
                            $i$f$mapNotNullTo = false;
                            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv /* !! */ ;
                            $i$f$forEach = false;
                            var14_31 = $this$forEach$iv$iv$iv.iterator();
                            while (var14_31.hasNext()) {
                                element$iv$iv = element$iv$iv$iv = var14_31.next();
                                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                                id = (UUID)element$iv$iv;
                                $i$a$-mapNotNull-ElementIRCInputStatus$updateElement$2$2 = false;
                                v2 = module.irc.getSessionManager().getSessions().get(id);
                                if ((v2 != null && (v2 = v2.getInfo()) != null ? v2.getName() : null) == null) continue;
                                it$iv$iv = it$iv$iv;
                                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                                destination$iv$iv.add(it$iv$iv);
                            }
                            $this$mapNotNull$iv = (List)destination$iv$iv;
                            $i$f$filter = false;
                            $this$mapNotNullTo$iv$iv /* !! */  = $this$filter$iv /* !! */ ;
                            destination$iv$iv = new ArrayList<E>();
                            $i$f$filterTo = false;
                            for (T element$iv$iv : $this$filterTo$iv$iv) {
                                name = (String)element$iv$iv;
                                $i$a$-filter-ElementIRCInputStatus$updateElement$2$3 = false;
                                if (((Boolean)this.includeSelfValue.get()).booleanValue()) ** GOTO lbl-1000
                                v3 = module.irc.getSessionManager().getSelfSession();
                                if (!Intrinsics.areEqual(v3 != null ? v3.getName() : null, name)) lbl-1000:
                                // 2 sources

                                {
                                    v4 = true;
                                } else {
                                    v4 = false;
                                }
                                if (!v4) continue;
                                destination$iv$iv.add(element$iv$iv);
                            }
                            it /* !! */  = $this$filter$iv /* !! */  = CollectionsKt.toMutableSet((List)destination$iv$iv);
                            $i$a$-takeIf-ElementIRCInputStatus$updateElement$2$4 = false;
                            v5 /* !! */  = var22_40 /* !! */  = !((Collection)it /* !! */ ).isEmpty() != false ? $this$filter$iv /* !! */  : null;
                            if (var22_40 /* !! */  != null && ($this$filter$iv /* !! */  = CollectionsKt.joinToString$default((Iterable)var22_40 /* !! */ , "\u00a77, ", null, null, 0, null, (Function1<String, CharSequence>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, updateElement$lambda$8$lambda$6(java.lang.String ), (Ljava/lang/String;)Ljava/lang/CharSequence;)(), 30, null)) != null) {
                                it /* !! */  = $this$filter$iv /* !! */ ;
                                $i$a$-let-ElementIRCInputStatus$updateElement$2$6 = false;
                                v6 = (String)it /* !! */  + " \u00a77is typing" + this.getTypingSuffix();
                            } else {
                                v6 = null;
                            }
                            v0 = var23_4;
                            var3_2 = v6;
                            if (var3_2 == null) break block9;
                            v7 = var3_2;
                            break block10;
                        }
                        if ((var4_3 /* !! */  = MinecraftInstance.mc.getCurrentScreen()) == null) break block11;
                        $this$filter$iv /* !! */  = var6_11 /* !! */  = var4_3 /* !! */ ;
                        var23_4 = v0;
                        $i$a$-takeIf-ElementIRCInputStatus$updateElement$3 = false;
                        var24_8 = it /* !! */  instanceof GuiHudDesigner;
                        v0 = var23_4;
                        v8 /* !! */  = var5_7 /* !! */  = var24_8 != false ? var6_11 /* !! */  : null;
                        if (var5_7 /* !! */  == null) break block11;
                        it /* !! */  = var5_7 /* !! */ ;
                        var23_4 = v0;
                        $i$a$-let-ElementIRCInputStatus$updateElement$4 = false;
                        v9 = new StringBuilder().append("\u00a7b");
                        v10 = DarkMeow.INSTANCE.getModuleManager().get(IRC.class);
                        if (v10 == null) break block12;
                        $i$a$-let-ElementIRCInputStatus$updateElement$2$6 = var9_21 = v10;
                        var11_26 = v9;
                        $i$a$-takeIf-ElementIRCInputStatus$updateElement$4$1 = false;
                        v9 = var11_26;
                        v10 = Boolean.valueOf(it.getState()) != false ? var9_21 : null;
                        if (v10 != null && (v10 = v10.irc) != null && (v10 = v10.getSessionManager()) != null && (v10 = v10.getSelfSession()) != null && (v10 = v10.getName()) != null) break block13;
                    }
                    v10 = "Username";
                }
                v7 = v9.append((String)v10).append(" \u00a77is typing").append(this.getTypingSuffix()).toString();
                v0 = var23_4;
                break block10;
            }
            v7 = null;
        }
        v0.displayText = v7;
    }

    @NotNull
    public final String getTypingSuffix() {
        return StringsKt.repeat(".", (int)(DarkMeow.INSTANCE.getUpdateManager().getUpdateId() / ((Number)this.animationSpeedValue.get()).longValue() % (long)3) + 1);
    }

    private static final CharSequence updateElement$lambda$8$lambda$6(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "\u00a7b" + it;
    }
}


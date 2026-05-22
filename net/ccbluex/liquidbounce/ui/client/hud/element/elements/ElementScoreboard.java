/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.scoreboard.Score
 *  net.minecraft.scoreboard.ScoreObjective
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.util.text.TextFormatting
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.features.module.modules.client.HUD;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.color.ColorValueManager;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScoreboard;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "defaultTitleColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "defaultTextColorValue", "backgroundColorValue", "radiusValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "renderPointValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "renderPointColorValue", "fontValue", "Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "hidePoint", "", "updateElement", "", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementScoreboard.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementScoreboard.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScoreboard\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1#2:166\n774#3:167\n865#3,2:168\n1740#3,3:170\n774#3:173\n865#3,2:174\n1878#3,3:176\n*S KotlinDebug\n*F\n+ 1 ElementScoreboard.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScoreboard\n*L\n71#1:167\n71#1:168,2\n74#1:170,3\n92#1:173\n92#1:174,2\n119#1:176,3\n*E\n"})
public final class ElementScoreboard
extends Element {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ColorValue defaultTitleColorValue = new ColorValue("DefaultTitleColor", new ColorValueInfo(new Color(240, 240, 240)), false, 4, null);
    @NotNull
    private final ColorValue defaultTextColorValue = new ColorValue("DefaultTextColor", new ColorValueInfo(new Color(240, 240, 240)), false, 4, null);
    @NotNull
    private final ColorValue backgroundColorValue = new ColorValue("BackgroundColor", ColorValueManager.Companion.getDEFAULT_BACKGROUND(), false, 4, null);
    @NotNull
    private final FloatValue radiusValue = new FloatValue("Radius", 0.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 20.0f));
    @NotNull
    private final ListValue renderPointValue;
    @NotNull
    private final ColorValue renderPointColorValue;
    @NotNull
    private final FontValue fontValue;
    @JvmField
    public boolean hidePoint;
    @NotNull
    private static final Function1<EntityPlayerSP, ScoreObjective>[] GET_SCOREBOARD_OBJECT;

    /*
     * WARNING - void declaration
     */
    public ElementScoreboard() {
        super("Scoreboard", 5.0, 0.0, 0.0f, new ElementSide(ElementSide.Horizontal.RIGHT, ElementSide.Vertical.MIDDLE), 0, 40, null);
        void $this$renderPointColorValue_u24lambda_u241;
        Object object = new String[]{"Always", "Smart", "None"};
        this.renderPointValue = new ListValue("RenderPoint", (String[])object, "Smart");
        Object object2 = object = new ColorValue("RenderPointColor", new ColorValueInfo(new Color(255, 0, 0)), false, 4, null);
        ElementScoreboard elementScoreboard = this;
        boolean bl2 = false;
        $this$renderPointColorValue_u24lambda_u241.getDisplayableFunc().add(() -> ElementScoreboard.renderPointColorValue$lambda$1$lambda$0(this));
        elementScoreboard.renderPointColorValue = object;
        this.fontValue = new FontValue("Font", new FontValue.FontInfo(null, 0, 3, null));
        this.hidePoint = true;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    @Override
    public void updateElement() {
        v0 = this;
        var1_1 = (String)this.renderPointValue.get();
        tmp = -1;
        switch (var1_1.hashCode()) {
            case 1964277295: {
                if (var1_1.equals("Always")) {
                    tmp = 1;
                }
                break;
            }
            case 2433880: {
                if (var1_1.equals("None")) {
                    tmp = 2;
                }
                break;
            }
            case 79996329: {
                if (var1_1.equals("Smart")) {
                    tmp = 3;
                }
                break;
            }
        }
        switch (tmp) {
            case 1: {
                v1 = false;
                break;
            }
            case 2: {
                v1 = true;
                break;
            }
            case 3: {
                var2_2 = MinecraftInstance.mc.getPlayer();
                if (var2_2 == null) ** GOTO lbl90
                var4_3 = var2_2;
                var19_4 = v0;
                $i$a$-let-ElementScoreboard$updateElement$1 = false;
                for (Function1<EntityPlayerSP, ScoreObjective> it : ElementScoreboard.GET_SCOREBOARD_OBJECT) {
                    $i$a$-firstNotNullOfOrNull-ElementScoreboard$updateElement$1$1 = false;
                    v2 = it.invoke((EntityPlayerSP)player);
                    if (v2 == null) {
                        continue;
                    }
                    ** GOTO lbl42
                }
                v2 = null;
lbl42:
                // 2 sources

                if ((var11_15 = v2) == null) ** GOTO lbl82
                it /* !! */  = var11_15;
                $i$a$-let-ElementScoreboard$updateElement$1$2 = false;
                var6_6 /* !! */  = it /* !! */ .func_96682_a().func_96534_i(it /* !! */ );
                if (var6_6 /* !! */  == null) ** GOTO lbl82
                it /* !! */  = (Iterable)var6_6 /* !! */ ;
                $i$f$filter = false;
                $i$a$-firstNotNullOfOrNull-ElementScoreboard$updateElement$1$1 = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                for (T element$iv$iv : $this$filterTo$iv$iv) {
                    it = (Score)element$iv$iv;
                    $i$a$-filter-ElementScoreboard$updateElement$1$3 = false;
                    v3 /* !! */  = it;
                    v4 = v3 /* !! */  != null && (v3 /* !! */  = v3 /* !! */ .func_96653_e()) != null ? !StringsKt.startsWith$default((String)v3 /* !! */ , "#", false, 2, null) : false;
                    if (!v4) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                var8_9 = CollectionsKt.takeLast((List)destination$iv$iv, 15);
                if (var8_9 == null || (var9_12 = CollectionsKt.zipWithNext((Iterable)var8_9)) == null) ** GOTO lbl82
                $this$filterTo$iv$iv = var9_12;
                $i$f$all = false;
                if (!($this$all$iv instanceof Collection) || !((Collection)$this$all$iv).isEmpty()) ** GOTO lbl71
                v5 = true;
                ** GOTO lbl80
lbl71:
                // 2 sources

                for (T element$iv : $this$all$iv) {
                    var15_21 = (Pair)element$iv;
                    $i$a$-all-ElementScoreboard$updateElement$1$4 = false;
                    a = (Score)var15_21.component1();
                    b = (Score)var15_21.component2();
                    if (b.func_96652_c() == a.func_96652_c() + 1) continue;
                    v5 = false;
                    ** GOTO lbl80
                }
                v5 = true;
lbl80:
                // 3 sources

                v6 = v5;
                ** GOTO lbl84
lbl82:
                // 3 sources

                v6 = null;
lbl84:
                // 2 sources

                v0 = var19_4;
                var3_27 = v6;
                if (var3_27 != null) {
                    v1 = var3_27;
                    break;
                }
lbl90:
                // 3 sources

                v1 = false;
                break;
            }
            default: {
                v1 = false;
            }
        }
        v0.hidePoint = v1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        ScoreObjective scoreObjective;
        ScoreObjective scoreObjective2;
        block11: {
            EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP == null) {
                return null;
            }
            EntityPlayerSP player = entityPlayerSP;
            for (Function1<EntityPlayerSP, ScoreObjective> it : GET_SCOREBOARD_OBJECT) {
                boolean bl2 = false;
                scoreObjective2 = it.invoke(player);
                if (scoreObjective2 == null) {
                    continue;
                }
                break block11;
            }
            scoreObjective2 = null;
        }
        if ((scoreObjective = scoreObjective2) != null) {
            Object object;
            int n2;
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            ScoreObjective currObjective = scoreObjective;
            boolean bl3 = false;
            FontRenderer fontRenderer = this.fontValue.getFont();
            Color defaultTextColor = ColorValue.getColor$default(this.defaultTextColorValue, null, 1, null);
            ScoreObjective it = currObjective;
            boolean bl4 = false;
            Collection collection = it.func_96682_a().func_96534_i(it);
            Intrinsics.checkNotNullExpressionValue(collection, "let(...)");
            Iterable iterable = collection;
            boolean $i$f$filter = false;
            it = $this$filter$iv;
            Collection destination$iv$iv22 = new ArrayList();
            boolean $i$f$filterTo22 = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Score it2 = (Score)element$iv$iv;
                n2 = 0;
                Object object2 = it2;
                boolean bl5 = object2 != null && (object2 = object2.func_96653_e()) != null ? !StringsKt.startsWith$default((String)object2, "#", false, 2, null) : false;
                if (!bl5) continue;
                destination$iv$iv22.add(element$iv$iv);
            }
            List scoreCollection = CollectionsKt.takeLast((List)destination$iv$iv22, 15);
            boolean bl6 = false;
            int destination$iv$iv22 = fontRenderer.func_78256_a(currObjective.func_96678_d());
            Iterator $i$f$filterTo22 = ((Iterable)scoreCollection).iterator();
            if (!$i$f$filterTo22.hasNext()) {
                object = null;
            } else {
                Object score = (Score)$i$f$filterTo22.next();
                boolean bl7 = false;
                score = fontRenderer.func_78256_a(ScorePlayerTeam.func_96667_a((Team)((Team)currObjective.func_96682_a().func_96509_i(score.func_96653_e())), (String)score.func_96653_e()) + ": " + String.valueOf(score.func_96652_c()));
                while ($i$f$filterTo22.hasNext()) {
                    Score score2 = (Score)$i$f$filterTo22.next();
                    $i$a$-maxOfOrNull-ElementScoreboard$drawElement$2$3$maxWidth$1 = false;
                    Comparable comparable = Integer.valueOf(fontRenderer.func_78256_a(ScorePlayerTeam.func_96667_a((Team)((Team)currObjective.func_96682_a().func_96509_i(score2.func_96653_e())), (String)score2.func_96653_e()) + ": " + String.valueOf(score2.func_96652_c())));
                    if (score.compareTo(comparable) >= 0) continue;
                    score = comparable;
                }
                object = score;
            }
            Integer n3 = (Integer)object;
            n2 = n3 != null ? n3 : 0;
            int maxWidth = Math.max(destination$iv$iv22, n2);
            int maxHeight = scoreCollection.size() * fontRenderer.field_78288_b;
            int l1 = -maxWidth - 3;
            HUD.INSTANCE.drawBackground((Number)Float.valueOf((float)l1 - 7.0f), (Number)Float.valueOf(-5.0f), (Number)Float.valueOf(9.0f), (Number)Float.valueOf((float)(maxHeight + fontRenderer.field_78288_b) + 5.0f), ColorValue.getColor$default(this.backgroundColorValue, null, 1, null), ((Number)this.radiusValue.get()).floatValue());
            Iterable $this$forEachIndexed$iv = scoreCollection;
            boolean $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                Integer n4;
                void score;
                int n5;
                if ((n5 = index$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Score score3 = (Score)item$iv;
                int index = n5;
                boolean bl8 = false;
                ScorePlayerTeam team = currObjective.func_96682_a().func_96509_i(score.func_96653_e());
                String scorePoints = String.valueOf(score.func_96652_c());
                int height = maxHeight - index * fontRenderer.field_78288_b;
                GlStateManager.func_179117_G();
                String string = ScorePlayerTeam.func_96667_a((Team)((Team)team), (String)score.func_96653_e());
                Intrinsics.checkNotNullExpressionValue(string, "formatPlayerName(...)");
                FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, string, Float.valueOf(l1), Float.valueOf(height), defaultTextColor, false, 16, null);
                Integer n6 = score.func_96652_c();
                int it3 = ((Number)n6).intValue();
                boolean bl9 = false;
                Integer n7 = n4 = !this.hidePoint ? n6 : null;
                if (n4 != null) {
                    n6 = n4;
                    it3 = ((Number)n6).intValue();
                    boolean bl10 = false;
                    FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, scorePoints, Float.valueOf(5 - fontRenderer.func_78256_a(scorePoints)), Float.valueOf(height), ColorValue.getColor$default(this.renderPointColorValue, null, 1, null), false, 16, null);
                }
                if (index != scoreCollection.size() - 1) continue;
                String displayName = currObjective.func_96678_d();
                Intrinsics.checkNotNull(displayName);
                FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, fontRenderer, displayName, Float.valueOf(l1 + maxWidth / 2 - fontRenderer.func_78256_a(displayName) / 2), Float.valueOf(height - fontRenderer.field_78288_b), ColorValue.getColor$default(this.defaultTitleColorValue, null, 1, null), false, 16, null);
            }
            return new ElementBorder(-((float)maxWidth) - 10.0f, -5.0f, 9.0f, (float)maxHeight + (float)fontRenderer.field_78288_b + (float)5);
        }
        return null;
    }

    private static final boolean renderPointColorValue$lambda$1$lambda$0(ElementScoreboard this$0) {
        return !Intrinsics.areEqual(this$0.renderPointValue.get(), "None");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final ScoreObjective GET_SCOREBOARD_OBJECT$lambda$18(EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        ScorePlayerTeam scorePlayerTeam = player.func_96123_co().func_96509_i(player.func_70005_c_());
        if (scorePlayerTeam == null) return null;
        TextFormatting textFormatting = scorePlayerTeam.func_178775_l();
        if (textFormatting == null) return null;
        Integer n2 = textFormatting.func_175746_b();
        int it = ((Number)n2).intValue();
        boolean bl2 = false;
        if (it < 0) return null;
        boolean bl3 = true;
        if (!bl3) return null;
        Integer n3 = n2;
        Integer n4 = n3;
        if (n4 == null) return null;
        it = ((Number)n4).intValue();
        boolean bl4 = false;
        ScoreObjective scoreObjective = player.func_96123_co().func_96539_a(3 + it);
        return scoreObjective;
    }

    private static final ScoreObjective GET_SCOREBOARD_OBJECT$lambda$19(EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return player.func_96123_co().func_96539_a(1);
    }

    static {
        Function1[] function1Array = new Function1[]{ElementScoreboard::GET_SCOREBOARD_OBJECT$lambda$18, ElementScoreboard::GET_SCOREBOARD_OBJECT$lambda$19};
        GET_SCOREBOARD_OBJECT = function1Array;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScoreboard$Companion;", "", "<init>", "()V", "GET_SCOREBOARD_OBJECT", "", "Lkotlin/Function1;", "Lnet/minecraft/client/entity/EntityPlayerSP;", "Lnet/minecraft/scoreboard/ScoreObjective;", "getGET_SCOREBOARD_OBJECT", "()[Lkotlin/jvm/functions/Function1;", "[Lkotlin/jvm/functions/Function1;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Function1<EntityPlayerSP, ScoreObjective>[] getGET_SCOREBOARD_OBJECT() {
            return GET_SCOREBOARD_OBJECT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


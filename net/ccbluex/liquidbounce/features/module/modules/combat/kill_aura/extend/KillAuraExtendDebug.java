/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.EntityLivingBase
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.extend;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraExtend;
import net.ccbluex.liquidbounce.injection.forge.StaticStorage;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendDebug;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraExtend;", "<init>", "()V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKillAuraExtendDebug.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KillAuraExtendDebug.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendDebug\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,40:1\n12#2,3:41\n*S KotlinDebug\n*F\n+ 1 KillAuraExtendDebug.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendDebug\n*L\n18#1:41,3\n*E\n"})
public final class KillAuraExtendDebug
extends KillAuraExtend {
    /*
     * WARNING - void declaration
     */
    public KillAuraExtendDebug() {
        super("Debug", false);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Render2DEvent, Unit> function$iv = (arg_0, arg_1) -> KillAuraExtendDebug._init_$lambda$3(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<Render2DEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit _init_$lambda$3(KillAuraExtendDebug this$0, ListenerBase $this$listener, Render2DEvent it) {
        CharSequence charSequence;
        ScaledResolution scaledResolution;
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        ScaledResolution sr = scaledResolution = StaticStorage.scaledResolution;
        boolean bl2 = false;
        StringBuilder $this$lambda_u243_u24lambda_u242_u24lambda_u240 = charSequence = new StringBuilder();
        boolean bl3 = false;
        $this$lambda_u243_u24lambda_u242_u24lambda_u240.append("Targets: " + this$0.getInstance().getTargetManager().getTargets().size());
        $this$lambda_u243_u24lambda_u242_u24lambda_u240.append("  |  ");
        $this$lambda_u243_u24lambda_u242_u24lambda_u240.append("Allows: " + DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows.size());
        $this$lambda_u243_u24lambda_u242_u24lambda_u240.append("  |  ");
        EntityLivingBase entityLivingBase = this$0.getInstance().getTargetManager().getPrevTarget();
        $this$lambda_u243_u24lambda_u242_u24lambda_u240.append("PrevTarget: " + (entityLivingBase != null ? entityLivingBase.func_70005_c_() : null));
        CharSequence text = charSequence = charSequence.toString();
        boolean bl4 = false;
        Intrinsics.checkNotNull(text);
        Number number = Float.valueOf((float)sr.func_78326_a() / 2.0f - (float)Fonts.minecraftFont.func_78256_a((String)text) / 2.0f);
        Number number2 = Float.valueOf((float)sr.func_78328_b() / 2.0f - 60.0f);
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, Fonts.minecraftFont, (String)text, number, number2, color, false, 16, null);
        return Unit.INSTANCE;
    }
}


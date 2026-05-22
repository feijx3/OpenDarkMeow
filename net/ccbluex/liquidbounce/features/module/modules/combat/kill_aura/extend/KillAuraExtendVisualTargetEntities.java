/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.extend;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.features.module.modules.combat.kill_aura.KillAuraExtend;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.utils.visual.Render3DUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendVisualTargetEntities;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/KillAuraExtend;", "<init>", "()V", "currentValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "otherValue", "noClipValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nKillAuraExtendVisualTargetEntities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KillAuraExtendVisualTargetEntities.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendVisualTargetEntities\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n12#2,3:41\n1869#3,2:44\n*S KotlinDebug\n*F\n+ 1 KillAuraExtendVisualTargetEntities.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/kill_aura/extend/KillAuraExtendVisualTargetEntities\n*L\n27#1:41,3\n30#1:44,2\n*E\n"})
public final class KillAuraExtendVisualTargetEntities
extends KillAuraExtend {
    @JvmField
    @NotNull
    public final ColorValue currentValue = new ColorValue("Current", new ColorValueInfo(new Color(255, 0, 0, 100)), false, 4, null);
    @JvmField
    @NotNull
    public final ColorValue otherValue = new ColorValue("Other", new ColorValueInfo(new Color(0, 255, 0, 100)), false, 4, null);
    @JvmField
    @NotNull
    public final BoolValue noClipValue = new BoolValue("NoClip", true);

    /*
     * WARNING - void declaration
     */
    public KillAuraExtendVisualTargetEntities() {
        super("VisualTargetEntities", true);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Render3DEvent, Unit> function$iv = (arg_0, arg_1) -> KillAuraExtendVisualTargetEntities._init_$lambda$1(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<Render3DEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render3DEvent.class), (ListenableOwner)$receiver$iv));
    }

    private static final Unit _init_$lambda$1(KillAuraExtendVisualTargetEntities this$0, ListenerBase $this$listener, Render3DEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        Entity entity = $this$listener.getMc().func_175606_aa();
        if (entity == null) {
            return Unit.INSTANCE;
        }
        Entity renderEntity = entity;
        Iterable $this$forEach$iv = this$0.getInstance().getTargetManager().getTargets();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            EntityLivingBase target = (EntityLivingBase)element$iv;
            boolean bl2 = false;
            Render3DUtils.drawBlockBoxFilled$default(Render3DUtils.INSTANCE, renderEntity, (Entity)target, event.getPartialTicks(), ColorValue.getColor$default(target == this$0.getInstance().getTargetManager().getPrevTarget() ? this$0.currentValue : this$0.otherValue, null, 1, null), (Boolean)this$0.noClipValue.get(), 0.0f, 16, null);
        }
        return Unit.INSTANCE;
    }
}


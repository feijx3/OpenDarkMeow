/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.grimac;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
import net.ccbluex.liquidbounce.handler.combat.IFakeEntity;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/grimac/GrimLegacyCollide;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "<init>", "()V", "speedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "airBorneValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "wasOnGround", "", "onMovementInputPost", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$POST;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGrimLegacyCollide.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GrimLegacyCollide.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/grimac/GrimLegacyCollide\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class GrimLegacyCollide
extends SpeedMode {
    @JvmField
    @NotNull
    public final FloatValue speedValue = new FloatValue("Speed", 0.08f, 0.01f, 0.08f);
    @JvmField
    @NotNull
    public final BoolValue airBorneValue = new BoolValue("AirBorne", true);
    private boolean wasOnGround;

    public GrimLegacyCollide() {
        super("GrimLegacyCollide");
    }

    @EventTarget
    public final void onMovementInputPost(@NotNull MovementInputEvent.POST event) {
        block6: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP3 == null) {
                return;
            }
            EntityPlayerSP player = entityPlayerSP3;
            EntityPlayerSP entityPlayerSP4 = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP4 == null) break block6;
            EntityPlayerSP it = entityPlayerSP2 = entityPlayerSP4;
            boolean bl2 = false;
            Object object = entityPlayerSP = !(event.getMovementInput().field_192832_b == 0.0f) || !(event.getMovementInput().field_78902_a == 0.0f) ? entityPlayerSP2 : null;
            if (entityPlayerSP != null) {
                Sequence<Entity> sequence;
                Sequence<Entity> sequence2;
                Sequence<Entity> sequence3;
                Sequence sequence4;
                List list;
                EntityPlayerSP entityPlayerSP5;
                EntityPlayerSP it2 = entityPlayerSP5 = entityPlayerSP;
                boolean bl3 = false;
                Object object2 = entityPlayerSP2 = it2.field_70737_aN <= 4 && !it2.func_70090_H() && !it2.func_180799_ab() ? entityPlayerSP5 : null;
                if (entityPlayerSP2 != null && (entityPlayerSP5 = entityPlayerSP2.field_70170_p) != null && (list = entityPlayerSP5.field_72996_f) != null && (sequence4 = CollectionsKt.asSequence(list)) != null && (sequence3 = SequencesKt.filter(sequence4, GrimLegacyCollide::onMovementInputPost$lambda$2)) != null && (sequence2 = SequencesKt.filter(sequence3, arg_0 -> GrimLegacyCollide.onMovementInputPost$lambda$3(player, arg_0))) != null && (sequence = SequencesKt.filter(sequence2, GrimLegacyCollide::onMovementInputPost$lambda$4)) != null) {
                    Sequence<Entity> entities = sequence;
                    boolean bl4 = false;
                    AxisAlignedBB box = player.func_174813_aQ().func_72321_a(1.5, 1.5, 1.5);
                    Sequence<Entity> sequence5 = SequencesKt.filter(entities, arg_0 -> GrimLegacyCollide.onMovementInputPost$lambda$6$lambda$5(box, arg_0));
                    if (sequence5 != null) {
                        Integer n2;
                        Integer n3 = SequencesKt.count(sequence5);
                        int it3 = ((Number)n3).intValue();
                        boolean bl5 = false;
                        Integer n4 = n2 = it3 > 0 ? n3 : null;
                        if (n2 != null) {
                            n3 = n2;
                            int collideCount = ((Number)n3).intValue();
                            boolean bl6 = false;
                            player.field_70747_aH = ((Number)this.speedValue.get()).floatValue() * (float)collideCount;
                            if (((Boolean)this.airBorneValue.get()).booleanValue()) {
                                player.field_70160_al = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private static final boolean onMovementInputPost$lambda$2(Entity it) {
        return !(it instanceof IFakeEntity);
    }

    private static final boolean onMovementInputPost$lambda$3(EntityPlayerSP $player, Entity it) {
        return !Intrinsics.areEqual(it, $player);
    }

    private static final boolean onMovementInputPost$lambda$4(Entity it) {
        return it instanceof EntityLivingBase && !(it instanceof EntityArmorStand);
    }

    private static final boolean onMovementInputPost$lambda$6$lambda$5(AxisAlignedBB $box, Entity it) {
        return $box.func_72326_a(it.func_174813_aQ());
    }
}


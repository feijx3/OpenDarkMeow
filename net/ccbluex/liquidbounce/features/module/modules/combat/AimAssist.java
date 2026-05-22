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
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.handler.combat.targets.TargetsManager;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeNormal;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.FloatRangeValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import net.darkmeow.darkmeow.utils.world.VecUtils;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AimAssist;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "priorityModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "rotationTurnSpeedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;", "rotationKeepTicksValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onDisable", "", "onMovementInputPre", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAimAssist.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AimAssist.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AimAssist\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n808#2,11:85\n2423#2,14:96\n*S KotlinDebug\n*F\n+ 1 AimAssist.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AimAssist\n*L\n52#1:85,11\n53#1:96,14\n*E\n"})
public final class AimAssist
extends Module {
    @JvmField
    @NotNull
    public final FloatValue rangeValue = new FloatValue("Range", 3.4f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 6.0f));
    @JvmField
    @NotNull
    public final ListValue priorityModeValue;
    @JvmField
    @NotNull
    public final FloatRangeValue rotationTurnSpeedValue;
    @JvmField
    @NotNull
    public final IntegerValue rotationKeepTicksValue;

    public AimAssist() {
        super("AimAssist", ModuleCategory.COMBAT, null, null, 12, null);
        String[] stringArray = new String[]{"Distance", "Health", "LivingTime", "HurtResistantTime", "EntityId"};
        this.priorityModeValue = new ListValue("PriorityMode", stringArray, "Distance");
        this.rotationTurnSpeedValue = new FloatRangeValue("RotationTurnSpeed", (ClosedRange<Float>)RangesKt.rangeTo(180.0f, 180.0f), (ClosedRange<Float>)RangesKt.rangeTo(10.0f, 180.0f));
        this.rotationKeepTicksValue = new IntegerValue("RotationKeepTicks", 1, new IntRange(0, 20));
    }

    @Override
    public void onDisable() {
        DarkMeow.INSTANCE.getRotationManager().delTask(this.getName());
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        block35: {
            block25: {
                block30: {
                    block27: {
                        block29: {
                            block28: {
                                block26: {
                                    block24: {
                                        Intrinsics.checkNotNullParameter(event, "event");
                                        v0 = MinecraftInstance.mc.getPlayer();
                                        if (v0 == null) {
                                            return;
                                        }
                                        player = v0;
                                        v1 = player.field_70170_p;
                                        Intrinsics.checkNotNullExpressionValue(v1, "world");
                                        var4_3 = WorldUtils.quickGetNearEntities(v1, player, ((Number)this.rangeValue.get()).floatValue(), (Function1<Entity, Boolean>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onMovementInputPre$lambda$0(net.minecraft.entity.Entity ), (Lnet/minecraft/entity/Entity;)Ljava/lang/Boolean;)());
                                        $i$f$filterIsInstance = false;
                                        var6_6 = $this$filterIsInstance$iv;
                                        destination$iv$iv = new ArrayList<E>();
                                        $i$f$filterIsInstanceTo = false;
                                        for (T element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                                            if (!(element$iv$iv /* !! */  instanceof EntityLivingBase)) continue;
                                            destination$iv$iv.add(element$iv$iv /* !! */ );
                                        }
                                        $this$filterIsInstance$iv = (List)destination$iv$iv;
                                        $i$f$minByOrNull = false;
                                        iterator$iv = $this$minByOrNull$iv.iterator();
                                        if (iterator$iv.hasNext()) break block24;
                                        v2 = null;
                                        break block25;
                                    }
                                    minElem$iv = iterator$iv.next();
                                    if (iterator$iv.hasNext()) break block26;
                                    v2 = minElem$iv;
                                    break block25;
                                }
                                entity = (EntityLivingBase)minElem$iv;
                                $i$a$-minByOrNull-AimAssist$onMovementInputPre$2 = false;
                                element$iv$iv /* !! */  = (String)this.priorityModeValue.get();
                                switch (element$iv$iv /* !! */ .hashCode()) {
                                    case -2037455746: {
                                        if (!element$iv$iv /* !! */ .equals("EntityId")) {
                                            ** break;
                                        }
                                        break block27;
                                    }
                                    case -2137395588: {
                                        if (element$iv$iv /* !! */ .equals("Health")) break;
                                        ** break;
                                    }
                                    case -1415550666: {
                                        if (!element$iv$iv /* !! */ .equals("LivingTime")) {
                                            ** break;
                                        }
                                        break block28;
                                    }
                                    case 567390779: {
                                        if (!element$iv$iv /* !! */ .equals("HurtResistantTime")) {
                                            ** break;
                                        }
                                        break block29;
                                    }
                                    case 353103893: {
                                        if (!element$iv$iv /* !! */ .equals("Distance")) ** break;
                                        v3 = player.func_70032_d((Entity)entity);
                                        break block30;
                                    }
                                }
                                v3 = entity.func_110143_aJ();
                                break block30;
                            }
                            v3 = -((float)entity.field_70173_aa);
                            break block30;
                        }
                        v3 = entity.field_70172_ad;
                        break block30;
                    }
                    v3 = entity.func_145782_y();
                    break block30;
lbl66:
                    // 6 sources

                    v3 = 0.0f;
                }
                minValue$iv = v3;
                do {
                    block34: {
                        block31: {
                            block33: {
                                block32: {
                                    e$iv = iterator$iv.next();
                                    entity = (EntityLivingBase)e$iv;
                                    $i$a$-minByOrNull-AimAssist$onMovementInputPre$2 = false;
                                    var12_18 = (String)this.priorityModeValue.get();
                                    switch (var12_18.hashCode()) {
                                        case -2037455746: {
                                            if (!var12_18.equals("EntityId")) {
                                                ** break;
                                            }
                                            break block31;
                                        }
                                        case -2137395588: {
                                            if (var12_18.equals("Health")) break;
                                            ** break;
                                        }
                                        case -1415550666: {
                                            if (!var12_18.equals("LivingTime")) {
                                                ** break;
                                            }
                                            break block32;
                                        }
                                        case 567390779: {
                                            if (!var12_18.equals("HurtResistantTime")) {
                                                ** break;
                                            }
                                            break block33;
                                        }
                                        case 353103893: {
                                            if (!var12_18.equals("Distance")) ** break;
                                            v4 = player.func_70032_d((Entity)entity);
                                            break block34;
                                        }
                                    }
                                    v4 = entity.func_110143_aJ();
                                    break block34;
                                }
                                v4 = -((float)entity.field_70173_aa);
                                break block34;
                            }
                            v4 = entity.field_70172_ad;
                            break block34;
                        }
                        v4 = entity.func_145782_y();
                        break block34;
lbl106:
                        // 6 sources

                        v4 = 0.0f;
                    }
                    v$iv = v4;
                    if (Float.compare(minValue$iv, v$iv) <= 0) continue;
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v2 = minElem$iv;
            }
            var3_19 = v2;
            if (var3_19 == null || (var4_3 = RotationUtils.getRotationEntity$default(RotationUtils.INSTANCE, (Entity)var3_19, VecUtils.INSTANCE.getEyeVec((Entity)player), 0.0, 2, null)) == null) break block35;
            rotation = var4_3;
            $i$a$-let-AimAssist$onMovementInputPre$3 = false;
            var5_5 = RotationUtils.INSTANCE.limitAngleChange(DarkMeow.INSTANCE.getRotationManager().serverRotation, (Rotation)rotation, this.rotationTurnSpeedValue.random());
            if (var5_5 != null) {
                var6_6 = var5_5;
                rotation = var6_6;
                $i$a$-also-AimAssist$onMovementInputPre$4 = false;
                DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(this.getName(), (Rotation)rotation, MovementModeNormal.INSTANCE, ((Number)this.rotationKeepTicksValue.get()).intValue()));
            }
        }
    }

    private static final boolean onMovementInputPre$lambda$0(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), entity, true, false, 4, null);
    }
}


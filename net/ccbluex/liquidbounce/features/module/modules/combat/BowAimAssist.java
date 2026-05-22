/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.ItemBow
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
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSilent;
import net.ccbluex.liquidbounce.handler.rotation.value.MovementModeValue;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.movement.RotationUtils;
import net.darkmeow.darkmeow.utils.world.VecUtils;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/BowAimAssist;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "priorityModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "rotationStrafeValue", "Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "rotationKeepTicksValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "onDisable", "", "onMovementInput", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nBowAimAssist.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BowAimAssist.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/BowAimAssist\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1#2:89\n808#3,11:90\n774#3:101\n865#3,2:102\n2423#3,14:104\n*S KotlinDebug\n*F\n+ 1 BowAimAssist.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/BowAimAssist\n*L\n56#1:90,11\n57#1:101\n57#1:102,2\n60#1:104,14\n*E\n"})
public final class BowAimAssist
extends Module {
    @JvmField
    @NotNull
    public final FloatValue rangeValue = new FloatValue("Range", 16.0f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 64.0f));
    @JvmField
    @NotNull
    public final ListValue priorityModeValue;
    @JvmField
    @NotNull
    public final MovementModeValue rotationStrafeValue;
    @JvmField
    @NotNull
    public final IntegerValue rotationKeepTicksValue;

    public BowAimAssist() {
        super("BowAimAssist", ModuleCategory.COMBAT, null, null, 12, null);
        String[] stringArray = new String[]{"Distance", "Health", "LivingTime", "HurtResistantTime", "EntityId"};
        this.priorityModeValue = new ListValue("PriorityMode", stringArray, "Distance");
        this.rotationStrafeValue = new MovementModeValue("RotationStrafe", MovementModeSilent.INSTANCE);
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
    public final void onMovementInput(@NotNull MovementInputEvent.PRE event) {
        block24: {
            block26: {
                block31: {
                    block28: {
                        block30: {
                            block29: {
                                block27: {
                                    block25: {
                                        Intrinsics.checkNotNullParameter(event, "event");
                                        var2_2 = MinecraftInstance.mc.getPlayer();
                                        if (var2_2 == null) break block24;
                                        it = var4_3 = var2_2;
                                        $i$a$-takeIf-BowAimAssist$onMovementInput$1 = false;
                                        v0 /* !! */  = var3_6 = it.func_184607_cu().func_77973_b() instanceof ItemBow != false ? var4_3 : null;
                                        if (var3_6 == null) break block24;
                                        player = var4_3 = var3_6;
                                        $i$a$-also-BowAimAssist$onMovementInput$2 = false;
                                        v1 = player.field_70170_p;
                                        Intrinsics.checkNotNullExpressionValue(v1, "world");
                                        var7_7 = WorldUtils.quickGetNearEntities(v1, player, ((Number)this.rangeValue.get()).floatValue(), (Function1<Entity, Boolean>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onMovementInput$lambda$6$lambda$1(net.minecraft.entity.Entity ), (Lnet/minecraft/entity/Entity;)Ljava/lang/Boolean;)());
                                        $i$f$filterIsInstance = false;
                                        var9_10 = $this$filterIsInstance$iv;
                                        destination$iv$iv = new ArrayList<E>();
                                        $i$f$filterIsInstanceTo = false;
                                        for (T element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                                            if (!(element$iv$iv /* !! */  instanceof EntityLivingBase)) continue;
                                            destination$iv$iv.add(element$iv$iv /* !! */ );
                                        }
                                        $this$filterIsInstance$iv = (List)destination$iv$iv;
                                        $i$f$filter = false;
                                        $this$filterIsInstanceTo$iv$iv = $this$filter$iv;
                                        destination$iv$iv = new ArrayList<E>();
                                        $i$f$filterTo = false;
                                        for (T element$iv$iv : $this$filterTo$iv$iv) {
                                            entity = (EntityLivingBase)element$iv$iv /* !! */ ;
                                            $i$a$-filter-BowAimAssist$onMovementInput$2$2 = false;
                                            if (!player.func_70685_l((Entity)entity)) continue;
                                            destination$iv$iv.add(element$iv$iv /* !! */ );
                                        }
                                        $this$filter$iv = (List)destination$iv$iv;
                                        $i$f$minByOrNull = false;
                                        iterator$iv = $this$minByOrNull$iv.iterator();
                                        if (iterator$iv.hasNext()) break block25;
                                        v2 = null;
                                        break block26;
                                    }
                                    minElem$iv = iterator$iv.next();
                                    if (iterator$iv.hasNext()) break block27;
                                    v2 = minElem$iv;
                                    break block26;
                                }
                                entity = (EntityLivingBase)minElem$iv;
                                $i$a$-minByOrNull-BowAimAssist$onMovementInput$2$3 = false;
                                element$iv$iv /* !! */  = (String)this.priorityModeValue.get();
                                switch (element$iv$iv /* !! */ .hashCode()) {
                                    case -2037455746: {
                                        if (!element$iv$iv /* !! */ .equals("EntityId")) {
                                            ** break;
                                        }
                                        break block28;
                                    }
                                    case -2137395588: {
                                        if (element$iv$iv /* !! */ .equals("Health")) break;
                                        ** break;
                                    }
                                    case -1415550666: {
                                        if (!element$iv$iv /* !! */ .equals("LivingTime")) {
                                            ** break;
                                        }
                                        break block29;
                                    }
                                    case 567390779: {
                                        if (!element$iv$iv /* !! */ .equals("HurtResistantTime")) {
                                            ** break;
                                        }
                                        break block30;
                                    }
                                    case 353103893: {
                                        if (!element$iv$iv /* !! */ .equals("Distance")) ** break;
                                        v3 = player.func_70032_d((Entity)entity);
                                        break block31;
                                    }
                                }
                                v3 = entity.func_110143_aJ();
                                break block31;
                            }
                            v3 = -((float)entity.field_70173_aa);
                            break block31;
                        }
                        v3 = entity.field_70172_ad;
                        break block31;
                    }
                    v3 = entity.func_145782_y();
                    break block31;
lbl83:
                    // 6 sources

                    v3 = 0.0f;
                }
                minValue$iv = v3;
                do {
                    block35: {
                        block32: {
                            block34: {
                                block33: {
                                    e$iv = iterator$iv.next();
                                    entity = (EntityLivingBase)e$iv;
                                    $i$a$-minByOrNull-BowAimAssist$onMovementInput$2$3 = false;
                                    var15_27 = (String)this.priorityModeValue.get();
                                    switch (var15_27.hashCode()) {
                                        case -2037455746: {
                                            if (!var15_27.equals("EntityId")) {
                                                ** break;
                                            }
                                            break block32;
                                        }
                                        case -2137395588: {
                                            if (var15_27.equals("Health")) break;
                                            ** break;
                                        }
                                        case -1415550666: {
                                            if (!var15_27.equals("LivingTime")) {
                                                ** break;
                                            }
                                            break block33;
                                        }
                                        case 567390779: {
                                            if (!var15_27.equals("HurtResistantTime")) {
                                                ** break;
                                            }
                                            break block34;
                                        }
                                        case 353103893: {
                                            if (!var15_27.equals("Distance")) ** break;
                                            v4 = player.func_70032_d((Entity)entity);
                                            break block35;
                                        }
                                    }
                                    v4 = entity.func_110143_aJ();
                                    break block35;
                                }
                                v4 = -((float)entity.field_70173_aa);
                                break block35;
                            }
                            v4 = entity.field_70172_ad;
                            break block35;
                        }
                        v4 = entity.func_145782_y();
                        break block35;
lbl123:
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
            var16_28 = v2;
            if (var16_28 == null) break block24;
            iterator$iv = (float)player.func_184605_cv() / 20.0f;
            var17_29 = VecUtils.INSTANCE.getEyeVec((Entity)player);
            var18_30 = (Entity)var16_28;
            var19_31 = RotationUtils.INSTANCE;
            $i$a$-let-BowAimAssist$onMovementInput$2$4 = false;
            var20_32 = (it * it + it * (float)2) / (float)3;
            var7_7 = var19_31.getRotationThrowable(var18_30, var17_29, RangesKt.coerceAtMost((float)var20_32, 1.0f));
            if (var7_7 != null) {
                rotation = var8_9 = var7_7;
                $i$a$-also-BowAimAssist$onMovementInput$2$5 = false;
                DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(this.getName(), (Rotation)rotation, this.rotationStrafeValue.getMovementMode(), ((Number)this.rotationKeepTicksValue.get()).intValue()));
            }
        }
    }

    private static final boolean onMovementInput$lambda$6$lambda$1(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return TargetsManager.isSelected$default(DarkMeow.INSTANCE.getCombatManager().getTargetsManager(), entity, true, false, 4, null);
    }
}


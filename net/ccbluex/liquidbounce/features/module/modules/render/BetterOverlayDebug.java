/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import de.florianmichael.vialoadingbase.ViaLoadingBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.event.events.render.gui.RenderGuiOverlayDebugEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.combat.LastAttackInfo;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.darkmeow.darkmeow.utils.kotlin.BoundedArrayDeque;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="BetterOverlayDebug", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/BetterOverlayDebug;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "rateHandActive", "", "logsHandActive", "Lnet/darkmeow/darkmeow/utils/kotlin/BoundedArrayDeque;", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onRenderGuiOverlayDebug", "Lnet/ccbluex/liquidbounce/event/events/render/gui/RenderGuiOverlayDebugEvent;", "calculateDamageReduction", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nBetterOverlayDebug.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BetterOverlayDebug.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/BetterOverlayDebug\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,274:1\n1788#2,4:275\n360#2,7:279\n360#2,7:287\n360#2,7:294\n360#2,7:301\n360#2,7:308\n1#3:286\n*S KotlinDebug\n*F\n+ 1 BetterOverlayDebug.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/BetterOverlayDebug\n*L\n48#1:275,4\n58#1:279,7\n180#1:287,7\n189#1:294,7\n204#1:301,7\n240#1:308,7\n*E\n"})
public final class BetterOverlayDebug
extends Module {
    @JvmField
    public int rateHandActive;
    @JvmField
    @NotNull
    public final BoundedArrayDeque<Boolean> logsHandActive = new BoundedArrayDeque(20);

    public BetterOverlayDebug() {
        super(null, null, null, null, 15, null);
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        int n2;
        void $this$count$iv;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP player = event.getPlayer();
        player.func_175150_k(false);
        this.logsHandActive.add(event.getPlayer().func_184587_cr());
        Iterable iterable = this.logsHandActive;
        BetterOverlayDebug betterOverlayDebug = this;
        boolean $i$f$count = false;
        if ($this$count$iv instanceof Collection && ((Collection)$this$count$iv).isEmpty()) {
            n2 = 0;
        } else {
            int count$iv = 0;
            for (Object element$iv : $this$count$iv) {
                Boolean it = (Boolean)element$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNull(it);
                if (!it.booleanValue() || ++count$iv >= 0) continue;
                CollectionsKt.throwCountOverflow();
            }
            n2 = count$iv;
        }
        int n3 = n2;
        betterOverlayDebug.rateHandActive = (int)((float)n3 / (float)this.logsHandActive.size() * 100.0f);
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget
    public final void onRenderGuiOverlayDebug(@NotNull RenderGuiOverlayDebugEvent event) {
        Object object;
        int n2;
        int index;
        int it;
        Object object2;
        Object object3;
        List<String> info;
        block50: {
            List<String> list;
            int n3;
            Object object4;
            int index$iv;
            boolean $i$f$indexOfFirst;
            Unit unit;
            Object object5;
            List<String> $this$indexOfFirst$iv;
            block49: {
                List<String> list2;
                int n4;
                block48: {
                    List<String> list3;
                    int n5;
                    block47: {
                        Object object6;
                        Object task;
                        Object object7;
                        Object[] stuck;
                        Object object822;
                        String string;
                        List<String> list4;
                        Integer n6;
                        List<String> list5;
                        int n7;
                        Object object9;
                        BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u247;
                        List<String> list6;
                        Entity currentEntity;
                        block46: {
                            Intrinsics.checkNotNullParameter(event, "event");
                            Entity entity = MinecraftInstance.mc.getRenderViewEntity();
                            if (entity == null) {
                                return;
                            }
                            currentEntity = entity;
                            info = list6 = event.getLeft();
                            boolean bl2 = false;
                            $this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u247 = this;
                            boolean bl3 = false;
                            object3 = info;
                            boolean $i$f$indexOfFirst2 = false;
                            int index$iv2 = 0;
                            object9 = $this$indexOfFirst$iv.iterator();
                            while (object9.hasNext()) {
                                Object e2 = object9.next();
                                String it22 = (String)e2;
                                boolean object822 = false;
                                if (StringsKt.startsWith$default(it22, "XYZ:", false, 2, null)) {
                                    n7 = index$iv2;
                                    break block46;
                                }
                                ++index$iv2;
                            }
                            n7 = -1;
                        }
                        $this$indexOfFirst$iv = n7;
                        int it4 = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                        boolean bl4 = false;
                        Object object8 = object2 = it4 != -1 ? $this$indexOfFirst$iv : null;
                        if (object2 != null) {
                            String string2;
                            String string3;
                            String player;
                            $this$indexOfFirst$iv = object2;
                            int index2 = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                            boolean bl5 = false;
                            Object object10 = object9 = (List)new ArrayList();
                            int it22 = index2 + 1;
                            List<String> object822 = info;
                            boolean bl6 = false;
                            object5 = "Motion: %.3f / %.5f / %.3f";
                            Object[] objectArray = new Object[]{currentEntity.field_70159_w, currentEntity.field_70181_x, currentEntity.field_70179_y};
                            String string4 = String.format((String)object5, Arrays.copyOf(objectArray, objectArray.length));
                            Intrinsics.checkNotNullExpressionValue(string4, "format(...)");
                            object10.add(string4);
                            object5 = "Fall Distance: %.3f";
                            objectArray = new Object[]{Float.valueOf(currentEntity.field_70143_R)};
                            String string5 = String.format((String)object5, Arrays.copyOf(objectArray, objectArray.length));
                            Intrinsics.checkNotNullExpressionValue(string5, "format(...)");
                            object10.add(string5);
                            object10.add("On Ground: " + currentEntity.field_70122_E);
                            object10.add("Entity Id: " + currentEntity.func_145782_y());
                            object10.add("Sprinting: " + currentEntity.func_70051_ag());
                            object10.add("Sneaking: " + currentEntity.func_70093_af());
                            EntityLivingBase entityLivingBase = currentEntity instanceof EntityLivingBase ? (EntityLivingBase)currentEntity : null;
                            if (entityLivingBase != null) {
                                object5 = entityLivingBase;
                                player = object5;
                                boolean bl7 = false;
                                object10.add("Hand Active: " + player.func_184587_cr() + " (" + $this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u247.rateHandActive + "%)");
                                string3 = object5;
                            } else {
                                string3 = null;
                            }
                            EntityPlayerSP entityPlayerSP = currentEntity instanceof EntityPlayerSP ? (EntityPlayerSP)currentEntity : null;
                            if (entityPlayerSP != null) {
                                object5 = entityPlayerSP;
                                player = object5;
                                boolean bl8 = false;
                                object10.add("Position Update Ticks: " + ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks((EntityPlayerSP)player));
                                object10.add("Server Sprint State: " + ExtendEntityPlayerSP.INSTANCE.getServerSprintState((EntityPlayerSP)player));
                                object10.add("Server Sneak State: " + ExtendEntityPlayerSP.INSTANCE.getServerSneakState((EntityPlayerSP)player));
                                string2 = object5;
                            } else {
                                string2 = null;
                            }
                            unit = Unit.INSTANCE;
                            object822.addAll(it22, (Collection)object9);
                            list5 = $this$indexOfFirst$iv;
                        } else {
                            list5 = null;
                        }
                        BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u249 = this;
                        boolean bl9 = false;
                        EntityPlayerSP entityPlayerSP = currentEntity instanceof EntityPlayerSP ? (EntityPlayerSP)currentEntity : null;
                        if (entityPlayerSP != null) {
                            $this$indexOfFirst$iv = entityPlayerSP;
                            Integer player = $this$indexOfFirst$iv;
                            boolean bl10 = false;
                            info.add("");
                            info.add("Movement Input Forward: " + ((EntityPlayerSP)player).field_71158_b.field_192832_b);
                            info.add("Movement Input Strafe: " + ((EntityPlayerSP)player).field_71158_b.field_78902_a);
                            info.add("Movement Input Jump: " + ((EntityPlayerSP)player).field_71158_b.field_78901_c);
                            info.add("Movement Input Sneak: " + ((EntityPlayerSP)player).field_71158_b.field_78899_d);
                            n6 = $this$indexOfFirst$iv;
                        } else {
                            n6 = null;
                        }
                        BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u2411 = this;
                        boolean bl11 = false;
                        EntityPlayer entityPlayer = currentEntity instanceof EntityPlayer ? (EntityPlayer)currentEntity : null;
                        if (entityPlayer != null) {
                            $this$indexOfFirst$iv = entityPlayer;
                            Integer player = $this$indexOfFirst$iv;
                            boolean bl12 = false;
                            info.add("");
                            info.add("Player Name: " + player.func_146103_bH().getName());
                            info.add("Player UUID: " + player.func_146103_bH().getId());
                            info.add("");
                            info.add("Health: " + player.func_110138_aP() + '/' + player.func_110143_aJ());
                            info.add("Armor Count: " + player.func_82243_bO() * (float)4);
                            info.add("Armor: " + player.func_70658_aO());
                            info.add("Armor Toughness: " + player.func_110148_a(SharedMonsterAttributes.field_189429_h).func_111126_e());
                            info.add("Hurt Time: " + ((EntityPlayer)player).field_70737_aN);
                            info.add("Invulnerable: " + player.func_190530_aW());
                            StringBuilder stringBuilder = new StringBuilder().append("Damage Reduction Ratio: ");
                            object9 = "%.2f";
                            Object[] objectArray2 = new Object[]{$this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u2411.calculateDamageReduction((EntityPlayer)player) * (double)100};
                            objectArray2 = objectArray2;
                            String string6 = String.format((String)object9, Arrays.copyOf(objectArray2, objectArray2.length));
                            Intrinsics.checkNotNullExpressionValue(string6, "format(...)");
                            info.add(stringBuilder.append(string6).append('%').toString());
                            list4 = $this$indexOfFirst$iv;
                        } else {
                            list4 = null;
                        }
                        BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2418_u24lambda_u2417 = this;
                        boolean bl13 = false;
                        info.add("");
                        info.add("\u00a7d<" + DarkMeow.INSTANCE.getCLIENT_NAME() + ">\u00a7r: " + DarkMeow.INSTANCE.getModuleManager().getModules().size() + " modules loaded.");
                        info.add("");
                        boolean bl2 = !((Collection)DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows).isEmpty() ? info.add("Allows Attack Entity: " + CollectionsKt.joinToString$default(DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows, ", ", null, null, 0, null, BetterOverlayDebug::onRenderGuiOverlayDebug$lambda$18$lambda$17$lambda$12, 30, null) + " (" + DarkMeow.INSTANCE.getCombatManager().getAllowAttackManager().allows.size() + ')') : info.add("Allows Attack Entity: empty");
                        List<String> list7 = info;
                        StringBuilder stringBuilder = new StringBuilder().append("Last Attack Entity: ");
                        LastAttackInfo lastAttackInfo = DarkMeow.INSTANCE.getCombatManager().getLastAttack();
                        if (lastAttackInfo != null) {
                            void it3;
                            $this$indexOfFirst$iv = lastAttackInfo;
                            StringBuilder player = stringBuilder;
                            List<String> bl12 = list7;
                            boolean bl15 = false;
                            String string7 = String.valueOf(it3.getEntity().func_145782_y());
                            list7 = bl12;
                            stringBuilder = player;
                            string = string7;
                        } else {
                            string = null;
                        }
                        list7.add(stringBuilder.append(string).toString());
                        Object it22 = DarkMeow.INSTANCE.getMovementManager().getStuckManager();
                        Object[] it2 = it22;
                        boolean bl16 = false;
                        Object object11 = object822 = it2.isInStuck() ? it22 : null;
                        if (object822 != null) {
                            it22 = object822;
                            stuck = it22;
                            boolean bl17 = false;
                            info.add("");
                            info.add("Movement Stuck Allow Moving: " + stuck.allowMoving);
                            info.add("Movement Stuck Allow Updating Walking: " + stuck.allowUpdatingWalking);
                            info.add("Movement Stuck Cancel Updating Walking: " + stuck.getCancelPlayerSPUpdateWalkingCount());
                            object7 = it22;
                        } else {
                            object7 = null;
                        }
                        info.add("");
                        it22 = "Server Rotation: %.1f / %.1f";
                        stuck = new Object[]{Float.valueOf(MathHelper.func_76142_g((float)DarkMeow.INSTANCE.getRotationManager().serverRotation.yaw)), Float.valueOf(MathHelper.func_76142_g((float)DarkMeow.INSTANCE.getRotationManager().serverRotation.pitch))};
                        String string8 = String.format((String)it22, Arrays.copyOf(stuck, stuck.length));
                        Intrinsics.checkNotNullExpressionValue(string8, "format(...)");
                        info.add(string8);
                        object822 = DarkMeow.INSTANCE.getRotationManager().getTask();
                        if (object822 != null) {
                            task = it22 = object822;
                            boolean bl18 = false;
                            info.add("");
                            info.add("Rotation Task: " + ((RotationTask)task).getName());
                            object2 = "Rotation Task Facing: %.1f / %.1f";
                            Object[] bl6 = new Object[]{Float.valueOf(MathHelper.func_76142_g((float)((RotationTask)task).getRotation().yaw)), Float.valueOf(MathHelper.func_76142_g((float)((RotationTask)task).getRotation().pitch))};
                            String string9 = String.format((String)object2, Arrays.copyOf(bl6, bl6.length));
                            Intrinsics.checkNotNullExpressionValue(string9, "format(...)");
                            info.add(string9);
                            MovementMode movementMode = ((RotationTask)task).getMode();
                            info.add("Rotation Task Movement Mode: " + (movementMode != null ? movementMode.getName() : null));
                            object6 = it22;
                        } else {
                            object6 = null;
                        }
                        info = list6 = event.getRight();
                        boolean bl19 = false;
                        BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2442_u24lambda_u2422 = this;
                        boolean bl20 = false;
                        task = info;
                        $i$f$indexOfFirst = false;
                        index$iv = 0;
                        for (Object e3 : $this$indexOfFirst$iv) {
                            String it3 = (String)e3;
                            boolean bl21 = false;
                            if (StringsKt.startsWith$default(it3, "MCP", false, 2, null)) {
                                n5 = index$iv;
                                break block47;
                            }
                            ++index$iv;
                        }
                        n5 = -1;
                    }
                    $this$indexOfFirst$iv = n5;
                    it = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                    boolean bl22 = false;
                    Object object12 = object2 = it != -1 ? $this$indexOfFirst$iv : null;
                    if (object2 != null) {
                        $this$indexOfFirst$iv = object2;
                        index = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                        boolean bl23 = false;
                        info.add(index + 1, DarkMeow.INSTANCE.getCLIENT_NAME() + ' ' + DarkMeow.INSTANCE.getCLIENT_VERSION());
                        list3 = $this$indexOfFirst$iv;
                    } else {
                        list3 = null;
                    }
                    BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2442_u24lambda_u2427 = this;
                    boolean bl24 = false;
                    $this$indexOfFirst$iv = info;
                    $i$f$indexOfFirst = false;
                    index$iv = 0;
                    for (Object object13 : $this$indexOfFirst$iv) {
                        String it5 = (String)object13;
                        boolean bl25 = false;
                        if (StringsKt.contains$default((CharSequence)it5, "mods loaded", false, 2, null)) {
                            n4 = index$iv;
                            break block48;
                        }
                        ++index$iv;
                    }
                    n4 = -1;
                }
                $this$indexOfFirst$iv = n4;
                it = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                boolean bl26 = false;
                Object object14 = object2 = it != -1 ? $this$indexOfFirst$iv : null;
                if (object2 != null) {
                    $this$indexOfFirst$iv = object2;
                    index = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                    boolean bl27 = false;
                    object4 = new ArrayList();
                    Iterator<String> iterator2 = object4;
                    int it5 = index + 1;
                    List<String> bl25 = info;
                    boolean bl28 = false;
                    iterator2.add("");
                    iterator2.add("ViaVersion Protocol: " + ViaLoadingBase.getInstance().getTargetVersion().getVersion());
                    object5 = Unit.INSTANCE;
                    bl25.addAll(it5, (Collection)object4);
                    list2 = $this$indexOfFirst$iv;
                } else {
                    list2 = null;
                }
                BetterOverlayDebug $this$onRenderGuiOverlayDebug_u24lambda_u2442_u24lambda_u2441 = this;
                boolean bl29 = false;
                $this$indexOfFirst$iv = info;
                $i$f$indexOfFirst = false;
                index$iv = 0;
                object4 = $this$indexOfFirst$iv.iterator();
                while (object4.hasNext()) {
                    String string;
                    String it6 = string = object4.next();
                    boolean bl30 = false;
                    if (StringsKt.startsWith$default(it6, "Local Difficulty:", false, 2, null)) {
                        n3 = index$iv;
                        break block49;
                    }
                    ++index$iv;
                }
                n3 = -1;
            }
            $this$indexOfFirst$iv = n3;
            it = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
            boolean bl31 = false;
            Object object15 = object2 = it != -1 ? $this$indexOfFirst$iv : null;
            if (object2 != null) {
                Object object16;
                $this$indexOfFirst$iv = object2;
                index = ((Number)((Object)$this$indexOfFirst$iv)).intValue();
                boolean bl32 = false;
                Object object17 = object4 = (List)new ArrayList();
                int it6 = index + 1;
                List<String> bl30 = info;
                boolean bl33 = false;
                RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
                if (rayTraceResult != null) {
                    Object obj = object5 = rayTraceResult;
                    boolean bl34 = false;
                    object17.add("");
                    object17.add("Looking Type: " + ((RayTraceResult)obj).field_72313_a.name());
                    RayTraceResult.Type type = ((RayTraceResult)obj).field_72313_a;
                    switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                        case 1: {
                            Object object18;
                            Entity entity = ((RayTraceResult)obj).field_72308_g;
                            if (entity != null) {
                                EntityLivingBase entityLivingBase;
                                Unit entity2 = unit = entity;
                                boolean bl35 = false;
                                object17.add("Looking Entity: " + entity2.func_70005_c_() + " (id:" + entity2.func_145782_y() + ')');
                                EntityLivingBase entityLivingBase2 = entity2 instanceof EntityLivingBase ? (EntityLivingBase)entity2 : null;
                                if (entityLivingBase2 != null) {
                                    EntityPlayer entityPlayer;
                                    EntityLivingBase entityLivingBase3;
                                    EntityLivingBase entityLiving = entityLivingBase3 = entityLivingBase2;
                                    boolean bl36 = false;
                                    info.add("Looking Entity Health: " + entityLiving.func_110143_aJ());
                                    info.add("Looking Entity Hurt Time: " + entityLiving.field_70737_aN);
                                    info.add("Looking Entity Hand Active: " + entityLiving.func_184587_cr());
                                    EntityPlayer entityPlayer2 = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;
                                    if (entityPlayer2 != null) {
                                        EntityPlayer entityPlayer3;
                                        EntityPlayer entityPlayer4 = entityPlayer3 = entityPlayer2;
                                        boolean bl37 = false;
                                        info.add("Looking Entity UUID: " + entityPlayer4.func_146103_bH().getId());
                                        entityPlayer = entityPlayer3;
                                    } else {
                                        entityPlayer = null;
                                    }
                                    entityLivingBase = entityLivingBase3;
                                } else {
                                    entityLivingBase = null;
                                }
                                object18 = unit;
                                break;
                            }
                            object18 = null;
                            break;
                        }
                        case 2: {
                            void it4;
                            Vec3d it7;
                            unit = obj.func_178782_a();
                            StringBuilder stringBuilder = new StringBuilder().append("Looking Block: ");
                            Object object19 = object17;
                            boolean bl38 = false;
                            String string = "" + it7.func_177958_n() + ' ' + it7.func_177956_o() + ' ' + it7.func_177952_p();
                            object19.add(stringBuilder.append(string).toString());
                            it7 = ((RayTraceResult)obj).field_72307_f;
                            stringBuilder = new StringBuilder().append("Looking Hit: ");
                            object19 = object17;
                            boolean bl39 = false;
                            string = "" + it4.field_72450_a + ' ' + it4.field_72448_b + ' ' + it4.field_72449_c;
                            Object object18 = object19.add(stringBuilder.append(string).toString());
                            break;
                        }
                        default: {
                            Object object18 = Unit.INSTANCE;
                        }
                    }
                    object16 = object5;
                } else {
                    object16 = null;
                }
                Unit unit2 = Unit.INSTANCE;
                bl30.addAll(it6, (Collection)object4);
                list = $this$indexOfFirst$iv;
            } else {
                list = null;
            }
            $this$indexOfFirst$iv = info;
            $i$f$indexOfFirst = false;
            index$iv = 0;
            object4 = $this$indexOfFirst$iv.iterator();
            while (object4.hasNext()) {
                String string;
                String it8 = string = object4.next();
                boolean bl40 = false;
                if (StringsKt.startsWith$default(it8, "Looking at:", false, 2, null)) {
                    n2 = index$iv;
                    break block50;
                }
                ++index$iv;
            }
            n2 = -1;
        }
        object3 = n2;
        it = ((Number)object3).intValue();
        boolean bl41 = false;
        Object object20 = object2 = it != -1 ? object3 : null;
        if (object2 != null) {
            object3 = object2;
            index = ((Number)object3).intValue();
            boolean bl42 = false;
            info.remove(index);
            object = object3;
        } else {
            object = null;
        }
    }

    private final double calculateDamageReduction(EntityPlayer player) {
        double armorPoints = player.func_70658_aO();
        double armorToughness = player.func_110148_a(SharedMonsterAttributes.field_189429_h).func_111126_e();
        double baseReduction = (armorPoints * (double)4 + armorToughness) / 100.0;
        int protectionLevel = 0;
        Iterator iterator2 = player.field_71071_by.field_70460_b.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            ItemStack itemStack = (ItemStack)iterator3.next();
            if (itemStack.func_190926_b()) continue;
            protectionLevel += EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_180310_c, (ItemStack)itemStack);
        }
        double protectionReduction = (double)protectionLevel * 0.04;
        double resistanceReduction = 0.0;
        if (player.func_70644_a(MobEffects.field_76429_m)) {
            PotionEffect resistanceEffect;
            PotionEffect potionEffect = resistanceEffect = player.func_70660_b(MobEffects.field_76429_m);
            Intrinsics.checkNotNull(potionEffect);
            double resistanceAmplifier = (double)potionEffect.func_76458_c() + 1.0;
            resistanceReduction = resistanceAmplifier * 0.2;
        }
        return Math.min(baseReduction + protectionReduction + resistanceReduction, 0.8);
    }

    private static final CharSequence onRenderGuiOverlayDebug$lambda$18$lambda$17$lambda$12(EntityLivingBase it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.func_145782_y());
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[RayTraceResult.Type.values().length];
            try {
                nArray[RayTraceResult.Type.ENTITY.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[RayTraceResult.Type.BLOCK.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.render.particles.Particle;
import net.ccbluex.liquidbounce.injection.extend.ExtendRenderManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.math.RandomUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@ModuleInfo(name="Particles", description="Beautiful", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001fH\u0007J\u001e\u0010 \u001a\u00020\u00172\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0!2\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Particles;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "colorOffsetModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "staticCountValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "attackCountValue", "particles", "Ljava/util/HashMap;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/Particles$ParticleType;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/particles/Particle;", "Lkotlin/collections/HashMap;", "attacks", "", "Lnet/minecraft/entity/EntityLivingBase;", "frustum", "Lnet/minecraft/client/renderer/culling/Frustum;", "onControllerUseEntityAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/events/controller/ControllerUseEntityAttackEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "onMovementInputPre", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renderParticles", "", "partialTicks", "", "ParticleType", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nParticles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Particles.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Particles\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1#2:183\n1#2:187\n1#2:189\n1#2:196\n216#3,2:184\n640#3:186\n216#3,2:190\n2756#4:188\n774#4:192\n865#4,2:193\n2756#4:195\n*S KotlinDebug\n*F\n+ 1 Particles.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Particles\n*L\n72#1:187\n76#1:189\n136#1:196\n63#1:184,2\n72#1:186\n122#1:190,2\n76#1:188\n135#1:192\n135#1:193,2\n136#1:195\n*E\n"})
public final class Particles
extends Module {
    @JvmField
    @NotNull
    public final ColorValue colorValue = new ColorValue("Color", null, false, 6, null);
    @JvmField
    @NotNull
    public final ListValue colorOffsetModeValue;
    @JvmField
    @NotNull
    public final IntegerValue staticCountValue;
    @JvmField
    @NotNull
    public final IntegerValue attackCountValue;
    @NotNull
    private final HashMap<ParticleType, List<Particle>> particles;
    @NotNull
    private Set<EntityLivingBase> attacks;
    @NotNull
    private final Frustum frustum;

    public Particles() {
        super(null, null, null, null, 15, null);
        Object[] objectArray = new String[]{"None", "Y", "XZ", "XYZ", "Random"};
        this.colorOffsetModeValue = new ListValue("ColorOffsetMode", (String[])objectArray, "None");
        this.staticCountValue = new IntegerValue("StaticCount", 2000, new IntRange(0, 5000));
        this.attackCountValue = new IntegerValue("AttackCount", 0, new IntRange(0, 50));
        objectArray = new Pair[]{TuplesKt.to(ParticleType.STATIC, (List)new ArrayList()), TuplesKt.to(ParticleType.ATTACK, (List)new ArrayList())};
        this.particles = MapsKt.hashMapOf(objectArray);
        this.attacks = new LinkedHashSet();
        this.frustum = new Frustum();
    }

    @EventTarget
    public final void onControllerUseEntityAttack(@NotNull ControllerUseEntityAttackEvent event) {
        block0: {
            Intrinsics.checkNotNullParameter(event, "event");
            Entity it = event.getTarget();
            boolean bl2 = false;
            EntityLivingBase entityLivingBase = it instanceof EntityLivingBase ? (EntityLivingBase)it : null;
            if (entityLivingBase == null) break block0;
            EntityLivingBase entityLivingBase2 = entityLivingBase;
            it = entityLivingBase2;
            boolean bl3 = false;
            this.attacks.add((EntityLivingBase)it);
        }
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map $this$forEach$iv = this.particles;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry it = element$iv = iterator2.next();
            boolean bl2 = false;
            ((List)it.getValue()).clear();
        }
    }

    @EventTarget
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Entity entity = MinecraftInstance.mc.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        Entity currentEntity = entity;
        this.frustum.func_78547_a(currentEntity.field_70165_t, currentEntity.field_70163_u, currentEntity.field_70161_v);
        Map $this$onEach$iv = this.particles;
        boolean $i$f$onEach = false;
        Object object = $this$onEach$iv;
        Map $this$onEach_u24lambda_u242$iv = object;
        boolean bl2 = false;
        Iterator iterator2 = $this$onEach_u24lambda_u242$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Iterable iterable;
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl3 = false;
            List list = (List)entry.getValue();
            list.removeIf(arg_0 -> Particles.onMovementInputPre$lambda$6$lambda$4(arg_0 -> Particles.onMovementInputPre$lambda$6$lambda$3(currentEntity, arg_0), arg_0));
            Iterable $this$onEach$iv2 = list;
            boolean $i$f$onEach2 = false;
            Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv2;
            boolean bl4 = false;
            for (Object element$iv2 : $this$onEach_u24lambda_u2418$iv) {
                Particle particle = (Particle)element$iv2;
                boolean bl5 = false;
                particle.updatePosition(currentEntity, this.frustum);
                particle.updateColor(this);
            }
        }
        List<Particle> list = this.particles.get((Object)ParticleType.STATIC);
        if (list != null) {
            List<Particle> it = list;
            boolean bl6 = false;
            Object object2 = ((Number)this.staticCountValue.get()).intValue() - it.size();
            int it2 = ((Number)object2).intValue();
            boolean bl7 = false;
            Object object3 = object = it2 > 0 ? object2 : null;
            if (object != null) {
                object2 = object;
                it2 = ((Number)object2).intValue();
                boolean bl8 = false;
                for (int i2 = 0; i2 < it2; ++i2) {
                    int it3 = i2;
                    boolean bl9 = false;
                    List<Particle> list2 = this.particles.get((Object)ParticleType.STATIC);
                    if (list2 != null) {
                        Vec3d vec3d = currentEntity.func_174791_d().func_72441_c(RandomUtils.INSTANCE.random(-50.0, 50.0), RandomUtils.INSTANCE.random(-10.0, 50.0), RandomUtils.INSTANCE.random(-50.0, 50.0));
                        Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
                        list2.add(new Particle(vec3d, this));
                    }
                }
            }
        }
        this.attacks.removeIf(arg_0 -> Particles.onMovementInputPre$lambda$15(arg_0 -> Particles.onMovementInputPre$lambda$14(this, currentEntity, arg_0), arg_0));
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map $this$forEach$iv = this.particles;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry it = element$iv = iterator2.next();
            boolean bl2 = false;
            this.renderParticles((List)it.getValue(), event.getPartialTicks());
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void renderParticles(List<Particle> particles, float partialTicks) {
        void $this$filterTo$iv$iv;
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GL11.glEnable((int)2848);
        GlStateManager.func_179112_b((int)770, (int)771);
        Iterable $this$filter$iv = particles;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Particle it = (Particle)element$iv$iv;
            boolean bl2 = false;
            if (!it.isNotCulling) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$onEach$iv = (List)destination$iv$iv;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            Particle particle = (Particle)element$iv;
            boolean bl4 = false;
            double x2 = particle.lastPosition.field_72450_a + (particle.position.field_72450_a - particle.lastPosition.field_72450_a) * (double)partialTicks - ExtendRenderManager.INSTANCE.getRenderPosX(MinecraftInstance.mc.getRenderManager());
            double y2 = particle.lastPosition.field_72448_b + (particle.position.field_72448_b - particle.lastPosition.field_72448_b) * (double)partialTicks - ExtendRenderManager.INSTANCE.getRenderPosY(MinecraftInstance.mc.getRenderManager());
            double z2 = particle.lastPosition.field_72449_c + (particle.position.field_72449_c - particle.lastPosition.field_72449_c) * (double)partialTicks - ExtendRenderManager.INSTANCE.getRenderPosZ(MinecraftInstance.mc.getRenderManager());
            int quality = RangesKt.coerceAtMost((int)(particle.distanceToCurrentEntity * (double)4 + (double)10), 350);
            GlStateManager.func_179094_E();
            GlStateManager.func_179137_b((double)x2, (double)y2, (double)z2);
            float scale = 0.04f;
            GlStateManager.func_179152_a((float)(-scale), (float)(-scale), (float)(-scale));
            GlStateManager.func_179114_b((float)(-MinecraftInstance.mc.getRenderManager().field_78735_i), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)MinecraftInstance.mc.getRenderManager().field_78732_j, (float)(MinecraftInstance.mc.getGameSettings().field_74320_O == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
            RenderUtils.drawFilledCircleNoGL(0, 0, 0.7, particle.color.hashCode(), quality);
            if (particle.distanceToCurrentEntity < 4.0) {
                RenderUtils.drawFilledCircleNoGL(0, 0, 1.4, new Color(particle.color.getRed(), particle.color.getGreen(), particle.color.getBlue(), 50).hashCode(), quality);
            }
            if (particle.distanceToCurrentEntity < 20.0) {
                RenderUtils.drawFilledCircleNoGL(0, 0, 2.3, new Color(particle.color.getRed(), particle.color.getGreen(), particle.color.getBlue(), 30).hashCode(), quality);
            }
            GlStateManager.func_179121_F();
        }
        GL11.glDisable((int)2848);
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
        GlStateManager.func_179117_G();
    }

    private static final boolean onMovementInputPre$lambda$6$lambda$3(Entity $currentEntity, Particle particle) {
        Intrinsics.checkNotNullParameter(particle, "particle");
        return $currentEntity.func_70011_f(particle.position.field_72450_a, particle.position.field_72448_b, particle.position.field_72449_c) > 55.0;
    }

    private static final boolean onMovementInputPre$lambda$6$lambda$4(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean onMovementInputPre$lambda$14(Particles this$0, Entity $currentEntity, EntityLivingBase attack) {
        boolean shouldRemove;
        block2: {
            Particles $this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413;
            block1: {
                Intrinsics.checkNotNullParameter(attack, "attack");
                shouldRemove = false;
                $this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413 = this$0;
                boolean bl2 = false;
                if (!($currentEntity.func_70032_d((Entity)attack) > 10.0f)) break block1;
                shouldRemove = true;
                break block2;
            }
            if (attack.field_70737_aN < 0 && attack.func_70089_S()) break block2;
            int n2 = ((Number)$this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413.attackCountValue.get()).intValue();
            for (int i2 = 0; i2 < n2; ++i2) {
                List<Particle> list;
                void $this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413_u24lambda_u2412_u24lambda_u2411;
                Particle particle;
                int it = i2;
                boolean bl3 = false;
                if ($this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413.particles.get((Object)ParticleType.STATIC) == null) continue;
                Particle particle2 = particle = new Particle((Entity)attack, $this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413);
                boolean bl4 = false;
                $this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413_u24lambda_u2412_u24lambda_u2411.updatePosition($currentEntity, $this$onMovementInputPre_u24lambda_u2414_u24lambda_u2413.frustum);
                list.add(particle);
            }
            shouldRemove = true;
        }
        return shouldRemove;
    }

    private static final boolean onMovementInputPre$lambda$15(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Particles$ParticleType;", "", "<init>", "(Ljava/lang/String;I)V", "STATIC", "ATTACK", "DarkMeow"})
    private static final class ParticleType
    extends Enum<ParticleType> {
        public static final /* enum */ ParticleType STATIC = new ParticleType();
        public static final /* enum */ ParticleType ATTACK = new ParticleType();
        private static final /* synthetic */ ParticleType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static ParticleType[] values() {
            return (ParticleType[])$VALUES.clone();
        }

        public static ParticleType valueOf(String value) {
            return Enum.valueOf(ParticleType.class, value);
        }

        @NotNull
        public static EnumEntries<ParticleType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = particleTypeArray = new ParticleType[]{ParticleType.STATIC, ParticleType.ATTACK};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}


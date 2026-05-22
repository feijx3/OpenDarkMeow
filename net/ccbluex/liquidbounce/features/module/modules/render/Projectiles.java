/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.render.projectiles.ProjectilesInfo;
import net.ccbluex.liquidbounce.features.module.modules.render.projectiles.ProjectilesMode;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.injection.extend.ExtendRenderManager;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Projectiles;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesMode;", "Lkotlin/collections/LinkedHashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "defaultColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "targetedColorValue", "lineWidthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "lastTickTargeted", "", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renderPoint", "calcProjectilesInfo", "Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesInfo;", "stack", "Lnet/minecraft/item/ItemStack;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nProjectiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Projectiles.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Projectiles\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,309:1\n1#2:310\n1563#3:311\n1634#3,3:312\n1056#3:315\n1869#3,2:316\n295#3,2:318\n*S KotlinDebug\n*F\n+ 1 Projectiles.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Projectiles\n*L\n40#1:311\n40#1:312,3\n41#1:315\n42#1:316,2\n303#1:318,2\n*E\n"})
public final class Projectiles
extends Module {
    @NotNull
    private final LinkedHashMap<String, ProjectilesMode> modes = new LinkedHashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @NotNull
    private final ColorValue defaultColorValue;
    @NotNull
    private final ColorValue targetedColorValue;
    @NotNull
    private final FloatValue lineWidthValue;
    private boolean lastTickTargeted;
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public Projectiles() {
        super("Projectiles", ModuleCategory.RENDER, null, null, 12, null);
        void it;
        Object object;
        List<Object> list;
        List<Class<ProjectilesMode>> list2;
        List<Class<ProjectilesMode>> it2 = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".projectiles", ProjectilesMode.class);
        boolean bl2 = false;
        List<Class<ProjectilesMode>> list3 = list = !((Collection)it2).isEmpty() ? list2 : null;
        if (list != null) {
            Iterable $this$sortedBy$iv;
            Object object2;
            void $this$mapTo$iv$iv;
            List $this$map$iv = list;
            boolean $i$f$map22 = false;
            List list4 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it3;
                object2 = (Class)item$iv$iv;
                object = destination$iv$iv;
                boolean bl3 = false;
                object.add((ProjectilesMode)it3.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ProjectilesMode it = (ProjectilesMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (ProjectilesMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                }
            });
            if ($this$map$iv != null) {
                void $this$forEach$iv;
                $this$sortedBy$iv = $this$map$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    void it4;
                    ProjectilesMode module = (ProjectilesMode)element$iv;
                    boolean bl4 = false;
                    Object bl3 = object2 = new BoolValue(module.getModeName(), true);
                    List<Value<?>> list5 = this.settingsModuleValues;
                    boolean bl5 = false;
                    module.setLinkedStatValue((BoolValue)it4);
                    list5.add((Value<?>)object2);
                    ((Map)this.modes).put(module.getModeName(), module);
                }
            }
        }
        this.defaultColorValue = new ColorValue("DefaultColor", new ColorValueInfo(255, 160, 255, 0, 8, null), false, 4, null);
        this.targetedColorValue = new ColorValue("TargetedColor", new ColorValueInfo(255, 255, 255, 0, 8, null), false, 4, null);
        this.lineWidthValue = new FloatValue("LineWidth", 1.5f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 3.0f));
        list2 = list = this.settingsModuleValues;
        object = this;
        boolean bl6 = false;
        Value[] valueArray = new Value[]{this.defaultColorValue, this.targetedColorValue, this.lineWidthValue};
        it.addAll(0, (Collection)CollectionsKt.mutableListOf(valueArray));
        ((Projectiles)object).values = list;
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        ColorValue colorValue;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return;
        }
        WorldClient world = worldClient;
        ItemStack itemStack = player.func_184614_ca();
        if (itemStack == null) {
            return;
        }
        ItemStack heldItem = itemStack;
        Item item = heldItem.func_77973_b();
        RenderManager renderManager = MinecraftInstance.mc.getRenderManager();
        ProjectilesInfo projectilesInfo = this.calcProjectilesInfo(heldItem);
        if (projectilesInfo == null) {
            return;
        }
        ProjectilesInfo state = projectilesInfo;
        boolean isBow = state.isBow();
        float motionFactor = state.getMotionFactor();
        float motionSlowdown = state.getMotionSlowdown();
        float gravity = state.getGravity();
        float size = state.getSize();
        Object object = DarkMeow.INSTANCE.getRotationManager().getTask();
        float yaw = object != null && (object = ((RotationTask)object).getRotation()) != null ? ((Rotation)object).yaw : player.field_70177_z;
        Object object2 = DarkMeow.INSTANCE.getRotationManager().getTask();
        float pitch = object2 != null && (object2 = ((RotationTask)object2).getRotation()) != null ? ((Rotation)object2).pitch : player.field_70125_A;
        float yawRadians = yaw / 180.0f * (float)Math.PI;
        float pitchRadians = pitch / 180.0f * (float)Math.PI;
        double posX = ExtendRenderManager.INSTANCE.getRenderPosX(renderManager) - (double)((float)Math.cos(yawRadians) * 0.16f);
        double posY = ExtendRenderManager.INSTANCE.getRenderPosY(renderManager) + (double)player.func_70047_e() - (double)0.1f;
        double posZ = ExtendRenderManager.INSTANCE.getRenderPosZ(renderManager) - (double)((float)Math.sin(yawRadians) * 0.16f);
        double motionX = (double)(-((float)Math.sin(yawRadians)) * (float)Math.cos(pitchRadians)) * (isBow ? 1.0 : 0.4);
        double motionY = (double)(-((float)Math.sin((pitch + (float)(item instanceof ItemPotion && Intrinsics.areEqual(heldItem.func_77973_b(), Items.field_185155_bH) ? -20 : 0)) / 180.0f * (float)Math.PI))) * (isBow ? 1.0 : 0.4);
        double motionZ = (double)((float)Math.cos(yawRadians) * (float)Math.cos(pitchRadians)) * (isBow ? 1.0 : 0.4);
        double distance = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
        motionX /= distance;
        motionY /= distance;
        motionZ /= distance;
        motionX *= (double)motionFactor;
        motionY *= (double)motionFactor;
        motionZ *= (double)motionFactor;
        RayTraceResult landingPosition = null;
        boolean hasLanded = false;
        boolean hitEntity = false;
        Tessellator tessellate = Tessellator.func_178181_a();
        BufferBuilder worldRenderer = tessellate.func_178180_c();
        GL11.glDepthMask((boolean)false);
        int[] nArray = new int[]{3042, 2848};
        RenderUtils.enableGlCap(nArray);
        nArray = new int[]{2929, 3008, 3553};
        RenderUtils.disableGlCap(nArray);
        GlStateManager.func_179112_b((int)770, (int)771);
        GL11.glHint((int)3154, (int)4354);
        boolean bl2 = this.lastTickTargeted;
        if (bl2) {
            colorValue = this.targetedColorValue;
        } else if (!bl2) {
            colorValue = this.defaultColorValue;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ColorUtils.INSTANCE.setGlColor(ColorValue.getColor$default(colorValue, null, 1, null));
        GlStateManager.func_187441_d((float)((Number)this.lineWidthValue.get()).floatValue());
        worldRenderer.func_181668_a(3, DefaultVertexFormats.field_181705_e);
        int calcCount = 0;
        while (!hasLanded && posY > 0.0 && calcCount <= 1000) {
            ++calcCount;
            Vec3d posBefore = new Vec3d(posX, posY, posZ);
            Vec3d posAfter = new Vec3d(posX + motionX, posY + motionY, posZ + motionZ);
            landingPosition = world.func_147447_a(posBefore, posAfter, false, true, false);
            posBefore = new Vec3d(posX, posY, posZ);
            posAfter = new Vec3d(posX + motionX, posY + motionY, posZ + motionZ);
            if (landingPosition != null) {
                hasLanded = true;
                posAfter = new Vec3d(landingPosition.field_72307_f.field_72450_a, landingPosition.field_72307_f.field_72448_b, landingPosition.field_72307_f.field_72449_c);
            }
            AxisAlignedBB arrowBox = new AxisAlignedBB(posX - (double)size, posY - (double)size, posZ - (double)size, posX + (double)size, posY + (double)size, posZ + (double)size).func_72321_a(motionX, motionY, motionZ).func_72321_a(1.0, 1.0, 1.0);
            int chunkMinX = (int)Math.floor((arrowBox.field_72340_a - 2.0) / 16.0);
            int chunkMaxX = (int)Math.floor((arrowBox.field_72336_d + 2.0) / 16.0);
            int chunkMinZ = (int)Math.floor((arrowBox.field_72339_c - 2.0) / 16.0);
            int chunkMaxZ = (int)Math.floor((arrowBox.field_72334_f + 2.0) / 16.0);
            List collidedEntities = new ArrayList();
            int x2 = chunkMinX;
            if (x2 <= chunkMaxX) {
                while (true) {
                    int z2;
                    if ((z2 = chunkMinZ) <= chunkMaxZ) {
                        while (true) {
                            world.func_72964_e(x2, z2).func_177414_a((Entity)player, arrowBox, collidedEntities, null);
                            if (z2 == chunkMaxZ) break;
                            ++z2;
                        }
                    }
                    if (x2 == chunkMaxX) break;
                    ++x2;
                }
            }
            for (Entity possibleEntity : collidedEntities) {
                RayTraceResult possibleEntityLanding;
                AxisAlignedBB possibleEntityBoundingBox;
                if (!possibleEntity.func_70067_L() || Intrinsics.areEqual(possibleEntity, player) || (possibleEntityBoundingBox = possibleEntity.func_174813_aQ().func_72321_a((double)size, (double)size, (double)size)).func_72327_a(posBefore, posAfter) == null) continue;
                hitEntity = true;
                hasLanded = true;
                landingPosition = possibleEntityLanding;
            }
            IBlockState blockState = world.func_180495_p(new BlockPos(posX += motionX, posY += motionY, posZ += motionZ));
            if (Intrinsics.areEqual(blockState.func_177230_c().func_149688_o(blockState), Material.field_151586_h)) {
                motionX *= 0.6;
                motionY *= 0.6;
                motionZ *= 0.6;
            } else {
                motionX *= (double)motionSlowdown;
                motionY *= (double)motionSlowdown;
                motionZ *= (double)motionSlowdown;
            }
            motionY -= (double)gravity;
            worldRenderer.func_181662_b(posX - ExtendRenderManager.INSTANCE.getRenderPosX(renderManager), posY - ExtendRenderManager.INSTANCE.getRenderPosY(renderManager), posZ - ExtendRenderManager.INSTANCE.getRenderPosZ(renderManager)).func_181675_d();
        }
        tessellate.func_78381_a();
        GL11.glPushMatrix();
        GL11.glTranslated((double)(posX - ExtendRenderManager.INSTANCE.getRenderPosX(renderManager)), (double)(posY - ExtendRenderManager.INSTANCE.getRenderPosY(renderManager)), (double)(posZ - ExtendRenderManager.INSTANCE.getRenderPosZ(renderManager)));
        if (landingPosition != null) {
            EnumFacing enumFacing = landingPosition.field_178784_b;
            Intrinsics.checkNotNull(enumFacing);
            switch (enumFacing.func_176740_k().ordinal()) {
                case 0: {
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    break;
                }
                case 2: {
                    GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
            }
            this.lastTickTargeted = hitEntity;
        }
        this.renderPoint();
        GL11.glPopMatrix();
        GL11.glDepthMask((boolean)true);
        RenderUtils.resetCaps();
        GlStateManager.func_179117_G();
    }

    private final void renderPoint() {
        int i2;
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)5.0f);
        GL11.glBegin((int)2);
        for (int i3 = 0; i3 < 6; ++i3) {
            double angle = (double)i3 * Math.PI / (double)3;
            GL11.glVertex3d((double)(0.5 * Math.cos(angle)), (double)0.0, (double)(0.5 * Math.sin(angle)));
        }
        GL11.glEnd();
        double smallHexRadius = 0.25;
        int n2 = 0;
        double[][] dArrayArray = new double[6][];
        while (n2 < 6) {
            int n3 = n2++;
            dArrayArray[n3] = new double[3];
        }
        double[][] midPoints = dArrayArray;
        for (i2 = 0; i2 < 6; ++i2) {
            double angle1 = (double)i2 * Math.PI / (double)3;
            double angle2 = (double)(i2 + 1) * Math.PI / (double)3;
            midPoints[i2][0] = 0.5 * (Math.cos(angle1) + Math.cos(angle2)) * 0.5;
            midPoints[i2][1] = 0.0;
            midPoints[i2][2] = 0.5 * (Math.sin(angle1) + Math.sin(angle2)) * 0.5;
        }
        GL11.glLineWidth((float)6.0f);
        GL11.glBegin((int)2);
        for (i2 = 0; i2 < 6; ++i2) {
            double angle = (double)i2 * Math.PI / (double)3;
            GL11.glVertex3d((double)(smallHexRadius * Math.cos(angle)), (double)0.0, (double)(smallHexRadius * Math.sin(angle)));
        }
        GL11.glEnd();
        GL11.glLineWidth((float)4.0f);
        GL11.glBegin((int)1);
        for (i2 = 0; i2 < 6; ++i2) {
            double angle = (double)i2 * Math.PI / (double)3;
            GL11.glVertex3d((double)midPoints[i2][0], (double)midPoints[i2][1], (double)midPoints[i2][2]);
            GL11.glVertex3d((double)(smallHexRadius * Math.cos(angle)), (double)0.0, (double)(smallHexRadius * Math.sin(angle)));
        }
        GL11.glEnd();
        GL11.glLineWidth((float)5.0f);
        GL11.glBegin((int)1);
        for (i2 = 0; i2 < 6; ++i2) {
            double angle = (double)i2 * Math.PI / (double)3;
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)(smallHexRadius * Math.cos(angle)), (double)0.0, (double)(smallHexRadius * Math.sin(angle)));
        }
        GL11.glEnd();
    }

    private final ProjectilesInfo calcProjectilesInfo(ItemStack stack) {
        Object v2;
        block1: {
            Collection<ProjectilesMode> collection = this.modes.values();
            Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
            Iterable $this$firstOrNull$iv = collection;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                ProjectilesMode it = (ProjectilesMode)element$iv;
                boolean bl2 = false;
                Item item = stack.func_77973_b();
                Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
                if (!it.canHandleProjectiles(item)) continue;
                v2 = element$iv;
                break block1;
            }
            v2 = null;
        }
        ProjectilesMode projectilesMode = v2;
        return projectilesMode != null ? projectilesMode.doHandleProjectiles() : null;
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }
}


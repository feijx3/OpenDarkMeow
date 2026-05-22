/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.entity.Entity
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import com.google.gson.JsonElement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.StorageEspMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.Render3DUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001dH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/StorageESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "renderModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "renderOutlineWidthValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/StorageEspMode;", "getModes", "()Ljava/util/Map;", "renderMaps", "Lnet/minecraft/util/math/BlockPos;", "Ljava/awt/Color;", "getRenderMaps", "frustum", "Lnet/minecraft/client/renderer/culling/Frustum;", "getFrustum", "()Lnet/minecraft/client/renderer/culling/Frustum;", "onEnable", "", "onDisable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStorageESP.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageESP.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/StorageESP\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,135:1\n1#2:136\n1563#3:137\n1634#3,3:138\n1056#3:141\n1869#3:142\n1869#3,2:143\n1870#3:145\n774#3:146\n865#3,2:147\n1869#3,2:149\n774#3:151\n865#3,2:152\n1869#3,2:154\n216#4,2:156\n*S KotlinDebug\n*F\n+ 1 StorageESP.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/StorageESP\n*L\n45#1:137\n45#1:138,3\n46#1:141\n47#1:142\n68#1:143,2\n47#1:145\n86#1:146\n86#1:147,2\n86#1:149,2\n87#1:151\n87#1:152,2\n87#1:154,2\n124#1:156,2\n*E\n"})
public final class StorageESP
extends Module {
    @JvmField
    @NotNull
    public final ListValue renderModeValue;
    @JvmField
    @NotNull
    public final FloatValue renderOutlineWidthValue;
    @NotNull
    private final Map<String, StorageEspMode> modes;
    @NotNull
    private final Map<BlockPos, Color> renderMaps;
    @NotNull
    private final Frustum frustum;

    /*
     * WARNING - void declaration
     */
    public StorageESP() {
        block5: {
            void $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            void $this$renderOutlineWidthValue_u24lambda_u241;
            Object $this$renderOutlineWidthValue_u24lambda_u240;
            super("StorageESP", ModuleCategory.RENDER, null, null, 12, null);
            Object object = new String[]{"Fill", "Outline"};
            this.renderModeValue = new ListValue("RenderMode", (String[])object, "Fill");
            Object object2 = object = new FloatValue("RenderOutlineWidth", 2.0f, (ClosedRange<Float>)RangesKt.rangeTo(1.0f, 2.0f));
            Object object3 = this;
            boolean bl2 = false;
            $this$renderOutlineWidthValue_u24lambda_u240.setSuperValue(this.renderModeValue);
            $this$renderOutlineWidthValue_u24lambda_u240 = object;
            boolean bl3 = false;
            $this$renderOutlineWidthValue_u24lambda_u241.setSuperValueMeta("Outline");
            ((StorageESP)object3).renderOutlineWidthValue = object;
            this.modes = new LinkedHashMap();
            this.renderMaps = new LinkedHashMap();
            this.frustum = new Frustum();
            Object it = object2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".storage_esp.impl", StorageEspMode.class);
            boolean bl4 = false;
            Object object4 = object = !((Collection)it).isEmpty() ? object2 : null;
            if (object == null) break block5;
            Iterable $this$map$iv = (Iterable)object;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                object3 = destination$iv$iv;
                boolean bl5 = false;
                object3.add((StorageEspMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    StorageEspMode it = (StorageEspMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (StorageEspMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list != null) {
                Unit unit;
                void $this$forEach$iv;
                Iterable $i$f$sortedBy2 = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    StorageEspMode module = (StorageEspMode)element$iv;
                    boolean bl6 = false;
                    String bl5 = module.getName();
                    BoolValue modulesValue2 = new BoolValue(this, module, bl5){
                        final /* synthetic */ StorageESP this$0;
                        final /* synthetic */ StorageEspMode $module;
                        {
                            this.this$0 = $receiver;
                            this.$module = $module;
                            super($super_call_param$1, false);
                        }

                        protected void onChanged(boolean oldValue, boolean newValue) {
                            if (this.this$0.getState()) {
                                boolean bl2 = newValue;
                                if (bl2) {
                                    this.$module.onEnable();
                                } else if (!bl2) {
                                    this.$module.onDisable();
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }

                        public void fromJson(JsonElement element) {
                            Intrinsics.checkNotNullParameter(element, "element");
                            super.fromJson(element);
                            this.onChanged((Boolean)this.getValue(), (Boolean)this.getValue());
                        }
                    };
                    module.setInstance(this);
                    module.setLinkedStatValue(modulesValue2);
                    this.getValues().add(modulesValue2);
                    Iterable $this$forEach$iv2 = module.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl7 = false;
                        value.setName(module.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modulesValue2);
                        }
                        this.getValues().add(value);
                    }
                    this.modes.put(module.getName(), module);
                }
                Unit it3 = unit = Unit.INSTANCE;
                boolean bl8 = false;
                this.getValues().add(this.renderModeValue);
                this.getValues().add(this.renderOutlineWidthValue);
            }
        }
    }

    @NotNull
    public final Map<String, StorageEspMode> getModes() {
        return this.modes;
    }

    @NotNull
    public final Map<BlockPos, Color> getRenderMaps() {
        return this.renderMaps;
    }

    @NotNull
    public final Frustum getFrustum() {
        return this.frustum;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            StorageEspMode it = (StorageEspMode)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            StorageEspMode it = (StorageEspMode)element$iv;
            boolean bl3 = false;
            it.onEnable();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onDisable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.modes.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            StorageEspMode it = (StorageEspMode)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            StorageEspMode it = (StorageEspMode)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
    }

    @EventTarget
    public final void onUpdate(@NotNull UpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Entity entity = MinecraftInstance.mc.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        Entity renderEntity = entity;
        BuildersKt.runBlocking$default(null, new Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends BlockPos, ? extends Color>>>, Object>(this, renderEntity, event, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ StorageESP this$0;
            final /* synthetic */ Entity $renderEntity;
            final /* synthetic */ UpdateEvent $event;
            {
                this.this$0 = $receiver;
                this.$renderEntity = $renderEntity;
                this.$event = $event;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (CoroutineScope)this.L$0;
                var14_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure($result);
                        this.this$0.getFrustum().func_78547_a(this.$renderEntity.field_70165_t, this.$renderEntity.field_70163_u, this.$renderEntity.field_70161_v);
                        v0 = this.$event.getPlayer().field_70170_p.field_147482_g;
                        Intrinsics.checkNotNullExpressionValue(v0, "loadedTileEntityList");
                        var3_4 /* !! */  = v0;
                        var4_5 = this.this$0;
                        $i$f$filter = false;
                        var6_8 = $this$filter$iv;
                        destination$iv$iv = new ArrayList<E>();
                        $i$f$filterTo = false;
                        for (T element$iv$iv : $this$filterTo$iv$iv) {
                            tile = (TileEntity)element$iv$iv;
                            $i$a$-filter-StorageESP$onUpdate$1$1 = false;
                            if (!var4_5.getFrustum().func_78546_a(tile.getRenderBoundingBox())) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = (List)destination$iv$iv;
                        var4_5 = this.$renderEntity;
                        $i$f$filter = false;
                        $this$filterTo$iv$iv = $this$filter$iv;
                        destination$iv$iv = new ArrayList<E>();
                        $i$f$filterTo = false;
                        for (T element$iv$iv : $this$filterTo$iv$iv) {
                            tile = (TileEntity)element$iv$iv;
                            $i$a$-filter-StorageESP$onUpdate$1$2 = false;
                            if (!var4_5.field_70170_p.func_175723_af().func_177746_a(tile.func_174877_v())) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = (List)destination$iv$iv;
                        var4_5 = this.this$0;
                        $i$f$map = false;
                        $this$filterTo$iv$iv = $this$map$iv;
                        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $i$f$mapTo = false;
                        for (T item$iv$iv : $this$mapTo$iv$iv) {
                            tile = (TileEntity)item$iv$iv;
                            var13_16 = destination$iv$iv;
                            $i$a$-map-StorageESP$onUpdate$1$3 = false;
                            var13_16.add(BuildersKt.async$default((CoroutineScope)$this$runBlocking, null, null, new Function2<CoroutineScope, Continuation<? super Pair<? extends BlockPos, ? extends Color>>, Object>(var4_5, tile, null){
                                int label;
                                final /* synthetic */ StorageESP this$0;
                                final /* synthetic */ TileEntity $tile;
                                {
                                    this.this$0 = $receiver;
                                    this.$tile = $tile;
                                    super(2, $completion);
                                }

                                /*
                                 * Enabled force condition propagation
                                 * Lifted jumps to return sites
                                 */
                                public final Object invokeSuspend(Object $result) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            Object it;
                                            Iterator<T> $this$filterTo$iv$iv;
                                            ResultKt.throwOnFailure($result);
                                            Iterable $this$filter$iv = this.this$0.getModes().values();
                                            boolean $i$f$filter = false;
                                            Iterable iterable = $this$filter$iv;
                                            Collection destination$iv$iv = new ArrayList<E>();
                                            boolean $i$f$filterTo = false;
                                            Iterator<T> iterator2 = $this$filterTo$iv$iv.iterator();
                                            while (iterator2.hasNext()) {
                                                T element$iv$iv = iterator2.next();
                                                StorageEspMode it2 = (StorageEspMode)element$iv$iv;
                                                boolean bl2 = false;
                                                if (!((Boolean)it2.getLinkedStatValue().get()).booleanValue()) continue;
                                                destination$iv$iv.add(element$iv$iv);
                                            }
                                            Iterable iterable2 = (List)destination$iv$iv;
                                            TileEntity tileEntity = this.$tile;
                                            $this$filterTo$iv$iv = iterable2.iterator();
                                            do {
                                                if (!$this$filterTo$iv$iv.hasNext()) return null;
                                                it = (StorageEspMode)$this$filterTo$iv$iv.next();
                                                boolean bl3 = false;
                                                Intrinsics.checkNotNull(tileEntity);
                                            } while ((it = ((StorageEspMode)it).getTileEntityColor(tileEntity)) == null);
                                            Object object = it;
                                            Object object2 = object;
                                            if (object2 == null) return null;
                                            iterable2 = object2;
                                            tileEntity = this.$tile;
                                            Iterable color = iterable2;
                                            boolean bl4 = false;
                                            Pair<BlockPos, Iterable> pair = TuplesKt.to(tileEntity.func_174877_v(), color);
                                            return pair;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                    return (Continuation)((Object)new /* invalid duplicate definition of identical inner class */);
                                }

                                public final Object invoke(CoroutineScope p1, Continuation<? super Pair<? extends BlockPos, ? extends Color>> p2) {
                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            }, 3, null));
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$runBlocking);
                        this.label = 1;
                        v1 = AwaitKt.awaitAll((List)destination$iv$iv, (Continuation)this);
                        if (v1 == var14_3) {
                            return var14_3;
                        }
                        ** GOTO lbl58
                    }
                    case 1: {
                        ResultKt.throwOnFailure($result);
                        v1 = $result;
lbl58:
                        // 2 sources

                        var3_4 /* !! */  = CollectionsKt.filterNotNull((Iterable)v1);
                        var4_5 = this.this$0;
                        it = var3_4 /* !! */ ;
                        $i$a$-also-StorageESP$onUpdate$1$4 = false;
                        var4_5.getRenderMaps().clear();
                        MapsKt.putAll(var4_5.getRenderMaps(), (Iterable)it);
                        return var3_4 /* !! */ ;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends BlockPos, ? extends Color>>>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)((Object)function2);
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super List<? extends Pair<? extends BlockPos, ? extends Color>>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Entity entity = MinecraftInstance.mc.getRenderViewEntity();
        if (entity == null) {
            return;
        }
        Entity renderEntity = entity;
        GlStateManager.func_179132_a((boolean)false);
        GlStateManager.func_179097_i();
        Map<BlockPos, Color> $this$forEach$iv = this.renderMaps;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<BlockPos, Color>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<BlockPos, Color> element$iv;
            Map.Entry<BlockPos, Color> entry = element$iv = iterator2.next();
            boolean bl2 = false;
            BlockPos pos = entry.getKey();
            Color color = entry.getValue();
            String string = (String)this.renderModeValue.get();
            if (Intrinsics.areEqual(string, "Fill")) {
                Render3DUtils.drawBlockBoxFilled$default(Render3DUtils.INSTANCE, renderEntity, pos, event.getPartialTicks(), color, false, null, 0.0f, 56, null);
                continue;
            }
            if (!Intrinsics.areEqual(string, "Outline")) continue;
            Render3DUtils.drawBlockBoxOutlined$default(Render3DUtils.INSTANCE, renderEntity, pos, event.getPartialTicks(), color, (Float)this.renderOutlineWidthValue.get(), false, null, 0.0f, 112, null);
        }
        GlStateManager.func_179098_w();
        GlStateManager.func_179126_j();
        GlStateManager.func_179132_a((boolean)true);
    }
}


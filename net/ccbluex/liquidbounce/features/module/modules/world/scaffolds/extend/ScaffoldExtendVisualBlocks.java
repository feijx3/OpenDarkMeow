/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.visual_blocks.ScaffoldExtendVisualBlockMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendVisualBlocks;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldExtend;", "<init>", "()V", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "visualBlockModes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/ScaffoldExtendVisualBlockMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onPlaced", "pos", "Lnet/minecraft/util/math/BlockPos;", "facing", "Lnet/minecraft/util/EnumFacing;", "result", "Lnet/minecraft/util/EnumActionResult;", "onDisable", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldExtendVisualBlocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldExtendVisualBlocks.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendVisualBlocks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,71:1\n1#2:72\n1#2:89\n1563#3:73\n1634#3,3:74\n1056#3:77\n1869#3:78\n1869#3,2:79\n1870#3:81\n1869#3,2:86\n2756#3:88\n37#4:82\n36#4,3:83\n*S KotlinDebug\n*F\n+ 1 ScaffoldExtendVisualBlocks.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendVisualBlocks\n*L\n66#1:89\n30#1:73\n30#1:74,3\n31#1:77\n32#1:78\n34#1:79,2\n32#1:81\n61#1:86,2\n66#1:88\n49#1:82\n49#1:83,3\n*E\n"})
public final class ScaffoldExtendVisualBlocks
extends ScaffoldExtend {
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @NotNull
    private final Map<String, ScaffoldExtendVisualBlockMode> visualBlockModes = new LinkedHashMap();
    @JvmField
    @NotNull
    public final ListValue modeValue = new ListValue("Mode", null, "DarkMeow", 2, null);
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public ScaffoldExtendVisualBlocks() {
        super("VisualBlocks", true);
        List<Class<ScaffoldExtendVisualBlockMode>> list;
        List<Class<ScaffoldExtendVisualBlockMode>> list2;
        this.settingsModuleValues.add(this.modeValue);
        List<Class<ScaffoldExtendVisualBlockMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".visual_blocks.impl", ScaffoldExtendVisualBlockMode.class);
        boolean bl2 = false;
        List<Class<ScaffoldExtendVisualBlockMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            void $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((ScaffoldExtendVisualBlockMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ScaffoldExtendVisualBlockMode it = (ScaffoldExtendVisualBlockMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (ScaffoldExtendVisualBlockMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list4 != null) {
                Unit unit;
                void $this$forEach$iv;
                Iterable $i$f$sortedBy2 = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    ScaffoldExtendVisualBlockMode it3 = (ScaffoldExtendVisualBlockMode)element$iv;
                    boolean bl4 = false;
                    it3.setInstance(this);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        value.setName("VisualBlocks" + it3.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(this.modeValue);
                            value.setSuperValueMeta(it3.getName());
                        }
                        this.settingsModuleValues.add(value);
                    }
                    this.visualBlockModes.put(it3.getName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
                Unit it4 = unit = Unit.INSTANCE;
                boolean bl6 = false;
                Collection $this$toTypedArray$iv = this.visualBlockModes.keySet();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                this.modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
        this.values = this.settingsModuleValues;
    }

    @EventTarget
    public final void onRender3D(@NotNull Render3DEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ScaffoldExtendVisualBlockMode scaffoldExtendVisualBlockMode = this.visualBlockModes.get(this.modeValue.get());
        if (scaffoldExtendVisualBlockMode != null) {
            scaffoldExtendVisualBlockMode.onRender(event.getPartialTicks());
        }
        GlStateManager.func_179098_w();
    }

    @Override
    public void onPlaced(@NotNull BlockPos pos, @NotNull EnumFacing facing, @NotNull EnumActionResult result) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(facing, "facing");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result == EnumActionResult.SUCCESS) {
            Iterable $this$forEach$iv = this.visualBlockModes.values();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ScaffoldExtendVisualBlockMode it = (ScaffoldExtendVisualBlockMode)element$iv;
                boolean bl2 = false;
                BlockPos blockPos = pos.func_177972_a(facing);
                Intrinsics.checkNotNullExpressionValue(blockPos, "offset(...)");
                it.onPlaced(blockPos);
            }
        }
    }

    @Override
    public void onDisable() {
        Iterable iterable;
        Iterable $this$onEach$iv = this.visualBlockModes.values();
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl2 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            ScaffoldExtendVisualBlockMode it = (ScaffoldExtendVisualBlockMode)element$iv;
            boolean bl3 = false;
            it.onClear();
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }
}


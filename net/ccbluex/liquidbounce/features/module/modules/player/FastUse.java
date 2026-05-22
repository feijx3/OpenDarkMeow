/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBucketMilk
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemPotion
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.player.fastuses.FastUseMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="FastUse", category=ModuleCategory.PLAYER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/FastUse;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/fastuses/FastUseMode;", "Lkotlin/collections/LinkedHashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "itemFood", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "itemBucketMilkFood", "itemPotion", "isActive", "", "onEnable", "", "onDisable", "tag", "getTag", "()Ljava/lang/String;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFastUse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastUse.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/FastUse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,67:1\n1#2:68\n1563#3:69\n1634#3,3:70\n1056#3:73\n1869#3:74\n1869#3,2:75\n1870#3:77\n37#4:78\n36#4,3:79\n*S KotlinDebug\n*F\n+ 1 FastUse.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/FastUse\n*L\n25#1:69\n25#1:70,3\n26#1:73\n27#1:74\n29#1:75,2\n27#1:77\n38#1:78\n38#1:79,3\n*E\n"})
public final class FastUse
extends Module {
    @NotNull
    public static final FastUse INSTANCE;
    @NotNull
    private static final LinkedHashMap<String, FastUseMode> modes;
    @NotNull
    private static final List<Value<?>> settingsModuleValues;
    @NotNull
    private static final ListValue modeValue;
    @NotNull
    private static final BoolValue itemFood;
    @NotNull
    private static final BoolValue itemBucketMilkFood;
    @NotNull
    private static final BoolValue itemPotion;
    @NotNull
    private static final List<Value<?>> values;

    private FastUse() {
        super(null, null, null, null, 15, null);
    }

    @NotNull
    public final ListValue getModeValue() {
        return modeValue;
    }

    public final boolean isActive() {
        boolean bl2;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP != null) {
            EntityPlayerSP it = entityPlayerSP;
            boolean bl3 = false;
            Item item = it.func_184607_cu().func_77973_b();
            bl2 = item instanceof ItemFood ? (Boolean)itemFood.get() : (item instanceof ItemBucketMilk ? (Boolean)itemBucketMilkFood.get() : (item instanceof ItemPotion ? (Boolean)itemPotion.get() : false));
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public void onEnable() {
        block0: {
            FastUseMode fastUseMode = modes.get(modeValue.get());
            if (fastUseMode == null) break block0;
            fastUseMode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        block0: {
            FastUseMode fastUseMode = modes.get(modeValue.get());
            if (fastUseMode == null) break block0;
            fastUseMode.onDisable();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)modeValue.get();
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    private static final boolean lambda$5$lambda$4$lambda$3(FastUseMode $it) {
        return Intrinsics.areEqual(modeValue.get(), $it.getModeName());
    }

    public static final /* synthetic */ LinkedHashMap access$getModes$p() {
        return modes;
    }

    /*
     * WARNING - void declaration
     */
    static {
        Object object;
        String[] stringArray;
        INSTANCE = new FastUse();
        modes = new LinkedHashMap();
        settingsModuleValues = new ArrayList();
        String[] it = stringArray = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".fastuses", FastUseMode.class);
        boolean bl2 = false;
        Object object2 = object = !((Collection)it).isEmpty() ? stringArray : null;
        if (object != null) {
            void $this$mapTo$iv$iv;
            List $this$map$iv = (List)object;
            boolean $i$f$map = false;
            List list = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((FastUseMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    FastUseMode it = (FastUseMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (FastUseMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                }
            });
            if ($this$map$iv != null) {
                Iterable $this$forEach$iv = $this$map$iv;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    FastUseMode it3 = (FastUseMode)element$iv;
                    boolean bl4 = false;
                    it3.setInstance(INSTANCE);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        settingsModuleValues.add(value.displayable(() -> FastUse.lambda$5$lambda$4$lambda$3(it3)));
                    }
                    ((Map)modes).put(it3.getModeName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
            }
        }
        Set<String> set = modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
        Collection $this$toTypedArray$iv = set;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        object = thisCollection$iv.toArray(new String[0]);
        modeValue = new ListValue((String[])object){

            protected void onChanged(String oldValue, String newValue) {
                block2: {
                    Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                    if (!FastUse.INSTANCE.getState()) break block2;
                    FastUseMode fastUseMode = (FastUseMode)FastUse.access$getModes$p().get(oldValue);
                    if (fastUseMode != null) {
                        fastUseMode.onDisable();
                    }
                    FastUseMode fastUseMode2 = (FastUseMode)FastUse.access$getModes$p().get(newValue);
                    if (fastUseMode2 != null) {
                        fastUseMode2.onEnable();
                    }
                }
            }
        };
        itemFood = new BoolValue("ItemFood", true);
        itemBucketMilkFood = new BoolValue("ItemBucketMilk", true);
        itemPotion = new BoolValue("ItemPotion", true);
        Object it4 = object = settingsModuleValues;
        boolean bl6 = false;
        Value[] valueArray = new Value[4];
        valueArray[0] = modeValue;
        valueArray[1] = itemFood;
        valueArray[2] = itemBucketMilkFood;
        valueArray[3] = itemPotion;
        it4.addAll(0, (Collection)CollectionsKt.mutableListOf(valueArray));
        values = object;
    }
}


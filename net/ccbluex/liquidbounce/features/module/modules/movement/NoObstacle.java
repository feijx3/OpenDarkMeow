/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement;

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
import net.ccbluex.liquidbounce.features.module.modules.movement.noobstacles.NoObstacleMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoObstacle", category=ModuleCategory.MOVEMENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoObstacle;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/noobstacles/NoObstacleMode;", "Lkotlin/collections/LinkedHashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onEnable", "", "onDisable", "tag", "getTag", "()Ljava/lang/String;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoObstacle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoObstacle.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/NoObstacle\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,52:1\n1#2:53\n1563#3:54\n1634#3,3:55\n1056#3:58\n1869#3:59\n1869#3,2:60\n1870#3:62\n37#4:63\n36#4,3:64\n*S KotlinDebug\n*F\n+ 1 NoObstacle.kt\nnet/ccbluex/liquidbounce/features/module/modules/movement/NoObstacle\n*L\n21#1:54\n21#1:55,3\n22#1:58\n23#1:59\n25#1:60,2\n23#1:62\n34#1:63\n34#1:64,3\n*E\n"})
public final class NoObstacle
extends Module {
    @NotNull
    private final LinkedHashMap<String, NoObstacleMode> modes = new LinkedHashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public NoObstacle() {
        super(null, null, null, null, 15, null);
        void it;
        Object object;
        Object object2;
        String[] stringArray;
        String[] it2 = stringArray = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".noobstacles", NoObstacleMode.class);
        boolean bl2 = false;
        Object object3 = object2 = !((Collection)it2).isEmpty() ? stringArray : null;
        if (object2 != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            List $this$map$iv = (List)object2;
            boolean $i$f$map22 = false;
            List list = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it3;
                Class clazz = (Class)item$iv$iv;
                object = destination$iv$iv;
                boolean bl3 = false;
                object.add((NoObstacleMode)it3.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    NoObstacleMode it = (NoObstacleMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (NoObstacleMode)b2;
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
                    NoObstacleMode it4 = (NoObstacleMode)element$iv;
                    boolean bl4 = false;
                    it4.setInstance(this);
                    Iterable $this$forEach$iv2 = it4.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        this.settingsModuleValues.add(value.displayable(() -> NoObstacle.lambda$5$lambda$4$lambda$3(this, it4)));
                    }
                    ((Map)this.modes).put(it4.getModeName(), it4);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it4);
                    EventManager.registerListener$default(eventManager, it4, false, false, 6, null);
                }
            }
        }
        Set<String> set = this.modes.keySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
        Object $this$toTypedArray$iv = set;
        boolean $i$f$toTypedArray = false;
        Object thisCollection$iv = $this$toTypedArray$iv;
        object2 = thisCollection$iv.toArray(new String[0]);
        this.modeValue = new ListValue(this, (String[])object2){
            final /* synthetic */ NoObstacle this$0;
            {
                this.this$0 = $receiver;
                super("Mode", $super_call_param$1, "OldGrim");
            }

            protected void onChanged(String oldValue, String newValue) {
                block2: {
                    Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                    if (!this.this$0.getState()) break block2;
                    NoObstacleMode noObstacleMode = (NoObstacleMode)NoObstacle.access$getModes$p(this.this$0).get(oldValue);
                    if (noObstacleMode != null) {
                        noObstacleMode.onDisable();
                    }
                    NoObstacleMode noObstacleMode2 = (NoObstacleMode)NoObstacle.access$getModes$p(this.this$0).get(newValue);
                    if (noObstacleMode2 != null) {
                        noObstacleMode2.onEnable();
                    }
                }
            }
        };
        $this$toTypedArray$iv = object2 = this.settingsModuleValues;
        object = this;
        boolean bl6 = false;
        ListValue[] listValueArray = new ListValue[]{this.modeValue};
        it.addAll(0, (Collection)CollectionsKt.mutableListOf(listValueArray));
        ((NoObstacle)object).values = object2;
    }

    @NotNull
    public final ListValue getModeValue() {
        return this.modeValue;
    }

    @Override
    public void onEnable() {
        block0: {
            NoObstacleMode noObstacleMode = this.modes.get(this.modeValue.get());
            if (noObstacleMode == null) break block0;
            noObstacleMode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        block0: {
            NoObstacleMode noObstacleMode = this.modes.get(this.modeValue.get());
            if (noObstacleMode == null) break block0;
            noObstacleMode.onDisable();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return (String)this.modeValue.get();
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    private static final boolean lambda$5$lambda$4$lambda$3(NoObstacle this$0, NoObstacleMode $it) {
        return Intrinsics.areEqual(this$0.modeValue.get(), $it.getModeName());
    }

    public static final /* synthetic */ LinkedHashMap access$getModes$p(NoObstacle $this) {
        return $this.modes;
    }
}


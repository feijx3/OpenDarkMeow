/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player;

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
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.player.game_helper.GameHelperModule;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/GameHelper;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/game_helper/GameHelperModule;", "onEnable", "", "onDisable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGameHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameHelper.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/GameHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,67:1\n1563#2:68\n1634#2,3:69\n1056#2:72\n1869#2:73\n1869#2,2:74\n1870#2:76\n774#2:77\n865#2,2:78\n1869#2,2:80\n774#2:82\n865#2,2:83\n1869#2,2:85\n*S KotlinDebug\n*F\n+ 1 GameHelper.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/GameHelper\n*L\n19#1:68\n19#1:69,3\n20#1:72\n21#1:73\n38#1:74,2\n21#1:76\n57#1:77\n57#1:78,2\n58#1:80,2\n64#1:82\n64#1:83,2\n65#1:85,2\n*E\n"})
public final class GameHelper
extends Module {
    @NotNull
    private final Map<String, GameHelperModule> modes = new LinkedHashMap();

    /*
     * WARNING - void declaration
     */
    public GameHelper() {
        super("GameHelper", ModuleCategory.PLAYER, null, null, 12, null);
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".game_helper", GameHelperModule.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((GameHelperModule)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                GameHelperModule it = (GameHelperModule)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getName());
                it = (GameHelperModule)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object item$iv$iv;
            GameHelperModule it = (GameHelperModule)element$iv;
            boolean bl3 = false;
            item$iv$iv = it.getName();
            BoolValue modulesValue2 = new BoolValue(this, it, (String)item$iv$iv){
                final /* synthetic */ GameHelper this$0;
                final /* synthetic */ GameHelperModule $it;
                {
                    this.this$0 = $receiver;
                    this.$it = $it;
                    super($super_call_param$1, false);
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    if (this.this$0.getState()) {
                        boolean bl2 = newValue;
                        if (bl2) {
                            this.$it.onEnable();
                        } else if (!bl2) {
                            this.$it.onDisable();
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            };
            it.setInstance(this);
            it.setLinkedStatValue(modulesValue2);
            this.getValues().add(modulesValue2);
            Iterable $this$forEach$iv2 = it.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                value.setName(it.getName() + value.getName());
                if (value.getSuperValue() == null) {
                    value.setSuperValue(modulesValue2);
                }
                this.getValues().add(value);
            }
            this.modes.put(it.getName(), it);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it);
            EventManager.registerListener$default(eventManager, it, false, false, 6, null);
        }
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
            GameHelperModule it = (GameHelperModule)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GameHelperModule it = (GameHelperModule)element$iv;
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
            GameHelperModule it = (GameHelperModule)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GameHelperModule it = (GameHelperModule)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
    }
}


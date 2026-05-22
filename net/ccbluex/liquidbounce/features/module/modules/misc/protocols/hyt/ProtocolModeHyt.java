/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.ProtocolMode;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.HytModule;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/ProtocolModeHyt;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/ProtocolMode;", "<init>", "()V", "modes", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/HytModule;", "Lkotlin/collections/HashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "onEnable", "", "onDisable", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nProtocolModeHyt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProtocolModeHyt.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/ProtocolModeHyt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,34:1\n1563#2:35\n1634#2,3:36\n1056#2:39\n1869#2:40\n1869#2,2:41\n1870#2:43\n216#3,2:44\n216#3,2:46\n*S KotlinDebug\n*F\n+ 1 ProtocolModeHyt.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/ProtocolModeHyt\n*L\n15#1:35\n15#1:36,3\n16#1:39\n17#1:40\n20#1:41,2\n17#1:43\n29#1:44,2\n30#1:46,2\n*E\n"})
public final class ProtocolModeHyt
extends ProtocolMode {
    @NotNull
    private final HashMap<String, HytModule> modes = new HashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public ProtocolModeHyt() {
        super("Hyt");
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".modules", HytModule.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((HytModule)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                HytModule it = (HytModule)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getModeName());
                it = (HytModule)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            HytModule it = (HytModule)element$iv;
            boolean bl3 = false;
            it.setInstance(this);
            Iterable $this$forEach$iv2 = it.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                this.settingsModuleValues.add(value);
            }
            ((Map)this.modes).put(it.getModeName(), it);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it);
            EventManager.registerListener$default(eventManager, it, false, false, 6, null);
        }
        this.values = this.settingsModuleValues;
    }

    @Override
    public void onEnable() {
        Map $this$forEach$iv = this.modes;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry it = element$iv = iterator2.next();
            boolean bl2 = false;
            ((HytModule)it.getValue()).onEnable();
        }
    }

    @Override
    public void onDisable() {
        Map $this$forEach$iv = this.modes;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry it = element$iv = iterator2.next();
            boolean bl2 = false;
            ((HytModule)it.getValue()).onDisable();
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }
}


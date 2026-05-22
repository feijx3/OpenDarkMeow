/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
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
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPostEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPreEvent;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.GAppleSpoofMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0016R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendSpoofCount;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "spoofModes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/GAppleSpoofMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "spoofActive", "", "getSpoofActive", "()Z", "setSpoofActive", "(Z)V", "doEatPre", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "event", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPreEvent;", "doEatPost", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPostEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGAppleExtendSpoofCount.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GAppleExtendSpoofCount.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendSpoofCount\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n774#2:69\n865#2,2:70\n1563#2:72\n1634#2,3:73\n1056#2:76\n1869#2:77\n1869#2,2:78\n1870#2:80\n37#3:81\n36#3,3:82\n1#4:85\n*S KotlinDebug\n*F\n+ 1 GAppleExtendSpoofCount.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendSpoofCount\n*L\n30#1:69\n30#1:70,2\n31#1:72\n31#1:73,3\n32#1:76\n33#1:77\n35#1:78,2\n33#1:80\n50#1:81\n50#1:82,3\n*E\n"})
public final class GAppleExtendSpoofCount
extends GAppleExtend {
    @NotNull
    private final List<Value<?>> values = new ArrayList();
    @NotNull
    private final Map<String, GAppleSpoofMode> spoofModes = new LinkedHashMap();
    @JvmField
    @NotNull
    public final ListValue modeValue = new ListValue("Mode", null, "Custom", 2, null);
    private boolean spoofActive;

    public GAppleExtendSpoofCount() {
        super("SpoofCount", true);
        Unit unit;
        Iterator $this$mapTo$iv$iv;
        Class it;
        Iterable $this$filterTo$iv$iv;
        this.getValues().add(this.modeValue);
        Iterable $this$filter$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".spoof.impl", GAppleSpoofMode.class);
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (Class)element$iv$iv;
            boolean bl2 = false;
            if (!(!Modifier.isAbstract(it.getModifiers()))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        Iterator iterator2 = $this$mapTo$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object item$iv$iv = iterator2.next();
            it = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add((GAppleSpoofMode)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                GAppleSpoofMode it = (GAppleSpoofMode)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getName());
                it = (GAppleSpoofMode)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GAppleSpoofMode mode = (GAppleSpoofMode)element$iv;
            boolean bl4 = false;
            mode.setInstance(this);
            Iterable $this$forEach$iv2 = mode.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl5 = false;
                value.setName(mode.getName() + value.getName());
                if (value.getSuperValue() == null) {
                    value.setSuperValue(this.modeValue);
                    value.setSuperValueMeta(mode.getName());
                }
                this.getValues().add(value);
            }
            this.spoofModes.put(mode.getName(), mode);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(mode);
            EventManager.registerListener$default(eventManager, mode, false, false, 6, null);
        }
        Unit it2 = unit = Unit.INSTANCE;
        boolean bl6 = false;
        Collection $this$toTypedArray$iv = this.spoofModes.keySet();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        this.modeValue.setValues(thisCollection$iv.toArray(new String[0]));
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    public final boolean getSpoofActive() {
        return this.spoofActive;
    }

    public final void setSpoofActive(boolean bl2) {
        this.spoofActive = bl2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void doEatPre(@NotNull SafeListenerBase $this$doEatPre, @NotNull GAppleDoEatPreEvent event) {
        block2: {
            Intrinsics.checkNotNullParameter($this$doEatPre, "<this>");
            Intrinsics.checkNotNullParameter(event, "event");
            var3_3 = this.spoofModes.get(this.modeValue.get());
            if (var3_3 == null) break block2;
            spoof = var4_4 = var3_3;
            $i$a$-also-GAppleExtendSpoofCount$doEatPre$1 = false;
            v0 = this;
            if (event.getPrevSlot() == event.getSelectSlot()) ** GOTO lbl-1000
            var7_7 = spoof;
            var8_8 = v0;
            $i$a$-run-GAppleExtendSpoofCount$doEatPre$1$1 = false;
            v0 = var8_8;
            if (Boolean.valueOf($this$doEatPre_u24lambda_u248_u24lambda_u246.shouldActive($this$doEatPre, event.getSelectSlot())).booleanValue()) {
                v1 = true;
            } else lbl-1000:
            // 2 sources

            {
                v1 = v0.spoofActive = false;
            }
            if (!this.spoofActive) break block2;
            $this$doEatPre_u24lambda_u248_u24lambda_u247 = spoof;
            $i$a$-run-GAppleExtendSpoofCount$doEatPre$1$2 = false;
            $this$doEatPre_u24lambda_u248_u24lambda_u247.pre($this$doEatPre, event.getSelectSlot());
        }
    }

    @Override
    public void doEatPost(@NotNull SafeListenerBase $this$doEatPost, @NotNull GAppleDoEatPostEvent event) {
        block1: {
            Intrinsics.checkNotNullParameter($this$doEatPost, "<this>");
            Intrinsics.checkNotNullParameter(event, "event");
            if (!this.spoofActive) break block1;
            GAppleSpoofMode gAppleSpoofMode = this.spoofModes.get(this.modeValue.get());
            if (gAppleSpoofMode != null) {
                GAppleSpoofMode gAppleSpoofMode2;
                GAppleSpoofMode $this$doEatPost_u24lambda_u249 = gAppleSpoofMode2 = gAppleSpoofMode;
                boolean bl2 = false;
                $this$doEatPost_u24lambda_u249.post($this$doEatPost, event.getSelectSlot());
            }
        }
    }
}


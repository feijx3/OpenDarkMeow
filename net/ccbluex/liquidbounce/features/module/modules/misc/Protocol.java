/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

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
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.ProtocolMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/Protocol;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/ProtocolMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "onEnable", "", "onDisable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Protocol.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/Protocol\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,63:1\n1#2:64\n1563#3:65\n1634#3,3:66\n1056#3:69\n1869#3:70\n1869#3,2:71\n1870#3:73\n37#4:74\n36#4,3:75\n*S KotlinDebug\n*F\n+ 1 Protocol.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/Protocol\n*L\n31#1:65\n31#1:66,3\n32#1:69\n33#1:70\n36#1:71,2\n33#1:73\n52#1:74\n52#1:75,3\n*E\n"})
public final class Protocol
extends Module {
    @NotNull
    public static final Protocol INSTANCE;
    @NotNull
    private static final Map<String, ProtocolMode> modes;
    @JvmField
    @NotNull
    public static final ListValue modeValue;

    private Protocol() {
        super("Protocol", ModuleCategory.MISC, null, null, 12, null);
    }

    @Override
    public void onEnable() {
        block0: {
            ProtocolMode protocolMode = modes.get(modeValue.get());
            if (protocolMode == null) break block0;
            protocolMode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        block0: {
            ProtocolMode protocolMode = modes.get(modeValue.get());
            if (protocolMode == null) break block0;
            protocolMode.onDisable();
        }
    }

    public static final /* synthetic */ Map access$getModes$p() {
        return modes;
    }

    /*
     * WARNING - void declaration
     */
    static {
        block5: {
            void $this$mapTo$iv$iv;
            List<Class<ProtocolMode>> list;
            List<Class<ProtocolMode>> list2;
            INSTANCE = new Protocol();
            modes = new LinkedHashMap();
            modeValue = new ListValue(){

                protected void onChanged(String oldValue, String newValue) {
                    block2: {
                        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                        Intrinsics.checkNotNullParameter(newValue, "newValue");
                        if (!Protocol.INSTANCE.getState()) break block2;
                        ProtocolMode protocolMode = (ProtocolMode)Protocol.access$getModes$p().get(oldValue);
                        if (protocolMode != null) {
                            protocolMode.onDisable();
                        }
                        ProtocolMode protocolMode2 = (ProtocolMode)Protocol.access$getModes$p().get(newValue);
                        if (protocolMode2 != null) {
                            protocolMode2.onEnable();
                        }
                    }
                }
            };
            List<Class<ProtocolMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".protocols", ProtocolMode.class);
            boolean bl2 = false;
            INSTANCE.getValues().add(modeValue);
            it = list2;
            boolean bl3 = false;
            List<Class<ProtocolMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
            if (list == null) break block5;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl4 = false;
                collection.add((ProtocolMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy2 = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ProtocolMode it = (ProtocolMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (ProtocolMode)b2;
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
                    ProtocolMode it3 = (ProtocolMode)element$iv;
                    boolean bl5 = false;
                    it3.setInstance(INSTANCE);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl6 = false;
                        value.setName(it3.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modeValue);
                            value.setSuperValueMeta(it3.getName());
                        }
                        INSTANCE.getValues().add(value);
                    }
                    modes.put(it3.getName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
                Unit it4 = unit = Unit.INSTANCE;
                boolean bl7 = false;
                Collection $this$toTypedArray$iv = modes.keySet();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            }
        }
    }
}


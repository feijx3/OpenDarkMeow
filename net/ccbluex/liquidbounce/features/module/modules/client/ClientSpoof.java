/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.client.ClientSpoof;
import net.ccbluex.liquidbounce.features.module.modules.client.clientspoof.ClientSpoofMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="ClientSpoof", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/ClientSpoof;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/client/clientspoof/ClientSpoofMode;", "Lkotlin/collections/HashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "onEnable", "", "onDisable", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nClientSpoof.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientSpoof.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/ClientSpoof\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n216#2,2:66\n216#2,2:68\n1563#3:70\n1634#3,3:71\n1869#3:74\n1869#3,2:75\n1870#3:77\n*S KotlinDebug\n*F\n+ 1 ClientSpoof.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/ClientSpoof\n*L\n51#1:66,2\n57#1:68,2\n20#1:70\n20#1:71,3\n21#1:74\n39#1:75,2\n21#1:77\n*E\n"})
public final class ClientSpoof
extends Module {
    @NotNull
    public static final ClientSpoof INSTANCE;
    @NotNull
    private static final HashMap<String, ClientSpoofMode> modes;
    @NotNull
    private static final List<Value<?>> settingsModuleValues;
    @NotNull
    private static final List<Value<?>> values;

    private ClientSpoof() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onEnable() {
        Map $this$forEach$iv = modes;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            ClientSpoofMode mode = (ClientSpoofMode)entry.getValue();
            if (!((Boolean)mode.getLinkedStatValue().get()).booleanValue()) continue;
            mode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        Map $this$forEach$iv = modes;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            ClientSpoofMode mode = (ClientSpoofMode)entry.getValue();
            if (!((Boolean)mode.getLinkedStatValue().get()).booleanValue()) continue;
            mode.onDisable();
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    private static final boolean lambda$3$lambda$2$lambda$1(2.modulesMode.1 $modulesMode) {
        return (Boolean)$modulesMode.get();
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$mapTo$iv$iv;
        INSTANCE = new ClientSpoof();
        modes = new HashMap();
        settingsModuleValues = new ArrayList();
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".clientspoof", ClientSpoofMode.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((ClientSpoofMode)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object item$iv$iv;
            ClientSpoofMode it = (ClientSpoofMode)element$iv;
            boolean bl3 = false;
            item$iv$iv = it.getModeName();
            BoolValue modulesMode2 = new BoolValue(it, (String)item$iv$iv){
                final /* synthetic */ ClientSpoofMode $it;
                {
                    this.$it = $it;
                    super($super_call_param$1, false);
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    if (ClientSpoof.INSTANCE.getState()) {
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
            it.setInstance(INSTANCE);
            it.setLinkedStatValue(modulesMode2);
            settingsModuleValues.add(modulesMode2);
            Iterable $this$forEach$iv2 = it.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                settingsModuleValues.add(value.displayable(() -> ClientSpoof.lambda$3$lambda$2$lambda$1(modulesMode2)));
            }
            ((Map)modes).put(it.getModeName(), it);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it);
            EventManager.registerListener$default(eventManager, it, false, false, 6, null);
        }
        values = settingsModuleValues;
    }
}


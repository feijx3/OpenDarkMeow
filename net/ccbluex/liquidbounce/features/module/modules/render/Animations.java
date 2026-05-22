/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import net.ccbluex.liquidbounce.features.module.modules.render.animations.AnimationMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/Animations;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/animations/AnimationMode;", "isLoadingSubModule", "", "()Z", "setLoadingSubModule", "(Z)V", "onEnable", "", "onDisable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAnimations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animations.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Animations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,72:1\n1563#2:73\n1634#2,3:74\n1869#2:77\n1869#2,2:78\n1870#2:80\n216#3,2:81\n216#3,2:83\n*S KotlinDebug\n*F\n+ 1 Animations.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/Animations\n*L\n20#1:73\n20#1:74,3\n21#1:77\n39#1:78,2\n21#1:80\n62#1:81,2\n68#1:83,2\n*E\n"})
public final class Animations
extends Module {
    @NotNull
    private final Map<String, AnimationMode> modes = new LinkedHashMap();
    private boolean isLoadingSubModule = true;

    /*
     * WARNING - void declaration
     */
    public Animations() {
        super("Animations", ModuleCategory.RENDER, null, null, 12, null);
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".animations", AnimationMode.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it2;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((AnimationMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object item$iv$iv;
            AnimationMode it = (AnimationMode)element$iv;
            boolean bl3 = false;
            item$iv$iv = it.getName();
            boolean it2 = it.getDefaultState();
            BoolValue modulesMode2 = new BoolValue(this, it, (String)item$iv$iv, it2){
                final /* synthetic */ Animations this$0;
                final /* synthetic */ AnimationMode $it;
                {
                    this.this$0 = $receiver;
                    this.$it = $it;
                    super($super_call_param$1, $super_call_param$2);
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
            it.setLinkedStatValue(modulesMode2);
            this.getValues().add(modulesMode2);
            this.isLoadingSubModule = false;
            Iterable $this$forEach$iv2 = it.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                value.setName(it.getName() + value.getName());
                if (value.getSuperValue() == null) {
                    value.setSuperValue(modulesMode2);
                }
                this.getValues().add(value);
            }
            this.isLoadingSubModule = true;
            this.modes.put(it.getName(), it);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it);
            EventManager.registerListener$default(eventManager, it, false, false, 6, null);
        }
        this.isLoadingSubModule = false;
    }

    public final boolean isLoadingSubModule() {
        return this.isLoadingSubModule;
    }

    public final void setLoadingSubModule(boolean bl2) {
        this.isLoadingSubModule = bl2;
    }

    @Override
    public void onEnable() {
        Map<String, AnimationMode> $this$forEach$iv = this.modes;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<String, AnimationMode>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, AnimationMode> element$iv;
            Map.Entry<String, AnimationMode> entry = element$iv = iterator2.next();
            boolean bl2 = false;
            AnimationMode mode = entry.getValue();
            if (!((Boolean)mode.getLinkedStatValue().get()).booleanValue()) continue;
            mode.onEnable();
        }
    }

    @Override
    public void onDisable() {
        Map<String, AnimationMode> $this$forEach$iv = this.modes;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<String, AnimationMode>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, AnimationMode> element$iv;
            Map.Entry<String, AnimationMode> entry = element$iv = iterator2.next();
            boolean bl2 = false;
            AnimationMode mode = entry.getValue();
            if (!((Boolean)mode.getLinkedStatValue().get()).booleanValue()) continue;
            mode.onDisable();
        }
    }
}


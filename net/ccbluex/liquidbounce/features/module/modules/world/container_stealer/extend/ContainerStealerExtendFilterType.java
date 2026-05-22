/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.GuiHopper
 *  net.minecraft.client.gui.inventory.GuiBrewingStand
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiDispenser
 *  net.minecraft.client.gui.inventory.GuiFurnace
 *  net.minecraft.client.gui.inventory.GuiShulkerBox
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.extend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR=\u0010\t\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\nj\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r`\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\b\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterType;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "<init>", "()V", "settingsValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getSettingsValues", "()Ljava/util/List;", "containerTypeState", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "Lkotlin/collections/HashMap;", "getContainerTypeState", "()Ljava/util/HashMap;", "allowStealer", "", "screen", "values", "getValues", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerStealerExtendFilterType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealerExtendFilterType.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterType\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,46:1\n216#2,2:47\n*S KotlinDebug\n*F\n+ 1 ContainerStealerExtendFilterType.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterType\n*L\n35#1:47,2\n*E\n"})
public final class ContainerStealerExtendFilterType
extends ContainerStealerExtend {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Value<?>> settingsValues = new ArrayList();
    @NotNull
    private final HashMap<Class<? extends GuiContainer>, BoolValue> containerTypeState = new HashMap();
    @NotNull
    private final List<Value<?>> values;
    @NotNull
    private static final HashMap<Class<? extends GuiContainer>, String> containerToNameMap;

    public ContainerStealerExtendFilterType() {
        super("FilterType", false);
        Map $this$forEach$iv = containerToNameMap;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            BoolValue boolValue;
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl2 = false;
            Class clazz = (Class)entry.getKey();
            String name = (String)entry.getValue();
            BoolValue value = boolValue = new BoolValue(name, true);
            boolean bl3 = false;
            ((Map)this.containerTypeState).put(clazz, value);
            this.settingsValues.add(value);
        }
        this.values = this.settingsValues;
    }

    @NotNull
    public final List<Value<?>> getSettingsValues() {
        return this.settingsValues;
    }

    @NotNull
    public final HashMap<Class<? extends GuiContainer>, BoolValue> getContainerTypeState() {
        return this.containerTypeState;
    }

    @Override
    public boolean allowStealer(@NotNull GuiContainer screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        BoolValue boolValue = this.containerTypeState.get(screen.getClass());
        return boolValue != null ? boolValue.getState() : false;
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to(GuiChest.class, "Chest"), TuplesKt.to(GuiFurnace.class, "Furnace"), TuplesKt.to(GuiBrewingStand.class, "BrewingStand"), TuplesKt.to(GuiShulkerBox.class, "ShulkerBox"), TuplesKt.to(GuiHopper.class, "Hopper"), TuplesKt.to(GuiDispenser.class, "Dispenser")};
        containerToNameMap = MapsKt.hashMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003RC\u0010\u0004\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterType$Companion;", "", "<init>", "()V", "containerToNameMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "", "Lkotlin/collections/HashMap;", "getContainerToNameMap$annotations", "getContainerToNameMap", "()Ljava/util/HashMap;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<Class<? extends GuiContainer>, String> getContainerToNameMap() {
            return containerToNameMap;
        }

        public static /* synthetic */ void getContainerToNameMap$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


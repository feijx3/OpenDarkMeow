/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiFurnace
 *  net.minecraft.client.gui.inventory.GuiShulkerBox
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.extend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.ccbluex.liquidbounce.injection.extend.gui.ExtendGuiChest;
import net.ccbluex.liquidbounce.injection.extend.gui.ExtendGuiFurnace;
import net.ccbluex.liquidbounce.injection.extend.gui.ExtendGuiShulkerBox;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterName;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "allowStealer", "", "screen", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "Companion", "ContainerTypeInfo", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerStealerExtendFilterName.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealerExtendFilterName.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterName\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n1563#2:54\n1634#2,3:55\n2746#2,3:58\n1761#2,3:61\n*S KotlinDebug\n*F\n+ 1 ContainerStealerExtendFilterName.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterName\n*L\n44#1:54\n44#1:55,3\n47#1:58,3\n48#1:61,3\n*E\n"})
public final class ContainerStealerExtendFilterName
extends ContainerStealerExtend {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @NotNull
    private static final HashMap<Class<? extends GuiContainer>, ContainerTypeInfo> CONTAINER_TYPE_MAP;

    public ContainerStealerExtendFilterName() {
        super("FilterName", false);
        String[] stringArray = new String[]{"OnlyNamed", "OnlyUnnamed"};
        this.modeValue = new ListValue("Mode", stringArray, "OnlyUnnamed");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean allowStealer(@NotNull GuiContainer screen) {
        boolean bl2;
        block13: {
            Intrinsics.checkNotNullParameter(screen, "screen");
            ContainerTypeInfo containerTypeInfo = CONTAINER_TYPE_MAP.get(screen.getClass());
            if (containerTypeInfo != null) {
                String it;
                void $this$mapTo$iv$iv;
                ContainerTypeInfo type = containerTypeInfo;
                boolean bl3 = false;
                String name = type.getBlock().invoke(screen).func_150260_c();
                Iterable $this$map$iv = type.getDefaultNameKeys();
                boolean $i$f$map = false;
                Iterable iterable = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it2;
                    String string = (String)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl4 = false;
                    collection.add(I18n.func_135052_a((String)it2, (Object[])new Object[0]));
                }
                List translationNames = (List)destination$iv$iv;
                String string = (String)this.modeValue.get();
                if (Intrinsics.areEqual(string, "OnlyNamed")) {
                    Iterable $this$none$iv = translationNames;
                    boolean $i$f$none = false;
                    if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                        bl2 = true;
                    } else {
                        for (Object element$iv : $this$none$iv) {
                            it = (String)element$iv;
                            boolean bl5 = false;
                            if (!Intrinsics.areEqual(it, name)) continue;
                            bl2 = false;
                            break block13;
                        }
                        bl2 = true;
                    }
                } else if (Intrinsics.areEqual(string, "OnlyUnnamed")) {
                    Iterable $this$any$iv = translationNames;
                    boolean $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl2 = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            it = (String)element$iv;
                            boolean bl6 = false;
                            if (!Intrinsics.areEqual(it, name)) continue;
                            bl2 = true;
                            break block13;
                        }
                        bl2 = false;
                    }
                } else {
                    bl2 = true;
                }
            } else {
                bl2 = true;
            }
        }
        return bl2;
    }

    private static final ITextComponent CONTAINER_TYPE_MAP$lambda$4(GuiContainer ui) {
        Intrinsics.checkNotNullParameter(ui, "ui");
        ITextComponent iTextComponent = ExtendGuiChest.INSTANCE.getLowerChestInventory((GuiContainer)((GuiChest)ui)).func_145748_c_();
        Intrinsics.checkNotNullExpressionValue(iTextComponent, "getDisplayName(...)");
        return iTextComponent;
    }

    private static final ITextComponent CONTAINER_TYPE_MAP$lambda$5(GuiContainer ui) {
        Intrinsics.checkNotNullParameter(ui, "ui");
        ITextComponent iTextComponent = ExtendGuiFurnace.INSTANCE.getTileFurnace((GuiFurnace)ui).func_145748_c_();
        Intrinsics.checkNotNullExpressionValue(iTextComponent, "getDisplayName(...)");
        return iTextComponent;
    }

    private static final ITextComponent CONTAINER_TYPE_MAP$lambda$6(GuiContainer ui) {
        Intrinsics.checkNotNullParameter(ui, "ui");
        ITextComponent iTextComponent = ExtendGuiShulkerBox.INSTANCE.getInventory((GuiShulkerBox)ui).func_145748_c_();
        Intrinsics.checkNotNullExpressionValue(iTextComponent, "getDisplayName(...)");
        return iTextComponent;
    }

    static {
        Pair[] pairArray = new Pair[3];
        String[] stringArray = new String[]{"container.chest", "container.chestDouble", "container.enderchest"};
        pairArray[0] = TuplesKt.to(GuiChest.class, new ContainerTypeInfo(SetsKt.setOf(stringArray), ContainerStealerExtendFilterName::CONTAINER_TYPE_MAP$lambda$4));
        pairArray[1] = TuplesKt.to(GuiFurnace.class, new ContainerTypeInfo(SetsKt.setOf("container.furnace"), ContainerStealerExtendFilterName::CONTAINER_TYPE_MAP$lambda$5));
        pairArray[2] = TuplesKt.to(GuiShulkerBox.class, new ContainerTypeInfo(SetsKt.setOf("container.shulkerBox"), ContainerStealerExtendFilterName::CONTAINER_TYPE_MAP$lambda$6));
        CONTAINER_TYPE_MAP = MapsKt.hashMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003RC\u0010\u0004\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterName$Companion;", "", "<init>", "()V", "CONTAINER_TYPE_MAP", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterName$ContainerTypeInfo;", "Lkotlin/collections/HashMap;", "getCONTAINER_TYPE_MAP$annotations", "getCONTAINER_TYPE_MAP", "()Ljava/util/HashMap;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<Class<? extends GuiContainer>, ContainerTypeInfo> getCONTAINER_TYPE_MAP() {
            return CONTAINER_TYPE_MAP;
        }

        public static /* synthetic */ void getCONTAINER_TYPE_MAP$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendFilterName$ContainerTypeInfo;", "", "defaultNameKeys", "", "", "block", "Lkotlin/Function1;", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "Lnet/minecraft/util/text/ITextComponent;", "<init>", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;)V", "getDefaultNameKeys", "()Ljava/util/Set;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "DarkMeow"})
    public static final class ContainerTypeInfo {
        @NotNull
        private final Set<String> defaultNameKeys;
        @NotNull
        private final Function1<GuiContainer, ITextComponent> block;

        public ContainerTypeInfo(@NotNull Set<String> defaultNameKeys, @NotNull Function1<? super GuiContainer, ? extends ITextComponent> block) {
            Intrinsics.checkNotNullParameter(defaultNameKeys, "defaultNameKeys");
            Intrinsics.checkNotNullParameter(block, "block");
            this.defaultNameKeys = defaultNameKeys;
            this.block = block;
        }

        @NotNull
        public final Set<String> getDefaultNameKeys() {
            return this.defaultNameKeys;
        }

        @NotNull
        public final Function1<GuiContainer, ITextComponent> getBlock() {
            return this.block;
        }
    }
}


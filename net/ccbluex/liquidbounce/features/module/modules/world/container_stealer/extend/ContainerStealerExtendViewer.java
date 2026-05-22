/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.BlockContainer
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec2f
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.extend;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.container.ContainerCloseEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerTryUseItemOnBlockEvent;
import net.ccbluex.liquidbounce.features.module.modules.client.HUD;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.ContainerStealerExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.container_stealer.enums.EnumPreStealerAction;
import net.ccbluex.liquidbounce.injection.extend.ExtendEntityRenderer;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FloatValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.darkmeow.darkmeow.utils.visual.RenderPositionUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.impl.WindowBlurShader;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0014\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/ContainerStealerExtend;", "<init>", "()V", "scaleValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatValue;", "rectValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "rectColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "overlaysValue", "onDisable", "", "lastClickPos", "Lnet/minecraft/util/math/BlockPos;", "getLastClickPos", "()Lnet/minecraft/util/math/BlockPos;", "setLastClickPos", "(Lnet/minecraft/util/math/BlockPos;)V", "renderPosition", "Lnet/minecraft/util/math/Vec2f;", "getRenderPosition", "()Lnet/minecraft/util/math/Vec2f;", "setRenderPosition", "(Lnet/minecraft/util/math/Vec2f;)V", "containerDataTracker", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer$ContainerDataTracker;", "getContainerDataTracker", "()Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer$ContainerDataTracker;", "preStealer", "Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/enums/EnumPreStealerAction;", "screen", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "renderChestItemViewer", "items", "", "Lnet/minecraft/item/ItemStack;", "Companion", "ContainerDataTracker", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nContainerStealerExtendViewer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealerExtendViewer.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,164:1\n1#2:165\n20#3,3:166\n12#3,3:169\n12#3,3:172\n12#3,3:175\n*S KotlinDebug\n*F\n+ 1 ContainerStealerExtendViewer.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer\n*L\n89#1:166,3\n96#1:169,3\n99#1:172,3\n104#1:175,3\n*E\n"})
public final class ContainerStealerExtendViewer
extends ContainerStealerExtend {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final FloatValue scaleValue = new FloatValue("Scale", 1.0f, (ClosedRange<Float>)RangesKt.rangeTo(0.1f, 4.0f));
    @JvmField
    @NotNull
    public final BoolValue rectValue = new BoolValue("Rect", true);
    @JvmField
    @NotNull
    public final ColorValue rectColorValue;
    @JvmField
    @NotNull
    public final BoolValue overlaysValue;
    @Nullable
    private BlockPos lastClickPos;
    @Nullable
    private Vec2f renderPosition;
    @NotNull
    private final ContainerDataTracker containerDataTracker;
    public static final float ITEM_STACK_RENDER_LENGTH = 20.0f;
    public static final float ITEM_STACK_RENDER_OFFSET = 2.0f;

    public ContainerStealerExtendViewer() {
        super("Viewer", true);
        ListenableOwner $receiver$iv;
        ListenableOwner $this$rectColorValue_u24lambda_u240;
        Object object = new ColorValue("RectColor", null, false, 6, null);
        ColorValue colorValue = object;
        ContainerStealerExtendViewer containerStealerExtendViewer = this;
        boolean bl2 = false;
        ((Value)((Object)$this$rectColorValue_u24lambda_u240)).setSuperValue(this.rectValue);
        containerStealerExtendViewer.rectColorValue = object;
        this.overlaysValue = new BoolValue("Overlays", true);
        this.containerDataTracker = new ContainerDataTracker(0, null, null, 7, null);
        object = ListenableOwnerExtends.INSTANCE;
        $this$rectColorValue_u24lambda_u240 = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> ContainerStealerExtendViewer._init_$lambda$3(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<ControllerTryUseItemOnBlockEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerTryUseItemOnBlockEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ContainerStealerExtendViewer._init_$lambda$4(this, arg_0, arg_1);
        priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<ControllerTryUseItemOnBlockEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ContainerCloseEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ContainerStealerExtendViewer._init_$lambda$6(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<ControllerTryUseItemOnBlockEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render3DEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> ContainerStealerExtendViewer._init_$lambda$11(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<ControllerTryUseItemOnBlockEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DEvent.class), $receiver$iv));
    }

    @Override
    public void onDisable() {
        DarkMeow.INSTANCE.getInventoryManager().getContainerManager().closeContainer();
    }

    @Nullable
    public final BlockPos getLastClickPos() {
        return this.lastClickPos;
    }

    public final void setLastClickPos(@Nullable BlockPos blockPos) {
        this.lastClickPos = blockPos;
    }

    @Nullable
    public final Vec2f getRenderPosition() {
        return this.renderPosition;
    }

    public final void setRenderPosition(@Nullable Vec2f vec2f) {
        this.renderPosition = vec2f;
    }

    @NotNull
    public final ContainerDataTracker getContainerDataTracker() {
        return this.containerDataTracker;
    }

    @Override
    @Nullable
    public EnumPreStealerAction preStealer(@NotNull GuiContainer screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.containerDataTracker.checkIdOrUpdate(screen);
        return null;
    }

    public final void renderChestItemViewer(@NotNull List<ItemStack> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        GlStateManager.func_179109_b((float)-90.0f, (float)0.0f, (float)0.0f);
        int height = RangesKt.coerceAtLeast(items.size() / 9, 1);
        if (((Boolean)HUD.blurValue.get()).booleanValue()) {
            WindowBlurShader.render$default(WindowBlurShader.INSTANCE, 0.0f, 0.0f, 180.0f, 20.0f * (float)height, 0, 0.0f, 48, null);
        }
        RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(0.0f), (Number)Float.valueOf(0.0f), (Number)Float.valueOf(180.0f), (Number)Float.valueOf(20.0f * (float)height), new Color(0, 0, 0, 120));
        if (((Boolean)this.rectValue.get()).booleanValue()) {
            RenderUtils.INSTANCE.drawRect((Number)Float.valueOf(0.0f), (Number)Float.valueOf(-1.0f), (Number)Float.valueOf(180.0f), (Number)Float.valueOf(0.0f), ColorValue.getColor$default(this.rectColorValue, null, 1, null));
        }
        for (int i2 = 0; i2 < height; ++i2) {
            int y2 = i2;
            boolean bl2 = false;
            int n2 = 9;
            for (int i3 = 0; i3 < n2; ++i3) {
                ItemStack itemStack;
                ItemStack itemStack2;
                ItemStack itemStack3;
                ItemStack itemStack4;
                int x2 = i3;
                boolean bl3 = false;
                int index = y2 * 9 + x2;
                ItemStack it = itemStack4 = items;
                boolean bl4 = false;
                Object object = itemStack3 = (0 <= index ? index < it.size() : false) ? itemStack4 : null;
                if (itemStack3 == null || (itemStack4 = itemStack3.get(index)) == null) continue;
                ItemStack it2 = itemStack2 = itemStack4;
                boolean bl5 = false;
                Object object2 = itemStack = !it2.func_190926_b() ? itemStack2 : null;
                if (itemStack == null) continue;
                ItemStack stack = itemStack2 = itemStack;
                boolean bl6 = false;
                RenderUtils.drawInGUIItem$default(Float.valueOf(20.0f * (float)x2 + 2.0f), Float.valueOf(20.0f * (float)y2 + 2.0f), stack, null, (Boolean)this.overlaysValue.get(), 0.0f, 8, null);
            }
        }
    }

    private static final Unit _init_$lambda$3(ContainerStealerExtendViewer this$0, SafeListenerBase $this$safeListener, ControllerTryUseItemOnBlockEvent event) {
        block0: {
            BlockPos blockPos;
            BlockPos blockPos2;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            BlockPos it = blockPos2 = event.getPos();
            boolean bl2 = false;
            Object object = blockPos = $this$safeListener.getWorld().func_180495_p(it).func_177230_c() instanceof BlockContainer ? blockPos2 : null;
            if (blockPos == null) break block0;
            it = blockPos2 = blockPos;
            boolean bl3 = false;
            this$0.lastClickPos = it;
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(ContainerStealerExtendViewer this$0, ListenerBase $this$listener, ContainerCloseEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.containerDataTracker.setInvalid();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$6(ContainerStealerExtendViewer this$0, ListenerBase $this$listener, Render3DEvent event) {
        Vec2f vec2f;
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        ContainerStealerExtendViewer containerStealerExtendViewer = this$0;
        BlockPos blockPos = this$0.lastClickPos;
        if (blockPos != null) {
            void pos;
            BlockPos blockPos2 = blockPos;
            ContainerStealerExtendViewer containerStealerExtendViewer2 = containerStealerExtendViewer;
            boolean bl2 = false;
            vec2f = RenderPositionUtils.INSTANCE.worldToScreen($this$listener.getMc(), event.getPartialTicks(), (double)pos.func_177958_n() + 0.5, pos.func_177956_o() + 1, (double)pos.func_177952_p() + 0.5);
            containerStealerExtendViewer = containerStealerExtendViewer2;
        } else {
            vec2f = null;
        }
        containerStealerExtendViewer.renderPosition = vec2f;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$11(ContainerStealerExtendViewer this$0, ListenerBase $this$listener, Render2DEvent event) {
        block1: {
            ContainerDataTracker containerDataTracker;
            ContainerDataTracker containerDataTracker2;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            ContainerDataTracker it = containerDataTracker2 = this$0.containerDataTracker;
            boolean bl2 = false;
            ContainerDataTracker containerDataTracker3 = containerDataTracker = it.isValid() ? containerDataTracker2 : null;
            if (containerDataTracker == null) break block1;
            ContainerDataTracker data = containerDataTracker2 = containerDataTracker;
            boolean bl3 = false;
            Vec2f vec2f = this$0.renderPosition;
            if (vec2f != null) {
                float f2;
                Vec2f vec2f2;
                Vec2f position = vec2f2 = vec2f;
                boolean bl4 = false;
                GlStateManager.func_179094_E();
                GlStateManager.func_179109_b((float)position.field_189982_i, (float)position.field_189983_j, (float)0.0f);
                float f3 = ((Number)this$0.scaleValue.get()).floatValue() * 80.0f;
                EntityRenderer entityRenderer = $this$listener.getMc().field_71460_t;
                Intrinsics.checkNotNullExpressionValue(entityRenderer, "entityRenderer");
                float scale = f2 = f3 / ExtendEntityRenderer.INSTANCE.getFOVModifier(entityRenderer, event.getPartialTicks(), true);
                boolean bl5 = false;
                GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
                Object object = this$0.getInstance().getExtends().get("Delay");
                this$0.renderChestItemViewer((object != null && (object = ((ContainerStealerExtend)object).getLinkedStatValue()) != null ? ((Boolean)((Value)object).get()).booleanValue() : false) ? data.getPrevItems() : data.getLaunchItems());
                GlStateManager.func_179121_F();
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer$Companion;", "", "<init>", "()V", "ITEM_STACK_RENDER_LENGTH", "", "ITEM_STACK_RENDER_OFFSET", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011\u00a8\u0006\u001b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer$ContainerDataTracker;", "", "windowId", "", "launchItems", "", "Lnet/minecraft/item/ItemStack;", "prevItems", "<init>", "(ILjava/util/List;Ljava/util/List;)V", "getWindowId", "()I", "setWindowId", "(I)V", "getLaunchItems", "()Ljava/util/List;", "setLaunchItems", "(Ljava/util/List;)V", "getPrevItems", "setPrevItems", "isValid", "", "setInvalid", "", "checkIdOrUpdate", "screen", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nContainerStealerExtendViewer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerStealerExtendViewer.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer$ContainerDataTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,164:1\n1563#2:165\n1634#2,3:166\n2746#2,3:169\n*S KotlinDebug\n*F\n+ 1 ContainerStealerExtendViewer.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/container_stealer/extend/ContainerStealerExtendViewer$ContainerDataTracker\n*L\n73#1:165\n73#1:166,3\n75#1:169,3\n*E\n"})
    public static final class ContainerDataTracker {
        private int windowId;
        @NotNull
        private List<ItemStack> launchItems;
        @NotNull
        private List<ItemStack> prevItems;

        public ContainerDataTracker(int windowId, @NotNull List<ItemStack> launchItems, @NotNull List<ItemStack> prevItems) {
            Intrinsics.checkNotNullParameter(launchItems, "launchItems");
            Intrinsics.checkNotNullParameter(prevItems, "prevItems");
            this.windowId = windowId;
            this.launchItems = launchItems;
            this.prevItems = prevItems;
        }

        public /* synthetic */ ContainerDataTracker(int n2, List list, List list2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 1) != 0) {
                n2 = -1;
            }
            if ((n3 & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((n3 & 4) != 0) {
                list2 = CollectionsKt.emptyList();
            }
            this(n2, list, list2);
        }

        public final int getWindowId() {
            return this.windowId;
        }

        public final void setWindowId(int n2) {
            this.windowId = n2;
        }

        @NotNull
        public final List<ItemStack> getLaunchItems() {
            return this.launchItems;
        }

        public final void setLaunchItems(@NotNull List<ItemStack> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.launchItems = list;
        }

        @NotNull
        public final List<ItemStack> getPrevItems() {
            return this.prevItems;
        }

        public final void setPrevItems(@NotNull List<ItemStack> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.prevItems = list;
        }

        public final boolean isValid() {
            return this.windowId != -1;
        }

        public final void setInvalid() {
            this.windowId = -1;
        }

        /*
         * WARNING - void declaration
         */
        public final void checkIdOrUpdate(@NotNull GuiContainer screen) {
            List currentItems;
            block10: {
                block9: {
                    boolean bl2;
                    block8: {
                        void $this$mapTo$iv$iv;
                        Intrinsics.checkNotNullParameter(screen, "screen");
                        Iterable $this$map$iv = screen.field_147002_h.field_75151_b.subList(0, screen.field_147002_h.field_75151_b.size() - 36);
                        boolean $i$f$map = false;
                        Iterable iterable = $this$map$iv;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        boolean $i$f$mapTo = false;
                        for (Object item$iv$iv : $this$mapTo$iv$iv) {
                            void it;
                            Slot slot = (Slot)item$iv$iv;
                            Collection collection = destination$iv$iv;
                            boolean bl3 = false;
                            collection.add(it.func_75211_c().func_77946_l());
                        }
                        currentItems = (List)destination$iv$iv;
                        if (screen.field_147002_h.field_75152_c != this.windowId) break block9;
                        Iterable $this$none$iv = this.launchItems;
                        boolean $i$f$none = false;
                        if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                            bl2 = true;
                        } else {
                            for (Object element$iv : $this$none$iv) {
                                ItemStack it = (ItemStack)element$iv;
                                boolean bl4 = false;
                                if (!it.func_190926_b()) continue;
                                bl2 = false;
                                break block8;
                            }
                            bl2 = true;
                        }
                    }
                    if (!bl2) break block10;
                }
                this.windowId = screen.field_147002_h.field_75152_c;
                this.launchItems = currentItems;
            }
            this.prevItems = currentItems;
        }

        public ContainerDataTracker() {
            this(0, null, null, 7, null);
        }
    }
}


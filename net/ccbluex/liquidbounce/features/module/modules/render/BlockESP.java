/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.block.BlockUtils;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.ccbluex.liquidbounce.value.impl.BlockValue;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="BlockESP", description="Allows you to see a selected block through walls.", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001cH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/BlockESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "blockValue", "Lnet/ccbluex/liquidbounce/value/impl/BlockValue;", "radiusValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "blockLimitValue", "colorRedValue", "colorGreenValue", "colorBlueValue", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "searchTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "posList", "", "Lnet/minecraft/util/math/BlockPos;", "thread", "Ljava/lang/Thread;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/events/player/UpdateEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "tag", "", "getTag", "()Ljava/lang/String;", "DarkMeow"})
public final class BlockESP
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final BlockValue blockValue;
    @NotNull
    private final IntegerValue radiusValue;
    @NotNull
    private final IntegerValue blockLimitValue;
    @NotNull
    private final IntegerValue colorRedValue;
    @NotNull
    private final IntegerValue colorGreenValue;
    @NotNull
    private final IntegerValue colorBlueValue;
    @NotNull
    private final BoolValue colorRainbow;
    @NotNull
    private final MSTimer searchTimer;
    @NotNull
    private final List<BlockPos> posList;
    @Nullable
    private Thread thread;

    public BlockESP() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Box", "2D"};
        this.modeValue = new ListValue("Mode", stringArray, "Box");
        this.blockValue = new BlockValue("Block", 168);
        this.radiusValue = new IntegerValue("Radius", 40, 5, 120);
        this.blockLimitValue = new IntegerValue("BlockLimit", 256, 0, 2056);
        this.colorRedValue = new IntegerValue("R", 255, 0, 255);
        this.colorGreenValue = new IntegerValue("G", 179, 0, 255);
        this.colorBlueValue = new IntegerValue("B", 72, 0, 255);
        this.colorRainbow = new BoolValue("Rainbow", false);
        this.searchTimer = new MSTimer();
        this.posList = new ArrayList();
    }

    @EventTarget
    public final void onUpdate(@Nullable UpdateEvent event) {
        block4: {
            block5: {
                if (!this.searchTimer.hasTimePassed(1000L)) break block4;
                if (this.thread == null) break block5;
                Thread thread2 = this.thread;
                Intrinsics.checkNotNull(thread2);
                if (thread2.isAlive()) break block4;
            }
            int radius = ((Number)this.radiusValue.get()).intValue();
            Block selectedBlock = Block.func_149729_e((int)((Number)this.blockValue.get()).intValue());
            if (selectedBlock == null || Intrinsics.areEqual(selectedBlock, Blocks.field_150350_a)) {
                return;
            }
            Thread thread3 = this.thread = new Thread(() -> BlockESP.onUpdate$lambda$1(radius, selectedBlock, this), "BlockESP-BlockFinder");
            Intrinsics.checkNotNull(thread3);
            thread3.start();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @EventTarget
    public final void onRender3D(@Nullable Render3DEvent event) {
        List<BlockPos> list = this.posList;
        synchronized (list) {
            boolean bl2 = false;
            Color color = (Boolean)this.colorRainbow.get() != false ? ColorUtils.rainbow() : new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue());
            for (BlockPos blockPos : this.posList) {
                String string = ((String)this.modeValue.get()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
                if (!Intrinsics.areEqual(string, "box")) continue;
                RenderUtils.drawBlockBox(blockPos, color, true);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return BlockUtils.getBlockName(((Number)this.blockValue.get()).intValue());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final void onUpdate$lambda$1(int $radius, Block $selectedBlock, BlockESP this$0) {
        List blockList = new ArrayList();
        block3: for (int x2 = -$radius; x2 < $radius; ++x2) {
            int n2 = -$radius + 1;
            int y2 = $radius;
            if (n2 > y2) continue;
            while (true) {
                for (int z2 = -$radius; z2 < $radius; ++z2) {
                    EntityPlayerSP player;
                    Intrinsics.checkNotNull(MinecraftInstance.mc.getPlayer());
                    int xPos = (int)player.field_70165_t + x2;
                    int yPos = (int)player.field_70163_u + y2;
                    int zPos = (int)player.field_70161_v + z2;
                    BlockPos blockPos = new BlockPos(xPos, yPos, zPos);
                    Block block = BlockUtils.getBlock(blockPos);
                    if (!Intrinsics.areEqual(block, $selectedBlock) || blockList.size() >= ((Number)this$0.blockLimitValue.get()).intValue()) continue;
                    blockList.add(blockPos);
                }
                if (y2 == n2) continue block3;
                --y2;
            }
        }
        this$0.searchTimer.reset();
        List<BlockPos> list = this$0.posList;
        synchronized (list) {
            boolean bl2 = false;
            this$0.posList.clear();
            this$0.posList.addAll(blockList);
            Unit unit = Unit.INSTANCE;
        }
    }
}


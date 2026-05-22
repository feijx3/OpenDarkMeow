/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.world;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.utils.block.BlockUtils;
import net.darkmeow.darkmeow.utils.kotlin.HashMapExtensions;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Jd\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0007Jd\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0007JD\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0015*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\r2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0007JD\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0015*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\r2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0007Jt\u0010\u0017\u001a>\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u00070\u0018j\u001e\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u0007`\u001a*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001b2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0007Jt\u0010\u0017\u001a>\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u00070\u0018j\u001e\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u0007`\u001a*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u001b2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0007\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/utils/world/WorldUtils;", "", "<init>", "()V", "searchBlocks", "Ljava/util/LinkedHashMap;", "Lnet/minecraft/util/math/BlockPos;", "Lnet/minecraft/block/Block;", "Lkotlin/collections/LinkedHashMap;", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/math/Vec3d;", "radiusX", "", "radiusY", "radiusZ", "takeIf", "Lkotlin/Function2;", "", "entity", "Lnet/minecraft/entity/Entity;", "", "radius", "searchBlocksSphere", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "", "DarkMeow"})
public final class WorldUtils {
    @NotNull
    public static final WorldUtils INSTANCE = new WorldUtils();

    private WorldUtils() {
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final LinkedHashMap<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Vec3d pos, int radiusX, int radiusY, int radiusZ, @NotNull Function2<? super BlockPos, ? super Block, Boolean> takeIf) {
        LinkedHashMap<BlockPos, Block> linkedHashMap;
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        LinkedHashMap<BlockPos, Block> $this$searchBlocks_u24lambda_u242 = linkedHashMap = new LinkedHashMap<BlockPos, Block>();
        boolean bl2 = false;
        int x2 = radiusX;
        int n2 = -radiusX;
        if (n2 <= x2) {
            while (true) {
                int y2;
                int n3;
                if ((n3 = -radiusY) <= (y2 = radiusY)) {
                    while (true) {
                        int z2;
                        int n4;
                        if ((n4 = -radiusZ) <= (z2 = radiusZ)) {
                            while (true) {
                                BlockPos blockPos;
                                BlockPos pos2 = blockPos = new BlockPos(pos.field_72450_a + (double)x2, pos.field_72448_b + (double)y2, pos.field_72449_c + (double)z2);
                                boolean bl3 = false;
                                Block block = BlockUtils.getBlock(pos2);
                                if (takeIf.invoke((BlockPos)pos2, (Block)block).booleanValue()) {
                                    $this$searchBlocks_u24lambda_u242.put(pos2, block);
                                }
                                if (z2 == n4) break;
                                --z2;
                            }
                        }
                        if (y2 == n3) break;
                        --y2;
                    }
                }
                if (x2 == n2) break;
                --x2;
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ LinkedHashMap searchBlocks$default(World world, Vec3d vec3d, int n2, int n3, int n4, Function2 function2, int n5, Object object) {
        if ((n5 & 0x10) != 0) {
            function2 = WorldUtils::searchBlocks$lambda$0;
        }
        return WorldUtils.searchBlocks(world, vec3d, n2, n3, n4, function2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final LinkedHashMap<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Entity entity, int radiusX, int radiusY, int radiusZ, @NotNull Function2<? super BlockPos, ? super Block, Boolean> takeIf) {
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        return WorldUtils.searchBlocks($this$searchBlocks, new Vec3d(entity.field_70165_t, entity.func_174813_aQ().field_72338_b + (double)entity.func_70047_e(), entity.field_70161_v), radiusX, radiusY, radiusZ, takeIf);
    }

    public static /* synthetic */ LinkedHashMap searchBlocks$default(World world, Entity entity, int n2, int n3, int n4, Function2 function2, int n5, Object object) {
        if ((n5 & 0x10) != 0) {
            function2 = WorldUtils::searchBlocks$lambda$3;
        }
        return WorldUtils.searchBlocks(world, entity, n2, n3, n4, function2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Map<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Vec3d pos, int radius, @NotNull Function2<? super BlockPos, ? super Block, Boolean> takeIf) {
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        return WorldUtils.searchBlocks($this$searchBlocks, pos, radius, radius, radius, takeIf);
    }

    public static /* synthetic */ Map searchBlocks$default(World world, Vec3d vec3d, int n2, Function2 function2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            function2 = WorldUtils::searchBlocks$lambda$4;
        }
        return WorldUtils.searchBlocks(world, vec3d, n2, function2);
    }

    @JvmStatic
    @NotNull
    public static final Map<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Entity entity, int radius, @NotNull Function2<? super BlockPos, ? super Block, Boolean> takeIf) {
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        return WorldUtils.searchBlocks($this$searchBlocks, new Vec3d(entity.field_70165_t, entity.func_174813_aQ().field_72338_b + (double)entity.func_70047_e(), entity.field_70161_v), radius, takeIf);
    }

    public static /* synthetic */ Map searchBlocks$default(World world, Entity entity, int n2, Function2 function2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            function2 = WorldUtils::searchBlocks$lambda$5;
        }
        return WorldUtils.searchBlocks(world, entity, n2, function2);
    }

    @JvmStatic
    @NotNull
    public static final HashMap<BlockPos, Block> searchBlocksSphere(@NotNull World $this$searchBlocksSphere, @NotNull Vec3d pos, double radius, @NotNull Function2<? super BlockPos, ? super Block, Boolean> takeIf) {
        Intrinsics.checkNotNullParameter($this$searchBlocksSphere, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        return HashMapExtensions.INSTANCE.removeIf(WorldUtils.searchBlocks($this$searchBlocksSphere, pos, (int)radius + 1, (int)radius + 1, (int)radius + 1, takeIf), arg_0 -> WorldUtils.searchBlocksSphere$lambda$7(pos, radius, arg_0));
    }

    public static /* synthetic */ HashMap searchBlocksSphere$default(World world, Vec3d vec3d, double d2, Function2 function2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            function2 = WorldUtils::searchBlocksSphere$lambda$6;
        }
        return WorldUtils.searchBlocksSphere(world, vec3d, d2, function2);
    }

    @JvmStatic
    @NotNull
    public static final HashMap<BlockPos, Block> searchBlocksSphere(@NotNull World $this$searchBlocksSphere, @NotNull Entity entity, double radius, @NotNull Function2<? super BlockPos, ? super Block, Boolean> takeIf) {
        Intrinsics.checkNotNullParameter($this$searchBlocksSphere, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        return WorldUtils.searchBlocksSphere($this$searchBlocksSphere, new Vec3d(entity.field_70165_t, entity.func_174813_aQ().field_72338_b + (double)entity.func_70047_e(), entity.field_70161_v), radius, takeIf);
    }

    public static /* synthetic */ HashMap searchBlocksSphere$default(World world, Entity entity, double d2, Function2 function2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            function2 = WorldUtils::searchBlocksSphere$lambda$8;
        }
        return WorldUtils.searchBlocksSphere(world, entity, d2, function2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final LinkedHashMap<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Vec3d pos, int radiusX, int radiusY, int radiusZ) {
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        return WorldUtils.searchBlocks$default($this$searchBlocks, pos, radiusX, radiusY, radiusZ, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final LinkedHashMap<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Entity entity, int radiusX, int radiusY, int radiusZ) {
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        return WorldUtils.searchBlocks$default($this$searchBlocks, entity, radiusX, radiusY, radiusZ, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Map<BlockPos, Block> searchBlocks(@NotNull World $this$searchBlocks, @NotNull Vec3d pos, int radius) {
        Intrinsics.checkNotNullParameter($this$searchBlocks, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        return WorldUtils.searchBlocks$default($this$searchBlocks, pos, radius, null, 4, null);
    }

    private static final boolean searchBlocks$lambda$0(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "<unused var>");
        return true;
    }

    private static final boolean searchBlocks$lambda$3(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "<unused var>");
        return true;
    }

    private static final boolean searchBlocks$lambda$4(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "<unused var>");
        return true;
    }

    private static final boolean searchBlocks$lambda$5(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "<unused var>");
        return true;
    }

    private static final boolean searchBlocksSphere$lambda$6(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "<unused var>");
        return true;
    }

    private static final boolean searchBlocksSphere$lambda$7(Vec3d $pos, double $radius, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        BlockPos blockPos = (BlockPos)entry.getKey();
        return blockPos.func_177957_d($pos.field_72450_a, $pos.field_72448_b, $pos.field_72449_c) > $radius;
    }

    private static final boolean searchBlocksSphere$lambda$8(BlockPos blockPos, Block block) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(block, "<unused var>");
        return true;
    }
}


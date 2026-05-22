/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.Chunk
 *  net.minecraft.world.chunk.IChunkProvider
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.darkmeow.utils.world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rH\u0007JT\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017\u00a8\u0006\u0018"}, d2={"Lnet/darkmeow/darkmeow/utils/world/WorldUtils;", "", "<init>", "()V", "quickGetNearEntities", "", "Lnet/minecraft/entity/Entity;", "Lnet/minecraft/world/World;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "distance", "", "takeIf", "Lkotlin/Function1;", "", "quickGetNearTileEntities", "Ljava/util/HashMap;", "Lnet/minecraft/util/math/BlockPos;", "Lnet/minecraft/tileentity/TileEntity;", "Lkotlin/collections/HashMap;", "Lkotlin/Function2;", "findEntity", "input", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nWorldUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorldUtils.kt\nnet/darkmeow/darkmeow/utils/world/WorldUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,109:1\n2756#2:110\n295#2:114\n296#2:119\n1#3:111\n1#3:113\n640#4:112\n12637#5,2:115\n12637#5,2:117\n*S KotlinDebug\n*F\n+ 1 WorldUtils.kt\nnet/darkmeow/darkmeow/utils/world/WorldUtils\n*L\n39#1:110\n97#1:114\n97#1:119\n39#1:111\n78#1:113\n78#1:112\n105#1:115,2\n107#1:117,2\n*E\n"})
public final class WorldUtils {
    @NotNull
    public static final WorldUtils INSTANCE = new WorldUtils();

    private WorldUtils() {
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Set<Entity> quickGetNearEntities(@NotNull World $this$quickGetNearEntities, @NotNull EntityPlayerSP player, float distance, @NotNull Function1<? super Entity, Boolean> takeIf) {
        Set set;
        Intrinsics.checkNotNullParameter($this$quickGetNearEntities, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        Set $this$quickGetNearEntities_u24lambda_u243 = set = (Set)new LinkedHashSet();
        boolean bl2 = false;
        if (!(distance <= 0.0f)) {
            int baseSize = MathKt.roundToInt((float)Math.ceil(distance / 16.0f));
            IChunkProvider chunkManager = $this$quickGetNearEntities.func_72863_F();
            int chunkX = -baseSize;
            if (chunkX <= baseSize) {
                while (true) {
                    int chunkZ;
                    if ((chunkZ = -baseSize) <= baseSize) {
                        while (true) {
                            if (chunkManager.func_186026_b(player.field_70176_ah + chunkX, player.field_70164_aj + chunkZ) != null) {
                                Chunk chunk;
                                Chunk it = chunk;
                                boolean bl3 = false;
                                int chunkY = -baseSize;
                                if (chunkY <= baseSize) {
                                    while (true) {
                                        boolean bl4 = 0 <= chunkY ? chunkY < 17 : false;
                                        if (bl4) {
                                            Iterable iterable;
                                            Iterable $this$onEach$iv = (Iterable)it.func_177429_s()[player.field_70162_ai + chunkY];
                                            boolean $i$f$onEach = false;
                                            Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
                                            boolean bl5 = false;
                                            for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                                                Entity entity = (Entity)element$iv;
                                                boolean bl6 = false;
                                                Intrinsics.checkNotNull(entity);
                                                if (!takeIf.invoke((Entity)entity).booleanValue() || !(player.func_70032_d(entity) < distance)) continue;
                                                $this$quickGetNearEntities_u24lambda_u243.add(entity);
                                            }
                                        }
                                        if (chunkY == baseSize) break;
                                        ++chunkY;
                                    }
                                }
                            }
                            if (chunkZ == baseSize) break;
                            ++chunkZ;
                        }
                    }
                    if (chunkX == baseSize) break;
                    ++chunkX;
                }
            }
        }
        return set;
    }

    public static /* synthetic */ Set quickGetNearEntities$default(World world, EntityPlayerSP entityPlayerSP, float f2, Function1 function1, int n2, Object object) {
        if ((n2 & 4) != 0) {
            function1 = WorldUtils::quickGetNearEntities$lambda$0;
        }
        return WorldUtils.quickGetNearEntities(world, entityPlayerSP, f2, function1);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final HashMap<BlockPos, TileEntity> quickGetNearTileEntities(@NotNull World $this$quickGetNearTileEntities, @NotNull EntityPlayerSP player, float distance, @NotNull Function2<? super BlockPos, ? super TileEntity, Boolean> takeIf) {
        HashMap<BlockPos, TileEntity> hashMap;
        Intrinsics.checkNotNullParameter($this$quickGetNearTileEntities, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(takeIf, "takeIf");
        HashMap<BlockPos, TileEntity> $this$quickGetNearTileEntities_u24lambda_u246 = hashMap = new HashMap<BlockPos, TileEntity>();
        boolean bl2 = false;
        if (!(distance <= 0.0f)) {
            int baseSize = MathKt.roundToInt((float)Math.ceil(distance / 16.0f));
            IChunkProvider chunkManager = $this$quickGetNearTileEntities.func_72863_F();
            int chunkX = -baseSize;
            if (chunkX <= baseSize) {
                while (true) {
                    int chunkZ;
                    if ((chunkZ = -baseSize) <= baseSize) {
                        while (true) {
                            Map map;
                            Chunk chunk;
                            if ((chunk = chunkManager.func_186026_b(player.field_70176_ah + chunkX, player.field_70164_aj + chunkZ)) != null && (map = chunk.func_177434_r()) != null) {
                                void $this$onEach$iv;
                                void var15_15;
                                Map map2 = map;
                                boolean $i$f$onEach = false;
                                void $this$onEach_u24lambda_u242$iv = var15_15 = $this$onEach$iv;
                                boolean bl3 = false;
                                Iterator iterator2 = $this$onEach_u24lambda_u242$iv.entrySet().iterator();
                                while (iterator2.hasNext()) {
                                    Map.Entry element$iv;
                                    Map.Entry entry = element$iv = iterator2.next();
                                    boolean bl4 = false;
                                    BlockPos pos = (BlockPos)entry.getKey();
                                    TileEntity tile = (TileEntity)entry.getValue();
                                    Intrinsics.checkNotNull(pos);
                                    Intrinsics.checkNotNull(tile);
                                    if (!takeIf.invoke((BlockPos)pos, (TileEntity)tile).booleanValue() || !(player.func_174831_c(pos) < (double)(distance * distance))) continue;
                                    $this$quickGetNearTileEntities_u24lambda_u246.put(pos, tile);
                                }
                            }
                            if (chunkZ == baseSize) break;
                            ++chunkZ;
                        }
                    }
                    if (chunkX == baseSize) break;
                    ++chunkX;
                }
            }
        }
        return hashMap;
    }

    public static /* synthetic */ HashMap quickGetNearTileEntities$default(World world, EntityPlayerSP entityPlayerSP, float f2, Function2 function2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            function2 = WorldUtils::quickGetNearTileEntities$lambda$4;
        }
        return WorldUtils.quickGetNearTileEntities(world, entityPlayerSP, f2, function2);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final Entity findEntity(@NotNull World $this$findEntity, @NotNull String input) {
        Entity entity;
        Intrinsics.checkNotNullParameter($this$findEntity, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        List list = $this$findEntity.field_72996_f;
        if (list != null) {
            Object v6;
            block9: {
                Iterable $this$firstOrNull$iv = list;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    boolean bl2;
                    block8: {
                        void $this$any$iv;
                        boolean bl3;
                        Entity otherEntity = (Entity)element$iv;
                        boolean bl4 = false;
                        Boolean[] booleanArray = new Boolean[3];
                        booleanArray[0] = Intrinsics.areEqual(String.valueOf(otherEntity.func_145782_y()), input);
                        booleanArray[1] = Intrinsics.areEqual(otherEntity.func_110124_au().toString(), input);
                        Boolean[] booleanArray2 = booleanArray;
                        int n2 = 2;
                        if ((otherEntity instanceof EntityPlayer ? (EntityPlayer)otherEntity : null) != null) {
                            boolean bl5;
                            Boolean[] booleanArray3;
                            int n3;
                            block7: {
                                void $this$any$iv2;
                                void entityPlayer;
                                EntityPlayer entityPlayer2;
                                entityPlayer2 = entityPlayer2;
                                n3 = n2;
                                booleanArray3 = booleanArray2;
                                boolean bl6 = false;
                                Boolean[] booleanArray4 = new Boolean[]{Intrinsics.areEqual(entityPlayer.func_146103_bH().getName(), input), StringsKt.equals(entityPlayer.func_146103_bH().getId().toString(), input, true)};
                                boolean $i$f$any = false;
                                for (void element$iv2 : $this$any$iv2) {
                                    boolean it = element$iv2.booleanValue();
                                    boolean bl7 = false;
                                    if (!it) continue;
                                    bl5 = true;
                                    break block7;
                                }
                                bl5 = false;
                            }
                            boolean bl8 = bl5;
                            booleanArray2 = booleanArray3;
                            n2 = n3;
                            bl3 = bl8;
                        } else {
                            bl3 = false;
                        }
                        booleanArray2[n2] = bl3;
                        boolean $i$f$any = false;
                        for (void element$iv3 : $this$any$iv) {
                            boolean it = element$iv3.booleanValue();
                            boolean bl9 = false;
                            if (!it) continue;
                            bl2 = true;
                            break block8;
                        }
                        bl2 = false;
                    }
                    if (!bl2) continue;
                    v6 = element$iv;
                    break block9;
                }
                v6 = null;
            }
            entity = v6;
        } else {
            entity = null;
        }
        return entity;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Set<Entity> quickGetNearEntities(@NotNull World $this$quickGetNearEntities, @NotNull EntityPlayerSP player, float distance) {
        Intrinsics.checkNotNullParameter($this$quickGetNearEntities, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        return WorldUtils.quickGetNearEntities$default($this$quickGetNearEntities, player, distance, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final HashMap<BlockPos, TileEntity> quickGetNearTileEntities(@NotNull World $this$quickGetNearTileEntities, @NotNull EntityPlayerSP player, float distance) {
        Intrinsics.checkNotNullParameter($this$quickGetNearTileEntities, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        return WorldUtils.quickGetNearTileEntities$default($this$quickGetNearTileEntities, player, distance, null, 4, null);
    }

    private static final boolean quickGetNearEntities$lambda$0(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "<unused var>");
        return true;
    }

    private static final boolean quickGetNearTileEntities$lambda$4(BlockPos blockPos, TileEntity tileEntity) {
        Intrinsics.checkNotNullParameter(blockPos, "<unused var>");
        Intrinsics.checkNotNullParameter(tileEntity, "<unused var>");
        return true;
    }
}


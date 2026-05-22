/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.inventory.ItemStack
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.bukkit.util;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.bukkit.util.NMSUtil;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.logging.Level;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.Nullable;

public class LegacyBlockToItem {
    private static final LegacyBlockToItem INSTANCE;
    private static final Random RANDOM;
    private final Method GET_WORLD_HANDLE;
    private final Method GET_BLOCK_TYPE;
    private final Method GET_BLOCK;
    private final Method GET_ITEM_FOR_BLOCK;
    private final Method GET_DROP_TYPE;
    private final Method TO_BUKKIT_ITEM_STACK;
    private final Method NEW_BUKKIT_ITEM_STACK;
    private final Method SET_POSITION;
    private final Object BLOCK_POSITION;

    public LegacyBlockToItem() throws ReflectiveOperationException {
        Class<?> blockPosition = NMSUtil.nms("BlockPosition");
        Class<?> mutableBlockPosition = NMSUtil.nms("BlockPosition$MutableBlockPosition");
        Class<?> world = NMSUtil.nms("World");
        Class<?> block = NMSUtil.nms("Block");
        Class<?> iBlockData = NMSUtil.nms("IBlockData");
        Class<?> nmsItem = NMSUtil.nms("Item");
        Class<?> nmsItemStack = NMSUtil.nms("ItemStack");
        Class<?> craftItemStack = NMSUtil.obc("inventory.CraftItemStack");
        this.GET_WORLD_HANDLE = NMSUtil.obc("CraftWorld").getDeclaredMethod("getHandle", new Class[0]);
        this.GET_BLOCK_TYPE = world.getDeclaredMethod("getType", blockPosition);
        this.GET_BLOCK = iBlockData.getDeclaredMethod("getBlock", new Class[0]);
        this.GET_ITEM_FOR_BLOCK = block.getDeclaredMethod("i", iBlockData);
        this.GET_ITEM_FOR_BLOCK.setAccessible(true);
        this.GET_DROP_TYPE = block.getDeclaredMethod("getDropType", iBlockData, Random.class, Integer.TYPE);
        this.TO_BUKKIT_ITEM_STACK = craftItemStack.getDeclaredMethod("asCraftMirror", nmsItemStack);
        this.NEW_BUKKIT_ITEM_STACK = craftItemStack.getDeclaredMethod("asNewCraftStack", nmsItem);
        this.SET_POSITION = mutableBlockPosition.getDeclaredMethod("c", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        this.BLOCK_POSITION = mutableBlockPosition.getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    public static LegacyBlockToItem getInstance() {
        return INSTANCE;
    }

    public @Nullable ItemStack blockToItem(Block block) {
        try {
            Object nmsWorld = this.GET_WORLD_HANDLE.invoke(block.getWorld(), new Object[0]);
            this.SET_POSITION.invoke(this.BLOCK_POSITION, block.getX(), block.getY(), block.getZ());
            Object blockData = this.GET_BLOCK_TYPE.invoke(nmsWorld, this.BLOCK_POSITION);
            Object nmsBlock = this.GET_BLOCK.invoke(blockData, new Object[0]);
            Object nmsItemStack = this.GET_ITEM_FOR_BLOCK.invoke(nmsBlock, blockData);
            ItemStack stack = (ItemStack)this.TO_BUKKIT_ITEM_STACK.invoke(null, nmsItemStack);
            if (stack.getType() != Material.AIR) {
                return stack;
            }
            Object nmsItem = this.GET_DROP_TYPE.invoke(nmsBlock, blockData, RANDOM, 0);
            return (ItemStack)this.NEW_BUKKIT_ITEM_STACK.invoke(null, nmsItem);
        }
        catch (ReflectiveOperationException ex2) {
            Via.getPlatform().getLogger().log(Level.WARNING, "Failed when trying to find the right item for pick-block.", ex2);
            return null;
        }
    }

    static {
        RANDOM = new Random();
        LegacyBlockToItem instance = null;
        try {
            instance = new LegacyBlockToItem();
        }
        catch (ReflectiveOperationException ex2) {
            Via.getPlatform().getLogger().log(Level.WARNING, "Couldn't find reflection methods/fields for pick-block functionality.\nPick-block won't work on clients 1.21.4 and newer.", ex2);
        }
        INSTANCE = instance;
    }
}


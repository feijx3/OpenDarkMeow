/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemFactory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.inventory.meta.BlockStateMeta
 *  org.bukkit.inventory.meta.ItemMeta
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.bukkit.providers;

import com.viaversion.viaversion.ViaVersionPlugin;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.bukkit.platform.PaperViaInjector;
import com.viaversion.viaversion.bukkit.util.LegacyBlockToItem;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.provider.PickItemProvider;
import java.lang.reflect.Method;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={SetInHand.class, GetStorageContents.class, BlockToItem.class})
public class BukkitPickItemProvider
extends PickItemProvider {
    private static final BlockToItem BLOCK_TO_ITEM = BlockToItem.build();
    private static final GetStorageContents GET_STORAGE_CONTENT = GetStorageContents.build();
    private static final SetInHand SET_IN_HAND = SetInHand.build();
    private static final boolean HAS_SPAWN_EGG_METHOD = PaperViaInjector.hasMethod(ItemFactory.class, Material.class, "getSpawnEgg", EntityType.class);
    private static final Method GET_SPAWN_EGG_ITEMSTACK_METHOD;
    private static final double BLOCK_RANGE = 5.5;
    private static final double BLOCK_RANGE_SQUARED = 30.25;
    private static final double ENTITY_RANGE = 6.0;
    private final ViaVersionPlugin plugin;

    public BukkitPickItemProvider(ViaVersionPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void pickItemFromBlock(UserConnection connection, BlockPosition blockPosition, boolean includeData) {
        UUID uuid = connection.getProtocolInfo().getUuid();
        Player player = this.plugin.getServer().getPlayer(uuid);
        if (player == null) {
            return;
        }
        this.plugin.runSyncFor(() -> {
            Location playerLocation = player.getLocation();
            if (blockPosition.distanceFromCenterSquared(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ()) > 30.25) {
                return;
            }
            Block block = player.getWorld().getBlockAt(blockPosition.x(), blockPosition.y(), blockPosition.z());
            if (block.getType() == Material.AIR) {
                return;
            }
            ItemStack item = BLOCK_TO_ITEM.apply(block, includeData && player.getGameMode() == GameMode.CREATIVE);
            if (item != null && item.getType() != Material.AIR) {
                this.pickItem(player, item);
            }
        }, player);
    }

    @Override
    public void pickItemFromEntity(UserConnection connection, int entityId, boolean includeData) {
        if (!HAS_SPAWN_EGG_METHOD && GET_SPAWN_EGG_ITEMSTACK_METHOD == null) {
            return;
        }
        UUID uuid = connection.getProtocolInfo().getUuid();
        Player player = this.plugin.getServer().getPlayer(uuid);
        if (player == null) {
            return;
        }
        this.plugin.runSyncFor(() -> {
            Entity entity = player.getWorld().getNearbyEntities(player.getLocation(), 6.0, 6.0, 6.0).stream().filter(e2 -> e2.getEntityId() == entityId).findAny().orElse(null);
            if (entity == null) {
                return;
            }
            if (GET_SPAWN_EGG_ITEMSTACK_METHOD == null) {
                Material spawnEggType = Bukkit.getItemFactory().getSpawnEgg(entity.getType());
                if (spawnEggType != null) {
                    this.pickItem(player, new ItemStack(spawnEggType, 1));
                }
                return;
            }
            try {
                ItemStack spawnEggItem = (ItemStack)GET_SPAWN_EGG_ITEMSTACK_METHOD.invoke(Bukkit.getItemFactory(), entity.getType());
                if (spawnEggItem != null) {
                    this.pickItem(player, spawnEggItem);
                }
            }
            catch (ReflectiveOperationException e3) {
                throw new RuntimeException(e3);
            }
        }, player);
    }

    private void pickItem(Player player, ItemStack item) {
        PlayerInventory inventory = player.getInventory();
        ItemStack[] contents = GET_STORAGE_CONTENT.apply(inventory);
        int sourceSlot = -1;
        for (int i2 = 0; i2 < contents.length; ++i2) {
            ItemStack content = contents[i2];
            if (content == null || !content.isSimilar(item)) continue;
            sourceSlot = i2;
            break;
        }
        if (sourceSlot != -1) {
            this.moveToHotbar(inventory, sourceSlot, contents);
        } else if (player.getGameMode() == GameMode.CREATIVE) {
            this.spawnItem(item, inventory, contents);
        }
    }

    private void spawnItem(ItemStack item, PlayerInventory inventory, ItemStack[] contents) {
        int targetSlot = this.findEmptyHotbarSlot(inventory, inventory.getHeldItemSlot());
        inventory.setHeldItemSlot(targetSlot);
        ItemStack heldItem = inventory.getItem(targetSlot);
        int emptySlot = targetSlot;
        if (heldItem != null && heldItem.getType() != Material.AIR) {
            for (int i2 = 0; i2 < contents.length; ++i2) {
                if (contents[i2] != null && contents[i2].getType() != Material.AIR) continue;
                emptySlot = i2;
                break;
            }
        }
        inventory.setItem(emptySlot, heldItem);
        SET_IN_HAND.apply(inventory, item);
    }

    private void moveToHotbar(PlayerInventory inventory, int sourceSlot, ItemStack[] contents) {
        if (sourceSlot < 9) {
            inventory.setHeldItemSlot(sourceSlot);
            return;
        }
        int heldSlot = inventory.getHeldItemSlot();
        int targetSlot = this.findEmptyHotbarSlot(inventory, heldSlot);
        inventory.setHeldItemSlot(targetSlot);
        ItemStack heldItem = inventory.getItem(targetSlot);
        SET_IN_HAND.apply(inventory, contents[sourceSlot]);
        inventory.setItem(sourceSlot, heldItem);
    }

    private int findEmptyHotbarSlot(PlayerInventory inventory, int heldSlot) {
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemStack item = inventory.getItem(i2);
            if (item != null && item.getType() != Material.AIR) continue;
            return i2;
        }
        return heldSlot;
    }

    static {
        if (PaperViaInjector.hasMethod(ItemFactory.class, ItemStack.class, "getSpawnEgg", EntityType.class)) {
            try {
                GET_SPAWN_EGG_ITEMSTACK_METHOD = ItemFactory.class.getDeclaredMethod("getSpawnEgg", EntityType.class);
            }
            catch (ReflectiveOperationException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            GET_SPAWN_EGG_ITEMSTACK_METHOD = null;
        }
    }

    @FunctionalInterface
    @NestHost(value=BukkitPickItemProvider.class)
    private static interface GetStorageContents {
        public ItemStack[] apply(PlayerInventory var1);

        public static GetStorageContents build() {
            if (PaperViaInjector.hasMethod(Inventory.class, "getStorageContents", new Class[0])) {
                return Inventory::getStorageContents;
            }
            return Inventory::getContents;
        }
    }

    @FunctionalInterface
    @NestHost(value=BukkitPickItemProvider.class)
    private static interface SetInHand {
        public void apply(PlayerInventory var1, ItemStack var2);

        public static SetInHand build() {
            if (PaperViaInjector.hasMethod(PlayerInventory.class, "setItemInMainHand", new Class[0])) {
                return PlayerInventory::setItemInMainHand;
            }
            return PlayerInventory::setItemInHand;
        }
    }

    @FunctionalInterface
    @NestHost(value=BukkitPickItemProvider.class)
    private static interface BlockToItem {
        public ItemStack apply(Block var1, boolean var2);

        public static BlockToItem build() {
            if (PaperViaInjector.hasMethod("org.bukkit.block.data.BlockData", "getPlacementMaterial")) {
                return (block, includeData) -> {
                    ItemMeta patt8962$temp;
                    ItemStack item = new ItemStack(block.getBlockData().getPlacementMaterial(), 1);
                    if (includeData && (patt8962$temp = item.getItemMeta()) instanceof BlockStateMeta) {
                        BlockStateMeta blockStateMeta = (BlockStateMeta)patt8962$temp;
                        blockStateMeta.setBlockState(block.getState());
                        item.setItemMeta((ItemMeta)blockStateMeta);
                    }
                    return item;
                };
            }
            ProtocolVersion version = Via.getAPI().getServerVersion().lowestSupportedProtocolVersion();
            if (version.equalTo(ProtocolVersion.v1_8)) {
                LegacyBlockToItem legacy = LegacyBlockToItem.getInstance();
                return legacy != null ? (block, includeData) -> legacy.blockToItem(block) : (b2, i2) -> null;
            }
            if (PaperViaInjector.hasMethod(Material.class, "isItem", new Class[0])) {
                return (block, includeData) -> {
                    if (!block.getType().isItem()) {
                        return null;
                    }
                    return version.newerThanOrEqualTo(ProtocolVersion.v1_13) ? new ItemStack(block.getType()) : new ItemStack(block.getType(), 1, 0, Byte.valueOf(block.getData()));
                };
            }
            return (block, includeData) -> null;
        }
    }
}


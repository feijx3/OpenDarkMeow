/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.player.PlayerItemHeldEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.plugin.Plugin
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.bukkit.listeners.v1_20_5to1_21;

import com.viaversion.viaversion.ViaVersionPlugin;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.bukkit.listeners.ViaBukkitListener;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.EfficiencyAttributeStorage;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class, Slot.class})
public class PlayerChangeItemListener
extends ViaBukkitListener {
    protected final Enchantment efficiency = this.getByName("efficiency", "DIG_SPEED");
    protected final Enchantment aquaAffinity = this.getByName("aqua_affinity", "WATER_WORKER");
    protected final Enchantment depthStrider = this.getByName("depth_strider", "DEPTH_STRIDER");
    protected final Enchantment soulSpeed = this.getByName("soul_speed", "SOUL_SPEED");
    protected final Enchantment swiftSneak = this.getByName("swift_sneak", "SWIFT_SNEAK");

    public PlayerChangeItemListener(ViaVersionPlugin plugin) {
        super((Plugin)plugin, Protocol1_20_5To1_21.class);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItem(event.getNewSlot());
        this.sendAttributeUpdate(player, item, Slot.HAND);
    }

    protected EfficiencyAttributeStorage getEfficiencyStorage(UserConnection connection) {
        return connection != null ? connection.get(EfficiencyAttributeStorage.class) : null;
    }

    void sendAttributeUpdate(Player player, @Nullable ItemStack item, Slot slot) {
        EfficiencyAttributeStorage.ActiveEnchants activeEnchants;
        UserConnection connection = this.getUserConnection(player);
        EfficiencyAttributeStorage storage = this.getEfficiencyStorage(connection);
        if (storage == null) {
            return;
        }
        EfficiencyAttributeStorage.ActiveEnchants enchants = storage.activeEnchants();
        switch (slot) {
            default: {
                throw new IncompatibleClassChangeError();
            }
            case HAND: {
                activeEnchants = enchants.efficiency(item != null ? item.getEnchantmentLevel(this.efficiency) : 0);
                break;
            }
            case HELMET: {
                activeEnchants = enchants.aquaAffinity(item != null ? item.getEnchantmentLevel(this.aquaAffinity) : 0);
                break;
            }
            case LEGGINGS: {
                activeEnchants = enchants.swiftSneak(item != null && this.swiftSneak != null ? item.getEnchantmentLevel(this.swiftSneak) : 0);
                break;
            }
            case BOOTS: {
                activeEnchants = enchants.depthStrider(item != null && this.depthStrider != null ? item.getEnchantmentLevel(this.depthStrider) : 0);
            }
        }
        enchants = activeEnchants;
        storage.setEnchants(player.getEntityId(), connection, enchants);
    }

    private Enchantment getByName(String newName, String oldName) {
        Enchantment enchantment = Enchantment.getByName((String)newName);
        if (enchantment == null) {
            return Enchantment.getByName((String)oldName);
        }
        return enchantment;
    }

    @NestHost(value=PlayerChangeItemListener.class)
    static enum Slot {
        HAND,
        BOOTS,
        LEGGINGS,
        HELMET;

    }
}


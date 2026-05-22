/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.block.Block
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.plugin.Plugin
 */
package com.viaversion.viaversion.bukkit.listeners.v1_8to1_9;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.bukkit.listeners.ViaBukkitListener;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockListener
extends ViaBukkitListener {
    public BlockListener(Plugin plugin) {
        super(plugin, Protocol1_8To1_9.class);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void placeBlock(BlockPlaceEvent e2) {
        if (this.isOnPipe(e2.getPlayer())) {
            Block b2 = e2.getBlockPlaced();
            EntityTracker1_9 tracker = (EntityTracker1_9)this.getUserConnection(e2.getPlayer()).getEntityTracker(Protocol1_8To1_9.class);
            tracker.addBlockInteraction(new BlockPosition(b2.getX(), b2.getY(), b2.getZ()));
        }
    }
}


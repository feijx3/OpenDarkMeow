/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Entity
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.bukkit.commands;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="sender", type=CommandSender.class)})
public final class BukkitCommandSender
extends J_L_Record
implements ViaCommandSender {
    private final CommandSender sender;

    public BukkitCommandSender(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public void sendMessage(String msg) {
        this.sender.sendMessage(msg);
    }

    @Override
    public UUID getUUID() {
        CommandSender commandSender = this.sender;
        if (commandSender instanceof Entity) {
            Entity entity = (Entity)commandSender;
            return entity.getUniqueId();
        }
        return new UUID(0L, 0L);
    }

    @Override
    public String getName() {
        return this.sender.getName();
    }

    @Override
    public final String toString() {
        return BukkitCommandSender.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return BukkitCommandSender.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return BukkitCommandSender.jvmdowngrader$equals$equals(this, o2);
    }

    public CommandSender sender() {
        return this.sender;
    }

    private static String jvmdowngrader$toString$toString(BukkitCommandSender bukkitCommandSender) {
        BukkitCommandSender bukkitCommandSender2 = bukkitCommandSender;
        return "BukkitCommandSender[" + "sender=" + bukkitCommandSender.sender + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(BukkitCommandSender bukkitCommandSender) {
        Object[] objectArray = new Object[]{bukkitCommandSender.sender};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(BukkitCommandSender bukkitCommandSender, Object object) {
        if (bukkitCommandSender == object) {
            return true;
        }
        if (object != null && object instanceof BukkitCommandSender) {
            BukkitCommandSender bukkitCommandSender2 = (BukkitCommandSender)object;
            if (Objects.equals(bukkitCommandSender.sender, bukkitCommandSender2.sender)) {
                return true;
            }
        }
        return false;
    }
}


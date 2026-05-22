/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.velocitypowered.api.command.CommandSource
 *  com.velocitypowered.api.proxy.Player
 *  net.kyori.adventure.text.Component
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.velocity.command;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import com.viaversion.viaversion.VelocityPlugin;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="source", type=CommandSource.class)})
public final class VelocityCommandSender
extends J_L_Record
implements ViaCommandSender {
    private final CommandSource source;

    public VelocityCommandSender(CommandSource source) {
        this.source = source;
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.source.hasPermission(permission);
    }

    @Override
    public void sendMessage(String msg) {
        this.source.sendMessage((Component)VelocityPlugin.COMPONENT_SERIALIZER.deserialize(msg));
    }

    @Override
    public UUID getUUID() {
        CommandSource commandSource = this.source;
        if (commandSource instanceof Player) {
            Player player = (Player)commandSource;
            return player.getUniqueId();
        }
        return new UUID(0L, 0L);
    }

    @Override
    public String getName() {
        CommandSource commandSource = this.source;
        if (commandSource instanceof Player) {
            Player player = (Player)commandSource;
            return player.getUsername();
        }
        return "?";
    }

    @Override
    public final String toString() {
        return VelocityCommandSender.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return VelocityCommandSender.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return VelocityCommandSender.jvmdowngrader$equals$equals(this, o2);
    }

    public CommandSource source() {
        return this.source;
    }

    private static String jvmdowngrader$toString$toString(VelocityCommandSender velocityCommandSender) {
        VelocityCommandSender velocityCommandSender2 = velocityCommandSender;
        return "VelocityCommandSender[" + "source=" + velocityCommandSender.source + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(VelocityCommandSender velocityCommandSender) {
        Object[] objectArray = new Object[]{velocityCommandSender.source};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(VelocityCommandSender velocityCommandSender, Object object) {
        if (velocityCommandSender == object) {
            return true;
        }
        if (object != null && object instanceof VelocityCommandSender) {
            VelocityCommandSender velocityCommandSender2 = (VelocityCommandSender)object;
            if (Objects.equals(velocityCommandSender.source, velocityCommandSender2.source)) {
                return true;
            }
        }
        return false;
    }
}


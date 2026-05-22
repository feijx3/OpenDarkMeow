/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="seconds", type=float.class), @RecordComponents.Value(name="cooldownGroup", type=String.class)})
@NestMembers(value={1.class})
public final class UseCooldown
extends J_L_Record
implements Rewritable {
    private final float seconds;
    private final @Nullable String cooldownGroup;
    public static final Type<UseCooldown> TYPE = new Type<UseCooldown>(UseCooldown.class){

        @Override
        public UseCooldown read(ByteBuf buffer) {
            float seconds = buffer.readFloat();
            String cooldownGroup = (String)Types.OPTIONAL_STRING.read(buffer);
            return new UseCooldown(seconds, cooldownGroup);
        }

        @Override
        public void write(ByteBuf buffer, UseCooldown value) {
            buffer.writeFloat(value.seconds());
            Types.OPTIONAL_STRING.write(buffer, value.cooldownGroup());
        }

        @Override
        public void write(Ops ops, UseCooldown value) {
            Key cooldownGroup = value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_UseCooldown$get$cooldownGroup() != null ? Key.of(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_UseCooldown$get$cooldownGroup()) : null;
            ops.writeMap(map -> map.write("seconds", Types.FLOAT, Float.valueOf(value.seconds())).writeOptional("cooldown_group", Types.RESOURCE_LOCATION, cooldownGroup));
        }
    };

    public UseCooldown(float seconds, @Nullable String cooldownGroup) {
        this.seconds = seconds;
        this.cooldownGroup = cooldownGroup;
    }

    @Override
    public UseCooldown rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        if (this.cooldownGroup == null) {
            return this;
        }
        String mappedCooldownGroup = Rewritable.rewriteItem(protocol, clientbound, this.cooldownGroup);
        return new UseCooldown(this.seconds, mappedCooldownGroup);
    }

    @Override
    public final String toString() {
        return UseCooldown.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return UseCooldown.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return UseCooldown.jvmdowngrader$equals$equals(this, o2);
    }

    public float seconds() {
        return this.seconds;
    }

    public @Nullable String cooldownGroup() {
        return this.cooldownGroup;
    }

    private static String jvmdowngrader$toString$toString(UseCooldown useCooldown) {
        UseCooldown useCooldown2 = useCooldown;
        return "UseCooldown[" + "seconds=" + useCooldown.seconds + ", " + "cooldownGroup=" + useCooldown.cooldownGroup + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(UseCooldown useCooldown) {
        Object[] objectArray = new Object[]{Float.valueOf(useCooldown.seconds), useCooldown.cooldownGroup};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(UseCooldown useCooldown, Object object) {
        if (useCooldown == object) {
            return true;
        }
        if (object != null && object instanceof UseCooldown) {
            UseCooldown useCooldown2 = (UseCooldown)object;
            if (useCooldown.seconds == useCooldown2.seconds && Objects.equals(useCooldown.cooldownGroup, useCooldown2.cooldownGroup)) {
                return true;
            }
        }
        return false;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_UseCooldown$get$cooldownGroup() {
        return this.cooldownGroup;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_UseCooldown$set$cooldownGroup(String string) {
        this.cooldownGroup = string;
    }
}


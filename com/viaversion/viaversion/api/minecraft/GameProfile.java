/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="name", type=String.class), @RecordComponents.Value(name="id", type=UUID.class), @RecordComponents.Value(name="properties", type=Property[].class)})
@NestMembers(value={Property.class})
public final class GameProfile
extends J_L_Record {
    private final @Nullable String name;
    private final @Nullable UUID id;
    private final Property[] properties;

    public GameProfile(@Nullable String name, @Nullable UUID id) {
        this(name, id, new Property[0]);
    }

    public GameProfile(@Nullable String name, @Nullable UUID id, Property[] properties) {
        this.name = name;
        this.id = id;
        this.properties = properties;
    }

    public Map<String, List<Property>> propertiesMap() {
        HashMap<String, List<Property>> map = new HashMap<String, List<Property>>();
        for (Property property : this.properties) {
            map.computeIfAbsent(property.name(), k2 -> new ArrayList()).add(property);
        }
        return map;
    }

    @Override
    public final String toString() {
        return GameProfile.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return GameProfile.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return GameProfile.jvmdowngrader$equals$equals(this, o2);
    }

    public @Nullable String name() {
        return this.name;
    }

    public @Nullable UUID id() {
        return this.id;
    }

    public Property[] properties() {
        return this.properties;
    }

    private static String jvmdowngrader$toString$toString(GameProfile gameProfile) {
        GameProfile gameProfile2 = gameProfile;
        return "GameProfile[" + "name=" + gameProfile.name + ", " + "id=" + gameProfile.id + ", " + "properties=" + gameProfile.properties + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(GameProfile gameProfile) {
        Object[] objectArray = new Object[]{gameProfile.name, gameProfile.id, gameProfile.properties};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(GameProfile gameProfile, Object object) {
        if (gameProfile == object) {
            return true;
        }
        if (object != null && object instanceof GameProfile) {
            GameProfile gameProfile2 = (GameProfile)object;
            if (Objects.equals(gameProfile.name, gameProfile2.name) && Objects.equals(gameProfile.id, gameProfile2.id) && Objects.equals(gameProfile.properties, gameProfile2.properties)) {
                return true;
            }
        }
        return false;
    }

    @RecordComponents(value={@RecordComponents.Value(name="name", type=String.class), @RecordComponents.Value(name="value", type=String.class), @RecordComponents.Value(name="signature", type=String.class)})
    @NestHost(value=GameProfile.class)
    public static final class Property
    extends J_L_Record {
        private final String name;
        private final String value;
        private final @Nullable String signature;

        public Property(String name, String value) {
            this(name, value, null);
        }

        public Property(String name, String value, @Nullable String signature) {
            this.name = name;
            this.value = value;
            this.signature = signature;
        }

        @Override
        public final String toString() {
            return Property.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return Property.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Property.jvmdowngrader$equals$equals(this, o2);
        }

        public String name() {
            return this.name;
        }

        public String value() {
            return this.value;
        }

        public @Nullable String signature() {
            return this.signature;
        }

        private static String jvmdowngrader$toString$toString(Property property) {
            Property property2 = property;
            return "GameProfile$Property[" + "name=" + property.name + ", " + "value=" + property.value + ", " + "signature=" + property.signature + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(Property property) {
            Object[] objectArray = new Object[]{property.name, property.value, property.signature};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Property property, Object object) {
            if (property == object) {
                return true;
            }
            if (object != null && object instanceof Property) {
                Property property2 = (Property)object;
                if (Objects.equals(property.name, property2.name) && Objects.equals(property.value, property2.value) && Objects.equals(property.signature, property2.signature)) {
                    return true;
                }
            }
            return false;
        }
    }
}


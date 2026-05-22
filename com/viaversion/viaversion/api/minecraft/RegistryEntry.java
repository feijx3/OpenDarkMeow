/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.util.Copyable;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="key", type=String.class), @RecordComponents.Value(name="tag", type=Tag.class)})
public final class RegistryEntry
extends J_L_Record
implements Copyable {
    private final String key;
    private final @Nullable Tag tag;

    public RegistryEntry(String key, @Nullable Tag tag) {
        this.key = key;
        this.tag = tag;
    }

    public RegistryEntry withKey(String key) {
        return new RegistryEntry(key, this.tag != null ? this.tag.copy() : null);
    }

    @Override
    public RegistryEntry copy() {
        return new RegistryEntry(this.key, this.tag != null ? this.tag.copy() : null);
    }

    @Override
    public final String toString() {
        return RegistryEntry.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return RegistryEntry.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return RegistryEntry.jvmdowngrader$equals$equals(this, o2);
    }

    public String key() {
        return this.key;
    }

    public @Nullable Tag tag() {
        return this.tag;
    }

    private static String jvmdowngrader$toString$toString(RegistryEntry registryEntry) {
        RegistryEntry registryEntry2 = registryEntry;
        return "RegistryEntry[" + "key=" + registryEntry.key + ", " + "tag=" + registryEntry.tag + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(RegistryEntry registryEntry) {
        Object[] objectArray = new Object[]{registryEntry.key, registryEntry.tag};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(RegistryEntry registryEntry, Object object) {
        if (registryEntry == object) {
            return true;
        }
        if (object != null && object instanceof RegistryEntry) {
            RegistryEntry registryEntry2 = (RegistryEntry)object;
            if (Objects.equals(registryEntry.key, registryEntry2.key) && Objects.equals(registryEntry.tag, registryEntry2.tag)) {
                return true;
            }
        }
        return false;
    }
}


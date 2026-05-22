/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.type.types;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={Entry.class})
public final class FakeEnumType
extends VarIntType {
    private final Entry[] entries;

    public FakeEnumType(List<String> initialNames, Entry ... remainingEntries) {
        this.entries = new Entry[initialNames.size() + remainingEntries.length];
        for (int i2 = 0; i2 < initialNames.size(); ++i2) {
            this.entries[i2] = Entry.of(i2, initialNames.get(i2));
        }
        System.arraycopy(remainingEntries, 0, this.entries, initialNames.size(), remainingEntries.length);
    }

    public FakeEnumType(Entry ... entries) {
        this.entries = entries;
    }

    @Override
    public void write(Ops ops, Integer value) {
        Entry entry = null;
        for (Entry e2 : this.entries) {
            if (e2.jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$get$id() != value.intValue()) continue;
            entry = e2;
            break;
        }
        Types.STRING.write(ops, entry != null ? entry.jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$get$name() : this.entries[0].jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$get$name());
    }

    public Entry[] entries() {
        return this.entries;
    }

    @RecordComponents(value={@RecordComponents.Value(name="id", type=int.class), @RecordComponents.Value(name="name", type=String.class)})
    @NestHost(value=FakeEnumType.class)
    public static final class Entry
    extends J_L_Record {
        private final int id;
        private final String name;

        public Entry(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Entry of(int id, String name) {
            return new Entry(id, name);
        }

        @Override
        public final String toString() {
            return Entry.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return Entry.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Entry.jvmdowngrader$equals$equals(this, o2);
        }

        public int id() {
            return this.id;
        }

        public String name() {
            return this.name;
        }

        private static String jvmdowngrader$toString$toString(Entry entry) {
            Entry entry2 = entry;
            return "FakeEnumType$Entry[" + "id=" + entry.id + ", " + "name=" + entry.name + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(Entry entry) {
            Object[] objectArray = new Object[]{entry.id, entry.name};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Entry entry, Object object) {
            if (entry == object) {
                return true;
            }
            if (object != null && object instanceof Entry) {
                Entry entry2 = (Entry)object;
                if (entry.id == entry2.id && Objects.equals(entry.name, entry2.name)) {
                    return true;
                }
            }
            return false;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$get$name() {
            return this.name;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$set$name(String string) {
            this.name = string;
        }

        public int jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$get$id() {
            return this.id;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_api_type_types_FakeEnumType$Entry$set$id(int n2) {
            this.id = n2;
        }
    }
}


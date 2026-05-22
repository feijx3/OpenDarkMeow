/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={Ids.class, Tag.class})
final class HolderSetImpl {
    HolderSetImpl() {
    }

    @RecordComponents(value={@RecordComponents.Value(name="ids", type=int[].class)})
    @NestHost(value=HolderSetImpl.class)
    static final class Ids
    extends J_L_Record
    implements HolderSet {
        private final int[] ids;

        Ids(int[] ids) {
            this.ids = ids;
        }

        @Override
        public boolean hasTagKey() {
            return false;
        }

        @Override
        public String tagKey() {
            throw new IllegalArgumentException("This holder set has direct ids");
        }

        @Override
        public boolean hasIds() {
            return true;
        }

        @Override
        public HolderSet rewrite(Int2IntFunction idRewriter) {
            int[] mappedIds = new int[this.ids.length];
            int validCount = 0;
            for (int id : this.ids) {
                int mappedId = idRewriter.applyAsInt(id);
                if (mappedId == -1) continue;
                mappedIds[validCount++] = mappedId;
            }
            return new Ids(validCount == this.ids.length ? mappedIds : Arrays.copyOf(mappedIds, validCount));
        }

        @Override
        public String toString() {
            return Ids.jvmdowngrader$concat$toString$1(Arrays.toString(this.ids));
        }

        @Override
        public final int hashCode() {
            return Ids.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Ids.jvmdowngrader$equals$equals(this, o2);
        }

        @Override
        public int[] ids() {
            return this.ids;
        }

        private static int jvmdowngrader$hashCode$hashCode(Ids ids) {
            Object[] objectArray = new Object[]{ids.ids};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Ids ids, Object object) {
            if (ids == object) {
                return true;
            }
            if (object != null && object instanceof Ids) {
                Ids ids2 = (Ids)object;
                if (Objects.equals(ids.ids, ids2.ids)) {
                    return true;
                }
            }
            return false;
        }

        private static String jvmdowngrader$concat$toString$1(String string) {
            return "Ids{ids=" + string + "}";
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="tagKey", type=String.class)})
    @NestHost(value=HolderSetImpl.class)
    static final class Tag
    extends J_L_Record
    implements HolderSet {
        private final String tagKey;

        Tag(String tagKey) {
            this.tagKey = tagKey;
        }

        @Override
        public boolean hasTagKey() {
            return true;
        }

        @Override
        public int[] ids() {
            throw new IllegalArgumentException("This holder set has a tag key");
        }

        @Override
        public boolean hasIds() {
            return false;
        }

        @Override
        public HolderSet rewrite(Int2IntFunction idRewriter) {
            return this;
        }

        @Override
        public final String toString() {
            return Tag.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return Tag.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Tag.jvmdowngrader$equals$equals(this, o2);
        }

        @Override
        public String tagKey() {
            return this.tagKey;
        }

        private static String jvmdowngrader$toString$toString(Tag tag) {
            Tag tag2 = tag;
            return "HolderSetImpl$Tag[" + "tagKey=" + tag.tagKey + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(Tag tag) {
            Object[] objectArray = new Object[]{tag.tagKey};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Tag tag, Object object) {
            if (tag == object) {
                return true;
            }
            if (object != null && object instanceof Tag) {
                Tag tag2 = (Tag)object;
                if (Objects.equals(tag.tagKey, tag2.tagKey)) {
                    return true;
                }
            }
            return false;
        }
    }
}


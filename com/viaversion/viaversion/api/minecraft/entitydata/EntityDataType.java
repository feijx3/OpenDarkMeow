/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.entitydata;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={EntityDataTypeImpl.class})
public interface EntityDataType {
    public Type type();

    public int typeId();

    public static EntityDataType create(int typeId, Type<?> type) {
        return new EntityDataTypeImpl(typeId, type);
    }

    @NestHost(value=EntityDataType.class)
    public static final class EntityDataTypeImpl
    implements EntityDataType {
        private final int typeId;
        private final Type<?> type;

        EntityDataTypeImpl(int typeId, Type<?> type) {
            Preconditions.checkNotNull(type);
            this.typeId = typeId;
            this.type = type;
        }

        @Override
        public int typeId() {
            return this.typeId;
        }

        @Override
        public Type<?> type() {
            return this.type;
        }

        public String toString() {
            return EntityDataTypeImpl.jvmdowngrader$concat$toString$1(this.typeId, String.valueOf(this.type));
        }

        public boolean equals(Object o2) {
            if (this == o2) {
                return true;
            }
            if (o2 == null || this.getClass() != o2.getClass()) {
                return false;
            }
            EntityDataTypeImpl dataType = (EntityDataTypeImpl)o2;
            if (this.typeId != dataType.typeId) {
                return false;
            }
            return this.type.equals(dataType.type);
        }

        public int hashCode() {
            int result = this.typeId;
            result = 31 * result + this.type.hashCode();
            return result;
        }

        private static String jvmdowngrader$concat$toString$1(int n2, String string) {
            return "EntityDataTypeImpl{typeId=" + n2 + ", type=" + string + "}";
        }
    }
}


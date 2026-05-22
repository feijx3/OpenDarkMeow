/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.data.predicate;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="exactPredicates", type=StructuredData[].class), @RecordComponents.Value(name="predicates", type=DataComponentPredicate[].class)})
@NestMembers(value={DataComponentMatchersType.class})
public final class DataComponentMatchers
extends J_L_Record {
    private final StructuredData<?>[] exactPredicates;
    private final DataComponentPredicate[] predicates;

    public DataComponentMatchers(StructuredData<?>[] exactPredicates, DataComponentPredicate[] predicates) {
        this.exactPredicates = exactPredicates;
        this.predicates = predicates;
    }

    @Override
    public final String toString() {
        return DataComponentMatchers.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return DataComponentMatchers.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return DataComponentMatchers.jvmdowngrader$equals$equals(this, o2);
    }

    public StructuredData<?>[] exactPredicates() {
        return this.exactPredicates;
    }

    public DataComponentPredicate[] predicates() {
        return this.predicates;
    }

    private static String jvmdowngrader$toString$toString(DataComponentMatchers dataComponentMatchers) {
        DataComponentMatchers dataComponentMatchers2 = dataComponentMatchers;
        return "DataComponentMatchers[" + "exactPredicates=" + dataComponentMatchers.exactPredicates + ", " + "predicates=" + dataComponentMatchers.predicates + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(DataComponentMatchers dataComponentMatchers) {
        Object[] objectArray = new Object[]{dataComponentMatchers.exactPredicates, dataComponentMatchers.predicates};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(DataComponentMatchers dataComponentMatchers, Object object) {
        if (dataComponentMatchers == object) {
            return true;
        }
        if (object != null && object instanceof DataComponentMatchers) {
            DataComponentMatchers dataComponentMatchers2 = (DataComponentMatchers)object;
            if (Objects.equals(dataComponentMatchers.exactPredicates, dataComponentMatchers2.exactPredicates) && Objects.equals(dataComponentMatchers.predicates, dataComponentMatchers2.predicates)) {
                return true;
            }
        }
        return false;
    }

    @NestHost(value=DataComponentMatchers.class)
    public static final class DataComponentMatchersType
    extends Type<DataComponentMatchers> {
        private final Type<StructuredData<?>[]> dataArrayType;

        public DataComponentMatchersType(Type<StructuredData<?>[]> dataArrayType) {
            super(DataComponentMatchers.class);
            this.dataArrayType = dataArrayType;
        }

        @Override
        public DataComponentMatchers read(ByteBuf buffer) {
            StructuredData[] exactPredicates = (StructuredData[])this.dataArrayType.read(buffer);
            DataComponentPredicate[] partialPredicates = (DataComponentPredicate[])DataComponentPredicate.ARRAY_TYPE.read(buffer);
            return new DataComponentMatchers(exactPredicates, partialPredicates);
        }

        @Override
        public void write(ByteBuf buffer, DataComponentMatchers value) {
            this.dataArrayType.write(buffer, value.exactPredicates());
            DataComponentPredicate.ARRAY_TYPE.write(buffer, value.predicates());
        }
    }
}


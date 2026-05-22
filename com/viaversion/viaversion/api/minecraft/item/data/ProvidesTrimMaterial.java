/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.misc.EitherHolderType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="material", type=EitherHolder.class)})
@NestMembers(value={1.class})
public final class ProvidesTrimMaterial
extends J_L_Record
implements Rewritable {
    private final EitherHolder<ArmorTrimMaterial> material;
    public static final Type<ProvidesTrimMaterial> TYPE = new Type<ProvidesTrimMaterial>(ProvidesTrimMaterial.class){

        @Override
        public ProvidesTrimMaterial read(ByteBuf buffer) {
            EitherHolder<ArmorTrimMaterial> position = EitherHolderType.read(buffer, ArmorTrimMaterial.TYPE1_21_5);
            return new ProvidesTrimMaterial(position);
        }

        @Override
        public void write(ByteBuf buffer, ProvidesTrimMaterial value) {
            EitherHolderType.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ProvidesTrimMaterial$get$material(), ArmorTrimMaterial.TYPE1_21_5);
        }
    };

    public ProvidesTrimMaterial(EitherHolder<ArmorTrimMaterial> material) {
        this.material = material;
    }

    @Override
    public ProvidesTrimMaterial rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        if (this.material.hasKey() || this.material.holder().hasId()) {
            return this;
        }
        ArmorTrimMaterial trimMaterial = this.material.holder().value();
        return new ProvidesTrimMaterial(EitherHolder.of(Holder.of(trimMaterial.rewrite(connection, (Protocol)protocol, clientbound))));
    }

    @Override
    public final String toString() {
        return ProvidesTrimMaterial.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ProvidesTrimMaterial.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ProvidesTrimMaterial.jvmdowngrader$equals$equals(this, o2);
    }

    public EitherHolder<ArmorTrimMaterial> material() {
        return this.material;
    }

    private static String jvmdowngrader$toString$toString(ProvidesTrimMaterial providesTrimMaterial) {
        ProvidesTrimMaterial providesTrimMaterial2 = providesTrimMaterial;
        return "ProvidesTrimMaterial[" + "material=" + providesTrimMaterial.material + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ProvidesTrimMaterial providesTrimMaterial) {
        Object[] objectArray = new Object[]{providesTrimMaterial.material};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ProvidesTrimMaterial providesTrimMaterial, Object object) {
        if (providesTrimMaterial == object) {
            return true;
        }
        if (object != null && object instanceof ProvidesTrimMaterial) {
            ProvidesTrimMaterial providesTrimMaterial2 = (ProvidesTrimMaterial)object;
            if (Objects.equals(providesTrimMaterial.material, providesTrimMaterial2.material)) {
                return true;
            }
        }
        return false;
    }

    public EitherHolder jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ProvidesTrimMaterial$get$material() {
        return this.material;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_ProvidesTrimMaterial$set$material(EitherHolder eitherHolder) {
        this.material = eitherHolder;
    }
}


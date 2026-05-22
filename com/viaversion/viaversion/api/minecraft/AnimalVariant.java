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
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="modelType", type=int.class), @RecordComponents.Value(name="texture", type=String.class), @RecordComponents.Value(name="biomes", type=HolderSet.class)})
@NestMembers(value={1.class})
public final class AnimalVariant
extends J_L_Record {
    private final int modelType;
    private final String texture;
    private final @Nullable HolderSet biomes;
    public static HolderType<AnimalVariant> TYPE = new HolderType<AnimalVariant>(){

        @Override
        public AnimalVariant readDirect(ByteBuf buffer) {
            int modelType = Types.VAR_INT.readPrimitive(buffer);
            String texture = (String)Types.STRING.read(buffer);
            HolderSet biomes = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
            return new AnimalVariant(modelType, texture, biomes);
        }

        @Override
        public void writeDirect(ByteBuf buffer, AnimalVariant variant) {
            Types.VAR_INT.writePrimitive(buffer, variant.modelType());
            Types.STRING.write(buffer, variant.texture());
            Types.OPTIONAL_HOLDER_SET.write(buffer, variant.biomes());
        }
    };

    public AnimalVariant(int modelType, String texture, @Nullable HolderSet biomes) {
        this.modelType = modelType;
        this.texture = texture;
        this.biomes = biomes;
    }

    @Override
    public final String toString() {
        return AnimalVariant.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return AnimalVariant.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return AnimalVariant.jvmdowngrader$equals$equals(this, o2);
    }

    public int modelType() {
        return this.modelType;
    }

    public String texture() {
        return this.texture;
    }

    public @Nullable HolderSet biomes() {
        return this.biomes;
    }

    private static String jvmdowngrader$toString$toString(AnimalVariant animalVariant) {
        AnimalVariant animalVariant2 = animalVariant;
        return "AnimalVariant[" + "modelType=" + animalVariant.modelType + ", " + "texture=" + animalVariant.texture + ", " + "biomes=" + animalVariant.biomes + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(AnimalVariant animalVariant) {
        Object[] objectArray = new Object[]{animalVariant.modelType, animalVariant.texture, animalVariant.biomes};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(AnimalVariant animalVariant, Object object) {
        if (animalVariant == object) {
            return true;
        }
        if (object != null && object instanceof AnimalVariant) {
            AnimalVariant animalVariant2 = (AnimalVariant)object;
            if (animalVariant.modelType == animalVariant2.modelType && Objects.equals(animalVariant.texture, animalVariant2.texture) && Objects.equals(animalVariant.biomes, animalVariant2.biomes)) {
                return true;
            }
        }
        return false;
    }
}


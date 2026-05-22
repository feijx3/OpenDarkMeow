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
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="width", type=int.class), @RecordComponents.Value(name="height", type=int.class), @RecordComponents.Value(name="assetId", type=String.class), @RecordComponents.Value(name="title", type=Tag.class), @RecordComponents.Value(name="author", type=Tag.class)})
@NestMembers(value={2.class, 1.class})
public final class PaintingVariant
extends J_L_Record {
    private final int width;
    private final int height;
    private final String assetId;
    private final @Nullable Tag title;
    private final @Nullable Tag author;
    public static HolderType<PaintingVariant> TYPE1_21 = new HolderType<PaintingVariant>(){

        @Override
        public PaintingVariant readDirect(ByteBuf buffer) {
            int width = Types.VAR_INT.readPrimitive(buffer);
            int height = Types.VAR_INT.readPrimitive(buffer);
            String assetId = (String)Types.STRING.read(buffer);
            return new PaintingVariant(width, height, assetId);
        }

        @Override
        public void writeDirect(ByteBuf buffer, PaintingVariant variant) {
            Types.VAR_INT.writePrimitive(buffer, variant.width());
            Types.VAR_INT.writePrimitive(buffer, variant.height());
            Types.STRING.write(buffer, variant.assetId());
        }
    };
    public static HolderType<PaintingVariant> TYPE1_21_2 = new HolderType<PaintingVariant>(){

        @Override
        public PaintingVariant readDirect(ByteBuf buffer) {
            int width = Types.VAR_INT.readPrimitive(buffer);
            int height = Types.VAR_INT.readPrimitive(buffer);
            String assetId = (String)Types.STRING.read(buffer);
            Tag title = (Tag)Types.OPTIONAL_TAG.read(buffer);
            Tag author = (Tag)Types.OPTIONAL_TAG.read(buffer);
            return new PaintingVariant(width, height, assetId, title, author);
        }

        @Override
        public void writeDirect(ByteBuf buffer, PaintingVariant variant) {
            Types.VAR_INT.writePrimitive(buffer, variant.width());
            Types.VAR_INT.writePrimitive(buffer, variant.height());
            Types.STRING.write(buffer, variant.assetId());
            Types.OPTIONAL_TAG.write(buffer, variant.title());
            Types.OPTIONAL_TAG.write(buffer, variant.author());
        }
    };

    public PaintingVariant(int width, int height, String assetId) {
        this(width, height, assetId, null, null);
    }

    public PaintingVariant(int width, int height, String assetId, @Nullable Tag title, @Nullable Tag author) {
        this.width = width;
        this.height = height;
        this.assetId = assetId;
        this.title = title;
        this.author = author;
    }

    @Override
    public final String toString() {
        return PaintingVariant.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return PaintingVariant.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return PaintingVariant.jvmdowngrader$equals$equals(this, o2);
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public String assetId() {
        return this.assetId;
    }

    public @Nullable Tag title() {
        return this.title;
    }

    public @Nullable Tag author() {
        return this.author;
    }

    private static String jvmdowngrader$toString$toString(PaintingVariant paintingVariant) {
        PaintingVariant paintingVariant2 = paintingVariant;
        return "PaintingVariant[" + "width=" + paintingVariant.width + ", " + "height=" + paintingVariant.height + ", " + "assetId=" + paintingVariant.assetId + ", " + "title=" + paintingVariant.title + ", " + "author=" + paintingVariant.author + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(PaintingVariant paintingVariant) {
        Object[] objectArray = new Object[]{paintingVariant.width, paintingVariant.height, paintingVariant.assetId, paintingVariant.title, paintingVariant.author};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(PaintingVariant paintingVariant, Object object) {
        if (paintingVariant == object) {
            return true;
        }
        if (object != null && object instanceof PaintingVariant) {
            PaintingVariant paintingVariant2 = (PaintingVariant)object;
            if (paintingVariant.width == paintingVariant2.width && paintingVariant.height == paintingVariant2.height && Objects.equals(paintingVariant.assetId, paintingVariant2.assetId) && Objects.equals(paintingVariant.title, paintingVariant2.title) && Objects.equals(paintingVariant.author, paintingVariant2.author)) {
                return true;
            }
        }
        return false;
    }
}


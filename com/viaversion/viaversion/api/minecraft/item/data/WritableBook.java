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
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="pages", type=FilterableString[].class)})
@NestMembers(value={1.class})
public final class WritableBook
extends J_L_Record
implements Copyable {
    private final FilterableString[] pages;
    public static final Type<WritableBook> TYPE = new Type<WritableBook>(WritableBook.class){

        @Override
        public WritableBook read(ByteBuf buffer) {
            return new WritableBook((FilterableString[])FilterableString.ARRAY_TYPE.read(buffer));
        }

        @Override
        public void write(ByteBuf buffer, WritableBook value) {
            FilterableString.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WritableBook$get$pages());
        }

        @Override
        public void write(Ops ops, WritableBook writableBook) {
            ops.writeMap(map -> map.writeOptional("pages", FilterableString.ARRAY_TYPE, writableBook.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WritableBook$get$pages(), new FilterableString[0]));
        }
    };

    public WritableBook(FilterableString[] pages) {
        this.pages = pages;
    }

    @Override
    public WritableBook copy() {
        return new WritableBook(Copyable.copy(this.pages));
    }

    @Override
    public final String toString() {
        return WritableBook.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return WritableBook.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return WritableBook.jvmdowngrader$equals$equals(this, o2);
    }

    public FilterableString[] pages() {
        return this.pages;
    }

    private static String jvmdowngrader$toString$toString(WritableBook writableBook) {
        WritableBook writableBook2 = writableBook;
        return "WritableBook[" + "pages=" + writableBook.pages + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(WritableBook writableBook) {
        Object[] objectArray = new Object[]{writableBook.pages};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(WritableBook writableBook, Object object) {
        if (writableBook == object) {
            return true;
        }
        if (object != null && object instanceof WritableBook) {
            WritableBook writableBook2 = (WritableBook)object;
            if (Objects.equals(writableBook.pages, writableBook2.pages)) {
                return true;
            }
        }
        return false;
    }

    public FilterableString[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WritableBook$get$pages() {
        return this.pages;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WritableBook$set$pages(FilterableString[] filterableStringArray) {
        this.pages = filterableStringArray;
    }
}


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
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="title", type=FilterableString.class), @RecordComponents.Value(name="author", type=String.class), @RecordComponents.Value(name="generation", type=int.class), @RecordComponents.Value(name="pages", type=FilterableComponent[].class), @RecordComponents.Value(name="resolved", type=boolean.class)})
@NestMembers(value={1.class})
public final class WrittenBook
extends J_L_Record
implements Copyable {
    private final FilterableString title;
    private final String author;
    private final int generation;
    private final FilterableComponent[] pages;
    private final boolean resolved;
    public static final Type<WrittenBook> TYPE = new Type<WrittenBook>(WrittenBook.class){

        @Override
        public WrittenBook read(ByteBuf buffer) {
            FilterableString title = (FilterableString)FilterableString.TYPE.read(buffer);
            String author = (String)Types.STRING.read(buffer);
            int generation = Types.VAR_INT.readPrimitive(buffer);
            FilterableComponent[] pages = (FilterableComponent[])FilterableComponent.ARRAY_TYPE.read(buffer);
            boolean resolved = buffer.readBoolean();
            return new WrittenBook(title, author, generation, pages, resolved);
        }

        @Override
        public void write(ByteBuf buffer, WrittenBook value) {
            FilterableString.TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$title());
            Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$author());
            Types.VAR_INT.writePrimitive(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$generation());
            FilterableComponent.ARRAY_TYPE.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$pages());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$resolved());
        }

        @Override
        public void write(Ops ops, WrittenBook value) {
            ops.writeMap(map -> map.write("title", FilterableString.TYPE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$title()).write("author", Types.STRING, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$author()).writeOptional("generation", Types.INT, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$generation(), 0).writeOptional("pages", FilterableComponent.ARRAY_TYPE, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$pages(), new FilterableComponent[0]).writeOptional("resolved", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$resolved(), false));
        }
    };

    public WrittenBook(FilterableString title, String author, int generation, FilterableComponent[] pages, boolean resolved) {
        this.title = title;
        this.author = author;
        this.generation = generation;
        this.pages = pages;
        this.resolved = resolved;
    }

    @Override
    public WrittenBook copy() {
        return new WrittenBook(this.title, this.author, this.generation, Copyable.copy(this.pages), this.resolved);
    }

    @Override
    public final String toString() {
        return WrittenBook.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return WrittenBook.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return WrittenBook.jvmdowngrader$equals$equals(this, o2);
    }

    public FilterableString title() {
        return this.title;
    }

    public String author() {
        return this.author;
    }

    public int generation() {
        return this.generation;
    }

    public FilterableComponent[] pages() {
        return this.pages;
    }

    public boolean resolved() {
        return this.resolved;
    }

    private static String jvmdowngrader$toString$toString(WrittenBook writtenBook) {
        WrittenBook writtenBook2 = writtenBook;
        return "WrittenBook[" + "title=" + writtenBook.title + ", " + "author=" + writtenBook.author + ", " + "generation=" + writtenBook.generation + ", " + "pages=" + writtenBook.pages + ", " + "resolved=" + writtenBook.resolved + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(WrittenBook writtenBook) {
        Object[] objectArray = new Object[]{writtenBook.title, writtenBook.author, writtenBook.generation, writtenBook.pages, writtenBook.resolved};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(WrittenBook writtenBook, Object object) {
        if (writtenBook == object) {
            return true;
        }
        if (object != null && object instanceof WrittenBook) {
            WrittenBook writtenBook2 = (WrittenBook)object;
            if (Objects.equals(writtenBook.title, writtenBook2.title) && Objects.equals(writtenBook.author, writtenBook2.author) && writtenBook.generation == writtenBook2.generation && Objects.equals(writtenBook.pages, writtenBook2.pages) && writtenBook.resolved == writtenBook2.resolved) {
                return true;
            }
        }
        return false;
    }

    public int jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$generation() {
        return this.generation;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$set$generation(int n2) {
        this.generation = n2;
    }

    public FilterableComponent[] jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$pages() {
        return this.pages;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$set$pages(FilterableComponent[] filterableComponentArray) {
        this.pages = filterableComponentArray;
    }

    public FilterableString jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$title() {
        return this.title;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$set$title(FilterableString filterableString) {
        this.title = filterableString;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$author() {
        return this.author;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$set$author(String string) {
        this.author = string;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$get$resolved() {
        return this.resolved;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_WrittenBook$set$resolved(boolean bl2) {
        this.resolved = bl2;
    }
}


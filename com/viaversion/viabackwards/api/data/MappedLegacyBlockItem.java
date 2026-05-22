/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.util.IdAndData;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={Type.class, BlockEntityHandler.class})
public class MappedLegacyBlockItem {
    private final int id;
    private final short data;
    private final String name;
    private final IdAndData block;
    private BlockEntityHandler blockEntityHandler;

    public MappedLegacyBlockItem(int id) {
        this(id, -1, null, Type.ITEM);
    }

    public MappedLegacyBlockItem(int id, short data, @Nullable String name, Type type) {
        this.id = id;
        this.data = data;
        String string = this.name = name != null ? MappedLegacyBlockItem.jvmdowngrader$concat$$init$$1(name) : null;
        this.block = type != Type.ITEM ? (data != -1 ? new IdAndData(id, data) : new IdAndData(id)) : null;
    }

    public int getId() {
        return this.id;
    }

    public short getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public IdAndData getBlock() {
        return this.block;
    }

    public boolean hasBlockEntityHandler() {
        return this.blockEntityHandler != null;
    }

    public @Nullable BlockEntityHandler getBlockEntityHandler() {
        return this.blockEntityHandler;
    }

    public void setBlockEntityHandler(@Nullable BlockEntityHandler blockEntityHandler) {
        this.blockEntityHandler = blockEntityHandler;
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "\u00a7f" + string;
    }

    @NestHost(value=MappedLegacyBlockItem.class)
    public static enum Type {
        ITEM("items"),
        BLOCK_ITEM("block-items"),
        BLOCK("blocks");

        final String name;

        private Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    @FunctionalInterface
    @NestHost(value=MappedLegacyBlockItem.class)
    public static interface BlockEntityHandler {
        public void handleCompoundTag(int var1, CompoundTag var2);
    }
}


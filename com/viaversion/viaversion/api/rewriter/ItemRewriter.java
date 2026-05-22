/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.rewriter.Rewriter;
import com.viaversion.viaversion.api.type.Type;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ItemRewriter<T extends Protocol<?, ?, ?, ?>>
extends Rewriter<T> {
    public @Nullable Item handleItemToClient(UserConnection var1, @Nullable Item var2);

    public @Nullable Item handleItemToServer(UserConnection var1, @Nullable Item var2);

    public HashedItem handleHashedItem(UserConnection var1, HashedItem var2);

    default public @Nullable Type<Item> itemType() {
        return null;
    }

    default public @Nullable Type<Item[]> itemArrayType() {
        return null;
    }

    default public @Nullable Type<Item> mappedItemType() {
        return this.itemType();
    }

    default public @Nullable Type<Item[]> mappedItemArrayType() {
        return this.itemArrayType();
    }

    default public String nbtTagName() {
        return ItemRewriter.jvmdowngrader$concat$nbtTagName$1(this.protocol().getClass().getSimpleName());
    }

    default public String nbtTagName(String nbt) {
        return ItemRewriter.jvmdowngrader$concat$nbtTagName$1(this.nbtTagName(), nbt);
    }

    private static String jvmdowngrader$concat$nbtTagName$1(String string) {
        return "VV|" + string;
    }

    private static String jvmdowngrader$concat$nbtTagName$1(String string, String string2) {
        return string + "|" + string2;
    }
}


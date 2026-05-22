/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.util.Key;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

final class RegistryAccessImpl
implements CodecContext.RegistryAccess {
    private final List<String> enchantments;
    private final MappingData mappingData;
    private final boolean mapped;

    RegistryAccessImpl(List<String> enchantments, MappingData mappingData) {
        this.enchantments = enchantments;
        this.mappingData = mappingData;
        this.mapped = false;
    }

    private RegistryAccessImpl(List<String> enchantments, MappingData mappingData, boolean mapped) {
        this.enchantments = enchantments;
        this.mappingData = mappingData;
        this.mapped = mapped;
    }

    @Override
    public Key item(int id) {
        return this.key(this.mappingData.getFullItemMappings(), id);
    }

    @Override
    public Key enchantment(int id) {
        String identifier = id >= 0 && id < this.enchantments.size() ? this.enchantments.get(id) : null;
        return this.key(identifier, id);
    }

    @Override
    public Key attributeModifier(int id) {
        return this.key(this.mappingData.getAttributeMappings(), id);
    }

    @Override
    public Key dataComponentType(int id) {
        return this.key(this.mappingData.getDataComponentSerializerMappings(), id);
    }

    private Key key(FullMappings mappings, int id) {
        String identifier = this.mapped ? mappings.mappedIdentifier(id) : mappings.identifier(id);
        return this.key(identifier, id);
    }

    private Key key(@Nullable String identifier, int id) {
        return identifier != null ? Key.of(identifier) : Key.of("viaversion", RegistryAccessImpl.jvmdowngrader$concat$key$1(id));
    }

    @Override
    public CodecContext.RegistryAccess withMapped(boolean mapped) {
        return this.mapped == mapped ? this : new RegistryAccessImpl(this.enchantments, this.mappingData, mapped);
    }

    private static String jvmdowngrader$concat$key$1(int n2) {
        return "unknown/" + n2;
    }
}


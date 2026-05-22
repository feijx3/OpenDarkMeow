/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.codec.RegistryAccessImpl;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.util.Key;
import java.util.List;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={RegistryAccess.class})
public interface CodecContext {
    public RegistryAccess registryAccess();

    public boolean mapped();

    public boolean isSupported(StructuredDataKey<?> var1);

    @NestHost(value=CodecContext.class)
    public static interface RegistryAccess {
        public Key item(int var1);

        public Key enchantment(int var1);

        public Key attributeModifier(int var1);

        public Key dataComponentType(int var1);

        public static RegistryAccess of(List<String> enchantments, MappingData mappingData) {
            return new RegistryAccessImpl(enchantments, mappingData);
        }

        public RegistryAccess withMapped(boolean var1);
    }
}


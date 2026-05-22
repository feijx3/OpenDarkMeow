/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;

public class BackwardsRegistryRewriter
extends RegistryDataRewriter {
    private final BackwardsProtocol<?, ?, ?, ?> protocol;

    public BackwardsRegistryRewriter(BackwardsProtocol<?, ?, ?, ?> protocol) {
        super(protocol);
        this.protocol = protocol;
    }

    @Override
    public void updateJukeboxSongs(RegistryEntry[] entries) {
        for (RegistryEntry entry : entries) {
            String mappedNamedSound;
            StringTag soundEvent;
            if (entry.tag() == null || (soundEvent = ((CompoundTag)entry.tag()).getStringTag("sound_event")) == null || (mappedNamedSound = this.protocol.getMappingData().getMappedNamedSound(soundEvent.getValue())) == null) continue;
            soundEvent.setValue(mappedNamedSound);
        }
    }
}


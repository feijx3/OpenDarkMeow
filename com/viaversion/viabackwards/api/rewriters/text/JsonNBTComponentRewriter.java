/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viabackwards.api.rewriters.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.TranslatableMappings;
import com.viaversion.viabackwards.api.rewriters.text.TranslatableRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class JsonNBTComponentRewriter<C extends ClientboundPacketType>
extends com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter<C>
implements TranslatableRewriter {
    private final Map<String, String> translatables;

    public JsonNBTComponentRewriter(BackwardsProtocol<C, ?, ?, ?> protocol, ComponentRewriterBase.ReadType type) {
        super(protocol, type);
        this.translatables = TranslatableMappings.translatablesFor(protocol);
    }

    public JsonNBTComponentRewriter(BackwardsProtocol<C, ?, ?, ?> protocol, ComponentRewriterBase.ReadType type, String version) {
        super(protocol, type);
        this.translatables = TranslatableMappings.translatablesFor(version);
    }

    @Override
    protected void handleTranslate(JsonObject root, String translate) {
        String newTranslate = this.mappedTranslationKey(translate);
        if (newTranslate != null) {
            root.addProperty("translate", newTranslate);
        }
    }

    @Override
    protected void handleTranslate(UserConnection connection, CompoundTag parentTag, StringTag translateTag) {
        String newTranslate = this.mappedTranslationKey(translateTag.getValue());
        if (newTranslate != null) {
            parentTag.put("translate", new StringTag(newTranslate));
        }
    }

    @Override
    public @Nullable String mappedTranslationKey(String translationKey) {
        return this.translatables.get(translationKey);
    }
}


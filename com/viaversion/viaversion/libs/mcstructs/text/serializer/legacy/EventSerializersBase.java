/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy.SerializerMap;

public abstract class EventSerializersBase {
    protected final SerializerMap<ClickEvent, ClickEventAction, String> clickEventSerializer;
    protected final SerializerMap<HoverEvent, HoverEventAction, TextComponent> hoverEventSerializer;

    public EventSerializersBase(SNbt<?> sNbt) {
        this.clickEventSerializer = this.createClickEventSerializer(SerializerMap.create(sNbt));
        this.hoverEventSerializer = this.createHoverEventSerializer(SerializerMap.create(sNbt));
    }

    protected abstract SerializerMap<ClickEvent, ClickEventAction, String> createClickEventSerializer(SerializerMap.Builder<ClickEvent, ClickEventAction, String> var1);

    protected abstract SerializerMap<HoverEvent, HoverEventAction, TextComponent> createHoverEventSerializer(SerializerMap.Builder<HoverEvent, HoverEventAction, TextComponent> var1);
}


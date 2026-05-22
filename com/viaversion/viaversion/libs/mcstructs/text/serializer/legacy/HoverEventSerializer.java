/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.AchievementHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy.EventSerializer;
import java.util.function.Predicate;

public class HoverEventSerializer<T extends HoverEvent>
extends EventSerializer<HoverEvent, T, HoverEventAction, TextComponent> {
    public static final HoverEventSerializer<TextHoverEvent> TEXT = HoverEventSerializer.createBasic(TextHoverEvent.class::isInstance, TextHoverEvent::getText, HoverEventAction.SHOW_TEXT, TextHoverEvent::new);
    public static final HoverEventSerializer<AchievementHoverEvent> ACHIEVEMENT = HoverEventSerializer.createBasic(AchievementHoverEvent.class::isInstance, hoverEvent -> new StringComponent(hoverEvent.getStatistic()), HoverEventAction.SHOW_ACHIEVEMENT, statistic -> new AchievementHoverEvent(statistic.asUnformattedString()));
    public static final HoverEventSerializer<ItemHoverEvent> LEGACY_ITEM = HoverEventSerializer.createBasic(hoverEvent -> hoverEvent instanceof ItemHoverEvent && ((ItemHoverEvent)hoverEvent).isLegacy(), hoverEvent -> {
        ItemHoverEvent.LegacyHolder itemData = (ItemHoverEvent.LegacyHolder)hoverEvent.getData();
        return new StringComponent(itemData.getData());
    }, HoverEventAction.SHOW_ITEM, value -> new ItemHoverEvent(value.asUnformattedString()));
    public static final HoverEventSerializer<EntityHoverEvent> LEGACY_ENTITY = HoverEventSerializer.createBasic(hoverEvent -> hoverEvent instanceof EntityHoverEvent && ((EntityHoverEvent)hoverEvent).getData() instanceof EntityHoverEvent.LegacyHolder, hoverEvent -> ((EntityHoverEvent.LegacyHolder)hoverEvent.getData()).getData(), HoverEventAction.SHOW_ENTITY, EntityHoverEvent::new);

    private static <T extends HoverEvent> HoverEventSerializer<T> createBasic(Predicate<HoverEvent> classMatcher, EventSerializer.BasicIOFunction<T, TextComponent> serializer, HoverEventAction action, EventSerializer.BasicIOFunction<TextComponent, T> deserializer) {
        return new HoverEventSerializer<T>(classMatcher, serializer, action, deserializer);
    }

    private static <T extends HoverEvent> HoverEventSerializer<T> createSNbt(Predicate<HoverEvent> classMatcher, EventSerializer.IOFunction<T, TextComponent> serializer, HoverEventAction action, EventSerializer.IOFunction<TextComponent, T> deserializer) {
        return new HoverEventSerializer<T>(classMatcher, serializer, action, deserializer);
    }

    protected HoverEventSerializer(Predicate<HoverEvent> classMatcher, EventSerializer.IOFunction<T, TextComponent> serializer, HoverEventAction action, EventSerializer.IOFunction<TextComponent, T> deserializer) {
        super(classMatcher, serializer, action, deserializer);
    }
}


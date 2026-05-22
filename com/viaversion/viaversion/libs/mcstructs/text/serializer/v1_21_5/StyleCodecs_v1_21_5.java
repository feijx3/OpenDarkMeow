/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_5;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.map.MapCodecMerger;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.CopyToClipboardClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenFileClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.RunCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.SuggestCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.TextHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_5.ExtraCodecs_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_5.TextCodecs_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_21_5.TextVerifier_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.verify.VerifyingConverter;

public class StyleCodecs_v1_21_5 {
    public static final MapCodec<Style> MAP_CODEC = MapCodecMerger.mapCodec(TextFormattingCodec.CODEC.mapCodec("color").optional().defaulted(null), Style::getColor, ExtraCodecs_v1_21_5.ARGB_COLOR.mapCodec("shadow_color").optional().defaulted(null), Style::getShadowColor, Codec.BOOLEAN.mapCodec("obfuscated").optional().defaulted(null), Style::getObfuscated, Codec.BOOLEAN.mapCodec("bold").optional().defaulted(null), Style::getBold, Codec.BOOLEAN.mapCodec("strikethrough").optional().defaulted(null), Style::getStrikethrough, Codec.BOOLEAN.mapCodec("underlined").optional().defaulted(null), Style::getUnderlined, Codec.BOOLEAN.mapCodec("italic").optional().defaulted(null), Style::getItalic, ClickEventCodec.CODEC.mapCodec("click_event").optional().defaulted(null), Style::getClickEvent, HoverEventCodec.CODEC.mapCodec("hover_event").optional().defaulted(null), Style::getHoverEvent, Codec.STRING.mapCodec("insertion").optional().defaulted(null), Style::getInsertion, Codec.STRING_IDENTIFIER.mapCodec("font").optional().defaulted(null), Style::getFont, Style::new);
    public static final Codec<Style> CODEC = MAP_CODEC.asCodec();

    public static class HoverEventCodec {
        public static final MapCodec<TextHoverEvent> TEXT = MapCodecMerger.mapCodec(TextCodecs_v1_21_5.TEXT.mapCodec("value").required(), TextHoverEvent::getText, TextHoverEvent::new);
        public static final MapCodec<ItemHoverEvent> ITEM = MapCodecMerger.mapCodec(Codec.STRING_IDENTIFIER.converterVerified(VerifyingConverter.verify(TextVerifier_v1_21_5.class, TextVerifier_v1_21_5::verifyRegistryItem, "Invalid item")).mapCodec("id").required(), hoverEvent -> hoverEvent.asModern().getId(), Codec.rangedInt(1, 99).mapCodec("count").optional().elseGet(() -> 1), hoverEvent -> hoverEvent.asModern().getCount(), NbtConverter_v1_20_3.INSTANCE.toCodec().verified(tag -> {
            if (!(tag instanceof CompoundTag)) {
                return Result.error("Expected a compound tag");
            }
            return null;
        }).map(tag -> tag, tag -> (CompoundTag)tag).converterVerified(VerifyingConverter.verify(TextVerifier_v1_21_5.class, TextVerifier_v1_21_5::verifyDataComponents, "Invalid data components")).mapCodec("components").optional().defaulted(null), hoverEvent -> hoverEvent.asModern().getTag(), ItemHoverEvent::new);
        public static final MapCodec<EntityHoverEvent> ENTITY = MapCodecMerger.mapCodec(Codec.STRING_IDENTIFIER.converterVerified(VerifyingConverter.verify(TextVerifier_v1_21_5.class, TextVerifier_v1_21_5::verifyRegistryEntity, "Invalid entity")).mapCodec("id").required(), hoverEvent -> hoverEvent.asModern().getType(), ExtraCodecs_v1_21_5.LENIENT_UUID.mapCodec("uuid").required(), hoverEvent -> hoverEvent.asModern().getUuid(), TextCodecs_v1_21_5.TEXT.mapCodec("name").optional().defaulted(null), hoverEvent -> hoverEvent.asModern().getName(), EntityHoverEvent::new);
        public static final Codec<HoverEvent> CODEC = Codec.named((NamedType[])new HoverEventAction[]{HoverEventAction.SHOW_TEXT, HoverEventAction.SHOW_ITEM, HoverEventAction.SHOW_ENTITY}).verified(action -> {
            if (action.isUserDefinable()) {
                return null;
            }
            return Result.error("The action " + action.getName() + " is not user definable");
        }).typed("action", HoverEvent::getAction, action -> {
            switch (action) {
                case SHOW_TEXT: {
                    return TEXT;
                }
                case SHOW_ITEM: {
                    return ITEM;
                }
                case SHOW_ENTITY: {
                    return ENTITY;
                }
            }
            return MapCodec.failing("Unknown hover event action: " + action);
        });
    }

    public static class ClickEventCodec {
        public static final MapCodec<OpenUrlClickEvent> OPEN_URL = MapCodecMerger.mapCodec(ExtraCodecs_v1_21_5.UNTRUSTED_URI.mapCodec("url").required(), OpenUrlClickEvent::asUri, ClickEvent::openUrl);
        public static final MapCodec<OpenFileClickEvent> OPEN_FILE = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("path").required(), OpenFileClickEvent::getPath, ClickEvent::openFile);
        public static final MapCodec<RunCommandClickEvent> RUN_COMMAND = MapCodecMerger.mapCodec(ExtraCodecs_v1_21_5.CHAT_STRING.mapCodec("command").required(), RunCommandClickEvent::getCommand, ClickEvent::runCommand);
        public static final MapCodec<SuggestCommandClickEvent> SUGGEST_COMMAND = MapCodecMerger.mapCodec(ExtraCodecs_v1_21_5.CHAT_STRING.mapCodec("command").required(), SuggestCommandClickEvent::getCommand, ClickEvent::suggestCommand);
        public static final MapCodec<ChangePageClickEvent> CHANGE_PAGE = MapCodecMerger.mapCodec(Codec.minInt(1).mapCodec("page").required(), ChangePageClickEvent::asInt, ClickEvent::changePage);
        public static final MapCodec<CopyToClipboardClickEvent> COPY_TO_CLIPBOARD = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("value").required(), CopyToClipboardClickEvent::getValue, ClickEvent::copyToClipboard);
        public static final Codec<ClickEvent> CODEC = Codec.named((NamedType[])new ClickEventAction[]{ClickEventAction.OPEN_URL, ClickEventAction.OPEN_FILE, ClickEventAction.RUN_COMMAND, ClickEventAction.SUGGEST_COMMAND, ClickEventAction.CHANGE_PAGE, ClickEventAction.COPY_TO_CLIPBOARD}).verified(type -> {
            if (type.isUserDefinable()) {
                return null;
            }
            return Result.error("The action " + type.getName() + " is not user definable");
        }).typed("action", ClickEvent::getAction, action -> {
            switch (action) {
                case OPEN_URL: {
                    return OPEN_URL;
                }
                case OPEN_FILE: {
                    return OPEN_FILE;
                }
                case RUN_COMMAND: {
                    return RUN_COMMAND;
                }
                case SUGGEST_COMMAND: {
                    return SUGGEST_COMMAND;
                }
                case CHANGE_PAGE: {
                    return CHANGE_PAGE;
                }
                case COPY_TO_CLIPBOARD: {
                    return COPY_TO_CLIPBOARD;
                }
            }
            return MapCodec.failing("Unknown click event action: " + action);
        });
    }

    public static class TextFormattingCodec {
        public static final Codec<TextFormatting> CODEC = Codec.STRING.flatMap(formatting -> Result.success(formatting.serialize()), s2 -> {
            TextFormatting formatting = TextFormatting.parse(s2);
            if (formatting == null) {
                return Result.error("Unknown formatting: " + s2);
            }
            if (formatting.isRGBColor() && (formatting.getRgbValue() < 0 || formatting.getRgbValue() > 0xFFFFFF)) {
                return Result.error("Out of range RGB value: " + s2);
            }
            return Result.success(formatting);
        });
    }
}


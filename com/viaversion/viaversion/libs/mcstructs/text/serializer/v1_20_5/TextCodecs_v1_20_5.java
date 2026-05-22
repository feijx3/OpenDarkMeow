/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5;

import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.impl.LazyInitCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.map.MapCodecMerger;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.JavaConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Either;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.KeybindComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.NbtComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.ScoreComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.SelectorComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.BlockNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.EntityNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.StorageNbtSource;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_3.TextCodecs_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.v1_20_5.StyleCodecs_v1_20_5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Generated;

public class TextCodecs_v1_20_5 {
    public static final Codec<TextComponent> TEXT = new LazyInitCodec<TextComponent>(() -> Codec.recursive(thiz -> TextCodecs_v1_20_3.createCodec((Codec)thiz, StyleCodecs_v1_20_5.MAP_CODEC, (TextCodecs_v1_20_3.TextComponentType[])ComponentType.values(), ComponentType::forComponent)));
    public static final MapCodec<StringComponent> STRING_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("text").required(), StringComponent::getText, StringComponent::new);
    public static final MapCodec<TranslationComponent> TRANSLATION_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("translate").required(), TranslationComponent::getKey, Codec.STRING.mapCodec("fallback").optional().lenient().defaulted(null), TranslationComponent::getFallback, Codec.either(JavaConverter_v1_20_3.INSTANCE.toCodec().verified(o2 -> {
        if (o2 instanceof Boolean || o2 instanceof Number || o2 instanceof String) {
            return null;
        }
        return Result.error("Invalid value type: " + o2.getClass().getName());
    }), TEXT).map(o2 -> o2 instanceof TextComponent ? Either.right((TextComponent)o2) : Either.left(o2), either -> {
        if (either.isLeft()) {
            return either.getLeft();
        }
        String collapsed = TextCodecs_v1_20_3.tryCollapse((TextComponent)either.getRight());
        if (collapsed != null) {
            return collapsed;
        }
        return either.getRight();
    }).listOf().mapCodec("with").optional().defaulted(List::isEmpty, ArrayList::new), comp -> Arrays.asList(comp.getArgs()), (key, fallback, arguments) -> new TranslationComponent((String)key, (List<?>)arguments).setFallback((String)fallback));
    public static final MapCodec<KeybindComponent> KEYBIND_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("keybind").required(), KeybindComponent::getKeybind, KeybindComponent::new);
    public static final MapCodec<ScoreComponent> SCORE_COMPONENT = MapCodecMerger.codec(Codec.STRING.mapCodec("name").required(), ScoreComponent::getName, Codec.STRING.mapCodec("objective").required(), ScoreComponent::getObjective, ScoreComponent::new).mapCodec("score").required();
    public static final MapCodec<SelectorComponent> SELECTOR_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("selector").required(), SelectorComponent::getSelector, TEXT.mapCodec("separator").optional().defaulted(null), SelectorComponent::getSeparator, SelectorComponent::new);
    public static final MapCodec<NbtComponent> NBT_COMPONENT = MapCodecMerger.mapCodec(Codec.STRING.mapCodec("nbt").required(), NbtComponent::getComponent, Codec.BOOLEAN.mapCodec("interpret").optional().lenient().defaulted(false), NbtComponent::isResolve, TEXT.mapCodec("separator").optional().lenient().defaulted(null), NbtComponent::getSeparator, TextCodecs_v1_20_3.createLegacyComponentMatcher((NamedType[])NbtDataSourceType.values(), NbtDataSourceType::getCodec, NbtDataSourceType::forDataSource, (String)"source"), NbtComponent::getDataSource, NbtComponent::new);

    private static enum NbtDataSourceType implements NamedType
    {
        ENTITY("entity", MapCodecMerger.mapCodec(Codec.STRING.mapCodec("entity").required(), EntityNbtSource::getSelector, EntityNbtSource::new)),
        BLOCK("block", MapCodecMerger.mapCodec(Codec.STRING.mapCodec("block").required(), BlockNbtSource::getPos, BlockNbtSource::new)),
        STORAGE("storage", MapCodecMerger.mapCodec(Codec.STRING_IDENTIFIER.mapCodec("storage").required(), StorageNbtSource::getId, StorageNbtSource::new));

        private final String name;
        private final MapCodec<? extends NbtDataSource> codec;

        public static NbtDataSourceType forDataSource(NbtDataSource dataSource) {
            if (dataSource instanceof EntityNbtSource) {
                return ENTITY;
            }
            if (dataSource instanceof BlockNbtSource) {
                return BLOCK;
            }
            if (dataSource instanceof StorageNbtSource) {
                return STORAGE;
            }
            throw new IllegalArgumentException("Unknown data source type: " + dataSource.getClass().getName());
        }

        @Override
        @Generated
        public String getName() {
            return this.name;
        }

        @Generated
        public MapCodec<? extends NbtDataSource> getCodec() {
            return this.codec;
        }

        @Generated
        private NbtDataSourceType(String name, MapCodec<? extends NbtDataSource> codec) {
            this.name = name;
            this.codec = codec;
        }
    }

    private static enum ComponentType implements TextCodecs_v1_20_3.TextComponentType
    {
        STRING("text", STRING_COMPONENT),
        TRANSLATION("translatable", TRANSLATION_COMPONENT),
        KEYBIND("keybind", KEYBIND_COMPONENT),
        SCORE("score", SCORE_COMPONENT),
        SELECTOR("selector", SELECTOR_COMPONENT),
        NBT("nbt", NBT_COMPONENT);

        private final String name;
        private final MapCodec<? extends TextComponent> codec;

        public static ComponentType forComponent(TextComponent component) {
            if (component instanceof StringComponent) {
                return STRING;
            }
            if (component instanceof TranslationComponent) {
                return TRANSLATION;
            }
            if (component instanceof KeybindComponent) {
                return KEYBIND;
            }
            if (component instanceof ScoreComponent) {
                return SCORE;
            }
            if (component instanceof SelectorComponent) {
                return SELECTOR;
            }
            if (component instanceof NbtComponent) {
                return NBT;
            }
            throw new IllegalArgumentException("Unknown component type: " + component.getClass().getName());
        }

        @Override
        @Generated
        public String getName() {
            return this.name;
        }

        @Override
        @Generated
        public MapCodec<? extends TextComponent> getCodec() {
            return this.codec;
        }

        @Generated
        private ComponentType(String name, MapCodec<? extends TextComponent> codec) {
            this.name = name;
            this.codec = codec;
        }
    }
}


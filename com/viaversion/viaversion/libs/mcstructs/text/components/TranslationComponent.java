/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.translation.Translator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import lombok.Generated;

public class TranslationComponent
extends TextComponent {
    private static final Pattern ARG_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
    private String key;
    private Object[] args;
    @Nullable
    private String fallback;
    private Translator translator = Translator.GLOBAL;

    public TranslationComponent(String key, List<?> args) {
        this.key = key;
        this.args = args.toArray();
    }

    public TranslationComponent(String key, Object ... args) {
        this.key = key;
        this.args = args;
    }

    public String getKey() {
        return this.key;
    }

    public TranslationComponent setKey(String key) {
        this.key = key;
        return this;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public TranslationComponent setArgs(Object[] args) {
        this.args = args;
        return this;
    }

    @Nullable
    public String getFallback() {
        return this.fallback;
    }

    public TranslationComponent setFallback(@Nullable String fallback) {
        this.fallback = fallback;
        return this;
    }

    public TranslationComponent setTranslator(@Nullable Translator translator) {
        this.translator = translator == null ? Translator.GLOBAL : translator;
        return this;
    }

    public TextComponent resolveIntoComponents() {
        ArrayList<TextComponent> components = new ArrayList<TextComponent>();
        String translated = this.translator.translate(this.key);
        if (translated == null) {
            translated = this.fallback;
        }
        if (translated == null) {
            translated = this.key;
        }
        Matcher matcher = ARG_PATTERN.matcher(translated);
        int argIndex = 0;
        int start = 0;
        while (matcher.find(start)) {
            int matchStart = matcher.start();
            int matchEnd = matcher.end();
            if (matchStart > start) {
                components.add(new StringComponent(String.format(translated.substring(start, matchStart), new Object[0])));
            }
            start = matchEnd;
            String argType = matcher.group(2);
            String match = translated.substring(matchStart, matchEnd);
            if (argType.equals("%") && match.equals("%%")) {
                components.add(new StringComponent("%"));
                continue;
            }
            if (!argType.equals("s")) {
                throw new IllegalStateException("Unsupported format: '" + match + "'");
            }
            String rawIndex = matcher.group(1);
            int index = rawIndex == null ? argIndex++ : Integer.parseInt(rawIndex) - 1;
            if (index >= this.args.length) continue;
            Object arg = this.args[index];
            if (arg instanceof TextComponent) {
                components.add((TextComponent)arg);
                continue;
            }
            if (arg == null) {
                components.add(new StringComponent("null"));
                continue;
            }
            components.add(new StringComponent(arg.toString()));
        }
        if (start < translated.length()) {
            components.add(new StringComponent(String.format(translated.substring(start), new Object[0])));
        }
        StringComponent out = new StringComponent();
        out.setStyle(this.getStyle());
        components.forEach(out::append);
        return out;
    }

    @Override
    public String asLegacyFormatString() {
        return this.resolveIntoComponents().asLegacyFormatString();
    }

    @Override
    public String asSingleString() {
        return this.resolveIntoComponents().asUnformattedString();
    }

    @Override
    public void asSingleString(Consumer<String> consumer) {
        if (consumer instanceof TranslatableContentConsumer) {
            this.resolveIntoComponents().visit(consumer);
        } else {
            this.resolveIntoComponents().visit(new TranslatableContentConsumer(consumer));
        }
    }

    @Override
    public TextComponent copy() {
        return this.copyMetaTo(this.shallowCopy());
    }

    @Override
    public TextComponent shallowCopy() {
        Object[] copyArgs = new Object[this.args.length];
        for (int i2 = 0; i2 < this.args.length; ++i2) {
            Object arg = this.args[i2];
            copyArgs[i2] = arg instanceof TextComponent ? ((TextComponent)arg).copy() : arg;
        }
        TranslationComponent copy = new TranslationComponent(this.key, copyArgs);
        copy.translator = this.translator;
        return copy.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), siblings -> !siblings.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("key", this.key).add("args", this.args, args -> ((Object[])args).length > 0, Arrays::toString).add("translator", this.translator, translator -> translator != Translator.GLOBAL).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof TranslationComponent)) {
            return false;
        }
        TranslationComponent other = (TranslationComponent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o2)) {
            return false;
        }
        String this$key = this.getKey();
        String other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        if (!Arrays.deepEquals(this.getArgs(), other.getArgs())) {
            return false;
        }
        String this$fallback = this.getFallback();
        String other$fallback = other.getFallback();
        if (this$fallback == null ? other$fallback != null : !this$fallback.equals(other$fallback)) {
            return false;
        }
        Translator this$translator = this.translator;
        Translator other$translator = other.translator;
        return !(this$translator == null ? other$translator != null : !this$translator.equals(other$translator));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TranslationComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getArgs());
        String $fallback = this.getFallback();
        result = result * 59 + ($fallback == null ? 43 : $fallback.hashCode());
        Translator $translator = this.translator;
        result = result * 59 + ($translator == null ? 43 : $translator.hashCode());
        return result;
    }

    private static final class TranslatableContentConsumer
    implements Consumer<String> {
        private static final IllegalArgumentException EX = new IllegalArgumentException("Too long");
        private final Consumer<String> runnable;
        private int visited;

        private TranslatableContentConsumer(Consumer<String> runnable) {
            this.runnable = runnable;
        }

        @Override
        public void accept(String s2) {
            if (this.visited++ > 32) {
                throw EX;
            }
            this.runnable.accept(s2);
        }
    }
}


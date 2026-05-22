/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec;

import net.darkmeow.irc.lib.io.netty.handler.codec.DefaultHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.ValueConverter;
import net.darkmeow.irc.lib.io.netty.util.HashingStrategy;

public final class DefaultHeadersImpl<K, V>
extends DefaultHeaders<K, V, DefaultHeadersImpl<K, V>> {
    public DefaultHeadersImpl(HashingStrategy<K> nameHashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator) {
        super(nameHashingStrategy, valueConverter, nameValidator);
    }

    public DefaultHeadersImpl(HashingStrategy<K> nameHashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator, int arraySizeHint, DefaultHeaders.ValueValidator<V> valueValidator) {
        super(nameHashingStrategy, valueConverter, nameValidator, arraySizeHint, valueValidator);
    }
}


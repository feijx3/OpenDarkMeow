/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import net.darkmeow.irc.lib.io.netty.util.internal.InternalThreadLocalMap;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public final class CharsetUtil {
    public static final Charset UTF_16 = StandardCharsets.UTF_16;
    public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
    public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
    public static final Charset US_ASCII = StandardCharsets.US_ASCII;
    private static final Charset[] CHARSETS = new Charset[]{UTF_16, UTF_16BE, UTF_16LE, UTF_8, ISO_8859_1, US_ASCII};

    public static Charset[] values() {
        return CHARSETS;
    }

    @Deprecated
    public static CharsetEncoder getEncoder(Charset charset) {
        return CharsetUtil.encoder(charset);
    }

    public static CharsetEncoder encoder(Charset charset, CodingErrorAction malformedInputAction, CodingErrorAction unmappableCharacterAction) {
        ObjectUtil.checkNotNull(charset, "charset");
        CharsetEncoder e2 = charset.newEncoder();
        e2.onMalformedInput(malformedInputAction).onUnmappableCharacter(unmappableCharacterAction);
        return e2;
    }

    public static CharsetEncoder encoder(Charset charset, CodingErrorAction codingErrorAction) {
        return CharsetUtil.encoder(charset, codingErrorAction, codingErrorAction);
    }

    public static CharsetEncoder encoder(Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        Map<Charset, CharsetEncoder> map = InternalThreadLocalMap.get().charsetEncoderCache();
        CharsetEncoder e2 = map.get(charset);
        if (e2 != null) {
            e2.reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            return e2;
        }
        e2 = CharsetUtil.encoder(charset, CodingErrorAction.REPLACE, CodingErrorAction.REPLACE);
        map.put(charset, e2);
        return e2;
    }

    @Deprecated
    public static CharsetDecoder getDecoder(Charset charset) {
        return CharsetUtil.decoder(charset);
    }

    public static CharsetDecoder decoder(Charset charset, CodingErrorAction malformedInputAction, CodingErrorAction unmappableCharacterAction) {
        ObjectUtil.checkNotNull(charset, "charset");
        CharsetDecoder d2 = charset.newDecoder();
        d2.onMalformedInput(malformedInputAction).onUnmappableCharacter(unmappableCharacterAction);
        return d2;
    }

    public static CharsetDecoder decoder(Charset charset, CodingErrorAction codingErrorAction) {
        return CharsetUtil.decoder(charset, codingErrorAction, codingErrorAction);
    }

    public static CharsetDecoder decoder(Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        Map<Charset, CharsetDecoder> map = InternalThreadLocalMap.get().charsetDecoderCache();
        CharsetDecoder d2 = map.get(charset);
        if (d2 != null) {
            d2.reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            return d2;
        }
        d2 = CharsetUtil.decoder(charset, CodingErrorAction.REPLACE, CodingErrorAction.REPLACE);
        map.put(charset, d2);
        return d2;
    }

    private CharsetUtil() {
    }
}


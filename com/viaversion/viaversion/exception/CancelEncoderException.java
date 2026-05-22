/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.handler.codec.EncoderException
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.exception;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.exception.CancelCodecException;
import io.netty.handler.codec.EncoderException;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class})
public class CancelEncoderException
extends EncoderException
implements CancelCodecException {
    public static final CancelEncoderException CACHED = new CancelEncoderException("This packet is supposed to be cancelled; If you have debug enabled, you can ignore these"){

        public Throwable fillInStackTrace() {
            return this;
        }
    };

    public CancelEncoderException() {
    }

    public CancelEncoderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CancelEncoderException(String message) {
        super(message);
    }

    public CancelEncoderException(Throwable cause) {
        super(cause);
    }

    public static CancelEncoderException generate(Throwable cause) {
        return Via.getManager().debugHandler().enabled() ? new CancelEncoderException(cause) : CACHED;
    }
}


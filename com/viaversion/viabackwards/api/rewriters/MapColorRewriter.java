/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;

public final class MapColorRewriter {
    public static void rewriteMapColors(PacketWrapper wrapper, IdRewriteFunction rewriter, int iconCount) {
        for (int i2 = 0; i2 < iconCount; ++i2) {
            wrapper.passthrough(Types.VAR_INT);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.BYTE);
            wrapper.passthrough(Types.OPTIONAL_COMPONENT);
        }
        short columns = wrapper.passthrough(Types.UNSIGNED_BYTE);
        if (columns < 1) {
            return;
        }
        wrapper.passthrough(Types.UNSIGNED_BYTE);
        wrapper.passthrough(Types.UNSIGNED_BYTE);
        wrapper.passthrough(Types.UNSIGNED_BYTE);
        byte[] data = wrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
        for (int i3 = 0; i3 < data.length; ++i3) {
            int color = data[i3] & 0xFF;
            int mappedColor = rewriter.rewrite(color);
            if (mappedColor == -1) continue;
            data[i3] = (byte)mappedColor;
        }
    }

    public static PacketHandler getRewriteHandler(IdRewriteFunction rewriter) {
        return wrapper -> MapColorRewriter.rewriteMapColors(wrapper, rewriter, wrapper.passthrough(Types.VAR_INT));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.imageio.StandardImageMetadataSupport;
import com.twelvemonkeys.imageio.plugins.webp.VP8xChunk;
import com.twelvemonkeys.lang.Validate;
import javax.imageio.ImageTypeSpecifier;

final class WebPImageMetadata
extends StandardImageMetadataSupport {
    WebPImageMetadata(ImageTypeSpecifier imageTypeSpecifier, VP8xChunk vP8xChunk) {
        super(WebPImageMetadata.builder(imageTypeSpecifier).withCompressionTypeName(Validate.notNull(vP8xChunk, (String)"header").isLossless ? "VP8L" : "VP8").withCompressionLossless(vP8xChunk.isLossless).withPixelAspectRatio(1.0).withFormatVersion("1.0"));
    }
}


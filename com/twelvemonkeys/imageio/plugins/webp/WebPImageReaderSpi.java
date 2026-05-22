/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.imageio.plugins.webp.WebPImageReader;
import com.twelvemonkeys.imageio.plugins.webp.WebPProviderInfo;
import com.twelvemonkeys.imageio.spi.ImageReaderSpiBase;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Locale;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public final class WebPImageReaderSpi
extends ImageReaderSpiBase {
    public WebPImageReaderSpi() {
        super(new WebPProviderInfo());
    }

    @Override
    public boolean canDecodeInput(Object object) throws IOException {
        return object instanceof ImageInputStream && WebPImageReaderSpi.canDecode((ImageInputStream)object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean canDecode(ImageInputStream imageInputStream) throws IOException {
        ByteOrder byteOrder = imageInputStream.getByteOrder();
        imageInputStream.mark();
        try {
            imageInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            if (imageInputStream.readInt() != 1179011410) {
                boolean bl2 = false;
                return bl2;
            }
            imageInputStream.readInt();
            if (imageInputStream.readInt() != 1346520407) {
                boolean bl3 = false;
                return bl3;
            }
            int n2 = imageInputStream.readInt();
            switch (n2) {
                case 540561494: 
                case 1278758998: 
                case 1480085590: {
                    boolean bl4 = true;
                    return bl4;
                }
            }
            boolean bl5 = false;
            return bl5;
        }
        finally {
            imageInputStream.setByteOrder(byteOrder);
            imageInputStream.reset();
        }
    }

    @Override
    public ImageReader createReaderInstance(Object object) {
        return new WebPImageReader(this);
    }

    @Override
    public String getDescription(Locale locale) {
        return "Google WebP File Format (WebP) Reader";
    }
}


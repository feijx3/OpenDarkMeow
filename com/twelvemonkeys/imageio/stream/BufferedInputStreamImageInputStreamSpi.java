/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.stream;

import com.twelvemonkeys.imageio.spi.ProviderInfo;
import com.twelvemonkeys.imageio.stream.BufferedChannelImageInputStream;
import com.twelvemonkeys.imageio.stream.FileCache;
import com.twelvemonkeys.imageio.stream.MemoryCache;
import com.twelvemonkeys.imageio.stream.StreamProviderInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.util.Iterator;
import java.util.Locale;
import javax.imageio.spi.ImageInputStreamSpi;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.stream.ImageInputStream;

public final class BufferedInputStreamImageInputStreamSpi
extends ImageInputStreamSpi {
    public BufferedInputStreamImageInputStreamSpi() {
        this(new StreamProviderInfo());
    }

    private BufferedInputStreamImageInputStreamSpi(ProviderInfo providerInfo) {
        super(providerInfo.getVendorName(), providerInfo.getVersion(), InputStream.class);
    }

    @Override
    public void onRegistration(ServiceRegistry serviceRegistry, Class<?> clazz) {
        Iterator<ImageInputStreamSpi> iterator2 = serviceRegistry.getServiceProviders(ImageInputStreamSpi.class, new InputStreamFilter(), true);
        while (iterator2.hasNext()) {
            ImageInputStreamSpi imageInputStreamSpi = iterator2.next();
            if (imageInputStreamSpi == this) continue;
            serviceRegistry.setOrdering(ImageInputStreamSpi.class, this, imageInputStreamSpi);
        }
    }

    @Override
    public ImageInputStream createInputStreamInstance(Object object, boolean bl2, File file) throws IOException {
        if (object instanceof InputStream) {
            ReadableByteChannel readableByteChannel = Channels.newChannel((InputStream)object);
            if (readableByteChannel instanceof SeekableByteChannel) {
                return new BufferedChannelImageInputStream((SeekableByteChannel)readableByteChannel);
            }
            return new BufferedChannelImageInputStream(bl2 ? new FileCache(readableByteChannel, file) : new MemoryCache(readableByteChannel));
        }
        throw new IllegalArgumentException("Expected input of type InputStream: " + object);
    }

    @Override
    public boolean canUseCacheFile() {
        return true;
    }

    @Override
    public String getDescription(Locale locale) {
        return "Service provider that instantiates an ImageInputStream from an InputStream";
    }

    private static class InputStreamFilter
    implements ServiceRegistry.Filter {
        private InputStreamFilter() {
        }

        @Override
        public boolean filter(Object object) {
            return ((ImageInputStreamSpi)object).getInputClass() == InputStream.class;
        }
    }
}


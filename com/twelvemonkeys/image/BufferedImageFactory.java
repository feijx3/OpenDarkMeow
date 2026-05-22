/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import com.twelvemonkeys.image.ImageConversionException;
import com.twelvemonkeys.image.ImageUtil;
import com.twelvemonkeys.image.SubsamplingFilter;
import com.twelvemonkeys.lang.Validate;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.awt.image.WritableRaster;
import java.lang.reflect.Array;
import java.util.EventListener;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class BufferedImageFactory {
    private List<ProgressListener> listeners;
    private int percentageDone;
    private ImageProducer producer;
    private ImageConversionException consumerException;
    private volatile boolean fetching;
    private boolean readColorModelOnly;
    private int x = 0;
    private int y = 0;
    private int width = -1;
    private int height = -1;
    private int xSub = 1;
    private int ySub = 1;
    private int offset;
    private int scanSize;
    private ColorModel sourceColorModel;
    private Hashtable<?, ?> sourceProperties;
    private Object sourcePixels;
    private BufferedImage buffered;
    private ColorModel colorModel;
    private final Consumer consumer = new Consumer();

    public BufferedImageFactory(Image image2) {
        this(image2 != null ? image2.getSource() : null);
    }

    public BufferedImageFactory(ImageProducer imageProducer) {
        Validate.notNull(imageProducer, "source");
        this.producer = imageProducer;
    }

    public BufferedImage getBufferedImage() throws ImageConversionException {
        this.doFetch(false);
        return this.buffered;
    }

    public ColorModel getColorModel() throws ImageConversionException {
        this.doFetch(true);
        return this.buffered != null ? this.buffered.getColorModel() : this.colorModel;
    }

    public void dispose() {
        this.freeResources();
        this.buffered = null;
        this.colorModel = null;
    }

    public void abort() {
        this.consumer.imageComplete(4);
    }

    public void setSourceRegion(Rectangle rectangle) {
        if (this.x != rectangle.x || this.y != rectangle.y || this.width != rectangle.width || this.height != rectangle.height) {
            this.dispose();
        }
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public void setSourceSubsampling(int n2, int n3) {
        if (this.xSub != n2 || this.ySub != n3) {
            this.dispose();
        }
        if (n2 > 1) {
            this.xSub = n2;
        }
        if (n3 > 1) {
            this.ySub = n3;
        }
    }

    private synchronized void doFetch(boolean bl2) throws ImageConversionException {
        if (!this.fetching && (!bl2 && this.buffered == null || this.buffered == null && this.sourceColorModel == null)) {
            if (!(bl2 || this.xSub <= 1 && this.ySub <= 1)) {
                if (this.width > 0 && this.height > 0) {
                    this.width = (this.width + this.xSub - 1) / this.xSub;
                    this.height = (this.height + this.ySub - 1) / this.ySub;
                    this.x = (this.x + this.xSub - 1) / this.xSub;
                    this.y = (this.y + this.ySub - 1) / this.ySub;
                }
                this.producer = new FilteredImageSource(this.producer, new SubsamplingFilter(this.xSub, this.ySub));
            }
            this.fetching = true;
            this.readColorModelOnly = bl2;
            this.producer.startProduction(this.consumer);
            while (this.fetching) {
                try {
                    this.wait(200L);
                }
                catch (InterruptedException interruptedException) {
                    throw new ImageConversionException("Image conversion aborted: " + interruptedException.getMessage(), interruptedException);
                }
            }
            try {
                if (this.consumerException != null) {
                    throw new ImageConversionException("Image conversion failed: " + this.consumerException.getMessage(), this.consumerException);
                }
                if (bl2) {
                    this.createColorModel();
                } else {
                    this.createBuffered();
                }
            }
            finally {
                this.freeResources();
            }
        }
    }

    private void createColorModel() {
        this.colorModel = this.sourceColorModel;
    }

    private void createBuffered() {
        if (this.width > 0 && this.height > 0) {
            if (this.sourceColorModel != null && this.sourcePixels != null) {
                WritableRaster writableRaster = ImageUtil.createRaster(this.width, this.height, this.sourcePixels, this.sourceColorModel);
                this.buffered = new BufferedImage(this.sourceColorModel, writableRaster, this.sourceColorModel.isAlphaPremultiplied(), this.sourceProperties);
            } else {
                this.buffered = ImageUtil.createClear(this.width, this.height, null);
            }
        }
        if (this.buffered == null) {
            throw new ImageConversionException("Could not create BufferedImage");
        }
    }

    private void freeResources() {
        this.sourceColorModel = null;
        this.sourcePixels = null;
        this.sourceProperties = null;
    }

    private void processProgress(int n2) {
        int n3;
        if (this.listeners != null && (n3 = 100 * n2 / this.height) > this.percentageDone) {
            this.percentageDone = n3;
            for (ProgressListener progressListener : this.listeners) {
                progressListener.progress(this, n3);
            }
        }
    }

    public void addProgressListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return;
        }
        if (this.listeners == null) {
            this.listeners = new CopyOnWriteArrayList<ProgressListener>();
        }
        this.listeners.add(progressListener);
    }

    public void removeProgressListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return;
        }
        if (this.listeners == null) {
            return;
        }
        this.listeners.remove(progressListener);
    }

    public void removeAllProgressListeners() {
        if (this.listeners != null) {
            this.listeners.clear();
        }
    }

    private static short[] toShortPixels(int[] nArray) {
        short[] sArray = new short[nArray.length];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            sArray[i2] = (short)(nArray[i2] & 0xFFFF);
        }
        return sArray;
    }

    private class Consumer
    implements ImageConsumer {
        private Consumer() {
        }

        private void setPixelsImpl(int n2, int n3, int n4, int n5, ColorModel colorModel, Object object, int n6, int n7) {
            int n8;
            this.setColorModelOnce(colorModel);
            if (object == null) {
                return;
            }
            if (BufferedImageFactory.this.sourcePixels == null) {
                BufferedImageFactory.this.sourcePixels = Array.newInstance(object.getClass().getComponentType(), BufferedImageFactory.this.width * BufferedImageFactory.this.height);
                BufferedImageFactory.this.scanSize = BufferedImageFactory.this.width;
                BufferedImageFactory.this.offset = 0;
            } else if (BufferedImageFactory.this.sourcePixels.getClass() != object.getClass()) {
                throw new IllegalStateException("Only one pixel type allowed");
            }
            if (n3 < BufferedImageFactory.this.y) {
                n8 = BufferedImageFactory.this.y - n3;
                if (n8 >= n5) {
                    return;
                }
                n6 += n7 * n8;
                n3 += n8;
                n5 -= n8;
            }
            if (n3 + n5 > BufferedImageFactory.this.y + BufferedImageFactory.this.height && (n5 = BufferedImageFactory.this.y + BufferedImageFactory.this.height - n3) <= 0) {
                return;
            }
            if (n2 < BufferedImageFactory.this.x) {
                n8 = BufferedImageFactory.this.x - n2;
                if (n8 >= n4) {
                    return;
                }
                n6 += n8;
                n2 += n8;
                n4 -= n8;
            }
            if (n2 + n4 > BufferedImageFactory.this.x + BufferedImageFactory.this.width && (n4 = BufferedImageFactory.this.x + BufferedImageFactory.this.width - n2) <= 0) {
                return;
            }
            n8 = BufferedImageFactory.this.offset + (n3 - BufferedImageFactory.this.y) * BufferedImageFactory.this.scanSize + (n2 - BufferedImageFactory.this.x);
            for (int i2 = n5; i2 > 0; --i2) {
                System.arraycopy(object, n6, BufferedImageFactory.this.sourcePixels, n8, n4);
                n6 += n7;
                n8 += BufferedImageFactory.this.scanSize;
            }
            BufferedImageFactory.this.processProgress(n3 + n5);
        }

        public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, short[] sArray, int n6, int n7) {
            this.setPixelsImpl(n2, n3, n4, n5, colorModel, sArray, n6, n7);
        }

        private void setColorModelOnce(ColorModel colorModel) {
            if (BufferedImageFactory.this.sourceColorModel != colorModel) {
                if (BufferedImageFactory.this.sourcePixels == null) {
                    BufferedImageFactory.this.sourceColorModel = colorModel;
                } else {
                    throw new IllegalStateException("Change of ColorModel after pixel delivery not supported");
                }
            }
            if (BufferedImageFactory.this.readColorModelOnly) {
                BufferedImageFactory.this.consumer.imageComplete(4);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void imageComplete(int n2) {
            BufferedImageFactory.this.fetching = false;
            if (BufferedImageFactory.this.producer != null) {
                BufferedImageFactory.this.producer.removeConsumer(this);
            }
            if (n2 == 1) {
                BufferedImageFactory.this.consumerException = new ImageConversionException("ImageConsumer.IMAGEERROR");
            }
            BufferedImageFactory bufferedImageFactory = BufferedImageFactory.this;
            synchronized (bufferedImageFactory) {
                BufferedImageFactory.this.notifyAll();
            }
        }

        @Override
        public void setColorModel(ColorModel colorModel) {
            this.setColorModelOnce(colorModel);
        }

        @Override
        public void setDimensions(int n2, int n3) {
            if (BufferedImageFactory.this.width < 0) {
                BufferedImageFactory.this.width = n2 - BufferedImageFactory.this.x;
            }
            if (BufferedImageFactory.this.height < 0) {
                BufferedImageFactory.this.height = n3 - BufferedImageFactory.this.y;
            }
            if (BufferedImageFactory.this.width <= 0 || BufferedImageFactory.this.height <= 0) {
                this.imageComplete(3);
            }
        }

        @Override
        public void setHints(int n2) {
        }

        @Override
        public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, byte[] byArray, int n6, int n7) {
            this.setPixelsImpl(n2, n3, n4, n5, colorModel, byArray, n6, n7);
        }

        @Override
        public void setPixels(int n2, int n3, int n4, int n5, ColorModel colorModel, int[] nArray, int n6, int n7) {
            if (colorModel.getTransferType() == 1) {
                this.setPixelsImpl(n2, n3, n4, n5, colorModel, BufferedImageFactory.toShortPixels(nArray), n6, n7);
            } else {
                this.setPixelsImpl(n2, n3, n4, n5, colorModel, nArray, n6, n7);
            }
        }

        public void setProperties(Hashtable hashtable) {
            BufferedImageFactory.this.sourceProperties = hashtable;
        }
    }

    public static interface ProgressListener
    extends EventListener {
        public void progress(BufferedImageFactory var1, float var2);
    }
}


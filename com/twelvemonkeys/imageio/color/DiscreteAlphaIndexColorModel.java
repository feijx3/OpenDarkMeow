/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.color;

import com.twelvemonkeys.lang.Validate;
import java.awt.Point;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;

public final class DiscreteAlphaIndexColorModel
extends ColorModel {
    private final IndexColorModel icm;
    private final int extraSamples;
    private final int samples;

    public DiscreteAlphaIndexColorModel(IndexColorModel indexColorModel) {
        this(indexColorModel, 1, true);
    }

    public DiscreteAlphaIndexColorModel(IndexColorModel indexColorModel, int n2, boolean bl2) {
        super(Validate.notNull(indexColorModel, "IndexColorModel").getPixelSize() * (1 + n2), new int[]{indexColorModel.getPixelSize(), indexColorModel.getPixelSize(), indexColorModel.getPixelSize(), indexColorModel.getPixelSize()}, indexColorModel.getColorSpace(), bl2, false, bl2 ? 3 : 1, indexColorModel.getTransferType());
        this.icm = indexColorModel;
        this.extraSamples = n2;
        this.samples = 1 + n2;
    }

    @Override
    public int getNumComponents() {
        return this.getNumColorComponents() + this.extraSamples;
    }

    @Override
    public int getRed(int n2) {
        return this.icm.getRed(n2);
    }

    @Override
    public int getGreen(int n2) {
        return this.icm.getGreen(n2);
    }

    @Override
    public int getBlue(int n2) {
        return this.icm.getBlue(n2);
    }

    @Override
    public int getAlpha(int n2) {
        return this.hasAlpha() ? (int)((float)n2 / (float)((1 << this.getComponentSize(3)) - 1) * 255.0f + 0.5f) : 255;
    }

    private int getSample(Object object, int n2) {
        int n3;
        switch (this.transferType) {
            case 0: {
                byte[] byArray = (byte[])object;
                n3 = byArray[n2] & 0xFF;
                break;
            }
            case 1: {
                short[] sArray = (short[])object;
                n3 = sArray[n2] & 0xFFFF;
                break;
            }
            case 3: {
                int[] nArray = (int[])object;
                n3 = nArray[n2];
                break;
            }
            default: {
                throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
            }
        }
        return n3;
    }

    @Override
    public int getRed(Object object) {
        return this.getRed(this.getSample(object, 0));
    }

    @Override
    public int getGreen(Object object) {
        return this.getGreen(this.getSample(object, 0));
    }

    @Override
    public int getBlue(Object object) {
        return this.getBlue(this.getSample(object, 0));
    }

    @Override
    public int getAlpha(Object object) {
        return this.hasAlpha() ? this.getAlpha(this.getSample(object, 1)) : 255;
    }

    @Override
    public SampleModel createCompatibleSampleModel(int n2, int n3) {
        return new PixelInterleavedSampleModel(this.transferType, n2, n3, this.samples, n2 * this.samples, this.createOffsets(this.samples));
    }

    private int[] createOffsets(int n2) {
        int[] nArray = new int[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            nArray[i2] = i2;
        }
        return nArray;
    }

    @Override
    public boolean isCompatibleSampleModel(SampleModel sampleModel) {
        return sampleModel instanceof PixelInterleavedSampleModel && sampleModel.getNumBands() == this.samples;
    }

    @Override
    public WritableRaster createCompatibleWritableRaster(int n2, int n3) {
        return Raster.createWritableRaster(this.createCompatibleSampleModel(n2, n3), new Point(0, 0));
    }

    @Override
    public boolean isCompatibleRaster(Raster raster) {
        int n2 = raster.getSampleModel().getSampleSize(0);
        return raster.getTransferType() == this.transferType && raster.getNumBands() == this.samples && 1 << n2 >= this.icm.getMapSize();
    }

    @Override
    public boolean equals(Object object) {
        return this == object || object != null && this.getClass() == object.getClass() && this.icm.equals(((DiscreteAlphaIndexColorModel)object).icm);
    }

    @Override
    public String toString() {
        return "DiscreteAlphaIndexColorModel: #pixelBits = " + this.pixel_bits + " numComponents = " + this.getNumComponents() + " color space = " + this.getColorSpace() + " transparency = " + this.getTransparency() + " has alpha = " + this.hasAlpha() + " isAlphaPre = " + this.isAlphaPremultiplied();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.util;

import com.twelvemonkeys.imageio.color.DiscreteAlphaIndexColorModel;
import com.twelvemonkeys.imageio.util.IndexedImageTypeSpecifier;
import com.twelvemonkeys.imageio.util.Int16ImageTypeSpecifier;
import com.twelvemonkeys.imageio.util.UInt32ImageTypeSpecifier;
import com.twelvemonkeys.lang.Validate;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import javax.imageio.ImageTypeSpecifier;

public final class ImageTypeSpecifiers {
    private static final ImageTypeSpecifier TYPE_INT_RGB = ImageTypeSpecifiers.createPackedOddBits(ColorSpace.getInstance(1000), 24, 0xFF0000, 65280, 255, 0, 3, false);
    private static final ImageTypeSpecifier TYPE_INT_BGR = ImageTypeSpecifiers.createPackedOddBits(ColorSpace.getInstance(1000), 24, 255, 65280, 0xFF0000, 0, 3, false);
    private static final ImageTypeSpecifier TYPE_USHORT_565_RGB = ImageTypeSpecifiers.createPackedOddBits(ColorSpace.getInstance(1000), 16, 63488, 2016, 31, 0, 1, false);
    private static final ImageTypeSpecifier TYPE_USHORT_555_RGB = ImageTypeSpecifiers.createPackedOddBits(ColorSpace.getInstance(1000), 15, 31744, 992, 31, 0, 1, false);

    private ImageTypeSpecifiers() {
    }

    public static ImageTypeSpecifier createFromBufferedImageType(int n2) {
        switch (n2) {
            case 1: {
                return TYPE_INT_RGB;
            }
            case 4: {
                return TYPE_INT_BGR;
            }
            case 8: {
                return TYPE_USHORT_565_RGB;
            }
            case 9: {
                return TYPE_USHORT_555_RGB;
            }
        }
        return ImageTypeSpecifier.createFromBufferedImageType(n2);
    }

    public static ImageTypeSpecifier createPacked(ColorSpace colorSpace, int n2, int n3, int n4, int n5, int n6, boolean bl2) {
        int n7 = ImageTypeSpecifiers.calculateRequiredBits(n2 | n3 | n4 | n5);
        if (n7 != 32) {
            return ImageTypeSpecifiers.createPackedOddBits(colorSpace, n7, n2, n3, n4, n5, n6, bl2);
        }
        return ImageTypeSpecifier.createPacked(colorSpace, n2, n3, n4, n5, n6, bl2);
    }

    private static int calculateRequiredBits(int n2) {
        int n3 = 1;
        while ((n2 >>>= 1) != 0) {
            ++n3;
        }
        return n3;
    }

    static ImageTypeSpecifier createPackedOddBits(ColorSpace colorSpace, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl2) {
        Validate.notNull(colorSpace, "colorSpace");
        Validate.isTrue(colorSpace.getType() == 5, colorSpace, "ColorSpace must be TYPE_RGB");
        Validate.isTrue(n3 != 0 || n4 != 0 || n5 != 0 || n6 != 0, "No mask has at least 1 bit set");
        DirectColorModel directColorModel = new DirectColorModel(colorSpace, n2, n3, n4, n5, n6, bl2, n7);
        return new ImageTypeSpecifier(directColorModel, ((ColorModel)directColorModel).createCompatibleSampleModel(1, 1));
    }

    public static ImageTypeSpecifier createInterleaved(ColorSpace colorSpace, int[] nArray, int n2, boolean bl2, boolean bl3) {
        if (n2 == 3) {
            return UInt32ImageTypeSpecifier.createInterleaved(colorSpace, nArray, bl2, bl3);
        }
        return ImageTypeSpecifier.createInterleaved(colorSpace, nArray, n2, bl2, bl3);
    }

    public static ImageTypeSpecifier createBanded(ColorSpace colorSpace, int[] nArray, int[] nArray2, int n2, boolean bl2, boolean bl3) {
        if (n2 == 3) {
            return UInt32ImageTypeSpecifier.createBanded(colorSpace, nArray, nArray2, bl2, bl3);
        }
        return ImageTypeSpecifier.createBanded(colorSpace, nArray, nArray2, n2, bl2, bl3);
    }

    public static ImageTypeSpecifier createGrayscale(int n2, int n3) {
        if (n2 == 16 && n3 == 2) {
            return new Int16ImageTypeSpecifier(ColorSpace.getInstance(1003), new int[]{0}, false, false);
        }
        if (n2 == 32 && n3 == 3) {
            return UInt32ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1003), new int[]{0}, false, false);
        }
        if (n3 == 4 || n3 == 5) {
            return ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1003), new int[]{0}, n3, false, false);
        }
        return ImageTypeSpecifier.createGrayscale(n2, n3, false);
    }

    public static ImageTypeSpecifier createGrayscale(int n2, int n3, boolean bl2) {
        if (n2 == 16 && n3 == 2) {
            return new Int16ImageTypeSpecifier(ColorSpace.getInstance(1003), new int[]{0, 1}, true, bl2);
        }
        if (n2 == 32 && n3 == 3) {
            return UInt32ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1003), new int[]{0, 1}, true, bl2);
        }
        if (n3 == 4 || n3 == 5) {
            return ImageTypeSpecifier.createInterleaved(ColorSpace.getInstance(1003), new int[]{0, 1}, n3, true, bl2);
        }
        return ImageTypeSpecifier.createGrayscale(n2, n3, false, bl2);
    }

    public static ImageTypeSpecifier createPackedGrayscale(ColorSpace colorSpace, int n2, int n3) {
        IndexColorModel indexColorModel;
        Object object;
        Validate.notNull(colorSpace, "colorSpace");
        Validate.isTrue(colorSpace.getType() == 6, colorSpace, "ColorSpace must be TYPE_GRAY");
        Validate.isTrue(n2 == 1 || n2 == 2 || n2 == 4, n2, "bits must be 1, 2, or 4: %s");
        Validate.isTrue(n3 == 0, n3, "dataType must be TYPE_BYTE: %s");
        int n4 = 1 << n2;
        if (ColorSpace.getInstance(1003).equals(colorSpace)) {
            object = new byte[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                object[i2] = (byte)(i2 * 255 / (n4 - 1));
            }
            indexColorModel = new IndexColorModel(n2, n4, (byte[])object, (byte[])object, (byte[])object);
        } else {
            object = new byte[n4];
            byte[] byArray = new byte[n4];
            byte[] byArray2 = new byte[n4];
            for (int i3 = 0; i3 < n4; ++i3) {
                float[] fArray = new float[]{(float)i3 / (float)(n4 - 1)};
                float[] fArray2 = colorSpace.toRGB(fArray);
                object[i3] = (byte)Math.round(fArray2[0] * 255.0f);
                byArray[i3] = (byte)Math.round(fArray2[1] * 255.0f);
                byArray2[i3] = (byte)Math.round(fArray2[2] * 255.0f);
            }
            indexColorModel = new IndexColorModel(n2, n4, (byte[])object, byArray, byArray2);
        }
        object = new MultiPixelPackedSampleModel(n3, 1, 1, n2);
        return new ImageTypeSpecifier(indexColorModel, (SampleModel)object);
    }

    public static ImageTypeSpecifier createIndexed(byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4, int n2, int n3) {
        return ImageTypeSpecifier.createIndexed(byArray, byArray2, byArray3, byArray4, n2, n3);
    }

    public static ImageTypeSpecifier createIndexed(int[] nArray, boolean bl2, int n2, int n3, int n4) {
        return ImageTypeSpecifiers.createFromIndexColorModel(new IndexColorModel(n3, nArray.length, nArray, 0, bl2, n2, n4));
    }

    public static ImageTypeSpecifier createFromIndexColorModel(IndexColorModel indexColorModel) {
        return new IndexedImageTypeSpecifier(indexColorModel);
    }

    public static ImageTypeSpecifier createDiscreteAlphaIndexedFromIndexColorModel(IndexColorModel indexColorModel) {
        DiscreteAlphaIndexColorModel discreteAlphaIndexColorModel = new DiscreteAlphaIndexColorModel(indexColorModel);
        return new ImageTypeSpecifier(discreteAlphaIndexColorModel, ((ColorModel)discreteAlphaIndexColorModel).createCompatibleSampleModel(1, 1));
    }

    public static ImageTypeSpecifier createDiscreteExtraSamplesIndexedFromIndexColorModel(IndexColorModel indexColorModel, int n2, boolean bl2) {
        DiscreteAlphaIndexColorModel discreteAlphaIndexColorModel = new DiscreteAlphaIndexColorModel(indexColorModel, n2, bl2);
        return new ImageTypeSpecifier(discreteAlphaIndexColorModel, ((ColorModel)discreteAlphaIndexColorModel).createCompatibleSampleModel(1, 1));
    }

    public static ImageTypeSpecifier createFromRenderedImage(RenderedImage renderedImage) {
        int n2;
        if (renderedImage == null) {
            throw new IllegalArgumentException("image == null!");
        }
        if (renderedImage instanceof BufferedImage && (n2 = ((BufferedImage)renderedImage).getType()) != 0 && n2 != 12 && n2 != 13) {
            return ImageTypeSpecifiers.createFromBufferedImageType(n2);
        }
        return new ImageTypeSpecifier(renderedImage);
    }
}


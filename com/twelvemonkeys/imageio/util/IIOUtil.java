/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.util;

import com.twelvemonkeys.image.ImageUtil;
import com.twelvemonkeys.imageio.util.IIOInputStreamAdapter;
import com.twelvemonkeys.imageio.util.IIOOutputStreamAdapter;
import com.twelvemonkeys.lang.Validate;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.TreeSet;
import javax.imageio.IIOParam;
import javax.imageio.ImageIO;
import javax.imageio.spi.IIOServiceProvider;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

public final class IIOUtil {
    private IIOUtil() {
    }

    public static InputStream createStreamAdapter(ImageInputStream imageInputStream) {
        return new BufferedInputStream(new IIOInputStreamAdapter(imageInputStream));
    }

    public static InputStream createStreamAdapter(ImageInputStream imageInputStream, long l2) {
        return new BufferedInputStream(new IIOInputStreamAdapter(imageInputStream, l2));
    }

    public static OutputStream createStreamAdapter(ImageOutputStream imageOutputStream) {
        return new BufferedOutputStream(new IIOOutputStreamAdapter(imageOutputStream));
    }

    public static Image fakeSubsampling(Image image2, IIOParam iIOParam) {
        if (image2 == null) {
            return null;
        }
        if (iIOParam != null) {
            int n2 = iIOParam.getSourceXSubsampling();
            int n3 = iIOParam.getSourceYSubsampling();
            if (n2 > 1 || n3 > 1) {
                int n4 = (ImageUtil.getWidth(image2) + n2 - 1) / n2;
                int n5 = (ImageUtil.getHeight(image2) + n3 - 1) / n3;
                return image2.getScaledInstance(n4, n5, 2);
            }
        }
        return image2;
    }

    public static Rectangle getSourceRegion(IIOParam iIOParam, int n2, int n3) {
        Rectangle rectangle = new Rectangle(n2, n3);
        if (iIOParam != null) {
            Rectangle rectangle2 = iIOParam.getSourceRegion();
            if (rectangle2 != null) {
                rectangle = rectangle.intersection(rectangle2);
            }
            int n4 = iIOParam.getSubsamplingXOffset();
            int n5 = iIOParam.getSubsamplingYOffset();
            rectangle.x += n4;
            rectangle.y += n5;
            rectangle.width -= n4;
            rectangle.height -= n5;
        }
        return rectangle;
    }

    public static BufferedImage fakeAOI(BufferedImage bufferedImage, Rectangle rectangle) {
        if (bufferedImage == null) {
            return null;
        }
        if (rectangle != null && (rectangle.x != 0 || rectangle.y != 0 || rectangle.width != bufferedImage.getWidth() || rectangle.height != bufferedImage.getHeight())) {
            return bufferedImage.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        return bufferedImage;
    }

    public static <T> void deregisterProvider(ServiceRegistry serviceRegistry, IIOServiceProvider iIOServiceProvider, Class<T> clazz) {
        serviceRegistry.deregisterServiceProvider(clazz.cast(iIOServiceProvider), clazz);
    }

    public static <T> T lookupProviderByName(ServiceRegistry serviceRegistry, String string, Class<T> clazz) {
        Iterator<T> iterator2 = serviceRegistry.getServiceProviders(clazz, true);
        while (iterator2.hasNext()) {
            T t2 = iterator2.next();
            if (!t2.getClass().getName().equals(string)) continue;
            return t2;
        }
        return null;
    }

    public static String[] getNormalizedReaderFormatNames() {
        return IIOUtil.normalizeNames(ImageIO.getReaderFormatNames());
    }

    public static String[] getNormalizedWriterFormatNames() {
        return IIOUtil.normalizeNames(ImageIO.getWriterFormatNames());
    }

    private static String[] normalizeNames(String[] stringArray) {
        TreeSet<String> treeSet = new TreeSet<String>();
        for (String string : stringArray) {
            treeSet.add(string.toUpperCase());
        }
        return treeSet.toArray(new String[0]);
    }

    public static void subsampleRow(byte[] byArray, int n2, int n3, byte[] byArray2, int n4, int n5, int n6, int n7) {
        if (n7 == 1) {
            return;
        }
        Validate.isTrue(n7 > 1, "samplePeriod must be > 1");
        Validate.isTrue(n6 > 0 && n6 <= 8 && (n6 == 1 || n6 % 2 == 0), "bitsPerSample must be > 0 and <= 8 and a power of 2");
        Validate.isTrue(n5 > 0, "samplesPerPixel must be > 0");
        Validate.isTrue(n5 * n6 <= 8 || n5 * n6 % 8 == 0, "samplesPerPixel * bitsPerSample must be < 8 or a multiple of 8 ");
        if (n6 * n5 % 8 == 0) {
            int n8 = n6 * n5 / 8;
            for (int i2 = 0; i2 < n3 * n8; i2 += n7 * n8) {
                System.arraycopy(byArray, n2 + i2, byArray2, n4 + i2 / n7, n8);
            }
        } else {
            int n9 = n6 * n5;
            int n10 = (1 << n9) - 1;
            for (int i3 = 0; i3 < n3; i3 += n7) {
                int n11 = (n4 + i3 / n7) * n9 / 8;
                int n12 = (n2 + i3) * n9 / 8;
                int n13 = 8 - n9 - i3 * n9 % 8;
                int n14 = n10 << n13;
                int n15 = 8 - n9 - i3 * n9 / n7 % 8;
                int n16 = ~(n10 << n15);
                int n17 = (byArray[n12] & n14) >> n13;
                byArray2[n11] = (byte)(byArray2[n11] & n16 | n17 << n15);
            }
        }
    }

    public static void subsampleRow(short[] sArray, int n2, int n3, short[] sArray2, int n4, int n5, int n6, int n7) {
        if (n7 == 1) {
            return;
        }
        Validate.isTrue(n7 > 1, "samplePeriod must be > 1");
        Validate.isTrue(n6 > 0 && n6 <= 16 && (n6 == 1 || n6 % 2 == 0), "bitsPerSample must be > 0 and <= 16 and a power of 2");
        Validate.isTrue(n5 > 0, "samplesPerPixel must be > 0");
        Validate.isTrue(n5 * n6 <= 16 || n5 * n6 % 16 == 0, "samplesPerPixel * bitsPerSample must be < 16 or a multiple of 16");
        int n8 = n6 * n5 / 16;
        for (int i2 = 0; i2 < n3 * n8; i2 += n7 * n8) {
            System.arraycopy(sArray, n2 + i2, sArray2, n4 + i2 / n7, n8);
        }
    }

    public static void subsampleRow(int[] nArray, int n2, int n3, int[] nArray2, int n4, int n5, int n6, int n7) {
        if (n7 == 1) {
            return;
        }
        Validate.isTrue(n7 > 1, "samplePeriod must be > 1");
        Validate.isTrue(n6 > 0 && n6 <= 32 && (n6 == 1 || n6 % 2 == 0), "bitsPerSample must be > 0 and <= 32 and a power of 2");
        Validate.isTrue(n5 > 0, "samplesPerPixel must be > 0");
        Validate.isTrue(n5 * n6 <= 32 || n5 * n6 % 32 == 0, "samplesPerPixel * bitsPerSample must be < 32 or a multiple of 32");
        int n8 = n6 * n5 / 32;
        for (int i2 = 0; i2 < n3 * n8; i2 += n7 * n8) {
            System.arraycopy(nArray, n2 + i2, nArray2, n4 + i2 / n7, n8);
        }
    }

    public static void subsampleRow(float[] fArray, int n2, int n3, float[] fArray2, int n4, int n5, int n6, int n7) {
        Validate.isTrue(n7 > 1, "samplePeriod must be > 1");
        Validate.isTrue(n6 > 0 && n6 <= 32 && (n6 == 1 || n6 % 2 == 0), "bitsPerSample must be > 0 and <= 32 and a power of 2");
        Validate.isTrue(n5 > 0, "samplesPerPixel must be > 0");
        Validate.isTrue(n5 * n6 <= 32 || n5 * n6 % 32 == 0, "samplesPerPixel * bitsPerSample must be < 32 or a multiple of 32");
        int n8 = n6 * n5 / 32;
        for (int i2 = 0; i2 < n3 * n8; i2 += n7 * n8) {
            System.arraycopy(fArray, n2 + i2, fArray2, n4 + i2 / n7, n8);
        }
    }

    public static void subsampleRow(double[] dArray, int n2, int n3, double[] dArray2, int n4, int n5, int n6, int n7) {
        Validate.isTrue(n7 > 1, "samplePeriod must be > 1");
        Validate.isTrue(n6 > 0 && n6 <= 64 && (n6 == 1 || n6 % 2 == 0), "bitsPerSample must be > 0 and <= 64 and a power of 2");
        Validate.isTrue(n5 > 0, "samplesPerPixel must be > 0");
        Validate.isTrue(n5 * n6 <= 64 || n5 * n6 % 64 == 0, "samplesPerPixel * bitsPerSample must be < 64 or a multiple of 64");
        int n8 = n6 * n5 / 64;
        for (int i2 = 0; i2 < n3 * n8; i2 += n7 * n8) {
            System.arraycopy(dArray, n2 + i2, dArray2, n4 + i2 / n7, n8);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import com.twelvemonkeys.image.AffineTransformOp;
import com.twelvemonkeys.image.BrightnessContrastFilter;
import com.twelvemonkeys.image.BufferedImageFactory;
import com.twelvemonkeys.image.DiffusionDither;
import com.twelvemonkeys.image.GrayFilter;
import com.twelvemonkeys.image.IndexImage;
import com.twelvemonkeys.image.ResampleOp;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.ConvolveOp;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.IndexColorModel;
import java.awt.image.Kernel;
import java.awt.image.PackedColorModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class ImageUtil {
    public static final int ROTATE_90_CCW = -90;
    public static final int ROTATE_90_CW = 90;
    public static final int ROTATE_180 = 180;
    public static final int FLIP_VERTICAL = -1;
    public static final int FLIP_HORIZONTAL = 1;
    public static final int EDGE_ZERO_FILL = 0;
    public static final int EDGE_NO_OP = 1;
    public static final int EDGE_REFLECT = 2;
    public static final int EDGE_WRAP = 3;
    public static final int DITHER_DEFAULT = 0;
    public static final int DITHER_NONE = 1;
    public static final int DITHER_DIFFUSION = 2;
    public static final int DITHER_DIFFUSION_ALTSCANS = 3;
    public static final int COLOR_SELECTION_DEFAULT = 0;
    public static final int COLOR_SELECTION_FAST = 256;
    public static final int COLOR_SELECTION_QUALITY = 512;
    public static final int TRANSPARENCY_DEFAULT = 0;
    public static final int TRANSPARENCY_OPAQUE = 65536;
    public static final int TRANSPARENCY_BITMASK = 131072;
    protected static final int TRANSPARENCY_TRANSLUCENT = 196608;
    private static final int BI_TYPE_ANY = -1;
    private static boolean VM_SUPPORTS_ACCELERATION = true;
    private static final float[] SHARPEN_MATRIX = new float[]{0.0f, -0.3f, 0.0f, -0.3f, 2.2f, -0.3f, 0.0f, -0.3f, 0.0f};
    private static final Kernel SHARPEN_KERNEL = new Kernel(3, 3, SHARPEN_MATRIX);
    private static final Component NULL_COMPONENT = new Component(){};
    private static MediaTracker sTracker = new MediaTracker(NULL_COMPONENT);
    protected static final AffineTransform IDENTITY_TRANSFORM = new AffineTransform();
    protected static final Point LOCATION_UPPER_LEFT = new Point(0, 0);
    private static final GraphicsConfiguration DEFAULT_CONFIGURATION = ImageUtil.getDefaultGraphicsConfiguration();

    private static GraphicsConfiguration getDefaultGraphicsConfiguration() {
        try {
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            if (!graphicsEnvironment.isHeadlessInstance()) {
                return graphicsEnvironment.getDefaultScreenDevice().getDefaultConfiguration();
            }
        }
        catch (LinkageError linkageError) {
            VM_SUPPORTS_ACCELERATION = false;
        }
        return null;
    }

    private ImageUtil() {
    }

    public static BufferedImage toBuffered(RenderedImage renderedImage) {
        WritableRaster writableRaster;
        String[] stringArray;
        Hashtable<String, Object> hashtable;
        if (renderedImage instanceof BufferedImage) {
            return (BufferedImage)renderedImage;
        }
        if (renderedImage == null) {
            throw new IllegalArgumentException("original == null");
        }
        String[] stringArray2 = renderedImage.getPropertyNames();
        if (stringArray2 != null && stringArray2.length > 0) {
            hashtable = new Hashtable<String, Object>(stringArray2.length);
            stringArray = stringArray2;
            int n2 = stringArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = stringArray[i2];
                hashtable.put(string, renderedImage.getProperty(string));
            }
        } else {
            hashtable = null;
        }
        if ((stringArray = renderedImage.getData()) instanceof WritableRaster) {
            writableRaster = (WritableRaster)stringArray;
        } else {
            writableRaster = stringArray.createCompatibleWritableRaster();
            writableRaster = renderedImage.copyData(writableRaster);
        }
        ColorModel colorModel = renderedImage.getColorModel();
        return new BufferedImage(colorModel, writableRaster, colorModel.isAlphaPremultiplied(), hashtable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static BufferedImage toBuffered(RenderedImage renderedImage, int n2) {
        if (renderedImage instanceof BufferedImage && ((BufferedImage)renderedImage).getType() == n2) {
            return (BufferedImage)renderedImage;
        }
        if (renderedImage == null) {
            throw new IllegalArgumentException("original == null");
        }
        BufferedImage bufferedImage = ImageUtil.createBuffered(renderedImage.getWidth(), renderedImage.getHeight(), n2, 3);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        try {
            graphics2D.setComposite(AlphaComposite.Src);
            graphics2D.drawRenderedImage(renderedImage, IDENTITY_TRANSFORM);
        }
        finally {
            graphics2D.dispose();
        }
        return bufferedImage;
    }

    public static BufferedImage toBuffered(BufferedImage bufferedImage, int n2) {
        return ImageUtil.toBuffered((RenderedImage)bufferedImage, n2);
    }

    public static BufferedImage toBuffered(Image image2) {
        if (image2 instanceof BufferedImage) {
            return (BufferedImage)image2;
        }
        if (image2 == null) {
            throw new IllegalArgumentException("original == null");
        }
        BufferedImageFactory bufferedImageFactory = new BufferedImageFactory(image2);
        return bufferedImageFactory.getBufferedImage();
    }

    public static BufferedImage createCopy(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("image == null");
        }
        ColorModel colorModel = bufferedImage.getColorModel();
        BufferedImage bufferedImage2 = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(bufferedImage.getWidth(), bufferedImage.getHeight()), colorModel.isAlphaPremultiplied(), null);
        ImageUtil.drawOnto(bufferedImage2, bufferedImage);
        return bufferedImage2;
    }

    static WritableRaster createRaster(int n2, int n3, Object object, ColorModel colorModel) {
        int n4;
        Object object2;
        DataBuffer dataBuffer = null;
        WritableRaster writableRaster = null;
        if (object instanceof int[]) {
            object2 = (int[])object;
            dataBuffer = new DataBufferInt((int[])object2, ((int[])object2).length);
            n4 = colorModel.getNumComponents();
        } else if (object instanceof short[]) {
            object2 = (short[])object;
            dataBuffer = new DataBufferUShort((short[])object2, ((int[])object2).length);
            n4 = ((int[])object2).length / (n2 * n3);
        } else if (object instanceof byte[]) {
            object2 = (byte[])object;
            dataBuffer = new DataBufferByte((byte[])object2, ((int[])object2).length);
            n4 = colorModel instanceof IndexColorModel ? 1 : ((int[])object2).length / (n2 * n3);
        } else {
            n4 = -1;
            writableRaster = colorModel.createCompatibleWritableRaster(n2, n3);
            writableRaster.setDataElements(0, 0, n2, n3, object);
        }
        if (writableRaster == null) {
            if (colorModel instanceof IndexColorModel && ImageUtil.isIndexedPacked((IndexColorModel)colorModel)) {
                writableRaster = Raster.createPackedRaster(dataBuffer, n2, n3, colorModel.getPixelSize(), LOCATION_UPPER_LEFT);
            } else if (colorModel instanceof PackedColorModel) {
                object2 = (PackedColorModel)colorModel;
                writableRaster = Raster.createPackedRaster(dataBuffer, n2, n3, n2, ((PackedColorModel)object2).getMasks(), LOCATION_UPPER_LEFT);
            } else {
                object2 = new int[n4];
                int n5 = 0;
                while (n5 < n4) {
                    object2[n5++] = n4 - n5;
                }
                writableRaster = Raster.createInterleavedRaster(dataBuffer, n2, n3, n2 * n4, n4, (int[])object2, LOCATION_UPPER_LEFT);
            }
        }
        return writableRaster;
    }

    private static boolean isIndexedPacked(IndexColorModel indexColorModel) {
        return indexColorModel.getPixelSize() == 1 || indexColorModel.getPixelSize() == 2 || indexColorModel.getPixelSize() == 4;
    }

    static WritableRaster createCompatibleWritableRaster(BufferedImage bufferedImage, ColorModel colorModel, int n2, int n3) {
        if (colorModel == null || ImageUtil.equals(bufferedImage.getColorModel(), colorModel)) {
            switch (bufferedImage.getType()) {
                case 5: {
                    int[] nArray = new int[]{2, 1, 0};
                    return Raster.createInterleavedRaster(0, n2, n3, n2 * 3, 3, nArray, null);
                }
                case 6: 
                case 7: {
                    int[] nArray = new int[]{3, 2, 1, 0};
                    return Raster.createInterleavedRaster(0, n2, n3, n2 * 4, 4, nArray, null);
                }
                case 0: {
                    SampleModel sampleModel = bufferedImage.getRaster().getSampleModel();
                    if (!(sampleModel instanceof ComponentSampleModel)) break;
                    int[] nArray = ((ComponentSampleModel)sampleModel).getBandOffsets();
                    return Raster.createInterleavedRaster(sampleModel.getDataType(), n2, n3, n2 * nArray.length, nArray.length, nArray, null);
                }
            }
            return bufferedImage.getColorModel().createCompatibleWritableRaster(n2, n3);
        }
        return colorModel.createCompatibleWritableRaster(n2, n3);
    }

    public static BufferedImage toBuffered(Image image2, int n2) {
        return ImageUtil.toBuffered(image2, n2, null);
    }

    private static BufferedImage toBuffered(Image image2, int n2, IndexColorModel indexColorModel) {
        if (image2 instanceof BufferedImage && ((BufferedImage)image2).getType() == n2 && (indexColorModel == null || ImageUtil.equals(((BufferedImage)image2).getColorModel(), indexColorModel))) {
            return (BufferedImage)image2;
        }
        if (image2 == null) {
            throw new IllegalArgumentException("original == null");
        }
        BufferedImage bufferedImage = indexColorModel == null ? ImageUtil.createBuffered(ImageUtil.getWidth(image2), ImageUtil.getHeight(image2), n2, 3) : new BufferedImage(ImageUtil.getWidth(image2), ImageUtil.getHeight(image2), n2, indexColorModel);
        ImageUtil.drawOnto(bufferedImage, image2);
        return bufferedImage;
    }

    static void drawOnto(BufferedImage bufferedImage, Image image2) {
        Graphics2D graphics2D = bufferedImage.createGraphics();
        try {
            graphics2D.setComposite(AlphaComposite.Src);
            graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
            graphics2D.drawImage(image2, 0, 0, null);
        }
        finally {
            graphics2D.dispose();
        }
    }

    public static BufferedImage createFlipped(Image image2, int n2) {
        AffineTransform affineTransform;
        switch (n2) {
            case -1: 
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException("Illegal direction: " + n2);
            }
        }
        BufferedImage bufferedImage = ImageUtil.toBuffered(image2);
        if (n2 == 1) {
            affineTransform = AffineTransform.getTranslateInstance(0.0, bufferedImage.getHeight());
            affineTransform.scale(1.0, -1.0);
        } else {
            affineTransform = AffineTransform.getTranslateInstance(bufferedImage.getWidth(), 0.0);
            affineTransform.scale(-1.0, 1.0);
        }
        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, 1);
        return affineTransformOp.filter(bufferedImage, null);
    }

    public static BufferedImage createRotated(Image image2, int n2) {
        switch (n2) {
            case -90: 
            case 90: 
            case 180: {
                return ImageUtil.createRotated(image2, Math.toRadians(n2));
            }
        }
        throw new IllegalArgumentException("Illegal direction: " + n2);
    }

    public static BufferedImage createRotated(Image image2, double d2) {
        return ImageUtil.createRotated0(ImageUtil.toBuffered(image2), d2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BufferedImage createRotated0(BufferedImage bufferedImage, double d2) {
        if (Math.abs(Math.toDegrees(d2)) % 360.0 == 0.0) {
            return bufferedImage;
        }
        boolean bl2 = Math.abs(Math.toDegrees(d2)) % 90.0 == 0.0;
        int n2 = bufferedImage.getWidth();
        int n3 = bufferedImage.getHeight();
        double d3 = Math.abs(Math.sin(d2));
        double d4 = Math.abs(Math.cos(d2));
        int n4 = (int)Math.floor((double)n2 * d4 + (double)n3 * d3);
        int n5 = (int)Math.floor((double)n3 * d4 + (double)n2 * d3);
        AffineTransform affineTransform = AffineTransform.getTranslateInstance((double)(n4 - n2) / 2.0, (double)(n5 - n3) / 2.0);
        affineTransform.rotate(d2, (double)n2 / 2.0, (double)n3 / 2.0);
        BufferedImage bufferedImage2 = ImageUtil.createTransparent(n4, n5);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        try {
            graphics2D.transform(affineTransform);
            if (!bl2) {
                graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setPaint(new TexturePaint(bufferedImage, new Rectangle2D.Float(0.0f, 0.0f, bufferedImage.getWidth(), bufferedImage.getHeight())));
                graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
            } else {
                graphics2D.drawImage((Image)bufferedImage, 0, 0, null);
            }
        }
        finally {
            graphics2D.dispose();
        }
        return bufferedImage2;
    }

    public static BufferedImage createScaled(Image image2, int n2, int n3, int n4) {
        Object object;
        ColorModel colorModel;
        int n5 = -1;
        if (image2 instanceof RenderedImage) {
            colorModel = ((RenderedImage)((Object)image2)).getColorModel();
            if (image2 instanceof BufferedImage) {
                n5 = ((BufferedImage)image2).getType();
            }
        } else {
            object = new BufferedImageFactory(image2);
            colorModel = ((BufferedImageFactory)object).getColorModel();
        }
        if (n5 != ((BufferedImage)(object = ImageUtil.createResampled(image2, n2, n3, n4))).getType() && n5 != -1 || !ImageUtil.equals(((BufferedImage)object).getColorModel(), colorModel)) {
            WritableRaster writableRaster = image2 instanceof BufferedImage ? ImageUtil.createCompatibleWritableRaster((BufferedImage)image2, colorModel, n2, n3) : colorModel.createCompatibleWritableRaster(n2, n3);
            BufferedImage bufferedImage = new BufferedImage(colorModel, writableRaster, colorModel.isAlphaPremultiplied(), null);
            if (colorModel instanceof IndexColorModel && n4 == 4) {
                new DiffusionDither((IndexColorModel)colorModel).filter((BufferedImage)object, bufferedImage);
            } else {
                ImageUtil.drawOnto(bufferedImage, (Image)object);
            }
            object = bufferedImage;
        }
        return object;
    }

    private static boolean equals(ColorModel colorModel, ColorModel colorModel2) {
        if (colorModel == colorModel2) {
            return true;
        }
        if (!colorModel.equals(colorModel2)) {
            return false;
        }
        if (colorModel instanceof IndexColorModel) {
            int n2;
            IndexColorModel indexColorModel = (IndexColorModel)colorModel;
            IndexColorModel indexColorModel2 = (IndexColorModel)colorModel2;
            int n3 = indexColorModel.getMapSize();
            if (n3 != (n2 = indexColorModel2.getMapSize())) {
                return false;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                if (indexColorModel.getRGB(i2) == indexColorModel2.getRGB(i2)) continue;
                return false;
            }
            return true;
        }
        return true;
    }

    public static BufferedImage createResampled(Image image2, int n2, int n3, int n4) {
        BufferedImage bufferedImage = image2 instanceof BufferedImage ? (BufferedImage)image2 : ImageUtil.toBuffered(image2, 6);
        return ImageUtil.createResampled(bufferedImage, n2, n3, n4);
    }

    public static BufferedImage createResampled(RenderedImage renderedImage, int n2, int n3, int n4) {
        BufferedImage bufferedImage = renderedImage instanceof BufferedImage ? (BufferedImage)renderedImage : ImageUtil.toBuffered(renderedImage, renderedImage.getColorModel().hasAlpha() ? 6 : 5);
        return ImageUtil.createResampled(bufferedImage, n2, n3, n4);
    }

    public static BufferedImage createResampled(BufferedImage bufferedImage, int n2, int n3, int n4) {
        return new ResampleOp(n2, n3, ImageUtil.convertAWTHints(n4)).filter(bufferedImage, null);
    }

    private static int convertAWTHints(int n2) {
        switch (n2) {
            case 2: 
            case 8: {
                return 1;
            }
            case 16: {
                return 2;
            }
            case 4: {
                return 13;
            }
        }
        return 9;
    }

    public static IndexColorModel getIndexColorModel(Image image2, int n2, int n3) {
        return IndexImage.getIndexColorModel(image2, n2, n3);
    }

    public static BufferedImage createIndexed(Image image2) {
        return IndexImage.getIndexedImage(ImageUtil.toBuffered(image2), 256, Color.black, 0);
    }

    public static BufferedImage createIndexed(Image image2, int n2, Color color, int n3) {
        return IndexImage.getIndexedImage(ImageUtil.toBuffered(image2), n2, color, n3);
    }

    public static BufferedImage createIndexed(Image image2, IndexColorModel indexColorModel, Color color, int n2) {
        return IndexImage.getIndexedImage(ImageUtil.toBuffered(image2), indexColorModel, color, n2);
    }

    public static BufferedImage createIndexed(Image image2, Image image3, Color color, int n2) {
        return IndexImage.getIndexedImage(ImageUtil.toBuffered(image2), IndexImage.getIndexColorModel(image3, 255, n2), color, n2);
    }

    public static BufferedImage sharpen(BufferedImage bufferedImage) {
        return ImageUtil.convolve(bufferedImage, SHARPEN_KERNEL, 2);
    }

    public static BufferedImage sharpen(BufferedImage bufferedImage, float f2) {
        if (f2 == 0.0f) {
            return bufferedImage;
        }
        float[] fArray = new float[]{0.0f, -f2, 0.0f, -f2, 4.0f * f2 + 1.0f, -f2, 0.0f, -f2, 0.0f};
        return ImageUtil.convolve(bufferedImage, new Kernel(3, 3, fArray), 2);
    }

    public static BufferedImage blur(BufferedImage bufferedImage) {
        return ImageUtil.blur(bufferedImage, 1.5f);
    }

    public static BufferedImage blur(BufferedImage bufferedImage, float f2) {
        if (f2 <= 1.0f) {
            return bufferedImage;
        }
        Kernel kernel = ImageUtil.makeKernel(f2);
        Kernel kernel2 = new Kernel(kernel.getHeight(), kernel.getWidth(), kernel.getKernelData(null));
        BufferedImage bufferedImage2 = ImageUtil.addBorder(bufferedImage, kernel.getWidth() / 2, kernel2.getHeight() / 2, 2);
        bufferedImage2 = ImageUtil.convolve(bufferedImage2, kernel, 1);
        bufferedImage2 = ImageUtil.convolve(bufferedImage2, kernel2, 1);
        return bufferedImage2.getSubimage(kernel.getWidth() / 2, kernel2.getHeight() / 2, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    private static Kernel makeKernel(float f2) {
        int n2;
        int n3 = (int)Math.ceil(f2);
        int n4 = n3 * 2 + 1;
        float[] fArray = new float[n4];
        float f3 = f2 / 3.0f;
        float f4 = 2.0f * f3 * f3;
        float f5 = (float)(Math.PI * 2 * (double)f3);
        float f6 = (float)Math.sqrt(f5);
        float f7 = f2 * f2;
        float f8 = 0.0f;
        int n5 = 0;
        for (n2 = -n3; n2 <= n3; ++n2) {
            float f9 = n2 * n2;
            fArray[n5] = f9 > f7 ? 0.0f : (float)Math.exp(-f9 / f4) / f6;
            f8 += fArray[n5];
            ++n5;
        }
        n2 = 0;
        while (n2 < n4) {
            int n6 = n2++;
            fArray[n6] = fArray[n6] / f8;
        }
        return new Kernel(n4, 1, fArray);
    }

    public static BufferedImage convolve(BufferedImage bufferedImage, Kernel kernel, int n2) {
        BufferedImage bufferedImage2;
        switch (n2) {
            case 2: 
            case 3: {
                bufferedImage2 = ImageUtil.addBorder(bufferedImage, kernel.getWidth() / 2, kernel.getHeight() / 2, n2);
                break;
            }
            default: {
                bufferedImage2 = bufferedImage;
            }
        }
        ConvolveOp convolveOp = new ConvolveOp(kernel, n2, null);
        BufferedImage bufferedImage3 = null;
        if (bufferedImage2.getType() == 5) {
            bufferedImage3 = ImageUtil.createBuffered(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getType(), bufferedImage.getColorModel().getTransparency());
        }
        BufferedImage bufferedImage4 = convolveOp.filter(bufferedImage2, bufferedImage3);
        if (bufferedImage != bufferedImage2) {
            bufferedImage4 = bufferedImage4.getSubimage(kernel.getWidth() / 2, kernel.getHeight() / 2, bufferedImage.getWidth(), bufferedImage.getHeight());
        }
        return bufferedImage4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static BufferedImage addBorder(BufferedImage bufferedImage, int n2, int n3, int n4) {
        int n5 = bufferedImage.getWidth();
        int n6 = bufferedImage.getHeight();
        ColorModel colorModel = bufferedImage.getColorModel();
        WritableRaster writableRaster = colorModel.createCompatibleWritableRaster(n5 + 2 * n2, n6 + 2 * n3);
        BufferedImage bufferedImage2 = new BufferedImage(colorModel, writableRaster, colorModel.isAlphaPremultiplied(), null);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        try {
            graphics2D.setComposite(AlphaComposite.Src);
            graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
            graphics2D.drawImage((Image)bufferedImage, n2, n3, null);
            switch (n4) {
                case 2: {
                    graphics2D.drawImage(bufferedImage, n2, 0, n2 + n5, n3, 0, 0, n5, 1, null);
                    graphics2D.drawImage(bufferedImage, -n5 + n2, n3, n2, n6 + n3, 0, 0, 1, n6, null);
                    graphics2D.drawImage(bufferedImage, n5 + n2, n3, 2 * n2 + n5, n6 + n3, n5 - 1, 0, n5, n6, null);
                    graphics2D.drawImage(bufferedImage, n2, n3 + n6, n2 + n5, 2 * n3 + n6, 0, n6 - 1, n5, n6, null);
                    return bufferedImage2;
                }
                case 3: {
                    graphics2D.drawImage((Image)bufferedImage, -n5 + n2, -n6 + n3, null);
                    graphics2D.drawImage((Image)bufferedImage, n2, -n6 + n3, null);
                    graphics2D.drawImage((Image)bufferedImage, n5 + n2, -n6 + n3, null);
                    graphics2D.drawImage((Image)bufferedImage, -n5 + n2, n3, null);
                    graphics2D.drawImage((Image)bufferedImage, n5 + n2, n3, null);
                    graphics2D.drawImage((Image)bufferedImage, -n5 + n2, n6 + n3, null);
                    graphics2D.drawImage((Image)bufferedImage, n2, n6 + n3, null);
                    graphics2D.drawImage((Image)bufferedImage, n5 + n2, n6 + n3, null);
                    return bufferedImage2;
                }
                default: {
                    throw new IllegalArgumentException("Illegal edge operation " + n4);
                }
            }
        }
        finally {
            graphics2D.dispose();
        }
    }

    public static Image contrast(Image image2) {
        return ImageUtil.contrast(image2, 0.3f);
    }

    public static Image contrast(Image image2, float f2) {
        if (f2 == 0.0f) {
            return image2;
        }
        BrightnessContrastFilter brightnessContrastFilter = new BrightnessContrastFilter(0.0f, f2);
        return ImageUtil.filter(image2, brightnessContrastFilter);
    }

    public static Image brightness(Image image2, float f2) {
        if (f2 == 0.0f) {
            return image2;
        }
        BrightnessContrastFilter brightnessContrastFilter = new BrightnessContrastFilter(f2, 0.0f);
        return ImageUtil.filter(image2, brightnessContrastFilter);
    }

    public static Image grayscale(Image image2) {
        GrayFilter grayFilter = new GrayFilter();
        return ImageUtil.filter(image2, grayFilter);
    }

    public static Image filter(Image image2, ImageFilter imageFilter) {
        FilteredImageSource filteredImageSource = new FilteredImageSource(image2.getSource(), imageFilter);
        return Toolkit.getDefaultToolkit().createImage(filteredImageSource);
    }

    public static BufferedImage accelerate(Image image2) {
        return ImageUtil.accelerate(image2, null, DEFAULT_CONFIGURATION);
    }

    public static BufferedImage accelerate(Image image2, GraphicsConfiguration graphicsConfiguration) {
        return ImageUtil.accelerate(image2, null, graphicsConfiguration);
    }

    static BufferedImage accelerate(Image image2, Color color, GraphicsConfiguration graphicsConfiguration) {
        BufferedImage bufferedImage;
        if (image2 instanceof BufferedImage && (bufferedImage = (BufferedImage)image2).getType() != 0 && ImageUtil.equals(bufferedImage.getColorModel(), graphicsConfiguration.getColorModel(bufferedImage.getTransparency()))) {
            return bufferedImage;
        }
        if (image2 == null) {
            throw new IllegalArgumentException("image == null");
        }
        int n2 = ImageUtil.getWidth(image2);
        int n3 = ImageUtil.getHeight(image2);
        BufferedImage bufferedImage2 = ImageUtil.createClear(n2, n3, -1, ImageUtil.getTransparency(image2), color, graphicsConfiguration);
        ImageUtil.drawOnto(bufferedImage2, image2);
        return bufferedImage2;
    }

    private static int getTransparency(Image image2) {
        if (image2 instanceof BufferedImage) {
            BufferedImage bufferedImage = (BufferedImage)image2;
            return bufferedImage.getTransparency();
        }
        return 1;
    }

    public static BufferedImage createTransparent(int n2, int n3) {
        return ImageUtil.createTransparent(n2, n3, -1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static BufferedImage createTransparent(int n2, int n3, int n4) {
        BufferedImage bufferedImage = ImageUtil.createBuffered(n2, n3, n4, 3);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        try {
            graphics2D.setComposite(AlphaComposite.Clear);
            graphics2D.fillRect(0, 0, n2, n3);
        }
        finally {
            graphics2D.dispose();
        }
        return bufferedImage;
    }

    public static BufferedImage createClear(int n2, int n3, Color color) {
        return ImageUtil.createClear(n2, n3, -1, color);
    }

    public static BufferedImage createClear(int n2, int n3, int n4, Color color) {
        return ImageUtil.createClear(n2, n3, n4, 1, color, DEFAULT_CONFIGURATION);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static BufferedImage createClear(int n2, int n3, int n4, int n5, Color color, GraphicsConfiguration graphicsConfiguration) {
        int n6 = color != null ? color.getTransparency() : n5;
        BufferedImage bufferedImage = ImageUtil.createBuffered(n2, n3, n4, n6, graphicsConfiguration);
        if (color != null) {
            Graphics2D graphics2D = bufferedImage.createGraphics();
            try {
                graphics2D.setComposite(AlphaComposite.Src);
                graphics2D.setColor(color);
                graphics2D.fillRect(0, 0, n2, n3);
            }
            finally {
                graphics2D.dispose();
            }
        }
        return bufferedImage;
    }

    private static BufferedImage createBuffered(int n2, int n3, int n4, int n5) {
        return ImageUtil.createBuffered(n2, n3, n4, n5, DEFAULT_CONFIGURATION);
    }

    static BufferedImage createBuffered(int n2, int n3, int n4, int n5, GraphicsConfiguration graphicsConfiguration) {
        GraphicsEnvironment graphicsEnvironment;
        if (VM_SUPPORTS_ACCELERATION && n4 == -1 && ImageUtil.supportsAcceleration(graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment())) {
            return ImageUtil.getConfiguration(graphicsConfiguration).createCompatibleImage(n2, n3, n5);
        }
        return new BufferedImage(n2, n3, ImageUtil.getImageType(n4, n5));
    }

    private static GraphicsConfiguration getConfiguration(GraphicsConfiguration graphicsConfiguration) {
        return graphicsConfiguration != null ? graphicsConfiguration : DEFAULT_CONFIGURATION;
    }

    private static int getImageType(int n2, int n3) {
        if (n2 != -1) {
            return n2;
        }
        switch (n3) {
            case 1: {
                return 1;
            }
            case 2: 
            case 3: {
                return 2;
            }
        }
        throw new IllegalArgumentException("Unknown transparency type: " + n3);
    }

    private static boolean supportsAcceleration(GraphicsEnvironment graphicsEnvironment) {
        try {
            return !graphicsEnvironment.isHeadlessInstance();
        }
        catch (LinkageError linkageError) {
            VM_SUPPORTS_ACCELERATION = false;
            return false;
        }
    }

    public static int getWidth(Image image2) {
        int n2 = image2.getWidth(NULL_COMPONENT);
        if (n2 < 0) {
            if (!ImageUtil.waitForImage(image2)) {
                return -1;
            }
            n2 = image2.getWidth(NULL_COMPONENT);
        }
        return n2;
    }

    public static int getHeight(Image image2) {
        int n2 = image2.getHeight(NULL_COMPONENT);
        if (n2 < 0) {
            if (!ImageUtil.waitForImage(image2)) {
                return -1;
            }
            n2 = image2.getHeight(NULL_COMPONENT);
        }
        return n2;
    }

    public static boolean waitForImage(Image image2) {
        return ImageUtil.waitForImages(new Image[]{image2}, -1L);
    }

    public static boolean waitForImage(Image image2, long l2) {
        return ImageUtil.waitForImages(new Image[]{image2}, l2);
    }

    public static boolean waitForImages(Image[] imageArray) {
        return ImageUtil.waitForImages(imageArray, -1L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean waitForImages(Image[] imageArray, long l2) {
        boolean bl2 = true;
        int n2 = imageArray.length == 1 ? System.identityHashCode(imageArray[0]) : System.identityHashCode(imageArray);
        for (Image image2 : imageArray) {
            sTracker.addImage(image2, n2);
            if (!sTracker.checkID(n2, false)) continue;
            sTracker.removeImage(image2, n2);
        }
        try {
            if (l2 < 0L) {
                sTracker.waitForID(n2);
            } else {
                bl2 = sTracker.waitForID(n2, l2);
            }
        }
        catch (InterruptedException interruptedException) {
            bl2 = false;
            return bl2;
        }
        finally {
            for (Image image2 : imageArray) {
                sTracker.removeImage(image2, n2);
            }
        }
        return bl2 && !sTracker.isErrorID(n2);
    }

    public static boolean hasTransparentPixels(RenderedImage renderedImage, boolean bl2) {
        if (renderedImage == null) {
            return false;
        }
        ColorModel colorModel = renderedImage.getColorModel();
        if (!colorModel.hasAlpha()) {
            return false;
        }
        if (colorModel.getTransparency() != 2 && colorModel.getTransparency() != 3) {
            return false;
        }
        Object object = null;
        for (int i2 = renderedImage.getMinTileY(); i2 < renderedImage.getNumYTiles(); ++i2) {
            for (int i3 = renderedImage.getMinTileX(); i3 < renderedImage.getNumXTiles(); ++i3) {
                Raster raster = renderedImage.getTile(i3, i2);
                int n2 = bl2 ? Math.max(raster.getWidth() / 10, 1) : 1;
                int n3 = bl2 ? Math.max(raster.getHeight() / 10, 1) : 1;
                for (int i4 = 0; i4 < raster.getHeight(); i4 += n3) {
                    for (int i5 = 0; i5 < raster.getWidth(); i5 += n2) {
                        if (colorModel.getAlpha(object = raster.getDataElements(i5, i4, object)) == 255) continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Color createTranslucent(Color color, int n2) {
        return new Color((n2 & 0xFF) << 24 | color.getRGB() & 0xFFFFFF, true);
    }

    static int blend(int n2, int n3) {
        return (((n2 ^ n3) & 0xFEFEFEFE) >> 1) + (n2 & n3);
    }

    public static Color blend(Color color, Color color2) {
        return new Color(ImageUtil.blend(color.getRGB(), color2.getRGB()), true);
    }

    public static Color blend(Color color, Color color2, float f2) {
        float f3 = 1.0f - f2;
        return new Color(ImageUtil.clamp((float)color.getRed() * f3 + (float)color2.getRed() * f2), ImageUtil.clamp((float)color.getGreen() * f3 + (float)color2.getGreen() * f2), ImageUtil.clamp((float)color.getBlue() * f3 + (float)color2.getBlue() * f2), ImageUtil.clamp((float)color.getAlpha() * f3 + (float)color2.getAlpha() * f2));
    }

    private static int clamp(float f2) {
        return (int)f2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import com.twelvemonkeys.image.BufferedImageFactory;
import com.twelvemonkeys.image.CopyDither;
import com.twelvemonkeys.image.DiffusionDither;
import com.twelvemonkeys.image.ImageConversionException;
import com.twelvemonkeys.image.ImageUtil;
import com.twelvemonkeys.image.InverseColorMapIndexColorModel;
import com.twelvemonkeys.image.MonochromeColorModel;
import com.twelvemonkeys.io.FileUtil;
import com.twelvemonkeys.lang.StringUtil;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

class IndexImage {
    protected static final int DITHER_MASK = 255;
    public static final int DITHER_DEFAULT = 0;
    public static final int DITHER_NONE = 1;
    public static final int DITHER_DIFFUSION = 2;
    public static final int DITHER_DIFFUSION_ALTSCANS = 3;
    protected static final int COLOR_SELECTION_MASK = 65280;
    public static final int COLOR_SELECTION_DEFAULT = 0;
    public static final int COLOR_SELECTION_FAST = 256;
    public static final int COLOR_SELECTION_QUALITY = 512;
    protected static final int TRANSPARENCY_MASK = 0xFF0000;
    public static final int TRANSPARENCY_DEFAULT = 0;
    public static final int TRANSPARENCY_OPAQUE = 65536;
    public static final int TRANSPARENCY_BITMASK = 131072;
    protected static final int TRANSPARENCY_TRANSLUCENT = 196608;

    private IndexImage() {
    }

    @Deprecated
    public static IndexColorModel getIndexColorModel(Image image2, int n2, boolean bl2) {
        return IndexImage.getIndexColorModel(image2, n2, bl2 ? 256 : 512);
    }

    public static IndexColorModel getIndexColorModel(Image image2, int n2, int n3) throws ImageConversionException {
        IndexColorModel indexColorModel = null;
        RenderedImage renderedImage = null;
        if (image2 instanceof RenderedImage) {
            renderedImage = (RenderedImage)((Object)image2);
            ColorModel colorModel = renderedImage.getColorModel();
            if (colorModel instanceof IndexColorModel && ((IndexColorModel)colorModel).getMapSize() <= n2) {
                indexColorModel = (IndexColorModel)colorModel;
            }
        } else {
            BufferedImageFactory bufferedImageFactory = new BufferedImageFactory(image2);
            ColorModel colorModel = bufferedImageFactory.getColorModel();
            if (colorModel instanceof IndexColorModel && ((IndexColorModel)colorModel).getMapSize() <= n2) {
                indexColorModel = (IndexColorModel)colorModel;
            } else {
                renderedImage = bufferedImageFactory.getBufferedImage();
            }
        }
        if (indexColorModel == null) {
            indexColorModel = IndexImage.createIndexColorModel(ImageUtil.toBuffered(renderedImage), n2, n3);
        } else if (!(indexColorModel instanceof InverseColorMapIndexColorModel)) {
            indexColorModel = new InverseColorMapIndexColorModel(indexColorModel);
        }
        return indexColorModel;
    }

    private static IndexColorModel createIndexColorModel(BufferedImage bufferedImage, int n2, int n3) {
        int n4;
        int n5;
        Object object;
        Object object2;
        int n6;
        int n7;
        boolean bl2 = IndexImage.isTransparent(n3);
        if (bl2) {
            --n2;
        }
        int n8 = bufferedImage.getWidth();
        int n9 = bufferedImage.getHeight();
        List[] listArray = new List[4096];
        int n10 = 1;
        if (IndexImage.isFast(n3)) {
            n10 += n8 * n9 / 16384;
        }
        int n11 = 0;
        for (n7 = 0; n7 < n8; ++n7) {
            block1: for (n6 = n7 % n10; n6 < n9; n6 += n10) {
                ++n11;
                int n12 = bufferedImage.getRGB(n7, n6) & 0xFFFFFF;
                int n13 = (n12 & 0xF00000) >>> 12 | (n12 & 0xF000) >>> 8 | (n12 & 0xF0) >>> 4;
                object2 = listArray[n13];
                if (object2 == null) {
                    object2 = new ArrayList();
                    object2.add(new Counter(n12));
                    listArray[n13] = object2;
                    continue;
                }
                object = object2.iterator();
                while (object.hasNext()) {
                    if (!((Counter)object.next()).add(n12)) continue;
                    continue block1;
                }
                object2.add(new Counter(n12));
            }
        }
        n7 = 1;
        n6 = 0;
        Cube[] cubeArray = new Cube[n2];
        cubeArray[0] = new Cube(listArray, n11);
        while (n7 < n2) {
            while (cubeArray[n6].isDone() && ++n6 != n7) {
            }
            if (n6 == n7) break;
            object2 = cubeArray[n6];
            object = ((Cube)object2).split();
            if (object == null) continue;
            if (((Cube)object).count > ((Cube)object2).count) {
                Object object3 = object2;
                object2 = object;
                object = object3;
            }
            int n14 = n6;
            n5 = ((Cube)object2).count;
            for (n4 = n6 + 1; n4 < n7 && cubeArray[n4].count >= n5; ++n4) {
                cubeArray[n14++] = cubeArray[n4];
            }
            cubeArray[n14++] = object2;
            n5 = ((Cube)object).count;
            while (n14 < n7 && cubeArray[n14].count >= n5) {
                ++n14;
            }
            System.arraycopy(cubeArray, n14, cubeArray, n14 + 1, n7 - n14);
            cubeArray[n14] = object;
            ++n7;
        }
        object2 = new byte[bl2 ? n7 + 1 : n7];
        object = new byte[bl2 ? n7 + 1 : n7];
        byte[] byArray = new byte[bl2 ? n7 + 1 : n7];
        for (n5 = 0; n5 < n7; ++n5) {
            n4 = cubeArray[n5].averageColor();
            object2[n5] = (byte)(n4 >> 16 & 0xFF);
            object[n5] = (byte)(n4 >> 8 & 0xFF);
            byArray[n5] = (byte)(n4 & 0xFF);
        }
        n5 = 8;
        InverseColorMapIndexColorModel inverseColorMapIndexColorModel = bl2 ? new InverseColorMapIndexColorModel(n5, ((Object)object2).length, (byte[])object2, (byte[])object, byArray, ((Object)object2).length - 1) : new InverseColorMapIndexColorModel(n5, ((Object)object2).length, (byte[])object2, (byte[])object, byArray);
        return inverseColorMapIndexColorModel;
    }

    public static BufferedImage getIndexedImage(BufferedImage bufferedImage) {
        return IndexImage.getIndexedImage(bufferedImage, 256, 0);
    }

    private static boolean isFast(int n2) {
        return (n2 & 0xFF00) != 512;
    }

    static boolean isTransparent(int n2) {
        return (n2 & 0x20000) != 0 || (n2 & 0x30000) != 0;
    }

    public static BufferedImage getIndexedImage(BufferedImage bufferedImage, Image image2, Color color, int n2) throws ImageConversionException {
        return IndexImage.getIndexedImage(bufferedImage, IndexImage.getIndexColorModel(image2, 256, n2), color, n2);
    }

    public static BufferedImage getIndexedImage(BufferedImage bufferedImage, int n2, Color color, int n3) {
        IndexColorModel indexColorModel = color != null ? IndexImage.getIndexColorModel((Image)IndexImage.createSolid(bufferedImage, color), n2, n3) : IndexImage.getIndexColorModel((Image)bufferedImage, n2, n3);
        if ((n3 & 0xFF) != 1 && indexColorModel.getMapSize() < n2) {
            n3 = n3 & 0xFFFFFF00 | 1;
        }
        return IndexImage.getIndexedImage(bufferedImage, indexColorModel, color, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static BufferedImage getIndexedImage(BufferedImage bufferedImage, IndexColorModel indexColorModel, Color color, int n2) {
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        boolean bl2 = IndexImage.isTransparent(n2) && bufferedImage.getColorModel().getTransparency() != 1 && indexColorModel.getTransparency() != 1;
        BufferedImage bufferedImage2 = bufferedImage;
        if (color != null) {
            bufferedImage2 = IndexImage.createSolid(bufferedImage, color);
        }
        BufferedImage bufferedImage3 = indexColorModel.getMapSize() > 2 ? new BufferedImage(n3, n4, 13, indexColorModel) : new BufferedImage(n3, n4, 12, indexColorModel);
        switch (n2 & 0xFF) {
            case 2: 
            case 3: {
                DiffusionDither diffusionDither = new DiffusionDither(indexColorModel);
                if ((n2 & 0xFF) == 3) {
                    diffusionDither.setAlternateScans(true);
                }
                diffusionDither.filter(bufferedImage2, bufferedImage3);
                break;
            }
            case 1: {
                CopyDither copyDither = new CopyDither(indexColorModel);
                copyDither.filter(bufferedImage2, bufferedImage3);
                break;
            }
            default: {
                Graphics2D graphics2D = bufferedImage3.createGraphics();
                try {
                    RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
                    graphics2D.setRenderingHints(renderingHints);
                    graphics2D.drawImage((Image)bufferedImage2, 0, 0, null);
                    break;
                }
                finally {
                    graphics2D.dispose();
                }
            }
        }
        if (bl2) {
            IndexImage.applyAlpha(bufferedImage3, bufferedImage);
        }
        return bufferedImage3;
    }

    public static BufferedImage getIndexedImage(BufferedImage bufferedImage, int n2, int n3) {
        return IndexImage.getIndexedImage(bufferedImage, n2, null, n3);
    }

    public static BufferedImage getIndexedImage(BufferedImage bufferedImage, IndexColorModel indexColorModel, int n2) {
        return IndexImage.getIndexedImage(bufferedImage, indexColorModel, null, n2);
    }

    public static BufferedImage getIndexedImage(BufferedImage bufferedImage, Image image2, int n2) {
        return IndexImage.getIndexedImage(bufferedImage, image2, null, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BufferedImage createSolid(BufferedImage bufferedImage, Color color) {
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getColorModel(), bufferedImage.copyData(null), bufferedImage.isAlphaPremultiplied(), null);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        try {
            graphics2D.setColor(color);
            graphics2D.setComposite(AlphaComposite.DstOver);
            graphics2D.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        }
        finally {
            graphics2D.dispose();
        }
        return bufferedImage2;
    }

    private static void applyAlpha(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
        for (int i2 = 0; i2 < bufferedImage2.getHeight(); ++i2) {
            for (int i3 = 0; i3 < bufferedImage2.getWidth(); ++i3) {
                if ((bufferedImage2.getRGB(i3, i2) >> 24 & 0xFF) >= 64) continue;
                bufferedImage.setRGB(i3, i2, 0xFFFFFF);
            }
        }
    }

    public static void main(String[] stringArray) {
        IndexColorModel indexColorModel;
        BufferedImage bufferedImage;
        Object object;
        File file;
        Object object2;
        Object object3;
        int n2 = 0;
        int n3 = -1;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        int n4 = 256;
        String string = null;
        String string2 = null;
        String string3 = null;
        Color color = null;
        boolean bl5 = false;
        String string4 = null;
        boolean bl6 = false;
        while (n2 < stringArray.length && stringArray[n2].charAt(0) == '-' && stringArray[n2].length() >= 2) {
            if (stringArray[n2].charAt(1) == 's' || stringArray[n2].equals("--speedtest")) {
                if (stringArray.length > ++n2 && stringArray[n2].charAt(0) != '-') {
                    try {
                        n3 = Integer.parseInt(stringArray[n2++]);
                        continue;
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl6 = true;
                        break;
                    }
                }
                n3 = 10;
                continue;
            }
            if (stringArray[n2].charAt(1) == 'w' || stringArray[n2].equals("--overwrite")) {
                bl2 = true;
                ++n2;
                continue;
            }
            if (stringArray[n2].charAt(1) == 'c' || stringArray[n2].equals("--colors")) {
                ++n2;
                try {
                    n4 = Integer.parseInt(stringArray[n2++]);
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    bl6 = true;
                    break;
                }
            }
            if (stringArray[n2].charAt(1) == 'g' || stringArray[n2].equals("--grayscale")) {
                ++n2;
                bl4 = true;
                continue;
            }
            if (stringArray[n2].charAt(1) == 'm' || stringArray[n2].equals("--monochrome")) {
                ++n2;
                n4 = 2;
                bl3 = true;
                continue;
            }
            if (stringArray[n2].charAt(1) == 'd' || stringArray[n2].equals("--dither")) {
                int n5 = ++n2;
                ++n2;
                string = stringArray[n5];
                continue;
            }
            if (stringArray[n2].charAt(1) == 'p' || stringArray[n2].equals("--palette")) {
                int n6 = ++n2;
                ++n2;
                string4 = stringArray[n6];
                continue;
            }
            if (stringArray[n2].charAt(1) == 'q' || stringArray[n2].equals("--quality")) {
                int n7 = ++n2;
                ++n2;
                string2 = stringArray[n7];
                continue;
            }
            if (stringArray[n2].charAt(1) == 'b' || stringArray[n2].equals("--bgcolor")) {
                ++n2;
                try {
                    color = StringUtil.toColor(stringArray[n2++]);
                    continue;
                }
                catch (Exception exception) {
                    bl6 = true;
                    break;
                }
            }
            if (stringArray[n2].charAt(1) == 't' || stringArray[n2].equals("--transparency")) {
                ++n2;
                bl5 = true;
                continue;
            }
            if (stringArray[n2].charAt(1) == 'f' || stringArray[n2].equals("--outputformat")) {
                int n8 = ++n2;
                ++n2;
                string3 = StringUtil.toLowerCase(stringArray[n8]);
                continue;
            }
            if (stringArray[n2].charAt(1) == 'h' || stringArray[n2].equals("--help")) {
                ++n2;
                bl6 = true;
                continue;
            }
            System.err.println("Unknown option \"" + stringArray[n2++] + "\"");
        }
        if (bl6 || stringArray.length < n2 + 1) {
            System.err.println("Usage: IndexImage [--help|-h] [--speedtest|-s <integer>] [--bgcolor|-b <color>] [--colors|-c <integer> | --grayscale|g | --monochrome|-m | --palette|-p <file>] [--dither|-d (default|diffusion|none)] [--quality|-q (default|high|low)] [--transparency|-t] [--outputformat|-f (gif|jpeg|png|wbmp|...)] [--overwrite|-w] <input> [<output>]");
            System.err.print("Input format names: ");
            object3 = ImageIO.getReaderFormatNames();
            for (int i2 = 0; i2 < ((String[])object3).length; ++i2) {
                System.err.print((String)object3[i2] + (i2 + 1 < ((Object)object3).length ? ", " : "\n"));
            }
            System.err.print("Output format names: ");
            object2 = ImageIO.getWriterFormatNames();
            for (int i3 = 0; i3 < ((String[])object2).length; ++i3) {
                System.err.print((String)object2[i3] + (i3 + 1 < ((Object)object2).length ? ", " : "\n"));
            }
            System.exit(5);
        }
        if (!((File)(object3 = new File(stringArray[n2++]))).exists()) {
            System.err.println("File \"" + ((File)object3).getAbsolutePath() + "\" does not exist!");
            System.exit(5);
        }
        object2 = null;
        if (string4 != null && !((File)(object2 = new File(string4))).exists()) {
            System.err.println("File \"" + ((File)object3).getAbsolutePath() + "\" does not exist!");
            System.exit(5);
        }
        if (n2 < stringArray.length) {
            file = new File(stringArray[n2]);
            if (string3 == null) {
                string3 = FileUtil.getExtension(file);
            }
        } else {
            object = FileUtil.getBasename((File)object3);
            if (string3 == null) {
                string3 = "png";
            }
            file = new File((String)object + '.' + string3);
        }
        if (!bl2 && file.exists()) {
            System.err.println("The file \"" + file.getAbsolutePath() + "\" allready exists!");
            System.exit(5);
        }
        object = null;
        BufferedImage bufferedImage2 = null;
        try {
            object = ImageIO.read((File)object3);
            if (object == null) {
                System.err.println("No reader for image: \"" + ((File)object3).getAbsolutePath() + "\"!");
                System.exit(5);
            }
            if (object2 != null && (bufferedImage2 = ImageIO.read((File)object2)) == null) {
                System.err.println("No reader for image: \"" + ((File)object2).getAbsolutePath() + "\"!");
                System.exit(5);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace(System.err);
            System.exit(5);
        }
        int n9 = 0;
        if ("DIFFUSION".equalsIgnoreCase(string)) {
            n9 |= 2;
        } else if ("DIFFUSION_ALTSCANS".equalsIgnoreCase(string)) {
            n9 |= 3;
        } else if ("NONE".equalsIgnoreCase(string)) {
            n9 |= 1;
        }
        if ("HIGH".equalsIgnoreCase(string2)) {
            n9 |= 0x200;
        } else if ("LOW".equalsIgnoreCase(string2)) {
            n9 |= 0x100;
        }
        if (bl5) {
            n9 |= 0x20000;
        }
        if (color != null && bufferedImage2 == null) {
            bufferedImage2 = IndexImage.createSolid((BufferedImage)object, color);
        }
        long l2 = 0L;
        if (n3 > 0) {
            System.out.println("Measuring speed!");
            l2 = System.currentTimeMillis();
        }
        if (bl3) {
            bufferedImage = IndexImage.getIndexedImage((BufferedImage)object, MonochromeColorModel.getInstance(), color, n9);
            indexColorModel = MonochromeColorModel.getInstance();
        } else if (bl4) {
            object = ImageUtil.toBuffered(ImageUtil.grayscale((Image)object));
            indexColorModel = IndexImage.getIndexColorModel((Image)object, n4, n9);
            bufferedImage = IndexImage.getIndexedImage((BufferedImage)object, indexColorModel, color, n9);
            if (n3 > 0) {
                indexColorModel = IndexImage.getIndexColorModel((Image)bufferedImage, n4, n9);
            }
        } else if (bufferedImage2 != null) {
            indexColorModel = IndexImage.getIndexColorModel((Image)bufferedImage2, n4, n9);
            bufferedImage = IndexImage.getIndexedImage(ImageUtil.toBuffered((BufferedImage)object, 2), indexColorModel, color, n9);
        } else {
            object = ImageUtil.toBuffered((BufferedImage)object, 2);
            indexColorModel = IndexImage.getIndexColorModel((Image)object, n4, n9);
            bufferedImage = IndexImage.getIndexedImage((BufferedImage)object, indexColorModel, color, n9);
        }
        if (n3 > 0) {
            System.out.println("Color selection + dither: " + (System.currentTimeMillis() - l2) + " ms");
        }
        try {
            if (!ImageIO.write((RenderedImage)bufferedImage, string3, file)) {
                System.err.println("No writer for format: \"" + string3 + "\"!");
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace(System.err);
        }
        if (n3 > 0) {
            System.out.println("Measuring speed!");
            for (int i4 = 0; i4 < 10; ++i4) {
                IndexImage.getIndexedImage((BufferedImage)object, indexColorModel, color, n9);
            }
            long l3 = 0L;
            for (int i5 = 0; i5 < n3; ++i5) {
                l2 = System.currentTimeMillis();
                IndexImage.getIndexedImage((BufferedImage)object, indexColorModel, color, n9);
                l3 += System.currentTimeMillis() - l2;
                System.out.print('.');
                if ((i5 + 1) % 10 != 0) continue;
                System.out.println("\nAverage (after " + (i5 + 1) + " iterations): " + l3 / (long)(i5 + 1) + "ms");
            }
            System.out.println("\nDither only:");
            System.out.println("Total time (" + n3 + " invocations): " + l3 + "ms");
            System.out.println("Average: " + l3 / (long)n3 + "ms");
        }
    }

    private static class Cube {
        int[] min = new int[]{0, 0, 0};
        int[] max = new int[]{255, 255, 255};
        boolean done = false;
        List<Counter>[] colors = null;
        int count = 0;
        static final int RED = 0;
        static final int GRN = 1;
        static final int BLU = 2;

        public Cube(List<Counter>[] listArray, int n2) {
            this.colors = listArray;
            this.count = n2;
        }

        public boolean isDone() {
            return this.done;
        }

        public Cube split() {
            int n2;
            int n3;
            int n4;
            int n5 = this.max[0] - this.min[0] + 1;
            int n6 = this.max[1] - this.min[1] + 1;
            int n7 = this.max[2] - this.min[2] + 1;
            if (n5 >= n6) {
                n4 = 1;
                if (n5 >= n7) {
                    n3 = 0;
                    n2 = 2;
                } else {
                    n3 = 2;
                    n2 = 0;
                }
            } else if (n6 >= n7) {
                n3 = 1;
                n4 = 0;
                n2 = 2;
            } else {
                n3 = 2;
                n4 = 0;
                n2 = 1;
            }
            Cube cube = this.splitChannel(n3, n4, n2);
            if (cube != null) {
                return cube;
            }
            cube = this.splitChannel(n4, n3, n2);
            if (cube != null) {
                return cube;
            }
            cube = this.splitChannel(n2, n3, n4);
            if (cube != null) {
                return cube;
            }
            this.done = true;
            return null;
        }

        public Cube splitChannel(int n2, int n3, int n4) {
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            if (this.min[n2] == this.max[n2]) {
                return null;
            }
            int n10 = (2 - n2) * 4;
            int n11 = (2 - n3) * 4;
            int n12 = (2 - n4) * 4;
            int n13 = this.count / 2;
            int[] nArray = new int[256];
            int n14 = 0;
            int[] nArray2 = new int[]{this.min[0] >> 4, this.min[1] >> 4, this.min[2] >> 4};
            int[] nArray3 = new int[]{this.max[0] >> 4, this.max[1] >> 4, this.max[2] >> 4};
            int n15 = this.min[0];
            int n16 = this.min[1];
            int n17 = this.min[2];
            int n18 = this.max[0];
            int n19 = this.max[1];
            int n20 = this.max[2];
            int[] nArray4 = new int[]{0, 0, 0};
            for (n9 = nArray2[n2]; n9 <= nArray3[n2]; ++n9) {
                n8 = n9 << n10;
                for (n7 = nArray2[n3]; n7 <= nArray3[n3]; ++n7) {
                    n6 = n8 | n7 << n11;
                    for (n5 = nArray2[n4]; n5 <= nArray3[n4]; ++n5) {
                        int n21 = n6 | n5 << n12;
                        List<Counter> list = this.colors[n21];
                        if (list == null) continue;
                        for (Counter counter : list) {
                            int n22 = counter.val;
                            nArray4[0] = (n22 & 0xFF0000) >> 16;
                            nArray4[1] = (n22 & 0xFF00) >> 8;
                            nArray4[2] = n22 & 0xFF;
                            if (nArray4[0] < n15 || nArray4[0] > n18 || nArray4[1] < n16 || nArray4[1] > n19 || nArray4[2] < n17 || nArray4[2] > n20) continue;
                            int n23 = nArray4[n2];
                            nArray[n23] = nArray[n23] + counter.count;
                            n14 += counter.count;
                        }
                    }
                }
                if (n14 >= n13) break;
            }
            n14 = 0;
            n9 = -1;
            n8 = this.min[n2];
            n7 = this.max[n2];
            for (n6 = this.min[n2]; n6 <= this.max[n2]; ++n6) {
                n5 = nArray[n6];
                if (n5 == 0) {
                    if (n14 != 0 || n6 >= this.max[n2]) continue;
                    this.min[n2] = n6 + 1;
                    continue;
                }
                if (n14 + n5 < n13) {
                    n9 = n6;
                    n14 += n5;
                    continue;
                }
                if (n13 - n14 <= n14 + n5 - n13) {
                    if (n9 == -1) {
                        if (n5 == this.count) {
                            this.max[n2] = n6;
                            return null;
                        }
                        n8 = n6;
                        n7 = n6 + 1;
                        break;
                    }
                    n8 = n9;
                    n7 = n6;
                    break;
                }
                if (n6 == this.max[n2]) {
                    if (n5 == this.count) {
                        return null;
                    }
                    n8 = n9;
                    n7 = n6;
                    break;
                }
                n14 += n5;
                n8 = n6;
                n7 = n6 + 1;
                break;
            }
            Cube cube = new Cube(this.colors, n14);
            this.count -= n14;
            cube.min[n2] = this.min[n2];
            cube.max[n2] = n8;
            this.min[n2] = n7;
            cube.min[n3] = this.min[n3];
            cube.max[n3] = this.max[n3];
            cube.min[n4] = this.min[n4];
            cube.max[n4] = this.max[n4];
            return cube;
        }

        public int averageColor() {
            if (this.count == 0) {
                return 0;
            }
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            int n2 = this.min[0];
            int n3 = this.min[1];
            int n4 = this.min[2];
            int n5 = this.max[0];
            int n6 = this.max[1];
            int n7 = this.max[2];
            int[] nArray = new int[]{n2 >> 4, n3 >> 4, n4 >> 4};
            int[] nArray2 = new int[]{n5 >> 4, n6 >> 4, n7 >> 4};
            for (int i2 = nArray[0]; i2 <= nArray2[0]; ++i2) {
                int n8 = i2 << 8;
                for (int i3 = nArray[1]; i3 <= nArray2[1]; ++i3) {
                    int n9 = n8 | i3 << 4;
                    for (int i4 = nArray[2]; i4 <= nArray2[2]; ++i4) {
                        int n10 = n9 | i4;
                        List<Counter> list = this.colors[n10];
                        if (list == null) continue;
                        for (Counter counter : list) {
                            int n11 = counter.val;
                            int n12 = (n11 & 0xFF0000) >> 16;
                            int n13 = (n11 & 0xFF00) >> 8;
                            int n14 = n11 & 0xFF;
                            if (n12 < n2 || n12 > n5 || n13 < n3 || n13 > n6 || n14 < n4 || n14 > n7) continue;
                            float f5 = (float)counter.count / (float)this.count;
                            f2 += (float)n12 * f5;
                            f3 += (float)n13 * f5;
                            f4 += (float)n14 * f5;
                        }
                    }
                }
            }
            return (int)(f2 + 0.5f) << 16 | (int)(f3 + 0.5f) << 8 | (int)(f4 + 0.5f);
        }
    }

    private static class Counter {
        public int val;
        public int count = 1;

        public Counter(int n2) {
            this.val = n2;
        }

        public boolean add(int n2) {
            if (this.val != n2) {
                return false;
            }
            ++this.count;
            return true;
        }
    }
}


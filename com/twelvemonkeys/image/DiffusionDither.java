/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import com.twelvemonkeys.image.ImageFilterException;
import com.twelvemonkeys.image.IndexImage;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.RasterOp;
import java.awt.image.WritableRaster;
import java.util.Random;

public class DiffusionDither
implements BufferedImageOp,
RasterOp {
    private static final int FS_SCALE = 256;
    private static final Random RANDOM = new Random();
    protected final IndexColorModel indexColorModel;
    private boolean alternateScans = true;

    public DiffusionDither(IndexColorModel indexColorModel) {
        this.indexColorModel = indexColorModel;
    }

    public DiffusionDither() {
        this(null);
    }

    public void setAlternateScans(boolean bl2) {
        this.alternateScans = bl2;
    }

    @Override
    public final BufferedImage createCompatibleDestImage(BufferedImage bufferedImage, ColorModel colorModel) {
        if (colorModel == null) {
            return new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 13, this.getICM(bufferedImage));
        }
        if (colorModel instanceof IndexColorModel) {
            return new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 13, (IndexColorModel)colorModel);
        }
        throw new ImageFilterException("Only IndexColorModel allowed.");
    }

    @Override
    public final WritableRaster createCompatibleDestRaster(Raster raster) {
        return this.createCompatibleDestRaster(raster, this.getICM(raster));
    }

    public final WritableRaster createCompatibleDestRaster(Raster raster, IndexColorModel indexColorModel) {
        return indexColorModel.createCompatibleWritableRaster(raster.getWidth(), raster.getHeight());
    }

    @Override
    public final Rectangle2D getBounds2D(BufferedImage bufferedImage) {
        return this.getBounds2D(bufferedImage.getRaster());
    }

    @Override
    public final Rectangle2D getBounds2D(Raster raster) {
        return raster.getBounds();
    }

    @Override
    public final Point2D getPoint2D(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            point2D2 = new Point2D.Float();
        }
        point2D2.setLocation(point2D.getX(), point2D.getY());
        return point2D2;
    }

    @Override
    public final RenderingHints getRenderingHints() {
        return null;
    }

    private static int[] toRGBArray(int n2, int[] nArray) {
        nArray[0] = (n2 & 0xFF0000) >> 16;
        nArray[1] = (n2 & 0xFF00) >> 8;
        nArray[2] = n2 & 0xFF;
        return nArray;
    }

    private static int toIntARGB(int[] nArray) {
        return 0xFF000000 | nArray[0] << 16 | nArray[1] << 8 | nArray[2];
    }

    @Override
    public final BufferedImage filter(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
        if (bufferedImage2 == null) {
            bufferedImage2 = this.createCompatibleDestImage(bufferedImage, this.getICM(bufferedImage));
        } else if (!(bufferedImage2.getColorModel() instanceof IndexColorModel)) {
            throw new ImageFilterException("Only IndexColorModel allowed.");
        }
        this.filter(bufferedImage.getRaster(), bufferedImage2.getRaster(), (IndexColorModel)bufferedImage2.getColorModel());
        return bufferedImage2;
    }

    @Override
    public final WritableRaster filter(Raster raster, WritableRaster writableRaster) {
        return this.filter(raster, writableRaster, this.getICM(raster));
    }

    private IndexColorModel getICM(BufferedImage bufferedImage) {
        return this.indexColorModel != null ? this.indexColorModel : IndexImage.getIndexColorModel((Image)bufferedImage, 256, 131072);
    }

    private IndexColorModel getICM(Raster raster) {
        return this.indexColorModel != null ? this.indexColorModel : this.createIndexColorModel(raster);
    }

    private IndexColorModel createIndexColorModel(Raster raster) {
        BufferedImage bufferedImage = new BufferedImage(raster.getWidth(), raster.getHeight(), 2);
        bufferedImage.setData(raster);
        return IndexImage.getIndexColorModel((Image)bufferedImage, 256, 131072);
    }

    public final WritableRaster filter(Raster raster, WritableRaster writableRaster, IndexColorModel indexColorModel) {
        int n2 = raster.getWidth();
        int n3 = raster.getHeight();
        if (writableRaster == null) {
            writableRaster = this.createCompatibleDestRaster(raster, indexColorModel);
        }
        int[][] nArray = new int[n2 + 2][3];
        int[][] nArray2 = new int[n2 + 2][3];
        for (int i2 = 0; i2 < n2 + 2; ++i2) {
            nArray[i2][0] = RANDOM.nextInt(512) - 256;
            nArray[i2][1] = RANDOM.nextInt(512) - 256;
            nArray[i2][2] = RANDOM.nextInt(512) - 256;
        }
        int[] nArray3 = new int[3];
        int[] nArray4 = new int[4];
        int[] nArray5 = new int[4];
        Object object = null;
        boolean bl2 = true;
        for (int i3 = 0; i3 < n3; ++i3) {
            int n4;
            int n5 = nArray2.length;
            while (--n5 >= 0) {
                nArray2[n5][0] = 0;
                nArray2[n5][1] = 0;
                nArray2[n5][2] = 0;
            }
            if (bl2) {
                n5 = 0;
                n4 = n2;
            } else {
                n5 = n2 - 1;
                n4 = -1;
            }
            while (true) {
                raster.getPixel(n5, i3, nArray4);
                for (int i4 = 0; i4 < 3; ++i4) {
                    nArray4[i4] = (nArray4[i4] << 4) + nArray[n5 + 1][i4] + 8 >> 4;
                    if (nArray4[i4] > 255) {
                        nArray4[i4] = 255;
                        continue;
                    }
                    if (nArray4[i4] >= 0) continue;
                    nArray4[i4] = 0;
                }
                object = indexColorModel.getDataElements(DiffusionDither.toIntARGB(nArray4), object);
                writableRaster.setDataElements(n5, i3, object);
                writableRaster.getPixel(n5, i3, nArray5);
                DiffusionDither.toRGBArray(indexColorModel.getRGB(nArray5[0]), nArray5);
                nArray3[0] = nArray4[0] - nArray5[0];
                nArray3[1] = nArray4[1] - nArray5[1];
                nArray3[2] = nArray4[2] - nArray5[2];
                if (bl2) {
                    int[] nArray6 = nArray[n5 + 2];
                    nArray6[0] = nArray6[0] + nArray3[0] * 7;
                    int[] nArray7 = nArray[n5 + 2];
                    nArray7[1] = nArray7[1] + nArray3[1] * 7;
                    int[] nArray8 = nArray[n5 + 2];
                    nArray8[2] = nArray8[2] + nArray3[2] * 7;
                    int[] nArray9 = nArray2[n5];
                    nArray9[0] = nArray9[0] + nArray3[0] * 3;
                    int[] nArray10 = nArray2[n5];
                    nArray10[1] = nArray10[1] + nArray3[1] * 3;
                    int[] nArray11 = nArray2[n5];
                    nArray11[2] = nArray11[2] + nArray3[2] * 3;
                    int[] nArray12 = nArray2[n5 + 1];
                    nArray12[0] = nArray12[0] + nArray3[0] * 5;
                    int[] nArray13 = nArray2[n5 + 1];
                    nArray13[1] = nArray13[1] + nArray3[1] * 5;
                    int[] nArray14 = nArray2[n5 + 1];
                    nArray14[2] = nArray14[2] + nArray3[2] * 5;
                    int[] nArray15 = nArray2[n5 + 2];
                    nArray15[0] = nArray15[0] + nArray3[0];
                    int[] nArray16 = nArray2[n5 + 2];
                    nArray16[1] = nArray16[1] + nArray3[1];
                    int[] nArray17 = nArray2[n5 + 2];
                    nArray17[2] = nArray17[2] + nArray3[2];
                    if (++n5 < n4) continue;
                    break;
                }
                int[] nArray18 = nArray[n5];
                nArray18[0] = nArray18[0] + nArray3[0] * 7;
                int[] nArray19 = nArray[n5];
                nArray19[1] = nArray19[1] + nArray3[1] * 7;
                int[] nArray20 = nArray[n5];
                nArray20[2] = nArray20[2] + nArray3[2] * 7;
                int[] nArray21 = nArray2[n5 + 2];
                nArray21[0] = nArray21[0] + nArray3[0] * 3;
                int[] nArray22 = nArray2[n5 + 2];
                nArray22[1] = nArray22[1] + nArray3[1] * 3;
                int[] nArray23 = nArray2[n5 + 2];
                nArray23[2] = nArray23[2] + nArray3[2] * 3;
                int[] nArray24 = nArray2[n5 + 1];
                nArray24[0] = nArray24[0] + nArray3[0] * 5;
                int[] nArray25 = nArray2[n5 + 1];
                nArray25[1] = nArray25[1] + nArray3[1] * 5;
                int[] nArray26 = nArray2[n5 + 1];
                nArray26[2] = nArray26[2] + nArray3[2] * 5;
                int[] nArray27 = nArray2[n5];
                nArray27[0] = nArray27[0] + nArray3[0];
                int[] nArray28 = nArray2[n5];
                nArray28[1] = nArray28[1] + nArray3[1];
                int[] nArray29 = nArray2[n5];
                nArray29[2] = nArray29[2] + nArray3[2];
                if (--n5 <= n4) break;
            }
            int[][] nArray30 = nArray;
            nArray = nArray2;
            nArray2 = nArray30;
            if (!this.alternateScans) continue;
            bl2 = !bl2;
        }
        return writableRaster;
    }
}


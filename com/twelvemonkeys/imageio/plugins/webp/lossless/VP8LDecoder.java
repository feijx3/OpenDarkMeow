/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.LSBBitReader;
import com.twelvemonkeys.imageio.plugins.webp.lossless.ColorCache;
import com.twelvemonkeys.imageio.plugins.webp.lossless.ColorIndexingTransform;
import com.twelvemonkeys.imageio.plugins.webp.lossless.ColorTransform;
import com.twelvemonkeys.imageio.plugins.webp.lossless.HuffmanCodeGroup;
import com.twelvemonkeys.imageio.plugins.webp.lossless.HuffmanInfo;
import com.twelvemonkeys.imageio.plugins.webp.lossless.PredictorTransform;
import com.twelvemonkeys.imageio.plugins.webp.lossless.SubtractGreenTransform;
import com.twelvemonkeys.imageio.plugins.webp.lossless.Transform;
import com.twelvemonkeys.imageio.util.RasterUtils;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.IIOException;
import javax.imageio.ImageReadParam;
import javax.imageio.stream.ImageInputStream;

public final class VP8LDecoder {
    private static final byte[] DISTANCES = new byte[]{24, 7, 23, 25, 40, 6, 39, 41, 22, 26, 38, 42, 56, 5, 55, 57, 21, 27, 54, 58, 37, 43, 72, 4, 71, 73, 20, 28, 53, 59, 70, 74, 36, 44, 88, 69, 75, 52, 60, 3, 87, 89, 19, 29, 86, 90, 35, 45, 68, 76, 85, 91, 51, 61, 104, 2, 103, 105, 18, 30, 102, 106, 34, 46, 84, 92, 67, 77, 101, 107, 50, 62, 120, 1, 119, 121, 83, 93, 17, 31, 100, 108, 66, 78, 118, 122, 33, 47, 117, 123, 49, 63, 99, 109, 82, 94, 0, 116, 124, 65, 79, 16, 32, 98, 110, 48, 115, 125, 81, 95, 64, 114, 126, 97, 111, 80, 113, 127, 96, 112};
    private final ImageInputStream imageInput;
    private final LSBBitReader lsbBitReader;

    public VP8LDecoder(ImageInputStream imageInputStream, boolean bl2) {
        this.imageInput = imageInputStream;
        this.lsbBitReader = new LSBBitReader(imageInputStream);
    }

    public void readVP8Lossless(WritableRaster writableRaster, boolean bl2, ImageReadParam imageReadParam, int n2, int n3) throws IOException {
        WritableRaster writableRaster2;
        WritableRaster writableRaster3;
        if (bl2) {
            this.imageInput.seek(this.imageInput.getStreamPosition() + 5L);
        }
        int n4 = n2;
        ArrayList<Transform> arrayList = new ArrayList<Transform>();
        while (bl2 && this.lsbBitReader.readBit() == 1) {
            n4 = this.readTransform(n4, n3, arrayList);
        }
        int n5 = 0;
        if (this.lsbBitReader.readBit() == 1 && ((n5 = (int)this.lsbBitReader.readBits(4)) < 1 || n5 > 11)) {
            throw new IIOException("Corrupt WebP stream, colorCacheBits < 1 || > 11: " + n5);
        }
        HuffmanInfo huffmanInfo = this.readHuffmanCodes(n4, n3, n5, bl2);
        ColorCache colorCache = null;
        if (n5 > 0) {
            colorCache = new ColorCache(n5);
        }
        if (bl2) {
            Rectangle rectangle = new Rectangle(n2, n3);
            writableRaster3 = this.createDecodeRaster(writableRaster, imageReadParam, rectangle);
            writableRaster2 = writableRaster3.createWritableChild(0, 0, n4, n3, 0, 0, null);
        } else {
            writableRaster2 = writableRaster3 = writableRaster;
        }
        this.decodeImage(writableRaster2, huffmanInfo, colorCache);
        for (Transform transform : arrayList) {
            transform.applyInverse(writableRaster3);
        }
        if (writableRaster3 != writableRaster) {
            VP8LDecoder.copyIntoRasterWithParams(writableRaster3, writableRaster, imageReadParam);
        }
    }

    private WritableRaster createDecodeRaster(WritableRaster writableRaster, ImageReadParam imageReadParam, Rectangle rectangle) {
        boolean bl2 = false;
        if (imageReadParam != null) {
            if (imageReadParam.getSourceRegion() != null && !imageReadParam.getSourceRegion().contains(rectangle) || imageReadParam.getSourceXSubsampling() != 1 || imageReadParam.getSourceYSubsampling() != 1) {
                return Raster.createInterleavedRaster(0, rectangle.width, rectangle.height, 4 * rectangle.width, 4, new int[]{0, 1, 2, 3}, null);
            }
            rectangle.setLocation(imageReadParam.getDestinationOffset());
            bl2 = true;
        }
        if (!writableRaster.getBounds().contains(rectangle)) {
            return Raster.createInterleavedRaster(0, rectangle.width, rectangle.height, 4 * rectangle.width, 4, new int[]{0, 1, 2, 3}, null);
        }
        return bl2 ? writableRaster.createWritableChild(rectangle.x, rectangle.y, rectangle.width, rectangle.height, 0, 0, null) : writableRaster;
    }

    public static void copyIntoRasterWithParams(Raster raster, WritableRaster writableRaster, ImageReadParam imageReadParam) {
        Point point;
        Rectangle rectangle = imageReadParam != null && imageReadParam.getSourceRegion() != null ? imageReadParam.getSourceRegion() : raster.getBounds();
        int n2 = imageReadParam != null ? imageReadParam.getSourceXSubsampling() : 1;
        int n3 = imageReadParam != null ? imageReadParam.getSourceYSubsampling() : 1;
        int n4 = imageReadParam != null ? imageReadParam.getSubsamplingXOffset() : 0;
        int n5 = imageReadParam != null ? imageReadParam.getSubsamplingYOffset() : 0;
        Point point2 = point = imageReadParam != null ? imageReadParam.getDestinationOffset() : new Point(0, 0);
        if (n2 == 1 && n3 == 1) {
            writableRaster.setRect(point.x, point.y, raster);
        } else {
            byte[] byArray = new byte[4];
            int n6 = writableRaster.getWidth() + writableRaster.getMinX();
            int n7 = writableRaster.getHeight() + writableRaster.getMinY();
            int n8 = point.y;
            int n9 = rectangle.y + n5;
            while (n8 < n7) {
                int n10 = point.x;
                int n11 = rectangle.x + n4;
                while (n10 < n6) {
                    raster.getDataElements(n11, n9, byArray);
                    writableRaster.setDataElements(n10, n8, byArray);
                    ++n10;
                    n11 += n2;
                }
                ++n8;
                n9 += n3;
            }
        }
    }

    private void decodeImage(WritableRaster writableRaster, HuffmanInfo huffmanInfo, ColorCache colorCache) throws IOException {
        int n2 = writableRaster.getWidth();
        int n3 = writableRaster.getHeight();
        int n4 = huffmanInfo.metaCodeBits == 0 ? -1 : (1 << huffmanInfo.metaCodeBits) - 1;
        HuffmanCodeGroup huffmanCodeGroup = huffmanInfo.huffmanGroups[0];
        byte[] byArray = new byte[4];
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                short s2;
                if ((i3 & n4) == 0 && huffmanInfo.huffmanMetaCodes != null) {
                    s2 = huffmanInfo.huffmanMetaCodes.getSample(i3 >> huffmanInfo.metaCodeBits, i2 >> huffmanInfo.metaCodeBits, 0);
                    huffmanCodeGroup = huffmanInfo.huffmanGroups[s2];
                }
                if ((s2 = huffmanCodeGroup.mainCode.readSymbol(this.lsbBitReader)) < 256) {
                    this.decodeLiteral(writableRaster, colorCache, huffmanCodeGroup, byArray, i2, i3, s2);
                    continue;
                }
                if (s2 < 280) {
                    int n5 = this.decodeBwRef(writableRaster, colorCache, n2, huffmanCodeGroup, byArray, s2, i3, i2);
                    i2 += (--i3 + n5) / n2;
                    i3 = (i3 + n5) % n2;
                    if (i2 >= n3 || i3 >= n2 || huffmanInfo.huffmanMetaCodes == null) continue;
                    int n6 = huffmanInfo.huffmanMetaCodes.getSample(i3 >> huffmanInfo.metaCodeBits, i2 >> huffmanInfo.metaCodeBits, 0);
                    huffmanCodeGroup = huffmanInfo.huffmanGroups[n6];
                    continue;
                }
                this.decodeCached(writableRaster, colorCache, byArray, i2, i3, s2);
            }
        }
    }

    private void decodeCached(WritableRaster writableRaster, ColorCache colorCache, byte[] byArray, int n2, int n3, short s2) {
        int n4 = colorCache.lookup(s2 - 256 - 24);
        byArray[0] = (byte)(n4 >> 16 & 0xFF);
        byArray[1] = (byte)(n4 >> 8 & 0xFF);
        byArray[2] = (byte)(n4 & 0xFF);
        byArray[3] = (byte)(n4 >>> 24);
        writableRaster.setDataElements(n3, n2, byArray);
    }

    private void decodeLiteral(WritableRaster writableRaster, ColorCache colorCache, HuffmanCodeGroup huffmanCodeGroup, byte[] byArray, int n2, int n3, short s2) throws IOException {
        byte by2 = (byte)huffmanCodeGroup.redCode.readSymbol(this.lsbBitReader);
        byte by3 = (byte)huffmanCodeGroup.blueCode.readSymbol(this.lsbBitReader);
        byte by4 = (byte)huffmanCodeGroup.alphaCode.readSymbol(this.lsbBitReader);
        byArray[0] = by2;
        byArray[1] = (byte)s2;
        byArray[2] = by3;
        byArray[3] = by4;
        writableRaster.setDataElements(n3, n2, byArray);
        if (colorCache != null) {
            colorCache.insert((by4 & 0xFF) << 24 | (by2 & 0xFF) << 16 | (s2 & 0xFF) << 8 | by3 & 0xFF);
        }
    }

    private int decodeBwRef(WritableRaster writableRaster, ColorCache colorCache, int n2, HuffmanCodeGroup huffmanCodeGroup, byte[] byArray, short s2, int n3, int n4) throws IOException {
        int n5;
        int n6;
        int n7;
        int n8 = this.lz77decode(s2 - 256);
        short s3 = huffmanCodeGroup.distanceCode.readSymbol(this.lsbBitReader);
        int n9 = this.lz77decode(s3);
        if (n9 > 120) {
            n7 = n9 - 120;
            n6 = n4 - n7 / n2;
            n5 = n3 - n7 % n2;
        } else {
            n5 = n3 - (8 - (DISTANCES[n9 - 1] & 0xF));
            n6 = n4 - (DISTANCES[n9 - 1] >> 4);
        }
        if (n5 < 0) {
            --n6;
            n5 += n2;
        } else if (n5 >= n2) {
            n5 -= n2;
            ++n6;
        }
        for (n7 = n8; n7 > 0; --n7) {
            if (n3 == n2) {
                n3 = 0;
                ++n4;
            }
            writableRaster.getDataElements(n5++, n6, byArray);
            writableRaster.setDataElements(n3, n4, byArray);
            if (n5 == n2) {
                n5 = 0;
                ++n6;
            }
            if (colorCache != null) {
                colorCache.insert((byArray[3] & 0xFF) << 24 | (byArray[0] & 0xFF) << 16 | (byArray[1] & 0xFF) << 8 | byArray[2] & 0xFF);
            }
            ++n3;
        }
        return n8;
    }

    private int lz77decode(int n2) throws IOException {
        if (n2 < 4) {
            return n2 + 1;
        }
        int n3 = n2 - 2 >> 1;
        int n4 = 2 + (n2 & 1) << n3;
        return n4 + (int)this.lsbBitReader.readBits(n3) + 1;
    }

    private int readTransform(int n2, int n3, List<Transform> list) throws IOException {
        int n4 = (int)this.lsbBitReader.readBits(2);
        switch (n4) {
            case 0: 
            case 1: {
                byte by2 = (byte)(this.lsbBitReader.readBits(3) + 2L);
                int n5 = VP8LDecoder.subSampleSize(n2, by2);
                int n6 = VP8LDecoder.subSampleSize(n3, by2);
                WritableRaster writableRaster = Raster.createInterleavedRaster(0, n5, n6, 4 * n5, 4, new int[]{0, 1, 2, 3}, null);
                this.readVP8Lossless(writableRaster, false, null, n5, n6);
                if (n4 == 0) {
                    list.add(0, new PredictorTransform(writableRaster, by2));
                    break;
                }
                list.add(0, new ColorTransform(writableRaster, by2));
                break;
            }
            case 2: {
                list.add(0, new SubtractGreenTransform());
                break;
            }
            case 3: {
                byte by3;
                int n7 = (int)this.lsbBitReader.readBits(8) + 1;
                int n8 = n7 > 16 ? 256 : (n7 > 4 ? 16 : (n7 > 2 ? 4 : 2));
                byte[] byArray = new byte[n8 * 4];
                this.readVP8Lossless(Raster.createInterleavedRaster(new DataBufferByte(byArray, n7 * 4), n7, 1, n7 * 4, 4, new int[]{0, 1, 2, 3}, null), false, null, n7, 1);
                for (by3 = 4; by3 < byArray.length; ++by3) {
                    byte by4 = by3;
                    byArray[by4] = (byte)(byArray[by4] + byArray[by3 - 4]);
                }
                by3 = (byte)(n7 > 16 ? 0 : (n7 > 4 ? 1 : (n7 > 2 ? 2 : 3)));
                n2 = VP8LDecoder.subSampleSize(n2, by3);
                list.add(0, new ColorIndexingTransform(byArray, by3));
                break;
            }
            default: {
                throw new AssertionError((Object)("Invalid transformType: " + n4));
            }
        }
        return n2;
    }

    private HuffmanInfo readHuffmanCodes(int n2, int n3, int n4, boolean bl2) throws IOException {
        Object object;
        int n5 = 1;
        int n6 = 0;
        WritableRaster writableRaster = null;
        if (bl2 && this.lsbBitReader.readBit() == 1) {
            n6 = (int)this.lsbBitReader.readBits(3) + 2;
            int n7 = VP8LDecoder.subSampleSize(n2, n6);
            int n8 = VP8LDecoder.subSampleSize(n3, n6);
            object = Raster.createPackedRaster(3, n7, n8, new int[]{65280, 255, -16777216, 0xFF0000}, null);
            this.readVP8Lossless(RasterUtils.asByteRaster((WritableRaster)object), false, null, n7, n8);
            int[] nArray = ((DataBufferInt)((Raster)object).getDataBuffer()).getData();
            int n9 = Integer.MIN_VALUE;
            for (int n10 : nArray) {
                n9 = Math.max(n9, n10 & 0xFFFF);
            }
            n5 = n9 + 1;
            writableRaster = Raster.createPackedRaster(((Raster)object).getDataBuffer(), n7, n8, n7, new int[]{65535}, null);
        }
        object = new HuffmanCodeGroup[n5];
        for (int i2 = 0; i2 < ((HuffmanCodeGroup[])object).length; ++i2) {
            object[i2] = new HuffmanCodeGroup(this.lsbBitReader, n4);
        }
        return new HuffmanInfo(writableRaster, n6, (HuffmanCodeGroup[])object);
    }

    private static int subSampleSize(int n2, int n3) {
        return n2 + (1 << n3) - 1 >> n3;
    }
}


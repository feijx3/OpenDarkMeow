/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.lossless.Transform;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

final class PredictorTransform
implements Transform {
    private final Raster data;
    private final byte bits;

    public PredictorTransform(Raster raster, byte by2) {
        this.data = raster;
        this.bits = by2;
    }

    @Override
    public void applyInverse(WritableRaster writableRaster) {
        int n2;
        int n3 = writableRaster.getWidth();
        int n4 = writableRaster.getHeight();
        byte[] byArray = new byte[4];
        writableRaster.getDataElements(0, 0, byArray);
        byArray[3] = (byte)(byArray[3] + -1);
        writableRaster.setDataElements(0, 0, byArray);
        byte[] byArray2 = new byte[4];
        byte[] byArray3 = new byte[4];
        byte[] byArray4 = new byte[4];
        for (n2 = 1; n2 < n3; ++n2) {
            writableRaster.getDataElements(n2, 0, byArray);
            writableRaster.getDataElements(n2 - 1, 0, byArray2);
            PredictorTransform.addPixels(byArray, byArray2);
            writableRaster.setDataElements(n2, 0, byArray);
        }
        for (n2 = 1; n2 < n4; ++n2) {
            writableRaster.getDataElements(0, n2, byArray);
            writableRaster.getDataElements(0, n2 - 1, byArray2);
            PredictorTransform.addPixels(byArray, byArray2);
            writableRaster.setDataElements(0, n2, byArray);
        }
        for (n2 = 1; n2 < n4; ++n2) {
            for (int i2 = 1; i2 < n3; ++i2) {
                int n5 = this.data.getSample(i2 >> this.bits, n2 >> this.bits, 1);
                writableRaster.getDataElements(i2, n2, byArray);
                int n6 = i2 - 1;
                int n7 = n2 - 1;
                int n8 = i2 == n3 - 1 ? 0 : i2 + 1;
                int n9 = i2 == n3 - 1 ? n2 : n7;
                switch (n5) {
                    case 0: {
                        byArray[3] = (byte)(byArray[3] + -1);
                        break;
                    }
                    case 1: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 2: {
                        writableRaster.getDataElements(i2, n7, byArray2);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 3: {
                        writableRaster.getDataElements(n8, n9, byArray2);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 4: {
                        writableRaster.getDataElements(n6, n7, byArray2);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 5: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(n8, n9, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 6: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(n6, n7, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 7: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 8: {
                        writableRaster.getDataElements(n6, n7, byArray2);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 9: {
                        writableRaster.getDataElements(i2, n7, byArray2);
                        writableRaster.getDataElements(n8, n9, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 10: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(n6, n7, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        writableRaster.getDataElements(n8, n9, byArray4);
                        PredictorTransform.average2(byArray3, byArray4);
                        PredictorTransform.average2(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 11: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        writableRaster.getDataElements(n6, n7, byArray4);
                        PredictorTransform.addPixels(byArray, PredictorTransform.select(byArray2, byArray3, byArray4));
                        break;
                    }
                    case 12: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        writableRaster.getDataElements(n6, n7, byArray4);
                        PredictorTransform.clampAddSubtractFull(byArray2, byArray3, byArray4);
                        PredictorTransform.addPixels(byArray, byArray2);
                        break;
                    }
                    case 13: {
                        writableRaster.getDataElements(n6, n2, byArray2);
                        writableRaster.getDataElements(i2, n7, byArray3);
                        PredictorTransform.average2(byArray2, byArray3);
                        writableRaster.getDataElements(n6, n7, byArray3);
                        PredictorTransform.clampAddSubtractHalf(byArray2, byArray3);
                        PredictorTransform.addPixels(byArray, byArray2);
                    }
                }
                writableRaster.setDataElements(i2, n2, byArray);
            }
        }
    }

    private static byte[] select(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = PredictorTransform.addSubtractFull(byArray[3], byArray2[3], byArray3[3]);
        int n7 = PredictorTransform.manhattanDistance(byArray, n6, n5 = PredictorTransform.addSubtractFull(byArray[0], byArray2[0], byArray3[0]), n4 = PredictorTransform.addSubtractFull(byArray[1], byArray2[1], byArray3[1]), n3 = PredictorTransform.addSubtractFull(byArray[2], byArray2[2], byArray3[2]));
        return n7 < (n2 = PredictorTransform.manhattanDistance(byArray2, n6, n5, n4, n3)) ? byArray : byArray2;
    }

    private static int manhattanDistance(byte[] byArray, int n2, int n3, int n4, int n5) {
        return Math.abs(n2 - (byArray[3] & 0xFF)) + Math.abs(n3 - (byArray[0] & 0xFF)) + Math.abs(n4 - (byArray[1] & 0xFF)) + Math.abs(n5 - (byArray[2] & 0xFF));
    }

    private static void average2(byte[] byArray, byte[] byArray2) {
        byArray[0] = (byte)(((byArray[0] & 0xFF) + (byArray2[0] & 0xFF)) / 2);
        byArray[1] = (byte)(((byArray[1] & 0xFF) + (byArray2[1] & 0xFF)) / 2);
        byArray[2] = (byte)(((byArray[2] & 0xFF) + (byArray2[2] & 0xFF)) / 2);
        byArray[3] = (byte)(((byArray[3] & 0xFF) + (byArray2[3] & 0xFF)) / 2);
    }

    private static int clamp(int n2) {
        return Math.max(0, Math.min(n2, 255));
    }

    private static void clampAddSubtractFull(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        byArray[0] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractFull(byArray[0], byArray2[0], byArray3[0]));
        byArray[1] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractFull(byArray[1], byArray2[1], byArray3[1]));
        byArray[2] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractFull(byArray[2], byArray2[2], byArray3[2]));
        byArray[3] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractFull(byArray[3], byArray2[3], byArray3[3]));
    }

    private static void clampAddSubtractHalf(byte[] byArray, byte[] byArray2) {
        byArray[0] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractHalf(byArray[0], byArray2[0]));
        byArray[1] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractHalf(byArray[1], byArray2[1]));
        byArray[2] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractHalf(byArray[2], byArray2[2]));
        byArray[3] = (byte)PredictorTransform.clamp(PredictorTransform.addSubtractHalf(byArray[3], byArray2[3]));
    }

    private static int addSubtractFull(byte by2, byte by3, byte by4) {
        return (by2 & 0xFF) + (by3 & 0xFF) - (by4 & 0xFF);
    }

    private static int addSubtractHalf(byte by2, byte by3) {
        return (by2 & 0xFF) + ((by2 & 0xFF) - (by3 & 0xFF)) / 2;
    }

    private static void addPixels(byte[] byArray, byte[] byArray2) {
        byArray[0] = (byte)(byArray[0] + byArray2[0]);
        byArray[1] = (byte)(byArray[1] + byArray2[1]);
        byArray[2] = (byte)(byArray[2] + byArray2[2]);
        byArray[3] = (byte)(byArray[3] + byArray2[3]);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.util;

import com.twelvemonkeys.lang.Validate;
import java.awt.Point;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;

public final class RasterUtils {
    private RasterUtils() {
    }

    public static Raster asByteRaster(Raster raster) {
        return RasterUtils.asByteRaster0(raster);
    }

    public static WritableRaster asByteRaster(WritableRaster writableRaster) {
        return (WritableRaster)RasterUtils.asByteRaster0(writableRaster);
    }

    private static Raster asByteRaster0(Raster raster) {
        switch (raster.getTransferType()) {
            case 0: {
                return raster;
            }
            case 3: {
                SampleModel sampleModel = raster.getSampleModel();
                if (!(sampleModel instanceof SinglePixelPackedSampleModel)) {
                    throw new IllegalArgumentException(String.format("Requires SinglePixelPackedSampleModel, %s not supported", sampleModel.getClass().getSimpleName()));
                }
                final DataBufferInt dataBufferInt = (DataBufferInt)raster.getDataBuffer();
                int n2 = raster.getWidth();
                int n3 = raster.getHeight();
                int n4 = dataBufferInt.getSize();
                return new WritableRaster(new PixelInterleavedSampleModel(0, n2, n3, 4, n2 * 4, RasterUtils.createBandOffsets((SinglePixelPackedSampleModel)sampleModel)), new DataBuffer(0, n4 * 4){
                    final int[] MASKS;
                    {
                        super(n2, n3);
                        this.MASKS = new int[]{-256, -65281, -16711681, 0xFFFFFF};
                    }

                    @Override
                    public int getElem(int n2, int n3) {
                        int n4 = n3 / 4;
                        int n5 = n3 % 4 * 8;
                        return dataBufferInt.getElem(n4) >>> n5 & 0xFF;
                    }

                    @Override
                    public void setElem(int n2, int n3, int n4) {
                        int n5 = n3 / 4;
                        int n6 = n3 % 4;
                        int n7 = n6 * 8;
                        int n8 = dataBufferInt.getElem(n5) & this.MASKS[n6] | (n4 & 0xFF) << n7;
                        dataBufferInt.setElem(n5, n8);
                    }
                }, new Point()){};
            }
        }
        throw new IllegalArgumentException(String.format("Raster type %d not supported", raster.getTransferType()));
    }

    private static int[] createBandOffsets(SinglePixelPackedSampleModel singlePixelPackedSampleModel) {
        Validate.notNull(singlePixelPackedSampleModel, "sampleModel");
        int[] nArray = singlePixelPackedSampleModel.getBitMasks();
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            int n3 = 0;
            if (n2 != 0) {
                while ((n2 & 0xFF) == 0) {
                    n2 >>>= 8;
                    ++n3;
                }
            }
            nArray2[i2] = n3;
        }
        return nArray2;
    }
}


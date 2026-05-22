/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import com.twelvemonkeys.image.IndexImage;
import com.twelvemonkeys.image.InverseColorMap;
import com.twelvemonkeys.lang.StringUtil;
import com.twelvemonkeys.lang.Validate;
import java.awt.Image;
import java.awt.image.IndexColorModel;

public class InverseColorMapIndexColorModel
extends IndexColorModel {
    protected int[] rgbs;
    protected int mapSize;
    protected InverseColorMap inverseMap = null;
    private static final int ALPHA_THRESHOLD = 128;
    private int whiteIndex = -1;
    private static final int WHITE = 0xFFFFFF;
    private static final int RGB_MASK = 0xFFFFFF;

    public InverseColorMapIndexColorModel(IndexColorModel indexColorModel) {
        this(Validate.notNull(indexColorModel, "color model"), InverseColorMapIndexColorModel.getRGBs(indexColorModel));
    }

    private InverseColorMapIndexColorModel(IndexColorModel indexColorModel, int[] nArray) {
        super(indexColorModel.getComponentSize()[0], indexColorModel.getMapSize(), nArray, 0, indexColorModel.getTransferType(), indexColorModel.getValidPixels());
        this.rgbs = nArray;
        this.mapSize = this.rgbs.length;
        this.inverseMap = new InverseColorMap(this.rgbs);
        this.whiteIndex = this.getWhiteIndex();
    }

    private static int[] getRGBs(IndexColorModel indexColorModel) {
        int[] nArray = new int[indexColorModel.getMapSize()];
        indexColorModel.getRGBs(nArray);
        return nArray;
    }

    public InverseColorMapIndexColorModel(int n2, int n3, int[] nArray, int n4, boolean bl2, int n5, int n6) {
        super(n2, n3, nArray, n4, bl2, n5, n6);
        this.rgbs = InverseColorMapIndexColorModel.getRGBs(this);
        this.mapSize = this.rgbs.length;
        this.inverseMap = new InverseColorMap(this.rgbs, n5);
        this.whiteIndex = this.getWhiteIndex();
    }

    public InverseColorMapIndexColorModel(int n2, int n3, byte[] byArray, byte[] byArray2, byte[] byArray3, int n4) {
        super(n2, n3, byArray, byArray2, byArray3, n4);
        this.rgbs = InverseColorMapIndexColorModel.getRGBs(this);
        this.mapSize = this.rgbs.length;
        this.inverseMap = new InverseColorMap(this.rgbs, n4);
        this.whiteIndex = this.getWhiteIndex();
    }

    public InverseColorMapIndexColorModel(int n2, int n3, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        super(n2, n3, byArray, byArray2, byArray3);
        this.rgbs = InverseColorMapIndexColorModel.getRGBs(this);
        this.mapSize = this.rgbs.length;
        this.inverseMap = new InverseColorMap(this.rgbs);
        this.whiteIndex = this.getWhiteIndex();
    }

    private int getWhiteIndex() {
        for (int i2 = 0; i2 < this.rgbs.length; ++i2) {
            int n2 = this.rgbs[i2];
            if ((n2 & 0xFFFFFF) != 0xFFFFFF) continue;
            return i2;
        }
        return -1;
    }

    public static IndexColorModel create(Image image2, int n2, int n3) {
        IndexColorModel indexColorModel = IndexImage.getIndexColorModel(image2, n2, n3);
        InverseColorMapIndexColorModel inverseColorMapIndexColorModel = indexColorModel instanceof InverseColorMapIndexColorModel ? (InverseColorMapIndexColorModel)indexColorModel : new InverseColorMapIndexColorModel(indexColorModel);
        return inverseColorMapIndexColorModel;
    }

    @Override
    public Object getDataElements(int n2, Object object) {
        int n3;
        int n4 = n2 >>> 24;
        int n5 = n4 < 128 && this.getTransparentPixel() != -1 ? this.getTransparentPixel() : ((n3 = n2 & 0xFFFFFF) == 0xFFFFFF && this.whiteIndex != -1 ? this.whiteIndex : this.inverseMap.getIndexNearest(n3));
        return this.installpixel(object, n5);
    }

    private Object installpixel(Object object, int n2) {
        switch (this.transferType) {
            case 3: {
                int[] nArray;
                if (object == null) {
                    nArray = new int[1];
                    object = nArray;
                } else {
                    nArray = (int[])object;
                }
                nArray[0] = n2;
                break;
            }
            case 0: {
                byte[] byArray;
                if (object == null) {
                    byArray = new byte[1];
                    object = byArray;
                } else {
                    byArray = (byte[])object;
                }
                byArray[0] = (byte)n2;
                break;
            }
            case 1: {
                short[] sArray;
                if (object == null) {
                    sArray = new short[1];
                    object = sArray;
                } else {
                    sArray = (short[])object;
                }
                sArray[0] = (short)n2;
                break;
            }
            default: {
                throw new UnsupportedOperationException("This method has not been implemented for transferType " + this.transferType);
            }
        }
        return object;
    }

    @Override
    public String toString() {
        return StringUtil.replace(super.toString(), "IndexColorModel: ", this.getClass().getName() + ": ");
    }
}


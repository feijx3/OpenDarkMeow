/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.plugins.webp.vp8.BoolDecoder;
import com.twelvemonkeys.imageio.plugins.webp.vp8.Globals;
import com.twelvemonkeys.imageio.plugins.webp.vp8.IDCT;
import com.twelvemonkeys.imageio.plugins.webp.vp8.MacroBlock;
import com.twelvemonkeys.imageio.plugins.webp.vp8.VP8Frame;
import java.io.IOException;

final class SubBlock {
    private final SubBlock above;
    private int[][] dest;
    private int[][] diff;
    private boolean hasNoZeroToken;
    private final SubBlock left;
    private final MacroBlock macroBlock;
    private int mode;
    private final Plane plane;
    private int[][] predict;
    private int[] tokens = new int[16];

    SubBlock(MacroBlock macroBlock, SubBlock subBlock, SubBlock subBlock2, Plane plane) {
        this.macroBlock = macroBlock;
        this.plane = plane;
        this.above = subBlock;
        this.left = subBlock2;
        this.mode = 0;
        for (int i2 = 0; i2 < 16; ++i2) {
            this.tokens[i2] = 0;
        }
    }

    public static int planeToType(Plane plane, boolean bl2) {
        switch (plane) {
            case Y2: {
                return 1;
            }
            case Y1: {
                return bl2 ? 0 : 3;
            }
            case U: 
            case V: {
                return 2;
            }
        }
        return -1;
    }

    private int DCTextra(BoolDecoder boolDecoder, int[] nArray) throws IOException {
        int n2 = 0;
        int n3 = 0;
        do {
            n2 += n2 + boolDecoder.readBool(nArray[n3]);
        } while (nArray[++n3] > 0);
        return n2;
    }

    public void decodeSubBlock(BoolDecoder boolDecoder, int[][][][] nArray, int n2, int n3, boolean bl2) throws IOException {
        int n4;
        SubBlock subBlock = this;
        int n5 = 0;
        if (bl2) {
            n5 = 1;
        }
        int n6 = n2;
        int n7 = 0;
        int n8 = 1;
        boolean bl3 = false;
        while (n8 != 11 && n7 + n5 < 16) {
            n8 = boolDecoder.readTree(Globals.vp8CoefTree, nArray[n3][Globals.vp8CoefBands[n7 + n5]][n6], bl3 ? 1 : 0);
            n4 = this.decodeToken(boolDecoder, n8);
            n6 = 0;
            bl3 = false;
            if (n4 == 1 || n4 == -1) {
                n6 = 1;
            } else if (n4 > 1 || n4 < -1) {
                n6 = 2;
            } else if (n4 == 0) {
                bl3 = true;
            }
            int[] nArray2 = subBlock.getTokens();
            if (n8 != 11) {
                nArray2[Globals.vp8defaultZigZag1d[n7 + n5]] = n4;
            }
            ++n7;
        }
        this.hasNoZeroToken = false;
        for (n4 = 0; n4 < 16; ++n4) {
            if (this.tokens[n4] == 0) continue;
            this.hasNoZeroToken = true;
        }
    }

    private int decodeToken(BoolDecoder boolDecoder, int n2) throws IOException {
        int n3 = n2;
        if (n2 == 5) {
            n3 = 5 + this.DCTextra(boolDecoder, Globals.Pcat1);
        }
        if (n2 == 6) {
            n3 = 7 + this.DCTextra(boolDecoder, Globals.Pcat2);
        }
        if (n2 == 7) {
            n3 = 11 + this.DCTextra(boolDecoder, Globals.Pcat3);
        }
        if (n2 == 8) {
            n3 = 19 + this.DCTextra(boolDecoder, Globals.Pcat4);
        }
        if (n2 == 9) {
            n3 = 35 + this.DCTextra(boolDecoder, Globals.Pcat5);
        }
        if (n2 == 10) {
            n3 = 67 + this.DCTextra(boolDecoder, Globals.Pcat6);
        }
        if (n2 != 0 && n2 != 11 && boolDecoder.readBit() > 0) {
            n3 = -n3;
        }
        return n3;
    }

    public void dequantSubBlock(VP8Frame vP8Frame, Integer n2) {
        SubBlock subBlock = this;
        int[] nArray = new int[16];
        for (int i2 = 0; i2 < 16; ++i2) {
            int n3;
            if (this.plane == Plane.U || this.plane == Plane.V) {
                n3 = vP8Frame.getSegmentQuants().getSegQuants()[this.getMacroBlock().getSegmentId()].getUvac_delta_q();
                if (i2 == 0) {
                    n3 = vP8Frame.getSegmentQuants().getSegQuants()[this.getMacroBlock().getSegmentId()].getUvdc_delta_q();
                }
            } else {
                n3 = vP8Frame.getSegmentQuants().getSegQuants()[this.getMacroBlock().getSegmentId()].getY1ac();
                if (i2 == 0) {
                    n3 = vP8Frame.getSegmentQuants().getSegQuants()[this.getMacroBlock().getSegmentId()].getY1dc();
                }
            }
            int n4 = subBlock.getTokens()[i2];
            nArray[i2] = n4 * n3;
        }
        if (n2 != null) {
            nArray[0] = n2;
        }
        int[][] nArray2 = IDCT.idct4x4llm(nArray);
        subBlock.setDiff(nArray2);
    }

    public void drawDebug() {
        if (this.dest != null) {
            this.dest[0][0] = 128;
            this.dest[1][0] = 128;
            this.dest[2][0] = 128;
            this.dest[3][0] = 128;
            this.dest[0][0] = 128;
            this.dest[0][1] = 128;
            this.dest[0][2] = 128;
            this.dest[0][3] = 128;
        }
    }

    public void drawDebugH() {
        if (this.dest != null) {
            this.dest[0][0] = 0;
            this.dest[1][0] = 0;
            this.dest[2][0] = 0;
            this.dest[3][0] = 0;
        }
    }

    public void drawDebugV() {
        if (this.dest != null) {
            this.dest[0][0] = 0;
            this.dest[0][1] = 0;
            this.dest[0][2] = 0;
            this.dest[0][3] = 0;
        }
    }

    public SubBlock getAbove() {
        return this.above;
    }

    public String getDebugString() {
        String string = "";
        string = string + "  " + (Object)((Object)this.plane);
        if (this.getMacroBlock().getYMode() == 4 && this.plane == Plane.Y1) {
            string = string + "\n  " + Globals.getSubBlockModeAsString(this.mode);
        }
        return string;
    }

    public int[][] getDest() {
        if (this.dest != null) {
            return this.dest;
        }
        return new int[4][4];
    }

    public int[][] getDiff() {
        return this.diff;
    }

    public SubBlock getLeft() {
        return this.left;
    }

    public MacroBlock getMacroBlock() {
        return this.macroBlock;
    }

    public int[][] getMacroBlockPredict(int n2) {
        if (this.dest != null) {
            return this.dest;
        }
        int n3 = 127;
        if (n2 == 2) {
            n3 = 129;
        }
        int[][] nArray = new int[4][4];
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                nArray[i3][i2] = n3;
            }
        }
        return nArray;
    }

    public int getMode() {
        return this.mode;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public int[][] getPredict() {
        if (this.predict != null) {
            return this.predict;
        }
        return this.getPredict(0, false);
    }

    public int[][] getPredict(int n2, boolean bl2) {
        if (this.dest != null) {
            return this.dest;
        }
        if (this.predict != null) {
            return this.predict;
        }
        int n3 = 127;
        if ((n2 == 1 || n2 == 0 || n2 == 2 || n2 == 3 || n2 == 6 || n2 == 5 || n2 == 8) && bl2) {
            n3 = 129;
        }
        int[][] nArray = new int[4][4];
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                nArray[i3][i2] = n3;
            }
        }
        return nArray;
    }

    int[] getTokens() {
        return this.tokens;
    }

    public boolean hasNoZeroToken() {
        return this.hasNoZeroToken;
    }

    public boolean isDest() {
        return this.dest != null;
    }

    public void predict(VP8Frame vP8Frame) {
        SubBlock subBlock = this;
        SubBlock subBlock2 = vP8Frame.getAboveSubBlock(subBlock, subBlock.getPlane());
        SubBlock subBlock3 = vP8Frame.getLeftSubBlock(subBlock, subBlock.getPlane());
        int[] nArray = new int[4];
        int[] nArray2 = new int[4];
        nArray[0] = subBlock2.getPredict(subBlock.getMode(), false)[0][3];
        nArray[1] = subBlock2.getPredict(subBlock.getMode(), false)[1][3];
        nArray[2] = subBlock2.getPredict(subBlock.getMode(), false)[2][3];
        nArray[3] = subBlock2.getPredict(subBlock.getMode(), false)[3][3];
        nArray2[0] = subBlock3.getPredict(subBlock.getMode(), true)[3][0];
        nArray2[1] = subBlock3.getPredict(subBlock.getMode(), true)[3][1];
        nArray2[2] = subBlock3.getPredict(subBlock.getMode(), true)[3][2];
        nArray2[3] = subBlock3.getPredict(subBlock.getMode(), true)[3][3];
        SubBlock subBlock4 = vP8Frame.getLeftSubBlock(subBlock2, subBlock.getPlane());
        int n2 = !subBlock3.isDest() && !subBlock2.isDest() ? subBlock4.getPredict(subBlock.getMode(), false)[3][3] : (!subBlock2.isDest() ? subBlock4.getPredict(subBlock.getMode(), false)[3][3] : subBlock4.getPredict(subBlock.getMode(), true)[3][3]);
        SubBlock subBlock5 = vP8Frame.getAboveRightSubBlock(subBlock, subBlock.plane);
        int[] nArray3 = new int[]{subBlock5.getPredict(subBlock.getMode(), false)[0][3], subBlock5.getPredict(subBlock.getMode(), false)[1][3], subBlock5.getPredict(subBlock.getMode(), false)[2][3], subBlock5.getPredict(subBlock.getMode(), false)[3][3]};
        int[][] nArray4 = new int[4][4];
        switch (subBlock.getMode()) {
            case 0: {
                int n3;
                int n4 = 0;
                for (n3 = 0; n3 < 4; ++n3) {
                    n4 += nArray[n3];
                    n4 += nArray2[n3];
                }
                n4 = n4 + 4 >> 3;
                for (n3 = 0; n3 < 4; ++n3) {
                    for (int i2 = 0; i2 < 4; ++i2) {
                        nArray4[i2][n3] = n4;
                    }
                }
                break;
            }
            case 1: {
                for (int i3 = 0; i3 < 4; ++i3) {
                    for (int i4 = 0; i4 < 4; ++i4) {
                        int n5 = nArray[i4] - n2 + nArray2[i3];
                        if (n5 < 0) {
                            n5 = 0;
                        }
                        if (n5 > 255) {
                            n5 = 255;
                        }
                        nArray4[i4][i3] = n5;
                    }
                }
                break;
            }
            case 2: {
                int[] nArray5 = new int[]{n2 + 2 * nArray[0] + nArray[1] + 2 >> 2, nArray[0] + 2 * nArray[1] + nArray[2] + 2 >> 2, nArray[1] + 2 * nArray[2] + nArray[3] + 2 >> 2, nArray[2] + 2 * nArray[3] + nArray3[0] + 2 >> 2};
                for (int i5 = 0; i5 < 4; ++i5) {
                    for (int i6 = 0; i6 < 4; ++i6) {
                        nArray4[i6][i5] = nArray5[i6];
                    }
                }
                break;
            }
            case 3: {
                int[] nArray6 = new int[]{n2 + 2 * nArray2[0] + nArray2[1] + 2 >> 2, nArray2[0] + 2 * nArray2[1] + nArray2[2] + 2 >> 2, nArray2[1] + 2 * nArray2[2] + nArray2[3] + 2 >> 2, nArray2[2] + 2 * nArray2[3] + nArray2[3] + 2 >> 2};
                for (int i7 = 0; i7 < 4; ++i7) {
                    for (int i8 = 0; i8 < 4; ++i8) {
                        nArray4[i8][i7] = nArray6[i7];
                    }
                }
                break;
            }
            case 4: {
                nArray4[0][0] = nArray[0] + nArray[1] * 2 + nArray[2] + 2 >> 2;
                int n6 = nArray[1] + nArray[2] * 2 + nArray[3] + 2 >> 2;
                nArray4[0][1] = n6;
                nArray4[1][0] = n6;
                int n7 = nArray[2] + nArray[3] * 2 + nArray3[0] + 2 >> 2;
                nArray4[0][2] = n7;
                nArray4[1][1] = n7;
                nArray4[2][0] = n7;
                int n8 = nArray[3] + nArray3[0] * 2 + nArray3[1] + 2 >> 2;
                nArray4[0][3] = n8;
                nArray4[1][2] = n8;
                nArray4[2][1] = n8;
                nArray4[3][0] = n8;
                int n9 = nArray3[0] + nArray3[1] * 2 + nArray3[2] + 2 >> 2;
                nArray4[1][3] = n9;
                nArray4[2][2] = n9;
                nArray4[3][1] = n9;
                int n10 = nArray3[1] + nArray3[2] * 2 + nArray3[3] + 2 >> 2;
                nArray4[2][3] = n10;
                nArray4[3][2] = n10;
                nArray4[3][3] = nArray3[2] + nArray3[3] * 2 + nArray3[3] + 2 >> 2;
                break;
            }
            case 5: {
                int[] nArray7 = new int[]{nArray2[3], nArray2[2], nArray2[1], nArray2[0], n2, nArray[0], nArray[1], nArray[2], nArray[3]};
                nArray4[0][3] = nArray7[0] + nArray7[1] * 2 + nArray7[2] + 2 >> 2;
                int n11 = nArray7[1] + nArray7[2] * 2 + nArray7[3] + 2 >> 2;
                nArray4[0][2] = n11;
                nArray4[1][3] = n11;
                int n12 = nArray7[2] + nArray7[3] * 2 + nArray7[4] + 2 >> 2;
                nArray4[0][1] = n12;
                nArray4[1][2] = n12;
                nArray4[2][3] = n12;
                int n13 = nArray7[3] + nArray7[4] * 2 + nArray7[5] + 2 >> 2;
                nArray4[0][0] = n13;
                nArray4[1][1] = n13;
                nArray4[2][2] = n13;
                nArray4[3][3] = n13;
                int n14 = nArray7[4] + nArray7[5] * 2 + nArray7[6] + 2 >> 2;
                nArray4[1][0] = n14;
                nArray4[2][1] = n14;
                nArray4[3][2] = n14;
                int n15 = nArray7[5] + nArray7[6] * 2 + nArray7[7] + 2 >> 2;
                nArray4[2][0] = n15;
                nArray4[3][1] = n15;
                nArray4[3][0] = nArray7[6] + nArray7[7] * 2 + nArray7[8] + 2 >> 2;
                break;
            }
            case 6: {
                int[] nArray8 = new int[]{nArray2[3], nArray2[2], nArray2[1], nArray2[0], n2, nArray[0], nArray[1], nArray[2], nArray[3]};
                nArray4[0][3] = nArray8[1] + nArray8[2] * 2 + nArray8[3] + 2 >> 2;
                nArray4[0][2] = nArray8[2] + nArray8[3] * 2 + nArray8[4] + 2 >> 2;
                int n16 = nArray8[3] + nArray8[4] * 2 + nArray8[5] + 2 >> 2;
                nArray4[0][1] = n16;
                nArray4[1][3] = n16;
                int n17 = nArray8[4] + nArray8[5] + 1 >> 1;
                nArray4[0][0] = n17;
                nArray4[1][2] = n17;
                int n18 = nArray8[4] + nArray8[5] * 2 + nArray8[6] + 2 >> 2;
                nArray4[1][1] = n18;
                nArray4[2][3] = n18;
                int n19 = nArray8[5] + nArray8[6] + 1 >> 1;
                nArray4[1][0] = n19;
                nArray4[2][2] = n19;
                int n20 = nArray8[5] + nArray8[6] * 2 + nArray8[7] + 2 >> 2;
                nArray4[2][1] = n20;
                nArray4[3][3] = n20;
                int n21 = nArray8[6] + nArray8[7] + 1 >> 1;
                nArray4[2][0] = n21;
                nArray4[3][2] = n21;
                nArray4[3][1] = nArray8[6] + nArray8[7] * 2 + nArray8[8] + 2 >> 2;
                nArray4[3][0] = nArray8[7] + nArray8[8] + 1 >> 1;
                break;
            }
            case 7: {
                nArray4[0][0] = nArray[0] + nArray[1] + 1 >> 1;
                nArray4[0][1] = nArray[0] + nArray[1] * 2 + nArray[2] + 2 >> 2;
                int n22 = nArray[1] + nArray[2] + 1 >> 1;
                nArray4[1][0] = n22;
                nArray4[0][2] = n22;
                int n23 = nArray[1] + nArray[2] * 2 + nArray[3] + 2 >> 2;
                nArray4[0][3] = n23;
                nArray4[1][1] = n23;
                int n24 = nArray[2] + nArray[3] + 1 >> 1;
                nArray4[2][0] = n24;
                nArray4[1][2] = n24;
                int n25 = nArray[2] + nArray[3] * 2 + nArray3[0] + 2 >> 2;
                nArray4[2][1] = n25;
                nArray4[1][3] = n25;
                int n26 = nArray[3] + nArray3[0] + 1 >> 1;
                nArray4[2][2] = n26;
                nArray4[3][0] = n26;
                int n27 = nArray[3] + nArray3[0] * 2 + nArray3[1] + 2 >> 2;
                nArray4[2][3] = n27;
                nArray4[3][1] = n27;
                nArray4[3][2] = nArray3[0] + nArray3[1] * 2 + nArray3[2] + 2 >> 2;
                nArray4[3][3] = nArray3[1] + nArray3[2] * 2 + nArray3[3] + 2 >> 2;
                break;
            }
            case 8: {
                int[] nArray9 = new int[]{nArray2[3], nArray2[2], nArray2[1], nArray2[0], n2, nArray[0], nArray[1], nArray[2], nArray[3]};
                nArray4[0][3] = nArray9[0] + nArray9[1] + 1 >> 1;
                nArray4[1][3] = nArray9[0] + nArray9[1] * 2 + nArray9[2] + 2 >> 2;
                int n28 = nArray9[1] + nArray9[2] + 1 >> 1;
                nArray4[2][3] = n28;
                nArray4[0][2] = n28;
                int n29 = nArray9[1] + nArray9[2] * 2 + nArray9[3] + 2 >> 2;
                nArray4[3][3] = n29;
                nArray4[1][2] = n29;
                int n30 = nArray9[2] + nArray9[3] + 1 >> 1;
                nArray4[0][1] = n30;
                nArray4[2][2] = n30;
                int n31 = nArray9[2] + nArray9[3] * 2 + nArray9[4] + 2 >> 2;
                nArray4[1][1] = n31;
                nArray4[3][2] = n31;
                int n32 = nArray9[3] + nArray9[4] + 1 >> 1;
                nArray4[0][0] = n32;
                nArray4[2][1] = n32;
                int n33 = nArray9[3] + nArray9[4] * 2 + nArray9[5] + 2 >> 2;
                nArray4[1][0] = n33;
                nArray4[3][1] = n33;
                nArray4[2][0] = nArray9[4] + nArray9[5] * 2 + nArray9[6] + 2 >> 2;
                nArray4[3][0] = nArray9[5] + nArray9[6] * 2 + nArray9[7] + 2 >> 2;
                break;
            }
            case 9: {
                nArray4[0][0] = nArray2[0] + nArray2[1] + 1 >> 1;
                nArray4[1][0] = nArray2[0] + nArray2[1] * 2 + nArray2[2] + 2 >> 2;
                int n34 = nArray2[1] + nArray2[2] + 1 >> 1;
                nArray4[0][1] = n34;
                nArray4[2][0] = n34;
                int n35 = nArray2[1] + nArray2[2] * 2 + nArray2[3] + 2 >> 2;
                nArray4[1][1] = n35;
                nArray4[3][0] = n35;
                int n36 = nArray2[2] + nArray2[3] + 1 >> 1;
                nArray4[0][2] = n36;
                nArray4[2][1] = n36;
                int n37 = nArray2[2] + nArray2[3] * 2 + nArray2[3] + 2 >> 2;
                nArray4[1][2] = n37;
                nArray4[3][1] = n37;
                int n38 = nArray2[3];
                nArray4[3][3] = n38;
                nArray4[2][3] = n38;
                nArray4[1][3] = n38;
                nArray4[0][3] = n38;
                nArray4[3][2] = n38;
                nArray4[2][2] = n38;
                break;
            }
            default: {
                throw new AssertionError((Object)("TODO mode: " + subBlock.getMode()));
            }
        }
        subBlock.setPredict(nArray4);
    }

    public void reconstruct() {
        SubBlock subBlock = this;
        int[][] nArray = subBlock.getPredict(1, false);
        int[][] nArray2 = new int[4][4];
        int[][] nArray3 = subBlock.getDiff();
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                int n2 = nArray3[i2][i3] + nArray[i2][i3];
                if (n2 < 0) {
                    n2 = 0;
                }
                if (n2 > 255) {
                    n2 = 255;
                }
                nArray2[i2][i3] = n2;
            }
        }
        subBlock.setDest(nArray2);
        if (!this.getMacroBlock().isKeepDebugInfo()) {
            subBlock.diff = null;
            subBlock.predict = null;
            subBlock.tokens = null;
        }
    }

    public void setDest(int[][] nArray) {
        this.dest = nArray;
    }

    public void setDiff(int[][] nArray) {
        this.diff = nArray;
    }

    public void setMode(int n2) {
        this.mode = n2;
    }

    public void setPixel(int n2, int n3, int n4) {
        if (this.dest == null) {
            this.dest = new int[4][4];
        }
        this.dest[n2][n3] = n4;
    }

    public void setPredict(int[][] nArray) {
        this.predict = nArray;
    }

    public String toString() {
        String string = "[";
        for (int i2 = 0; i2 < 16; ++i2) {
            string = string + this.tokens[i2] + " ";
        }
        string = string + "]";
        return string;
    }

    public static enum Plane {
        U,
        V,
        Y1,
        Y2;

    }
}


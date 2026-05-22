/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.plugins.webp.vp8.Globals;
import com.twelvemonkeys.imageio.plugins.webp.vp8.IDCT;
import com.twelvemonkeys.imageio.plugins.webp.vp8.SubBlock;
import com.twelvemonkeys.imageio.plugins.webp.vp8.VP8Frame;
import java.io.IOException;

final class MacroBlock {
    private int filterLevel;
    private final boolean keepDebugInfo;
    private int segmentId;
    private int skipCoeff;
    private boolean skipInnerLoopFilter;
    final SubBlock[][] uSubBlocks;
    private int uVFilterLevel;
    private int uvMode;
    final SubBlock[][] vSubBlocks;
    private final int x;
    private final int y;
    final SubBlock y2SubBlock;
    private int yMode;
    final SubBlock[][] ySubBlocks;

    MacroBlock(int n2, int n3, boolean bl2) {
        SubBlock subBlock;
        SubBlock subBlock2;
        int n4;
        int n5;
        this.x = n2 - 1;
        this.y = n3 - 1;
        this.keepDebugInfo = bl2;
        this.ySubBlocks = new SubBlock[4][4];
        this.uSubBlocks = new SubBlock[2][2];
        this.vSubBlocks = new SubBlock[2][2];
        for (n5 = 0; n5 < 4; ++n5) {
            for (n4 = 0; n4 < 4; ++n4) {
                subBlock2 = null;
                subBlock = null;
                if (n4 > 0) {
                    subBlock2 = this.ySubBlocks[n4 - 1][n5];
                }
                if (n5 > 0) {
                    subBlock = this.ySubBlocks[n4][n5 - 1];
                }
                this.ySubBlocks[n4][n5] = new SubBlock(this, subBlock, subBlock2, SubBlock.Plane.Y1);
            }
        }
        for (n5 = 0; n5 < 2; ++n5) {
            for (n4 = 0; n4 < 2; ++n4) {
                subBlock2 = null;
                subBlock = null;
                if (n4 > 0) {
                    subBlock2 = this.uSubBlocks[n4 - 1][n5];
                }
                if (n5 > 0) {
                    subBlock = this.uSubBlocks[n4][n5 - 1];
                }
                this.uSubBlocks[n4][n5] = new SubBlock(this, subBlock, subBlock2, SubBlock.Plane.U);
            }
        }
        for (n5 = 0; n5 < 2; ++n5) {
            for (n4 = 0; n4 < 2; ++n4) {
                subBlock2 = null;
                subBlock = null;
                if (n4 > 0) {
                    subBlock2 = this.vSubBlocks[n4 - 1][n5];
                }
                if (n5 > 0) {
                    subBlock = this.vSubBlocks[n4][n5 - 1];
                }
                this.vSubBlocks[n4][n5] = new SubBlock(this, subBlock, subBlock2, SubBlock.Plane.V);
            }
        }
        this.y2SubBlock = new SubBlock(this, null, null, SubBlock.Plane.Y2);
    }

    public void decodeMacroBlock(VP8Frame vP8Frame) throws IOException {
        MacroBlock macroBlock = this;
        if (macroBlock.getSkipCoeff() > 0) {
            if (macroBlock.getYMode() != 4) {
                macroBlock.skipInnerLoopFilter = true;
            }
        } else {
            this.decodeMacroBlockTokens(vP8Frame, macroBlock.getYMode() != 4);
        }
    }

    private void decodeMacroBlockTokens(VP8Frame vP8Frame, boolean bl2) throws IOException {
        if (bl2) {
            this.skipInnerLoopFilter = this.decodePlaneTokens(vP8Frame, 1, SubBlock.Plane.Y2, false);
        }
        this.skipInnerLoopFilter |= this.decodePlaneTokens(vP8Frame, 4, SubBlock.Plane.Y1, bl2);
        this.skipInnerLoopFilter |= this.decodePlaneTokens(vP8Frame, 2, SubBlock.Plane.U, false);
        this.skipInnerLoopFilter |= this.decodePlaneTokens(vP8Frame, 2, SubBlock.Plane.V, false);
        this.skipInnerLoopFilter = !this.skipInnerLoopFilter;
    }

    private boolean decodePlaneTokens(VP8Frame vP8Frame, int n2, SubBlock.Plane plane, boolean bl2) throws IOException {
        MacroBlock macroBlock = this;
        boolean bl3 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                SubBlock subBlock = macroBlock.getSubBlock(plane, i3, i2);
                SubBlock subBlock2 = vP8Frame.getLeftSubBlock(subBlock, plane);
                SubBlock subBlock3 = vP8Frame.getAboveSubBlock(subBlock, plane);
                if (subBlock2.hasNoZeroToken()) {
                    n3 = 1;
                }
                n5 += n3;
                if (subBlock3.hasNoZeroToken()) {
                    n4 = 1;
                }
                subBlock.decodeSubBlock(vP8Frame.getTokenBoolDecoder(), vP8Frame.getCoefProbs(), n5 += n4, SubBlock.planeToType(plane, bl2), bl2);
                bl3 |= subBlock.hasNoZeroToken();
            }
        }
        return bl3;
    }

    public void dequantMacroBlock(VP8Frame vP8Frame) {
        MacroBlock macroBlock = this;
        if (macroBlock.getYMode() != 4) {
            SubBlock subBlock;
            int n2;
            int n3;
            SubBlock subBlock2 = macroBlock.getY2SubBlock();
            int n4 = vP8Frame.getSegmentQuants().getSegQuants()[this.getSegmentId()].getY2ac_delta_q();
            int n5 = vP8Frame.getSegmentQuants().getSegQuants()[this.getSegmentId()].getY2dc();
            int[] nArray = new int[16];
            nArray[0] = subBlock2.getTokens()[0] * n5;
            for (n3 = 1; n3 < 16; ++n3) {
                nArray[n3] = subBlock2.getTokens()[n3] * n4;
            }
            subBlock2.setDiff(IDCT.iwalsh4x4(nArray));
            for (n3 = 0; n3 < 4; ++n3) {
                for (n2 = 0; n2 < 4; ++n2) {
                    subBlock = macroBlock.getYSubBlock(n2, n3);
                    subBlock.dequantSubBlock(vP8Frame, subBlock2.getDiff()[n2][n3]);
                }
            }
            macroBlock.predictY(vP8Frame);
            macroBlock.predictUV(vP8Frame);
            for (n3 = 0; n3 < 2; ++n3) {
                for (n2 = 0; n2 < 2; ++n2) {
                    subBlock = macroBlock.getUSubBlock(n2, n3);
                    subBlock.dequantSubBlock(vP8Frame, null);
                    subBlock = macroBlock.getVSubBlock(n3, n2);
                    subBlock.dequantSubBlock(vP8Frame, null);
                }
            }
            macroBlock.recon_mb();
        } else {
            SubBlock subBlock;
            int n6;
            int n7;
            for (n7 = 0; n7 < 4; ++n7) {
                for (n6 = 0; n6 < 4; ++n6) {
                    subBlock = macroBlock.getYSubBlock(n6, n7);
                    subBlock.dequantSubBlock(vP8Frame, null);
                    subBlock.predict(vP8Frame);
                    subBlock.reconstruct();
                }
            }
            macroBlock.predictUV(vP8Frame);
            for (n7 = 0; n7 < 2; ++n7) {
                for (n6 = 0; n6 < 2; ++n6) {
                    subBlock = macroBlock.getUSubBlock(n6, n7);
                    subBlock.dequantSubBlock(vP8Frame, null);
                    subBlock.reconstruct();
                }
            }
            for (n7 = 0; n7 < 2; ++n7) {
                for (n6 = 0; n6 < 2; ++n6) {
                    subBlock = macroBlock.getVSubBlock(n6, n7);
                    subBlock.dequantSubBlock(vP8Frame, null);
                    subBlock.reconstruct();
                }
            }
        }
    }

    public void drawDebug() {
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int i3 = 0; i3 < 4; ++i3) {
                SubBlock subBlock = this.ySubBlocks[i3][0];
                subBlock.drawDebugH();
                subBlock = this.ySubBlocks[0][i2];
                subBlock.drawDebugV();
            }
        }
    }

    public String getDebugString() {
        String string = " YMode: " + Globals.getModeAsString(this.yMode);
        string = string + "\n UVMode: " + Globals.getModeAsString(this.uvMode);
        string = string + "\n SegmentID: " + this.segmentId;
        string = string + "\n Filter Level: " + this.filterLevel;
        string = string + "\n UV Filter Level: " + this.uVFilterLevel;
        string = string + "\n Skip Coeff: " + this.skipCoeff;
        return string;
    }

    public int getFilterLevel() {
        return this.filterLevel;
    }

    public SubBlock getBottomSubBlock(int n2, SubBlock.Plane plane) {
        switch (plane) {
            case Y1: {
                return this.ySubBlocks[n2][3];
            }
            case U: {
                return this.uSubBlocks[n2][1];
            }
            case V: {
                return this.vSubBlocks[n2][1];
            }
            case Y2: {
                return this.y2SubBlock;
            }
        }
        throw new IllegalArgumentException("Bad plane: " + (Object)((Object)plane));
    }

    public SubBlock getLeftSubBlock(int n2, SubBlock.Plane plane) {
        switch (plane) {
            case Y1: {
                return this.ySubBlocks[0][n2];
            }
            case U: {
                return this.uSubBlocks[0][n2];
            }
            case V: {
                return this.vSubBlocks[0][n2];
            }
            case Y2: {
                return this.y2SubBlock;
            }
        }
        throw new IllegalArgumentException("Bad plane: " + (Object)((Object)plane));
    }

    public SubBlock getRightSubBlock(int n2, SubBlock.Plane plane) {
        switch (plane) {
            case Y1: {
                return this.ySubBlocks[3][n2];
            }
            case U: {
                return this.uSubBlocks[1][n2];
            }
            case V: {
                return this.vSubBlocks[1][n2];
            }
            case Y2: {
                return this.y2SubBlock;
            }
        }
        throw new IllegalArgumentException("Bad plane: " + (Object)((Object)plane));
    }

    public int getSkipCoeff() {
        return this.skipCoeff;
    }

    public SubBlock getSubBlock(SubBlock.Plane plane, int n2, int n3) {
        switch (plane) {
            case Y1: {
                return this.getYSubBlock(n2, n3);
            }
            case U: {
                return this.getUSubBlock(n2, n3);
            }
            case V: {
                return this.getVSubBlock(n2, n3);
            }
            case Y2: {
                return this.getY2SubBlock();
            }
        }
        throw new IllegalArgumentException("Bad plane: " + (Object)((Object)plane));
    }

    public int getSubblockX(SubBlock subBlock) {
        if (subBlock.getPlane() == SubBlock.Plane.Y1) {
            for (int i2 = 0; i2 < 4; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    if (this.ySubBlocks[i3][i2] != subBlock) continue;
                    return i3;
                }
            }
        } else if (subBlock.getPlane() == SubBlock.Plane.U) {
            for (int i4 = 0; i4 < 2; ++i4) {
                for (int i5 = 0; i5 < 2; ++i5) {
                    if (this.uSubBlocks[i5][i4] != subBlock) continue;
                    return i5;
                }
            }
        } else if (subBlock.getPlane() == SubBlock.Plane.V) {
            for (int i6 = 0; i6 < 2; ++i6) {
                for (int i7 = 0; i7 < 2; ++i7) {
                    if (this.vSubBlocks[i7][i6] != subBlock) continue;
                    return i7;
                }
            }
        } else if (subBlock.getPlane() == SubBlock.Plane.Y2) {
            return 0;
        }
        return -100;
    }

    public int getSubblockY(SubBlock subBlock) {
        if (subBlock.getPlane() == SubBlock.Plane.Y1) {
            for (int i2 = 0; i2 < 4; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    if (this.ySubBlocks[i3][i2] != subBlock) continue;
                    return i2;
                }
            }
        } else if (subBlock.getPlane() == SubBlock.Plane.U) {
            for (int i4 = 0; i4 < 2; ++i4) {
                for (int i5 = 0; i5 < 2; ++i5) {
                    if (this.uSubBlocks[i5][i4] != subBlock) continue;
                    return i4;
                }
            }
        } else if (subBlock.getPlane() == SubBlock.Plane.V) {
            for (int i6 = 0; i6 < 2; ++i6) {
                for (int i7 = 0; i7 < 2; ++i7) {
                    if (this.vSubBlocks[i7][i6] != subBlock) continue;
                    return i6;
                }
            }
        } else if (subBlock.getPlane() == SubBlock.Plane.Y2) {
            return 0;
        }
        return -100;
    }

    public SubBlock getUSubBlock(int n2, int n3) {
        return this.uSubBlocks[n2][n3];
    }

    public int getUVFilterLevel() {
        return this.uVFilterLevel;
    }

    public int getUvMode() {
        return this.uvMode;
    }

    public SubBlock getVSubBlock(int n2, int n3) {
        return this.vSubBlocks[n2][n3];
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public SubBlock getY2SubBlock() {
        return this.y2SubBlock;
    }

    public int getYMode() {
        return this.yMode;
    }

    public SubBlock getYSubBlock(int n2, int n3) {
        return this.ySubBlocks[n2][n3];
    }

    public boolean isKeepDebugInfo() {
        return this.keepDebugInfo;
    }

    public boolean isSkip_inner_lf() {
        return this.skipInnerLoopFilter;
    }

    public void predictUV(VP8Frame vP8Frame) {
        MacroBlock macroBlock = vP8Frame.getMacroBlock(this.x, this.y - 1);
        MacroBlock macroBlock2 = vP8Frame.getMacroBlock(this.x - 1, this.y);
        switch (this.uvMode) {
            case 0: {
                int n2;
                int n3;
                int n4;
                int n5;
                boolean bl2 = false;
                boolean bl3 = false;
                int n6 = 0;
                int n7 = 0;
                if (this.x > 0) {
                    bl3 = true;
                }
                if (this.y > 0) {
                    bl2 = true;
                }
                if (bl2 || bl3) {
                    SubBlock subBlock;
                    SubBlock subBlock2;
                    int n8;
                    if (bl2) {
                        for (n8 = 0; n8 < 2; ++n8) {
                            subBlock2 = macroBlock.getUSubBlock(n8, 1);
                            subBlock = macroBlock.getVSubBlock(n8, 1);
                            for (n5 = 0; n5 < 4; ++n5) {
                                n6 += subBlock2.getDest()[n5][3];
                                n7 += subBlock.getDest()[n5][3];
                            }
                        }
                    }
                    if (bl3) {
                        for (n8 = 0; n8 < 2; ++n8) {
                            subBlock2 = macroBlock2.getUSubBlock(1, n8);
                            subBlock = macroBlock2.getVSubBlock(1, n8);
                            for (n5 = 0; n5 < 4; ++n5) {
                                n6 += subBlock2.getDest()[3][n5];
                                n7 += subBlock.getDest()[3][n5];
                            }
                        }
                    }
                    n8 = 2;
                    if (bl2) {
                        ++n8;
                    }
                    if (bl3) {
                        ++n8;
                    }
                    n4 = n6 + (1 << n8 - 1) >> n8;
                    n3 = n7 + (1 << n8 - 1) >> n8;
                } else {
                    n4 = 128;
                    n3 = 128;
                }
                int[][] nArray = new int[4][4];
                for (int i2 = 0; i2 < 4; ++i2) {
                    for (int i3 = 0; i3 < 4; ++i3) {
                        nArray[i3][i2] = n4;
                    }
                }
                int[][] nArray2 = new int[4][4];
                for (n2 = 0; n2 < 4; ++n2) {
                    for (n5 = 0; n5 < 4; ++n5) {
                        nArray2[n5][n2] = n3;
                    }
                }
                for (n2 = 0; n2 < 2; ++n2) {
                    for (n5 = 0; n5 < 2; ++n5) {
                        SubBlock subBlock = this.uSubBlocks[n5][n2];
                        SubBlock subBlock3 = this.vSubBlocks[n5][n2];
                        subBlock.setPredict(nArray);
                        subBlock3.setPredict(nArray2);
                    }
                }
                break;
            }
            case 1: {
                int n9;
                SubBlock[] subBlockArray = new SubBlock[2];
                SubBlock[] subBlockArray2 = new SubBlock[2];
                for (n9 = 0; n9 < 2; ++n9) {
                    subBlockArray[n9] = macroBlock.getUSubBlock(n9, 1);
                    subBlockArray2[n9] = macroBlock.getVSubBlock(n9, 1);
                }
                for (n9 = 0; n9 < 2; ++n9) {
                    for (int i4 = 0; i4 < 2; ++i4) {
                        SubBlock subBlock = this.uSubBlocks[n9][i4];
                        SubBlock subBlock4 = this.vSubBlocks[n9][i4];
                        int[][] nArray = new int[4][4];
                        int[][] nArray3 = new int[4][4];
                        for (int i5 = 0; i5 < 4; ++i5) {
                            for (int i6 = 0; i6 < 4; ++i6) {
                                nArray[i5][i6] = subBlockArray[n9].getMacroBlockPredict(1)[i5][3];
                                nArray3[i5][i6] = subBlockArray2[n9].getMacroBlockPredict(1)[i5][3];
                            }
                        }
                        subBlock.setPredict(nArray);
                        subBlock4.setPredict(nArray3);
                    }
                }
                break;
            }
            case 2: {
                int n10;
                SubBlock[] subBlockArray = new SubBlock[2];
                SubBlock[] subBlockArray3 = new SubBlock[2];
                for (n10 = 0; n10 < 2; ++n10) {
                    subBlockArray[n10] = macroBlock2.getUSubBlock(1, n10);
                    subBlockArray3[n10] = macroBlock2.getVSubBlock(1, n10);
                }
                for (n10 = 0; n10 < 2; ++n10) {
                    for (int i7 = 0; i7 < 2; ++i7) {
                        SubBlock subBlock = this.uSubBlocks[i7][n10];
                        SubBlock subBlock5 = this.vSubBlocks[i7][n10];
                        int[][] nArray = new int[4][4];
                        int[][] nArray4 = new int[4][4];
                        for (int i8 = 0; i8 < 4; ++i8) {
                            for (int i9 = 0; i9 < 4; ++i9) {
                                nArray[i9][i8] = subBlockArray[n10].getMacroBlockPredict(2)[3][i8];
                                nArray4[i9][i8] = subBlockArray3[n10].getMacroBlockPredict(2)[3][i8];
                            }
                        }
                        subBlock.setPredict(nArray);
                        subBlock5.setPredict(nArray4);
                    }
                }
                break;
            }
            case 3: {
                int n11;
                MacroBlock macroBlock3 = vP8Frame.getMacroBlock(this.x - 1, this.y - 1);
                SubBlock subBlock = macroBlock3.getUSubBlock(1, 1);
                int n12 = subBlock.getDest()[3][3];
                SubBlock subBlock6 = macroBlock3.getVSubBlock(1, 1);
                int n13 = subBlock6.getDest()[3][3];
                SubBlock[] subBlockArray = new SubBlock[2];
                SubBlock[] subBlockArray4 = new SubBlock[2];
                SubBlock[] subBlockArray5 = new SubBlock[2];
                SubBlock[] subBlockArray6 = new SubBlock[2];
                for (n11 = 0; n11 < 2; ++n11) {
                    subBlockArray[n11] = macroBlock.getUSubBlock(n11, 1);
                    subBlockArray4[n11] = macroBlock2.getUSubBlock(1, n11);
                    subBlockArray5[n11] = macroBlock.getVSubBlock(n11, 1);
                    subBlockArray6[n11] = macroBlock2.getVSubBlock(1, n11);
                }
                for (n11 = 0; n11 < 2; ++n11) {
                    for (int i10 = 0; i10 < 4; ++i10) {
                        for (int i11 = 0; i11 < 2; ++i11) {
                            for (int i12 = 0; i12 < 4; ++i12) {
                                int n14 = subBlockArray4[n11].getDest()[3][i10] + subBlockArray[i11].getDest()[i12][3] - n12;
                                n14 = Globals.clamp(n14, 255);
                                this.uSubBlocks[i11][n11].setPixel(i12, i10, n14);
                                int n15 = subBlockArray6[n11].getDest()[3][i10] + subBlockArray5[i11].getDest()[i12][3] - n13;
                                n15 = Globals.clamp(n15, 255);
                                this.vSubBlocks[i11][n11].setPixel(i12, i10, n15);
                            }
                        }
                    }
                }
                break;
            }
            default: {
                throw new AssertionError((Object)("TODO predict_mb_uv: " + this.yMode));
            }
        }
    }

    public void predictY(VP8Frame vP8Frame) {
        MacroBlock macroBlock = vP8Frame.getMacroBlock(this.x, this.y - 1);
        MacroBlock macroBlock2 = vP8Frame.getMacroBlock(this.x - 1, this.y);
        switch (this.yMode) {
            case 0: {
                int n2;
                int n3;
                int n4;
                boolean bl2 = false;
                boolean bl3 = false;
                int n5 = 0;
                if (this.x > 0) {
                    bl3 = true;
                }
                if (this.y > 0) {
                    bl2 = true;
                }
                if (bl2 || bl3) {
                    SubBlock subBlock;
                    int n6;
                    if (bl2) {
                        for (n6 = 0; n6 < 4; ++n6) {
                            subBlock = macroBlock.getYSubBlock(n6, 3);
                            for (n4 = 0; n4 < 4; ++n4) {
                                n5 += subBlock.getDest()[n4][3];
                            }
                        }
                    }
                    if (bl3) {
                        for (n6 = 0; n6 < 4; ++n6) {
                            subBlock = macroBlock2.getYSubBlock(3, n6);
                            for (n4 = 0; n4 < 4; ++n4) {
                                n5 += subBlock.getDest()[3][n4];
                            }
                        }
                    }
                    n6 = 3;
                    if (bl2) {
                        ++n6;
                    }
                    if (bl3) {
                        ++n6;
                    }
                    n3 = n5 + (1 << n6 - 1) >> n6;
                } else {
                    n3 = 128;
                }
                int[][] nArray = new int[4][4];
                for (n2 = 0; n2 < 4; ++n2) {
                    for (n4 = 0; n4 < 4; ++n4) {
                        nArray[n4][n2] = n3;
                    }
                }
                for (n2 = 0; n2 < 4; ++n2) {
                    for (n4 = 0; n4 < 4; ++n4) {
                        SubBlock subBlock = this.ySubBlocks[n4][n2];
                        subBlock.setPredict(nArray);
                    }
                }
                break;
            }
            case 1: {
                int n7;
                SubBlock[] subBlockArray = new SubBlock[4];
                for (n7 = 0; n7 < 4; ++n7) {
                    subBlockArray[n7] = macroBlock.getYSubBlock(n7, 3);
                }
                for (n7 = 0; n7 < 4; ++n7) {
                    for (int i2 = 0; i2 < 4; ++i2) {
                        SubBlock subBlock = this.ySubBlocks[i2][n7];
                        int[][] nArray = new int[4][4];
                        for (int i3 = 0; i3 < 4; ++i3) {
                            for (int i4 = 0; i4 < 4; ++i4) {
                                nArray[i4][i3] = subBlockArray[i2].getPredict(2, false)[i4][3];
                            }
                        }
                        subBlock.setPredict(nArray);
                    }
                }
                break;
            }
            case 2: {
                int n8;
                SubBlock[] subBlockArray = new SubBlock[4];
                for (n8 = 0; n8 < 4; ++n8) {
                    subBlockArray[n8] = macroBlock2.getYSubBlock(3, n8);
                }
                for (n8 = 0; n8 < 4; ++n8) {
                    for (int i5 = 0; i5 < 4; ++i5) {
                        SubBlock subBlock = this.ySubBlocks[i5][n8];
                        int[][] nArray = new int[4][4];
                        for (int i6 = 0; i6 < 4; ++i6) {
                            for (int i7 = 0; i7 < 4; ++i7) {
                                nArray[i7][i6] = subBlockArray[n8].getPredict(0, true)[3][i6];
                            }
                        }
                        subBlock.setPredict(nArray);
                    }
                }
                break;
            }
            case 3: {
                int n9;
                MacroBlock macroBlock3 = vP8Frame.getMacroBlock(this.x - 1, this.y - 1);
                SubBlock subBlock = macroBlock3.getYSubBlock(3, 3);
                int n10 = subBlock.getDest()[3][3];
                SubBlock[] subBlockArray = new SubBlock[4];
                SubBlock[] subBlockArray2 = new SubBlock[4];
                for (n9 = 0; n9 < 4; ++n9) {
                    subBlockArray[n9] = macroBlock.getYSubBlock(n9, 3);
                }
                for (n9 = 0; n9 < 4; ++n9) {
                    subBlockArray2[n9] = macroBlock2.getYSubBlock(3, n9);
                }
                for (n9 = 0; n9 < 4; ++n9) {
                    for (int i8 = 0; i8 < 4; ++i8) {
                        for (int i9 = 0; i9 < 4; ++i9) {
                            for (int i10 = 0; i10 < 4; ++i10) {
                                int n11 = subBlockArray2[n9].getDest()[3][i8] + subBlockArray[i9].getDest()[i10][3] - n10;
                                this.ySubBlocks[i9][n9].setPixel(i10, i8, Globals.clamp(n11, 255));
                            }
                        }
                    }
                }
                break;
            }
            default: {
                System.out.println("TODO predict_mb_y: " + this.yMode);
                System.exit(0);
            }
        }
    }

    public void recon_mb() {
        SubBlock subBlock;
        int n2;
        int n3;
        for (n3 = 0; n3 < 4; ++n3) {
            for (n2 = 0; n2 < 4; ++n2) {
                subBlock = this.ySubBlocks[n2][n3];
                subBlock.reconstruct();
            }
        }
        for (n3 = 0; n3 < 2; ++n3) {
            for (n2 = 0; n2 < 2; ++n2) {
                subBlock = this.uSubBlocks[n2][n3];
                subBlock.reconstruct();
            }
        }
        for (n3 = 0; n3 < 2; ++n3) {
            for (n2 = 0; n2 < 2; ++n2) {
                subBlock = this.vSubBlocks[n2][n3];
                subBlock.reconstruct();
            }
        }
    }

    public void setFilterLevel(int n2) {
        this.filterLevel = n2;
    }

    public void setSegmentId(int n2) {
        this.segmentId = n2;
    }

    public void setSkipCoeff(int n2) {
        this.skipCoeff = n2;
    }

    public void setUVFilterLevel(int n2) {
        this.uVFilterLevel = n2;
    }

    public void setUvMode(int n2) {
        this.uvMode = n2;
    }

    public void setYMode(int n2) {
        this.yMode = n2;
    }

    public String toString() {
        return "x: " + this.x + "y: " + this.y;
    }

    public int getSegmentId() {
        return this.segmentId;
    }
}


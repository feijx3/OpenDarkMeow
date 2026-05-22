/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.color.YCbCrConverter;
import com.twelvemonkeys.imageio.plugins.webp.vp8.BoolDecoder;
import com.twelvemonkeys.imageio.plugins.webp.vp8.Globals;
import com.twelvemonkeys.imageio.plugins.webp.vp8.LoopFilter;
import com.twelvemonkeys.imageio.plugins.webp.vp8.MacroBlock;
import com.twelvemonkeys.imageio.plugins.webp.vp8.SegmentQuants;
import com.twelvemonkeys.imageio.plugins.webp.vp8.SubBlock;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.IIOException;
import javax.imageio.ImageReadParam;
import javax.imageio.event.IIOReadProgressListener;
import javax.imageio.stream.ImageInputStream;

public final class VP8Frame {
    private static final int BLOCK_TYPES = 4;
    private static final int COEF_BANDS = 8;
    private static final int MAX_ENTROPY_TOKENS = 12;
    private static final int MAX_MODE_LF_DELTAS = 4;
    private static final int MAX_REF_LF_DELTAS = 4;
    private static final int PREV_COEF_CONTEXTS = 3;
    private IIOReadProgressListener listener = null;
    private final int[][][][] coefProbs;
    private int filterLevel;
    private final ImageInputStream frame;
    private final boolean debug;
    private int frameType;
    private int height;
    private int macroBlockCols;
    private int macroBlockNoCoeffSkip;
    private int macroBlockRows;
    private MacroBlock[][] macroBlocks;
    private int macroBlockSegementAbsoluteDelta;
    private int[] macroBlockSegmentTreeProbs;
    private final int[] modeLoopFilterDeltas = new int[4];
    private int modeRefLoopFilterDeltaEnabled;
    private int modeRefLoopFilterDeltaUpdate;
    private int multiTokenPartition = 0;
    private long offset;
    private final int[] refLoopFilterDeltas = new int[4];
    private int refreshEntropyProbs;
    private int refreshLastFrame;
    private int segmentationIsEnabled;
    private SegmentQuants segmentQuants;
    private int sharpnessLevel;
    private boolean simpleFilter;
    private BoolDecoder tokenBoolDecoder;
    private final List<BoolDecoder> tokenBoolDecoders;
    private int updateMacroBlockSegmentationMap;
    private int updateMacroBlockSegmentatonData;
    private int width;
    private final byte[] yuv = new byte[3];
    private final byte[] rgb = new byte[4];

    public VP8Frame(ImageInputStream imageInputStream, boolean bl2) throws IOException {
        this.frame = imageInputStream;
        this.debug = bl2;
        this.offset = this.frame.getStreamPosition();
        this.coefProbs = Globals.getDefaultCoefProbs();
        this.tokenBoolDecoders = new ArrayList<BoolDecoder>();
    }

    public void setProgressListener(IIOReadProgressListener iIOReadProgressListener) {
        this.listener = iIOReadProgressListener;
    }

    private void createMacroBlocks() {
        this.macroBlocks = new MacroBlock[this.macroBlockRows + 2][this.macroBlockCols + 2];
        for (int i2 = 0; i2 < this.macroBlockRows + 2; ++i2) {
            for (int i3 = 0; i3 < this.macroBlockCols + 2; ++i3) {
                this.macroBlocks[i2][i3] = new MacroBlock(i3, i2, this.debug);
            }
        }
    }

    public boolean decode(WritableRaster writableRaster, ImageReadParam imageReadParam) throws IOException {
        int n2;
        int n3;
        int n4;
        int n5;
        this.segmentQuants = new SegmentQuants();
        int n6 = this.frame.readUnsignedByte();
        this.frameType = this.getBitAsInt(n6, 0);
        if (this.frameType != 0) {
            return false;
        }
        int n7 = this.getBitAsInt(n6, 1) << 1;
        n7 += this.getBitAsInt(n6, 2) << 1;
        n7 += this.getBitAsInt(n6, 3);
        int n8 = this.getBitAsInt(n6, 5);
        n8 += this.getBitAsInt(n6, 6) << 1;
        n8 += this.getBitAsInt(n6, 7) << 2;
        n6 = this.frame.readUnsignedByte();
        n8 += n6 << 3;
        n6 = this.frame.readUnsignedByte();
        n8 += n6 << 11;
        n6 = this.frame.readUnsignedByte();
        n6 = this.frame.readUnsignedByte();
        n6 = this.frame.readUnsignedByte();
        int n9 = n6 = this.frame.readUnsignedByte();
        n6 = this.frame.readUnsignedByte();
        this.width = (n9 += n6 << 8) & 0x3FFF;
        int n10 = n6 = this.frame.readUnsignedByte();
        n6 = this.frame.readUnsignedByte();
        this.height = (n10 += n6 << 8) & 0x3FFF;
        int n11 = this.width;
        int n12 = this.height;
        if ((n11 & 0xF) != 0) {
            n11 += 16 - (n11 & 0xF);
        }
        if ((n12 & 0xF) != 0) {
            n12 += 16 - (n12 & 0xF);
        }
        this.macroBlockRows = n12 >> 4;
        this.macroBlockCols = n11 >> 4;
        this.createMacroBlocks();
        this.offset = this.frame.getStreamPosition();
        BoolDecoder boolDecoder = new BoolDecoder(this.frame, this.offset);
        if (this.frameType == 0) {
            n5 = boolDecoder.readBit();
            n4 = boolDecoder.readBit();
        }
        this.segmentationIsEnabled = boolDecoder.readBit();
        if (this.segmentationIsEnabled > 0) {
            this.updateMacroBlockSegmentationMap = boolDecoder.readBit();
            this.updateMacroBlockSegmentatonData = boolDecoder.readBit();
            if (this.updateMacroBlockSegmentatonData > 0) {
                this.macroBlockSegementAbsoluteDelta = boolDecoder.readBit();
                for (n5 = 0; n5 < 4; ++n5) {
                    n4 = 0;
                    if (boolDecoder.readBit() > 0) {
                        n4 = boolDecoder.readLiteral(Globals.vp8MacroBlockFeatureDataBits[0]);
                        if (boolDecoder.readBit() > 0) {
                            n4 = -n4;
                        }
                    }
                    this.segmentQuants.getSegQuants()[n5].setQindex(n4);
                }
                for (n5 = 0; n5 < 4; ++n5) {
                    n4 = 0;
                    if (boolDecoder.readBit() > 0) {
                        n4 = boolDecoder.readLiteral(Globals.vp8MacroBlockFeatureDataBits[1]);
                        if (boolDecoder.readBit() > 0) {
                            n4 = -n4;
                        }
                    }
                    this.segmentQuants.getSegQuants()[n5].setFilterStrength(n4);
                }
                if (this.updateMacroBlockSegmentationMap > 0) {
                    this.macroBlockSegmentTreeProbs = new int[3];
                    for (n5 = 0; n5 < 3; ++n5) {
                        this.macroBlockSegmentTreeProbs[n5] = n4 = boolDecoder.readBit() > 0 ? boolDecoder.readLiteral(8) : 255;
                    }
                }
            }
        }
        this.simpleFilter = boolDecoder.readBit() != 0;
        this.filterLevel = boolDecoder.readLiteral(6);
        this.sharpnessLevel = boolDecoder.readLiteral(3);
        this.modeRefLoopFilterDeltaEnabled = boolDecoder.readBit();
        if (this.modeRefLoopFilterDeltaEnabled > 0) {
            this.modeRefLoopFilterDeltaUpdate = boolDecoder.readBit();
            if (this.modeRefLoopFilterDeltaUpdate > 0) {
                for (n5 = 0; n5 < 4; ++n5) {
                    if (boolDecoder.readBit() <= 0) continue;
                    this.refLoopFilterDeltas[n5] = boolDecoder.readLiteral(6);
                    if (boolDecoder.readBit() <= 0) continue;
                    this.refLoopFilterDeltas[n5] = this.refLoopFilterDeltas[n5] * -1;
                }
                for (n5 = 0; n5 < 4; ++n5) {
                    if (boolDecoder.readBit() <= 0) continue;
                    this.modeLoopFilterDeltas[n5] = boolDecoder.readLiteral(6);
                    if (boolDecoder.readBit() <= 0) continue;
                    this.modeLoopFilterDeltas[n5] = this.modeLoopFilterDeltas[n5] * -1;
                }
            }
        }
        this.setupTokenDecoder(boolDecoder, n8, this.offset);
        boolDecoder.seek();
        this.segmentQuants.parse(boolDecoder, this.segmentationIsEnabled == 1, this.macroBlockSegementAbsoluteDelta == 1);
        if (this.frameType != 0) {
            throw new IllegalArgumentException("Bad input: Not an Intra frame");
        }
        this.refreshEntropyProbs = boolDecoder.readBit();
        if (this.refreshEntropyProbs > 0) {
            // empty if block
        }
        this.refreshLastFrame = 0;
        this.refreshLastFrame = this.frameType == 0 ? 1 : boolDecoder.readBit();
        for (n5 = 0; n5 < 4; ++n5) {
            for (n4 = 0; n4 < 8; ++n4) {
                for (int i2 = 0; i2 < 3; ++i2) {
                    for (n3 = 0; n3 < 11; ++n3) {
                        if (boolDecoder.readBool(Globals.vp8CoefUpdateProbs[n5][n4][i2][n3]) <= 0) continue;
                        this.coefProbs[n5][n4][i2][n3] = n2 = boolDecoder.readLiteral(8);
                    }
                }
            }
        }
        this.macroBlockNoCoeffSkip = boolDecoder.readBit();
        if (this.frameType != 0) {
            throw new IIOException("Bad input: Not an Intra frame");
        }
        this.readModes(boolDecoder);
        n5 = 0;
        n4 = 1 << this.multiTokenPartition;
        Rectangle rectangle = imageReadParam != null && imageReadParam.getSourceRegion() != null ? imageReadParam.getSourceRegion() : writableRaster.getBounds();
        n3 = imageReadParam != null ? imageReadParam.getSourceXSubsampling() : 1;
        n2 = imageReadParam != null ? imageReadParam.getSourceYSubsampling() : 1;
        for (int i3 = 0; i3 < this.macroBlockRows; ++i3) {
            if (n4 > 1) {
                this.tokenBoolDecoder = this.tokenBoolDecoders.get(n5);
                this.tokenBoolDecoder.seek();
                if (++n5 == n4) {
                    n5 = 0;
                }
            }
            this.decodeMacroBlockRow(i3, writableRaster, rectangle, n3, n2);
            this.fireProgressUpdate(i3);
        }
        return true;
    }

    private void decodeMacroBlockRow(int n2, WritableRaster writableRaster, Rectangle rectangle, int n3, int n4) throws IOException {
        boolean bl2 = this.filterLevel != 0;
        MacroBlock macroBlock = null;
        MacroBlock[] macroBlockArray = this.macroBlocks[n2];
        MacroBlock[] macroBlockArray2 = this.macroBlocks[n2 + 1];
        for (int i2 = 0; i2 < this.macroBlockCols; ++i2) {
            MacroBlock macroBlock2 = macroBlockArray2[i2 + 1];
            macroBlock2.decodeMacroBlock(this);
            macroBlock2.dequantMacroBlock(this);
            if (bl2) {
                MacroBlock macroBlock3 = n2 > 0 ? macroBlockArray[i2 + 1] : null;
                LoopFilter.loopFilterBlock(macroBlock2, macroBlock, macroBlock3, this.frameType, this.simpleFilter, this.sharpnessLevel);
            }
            this.copyBlock(macroBlock2, writableRaster, rectangle, n3, n4);
            macroBlock = macroBlock2;
        }
    }

    private void fireProgressUpdate(int n2) {
        if (this.listener != null) {
            float f2 = 100.0f * ((float)(n2 + 1) / (float)this.getMacroBlockRows());
            this.listener.imageProgress(null, f2);
        }
    }

    public SubBlock getAboveRightSubBlock(SubBlock subBlock, SubBlock.Plane plane) {
        MacroBlock macroBlock = subBlock.getMacroBlock();
        int n2 = macroBlock.getSubblockX(subBlock);
        int n3 = macroBlock.getSubblockY(subBlock);
        if (plane == SubBlock.Plane.Y1) {
            if (n3 == 0 && n2 < 3) {
                MacroBlock macroBlock2 = this.getMacroBlock(macroBlock.getX(), macroBlock.getY() - 1);
                SubBlock subBlock2 = macroBlock2.getSubBlock(plane, n2 + 1, 3);
                return subBlock2;
            }
            if (n3 == 0 && n2 == 3) {
                MacroBlock macroBlock3 = this.getMacroBlock(macroBlock.getX() + 1, macroBlock.getY() - 1);
                SubBlock subBlock3 = macroBlock3.getSubBlock(plane, 0, 3);
                if (macroBlock3.getX() == this.getMacroBlockCols()) {
                    int[][] nArray = new int[4][4];
                    for (int i2 = 0; i2 < 4; ++i2) {
                        for (int i3 = 0; i3 < 4; ++i3) {
                            nArray[i3][i2] = macroBlock3.getY() < 0 ? 127 : this.getMacroBlock(macroBlock.getX(), macroBlock.getY() - 1).getSubBlock(SubBlock.Plane.Y1, 3, 3).getDest()[3][3];
                        }
                    }
                    subBlock3 = new SubBlock(macroBlock3, null, null, SubBlock.Plane.Y1);
                    subBlock3.setDest(nArray);
                }
                return subBlock3;
            }
            if (n3 > 0 && n2 < 3) {
                SubBlock subBlock4 = macroBlock.getSubBlock(plane, n2 + 1, n3 - 1);
                return subBlock4;
            }
            SubBlock subBlock5 = macroBlock.getSubBlock(subBlock.getPlane(), 3, 0);
            return this.getAboveRightSubBlock(subBlock5, plane);
        }
        throw new IllegalArgumentException("bad input: getAboveRightSubBlock()");
    }

    public SubBlock getAboveSubBlock(SubBlock subBlock, SubBlock.Plane plane) {
        SubBlock subBlock2 = subBlock.getAbove();
        if (subBlock2 == null) {
            MacroBlock macroBlock = subBlock.getMacroBlock();
            int n2 = macroBlock.getSubblockX(subBlock);
            MacroBlock macroBlock2 = this.getMacroBlock(macroBlock.getX(), macroBlock.getY() - 1);
            while (plane == SubBlock.Plane.Y2 && macroBlock2.getYMode() == 4) {
                macroBlock2 = this.getMacroBlock(macroBlock2.getX(), macroBlock2.getY() - 1);
            }
            subBlock2 = macroBlock2.getBottomSubBlock(n2, subBlock.getPlane());
        }
        return subBlock2;
    }

    private int getBitAsInt(int n2, int n3) {
        int n4 = n2 & 1 << n3;
        if (n4 != 0) {
            return 1;
        }
        return 0;
    }

    int[][][][] getCoefProbs() {
        return this.coefProbs;
    }

    public BufferedImage getDebugImageDiff() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int[] nArray = new int[3];
                int n2 = 127 + this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.Y1, i2 % 16 / 4, i3 % 16 / 4).getDiff()[i2 % 4][i3 % 4];
                int n3 = 127 + this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.U, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getDiff()[i2 / 2 % 4][i3 / 2 % 4];
                int n4 = 127 + this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.V, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getDiff()[i2 / 2 % 4][i3 / 2 % 4];
                nArray[0] = (int)(1.164 * (double)(n2 - 16) + 1.596 * (double)(n4 - 128));
                nArray[1] = (int)(1.164 * (double)(n2 - 16) - 0.813 * (double)(n4 - 128) - 0.391 * (double)(n3 - 128));
                nArray[2] = (int)(1.164 * (double)(n2 - 16) + 2.018 * (double)(n3 - 128));
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImagePredict() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int[] nArray = new int[3];
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.Y1, i2 % 16 / 4, i3 % 16 / 4).getPredict()[i2 % 4][i3 % 4];
                int n3 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.U, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getPredict()[i2 / 2 % 4][i3 / 2 % 4];
                int n4 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.V, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getPredict()[i2 / 2 % 4][i3 / 2 % 4];
                nArray[0] = (int)(1.164 * (double)(n2 - 16) + 1.596 * (double)(n4 - 128));
                nArray[1] = (int)(1.164 * (double)(n2 - 16) - 0.813 * (double)(n4 - 128) - 0.391 * (double)(n3 - 128));
                nArray[2] = (int)(1.164 * (double)(n2 - 16) + 2.018 * (double)(n3 - 128));
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageUBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.U, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getDest()[i2 / 2 % 4][i3 / 2 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageUDiffBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = 127 + this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.U, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getDiff()[i2 / 2 % 4][i3 / 2 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageUPredBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.U, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getPredict()[i2 / 2 % 4][i3 / 2 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageVBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.V, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getDest()[i2 / 2 % 4][i3 / 2 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageVDiffBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = 127 + this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.V, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getDiff()[i2 / 2 % 4][i3 / 2 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageVPredBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.V, i2 / 2 % 8 / 4, i3 / 2 % 8 / 4).getPredict()[i2 / 2 % 4][i3 / 2 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageYBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.Y1, i2 % 16 / 4, i3 % 16 / 4).getDest()[i2 % 4][i3 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageYDiffBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = 127 + this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.Y1, i2 % 16 / 4, i3 % 16 / 4).getDiff()[i2 % 4][i3 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public BufferedImage getDebugImageYPredBuffer() {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), 1);
        WritableRaster writableRaster = bufferedImage.getWritableTile(0, 0);
        for (int i2 = 0; i2 < this.getWidth(); ++i2) {
            for (int i3 = 0; i3 < this.getHeight(); ++i3) {
                int n2 = this.getMacroBlock(i2 / 16, i3 / 16).getSubBlock(SubBlock.Plane.Y1, i2 % 16 / 4, i3 % 16 / 4).getPredict()[i2 % 4][i3 % 4];
                int[] nArray = new int[]{n2, n2, n2};
                for (int i4 = 0; i4 < 3; ++i4) {
                    if (nArray[i4] < 0) {
                        nArray[i4] = 0;
                    }
                    if (nArray[i4] <= 255) continue;
                    nArray[i4] = 255;
                }
                writableRaster.setPixel(i2, i3, nArray);
            }
        }
        return bufferedImage;
    }

    public int getFrameType() {
        return this.frameType;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public SubBlock getLeftSubBlock(SubBlock subBlock, SubBlock.Plane plane) {
        SubBlock subBlock2 = subBlock.getLeft();
        if (subBlock2 == null) {
            MacroBlock macroBlock = subBlock.getMacroBlock();
            int n2 = macroBlock.getSubblockY(subBlock);
            MacroBlock macroBlock2 = this.getMacroBlock(macroBlock.getX() - 1, macroBlock.getY());
            while (plane == SubBlock.Plane.Y2 && macroBlock2.getYMode() == 4) {
                macroBlock2 = this.getMacroBlock(macroBlock2.getX() - 1, macroBlock2.getY());
            }
            subBlock2 = macroBlock2.getRightSubBlock(n2, subBlock.getPlane());
        }
        return subBlock2;
    }

    public MacroBlock getMacroBlock(int n2, int n3) {
        return this.macroBlocks[n3 + 1][n2 + 1];
    }

    public int getMacroBlockCols() {
        return this.macroBlockCols;
    }

    public String getMacroBlockDebugString(int n2, int n3, int n4, int n5) {
        String string = "";
        if (n2 < this.macroBlockCols && n3 < this.getMacroBlockRows()) {
            MacroBlock macroBlock = this.getMacroBlock(n2, n3);
            string = string + macroBlock.getDebugString();
            if (n4 < 4 && n5 < 4) {
                SubBlock subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, n4, n5);
                string = string + "\n SubBlock " + n4 + ", " + n5 + "\n  " + subBlock.getDebugString();
                subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y2, n4, n5);
                string = string + "\n SubBlock " + n4 + ", " + n5 + "\n  " + subBlock.getDebugString();
                subBlock = macroBlock.getSubBlock(SubBlock.Plane.U, n4 / 2, n5 / 2);
                string = string + "\n SubBlock " + n4 / 2 + ", " + n5 / 2 + "\n  " + subBlock.getDebugString();
                subBlock = macroBlock.getSubBlock(SubBlock.Plane.V, n4 / 2, n5 / 2);
                string = string + "\n SubBlock " + n4 / 2 + ", " + n5 / 2 + "\n  " + subBlock.getDebugString();
            }
        }
        return string;
    }

    public int getMacroBlockRows() {
        return this.macroBlockRows;
    }

    public int getQIndex() {
        return this.segmentQuants.getqIndex();
    }

    public SegmentQuants getSegmentQuants() {
        return this.segmentQuants;
    }

    public int getSharpnessLevel() {
        return this.sharpnessLevel;
    }

    public BoolDecoder getTokenBoolDecoder() throws IOException {
        this.tokenBoolDecoder.seek();
        return this.tokenBoolDecoder;
    }

    private void readModes(BoolDecoder boolDecoder) throws IOException {
        int n2 = -1;
        int n3 = 0;
        if (this.macroBlockNoCoeffSkip > 0) {
            n3 = boolDecoder.readLiteral(8);
        }
        while (++n2 < this.macroBlockRows) {
            int n4 = -1;
            while (++n4 < this.macroBlockCols) {
                SubBlock subBlock;
                int n5;
                int n6;
                int n7;
                MacroBlock macroBlock = this.getMacroBlock(n4, n2);
                if (this.segmentationIsEnabled > 0 && this.updateMacroBlockSegmentationMap > 0) {
                    n7 = boolDecoder.readTree(Globals.macroBlockSegmentTree, this.macroBlockSegmentTreeProbs, 0);
                    macroBlock.setSegmentId(n7);
                }
                if (this.modeRefLoopFilterDeltaEnabled > 0) {
                    n7 = this.filterLevel;
                    n7 = (n7 += this.refLoopFilterDeltas[0]) < 0 ? 0 : Math.min(n7, 63);
                    macroBlock.setFilterLevel(n7);
                } else {
                    macroBlock.setFilterLevel(this.segmentQuants.getSegQuants()[macroBlock.getSegmentId()].getFilterStrength());
                }
                n7 = this.macroBlockNoCoeffSkip > 0 ? boolDecoder.readBool(n3) : 0;
                macroBlock.setSkipCoeff(n7);
                int n8 = this.readYMode(boolDecoder);
                macroBlock.setYMode(n8);
                if (n8 == 4) {
                    for (n6 = 0; n6 < 4; ++n6) {
                        for (n5 = 0; n5 < 4; ++n5) {
                            SubBlock subBlock2 = macroBlock.getYSubBlock(n5, n6);
                            subBlock = this.getAboveSubBlock(subBlock2, SubBlock.Plane.Y1);
                            SubBlock subBlock3 = this.getLeftSubBlock(subBlock2, SubBlock.Plane.Y1);
                            int n9 = this.readSubBlockMode(boolDecoder, subBlock.getMode(), subBlock3.getMode());
                            subBlock2.setMode(n9);
                        }
                    }
                    if (this.modeRefLoopFilterDeltaEnabled > 0) {
                        n6 = macroBlock.getFilterLevel();
                        n6 = (n6 += this.modeLoopFilterDeltas[0]) < 0 ? 0 : Math.min(n6, 63);
                        macroBlock.setFilterLevel(n6);
                    }
                } else {
                    switch (n8) {
                        case 1: {
                            n6 = 2;
                            break;
                        }
                        case 2: {
                            n6 = 3;
                            break;
                        }
                        case 3: {
                            n6 = 1;
                            break;
                        }
                        default: {
                            n6 = 0;
                        }
                    }
                    for (n5 = 0; n5 < 4; ++n5) {
                        for (int i2 = 0; i2 < 4; ++i2) {
                            subBlock = macroBlock.getYSubBlock(n5, i2);
                            subBlock.setMode(n6);
                        }
                    }
                }
                n6 = this.readUvMode(boolDecoder);
                macroBlock.setUvMode(n6);
            }
        }
    }

    private int readPartitionSize(long l2) throws IOException {
        this.frame.seek(l2);
        return this.frame.readUnsignedByte() + (this.frame.readUnsignedByte() << 8) + (this.frame.readUnsignedByte() << 16);
    }

    private int readSubBlockMode(BoolDecoder boolDecoder, int n2, int n3) throws IOException {
        return boolDecoder.readTree(Globals.vp8SubBlockModeTree, Globals.vp8KeyFrameSubBlockModeProb[n2][n3], 0);
    }

    private int readUvMode(BoolDecoder boolDecoder) throws IOException {
        return boolDecoder.readTree(Globals.vp8UVModeTree, Globals.vp8KeyFrameUVModeProb, 0);
    }

    private int readYMode(BoolDecoder boolDecoder) throws IOException {
        return boolDecoder.readTree(Globals.vp8KeyFrameYModeTree, Globals.vp8KeyFrameYModeProb, 0);
    }

    private void setupTokenDecoder(BoolDecoder boolDecoder, int n2, long l2) throws IOException {
        long l3;
        long l4 = l3 = l2 + (long)n2;
        this.multiTokenPartition = boolDecoder.readLiteral(2);
        int n3 = 1 << this.multiTokenPartition;
        if (n3 > 1) {
            l4 += 3L * (long)(n3 - 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            long l5;
            if (i2 < n3 - 1) {
                l5 = this.readPartitionSize(l3 + (long)i2 * 3L);
                boolDecoder.seek();
            } else {
                l5 = this.frame.length() - l4;
            }
            this.tokenBoolDecoders.add(new BoolDecoder(this.frame, l4));
            l4 += l5;
        }
        this.tokenBoolDecoder = this.tokenBoolDecoders.get(0);
    }

    private void copyBlock(MacroBlock macroBlock, WritableRaster writableRaster, Rectangle rectangle, int n2, int n3) {
        int n4 = macroBlock.getY() * 16 - rectangle.y;
        int n5 = Math.min(16, writableRaster.getHeight() * n3 - n4);
        int n6 = macroBlock.getX() * 16 - rectangle.x;
        int n7 = Math.min(16, writableRaster.getWidth() * n2 - n6);
        for (int i2 = 0; i2 < n5; i2 += n3) {
            int n8 = (n4 + i2) / n3;
            if (n8 < 0) continue;
            for (int i3 = 0; i3 < n7; i3 += n2) {
                int n9 = (n6 + i3) / n2;
                if (n9 < 0) continue;
                this.yuv[0] = (byte)macroBlock.getSubBlock(SubBlock.Plane.Y1, i3 / 4, i2 / 4).getDest()[i3 % 4][i2 % 4];
                this.yuv[1] = (byte)macroBlock.getSubBlock(SubBlock.Plane.U, i3 / 2 / 4, i2 / 2 / 4).getDest()[i3 / 2 % 4][i2 / 2 % 4];
                this.yuv[2] = (byte)macroBlock.getSubBlock(SubBlock.Plane.V, i3 / 2 / 4, i2 / 2 / 4).getDest()[i3 / 2 % 4][i2 / 2 % 4];
                YCbCrConverter.convertRec601YCbCr2RGB(this.yuv, this.rgb, 0);
                writableRaster.setDataElements(n9, n8, this.rgb);
            }
        }
    }
}


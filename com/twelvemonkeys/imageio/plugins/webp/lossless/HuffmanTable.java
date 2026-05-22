/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.lossless;

import com.twelvemonkeys.imageio.plugins.webp.LSBBitReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.IIOException;

final class HuffmanTable {
    private static final int LEVEL1_BITS = 8;
    private static final int[] L_CODE_ORDER = new int[]{17, 18, 0, 1, 2, 3, 4, 5, 16, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private final int[] level1 = new int[256];
    private final List<int[]> level2 = new ArrayList<int[]>();

    public HuffmanTable(LSBBitReader lSBBitReader, int n2) throws IOException {
        boolean bl2;
        boolean bl3 = bl2 = lSBBitReader.readBit() == 1;
        if (bl2) {
            int n3 = lSBBitReader.readBit() + 1;
            boolean bl4 = lSBBitReader.readBit() == 1;
            short s2 = (short)lSBBitReader.readBits(bl4 ? 8 : 1);
            if (n3 == 2) {
                short s3 = (short)lSBBitReader.readBits(8);
                for (int i2 = 0; i2 < 256; i2 += 2) {
                    this.level1[i2] = 0x10000 | s2;
                    this.level1[i2 + 1] = 0x10000 | s3;
                }
            } else {
                Arrays.fill(this.level1, (int)s2);
            }
        } else {
            int n4 = (int)(lSBBitReader.readBits(4) + 4L);
            short[] sArray = new short[L_CODE_ORDER.length];
            int n5 = 0;
            for (int i3 = 0; i3 < n4; ++i3) {
                short s4;
                sArray[HuffmanTable.L_CODE_ORDER[i3]] = s4 = (short)lSBBitReader.readBits(3);
                if (s4 <= 0) continue;
                ++n5;
            }
            short[] sArray2 = HuffmanTable.readCodeLengths(lSBBitReader, sArray, n2, n5);
            this.buildFromLengths(sArray2);
        }
    }

    private HuffmanTable(short[] sArray, int n2) {
        this.buildFromLengths(sArray, n2);
    }

    private void buildFromLengths(short[] sArray) {
        int n2 = 0;
        for (short s2 : sArray) {
            if (s2 == 0) continue;
            ++n2;
        }
        this.buildFromLengths(sArray, n2);
    }

    private void buildFromLengths(short[] sArray, int n2) {
        int n3;
        int[] nArray = new int[n2];
        int n4 = 0;
        for (n3 = 0; n3 < sArray.length; ++n3) {
            if (sArray[n3] == 0) continue;
            nArray[n4++] = sArray[n3] << 16 | n3;
        }
        if (n2 == 1) {
            Arrays.fill(this.level1, nArray[0] & 0xFFFF);
        }
        Arrays.sort(nArray);
        n3 = 0;
        int n5 = -1;
        int[] nArray2 = null;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n6;
            int n7 = nArray[i2];
            int n8 = n7 >>> 16;
            if (n8 <= 8) {
                for (n6 = n3; n6 < this.level1.length; n6 += 1 << n8) {
                    this.level1[n6] = n7;
                }
            } else {
                if ((n3 & 0xFF) != n5) {
                    n6 = n8;
                    int n9 = i2;
                    for (int i3 = 1 << n8 - 8; n9 < nArray.length && i3 > 0; ++n9, --i3) {
                        int n10 = nArray[n9] >>> 16;
                        while (n10 != n6) {
                            ++n6;
                            i3 <<= 1;
                        }
                    }
                    n9 = n6 - 8;
                    nArray2 = new int[1 << n9];
                    n5 = n3 & 0xFF;
                    this.level2.add(nArray2);
                    this.level1[n5] = 8 + n9 << 16 | this.level2.size() - 1;
                }
                for (n6 = n3 >>> 8; n6 < nArray2.length; n6 += 1 << n8 - 8) {
                    nArray2[n6] = n8 - 8 << 16 | n7 & 0xFFFF;
                }
            }
            n3 = this.nextCode(n3, n8);
        }
    }

    private int nextCode(int n2, int n3) {
        int n4 = ~n2 & (1 << n3) - 1;
        int n5 = Integer.highestOneBit(n4);
        return n2 & n5 - 1 | n5;
    }

    private static short[] readCodeLengths(LSBBitReader lSBBitReader, short[] sArray, int n2, int n3) throws IOException {
        int n4;
        HuffmanTable huffmanTable = new HuffmanTable(sArray, n3);
        if (lSBBitReader.readBit() == 1) {
            int n5 = (int)(2L + 2L * lSBBitReader.readBits(3));
            n4 = (int)(2L + lSBBitReader.readBits(n5));
        } else {
            n4 = n2;
        }
        short[] sArray2 = new short[n2];
        short s2 = 8;
        for (int i2 = 0; i2 < n2 && n4 > 0; ++i2, --n4) {
            int n6;
            int n7;
            short s3 = huffmanTable.readSymbol(lSBBitReader);
            if (s3 < 16) {
                sArray2[i2] = s3;
                if (s3 == 0) continue;
                s2 = s3;
                continue;
            }
            short s4 = 0;
            switch (s3) {
                case 16: {
                    s4 = s2;
                    n7 = 2;
                    n6 = 3;
                    break;
                }
                case 17: {
                    n7 = 3;
                    n6 = 3;
                    break;
                }
                case 18: {
                    n7 = 7;
                    n6 = 11;
                    break;
                }
                default: {
                    throw new IIOException("Huffman: Unreachable: Decoded Code Length > 18.");
                }
            }
            int n8 = (int)(lSBBitReader.readBits(n7) + (long)n6);
            if (i2 + n8 > n2) {
                throw new IIOException(String.format("Huffman: Code length repeat count overflows alphabet: Start index: %d, count: %d, alphabet size: %d", i2, n8, n2));
            }
            Arrays.fill(sArray2, i2, i2 + n8, s4);
            i2 += n8 - 1;
        }
        return sArray2;
    }

    public short readSymbol(LSBBitReader lSBBitReader) throws IOException {
        int n2 = (int)lSBBitReader.peekBits(8);
        int n3 = this.level1[n2];
        int n4 = n3 >>> 16;
        if (n4 > 8) {
            lSBBitReader.readBits(8);
            int n5 = (int)lSBBitReader.peekBits(n4 - 8);
            n3 = this.level2.get(n3 & 0xFFFF)[n5];
            n4 = n3 >>> 16;
        }
        lSBBitReader.readBits(n4);
        return (short)(n3 & 0xFFFF);
    }
}


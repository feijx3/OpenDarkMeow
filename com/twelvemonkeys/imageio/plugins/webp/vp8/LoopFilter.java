/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp.vp8;

import com.twelvemonkeys.imageio.plugins.webp.vp8.MacroBlock;
import com.twelvemonkeys.imageio.plugins.webp.vp8.Segment;
import com.twelvemonkeys.imageio.plugins.webp.vp8.SubBlock;

final class LoopFilter {
    LoopFilter() {
    }

    private static int clamp(int n2) {
        return Math.max(Math.min(n2, 127), -128);
    }

    private static int common_adjust(boolean bl2, Segment segment) {
        int n2 = LoopFilter.u2s(segment.P1);
        int n3 = LoopFilter.u2s(segment.P0);
        int n4 = LoopFilter.u2s(segment.Q0);
        int n5 = LoopFilter.u2s(segment.Q1);
        int n6 = LoopFilter.clamp((bl2 ? LoopFilter.clamp(n2 - n5) : 0) + 3 * (n4 - n3));
        int n7 = LoopFilter.clamp(n6 + 3) >> 3;
        n6 = LoopFilter.clamp(n6 + 4) >> 3;
        segment.Q0 = LoopFilter.s2u(n4 - n6);
        segment.P0 = LoopFilter.s2u(n3 + n7);
        return n6;
    }

    private static boolean filter_yes(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        return Math.abs(n7 - n8) * 2 + Math.abs(n6 - n9) / 2 <= n3 && Math.abs(n4 - n5) <= n2 && Math.abs(n5 - n6) <= n2 && Math.abs(n6 - n7) <= n2 && Math.abs(n11 - n10) <= n2 && Math.abs(n10 - n9) <= n2 && Math.abs(n9 - n8) <= n2;
    }

    private static Segment getSegH(SubBlock subBlock, SubBlock subBlock2, int n2) {
        Segment segment = new Segment();
        int[][] nArray = subBlock.getDest();
        int[][] nArray2 = subBlock2.getDest();
        segment.P0 = nArray2[3][n2];
        segment.P1 = nArray2[2][n2];
        segment.P2 = nArray2[1][n2];
        segment.P3 = nArray2[0][n2];
        segment.Q0 = nArray[0][n2];
        segment.Q1 = nArray[1][n2];
        segment.Q2 = nArray[2][n2];
        segment.Q3 = nArray[3][n2];
        return segment;
    }

    private static Segment getSegV(SubBlock subBlock, SubBlock subBlock2, int n2) {
        Segment segment = new Segment();
        int[][] nArray = subBlock.getDest();
        int[][] nArray2 = subBlock2.getDest();
        segment.P0 = nArray2[n2][3];
        segment.P1 = nArray2[n2][2];
        segment.P2 = nArray2[n2][1];
        segment.P3 = nArray2[n2][0];
        segment.Q0 = nArray[n2][0];
        segment.Q1 = nArray[n2][1];
        segment.Q2 = nArray[n2][2];
        segment.Q3 = nArray[n2][3];
        return segment;
    }

    private static boolean hev(int n2, int n3, int n4, int n5, int n6) {
        return Math.abs(n3 - n4) > n2 || Math.abs(n6 - n5) > n2;
    }

    static void loopFilterBlock(MacroBlock macroBlock, MacroBlock macroBlock2, MacroBlock macroBlock3, int n2, boolean bl2, int n3) {
        if (bl2) {
            LoopFilter.loopFilterSimpleBlock(macroBlock, macroBlock2, macroBlock3, n3);
        } else {
            LoopFilter.loopFilterUVBlock(macroBlock, macroBlock2, macroBlock3, n3, n2);
            LoopFilter.loopFilterYBlock(macroBlock, macroBlock2, macroBlock3, n3, n2);
        }
    }

    static void loopFilterSimpleBlock(MacroBlock macroBlock, MacroBlock macroBlock2, MacroBlock macroBlock3, int n2) {
        int n3 = macroBlock.getFilterLevel();
        if (n3 != 0) {
            Segment segment;
            SubBlock subBlock;
            int n4;
            int n5;
            int n6 = macroBlock.getFilterLevel();
            if (n2 > 0 && (n6 >>= n2 > 4 ? 2 : 1) > 9 - n2) {
                n6 = 9 - n2;
            }
            if (n6 == 0) {
                n6 = 1;
            }
            if ((n5 = n3 * 2 + n6) < 1) {
                n5 = 1;
            }
            int n7 = n5 + 4;
            if (macroBlock2 != null) {
                for (n4 = 0; n4 < 4; ++n4) {
                    SubBlock subBlock2 = macroBlock.getSubBlock(SubBlock.Plane.Y1, 0, n4);
                    subBlock = macroBlock2.getSubBlock(SubBlock.Plane.Y1, 3, n4);
                    for (int i2 = 0; i2 < 4; ++i2) {
                        Segment segment2 = LoopFilter.getSegH(subBlock2, subBlock, i2);
                        LoopFilter.simple_segment(n7, segment2);
                        LoopFilter.setSegH(subBlock2, subBlock, segment2, i2);
                    }
                }
            }
            if (!macroBlock.isSkip_inner_lf()) {
                for (n4 = 1; n4 < 4; ++n4) {
                    for (int i3 = 0; i3 < 4; ++i3) {
                        subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, n4 - 1, i3);
                        SubBlock subBlock3 = macroBlock.getSubBlock(SubBlock.Plane.Y1, n4, i3);
                        for (int i4 = 0; i4 < 4; ++i4) {
                            segment = LoopFilter.getSegH(subBlock3, subBlock, i4);
                            LoopFilter.simple_segment(n5, segment);
                            LoopFilter.setSegH(subBlock3, subBlock, segment, i4);
                        }
                    }
                }
            }
            if (macroBlock3 != null) {
                for (n4 = 0; n4 < 4; ++n4) {
                    SubBlock subBlock4 = macroBlock3.getSubBlock(SubBlock.Plane.Y1, n4, 3);
                    subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, n4, 0);
                    for (int i5 = 0; i5 < 4; ++i5) {
                        Segment segment3 = LoopFilter.getSegV(subBlock, subBlock4, i5);
                        LoopFilter.simple_segment(n7, segment3);
                        LoopFilter.setSegV(subBlock, subBlock4, segment3, i5);
                    }
                }
            }
            if (!macroBlock.isSkip_inner_lf()) {
                for (n4 = 1; n4 < 4; ++n4) {
                    for (int i6 = 0; i6 < 4; ++i6) {
                        subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, i6, n4 - 1);
                        SubBlock subBlock5 = macroBlock.getSubBlock(SubBlock.Plane.Y1, i6, n4);
                        for (int i7 = 0; i7 < 4; ++i7) {
                            segment = LoopFilter.getSegV(subBlock5, subBlock, i7);
                            LoopFilter.simple_segment(n5, segment);
                            LoopFilter.setSegV(subBlock5, subBlock, segment, i7);
                        }
                    }
                }
            }
        }
    }

    static void loopFilterUVBlock(MacroBlock macroBlock, MacroBlock macroBlock2, MacroBlock macroBlock3, int n2, int n3) {
        int n4 = macroBlock.getFilterLevel();
        if (n4 != 0) {
            Segment segment;
            SubBlock subBlock;
            SubBlock subBlock2;
            SubBlock subBlock3;
            int n5;
            int n6 = macroBlock.getFilterLevel();
            if (n2 > 0 && (n6 >>= n2 > 4 ? 2 : 1) > 9 - n2) {
                n6 = 9 - n2;
            }
            if (n6 == 0) {
                n6 = 1;
            }
            int n7 = 0;
            if (n3 == 0) {
                if (n4 >= 40) {
                    n7 = 2;
                } else if (n4 >= 15) {
                    n7 = 1;
                }
            } else if (n4 >= 40) {
                n7 = 3;
            } else if (n4 >= 20) {
                n7 = 2;
            } else if (n4 >= 15) {
                n7 = 1;
            }
            int n8 = (n4 + 2) * 2 + n6;
            int n9 = n4 * 2 + n6;
            if (macroBlock2 != null) {
                for (n5 = 0; n5 < 2; ++n5) {
                    SubBlock subBlock4 = macroBlock.getSubBlock(SubBlock.Plane.U, 0, n5);
                    subBlock3 = macroBlock2.getSubBlock(SubBlock.Plane.U, 1, n5);
                    subBlock2 = macroBlock.getSubBlock(SubBlock.Plane.V, 0, n5);
                    subBlock = macroBlock2.getSubBlock(SubBlock.Plane.V, 1, n5);
                    for (int i2 = 0; i2 < 4; ++i2) {
                        Segment segment2 = LoopFilter.getSegH(subBlock4, subBlock3, i2);
                        LoopFilter.MBfilter(n7, n6, n8, segment2);
                        LoopFilter.setSegH(subBlock4, subBlock3, segment2, i2);
                        segment2 = LoopFilter.getSegH(subBlock2, subBlock, i2);
                        LoopFilter.MBfilter(n7, n6, n8, segment2);
                        LoopFilter.setSegH(subBlock2, subBlock, segment2, i2);
                    }
                }
            }
            if (!macroBlock.isSkip_inner_lf()) {
                for (n5 = 1; n5 < 2; ++n5) {
                    for (int i3 = 0; i3 < 2; ++i3) {
                        subBlock3 = macroBlock.getSubBlock(SubBlock.Plane.U, n5 - 1, i3);
                        subBlock2 = macroBlock.getSubBlock(SubBlock.Plane.U, n5, i3);
                        subBlock = macroBlock.getSubBlock(SubBlock.Plane.V, n5 - 1, i3);
                        SubBlock subBlock5 = macroBlock.getSubBlock(SubBlock.Plane.V, n5, i3);
                        for (int i4 = 0; i4 < 4; ++i4) {
                            segment = LoopFilter.getSegH(subBlock2, subBlock3, i4);
                            LoopFilter.subblock_filter(n7, n6, n9, segment);
                            LoopFilter.setSegH(subBlock2, subBlock3, segment, i4);
                            segment = LoopFilter.getSegH(subBlock5, subBlock, i4);
                            LoopFilter.subblock_filter(n7, n6, n9, segment);
                            LoopFilter.setSegH(subBlock5, subBlock, segment, i4);
                        }
                    }
                }
            }
            if (macroBlock3 != null) {
                for (n5 = 0; n5 < 2; ++n5) {
                    SubBlock subBlock6 = macroBlock3.getSubBlock(SubBlock.Plane.U, n5, 1);
                    subBlock3 = macroBlock.getSubBlock(SubBlock.Plane.U, n5, 0);
                    subBlock2 = macroBlock3.getSubBlock(SubBlock.Plane.V, n5, 1);
                    subBlock = macroBlock.getSubBlock(SubBlock.Plane.V, n5, 0);
                    for (int i5 = 0; i5 < 4; ++i5) {
                        Segment segment3 = LoopFilter.getSegV(subBlock3, subBlock6, i5);
                        LoopFilter.MBfilter(n7, n6, n8, segment3);
                        LoopFilter.setSegV(subBlock3, subBlock6, segment3, i5);
                        segment3 = LoopFilter.getSegV(subBlock, subBlock2, i5);
                        LoopFilter.MBfilter(n7, n6, n8, segment3);
                        LoopFilter.setSegV(subBlock, subBlock2, segment3, i5);
                    }
                }
            }
            if (!macroBlock.isSkip_inner_lf()) {
                for (n5 = 1; n5 < 2; ++n5) {
                    for (int i6 = 0; i6 < 2; ++i6) {
                        subBlock3 = macroBlock.getSubBlock(SubBlock.Plane.U, i6, n5 - 1);
                        subBlock2 = macroBlock.getSubBlock(SubBlock.Plane.U, i6, n5);
                        subBlock = macroBlock.getSubBlock(SubBlock.Plane.V, i6, n5 - 1);
                        SubBlock subBlock7 = macroBlock.getSubBlock(SubBlock.Plane.V, i6, n5);
                        for (int i7 = 0; i7 < 4; ++i7) {
                            segment = LoopFilter.getSegV(subBlock2, subBlock3, i7);
                            LoopFilter.subblock_filter(n7, n6, n9, segment);
                            LoopFilter.setSegV(subBlock2, subBlock3, segment, i7);
                            segment = LoopFilter.getSegV(subBlock7, subBlock, i7);
                            LoopFilter.subblock_filter(n7, n6, n9, segment);
                            LoopFilter.setSegV(subBlock7, subBlock, segment, i7);
                        }
                    }
                }
            }
        }
    }

    static void loopFilterYBlock(MacroBlock macroBlock, MacroBlock macroBlock2, MacroBlock macroBlock3, int n2, int n3) {
        int n4 = macroBlock.getFilterLevel();
        if (n4 != 0) {
            Segment segment;
            SubBlock subBlock;
            int n5;
            int n6 = macroBlock.getFilterLevel();
            if (n2 > 0 && (n6 >>= n2 > 4 ? 2 : 1) > 9 - n2) {
                n6 = 9 - n2;
            }
            if (n6 == 0) {
                n6 = 1;
            }
            int n7 = 0;
            if (n3 == 0) {
                if (n4 >= 40) {
                    n7 = 2;
                } else if (n4 >= 15) {
                    n7 = 1;
                }
            } else if (n4 >= 40) {
                n7 = 3;
            } else if (n4 >= 20) {
                n7 = 2;
            } else if (n4 >= 15) {
                n7 = 1;
            }
            int n8 = (n4 + 2) * 2 + n6;
            int n9 = n4 * 2 + n6;
            if (macroBlock2 != null) {
                for (n5 = 0; n5 < 4; ++n5) {
                    SubBlock subBlock2 = macroBlock.getSubBlock(SubBlock.Plane.Y1, 0, n5);
                    subBlock = macroBlock2.getSubBlock(SubBlock.Plane.Y1, 3, n5);
                    for (int i2 = 0; i2 < 4; ++i2) {
                        Segment segment2 = LoopFilter.getSegH(subBlock2, subBlock, i2);
                        LoopFilter.MBfilter(n7, n6, n8, segment2);
                        LoopFilter.setSegH(subBlock2, subBlock, segment2, i2);
                    }
                }
            }
            if (!macroBlock.isSkip_inner_lf()) {
                for (n5 = 1; n5 < 4; ++n5) {
                    for (int i3 = 0; i3 < 4; ++i3) {
                        subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, n5 - 1, i3);
                        SubBlock subBlock3 = macroBlock.getSubBlock(SubBlock.Plane.Y1, n5, i3);
                        for (int i4 = 0; i4 < 4; ++i4) {
                            segment = LoopFilter.getSegH(subBlock3, subBlock, i4);
                            LoopFilter.subblock_filter(n7, n6, n9, segment);
                            LoopFilter.setSegH(subBlock3, subBlock, segment, i4);
                        }
                    }
                }
            }
            if (macroBlock3 != null) {
                for (n5 = 0; n5 < 4; ++n5) {
                    SubBlock subBlock4 = macroBlock3.getSubBlock(SubBlock.Plane.Y1, n5, 3);
                    subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, n5, 0);
                    for (int i5 = 0; i5 < 4; ++i5) {
                        Segment segment3 = LoopFilter.getSegV(subBlock, subBlock4, i5);
                        LoopFilter.MBfilter(n7, n6, n8, segment3);
                        LoopFilter.setSegV(subBlock, subBlock4, segment3, i5);
                    }
                }
            }
            if (!macroBlock.isSkip_inner_lf()) {
                for (n5 = 1; n5 < 4; ++n5) {
                    for (int i6 = 0; i6 < 4; ++i6) {
                        subBlock = macroBlock.getSubBlock(SubBlock.Plane.Y1, i6, n5 - 1);
                        SubBlock subBlock5 = macroBlock.getSubBlock(SubBlock.Plane.Y1, i6, n5);
                        for (int i7 = 0; i7 < 4; ++i7) {
                            segment = LoopFilter.getSegV(subBlock5, subBlock, i7);
                            LoopFilter.subblock_filter(n7, n6, n9, segment);
                            LoopFilter.setSegV(subBlock5, subBlock, segment, i7);
                        }
                    }
                }
            }
        }
    }

    private static void MBfilter(int n2, int n3, int n4, Segment segment) {
        int n5 = LoopFilter.u2s(segment.P3);
        int n6 = LoopFilter.u2s(segment.P2);
        int n7 = LoopFilter.u2s(segment.P1);
        int n8 = LoopFilter.u2s(segment.P0);
        int n9 = LoopFilter.u2s(segment.Q0);
        int n10 = LoopFilter.u2s(segment.Q1);
        int n11 = LoopFilter.u2s(segment.Q2);
        int n12 = LoopFilter.u2s(segment.Q3);
        if (LoopFilter.filter_yes(n3, n4, n12, n11, n10, n9, n8, n7, n6, n5)) {
            if (!LoopFilter.hev(n2, n7, n8, n9, n10)) {
                int n13 = LoopFilter.clamp(LoopFilter.clamp(n7 - n10) + 3 * (n9 - n8));
                int n14 = 27 * n13 + 63 >> 7;
                segment.Q0 = LoopFilter.s2u(n9 - n14);
                segment.P0 = LoopFilter.s2u(n8 + n14);
                n14 = 18 * n13 + 63 >> 7;
                segment.Q1 = LoopFilter.s2u(n10 - n14);
                segment.P1 = LoopFilter.s2u(n7 + n14);
                n14 = 9 * n13 + 63 >> 7;
                segment.Q2 = LoopFilter.s2u(n11 - n14);
                segment.P2 = LoopFilter.s2u(n6 + n14);
            } else {
                LoopFilter.common_adjust(true, segment);
            }
        }
    }

    private static int s2u(int n2) {
        return LoopFilter.clamp(n2) + 128;
    }

    private static void setSegH(SubBlock subBlock, SubBlock subBlock2, Segment segment, int n2) {
        int[][] nArray = subBlock.getDest();
        int[][] nArray2 = subBlock2.getDest();
        nArray2[3][n2] = segment.P0;
        nArray2[2][n2] = segment.P1;
        nArray2[1][n2] = segment.P2;
        nArray2[0][n2] = segment.P3;
        nArray[0][n2] = segment.Q0;
        nArray[1][n2] = segment.Q1;
        nArray[2][n2] = segment.Q2;
        nArray[3][n2] = segment.Q3;
    }

    private static void setSegV(SubBlock subBlock, SubBlock subBlock2, Segment segment, int n2) {
        int[][] nArray = subBlock.getDest();
        int[][] nArray2 = subBlock2.getDest();
        nArray2[n2][3] = segment.P0;
        nArray2[n2][2] = segment.P1;
        nArray2[n2][1] = segment.P2;
        nArray2[n2][0] = segment.P3;
        nArray[n2][0] = segment.Q0;
        nArray[n2][1] = segment.Q1;
        nArray[n2][2] = segment.Q2;
        nArray[n2][3] = segment.Q3;
    }

    private static void simple_segment(int n2, Segment segment) {
        if (Math.abs(segment.P0 - segment.Q0) * 2 + Math.abs(segment.P1 - segment.Q1) / 2 <= n2) {
            LoopFilter.common_adjust(true, segment);
        }
    }

    private static void subblock_filter(int n2, int n3, int n4, Segment segment) {
        int n5 = LoopFilter.u2s(segment.P3);
        int n6 = LoopFilter.u2s(segment.P2);
        int n7 = LoopFilter.u2s(segment.P1);
        int n8 = LoopFilter.u2s(segment.P0);
        int n9 = LoopFilter.u2s(segment.Q0);
        int n10 = LoopFilter.u2s(segment.Q1);
        int n11 = LoopFilter.u2s(segment.Q2);
        int n12 = LoopFilter.u2s(segment.Q3);
        if (LoopFilter.filter_yes(n3, n4, n12, n11, n10, n9, n8, n7, n6, n5)) {
            boolean bl2 = LoopFilter.hev(n2, n7, n8, n9, n10);
            int n13 = LoopFilter.common_adjust(bl2, segment) + 1 >> 1;
            if (!bl2) {
                segment.Q1 = LoopFilter.s2u(n10 - n13);
                segment.P1 = LoopFilter.s2u(n7 + n13);
            }
        }
    }

    private static int u2s(int n2) {
        return n2 - 128;
    }
}


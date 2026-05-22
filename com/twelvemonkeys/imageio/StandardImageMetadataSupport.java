/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio;

import com.twelvemonkeys.imageio.AbstractMetadata;
import com.twelvemonkeys.lang.Validate;
import java.awt.color.ColorSpace;
import java.awt.image.BandedSampleModel;
import java.awt.image.ColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.IndexColorModel;
import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;

public class StandardImageMetadataSupport
extends AbstractMetadata {
    private final ImageTypeSpecifier type;
    protected final ColorSpaceType colorSpaceType;
    protected final boolean blackIsZero;
    private final IndexColorModel palette;
    protected final String compressionName;
    protected final boolean compressionLossless;
    protected final PlanarConfiguration planarConfiguration;
    private final int[] bitsPerSample;
    private final int[] significantBits;
    private final int[] sampleMSB;
    protected final Double pixelAspectRatio;
    protected final ImageOrientation orientation;
    protected final String formatVersion;
    protected final SubimageInterpretation subimageInterpretation;
    private final Calendar documentCreationTime;
    private final Collection<TextEntry> textEntries;

    protected StandardImageMetadataSupport(Builder builder) {
        Validate.notNull(builder, "builder");
        this.type = builder.type;
        this.colorSpaceType = builder.colorSpaceType;
        this.blackIsZero = builder.blackIsZero;
        this.palette = builder.palette;
        this.compressionName = builder.compressionName;
        this.compressionLossless = builder.compressionLossless;
        this.planarConfiguration = builder.planarConfiguration;
        this.bitsPerSample = builder.bitsPerSample;
        this.significantBits = builder.significantBits;
        this.sampleMSB = builder.sampleMSB;
        this.orientation = builder.orientation;
        this.pixelAspectRatio = builder.pixelAspectRatio;
        this.formatVersion = builder.formatVersion;
        this.documentCreationTime = builder.documentCreationTime;
        this.subimageInterpretation = builder.subimageInterpretation;
        this.textEntries = builder.textEntries;
    }

    public static Builder builder(ImageTypeSpecifier imageTypeSpecifier) {
        return new Builder(imageTypeSpecifier);
    }

    @Override
    protected IIOMetadataNode getStandardChromaNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Chroma");
        ColorModel colorModel = this.colorSpaceType != null ? null : this.type.getColorModel();
        ColorSpaceType colorSpaceType = this.colorSpaceType != null ? this.colorSpaceType : StandardImageMetadataSupport.colorSpaceType(colorModel.getColorSpace());
        int n2 = this.colorSpaceType != null ? this.colorSpaceType.numChannels : colorModel.getNumComponents();
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ColorSpaceType");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        iIOMetadataNode2.setAttribute("name", colorSpaceType.toString());
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("NumChannels");
        iIOMetadataNode3.setAttribute("value", String.valueOf(n2));
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("BlackIsZero");
        iIOMetadataNode4.setAttribute("value", StandardImageMetadataSupport.booleanString(this.blackIsZero));
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        if (colorModel instanceof IndexColorModel || this.palette != null) {
            IndexColorModel indexColorModel = this.palette != null ? this.palette : (IndexColorModel)colorModel;
            IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode("Palette");
            iIOMetadataNode.appendChild(iIOMetadataNode5);
            for (int i2 = 0; i2 < indexColorModel.getMapSize(); ++i2) {
                IIOMetadataNode iIOMetadataNode6 = new IIOMetadataNode("PaletteEntry");
                iIOMetadataNode5.appendChild(iIOMetadataNode6);
                iIOMetadataNode6.setAttribute("index", Integer.toString(i2));
                iIOMetadataNode6.setAttribute("red", Integer.toString(indexColorModel.getRed(i2)));
                iIOMetadataNode6.setAttribute("green", Integer.toString(indexColorModel.getGreen(i2)));
                iIOMetadataNode6.setAttribute("blue", Integer.toString(indexColorModel.getBlue(i2)));
                if (indexColorModel.getTransparency() != 3) continue;
                iIOMetadataNode6.setAttribute("alpha", Integer.toString(indexColorModel.getAlpha(i2)));
            }
            if (indexColorModel.getTransparentPixel() != -1) {
                IIOMetadataNode iIOMetadataNode7 = new IIOMetadataNode("BackgroundIndex");
                iIOMetadataNode.appendChild(iIOMetadataNode7);
                iIOMetadataNode7.setAttribute("value", Integer.toString(indexColorModel.getTransparentPixel()));
            }
        }
        return iIOMetadataNode;
    }

    private static ColorSpaceType colorSpaceType(ColorSpace colorSpace) {
        switch (colorSpace.getType()) {
            case 0: {
                return ColorSpaceType.XYZ;
            }
            case 1: {
                return ColorSpaceType.Lab;
            }
            case 2: {
                return ColorSpaceType.Luv;
            }
            case 3: {
                return ColorSpaceType.YCbCr;
            }
            case 4: {
                return ColorSpaceType.Yxy;
            }
            case 5: {
                return ColorSpaceType.RGB;
            }
            case 6: {
                return ColorSpaceType.GRAY;
            }
            case 7: {
                return ColorSpaceType.HSV;
            }
            case 8: {
                return ColorSpaceType.HLS;
            }
            case 9: {
                return ColorSpaceType.CMYK;
            }
            case 11: {
                return ColorSpaceType.CMY;
            }
        }
        int n2 = colorSpace.getNumComponents();
        if (n2 == 1) {
            return ColorSpaceType.GRAY;
        }
        if (n2 < 16) {
            return ColorSpaceType.valueOf("GENERIC_" + Integer.toHexString(n2) + "CLR");
        }
        throw new IllegalArgumentException("Unknown ColorSpace type: " + colorSpace);
    }

    @Override
    protected IIOMetadataNode getStandardCompressionNode() {
        if (this.compressionName == null) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Compression");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("CompressionTypeName");
        iIOMetadataNode2.setAttribute("value", this.compressionName);
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("Lossless");
        iIOMetadataNode3.setAttribute("value", StandardImageMetadataSupport.booleanString(this.compressionLossless));
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        return iIOMetadataNode;
    }

    protected static String booleanString(boolean bl2) {
        return bl2 ? "TRUE" : "FALSE";
    }

    @Override
    protected IIOMetadataNode getStandardDataNode() {
        Object object;
        Object object2;
        String string;
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Data");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("PlanarConfiguration");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        iIOMetadataNode2.setAttribute("value", this.planarConfiguration != null ? this.planarConfiguration.toString() : (this.type.getSampleModel() instanceof BandedSampleModel ? "PlaneInterleaved" : "PixelInterleaved"));
        String string2 = string = this.colorSpaceType == null && this.type.getColorModel() instanceof IndexColorModel ? "Index" : StandardImageMetadataSupport.sampleFormat(this.type.getSampleModel());
        if (string != null) {
            object2 = new IIOMetadataNode("SampleFormat");
            ((IIOMetadataNode)object2).setAttribute("value", string);
            iIOMetadataNode.appendChild((Node)object2);
        }
        object2 = this.bitsPerSample != null ? this.bitsPerSample : this.type.getSampleModel().getSampleSize();
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("BitsPerSample");
        iIOMetadataNode3.setAttribute("value", StandardImageMetadataSupport.createListValue(((Object)object2).length, (int[])object2));
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        if (this.significantBits != null && !((String)(object = StandardImageMetadataSupport.createListValue(this.type.getNumBands(), this.significantBits))).equals(iIOMetadataNode3.getAttribute("value"))) {
            IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("SignificantBitsPerSample");
            iIOMetadataNode4.setAttribute("value", (String)object);
            iIOMetadataNode.appendChild(iIOMetadataNode4);
        }
        if (this.sampleMSB != null) {
            object = new IIOMetadataNode("SampleMSB");
            ((IIOMetadataNode)object).setAttribute("value", StandardImageMetadataSupport.createListValue(this.type.getNumBands(), this.sampleMSB));
            iIOMetadataNode.appendChild((Node)object);
        }
        return iIOMetadataNode;
    }

    private static String createListValue(int n2, int ... nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(nArray[i2 % nArray.length]);
        }
        return stringBuilder.toString();
    }

    private static String sampleFormat(SampleModel sampleModel) {
        switch (sampleModel.getDataType()) {
            case 2: 
            case 3: {
                if (sampleModel instanceof ComponentSampleModel) {
                    return "SignedIntegral";
                }
            }
            case 0: 
            case 1: {
                return "UnsignedIntegral";
            }
            case 4: 
            case 5: {
                return "Real";
            }
        }
        return null;
    }

    @Override
    protected IIOMetadataNode getStandardDimensionNode() {
        IIOMetadataNode iIOMetadataNode;
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Dimension");
        if (this.pixelAspectRatio != null) {
            iIOMetadataNode = new IIOMetadataNode("PixelAspectRatio");
            iIOMetadataNode.setAttribute("value", String.valueOf(this.pixelAspectRatio));
            iIOMetadataNode2.appendChild(iIOMetadataNode);
        }
        iIOMetadataNode = new IIOMetadataNode("ImageOrientation");
        iIOMetadataNode.setAttribute("value", this.orientation.toString());
        iIOMetadataNode2.appendChild(iIOMetadataNode);
        return iIOMetadataNode2.hasChildNodes() ? iIOMetadataNode2 : null;
    }

    @Override
    protected IIOMetadataNode getStandardDocumentNode() {
        IIOMetadataNode iIOMetadataNode;
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Document");
        if (this.formatVersion != null) {
            iIOMetadataNode = new IIOMetadataNode("FormatVersion");
            iIOMetadataNode2.appendChild(iIOMetadataNode);
            iIOMetadataNode.setAttribute("value", this.formatVersion);
        }
        if (this.subimageInterpretation != null) {
            iIOMetadataNode = new IIOMetadataNode("SubimageInterpretation");
            iIOMetadataNode2.appendChild(iIOMetadataNode);
            iIOMetadataNode.setAttribute("value", this.subimageInterpretation.toString());
        }
        if (this.documentCreationTime != null) {
            iIOMetadataNode = new IIOMetadataNode("ImageCreationTime");
            iIOMetadataNode2.appendChild(iIOMetadataNode);
            iIOMetadataNode.setAttribute("year", String.valueOf(this.documentCreationTime.get(1)));
            iIOMetadataNode.setAttribute("month", String.valueOf(this.documentCreationTime.get(2) + 1));
            iIOMetadataNode.setAttribute("day", String.valueOf(this.documentCreationTime.get(5)));
            iIOMetadataNode.setAttribute("hour", String.valueOf(this.documentCreationTime.get(11)));
            iIOMetadataNode.setAttribute("minute", String.valueOf(this.documentCreationTime.get(12)));
            iIOMetadataNode.setAttribute("second", String.valueOf(this.documentCreationTime.get(13)));
        }
        return iIOMetadataNode2.hasChildNodes() ? iIOMetadataNode2 : null;
    }

    @Override
    protected IIOMetadataNode getStandardTextNode() {
        if (this.textEntries.isEmpty()) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Text");
        for (TextEntry textEntry : this.textEntries) {
            IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("TextEntry");
            iIOMetadataNode.appendChild(iIOMetadataNode2);
            if (textEntry.keyword != null) {
                iIOMetadataNode2.setAttribute("keyword", textEntry.keyword);
            }
            iIOMetadataNode2.setAttribute("value", textEntry.value);
            if (textEntry.language != null) {
                iIOMetadataNode2.setAttribute("language", textEntry.language);
            }
            if (textEntry.encoding != null) {
                iIOMetadataNode2.setAttribute("encoding", textEntry.encoding);
            }
            if (textEntry.compression == null) continue;
            iIOMetadataNode2.setAttribute("compression", textEntry.compression);
        }
        return iIOMetadataNode;
    }

    @Override
    protected IIOMetadataNode getStandardTransparencyNode() {
        IndexColorModel indexColorModel;
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Transparency");
        ColorModel colorModel = this.type.getColorModel();
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Alpha");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        iIOMetadataNode2.setAttribute("value", colorModel.hasAlpha() ? (colorModel.isAlphaPremultiplied() ? "premultiplied" : "nonpremultiplied") : "none");
        if (colorModel instanceof IndexColorModel && (indexColorModel = (IndexColorModel)colorModel).getTransparentPixel() != -1) {
            IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("TransparentIndex");
            iIOMetadataNode.appendChild(iIOMetadataNode3);
            iIOMetadataNode3.setAttribute("value", Integer.toString(indexColorModel.getTransparentPixel()));
        }
        return iIOMetadataNode;
    }

    protected static final class TextEntry {
        static final List<String> COMPRESSIONS = Arrays.asList("none", "lzw", "zip", "bzip", "other");
        final String keyword;
        final String value;
        final String language;
        final String encoding;
        final String compression;

        public TextEntry(String string, String string2) {
            this(string, string2, null, null, null);
        }

        public TextEntry(String string, String string2, String string3, String string4, String string5) {
            this.keyword = string;
            this.value = Validate.notNull(string2, "value");
            this.language = string3;
            this.encoding = string4;
            this.compression = Validate.isTrue(string5 == null || COMPRESSIONS.contains(string5), string5, String.format("Unknown compression: %s (expected: %s)", string5, COMPRESSIONS));
        }
    }

    protected static enum SubimageInterpretation {
        Standalone,
        SinglePage,
        FullResolution,
        ReducedResolution,
        PyramidLayer,
        Preview,
        VolumeSlice,
        ObjectView,
        Panorama,
        AnimationFrame,
        TransparencyMask,
        CompositingLayer,
        SpectralSlice,
        Unknown;

    }

    protected static enum ImageOrientation {
        Normal,
        Rotate90,
        Rotate180,
        Rotate270,
        FlipH,
        FlipV,
        FlipHRotate90,
        FlipVRotate90;

    }

    protected static enum PlanarConfiguration {
        PixelInterleaved,
        PlaneInterleaved,
        LineInterleaved,
        TileInterleaved;

    }

    protected static enum ColorSpaceType {
        XYZ(3),
        Lab(3),
        Luv(3),
        YCbCr(3),
        Yxy(3),
        YCCK(4),
        PhotoYCC(3),
        RGB(3),
        GRAY(1),
        HSV(3),
        HLS(3),
        CMYK(3),
        CMY(3),
        GENERIC_2CLR(2, "2CLR"),
        GENERIC_3CLR(3, "3CLR"),
        GENERIC_4CLR(4, "4CLR"),
        GENERIC_5CLR(5, "5CLR"),
        GENERIC_6CLR(6, "6CLR"),
        GENERIC_7CLR(7, "7CLR"),
        GENERIC_8CLR(8, "8CLR"),
        GENERIC_9CLR(9, "9CLR"),
        GENERIC_ACLR(10, "ACLR"),
        GENERIC_BCLR(11, "BCLR"),
        GENERIC_CCLR(12, "CCLR"),
        GENERIC_DCLR(13, "DCLR"),
        GENERIC_ECLR(14, "ECLR"),
        GENERIC_FCLR(15, "FCLR");

        final int numChannels;
        private final String nameOverride;

        private ColorSpaceType(int n3) {
            this(n3, null);
        }

        private ColorSpaceType(int n3, String string2) {
            this.numChannels = n3;
            this.nameOverride = string2;
        }

        public String toString() {
            return this.nameOverride != null ? this.nameOverride : super.toString();
        }
    }

    public static class Builder {
        private final ImageTypeSpecifier type;
        private ColorSpaceType colorSpaceType;
        private boolean blackIsZero = true;
        private IndexColorModel palette;
        private String compressionName;
        private boolean compressionLossless = true;
        private PlanarConfiguration planarConfiguration;
        public int[] bitsPerSample;
        private int[] significantBits;
        private int[] sampleMSB;
        private Double pixelAspectRatio;
        private ImageOrientation orientation = ImageOrientation.Normal;
        private String formatVersion;
        private SubimageInterpretation subimageInterpretation;
        private Calendar documentCreationTime;
        private final Collection<TextEntry> textEntries = new ArrayList<TextEntry>();

        protected Builder(ImageTypeSpecifier imageTypeSpecifier) {
            this.type = Validate.notNull(imageTypeSpecifier, "type");
        }

        public Builder withColorSpaceType(ColorSpaceType colorSpaceType) {
            this.colorSpaceType = colorSpaceType;
            return this;
        }

        public Builder withBlackIsZero(boolean bl2) {
            this.blackIsZero = bl2;
            return this;
        }

        public Builder withPalette(IndexColorModel indexColorModel) {
            this.palette = indexColorModel;
            return this;
        }

        public Builder withCompressionTypeName(String string) {
            this.compressionName = Validate.notNull(string, "compressionName").equalsIgnoreCase("none") ? null : string;
            return this;
        }

        public Builder withCompressionLossless(boolean bl2) {
            this.compressionLossless = Validate.isTrue(bl2 || this.compressionName != null, bl2, "Lossy compression requires compression name");
            return this;
        }

        public Builder withPlanarConfiguration(PlanarConfiguration planarConfiguration) {
            this.planarConfiguration = planarConfiguration;
            return this;
        }

        public Builder withBitsPerSample(int ... nArray) {
            this.bitsPerSample = nArray;
            return this;
        }

        public Builder withSignificantBitsPerSample(int ... nArray) {
            this.significantBits = Validate.isTrue(nArray.length == 1 || nArray.length == this.type.getNumBands(), nArray, String.format("single value or %d values expected", this.type.getNumBands()));
            return this;
        }

        public Builder withSampleMSB(int ... nArray) {
            this.sampleMSB = Validate.isTrue(nArray.length == 1 || nArray.length == this.type.getNumBands(), nArray, String.format("single value or %d values expected", this.type.getNumBands()));
            return this;
        }

        public Builder withPixelAspectRatio(Double d2) {
            this.pixelAspectRatio = d2;
            return this;
        }

        public Builder withOrientation(ImageOrientation imageOrientation) {
            this.orientation = Validate.notNull(imageOrientation, "orientation");
            return this;
        }

        public Builder withFormatVersion(String string) {
            this.formatVersion = Validate.notNull(string, "formatVersion");
            return this;
        }

        public Builder withSubimageInterpretation(SubimageInterpretation subimageInterpretation) {
            this.subimageInterpretation = subimageInterpretation;
            return this;
        }

        public Builder withDocumentCreationTime(Calendar calendar) {
            this.documentCreationTime = calendar;
            return this;
        }

        public Builder withTextEntries(Map<String, String> map) {
            return this.withTextEntries(this.toTextEntries(Validate.notNull(map, "entries").entrySet()));
        }

        private Collection<TextEntry> toTextEntries(Collection<Map.Entry<String, String>> collection) {
            TextEntry[] textEntryArray = new TextEntry[collection.size()];
            int n2 = 0;
            for (Map.Entry<String, String> entry : collection) {
                textEntryArray[n2++] = new TextEntry(entry.getKey(), entry.getValue());
            }
            return Arrays.asList(textEntryArray);
        }

        public Builder withTextEntries(Collection<TextEntry> collection) {
            this.textEntries.addAll(Validate.notNull(collection, "entries"));
            return this;
        }

        public Builder withTextEntry(String string, String string2) {
            if (string2 != null && !string2.isEmpty()) {
                this.textEntries.add(new TextEntry(Validate.notNull(string, "keyword"), string2));
            }
            return this;
        }

        public IIOMetadata build() {
            return new StandardImageMetadataSupport(this);
        }
    }
}


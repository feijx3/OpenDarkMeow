/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.plugins.webp;

import com.twelvemonkeys.imageio.ImageReaderBase;
import com.twelvemonkeys.imageio.color.ColorProfiles;
import com.twelvemonkeys.imageio.color.ColorSpaces;
import com.twelvemonkeys.imageio.metadata.Directory;
import com.twelvemonkeys.imageio.metadata.tiff.TIFFReader;
import com.twelvemonkeys.imageio.metadata.xmp.XMPReader;
import com.twelvemonkeys.imageio.plugins.webp.AnimationFrame;
import com.twelvemonkeys.imageio.plugins.webp.LSBBitReader;
import com.twelvemonkeys.imageio.plugins.webp.RIFFChunk;
import com.twelvemonkeys.imageio.plugins.webp.VP8xChunk;
import com.twelvemonkeys.imageio.plugins.webp.WebPImageMetadata;
import com.twelvemonkeys.imageio.plugins.webp.lossless.VP8LDecoder;
import com.twelvemonkeys.imageio.plugins.webp.vp8.VP8Frame;
import com.twelvemonkeys.imageio.stream.SubImageInputStream;
import com.twelvemonkeys.imageio.util.IIOUtil;
import com.twelvemonkeys.imageio.util.ImageTypeSpecifiers;
import com.twelvemonkeys.imageio.util.ProgressListenerBase;
import com.twelvemonkeys.imageio.util.RasterUtils;
import java.awt.Rectangle;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.IIOException;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.spi.ImageReaderSpi;

final class WebPImageReader
extends ImageReaderBase {
    static final boolean DEBUG = "true".equalsIgnoreCase(System.getProperty("com.twelvemonkeys.imageio.plugins.webp.debug"));
    private LSBBitReader lsbBitReader;
    private long fileSize;
    private VP8xChunk header;
    private ICC_Profile containedICCP;
    private ICC_Profile iccProfile;
    private final List<AnimationFrame> frames = new ArrayList<AnimationFrame>();

    WebPImageReader(ImageReaderSpi imageReaderSpi) {
        super(imageReaderSpi);
    }

    @Override
    protected void resetMembers() {
        this.fileSize = -1L;
        this.header = null;
        this.containedICCP = null;
        this.iccProfile = null;
        this.lsbBitReader = null;
        this.frames.clear();
    }

    @Override
    public void setInput(Object object, boolean bl2, boolean bl3) {
        super.setInput(object, bl2, bl3);
        if (this.imageInput != null) {
            this.lsbBitReader = new LSBBitReader(this.imageInput);
        }
    }

    private void readHeader(int n2) throws IOException {
        this.checkBounds(n2);
        this.readHeader();
        if (this.header.containsANIM) {
            this.readFrame(n2);
        }
    }

    private void readFrame(int n2) throws IOException {
        if (!this.header.containsANIM) {
            throw new IndexOutOfBoundsException("imageIndex >= 1 for non-animated WebP: " + n2);
        }
        if (n2 < this.frames.size()) {
            return;
        }
        VP8xChunk vP8xChunk = this.frames.isEmpty() ? this.header : (RIFFChunk)this.frames.get(this.frames.size() - 1);
        this.imageInput.seek(vP8xChunk.offset + vP8xChunk.length);
        while (this.imageInput.getStreamPosition() < this.fileSize) {
            int n3 = this.imageInput.readInt();
            long l2 = this.imageInput.readUnsignedInt();
            long l3 = this.imageInput.getStreamPosition();
            if (DEBUG) {
                System.out.printf("chunk: '%s'\n", WebPImageReader.fourCC(n3));
                System.out.println("chunkStart: " + l3);
                System.out.println("chunkLength: " + l2);
            }
            switch (n3) {
                case 1296649793: {
                    break;
                }
                case 1179471425: {
                    int n4 = 2 * (int)this.lsbBitReader.readBits(24);
                    int n5 = 2 * (int)this.lsbBitReader.readBits(24);
                    int n6 = 1 + (int)this.lsbBitReader.readBits(24);
                    int n7 = 1 + (int)this.lsbBitReader.readBits(24);
                    Rectangle rectangle = new Rectangle(n4, n5, n6, n7);
                    int n8 = (int)this.lsbBitReader.readBits(24);
                    int n9 = this.imageInput.readUnsignedByte();
                    this.frames.add(new AnimationFrame(l2, l3, rectangle, n8, n9));
                    break;
                }
            }
            if (n2 < this.frames.size()) {
                return;
            }
            this.imageInput.seek(l3 + l2 + (l2 & 1L));
        }
        throw new IndexOutOfBoundsException(String.format("imageIndex > %d: %d", this.frames.size(), n2));
    }

    private void readHeader() throws IOException {
        if (this.header != null) {
            return;
        }
        this.imageInput.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        this.imageInput.seek(0L);
        int n2 = this.imageInput.readInt();
        if (n2 != 1179011410) {
            throw new IIOException(String.format("Not a WebP file, invalid 'RIFF' magic: '%s'", WebPImageReader.fourCC(n2)));
        }
        this.fileSize = 8L + this.imageInput.readUnsignedInt();
        int n3 = this.imageInput.readInt();
        if (n3 != 1346520407) {
            throw new IIOException(String.format("Not a WebP file, invalid 'WEBP' magic: '%s'", WebPImageReader.fourCC(n3)));
        }
        int n4 = this.imageInput.readInt();
        long l2 = this.imageInput.readUnsignedInt();
        this.header = new VP8xChunk(n4, l2, this.imageInput.getStreamPosition());
        switch (n4) {
            case 540561494: {
                int n5 = this.lsbBitReader.readBit();
                if (n5 != 0) {
                    throw new IIOException("Unexpected WebP frame type, expected key frame (0): " + n5);
                }
                int n6 = (int)this.lsbBitReader.readBits(3);
                int n7 = this.lsbBitReader.readBit();
                if (DEBUG) {
                    System.out.println("versionNumber: " + n6);
                    System.out.println("showFrame: " + n7);
                }
                this.lsbBitReader.readBits(19);
                this.imageInput.readUnsignedByte();
                this.imageInput.readUnsignedByte();
                this.imageInput.readUnsignedByte();
                int n8 = this.imageInput.readUnsignedShort();
                this.header.width = n8 & 0x3FFF;
                int n9 = this.imageInput.readUnsignedShort();
                this.header.height = n9 & 0x3FFF;
                break;
            }
            case 1278758998: {
                byte by2 = this.imageInput.readByte();
                if (by2 != 47) {
                    throw new IIOException(String.format("Unexpected 'VP8L' signature, expected 0x0x%2x: 0x%2x", (byte)47, by2));
                }
                this.header.isLossless = true;
                this.header.width = 1 + (int)this.lsbBitReader.readBits(14);
                this.header.height = 1 + (int)this.lsbBitReader.readBits(14);
                this.header.containsALPH = this.lsbBitReader.readBit() == 1;
                int n10 = (int)this.lsbBitReader.readBits(3);
                if (n10 == 0) break;
                throw new IIOException(String.format("Unexpected 'VP8L' version, expected 0: %d", n10));
            }
            case 1480085590: {
                if (l2 != 10L) {
                    throw new IIOException("Unexpected 'VP8X' chunk length, expected 10: " + l2);
                }
                int n11 = this.lsbBitReader.readBit();
                if (n11 != 0) {
                    throw new IIOException(String.format("Unexpected 'VP8X' chunk reserved value, expected 0: %d", n11));
                }
                this.header.containsANIM = this.lsbBitReader.readBit() == 1;
                this.header.containsXMP_ = this.lsbBitReader.readBit() == 1;
                this.header.containsEXIF = this.lsbBitReader.readBit() == 1;
                this.header.containsALPH = this.lsbBitReader.readBit() == 1;
                this.header.containsICCP = this.lsbBitReader.readBit() == 1;
                n11 = (int)this.lsbBitReader.readBits(26);
                if (n11 != 0) {
                    throw new IIOException(String.format("Unexpected 'VP8X' chunk reserved value, expected 0: %d", n11));
                }
                this.header.width = 1 + (int)this.lsbBitReader.readBits(24);
                this.header.height = 1 + (int)this.lsbBitReader.readBits(24);
                if (!this.header.containsICCP) break;
                while (this.containedICCP == null && this.imageInput.getStreamPosition() < this.fileSize) {
                    int n12 = this.imageInput.readInt();
                    long l3 = this.imageInput.readUnsignedInt();
                    long l4 = this.imageInput.getStreamPosition();
                    if (n12 == 1346585417) {
                        this.containedICCP = ColorProfiles.readProfile(IIOUtil.createStreamAdapter(this.imageInput, l3));
                        if (this.containedICCP.getColorSpaceType() == 5) {
                            this.iccProfile = this.containedICCP;
                        } else {
                            this.processWarningOccurred("Encountered non-RGB ICC Profile, ignoring color profile, colors may appear incorrect");
                        }
                    } else {
                        this.processWarningOccurred(String.format("Expected 'ICCP' chunk, '%s' chunk encountered", WebPImageReader.fourCC(n12)));
                    }
                    this.imageInput.seek(l4 + l3 + (l3 & 1L));
                }
                break;
            }
            default: {
                throw new IIOException(String.format("Unknown WebP chunk: '%s'", WebPImageReader.fourCC(n4)));
            }
        }
        if (DEBUG) {
            System.out.println("file size: " + this.fileSize + " (stream length: " + this.imageInput.length() + ")");
            System.out.println("header: " + this.header);
        }
    }

    static String fourCC(int n2) {
        return new String(new byte[]{(byte)(n2 & 0xFF), (byte)((n2 & 0xFF00) >> 8), (byte)((n2 & 0xFF0000) >> 16), (byte)((n2 & 0xFF000000) >>> 24)}, StandardCharsets.US_ASCII);
    }

    @Override
    public int getNumImages(boolean bl2) throws IOException {
        this.assertInput();
        this.readHeader();
        if (this.header.containsANIM && bl2) {
            if (this.isSeekForwardOnly()) {
                throw new IllegalStateException("Illegal combination of allowSearch with seekForwardOnly");
            }
            this.readAllFrames();
            return this.frames.size();
        }
        return this.header.containsANIM ? -1 : 1;
    }

    private void readAllFrames() throws IOException {
        try {
            this.readFrame(Integer.MAX_VALUE);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
    }

    @Override
    public int getWidth(int n2) throws IOException {
        this.readHeader(n2);
        return this.header.containsANIM ? this.frames.get((int)n2).bounds.width : this.header.width;
    }

    @Override
    public int getHeight(int n2) throws IOException {
        this.readHeader(n2);
        return this.header.containsANIM ? this.frames.get((int)n2).bounds.height : this.header.height;
    }

    @Override
    public ImageTypeSpecifier getRawImageType(int n2) throws IOException {
        this.readHeader(n2);
        if (this.iccProfile != null && !ColorProfiles.isCS_sRGB(this.iccProfile)) {
            int[] nArray;
            ICC_ColorSpace iCC_ColorSpace = ColorSpaces.createColorSpace(this.iccProfile);
            if (this.header.containsALPH) {
                int[] nArray2 = new int[4];
                nArray2[0] = 0;
                nArray2[1] = 1;
                nArray2[2] = 2;
                nArray = nArray2;
                nArray2[3] = 3;
            } else {
                int[] nArray3 = new int[3];
                nArray3[0] = 0;
                nArray3[1] = 1;
                nArray = nArray3;
                nArray3[2] = 2;
            }
            int[] nArray4 = nArray;
            return ImageTypeSpecifiers.createInterleaved(iCC_ColorSpace, nArray4, 0, this.header.containsALPH, false);
        }
        return ImageTypeSpecifiers.createFromBufferedImageType(this.header.containsALPH ? 6 : 5);
    }

    @Override
    public Iterator<ImageTypeSpecifier> getImageTypes(int n2) throws IOException {
        ImageTypeSpecifier imageTypeSpecifier = this.getRawImageType(n2);
        ArrayList<ImageTypeSpecifier> arrayList = new ArrayList<ImageTypeSpecifier>();
        if (imageTypeSpecifier.getBufferedImageType() == 0) {
            arrayList.add(ImageTypeSpecifiers.createFromBufferedImageType(this.header.containsALPH ? 6 : 5));
        }
        arrayList.add(imageTypeSpecifier);
        arrayList.add(ImageTypeSpecifiers.createFromBufferedImageType(this.header.containsALPH ? 2 : 1));
        arrayList.add(ImageTypeSpecifiers.createFromBufferedImageType(this.header.containsALPH ? 3 : 4));
        return arrayList.iterator();
    }

    @Override
    public BufferedImage read(int n2, ImageReadParam imageReadParam) throws IOException {
        int n3 = this.getWidth(n2);
        int n4 = this.getHeight(n2);
        BufferedImage bufferedImage = WebPImageReader.getDestination(imageReadParam, this.getImageTypes(n2), n3, n4);
        this.processImageStarted(n2);
        switch (this.header.fourCC) {
            case 540561494: {
                this.imageInput.seek(this.header.offset);
                this.readVP8(RasterUtils.asByteRaster(bufferedImage.getRaster()), imageReadParam);
                break;
            }
            case 1278758998: {
                this.imageInput.seek(this.header.offset);
                this.readVP8Lossless(RasterUtils.asByteRaster(bufferedImage.getRaster()), imageReadParam);
                break;
            }
            case 1480085590: {
                if (this.header.containsANIM) {
                    AnimationFrame animationFrame = this.frames.get(n2);
                    this.imageInput.seek(animationFrame.offset + 16L);
                    this.readVP8Extended(bufferedImage, imageReadParam, animationFrame.offset + animationFrame.length, animationFrame.bounds.width, animationFrame.bounds.height);
                    break;
                }
                this.imageInput.seek(this.header.offset + this.header.length);
                this.readVP8Extended(bufferedImage, imageReadParam, this.fileSize);
                break;
            }
            default: {
                throw new IIOException("Unknown first chunk for WebP: " + WebPImageReader.fourCC(this.header.fourCC));
            }
        }
        this.applyICCProfileIfNeeded(bufferedImage);
        if (this.abortRequested()) {
            this.processReadAborted();
        } else {
            this.processImageComplete();
        }
        return bufferedImage;
    }

    private void readVP8Extended(BufferedImage bufferedImage, ImageReadParam imageReadParam, long l2) throws IOException {
        this.readVP8Extended(bufferedImage, imageReadParam, l2, this.header.width, this.header.height);
    }

    private void readVP8Extended(BufferedImage bufferedImage, ImageReadParam imageReadParam, long l2, int n2, int n3) throws IOException {
        boolean bl2 = false;
        while (this.imageInput.getStreamPosition() < l2) {
            int n4 = this.imageInput.readInt();
            long l3 = this.imageInput.readUnsignedInt();
            long l4 = this.imageInput.getStreamPosition();
            if (DEBUG) {
                System.out.printf("chunk: '%s'\n", WebPImageReader.fourCC(n4));
                System.out.println("chunkStart: " + l4);
                System.out.println("chunkLength: " + l3);
            }
            switch (n4) {
                case 1213221953: {
                    bl2 = true;
                    this.readAlpha(bufferedImage, imageReadParam, n2, n3);
                    break;
                }
                case 540561494: {
                    this.readVP8(RasterUtils.asByteRaster(bufferedImage.getRaster()).createWritableChild(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), 0, 0, new int[]{0, 1, 2}), imageReadParam);
                    if (!this.header.containsALPH || bl2) break;
                    this.opaqueAlpha(bufferedImage.getAlphaRaster());
                    break;
                }
                case 1278758998: {
                    this.readVP8Lossless(RasterUtils.asByteRaster(bufferedImage.getRaster()), imageReadParam, n2, n3);
                    break;
                }
                case 1179471425: 
                case 1296649793: {
                    if (!this.header.containsANIM) {
                        this.processWarningOccurred("Ignoring unsupported chunk: " + WebPImageReader.fourCC(n4));
                    }
                }
                case 542133592: 
                case 1179211845: 
                case 1346585417: {
                    break;
                }
                default: {
                    this.processWarningOccurred("Ignoring unexpected chunk: " + WebPImageReader.fourCC(n4));
                }
            }
            this.imageInput.seek(l4 + l3 + (l3 & 1L));
        }
    }

    private void readAlpha(BufferedImage bufferedImage, ImageReadParam imageReadParam, int n2, int n3) throws IOException {
        int n4 = (int)this.lsbBitReader.readBits(2);
        int n5 = (int)this.lsbBitReader.readBits(2);
        int n6 = (int)this.lsbBitReader.readBits(2);
        int n7 = (int)this.lsbBitReader.readBits(2);
        if (n7 != 0) {
            this.processWarningOccurred(String.format("Unexpected 'ALPH' chunk reserved value, expected 0: %d", n7));
        }
        if (DEBUG) {
            System.out.println("preProcessing: " + n6);
            System.out.println("filtering: " + n5);
            System.out.println("compression: " + n4);
        }
        WritableRaster writableRaster = bufferedImage.getAlphaRaster();
        switch (n4) {
            case 0: {
                this.readUncompressedAlpha(writableRaster);
                break;
            }
            case 1: {
                this.imageInput.seek(this.imageInput.getStreamPosition() - 5L);
                WritableRaster writableRaster2 = Raster.createInterleavedRaster(0, n2, n3, 4, null);
                this.readVP8Lossless(writableRaster2, null, n2, n3);
                WritableRaster writableRaster3 = writableRaster2.createWritableChild(0, 0, writableRaster2.getWidth(), writableRaster2.getHeight(), 0, 0, new int[]{1});
                this.alphaFilter(writableRaster3, n5);
                VP8LDecoder.copyIntoRasterWithParams(writableRaster3, writableRaster, imageReadParam);
                break;
            }
            default: {
                this.processWarningOccurred("Unknown WebP alpha compression: " + n4);
                this.opaqueAlpha(writableRaster);
            }
        }
    }

    private void alphaFilter(WritableRaster writableRaster, int n2) {
        if (n2 != 0) {
            for (int i2 = 0; i2 < writableRaster.getHeight(); ++i2) {
                for (int i3 = 0; i3 < writableRaster.getWidth(); ++i3) {
                    int n3 = this.getPredictorAlpha(writableRaster, n2, i2, i3);
                    writableRaster.setSample(i3, i2, 0, writableRaster.getSample(i3, i2, 0) + n3 % 256);
                }
            }
        }
    }

    private int getPredictorAlpha(WritableRaster writableRaster, int n2, int n3, int n4) {
        switch (n2) {
            case 0: {
                return 0;
            }
            case 1: {
                if (n4 == 0) {
                    return n3 == 0 ? 0 : writableRaster.getSample(0, n3 - 1, 0);
                }
                return writableRaster.getSample(n4 - 1, n3, 0);
            }
            case 2: {
                if (n3 == 0) {
                    return n4 == 0 ? 0 : writableRaster.getSample(n4 - 1, 0, 0);
                }
                return writableRaster.getSample(n4, n3 - 1, 0);
            }
            case 3: {
                if (n4 == 0) {
                    return n3 == 0 ? 0 : writableRaster.getSample(0, n3 - 1, 0);
                }
                if (n3 == 0) {
                    return writableRaster.getSample(n4 - 1, 0, 0);
                }
                int n5 = writableRaster.getSample(n4 - 1, n3, 0);
                int n6 = writableRaster.getSample(n4, n3 - 1, 0);
                int n7 = writableRaster.getSample(n4 - 1, n3 - 1, 0);
                return Math.max(0, Math.min(n5 + n6 - n7, 255));
            }
        }
        this.processWarningOccurred("Unknown WebP alpha filtering: " + n2);
        return 0;
    }

    private void applyICCProfileIfNeeded(BufferedImage bufferedImage) {
        ColorModel colorModel;
        ICC_Profile iCC_Profile;
        if (this.iccProfile != null && !this.iccProfile.equals(iCC_Profile = ((ICC_ColorSpace)(colorModel = bufferedImage.getColorModel()).getColorSpace()).getProfile())) {
            if (DEBUG) {
                System.err.println("Converting from " + this.iccProfile + " to " + (ColorProfiles.isCS_sRGB(iCC_Profile) ? "sRGB" : iCC_Profile));
            }
            WritableRaster writableRaster = colorModel.hasAlpha() ? bufferedImage.getRaster().createWritableChild(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), 0, 0, new int[]{0, 1, 2}) : bufferedImage.getRaster();
            new ColorConvertOp(new ICC_Profile[]{this.iccProfile, iCC_Profile}, null).filter(writableRaster, writableRaster);
        }
    }

    private void opaqueAlpha(WritableRaster writableRaster) {
        int n2 = writableRaster.getHeight();
        int n3 = writableRaster.getWidth();
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                writableRaster.setSample(i3, i2, 0, 255);
            }
        }
    }

    private void readUncompressedAlpha(WritableRaster writableRaster) throws IOException {
        this.processWarningOccurred("Uncompressed WebP alpha not implemented");
        this.opaqueAlpha(writableRaster);
    }

    private void readVP8Lossless(WritableRaster writableRaster, ImageReadParam imageReadParam) throws IOException {
        this.readVP8Lossless(writableRaster, imageReadParam, this.header.width, this.header.height);
    }

    private void readVP8Lossless(WritableRaster writableRaster, ImageReadParam imageReadParam, int n2, int n3) throws IOException {
        VP8LDecoder vP8LDecoder = new VP8LDecoder(this.imageInput, DEBUG);
        vP8LDecoder.readVP8Lossless(writableRaster, true, imageReadParam, n2, n3);
    }

    private void readVP8(WritableRaster writableRaster, ImageReadParam imageReadParam) throws IOException {
        VP8Frame vP8Frame = new VP8Frame(this.imageInput, DEBUG);
        vP8Frame.setProgressListener(new ProgressListenerBase(){

            @Override
            public void imageProgress(ImageReader imageReader, float f2) {
                WebPImageReader.this.processImageProgress(f2);
            }
        });
        if (!vP8Frame.decode(writableRaster, imageReadParam)) {
            this.processWarningOccurred("Nothing to decode");
        }
    }

    @Override
    public IIOMetadata getImageMetadata(int n2) throws IOException {
        return new WebPImageMetadata(this.getRawImageType(n2), this.header);
    }

    private void readMeta() throws IOException {
        if (this.header.containsEXIF || this.header.containsXMP_) {
            this.imageInput.seek(this.header.offset + this.header.length);
            while (this.imageInput.getStreamPosition() < this.fileSize) {
                int n2 = this.imageInput.readInt();
                long l2 = this.imageInput.readUnsignedInt();
                long l3 = this.imageInput.getStreamPosition();
                switch (n2) {
                    case 1179211845: {
                        int n3 = 0;
                        byte[] byArray = new byte[6];
                        this.imageInput.readFully(byArray);
                        if (byArray[0] == 69 && byArray[1] == 120 && byArray[2] == 105 && byArray[3] == 102 && byArray[4] == 0 && byArray[5] == 0) {
                            n3 = 6;
                        } else {
                            this.imageInput.seek(l3);
                        }
                        SubImageInputStream subImageInputStream = new SubImageInputStream(this.imageInput, l2 - (long)n3);
                        Directory directory = new TIFFReader().read(subImageInputStream);
                        if (!DEBUG) break;
                        System.out.println("exif: " + directory);
                        break;
                    }
                    case 542133592: {
                        Directory directory = new XMPReader().read(new SubImageInputStream(this.imageInput, l2));
                        if (!DEBUG) break;
                        System.out.println("xmp: " + directory);
                        break;
                    }
                }
                this.imageInput.seek(l3 + l2 + (l2 & 1L));
            }
        }
    }
}


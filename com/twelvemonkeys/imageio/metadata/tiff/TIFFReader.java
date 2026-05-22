/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.metadata.tiff;

import com.twelvemonkeys.imageio.metadata.Directory;
import com.twelvemonkeys.imageio.metadata.Entry;
import com.twelvemonkeys.imageio.metadata.MetadataReader;
import com.twelvemonkeys.imageio.metadata.tiff.IFD;
import com.twelvemonkeys.imageio.metadata.tiff.Rational;
import com.twelvemonkeys.imageio.metadata.tiff.TIFF;
import com.twelvemonkeys.imageio.metadata.tiff.TIFFDirectory;
import com.twelvemonkeys.imageio.metadata.tiff.TIFFEntry;
import com.twelvemonkeys.imageio.metadata.tiff.Unknown;
import com.twelvemonkeys.lang.StringUtil;
import com.twelvemonkeys.lang.Validate;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public final class TIFFReader
extends MetadataReader {
    static final boolean DEBUG = "true".equalsIgnoreCase(System.getProperty("com.twelvemonkeys.imageio.metadata.tiff.debug"));
    private static final Collection<Integer> VALID_TOP_LEVEL_IFDS = Collections.unmodifiableCollection(Arrays.asList(330, 34665, 34853));
    private static final Map<Integer, Collection<Integer>> VALID_SUB_IFDS = TIFFReader.createSubIFDMap();
    private final Set<Long> parsedIFDs = new TreeSet<Long>();
    private long inputLength;
    private boolean longOffsets;
    private int offsetSize;

    private static Map<Integer, Collection<Integer>> createSubIFDMap() {
        HashMap<Integer, Collection<Integer>> hashMap = new HashMap<Integer, Collection<Integer>>(){

            @Override
            public Collection<Integer> get(Object object) {
                Set<Integer> set = (Set<Integer>)super.get(object);
                return set != null ? set : Collections.emptySet();
            }
        };
        hashMap.put(330, Collections.singleton(330));
        hashMap.put(34665, Collections.singleton(40965));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override
    public Directory read(ImageInputStream imageInputStream) throws IOException {
        Validate.notNull(imageInputStream, "input");
        byte[] byArray = new byte[2];
        imageInputStream.readFully(byArray);
        if (byArray[0] == 73 && byArray[1] == 73) {
            imageInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        } else if (byArray[0] == 77 && byArray[1] == 77) {
            imageInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        } else {
            throw new IIOException(String.format("Invalid TIFF byte order mark '%s', expected: 'II' or 'MM'", StringUtil.decode(byArray, 0, byArray.length, "ASCII")));
        }
        int n2 = imageInputStream.readUnsignedShort();
        if (n2 == 42) {
            this.longOffsets = false;
            this.offsetSize = 4;
        } else if (n2 == 43) {
            this.longOffsets = true;
            this.offsetSize = 8;
            int n3 = imageInputStream.readUnsignedShort();
            if (n3 != 8) {
                throw new IIOException(String.format("Unexpected BigTIFF offset size: %04x, expected: %04x", n3, 8));
            }
            int n4 = imageInputStream.readUnsignedShort();
            if (n4 != 0) {
                throw new IIOException(String.format("Unexpected BigTIFF padding: %04x, expected: %04x", n4, 0));
            }
        } else {
            throw new IIOException(String.format("Wrong TIFF magic in input data: %04x, expected: %04x", n2, 42));
        }
        this.inputLength = imageInputStream.length();
        return this.readLinkedIFDs(imageInputStream);
    }

    private TIFFDirectory readLinkedIFDs(ImageInputStream imageInputStream) throws IOException {
        long l2 = this.readOffset(imageInputStream);
        ArrayList<IFD> arrayList = new ArrayList<IFD>();
        while (l2 != 0L) {
            try {
                if (this.inputLength > 0L && l2 >= this.inputLength || !this.isValidOffset(imageInputStream, l2) || !this.parsedIFDs.add(l2)) {
                    if (!DEBUG) break;
                    System.err.println("Bad IFD offset: " + l2);
                    break;
                }
                arrayList.add(this.readIFD(imageInputStream, l2, VALID_TOP_LEVEL_IFDS));
                l2 = this.readOffset(imageInputStream);
            }
            catch (EOFException eOFException) {
                l2 = 0L;
            }
        }
        return new TIFFDirectory((Collection<? extends Directory>)arrayList);
    }

    private long readOffset(ImageInputStream imageInputStream) throws IOException {
        return this.longOffsets ? imageInputStream.readLong() : imageInputStream.readUnsignedInt();
    }

    private IFD readIFD(ImageInputStream imageInputStream, long l2, Collection<Integer> collection) throws IOException {
        imageInputStream.seek(l2);
        long l3 = this.readEntryCount(imageInputStream);
        ArrayList<TIFFEntry> arrayList = new ArrayList<TIFFEntry>();
        int n2 = 0;
        while ((long)n2 < l3) {
            block3: {
                try {
                    TIFFEntry tIFFEntry = this.readEntry(imageInputStream);
                    if (tIFFEntry == null) break block3;
                    arrayList.add(tIFFEntry);
                }
                catch (IIOException iIOException) {
                    if (!DEBUG) break;
                    iIOException.printStackTrace();
                    break;
                }
            }
            ++n2;
        }
        this.readSubIFDs(imageInputStream, arrayList, collection);
        return new IFD(arrayList);
    }

    private long readEntryCount(ImageInputStream imageInputStream) throws IOException {
        return this.longOffsets ? imageInputStream.readLong() : (long)imageInputStream.readUnsignedShort();
    }

    private void readSubIFDs(ImageInputStream imageInputStream, List<TIFFEntry> list, Collection<Integer> collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        long l2 = imageInputStream.getStreamPosition();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            TIFFEntry tIFFEntry = list.get(i2);
            int n3 = (Integer)tIFFEntry.getIdentifier();
            if (!collection.contains(n3)) continue;
            try {
                long[] lArray = this.getPointerOffsets(tIFFEntry);
                ArrayList<IFD> arrayList = new ArrayList<IFD>(lArray.length);
                for (long l3 : lArray) {
                    try {
                        if (this.inputLength > 0L && l3 >= this.inputLength || !this.isValidOffset(imageInputStream, l3) || !this.parsedIFDs.add(l3)) {
                            if (!DEBUG) break;
                            System.err.println("Bad IFD offset: " + l3);
                            break;
                        }
                        arrayList.add(this.readIFD(imageInputStream, l3, VALID_SUB_IFDS.get(n3)));
                    }
                    catch (EOFException eOFException) {
                        if (!DEBUG) continue;
                        eOFException.printStackTrace();
                    }
                }
                if (arrayList.size() == 1) {
                    list.set(i2, new TIFFEntry(n3, tIFFEntry.getType(), arrayList.get(0)));
                    continue;
                }
                if (arrayList.isEmpty()) continue;
                list.set(i2, new TIFFEntry(n3, tIFFEntry.getType(), arrayList.toArray(new IFD[0])));
                continue;
            }
            catch (IIOException iIOException) {
                if (!DEBUG) continue;
                System.err.println("Error parsing sub-IFD: " + n3);
                iIOException.printStackTrace();
            }
        }
        imageInputStream.seek(l2);
    }

    private long[] getPointerOffsets(Entry entry) throws IIOException {
        long[] lArray;
        Object object = entry.getValue();
        if (object instanceof Byte) {
            lArray = new long[]{(Byte)object & 0xFF};
        } else if (object instanceof Short) {
            lArray = new long[]{(Short)object & 0xFFFF};
        } else if (object instanceof Integer) {
            lArray = new long[]{(long)((Integer)object).intValue() & 0xFFFFFFFFL};
        } else if (object instanceof Long) {
            lArray = new long[]{(Long)object};
        } else if (object instanceof long[]) {
            lArray = (long[])object;
        } else {
            throw new IIOException(String.format("Unknown pointer type: %s", object != null ? object.getClass() : null));
        }
        return lArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TIFFEntry readEntry(ImageInputStream imageInputStream) throws IOException {
        Object object;
        int n2 = imageInputStream.readUnsignedShort();
        short s2 = imageInputStream.readShort();
        int n3 = this.readValueCount(imageInputStream);
        if (n3 < 0) {
            throw new IIOException(String.format("Illegal count %d for tag %s type %s @%08x", n3, n2, s2, imageInputStream.getStreamPosition()));
        }
        if (!this.isValidType(s2)) {
            imageInputStream.skipBytes(4);
            if (DEBUG) {
                long l2 = imageInputStream.getStreamPosition() - 12L;
                System.err.printf("Bad TIFF data @%08x\n", imageInputStream.getStreamPosition());
                System.err.println("tagId: " + n2 + (n2 <= 0 ? " (INVALID)" : ""));
                System.err.println("type: " + s2 + " (INVALID)");
                System.err.println("count: " + n3);
                imageInputStream.mark();
                try {
                    imageInputStream.seek(l2);
                    byte[] byArray = new byte[8 + Math.min(120, Math.max(24, n3))];
                    int n4 = imageInputStream.read(byArray);
                    System.err.print(HexDump.dump(l2, byArray, 0, n4));
                    System.err.println(n4 < n3 ? "[...]" : "");
                }
                finally {
                    imageInputStream.reset();
                }
            }
            return null;
        }
        long l3 = TIFFEntry.getValueLength(s2, n3);
        if (l3 > 0L && l3 <= (long)this.offsetSize) {
            object = this.readValueInLine(imageInputStream, s2, n3);
            imageInputStream.skipBytes((long)this.offsetSize - l3);
        } else {
            long l4 = this.readOffset(imageInputStream);
            object = this.readValueAt(imageInputStream, l4, l3, s2, n3);
        }
        return new TIFFEntry(n2, s2, object);
    }

    private boolean isValidType(short s2) {
        return s2 > 0 && s2 < TIFF.TYPE_LENGTHS.length && TIFF.TYPE_LENGTHS[s2] > 0;
    }

    private int readValueCount(ImageInputStream imageInputStream) throws IOException {
        return this.assertIntCount(this.longOffsets ? imageInputStream.readLong() : imageInputStream.readUnsignedInt());
    }

    private int assertIntCount(long l2) throws IOException {
        if (l2 > Integer.MAX_VALUE) {
            throw new IIOException(String.format("Unsupported TIFF value count value: %s > Integer.MAX_VALUE", l2));
        }
        return (int)l2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isValidOffset(ImageInputStream imageInputStream, long l2) throws IOException {
        try {
            imageInputStream.mark();
            imageInputStream.seek(l2);
            boolean bl2 = imageInputStream.read() >= 0;
            return bl2;
        }
        catch (IOException iOException) {
            boolean bl3 = false;
            return bl3;
        }
        finally {
            imageInputStream.reset();
        }
    }

    private boolean isValidLengthAtOffset(ImageInputStream imageInputStream, long l2, long l3) throws IOException {
        return !(this.inputLength >= 0L && this.inputLength < l2 + l3 || l3 >= 32767L && !this.isValidOffset(imageInputStream, l2 + l3 - 1L));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Object readValueAt(ImageInputStream imageInputStream, long l2, long l3, short s2, int n2) throws IOException {
        long l4 = imageInputStream.getStreamPosition();
        try {
            imageInputStream.seek(l2);
            if (n2 < Integer.MAX_VALUE && this.isValidLengthAtOffset(imageInputStream, l2, l3)) {
                Object object = TIFFReader.readValue(imageInputStream, s2, n2, this.longOffsets);
                return object;
            }
            try {
                throw new EOFException(String.format("TIFF value offset or size too large: @%08x/%d bytes (input length: %s)", l2, l3, this.inputLength >= 0L ? this.inputLength + " bytes" : "unknown"));
            }
            catch (EOFException eOFException) {
                if (DEBUG) {
                    System.err.println(eOFException);
                }
                EOFException eOFException2 = eOFException;
                return eOFException2;
            }
        }
        finally {
            imageInputStream.seek(l4);
        }
    }

    private Object readValueInLine(ImageInputStream imageInputStream, short s2, int n2) throws IOException {
        return TIFFReader.readValue(imageInputStream, s2, n2, this.longOffsets);
    }

    private static Object readValue(ImageInputStream imageInputStream, short s2, int n2, boolean bl2) throws IOException {
        long l2 = imageInputStream.getStreamPosition();
        switch (s2) {
            case 2: {
                if (n2 == 0) {
                    return "";
                }
                byte[] byArray = new byte[n2];
                imageInputStream.readFully(byArray);
                int n3 = byArray[byArray.length - 1] == 0 ? byArray.length - 1 : byArray.length;
                String[] stringArray = new String(byArray, 0, n3, StandardCharsets.UTF_8).split("\u0000");
                return stringArray.length == 1 ? stringArray[0] : stringArray;
            }
            case 1: {
                if (n2 == 1) {
                    return imageInputStream.readUnsignedByte();
                }
            }
            case 6: {
                if (n2 == 1) {
                    return imageInputStream.readByte();
                }
            }
            case 7: {
                byte[] byArray = new byte[n2];
                imageInputStream.readFully(byArray);
                return byArray;
            }
            case 3: {
                if (n2 == 1) {
                    return imageInputStream.readUnsignedShort();
                }
            }
            case 8: {
                if (n2 == 1) {
                    return imageInputStream.readShort();
                }
                short[] sArray = new short[n2];
                imageInputStream.readFully(sArray, 0, sArray.length);
                if (s2 == 3) {
                    int[] nArray = new int[n2];
                    for (int i2 = 0; i2 < n2; ++i2) {
                        nArray[i2] = sArray[i2] & 0xFFFF;
                    }
                    return nArray;
                }
                return sArray;
            }
            case 4: 
            case 13: {
                if (n2 == 1) {
                    return imageInputStream.readUnsignedInt();
                }
            }
            case 9: {
                if (n2 == 1) {
                    return imageInputStream.readInt();
                }
                int[] nArray = new int[n2];
                imageInputStream.readFully(nArray, 0, nArray.length);
                if (s2 == 4 || s2 == 13) {
                    long[] lArray = new long[n2];
                    for (int i3 = 0; i3 < n2; ++i3) {
                        lArray[i3] = (long)nArray[i3] & 0xFFFFFFFFL;
                    }
                    return lArray;
                }
                return nArray;
            }
            case 11: {
                if (n2 == 1) {
                    return Float.valueOf(imageInputStream.readFloat());
                }
                float[] fArray = new float[n2];
                imageInputStream.readFully(fArray, 0, fArray.length);
                return fArray;
            }
            case 12: {
                if (n2 == 1) {
                    return imageInputStream.readDouble();
                }
                double[] dArray = new double[n2];
                imageInputStream.readFully(dArray, 0, dArray.length);
                return dArray;
            }
            case 5: {
                if (n2 == 1) {
                    return TIFFReader.createSafeRational(imageInputStream.readUnsignedInt(), imageInputStream.readUnsignedInt());
                }
                Rational[] rationalArray = new Rational[n2];
                for (int i4 = 0; i4 < rationalArray.length; ++i4) {
                    rationalArray[i4] = TIFFReader.createSafeRational(imageInputStream.readUnsignedInt(), imageInputStream.readUnsignedInt());
                }
                return rationalArray;
            }
            case 10: {
                if (n2 == 1) {
                    return TIFFReader.createSafeRational(imageInputStream.readInt(), imageInputStream.readInt());
                }
                Rational[] rationalArray = new Rational[n2];
                for (int i5 = 0; i5 < rationalArray.length; ++i5) {
                    rationalArray[i5] = TIFFReader.createSafeRational(imageInputStream.readInt(), imageInputStream.readInt());
                }
                return rationalArray;
            }
            case 16: 
            case 17: 
            case 18: {
                if (!bl2) break;
                if (n2 == 1) {
                    long l3 = imageInputStream.readLong();
                    if (s2 != 17 && l3 < 0L) {
                        throw new IIOException(String.format("Value > %s", Long.MAX_VALUE));
                    }
                    return l3;
                }
                long[] lArray = new long[n2];
                for (int i6 = 0; i6 < n2; ++i6) {
                    lArray[i6] = imageInputStream.readLong();
                }
                return lArray;
            }
        }
        return new Unknown(s2, n2, l2);
    }

    private static Rational createSafeRational(long l2, long l3) {
        if (l3 == 0L) {
            return Rational.NaN;
        }
        return new Rational(l2, l3);
    }

    public static void main(String[] stringArray) throws IOException {
        TIFFReader tIFFReader = new TIFFReader();
        try (ImageInputStream imageInputStream = ImageIO.createImageInputStream(new File(stringArray[0]));){
            long l2 = 0L;
            if (stringArray.length > 1) {
                l2 = stringArray[1].startsWith("0x") ? (long)Integer.parseInt(stringArray[1].substring(2), 16) : Long.parseLong(stringArray[1]);
                imageInputStream.setByteOrder(l2 < 0L ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                l2 = Math.abs(l2);
                imageInputStream.seek(l2);
            }
            Directory directory = stringArray.length > 1 ? tIFFReader.readIFD(imageInputStream, l2, VALID_TOP_LEVEL_IFDS) : tIFFReader.read(imageInputStream);
            for (Entry entry : directory) {
                System.err.println(entry);
                Object object = entry.getValue();
                if (!(object instanceof byte[])) continue;
                byte[] byArray = (byte[])object;
                System.err.println(HexDump.dump(0L, byArray, 0, Math.min(byArray.length, 128)));
            }
        }
    }

    public static class HexDump {
        private static final int WIDTH = 32;

        private HexDump() {
        }

        public static String dump(byte[] byArray) {
            return HexDump.dump(0L, byArray, 0, byArray.length);
        }

        public static String dump(long l2, byte[] byArray, int n2, int n3) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < n3; ++i2) {
                if (i2 % 32 == 0) {
                    if (i2 > 0) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(String.format("%08x: ", (long)(i2 + n2) + l2));
                } else if (i2 > 0 && i2 % 2 == 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(String.format("%02x", byArray[i2 + n2]));
                int n4 = i2 + 1;
                if (n4 % 32 != 0 && n4 != n3) continue;
                int n5 = (32 - n4 % 32) % 32;
                if (n5 != 0) {
                    int n6 = n5 / 2;
                    if (n3 % 2 != 0) {
                        stringBuilder.append("  ");
                    }
                    for (int i3 = 0; i3 < n6; ++i3) {
                        stringBuilder.append("     ");
                    }
                }
                stringBuilder.append("  ");
                stringBuilder.append(HexDump.toAsciiString(byArray, n4 - (32 - n5) + n2, n4 + n2));
            }
            return stringBuilder.toString();
        }

        private static String toAsciiString(byte[] byArray, int n2, int n3) {
            byte[] byArray2 = Arrays.copyOfRange(byArray, n2, n3);
            for (int i2 = 0; i2 < byArray2.length; ++i2) {
                if (byArray2[i2] >= 32 && byArray2[i2] <= 126) continue;
                byArray2[i2] = 46;
            }
            return new String(byArray2, StandardCharsets.US_ASCII);
        }
    }
}


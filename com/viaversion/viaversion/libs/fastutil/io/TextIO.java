/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.viaversion.viaversion.libs.fastutil.booleans.BooleanArrays
 *  com.viaversion.viaversion.libs.fastutil.booleans.BooleanIterable
 *  com.viaversion.viaversion.libs.fastutil.booleans.BooleanIterator
 *  com.viaversion.viaversion.libs.fastutil.bytes.ByteArrays
 *  com.viaversion.viaversion.libs.fastutil.bytes.ByteIterable
 *  com.viaversion.viaversion.libs.fastutil.bytes.ByteIterator
 *  com.viaversion.viaversion.libs.fastutil.doubles.DoubleArrays
 *  com.viaversion.viaversion.libs.fastutil.doubles.DoubleIterable
 *  com.viaversion.viaversion.libs.fastutil.doubles.DoubleIterator
 *  com.viaversion.viaversion.libs.fastutil.floats.FloatArrays
 *  com.viaversion.viaversion.libs.fastutil.floats.FloatIterable
 *  com.viaversion.viaversion.libs.fastutil.floats.FloatIterator
 *  com.viaversion.viaversion.libs.fastutil.io.TextIO$BooleanReaderWrapper
 *  com.viaversion.viaversion.libs.fastutil.io.TextIO$ByteReaderWrapper
 *  com.viaversion.viaversion.libs.fastutil.io.TextIO$DoubleReaderWrapper
 *  com.viaversion.viaversion.libs.fastutil.io.TextIO$FloatReaderWrapper
 *  com.viaversion.viaversion.libs.fastutil.io.TextIO$LongReaderWrapper
 *  com.viaversion.viaversion.libs.fastutil.io.TextIO$ShortReaderWrapper
 *  com.viaversion.viaversion.libs.fastutil.longs.LongArrays
 *  com.viaversion.viaversion.libs.fastutil.longs.LongIterable
 *  com.viaversion.viaversion.libs.fastutil.longs.LongIterator
 *  com.viaversion.viaversion.libs.fastutil.shorts.ShortArrays
 *  com.viaversion.viaversion.libs.fastutil.shorts.ShortIterable
 *  com.viaversion.viaversion.libs.fastutil.shorts.ShortIterator
 */
package com.viaversion.viaversion.libs.fastutil.io;

import com.viaversion.viaversion.libs.fastutil.BigArrays;
import com.viaversion.viaversion.libs.fastutil.booleans.BooleanArrays;
import com.viaversion.viaversion.libs.fastutil.booleans.BooleanIterable;
import com.viaversion.viaversion.libs.fastutil.booleans.BooleanIterator;
import com.viaversion.viaversion.libs.fastutil.bytes.ByteArrays;
import com.viaversion.viaversion.libs.fastutil.bytes.ByteIterable;
import com.viaversion.viaversion.libs.fastutil.bytes.ByteIterator;
import com.viaversion.viaversion.libs.fastutil.doubles.DoubleArrays;
import com.viaversion.viaversion.libs.fastutil.doubles.DoubleIterable;
import com.viaversion.viaversion.libs.fastutil.doubles.DoubleIterator;
import com.viaversion.viaversion.libs.fastutil.floats.FloatArrays;
import com.viaversion.viaversion.libs.fastutil.floats.FloatIterable;
import com.viaversion.viaversion.libs.fastutil.floats.FloatIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterable;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.io.FastBufferedOutputStream;
import com.viaversion.viaversion.libs.fastutil.io.TextIO;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterable;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.shorts.ShortArrays;
import com.viaversion.viaversion.libs.fastutil.shorts.ShortIterable;
import com.viaversion.viaversion.libs.fastutil.shorts.ShortIterator;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class TextIO {
    public static final int BUFFER_SIZE = 8192;

    private TextIO() {
    }

    public static int loadInts(BufferedReader reader, int[] array, int offset, int length) throws IOException {
        IntArrays.ensureOffsetLength(array, offset, length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Integer.parseInt(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadInts(BufferedReader reader, int[] array) throws IOException {
        return TextIO.loadInts(reader, array, 0, array.length);
    }

    public static int loadInts(File file, int[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadInts(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadInts(CharSequence filename, int[] array, int offset, int length) throws IOException {
        return TextIO.loadInts(new File(filename.toString()), array, offset, length);
    }

    public static int loadInts(File file, int[] array) throws IOException {
        return TextIO.loadInts(file, array, 0, array.length);
    }

    public static int loadInts(CharSequence filename, int[] array) throws IOException {
        return TextIO.loadInts(filename, array, 0, array.length);
    }

    public static void storeInts(int[] array, int offset, int length, PrintStream stream) {
        IntArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeInts(int[] array, PrintStream stream) {
        TextIO.storeInts(array, 0, array.length, stream);
    }

    public static void storeInts(int[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeInts(array, offset, length, stream);
        stream.close();
    }

    public static void storeInts(int[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeInts(array, offset, length, new File(filename.toString()));
    }

    public static void storeInts(int[] array, File file) throws IOException {
        TextIO.storeInts(array, 0, array.length, file);
    }

    public static void storeInts(int[] array, CharSequence filename) throws IOException {
        TextIO.storeInts(array, 0, array.length, filename);
    }

    public static void storeInts(IntIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextInt());
        }
    }

    public static void storeInts(IntIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeInts(i2, stream);
        stream.close();
    }

    public static void storeInts(IntIterator i2, CharSequence filename) throws IOException {
        TextIO.storeInts(i2, new File(filename.toString()));
    }

    public static long loadInts(BufferedReader reader, int[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                int[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Integer.parseInt(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadInts(BufferedReader reader, int[][] array) throws IOException {
        return TextIO.loadInts(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadInts(File file, int[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadInts(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadInts(CharSequence filename, int[][] array, long offset, long length) throws IOException {
        return TextIO.loadInts(new File(filename.toString()), array, offset, length);
    }

    public static long loadInts(File file, int[][] array) throws IOException {
        return TextIO.loadInts(file, array, 0L, BigArrays.length(array));
    }

    public static long loadInts(CharSequence filename, int[][] array) throws IOException {
        return TextIO.loadInts(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeInts(int[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            int[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeInts(int[][] array, PrintStream stream) {
        TextIO.storeInts(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeInts(int[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeInts(array, offset, length, stream);
        stream.close();
    }

    public static void storeInts(int[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeInts(array, offset, length, new File(filename.toString()));
    }

    public static void storeInts(int[][] array, File file) throws IOException {
        TextIO.storeInts(array, 0L, BigArrays.length(array), file);
    }

    public static void storeInts(int[][] array, CharSequence filename) throws IOException {
        TextIO.storeInts(array, 0L, BigArrays.length(array), filename);
    }

    public static IntIterator asIntIterator(BufferedReader reader) {
        return new IntReaderWrapper(reader);
    }

    public static IntIterator asIntIterator(File file) throws IOException {
        return new IntReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static IntIterator asIntIterator(CharSequence filename) throws IOException {
        return TextIO.asIntIterator(new File(filename.toString()));
    }

    public static IntIterable asIntIterable(File file) {
        return () -> {
            try {
                return TextIO.asIntIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static IntIterable asIntIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asIntIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static int loadLongs(BufferedReader reader, long[] array, int offset, int length) throws IOException {
        LongArrays.ensureOffsetLength((long[])array, (int)offset, (int)length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Long.parseLong(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadLongs(BufferedReader reader, long[] array) throws IOException {
        return TextIO.loadLongs(reader, array, 0, array.length);
    }

    public static int loadLongs(File file, long[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadLongs(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadLongs(CharSequence filename, long[] array, int offset, int length) throws IOException {
        return TextIO.loadLongs(new File(filename.toString()), array, offset, length);
    }

    public static int loadLongs(File file, long[] array) throws IOException {
        return TextIO.loadLongs(file, array, 0, array.length);
    }

    public static int loadLongs(CharSequence filename, long[] array) throws IOException {
        return TextIO.loadLongs(filename, array, 0, array.length);
    }

    public static void storeLongs(long[] array, int offset, int length, PrintStream stream) {
        LongArrays.ensureOffsetLength((long[])array, (int)offset, (int)length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeLongs(long[] array, PrintStream stream) {
        TextIO.storeLongs(array, 0, array.length, stream);
    }

    public static void storeLongs(long[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeLongs(array, offset, length, stream);
        stream.close();
    }

    public static void storeLongs(long[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeLongs(array, offset, length, new File(filename.toString()));
    }

    public static void storeLongs(long[] array, File file) throws IOException {
        TextIO.storeLongs(array, 0, array.length, file);
    }

    public static void storeLongs(long[] array, CharSequence filename) throws IOException {
        TextIO.storeLongs(array, 0, array.length, filename);
    }

    public static void storeLongs(LongIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextLong());
        }
    }

    public static void storeLongs(LongIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeLongs(i2, stream);
        stream.close();
    }

    public static void storeLongs(LongIterator i2, CharSequence filename) throws IOException {
        TextIO.storeLongs(i2, new File(filename.toString()));
    }

    public static long loadLongs(BufferedReader reader, long[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                long[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Long.parseLong(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadLongs(BufferedReader reader, long[][] array) throws IOException {
        return TextIO.loadLongs(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadLongs(File file, long[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadLongs(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadLongs(CharSequence filename, long[][] array, long offset, long length) throws IOException {
        return TextIO.loadLongs(new File(filename.toString()), array, offset, length);
    }

    public static long loadLongs(File file, long[][] array) throws IOException {
        return TextIO.loadLongs(file, array, 0L, BigArrays.length(array));
    }

    public static long loadLongs(CharSequence filename, long[][] array) throws IOException {
        return TextIO.loadLongs(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeLongs(long[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            long[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeLongs(long[][] array, PrintStream stream) {
        TextIO.storeLongs(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeLongs(long[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeLongs(array, offset, length, stream);
        stream.close();
    }

    public static void storeLongs(long[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeLongs(array, offset, length, new File(filename.toString()));
    }

    public static void storeLongs(long[][] array, File file) throws IOException {
        TextIO.storeLongs(array, 0L, BigArrays.length(array), file);
    }

    public static void storeLongs(long[][] array, CharSequence filename) throws IOException {
        TextIO.storeLongs(array, 0L, BigArrays.length(array), filename);
    }

    public static LongIterator asLongIterator(BufferedReader reader) {
        return new LongReaderWrapper(reader);
    }

    public static LongIterator asLongIterator(File file) throws IOException {
        return new LongReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static LongIterator asLongIterator(CharSequence filename) throws IOException {
        return TextIO.asLongIterator(new File(filename.toString()));
    }

    public static LongIterable asLongIterable(File file) {
        return () -> {
            try {
                return TextIO.asLongIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static LongIterable asLongIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asLongIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static int loadDoubles(BufferedReader reader, double[] array, int offset, int length) throws IOException {
        DoubleArrays.ensureOffsetLength((double[])array, (int)offset, (int)length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Double.parseDouble(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadDoubles(BufferedReader reader, double[] array) throws IOException {
        return TextIO.loadDoubles(reader, array, 0, array.length);
    }

    public static int loadDoubles(File file, double[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadDoubles(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadDoubles(CharSequence filename, double[] array, int offset, int length) throws IOException {
        return TextIO.loadDoubles(new File(filename.toString()), array, offset, length);
    }

    public static int loadDoubles(File file, double[] array) throws IOException {
        return TextIO.loadDoubles(file, array, 0, array.length);
    }

    public static int loadDoubles(CharSequence filename, double[] array) throws IOException {
        return TextIO.loadDoubles(filename, array, 0, array.length);
    }

    public static void storeDoubles(double[] array, int offset, int length, PrintStream stream) {
        DoubleArrays.ensureOffsetLength((double[])array, (int)offset, (int)length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeDoubles(double[] array, PrintStream stream) {
        TextIO.storeDoubles(array, 0, array.length, stream);
    }

    public static void storeDoubles(double[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeDoubles(array, offset, length, stream);
        stream.close();
    }

    public static void storeDoubles(double[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeDoubles(array, offset, length, new File(filename.toString()));
    }

    public static void storeDoubles(double[] array, File file) throws IOException {
        TextIO.storeDoubles(array, 0, array.length, file);
    }

    public static void storeDoubles(double[] array, CharSequence filename) throws IOException {
        TextIO.storeDoubles(array, 0, array.length, filename);
    }

    public static void storeDoubles(DoubleIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextDouble());
        }
    }

    public static void storeDoubles(DoubleIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeDoubles(i2, stream);
        stream.close();
    }

    public static void storeDoubles(DoubleIterator i2, CharSequence filename) throws IOException {
        TextIO.storeDoubles(i2, new File(filename.toString()));
    }

    public static long loadDoubles(BufferedReader reader, double[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                double[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Double.parseDouble(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadDoubles(BufferedReader reader, double[][] array) throws IOException {
        return TextIO.loadDoubles(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadDoubles(File file, double[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadDoubles(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadDoubles(CharSequence filename, double[][] array, long offset, long length) throws IOException {
        return TextIO.loadDoubles(new File(filename.toString()), array, offset, length);
    }

    public static long loadDoubles(File file, double[][] array) throws IOException {
        return TextIO.loadDoubles(file, array, 0L, BigArrays.length(array));
    }

    public static long loadDoubles(CharSequence filename, double[][] array) throws IOException {
        return TextIO.loadDoubles(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeDoubles(double[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            double[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeDoubles(double[][] array, PrintStream stream) {
        TextIO.storeDoubles(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeDoubles(double[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeDoubles(array, offset, length, stream);
        stream.close();
    }

    public static void storeDoubles(double[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeDoubles(array, offset, length, new File(filename.toString()));
    }

    public static void storeDoubles(double[][] array, File file) throws IOException {
        TextIO.storeDoubles(array, 0L, BigArrays.length(array), file);
    }

    public static void storeDoubles(double[][] array, CharSequence filename) throws IOException {
        TextIO.storeDoubles(array, 0L, BigArrays.length(array), filename);
    }

    public static DoubleIterator asDoubleIterator(BufferedReader reader) {
        return new DoubleReaderWrapper(reader);
    }

    public static DoubleIterator asDoubleIterator(File file) throws IOException {
        return new DoubleReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static DoubleIterator asDoubleIterator(CharSequence filename) throws IOException {
        return TextIO.asDoubleIterator(new File(filename.toString()));
    }

    public static DoubleIterable asDoubleIterable(File file) {
        return () -> {
            try {
                return TextIO.asDoubleIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static DoubleIterable asDoubleIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asDoubleIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static int loadBooleans(BufferedReader reader, boolean[] array, int offset, int length) throws IOException {
        BooleanArrays.ensureOffsetLength((boolean[])array, (int)offset, (int)length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Boolean.parseBoolean(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadBooleans(BufferedReader reader, boolean[] array) throws IOException {
        return TextIO.loadBooleans(reader, array, 0, array.length);
    }

    public static int loadBooleans(File file, boolean[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadBooleans(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadBooleans(CharSequence filename, boolean[] array, int offset, int length) throws IOException {
        return TextIO.loadBooleans(new File(filename.toString()), array, offset, length);
    }

    public static int loadBooleans(File file, boolean[] array) throws IOException {
        return TextIO.loadBooleans(file, array, 0, array.length);
    }

    public static int loadBooleans(CharSequence filename, boolean[] array) throws IOException {
        return TextIO.loadBooleans(filename, array, 0, array.length);
    }

    public static void storeBooleans(boolean[] array, int offset, int length, PrintStream stream) {
        BooleanArrays.ensureOffsetLength((boolean[])array, (int)offset, (int)length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeBooleans(boolean[] array, PrintStream stream) {
        TextIO.storeBooleans(array, 0, array.length, stream);
    }

    public static void storeBooleans(boolean[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeBooleans(array, offset, length, stream);
        stream.close();
    }

    public static void storeBooleans(boolean[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeBooleans(array, offset, length, new File(filename.toString()));
    }

    public static void storeBooleans(boolean[] array, File file) throws IOException {
        TextIO.storeBooleans(array, 0, array.length, file);
    }

    public static void storeBooleans(boolean[] array, CharSequence filename) throws IOException {
        TextIO.storeBooleans(array, 0, array.length, filename);
    }

    public static void storeBooleans(BooleanIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextBoolean());
        }
    }

    public static void storeBooleans(BooleanIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeBooleans(i2, stream);
        stream.close();
    }

    public static void storeBooleans(BooleanIterator i2, CharSequence filename) throws IOException {
        TextIO.storeBooleans(i2, new File(filename.toString()));
    }

    public static long loadBooleans(BufferedReader reader, boolean[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                boolean[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Boolean.parseBoolean(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadBooleans(BufferedReader reader, boolean[][] array) throws IOException {
        return TextIO.loadBooleans(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadBooleans(File file, boolean[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadBooleans(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadBooleans(CharSequence filename, boolean[][] array, long offset, long length) throws IOException {
        return TextIO.loadBooleans(new File(filename.toString()), array, offset, length);
    }

    public static long loadBooleans(File file, boolean[][] array) throws IOException {
        return TextIO.loadBooleans(file, array, 0L, BigArrays.length(array));
    }

    public static long loadBooleans(CharSequence filename, boolean[][] array) throws IOException {
        return TextIO.loadBooleans(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeBooleans(boolean[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            boolean[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeBooleans(boolean[][] array, PrintStream stream) {
        TextIO.storeBooleans(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeBooleans(boolean[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeBooleans(array, offset, length, stream);
        stream.close();
    }

    public static void storeBooleans(boolean[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeBooleans(array, offset, length, new File(filename.toString()));
    }

    public static void storeBooleans(boolean[][] array, File file) throws IOException {
        TextIO.storeBooleans(array, 0L, BigArrays.length(array), file);
    }

    public static void storeBooleans(boolean[][] array, CharSequence filename) throws IOException {
        TextIO.storeBooleans(array, 0L, BigArrays.length(array), filename);
    }

    public static BooleanIterator asBooleanIterator(BufferedReader reader) {
        return new BooleanReaderWrapper(reader);
    }

    public static BooleanIterator asBooleanIterator(File file) throws IOException {
        return new BooleanReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static BooleanIterator asBooleanIterator(CharSequence filename) throws IOException {
        return TextIO.asBooleanIterator(new File(filename.toString()));
    }

    public static BooleanIterable asBooleanIterable(File file) {
        return () -> {
            try {
                return TextIO.asBooleanIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static BooleanIterable asBooleanIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asBooleanIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static int loadBytes(BufferedReader reader, byte[] array, int offset, int length) throws IOException {
        ByteArrays.ensureOffsetLength((byte[])array, (int)offset, (int)length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Byte.parseByte(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadBytes(BufferedReader reader, byte[] array) throws IOException {
        return TextIO.loadBytes(reader, array, 0, array.length);
    }

    public static int loadBytes(File file, byte[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadBytes(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadBytes(CharSequence filename, byte[] array, int offset, int length) throws IOException {
        return TextIO.loadBytes(new File(filename.toString()), array, offset, length);
    }

    public static int loadBytes(File file, byte[] array) throws IOException {
        return TextIO.loadBytes(file, array, 0, array.length);
    }

    public static int loadBytes(CharSequence filename, byte[] array) throws IOException {
        return TextIO.loadBytes(filename, array, 0, array.length);
    }

    public static void storeBytes(byte[] array, int offset, int length, PrintStream stream) {
        ByteArrays.ensureOffsetLength((byte[])array, (int)offset, (int)length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeBytes(byte[] array, PrintStream stream) {
        TextIO.storeBytes(array, 0, array.length, stream);
    }

    public static void storeBytes(byte[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeBytes(array, offset, length, stream);
        stream.close();
    }

    public static void storeBytes(byte[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeBytes(array, offset, length, new File(filename.toString()));
    }

    public static void storeBytes(byte[] array, File file) throws IOException {
        TextIO.storeBytes(array, 0, array.length, file);
    }

    public static void storeBytes(byte[] array, CharSequence filename) throws IOException {
        TextIO.storeBytes(array, 0, array.length, filename);
    }

    public static void storeBytes(ByteIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextByte());
        }
    }

    public static void storeBytes(ByteIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeBytes(i2, stream);
        stream.close();
    }

    public static void storeBytes(ByteIterator i2, CharSequence filename) throws IOException {
        TextIO.storeBytes(i2, new File(filename.toString()));
    }

    public static long loadBytes(BufferedReader reader, byte[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                byte[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Byte.parseByte(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadBytes(BufferedReader reader, byte[][] array) throws IOException {
        return TextIO.loadBytes(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadBytes(File file, byte[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadBytes(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadBytes(CharSequence filename, byte[][] array, long offset, long length) throws IOException {
        return TextIO.loadBytes(new File(filename.toString()), array, offset, length);
    }

    public static long loadBytes(File file, byte[][] array) throws IOException {
        return TextIO.loadBytes(file, array, 0L, BigArrays.length(array));
    }

    public static long loadBytes(CharSequence filename, byte[][] array) throws IOException {
        return TextIO.loadBytes(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeBytes(byte[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            byte[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeBytes(byte[][] array, PrintStream stream) {
        TextIO.storeBytes(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeBytes(byte[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeBytes(array, offset, length, stream);
        stream.close();
    }

    public static void storeBytes(byte[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeBytes(array, offset, length, new File(filename.toString()));
    }

    public static void storeBytes(byte[][] array, File file) throws IOException {
        TextIO.storeBytes(array, 0L, BigArrays.length(array), file);
    }

    public static void storeBytes(byte[][] array, CharSequence filename) throws IOException {
        TextIO.storeBytes(array, 0L, BigArrays.length(array), filename);
    }

    public static ByteIterator asByteIterator(BufferedReader reader) {
        return new ByteReaderWrapper(reader);
    }

    public static ByteIterator asByteIterator(File file) throws IOException {
        return new ByteReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static ByteIterator asByteIterator(CharSequence filename) throws IOException {
        return TextIO.asByteIterator(new File(filename.toString()));
    }

    public static ByteIterable asByteIterable(File file) {
        return () -> {
            try {
                return TextIO.asByteIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static ByteIterable asByteIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asByteIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static int loadShorts(BufferedReader reader, short[] array, int offset, int length) throws IOException {
        ShortArrays.ensureOffsetLength((short[])array, (int)offset, (int)length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Short.parseShort(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadShorts(BufferedReader reader, short[] array) throws IOException {
        return TextIO.loadShorts(reader, array, 0, array.length);
    }

    public static int loadShorts(File file, short[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadShorts(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadShorts(CharSequence filename, short[] array, int offset, int length) throws IOException {
        return TextIO.loadShorts(new File(filename.toString()), array, offset, length);
    }

    public static int loadShorts(File file, short[] array) throws IOException {
        return TextIO.loadShorts(file, array, 0, array.length);
    }

    public static int loadShorts(CharSequence filename, short[] array) throws IOException {
        return TextIO.loadShorts(filename, array, 0, array.length);
    }

    public static void storeShorts(short[] array, int offset, int length, PrintStream stream) {
        ShortArrays.ensureOffsetLength((short[])array, (int)offset, (int)length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeShorts(short[] array, PrintStream stream) {
        TextIO.storeShorts(array, 0, array.length, stream);
    }

    public static void storeShorts(short[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeShorts(array, offset, length, stream);
        stream.close();
    }

    public static void storeShorts(short[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeShorts(array, offset, length, new File(filename.toString()));
    }

    public static void storeShorts(short[] array, File file) throws IOException {
        TextIO.storeShorts(array, 0, array.length, file);
    }

    public static void storeShorts(short[] array, CharSequence filename) throws IOException {
        TextIO.storeShorts(array, 0, array.length, filename);
    }

    public static void storeShorts(ShortIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextShort());
        }
    }

    public static void storeShorts(ShortIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeShorts(i2, stream);
        stream.close();
    }

    public static void storeShorts(ShortIterator i2, CharSequence filename) throws IOException {
        TextIO.storeShorts(i2, new File(filename.toString()));
    }

    public static long loadShorts(BufferedReader reader, short[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                short[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Short.parseShort(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadShorts(BufferedReader reader, short[][] array) throws IOException {
        return TextIO.loadShorts(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadShorts(File file, short[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadShorts(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadShorts(CharSequence filename, short[][] array, long offset, long length) throws IOException {
        return TextIO.loadShorts(new File(filename.toString()), array, offset, length);
    }

    public static long loadShorts(File file, short[][] array) throws IOException {
        return TextIO.loadShorts(file, array, 0L, BigArrays.length(array));
    }

    public static long loadShorts(CharSequence filename, short[][] array) throws IOException {
        return TextIO.loadShorts(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeShorts(short[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            short[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeShorts(short[][] array, PrintStream stream) {
        TextIO.storeShorts(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeShorts(short[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeShorts(array, offset, length, stream);
        stream.close();
    }

    public static void storeShorts(short[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeShorts(array, offset, length, new File(filename.toString()));
    }

    public static void storeShorts(short[][] array, File file) throws IOException {
        TextIO.storeShorts(array, 0L, BigArrays.length(array), file);
    }

    public static void storeShorts(short[][] array, CharSequence filename) throws IOException {
        TextIO.storeShorts(array, 0L, BigArrays.length(array), filename);
    }

    public static ShortIterator asShortIterator(BufferedReader reader) {
        return new ShortReaderWrapper(reader);
    }

    public static ShortIterator asShortIterator(File file) throws IOException {
        return new ShortReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static ShortIterator asShortIterator(CharSequence filename) throws IOException {
        return TextIO.asShortIterator(new File(filename.toString()));
    }

    public static ShortIterable asShortIterable(File file) {
        return () -> {
            try {
                return TextIO.asShortIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static ShortIterable asShortIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asShortIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static int loadFloats(BufferedReader reader, float[] array, int offset, int length) throws IOException {
        FloatArrays.ensureOffsetLength((float[])array, (int)offset, (int)length);
        int i2 = 0;
        try {
            String s2;
            for (i2 = 0; i2 < length && (s2 = reader.readLine()) != null; ++i2) {
                array[i2 + offset] = Float.parseFloat(s2.trim());
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return i2;
    }

    public static int loadFloats(BufferedReader reader, float[] array) throws IOException {
        return TextIO.loadFloats(reader, array, 0, array.length);
    }

    public static int loadFloats(File file, float[] array, int offset, int length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int result = TextIO.loadFloats(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static int loadFloats(CharSequence filename, float[] array, int offset, int length) throws IOException {
        return TextIO.loadFloats(new File(filename.toString()), array, offset, length);
    }

    public static int loadFloats(File file, float[] array) throws IOException {
        return TextIO.loadFloats(file, array, 0, array.length);
    }

    public static int loadFloats(CharSequence filename, float[] array) throws IOException {
        return TextIO.loadFloats(filename, array, 0, array.length);
    }

    public static void storeFloats(float[] array, int offset, int length, PrintStream stream) {
        FloatArrays.ensureOffsetLength((float[])array, (int)offset, (int)length);
        for (int i2 = 0; i2 < length; ++i2) {
            stream.println(array[offset + i2]);
        }
    }

    public static void storeFloats(float[] array, PrintStream stream) {
        TextIO.storeFloats(array, 0, array.length, stream);
    }

    public static void storeFloats(float[] array, int offset, int length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeFloats(array, offset, length, stream);
        stream.close();
    }

    public static void storeFloats(float[] array, int offset, int length, CharSequence filename) throws IOException {
        TextIO.storeFloats(array, offset, length, new File(filename.toString()));
    }

    public static void storeFloats(float[] array, File file) throws IOException {
        TextIO.storeFloats(array, 0, array.length, file);
    }

    public static void storeFloats(float[] array, CharSequence filename) throws IOException {
        TextIO.storeFloats(array, 0, array.length, filename);
    }

    public static void storeFloats(FloatIterator i2, PrintStream stream) {
        while (i2.hasNext()) {
            stream.println(i2.nextFloat());
        }
    }

    public static void storeFloats(FloatIterator i2, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeFloats(i2, stream);
        stream.close();
    }

    public static void storeFloats(FloatIterator i2, CharSequence filename) throws IOException {
        TextIO.storeFloats(i2, new File(filename.toString()));
    }

    public static long loadFloats(BufferedReader reader, float[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        long c2 = 0L;
        try {
            for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
                float[] t2 = array[i2];
                int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
                for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                    String s2 = reader.readLine();
                    if (s2 == null) {
                        return c2;
                    }
                    t2[d2] = Float.parseFloat(s2.trim());
                    ++c2;
                }
            }
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        return c2;
    }

    public static long loadFloats(BufferedReader reader, float[][] array) throws IOException {
        return TextIO.loadFloats(reader, array, 0L, BigArrays.length(array));
    }

    public static long loadFloats(File file, float[][] array, long offset, long length) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        long result = TextIO.loadFloats(reader, array, offset, length);
        reader.close();
        return result;
    }

    public static long loadFloats(CharSequence filename, float[][] array, long offset, long length) throws IOException {
        return TextIO.loadFloats(new File(filename.toString()), array, offset, length);
    }

    public static long loadFloats(File file, float[][] array) throws IOException {
        return TextIO.loadFloats(file, array, 0L, BigArrays.length(array));
    }

    public static long loadFloats(CharSequence filename, float[][] array) throws IOException {
        return TextIO.loadFloats(filename, array, 0L, BigArrays.length(array));
    }

    public static void storeFloats(float[][] array, long offset, long length, PrintStream stream) {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i2 = BigArrays.segment(offset); i2 < BigArrays.segment(offset + length + 0x7FFFFFFL); ++i2) {
            float[] t2 = array[i2];
            int l2 = (int)Math.min((long)t2.length, offset + length - BigArrays.start(i2));
            for (int d2 = (int)Math.max(0L, offset - BigArrays.start(i2)); d2 < l2; ++d2) {
                stream.println(t2[d2]);
            }
        }
    }

    public static void storeFloats(float[][] array, PrintStream stream) {
        TextIO.storeFloats(array, 0L, BigArrays.length(array), stream);
    }

    public static void storeFloats(float[][] array, long offset, long length, File file) throws IOException {
        PrintStream stream = new PrintStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        TextIO.storeFloats(array, offset, length, stream);
        stream.close();
    }

    public static void storeFloats(float[][] array, long offset, long length, CharSequence filename) throws IOException {
        TextIO.storeFloats(array, offset, length, new File(filename.toString()));
    }

    public static void storeFloats(float[][] array, File file) throws IOException {
        TextIO.storeFloats(array, 0L, BigArrays.length(array), file);
    }

    public static void storeFloats(float[][] array, CharSequence filename) throws IOException {
        TextIO.storeFloats(array, 0L, BigArrays.length(array), filename);
    }

    public static FloatIterator asFloatIterator(BufferedReader reader) {
        return new FloatReaderWrapper(reader);
    }

    public static FloatIterator asFloatIterator(File file) throws IOException {
        return new FloatReaderWrapper(new BufferedReader(new FileReader(file)));
    }

    public static FloatIterator asFloatIterator(CharSequence filename) throws IOException {
        return TextIO.asFloatIterator(new File(filename.toString()));
    }

    public static FloatIterable asFloatIterable(File file) {
        return () -> {
            try {
                return TextIO.asFloatIterator(file);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    public static FloatIterable asFloatIterable(CharSequence filename) {
        return () -> {
            try {
                return TextIO.asFloatIterator(filename);
            }
            catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        };
    }

    private static final class IntReaderWrapper
    implements IntIterator {
        private final BufferedReader reader;
        private boolean toAdvance = true;
        private String s;
        private int next;

        public IntReaderWrapper(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public boolean hasNext() {
            if (!this.toAdvance) {
                return this.s != null;
            }
            this.toAdvance = false;
            try {
                this.s = this.reader.readLine();
            }
            catch (EOFException eOFException) {
            }
            catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            if (this.s == null) {
                return false;
            }
            this.next = Integer.parseInt(this.s.trim());
            return true;
        }

        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }
}


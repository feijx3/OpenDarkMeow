/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.stream;

import com.twelvemonkeys.imageio.stream.Cache;
import com.twelvemonkeys.lang.Validate;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.imageio.stream.ImageInputStreamImpl;

final class BufferedChannelImageInputStream
extends ImageInputStreamImpl {
    private static final Closeable CLOSEABLE_STUB = new Closeable(){

        @Override
        public void close() {
        }
    };
    static final int DEFAULT_BUFFER_SIZE = 8192;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
    private byte[] buffer = this.byteBuffer.array();
    private int bufferPos;
    private int bufferLimit;
    private final ByteBuffer integralCache = ByteBuffer.allocate(8);
    private final byte[] integralCacheArray = this.integralCache.array();
    private SeekableByteChannel channel;
    private Closeable closeable;

    public BufferedChannelImageInputStream(File file) throws IOException {
        this(Validate.notNull(file, "file").toPath());
    }

    public BufferedChannelImageInputStream(Path path) throws IOException {
        this(FileChannel.open(Validate.notNull(path, "file"), StandardOpenOption.READ), true);
    }

    public BufferedChannelImageInputStream(RandomAccessFile randomAccessFile) {
        this(Validate.notNull(randomAccessFile, "file").getChannel(), true);
    }

    public BufferedChannelImageInputStream(FileInputStream fileInputStream) {
        this(Validate.notNull(fileInputStream, "inputStream").getChannel(), false);
    }

    public BufferedChannelImageInputStream(SeekableByteChannel seekableByteChannel) {
        this(Validate.notNull(seekableByteChannel, "channel"), false);
    }

    BufferedChannelImageInputStream(Cache cache2) {
        this(Validate.notNull(cache2, "cache"), true);
    }

    private BufferedChannelImageInputStream(SeekableByteChannel seekableByteChannel, boolean bl2) {
        this.channel = Validate.notNull(seekableByteChannel, "channel");
        this.closeable = bl2 ? this.channel : CLOSEABLE_STUB;
    }

    private boolean fillBuffer() throws IOException {
        this.byteBuffer.rewind();
        int n2 = this.channel.read(this.byteBuffer);
        this.bufferPos = 0;
        this.bufferLimit = Math.max(n2, 0);
        return this.bufferLimit > 0;
    }

    private boolean bufferEmpty() {
        return this.bufferPos >= this.bufferLimit;
    }

    @Override
    public void setByteOrder(ByteOrder byteOrder) {
        super.setByteOrder(byteOrder);
        this.integralCache.order(byteOrder);
    }

    @Override
    public int read() throws IOException {
        this.checkClosed();
        if (this.bufferEmpty() && !this.fillBuffer()) {
            return -1;
        }
        this.bitOffset = 0;
        ++this.streamPos;
        return this.buffer[this.bufferPos++] & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) throws IOException {
        int n4;
        this.checkClosed();
        this.bitOffset = 0;
        if (this.bufferEmpty()) {
            if (n3 >= this.buffer.length) {
                return this.readDirect(byArray, n2, n3);
            }
            if (!this.fillBuffer()) {
                return -1;
            }
        }
        if (n3 > (n4 = this.readBuffered(byArray, n2, n3))) {
            return n4 + Math.max(0, this.readDirect(byArray, n2 + n4, n3 - n4));
        }
        return n4;
    }

    private int readDirect(byte[] byArray, int n2, int n3) throws IOException {
        this.bufferLimit = 0;
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray, n2, n3);
        int n4 = 0;
        while (byteBuffer.hasRemaining()) {
            int n5 = this.channel.read(byteBuffer);
            if (n5 == -1) {
                if (n4 != 0) break;
                return -1;
            }
            n4 += n5;
        }
        this.streamPos += (long)n4;
        return n4;
    }

    private int readBuffered(byte[] byArray, int n2, int n3) {
        int n4 = Math.min(this.bufferLimit - this.bufferPos, n3);
        if (n4 > 0) {
            System.arraycopy(this.buffer, this.bufferPos, byArray, n2, n4);
            this.bufferPos += n4;
            this.streamPos += (long)n4;
        }
        return n4;
    }

    @Override
    public long length() {
        try {
            this.checkClosed();
            return this.channel.size();
        }
        catch (IOException iOException) {
            return -1L;
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
        this.buffer = null;
        this.byteBuffer = null;
        this.channel = null;
        try {
            this.closeable.close();
        }
        finally {
            this.closeable = null;
        }
    }

    @Override
    public short readShort() throws IOException {
        this.readFully(this.integralCacheArray, 0, 2);
        return this.integralCache.getShort(0);
    }

    @Override
    public int readInt() throws IOException {
        this.readFully(this.integralCacheArray, 0, 4);
        return this.integralCache.getInt(0);
    }

    @Override
    public long readLong() throws IOException {
        this.readFully(this.integralCacheArray, 0, 8);
        return this.integralCache.getLong(0);
    }

    @Override
    public void seek(long l2) throws IOException {
        this.checkClosed();
        if (l2 < this.flushedPos) {
            throw new IndexOutOfBoundsException("position < flushedPos!");
        }
        this.bitOffset = 0;
        if (this.streamPos == l2) {
            return;
        }
        long l3 = (long)this.bufferPos + l2 - this.streamPos;
        if (l3 >= 0L && l3 < (long)this.bufferLimit) {
            this.bufferPos = (int)l3;
        } else {
            this.bufferLimit = 0;
            this.channel.position(l2);
        }
        this.streamPos = l2;
    }

    @Override
    public void flushBefore(long l2) throws IOException {
        super.flushBefore(l2);
        if (this.channel instanceof Cache) {
            ((Cache)this.channel).flushBefore(l2);
        }
    }
}


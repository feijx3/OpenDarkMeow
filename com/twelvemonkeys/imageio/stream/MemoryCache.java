/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.stream;

import com.twelvemonkeys.imageio.stream.Cache;
import com.twelvemonkeys.lang.Validate;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

final class MemoryCache
implements Cache {
    static final int BLOCK_SIZE = 8192;
    private static final byte[] NULL_BLOCK = new byte[0];
    private final List<byte[]> cache = new ArrayList<byte[]>();
    private final ReadableByteChannel channel;
    private int maxBlock = Integer.MAX_VALUE;
    private long length;
    private long position;
    private long start;

    MemoryCache(InputStream inputStream) {
        this(Channels.newChannel(Validate.notNull(inputStream, "stream")));
    }

    public MemoryCache(ReadableByteChannel readableByteChannel) {
        this.channel = Validate.notNull(readableByteChannel, "channel");
    }

    byte[] fetchBlock() throws IOException {
        long l2 = this.position;
        long l3 = l2 / 8192L;
        if (l3 >= Integer.MAX_VALUE) {
            throw new IOException("Memory cache max size exceeded");
        }
        if (l3 > (long)this.maxBlock) {
            return NULL_BLOCK;
        }
        while (l3 >= (long)this.cache.size()) {
            byte[] byArray;
            try {
                byArray = new byte[8192];
            }
            catch (OutOfMemoryError outOfMemoryError) {
                throw new IOException("No more memory for cache: " + this.cache.size() * 8192);
            }
            this.cache.add(byArray);
            int n2 = this.readBlock(byArray);
            this.length += (long)n2;
            if (n2 >= 8192) continue;
            this.maxBlock = (int)l3;
            return byArray;
        }
        return this.cache.get((int)l3);
    }

    private int readBlock(byte[] byArray) throws IOException {
        int n2;
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        while (byteBuffer.hasRemaining() && (n2 = this.channel.read(byteBuffer)) != -1) {
        }
        return byteBuffer.position();
    }

    @Override
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override
    public void close() throws IOException {
        this.cache.clear();
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        byte[] byArray = this.fetchBlock();
        if (this.position >= this.length) {
            return -1;
        }
        int n2 = (int)(this.position % 8192L);
        int n3 = Math.min(byteBuffer.remaining(), (int)Math.min((long)(8192 - n2), this.length - this.position));
        byteBuffer.put(byArray, n2, n3);
        this.position += (long)n3;
        return n3;
    }

    @Override
    public long position() throws IOException {
        return this.position;
    }

    @Override
    public SeekableByteChannel position(long l2) throws IOException {
        if (l2 < this.start) {
            throw new IOException("Seek before flush position");
        }
        this.position = l2;
        return this;
    }

    @Override
    public long size() throws IOException {
        return -1L;
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    @Override
    public SeekableByteChannel truncate(long l2) {
        throw new NonWritableChannelException();
    }

    @Override
    public void flushBefore(long l2) {
        if (l2 < this.start) {
            throw new IndexOutOfBoundsException("pos < flushed position");
        }
        if (l2 > this.position) {
            throw new IndexOutOfBoundsException("pos > current position");
        }
        int n2 = (int)(l2 / 8192L);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.cache.set(i2, null);
        }
        this.start = l2;
    }
}


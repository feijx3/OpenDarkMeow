/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.stream;

import com.twelvemonkeys.imageio.stream.Cache;
import com.twelvemonkeys.lang.Validate;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;

final class FileCache
implements Cache {
    static final int BLOCK_SIZE = 8192;
    private final FileChannel cache;
    private final ReadableByteChannel channel;

    FileCache(InputStream inputStream, File file) throws IOException {
        this(Channels.newChannel(Validate.notNull(inputStream, "stream")), file);
    }

    public FileCache(ReadableByteChannel readableByteChannel, File file) throws IOException {
        this.channel = Validate.notNull(readableByteChannel, "channel");
        Validate.isTrue(file == null || file.isDirectory(), file, "%s is not a directory");
        Path path = file == null ? Files.createTempFile("imageio", ".tmp", new FileAttribute[0]) : Files.createTempFile(file.toPath(), "imageio", ".tmp", new FileAttribute[0]);
        this.cache = FileChannel.open(path, StandardOpenOption.DELETE_ON_CLOSE, StandardOpenOption.READ, StandardOpenOption.WRITE);
    }

    void fetch() throws IOException {
        while (this.cache.position() >= this.cache.size() && this.cache.transferFrom(this.channel, this.cache.size(), Math.max(this.cache.position() - this.cache.size(), 8192L)) > 0L) {
        }
    }

    @Override
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override
    public void close() throws IOException {
        this.cache.close();
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        this.fetch();
        if (this.cache.position() >= this.cache.size()) {
            return -1;
        }
        return this.cache.read(byteBuffer);
    }

    @Override
    public long position() throws IOException {
        return this.cache.position();
    }

    @Override
    public SeekableByteChannel position(long l2) throws IOException {
        this.cache.position(l2);
        return this;
    }

    @Override
    public long size() {
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
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.imageio.stream;

import java.nio.channels.SeekableByteChannel;

interface Cache
extends SeekableByteChannel {
    public void flushBefore(long var1);
}


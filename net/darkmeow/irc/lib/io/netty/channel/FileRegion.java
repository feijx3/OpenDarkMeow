/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import net.darkmeow.irc.lib.io.netty.util.ReferenceCounted;

public interface FileRegion
extends ReferenceCounted {
    public long position();

    @Deprecated
    public long transfered();

    public long transferred();

    public long count();

    public long transferTo(WritableByteChannel var1, long var2) throws IOException;

    @Override
    public FileRegion retain();

    @Override
    public FileRegion retain(int var1);

    @Override
    public FileRegion touch();

    @Override
    public FileRegion touch(Object var1);
}


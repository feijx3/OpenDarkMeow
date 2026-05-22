/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketKeepAlive;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacket;", "timeSeconds", "", "timeNanos", "", "sequence", "<init>", "(JII)V", "getTimeSeconds", "()J", "getTimeNanos", "()I", "getSequence", "write", "", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "DarkMeow"})
public final class SFC2SPacketKeepAlive
extends SFC2SPacket {
    private final long timeSeconds;
    private final int timeNanos;
    private final int sequence;

    public SFC2SPacketKeepAlive(long timeSeconds, int timeNanos, int sequence) {
        super(1);
        this.timeSeconds = timeSeconds;
        this.timeNanos = timeNanos;
        this.sequence = sequence;
    }

    public final long getTimeSeconds() {
        return this.timeSeconds;
    }

    public final int getTimeNanos() {
        return this.timeNanos;
    }

    public final int getSequence() {
        return this.sequence;
    }

    @Override
    public void write(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeLong(this.timeSeconds);
        buf.writeInt(this.timeNanos);
        buf.writeInt(this.sequence);
    }
}


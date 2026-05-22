/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "", "wrapped", "Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;", "<init>", "(Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;)V", "getWrapped", "()Lnet/darkmeow/irc/lib/io/netty/buffer/ByteBuf;", "readBoolean", "", "writeBoolean", "", "data", "readInt", "", "writeInt", "readLong", "", "writeLong", "writeByte", "writeBytes", "", "readString", "", "writeString", "readUUID", "Ljava/util/UUID;", "writeUUID", "Companion", "DarkMeow"})
public final class SilenceFixNettyBuffer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ByteBuf wrapped;

    public SilenceFixNettyBuffer(@NotNull ByteBuf wrapped) {
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        this.wrapped = wrapped;
    }

    @NotNull
    public final ByteBuf getWrapped() {
        return this.wrapped;
    }

    public final boolean readBoolean() {
        return this.wrapped.readBoolean();
    }

    public final void writeBoolean(boolean data) {
        this.wrapped.writeBoolean(data);
    }

    public final int readInt() {
        return this.wrapped.readInt();
    }

    public final void writeInt(int data) {
        this.wrapped.writeInt(data);
    }

    public final long readLong() {
        return this.wrapped.readLong();
    }

    public final void writeLong(long data) {
        this.wrapped.writeLong(data);
    }

    public final void writeByte(int data) {
        this.wrapped.writeByte(data);
    }

    public final void writeBytes(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.wrapped.writeBytes(data);
    }

    @NotNull
    public final String readString() {
        byte[] byArray;
        if (this.wrapped.readableBytes() < 4) {
            throw new IllegalStateException("Can't read utf bytes length because readableBytes < 4");
        }
        int length = this.wrapped.readInt();
        if (length < 0) {
            throw new IllegalStateException("Can't read utf bytes because length < 0");
        }
        byte[] $this$readString_u24lambda_u240 = byArray = new byte[length];
        boolean bl2 = false;
        this.wrapped.readBytes($this$readString_u24lambda_u240);
        Charset charset = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
        Charset charset2 = charset;
        return new String(byArray, charset2);
    }

    public final void writeString(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String string = data;
        Charset charset = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
        byte[] byArray = string.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(byArray, "getBytes(...)");
        byte[] bytes = byArray;
        this.wrapped.writeInt(bytes.length);
        this.wrapped.writeBytes(bytes);
    }

    @NotNull
    public final UUID readUUID() {
        return new UUID(this.wrapped.readLong(), this.wrapped.readLong());
    }

    public final void writeUUID(@NotNull UUID data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.wrapped.writeLong(data.getMostSignificantBits());
        this.wrapped.writeLong(data.getLeastSignificantBits());
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer$Companion;", "", "<init>", "()V", "create", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SilenceFixNettyBuffer create() {
            ByteBuf byteBuf = Unpooled.buffer();
            Intrinsics.checkNotNullExpressionValue(byteBuf, "buffer(...)");
            return new SilenceFixNettyBuffer(byteBuf);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s;

import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketHandShake;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacket;", "verifyMessage", "", "key", "Ljavax/crypto/SecretKey;", "<init>", "(Ljava/lang/String;Ljavax/crypto/SecretKey;)V", "getVerifyMessage", "()Ljava/lang/String;", "getKey", "()Ljavax/crypto/SecretKey;", "write", "", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "DarkMeow"})
public final class SFC2SPacketHandShake
extends SFC2SPacket {
    @NotNull
    private final String verifyMessage;
    @NotNull
    private final SecretKey key;

    public SFC2SPacketHandShake(@NotNull String verifyMessage, @NotNull SecretKey key) {
        Intrinsics.checkNotNullParameter(verifyMessage, "verifyMessage");
        Intrinsics.checkNotNullParameter(key, "key");
        super(0);
        this.verifyMessage = verifyMessage;
        this.key = key;
    }

    @NotNull
    public final String getVerifyMessage() {
        return this.verifyMessage;
    }

    @NotNull
    public final SecretKey getKey() {
        return this.key;
    }

    @Override
    public void write(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeString(this.verifyMessage);
        byte[] byArray = this.key.getEncoded();
        Intrinsics.checkNotNullExpressionValue(byArray, "getEncoded(...)");
        buf.writeBytes(byArray);
    }
}


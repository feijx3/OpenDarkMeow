/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFConfig;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.packet.c2s.SFC2SPacket;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.utils.SilenceFixNettyBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacketLogin;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/packet/c2s/SFC2SPacket;", "username", "", "password", "hardwareUniqueId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "config", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFConfig;)V", "getUsername", "()Ljava/lang/String;", "getPassword", "getHardwareUniqueId", "write", "", "buf", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/utils/SilenceFixNettyBuffer;", "DarkMeow"})
public final class SFC2SPacketLogin
extends SFC2SPacket {
    @NotNull
    private final String username;
    @NotNull
    private final String password;
    @NotNull
    private final String hardwareUniqueId;

    public SFC2SPacketLogin(@NotNull String username, @NotNull String password, @NotNull String hardwareUniqueId) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(hardwareUniqueId, "hardwareUniqueId");
        super(3);
        this.username = username;
        this.password = password;
        this.hardwareUniqueId = hardwareUniqueId;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    @NotNull
    public final String getHardwareUniqueId() {
        return this.hardwareUniqueId;
    }

    public SFC2SPacketLogin(@NotNull SFConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this(config.getUsername(), config.getPassword(), config.getHardwareUniqueId());
    }

    @Override
    public void write(@NotNull SilenceFixNettyBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        buf.writeString(this.username);
        buf.writeString(this.password);
        buf.writeString(this.hardwareUniqueId);
    }
}


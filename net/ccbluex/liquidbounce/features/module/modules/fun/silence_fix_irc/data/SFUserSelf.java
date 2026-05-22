/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUser;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.data.SFUserLevel;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUser;", "name", "", "rank", "client", "level", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserLevel;", "qq", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserLevel;Ljava/lang/String;)V", "getLevel", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserLevel;", "getQq", "()Ljava/lang/String;", "Companion", "DarkMeow"})
public final class SFUserSelf
extends SFUser {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SFUserLevel level;
    @NotNull
    private final String qq;
    @NotNull
    private static final SFUserSelf EMPTY = new SFUserSelf("", "", "", SFUserLevel.Administrator, "");

    public SFUserSelf(@NotNull String name, @NotNull String rank, @NotNull String client, @NotNull SFUserLevel level, @NotNull String qq) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter((Object)level, "level");
        Intrinsics.checkNotNullParameter(qq, "qq");
        super(name, rank, client);
        this.level = level;
        this.qq = qq;
    }

    @NotNull
    public final SFUserLevel getLevel() {
        return this.level;
    }

    @NotNull
    public final String getQq() {
        return this.qq;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf$Companion;", "", "<init>", "()V", "EMPTY", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "getEMPTY", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/data/SFUserSelf;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SFUserSelf getEMPTY() {
            return EMPTY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


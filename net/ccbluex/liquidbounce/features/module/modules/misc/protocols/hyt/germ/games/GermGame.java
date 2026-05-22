/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.INetHandler
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.games;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.games.GermGameCategory;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.packet.client.CPacketHytGermJoinGame;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0012\u001a\u0012\u0012\u000e\b\u0001\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/games/GermGame;", "", "category", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/games/GermGameCategory;", "name", "", "entry", "", "sid", "<init>", "(Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/games/GermGameCategory;Ljava/lang/String;ILjava/lang/String;)V", "getCategory", "()Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/games/GermGameCategory;", "getName", "()Ljava/lang/String;", "getEntry", "()I", "getSid", "build", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/INetHandler;", "kotlin.jvm.PlatformType", "DarkMeow"})
public class GermGame {
    @NotNull
    private final GermGameCategory category;
    @NotNull
    private final String name;
    private final int entry;
    @NotNull
    private final String sid;

    public GermGame(@NotNull GermGameCategory category, @NotNull String name, int entry, @NotNull String sid) {
        Intrinsics.checkNotNullParameter((Object)category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sid, "sid");
        this.category = category;
        this.name = name;
        this.entry = entry;
        this.sid = sid;
    }

    public /* synthetic */ GermGame(GermGameCategory germGameCategory, String string, int n2, String string2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            germGameCategory = GermGameCategory.UNKNOWN;
        }
        if ((n3 & 2) != 0) {
            string = "";
        }
        this(germGameCategory, string, n2, string2);
    }

    @NotNull
    public final GermGameCategory getCategory() {
        return this.category;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getEntry() {
        return this.entry;
    }

    @NotNull
    public final String getSid() {
        return this.sid;
    }

    @NotNull
    public final Packet<? extends INetHandler> build() {
        return new CPacketHytGermJoinGame(this.entry, this.sid).build();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.viamcp;

import com.viaversion.viaversion.api.connection.UserConnection;
import de.florianmichael.vialoadingbase.netty.VLBPipeline;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/darkmeow/viamcp/MCPVLBPipeline;", "Lde/florianmichael/vialoadingbase/netty/VLBPipeline;", "user", "Lcom/viaversion/viaversion/api/connection/UserConnection;", "<init>", "(Lcom/viaversion/viaversion/api/connection/UserConnection;)V", "getDecoderHandlerName", "", "getEncoderHandlerName", "getDecompressionHandlerName", "getCompressionHandlerName", "DarkMeow"})
public final class MCPVLBPipeline
extends VLBPipeline {
    public MCPVLBPipeline(@NotNull UserConnection user) {
        Intrinsics.checkNotNullParameter(user, "user");
        super(user);
    }

    @Override
    @NotNull
    public String getDecoderHandlerName() {
        return "decoder";
    }

    @Override
    @NotNull
    public String getEncoderHandlerName() {
        return "encoder";
    }

    @Override
    @NotNull
    public String getDecompressionHandlerName() {
        return "decompress";
    }

    @Override
    @NotNull
    public String getCompressionHandlerName() {
        return "compress";
    }
}


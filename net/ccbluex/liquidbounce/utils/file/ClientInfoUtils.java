/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.file;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/utils/file/ClientInfoUtils;", "", "<init>", "()V", "info", "Lnet/ccbluex/liquidbounce/utils/file/ClientInfoUtils$ClientInfo;", "reload", "", "force", "getName", "", "getVersion", "ClientInfo", "DarkMeow"})
public final class ClientInfoUtils {
    @NotNull
    public static final ClientInfoUtils INSTANCE = new ClientInfoUtils();
    @Nullable
    private static ClientInfo info;

    private ClientInfoUtils() {
    }

    @JvmOverloads
    public final boolean reload(boolean force) {
        Object object;
        if (info != null && !force) {
            return true;
        }
        ClientInfoUtils clientInfoUtils = this;
        try {
            ClientInfoUtils $this$reload_u24lambda_u240 = clientInfoUtils;
            boolean bl2 = false;
            info = new Gson().fromJson((JsonElement)JsonParser.parseString(FileUtils.INSTANCE.readResourceFileAsString("client.info")).getAsJsonObject(), ClientInfo.class);
            object = Result.constructor-impl(Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl(ResultKt.createFailure(throwable));
        }
        return Result.isSuccess-impl(object);
    }

    public static /* synthetic */ boolean reload$default(ClientInfoUtils clientInfoUtils, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return clientInfoUtils.reload(bl2);
    }

    @NotNull
    public final String getName() {
        boolean it = ClientInfoUtils.reload$default(this, false, 1, null);
        boolean bl2 = false;
        Object object = info;
        if (object == null || (object = ((ClientInfo)object).getName()) == null) {
            object = "null";
        }
        return object;
    }

    @NotNull
    public final String getVersion() {
        boolean it = ClientInfoUtils.reload$default(this, false, 1, null);
        boolean bl2 = false;
        Object object = info;
        if (object == null || (object = ((ClientInfo)object).getVersion()) == null) {
            object = "null";
        }
        return object;
    }

    @JvmOverloads
    public final boolean reload() {
        return ClientInfoUtils.reload$default(this, false, 1, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/utils/file/ClientInfoUtils$ClientInfo;", "", "name", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "DarkMeow"})
    public static final class ClientInfo {
        @NotNull
        private final String name;
        @NotNull
        private final String version;

        public ClientInfo(@NotNull String name, @NotNull String version) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            this.name = name;
            this.version = version;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.version;
        }

        @NotNull
        public final ClientInfo copy(@NotNull String name, @NotNull String version) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            return new ClientInfo(name, version);
        }

        public static /* synthetic */ ClientInfo copy$default(ClientInfo clientInfo, String string, String string2, int n2, Object object) {
            if ((n2 & 1) != 0) {
                string = clientInfo.name;
            }
            if ((n2 & 2) != 0) {
                string2 = clientInfo.version;
            }
            return clientInfo.copy(string, string2);
        }

        @NotNull
        public String toString() {
            return "ClientInfo(name=" + this.name + ", version=" + this.version + ')';
        }

        public int hashCode() {
            int result = this.name.hashCode();
            result = result * 31 + this.version.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientInfo)) {
                return false;
            }
            ClientInfo clientInfo = (ClientInfo)other;
            if (!Intrinsics.areEqual(this.name, clientInfo.name)) {
                return false;
            }
            return Intrinsics.areEqual(this.version, clientInfo.version);
        }
    }
}


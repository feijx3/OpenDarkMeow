/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc.config;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.darkmeow.darkmeow.irc.config.IRCStaticConfigs;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigProxy;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigRedirectServer;
import net.darkmeow.darkmeow.irc.config.data.IRCGlobalConfigRoot;
import net.darkmeow.irc.client.IRCClient;
import net.darkmeow.irc.client.interfaces.IRCClientProvider;
import net.darkmeow.irc.client.listener.IRCClientListenableProvide;
import net.darkmeow.irc.client.options.IRCClientOptions;
import net.darkmeow.irc.client.options.IRCClientRemoteVerify;
import net.darkmeow.irc.client.options.IRCClientSignatureKey;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxy;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0013\u0010\u0013\u001a\u00070\u0014\u00a2\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/darkmeow/darkmeow/irc/config/IRCGlobalConfigManager;", "", "<init>", "()V", "gson", "Lcom/viaversion/viaversion/libs/gson/Gson;", "kotlin.jvm.PlatformType", "config", "Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRoot;", "getConfig", "()Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRoot;", "setConfig", "(Lnet/darkmeow/darkmeow/irc/config/data/IRCGlobalConfigRoot;)V", "globalConfigFile", "Ljava/io/File;", "read", "", "save", "reset", "newClientInstance", "Lnet/darkmeow/irc/client/interfaces/IRCClientProvider;", "Lorg/jetbrains/annotations/NotNull;", "listenable", "Lnet/darkmeow/irc/client/listener/IRCClientListenableProvide;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nIRCGlobalConfigManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IRCGlobalConfigManager.kt\nnet/darkmeow/darkmeow/irc/config/IRCGlobalConfigManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,56:1\n1#2:57\n*E\n"})
public final class IRCGlobalConfigManager {
    @NotNull
    public static final IRCGlobalConfigManager INSTANCE = new IRCGlobalConfigManager();
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    public static IRCGlobalConfigRoot config;
    @JvmField
    @NotNull
    public static final File globalConfigFile;

    private IRCGlobalConfigManager() {
    }

    @NotNull
    public final IRCGlobalConfigRoot getConfig() {
        IRCGlobalConfigRoot iRCGlobalConfigRoot = config;
        if (iRCGlobalConfigRoot != null) {
            return iRCGlobalConfigRoot;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(@NotNull IRCGlobalConfigRoot iRCGlobalConfigRoot) {
        Intrinsics.checkNotNullParameter(iRCGlobalConfigRoot, "<set-?>");
        config = iRCGlobalConfigRoot;
    }

    public final void read() {
        Object object;
        Object $this$read_u24lambda_u240;
        Object object2 = this;
        IRCGlobalConfigManager iRCGlobalConfigManager = this;
        try {
            $this$read_u24lambda_u240 = object2;
            boolean bl2 = false;
            File file = globalConfigFile;
            Charset charset = Charsets.UTF_8;
            $this$read_u24lambda_u240 = Result.constructor-impl(gson.fromJson((Reader)new InputStreamReader((InputStream)new FileInputStream(file), charset), IRCGlobalConfigRoot.class));
        }
        catch (Throwable bl2) {
            $this$read_u24lambda_u240 = Result.constructor-impl(ResultKt.createFailure(bl2));
        }
        IRCGlobalConfigManager iRCGlobalConfigManager2 = iRCGlobalConfigManager;
        object2 = $this$read_u24lambda_u240;
        Throwable throwable = Result.exceptionOrNull-impl(object2);
        if (throwable == null) {
            object = object2;
        } else {
            $this$read_u24lambda_u240 = throwable;
            iRCGlobalConfigManager = iRCGlobalConfigManager2;
            boolean bl3 = false;
            object = new IRCGlobalConfigRoot(null, null, null, null, 15, null);
            iRCGlobalConfigManager2 = iRCGlobalConfigManager;
        }
        iRCGlobalConfigManager2.setConfig((IRCGlobalConfigRoot)object);
    }

    public final void save() {
        String string = gson.toJson(this.getConfig());
        Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
        FilesKt.writeText(globalConfigFile, string, Charsets.UTF_8);
    }

    public final void reset() {
        this.setConfig(new IRCGlobalConfigRoot(null, null, null, null, 15, null));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final IRCClientProvider newClientInstance(@NotNull IRCClientListenableProvide listenable) {
        IRCOptionsProxy iRCOptionsProxy;
        Intrinsics.checkNotNullParameter(listenable, "listenable");
        IRCClientListenableProvide iRCClientListenableProvide = listenable;
        IRCClientOptions.IRCClientOptionsBuilder iRCClientOptionsBuilder = IRCClientOptions.builder();
        Object object = this.getConfig().getRedirectServer();
        if (object == null || (object = ((IRCGlobalConfigRedirectServer)object).getHost()) == null) {
            object = "irc.nekocurit.asia";
        }
        IRCGlobalConfigRedirectServer iRCGlobalConfigRedirectServer = this.getConfig().getRedirectServer();
        IRCClientOptions.IRCClientOptionsBuilder iRCClientOptionsBuilder2 = iRCClientOptionsBuilder.host((String)object).port(iRCGlobalConfigRedirectServer != null ? iRCGlobalConfigRedirectServer.getPort() : 45020);
        IRCGlobalConfigProxy iRCGlobalConfigProxy = this.getConfig().getProxy();
        if (iRCGlobalConfigProxy != null) {
            void proxy;
            IRCGlobalConfigProxy iRCGlobalConfigProxy2 = iRCGlobalConfigProxy;
            IRCClientOptions.IRCClientOptionsBuilder iRCClientOptionsBuilder3 = iRCClientOptionsBuilder2;
            IRCClientListenableProvide iRCClientListenableProvide2 = iRCClientListenableProvide;
            boolean bl2 = false;
            IRCOptionsProxy iRCOptionsProxy2 = proxy.getType().getExec().invoke(proxy.getHost(), proxy.getPort(), proxy.getUsername(), proxy.getPassword());
            iRCClientListenableProvide = iRCClientListenableProvide2;
            iRCClientOptionsBuilder2 = iRCClientOptionsBuilder3;
            iRCOptionsProxy = iRCOptionsProxy2;
        } else {
            iRCOptionsProxy = null;
        }
        IRCClientProvider iRCClientProvider = IRCClient.newInstance(iRCClientListenableProvide, iRCClientOptionsBuilder2.proxy(iRCOptionsProxy).brand(IRCStaticConfigs.INSTANCE.getCLIENT_BRAND()).clientKey(new IRCClientSignatureKey(IRCStaticConfigs.INSTANCE.getKEY_SIGNATURE_CLIENT())).remoteVerify(new IRCClientRemoteVerify(IRCStaticConfigs.INSTANCE.getKEY_REMOTE_VERIFY())).build());
        Intrinsics.checkNotNullExpressionValue(iRCClientProvider, "newInstance(...)");
        return iRCClientProvider;
    }

    static {
        globalConfigFile = new File(System.getProperty("user.home"), ".dark_irc.json");
        INSTANCE.read();
    }
}


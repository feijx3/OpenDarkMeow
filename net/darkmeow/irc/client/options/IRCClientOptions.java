/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.darkmeow.irc.client.options;

import lombok.Generated;
import net.darkmeow.irc.client.options.IRCClientRemoteVerify;
import net.darkmeow.irc.client.options.IRCClientSignatureKey;
import net.darkmeow.irc.client.options.proxy.IRCOptionsProxy;
import net.darkmeow.irc.data.DataClientBrand;
import net.darkmeow.irc.utils.FakeHardwareUniqueIdGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IRCClientOptions {
    @NotNull
    public String host;
    public int port;
    @Nullable
    public IRCOptionsProxy proxy;
    @NotNull
    public String hardWareUniqueId;
    @Nullable
    public IRCClientSignatureKey clientKey;
    @Nullable
    public IRCClientRemoteVerify remoteVerify;
    @NotNull
    public DataClientBrand brand;

    @Generated
    private static IRCOptionsProxy $default$proxy() {
        return null;
    }

    @Generated
    private static String $default$hardWareUniqueId() {
        return FakeHardwareUniqueIdGetter.get();
    }

    @Generated
    private static IRCClientSignatureKey $default$clientKey() {
        return null;
    }

    @Generated
    private static IRCClientRemoteVerify $default$remoteVerify() {
        return null;
    }

    @Generated
    public static IRCClientOptionsBuilder builder() {
        return new IRCClientOptionsBuilder();
    }

    @Generated
    public IRCClientOptions(@NotNull String host, int port, @Nullable IRCOptionsProxy proxy, @NotNull String hardWareUniqueId, @Nullable IRCClientSignatureKey clientKey, @Nullable IRCClientRemoteVerify remoteVerify, @NotNull DataClientBrand brand) {
        if (host == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        if (hardWareUniqueId == null) {
            throw new NullPointerException("hardWareUniqueId is marked non-null but is null");
        }
        if (brand == null) {
            throw new NullPointerException("brand is marked non-null but is null");
        }
        this.host = host;
        this.port = port;
        this.proxy = proxy;
        this.hardWareUniqueId = hardWareUniqueId;
        this.clientKey = clientKey;
        this.remoteVerify = remoteVerify;
        this.brand = brand;
    }

    @Generated
    public static class IRCClientOptionsBuilder {
        @Generated
        private String host;
        @Generated
        private int port;
        @Generated
        private boolean proxy$set;
        @Generated
        private IRCOptionsProxy proxy$value;
        @Generated
        private boolean hardWareUniqueId$set;
        @Generated
        private String hardWareUniqueId$value;
        @Generated
        private boolean clientKey$set;
        @Generated
        private IRCClientSignatureKey clientKey$value;
        @Generated
        private boolean remoteVerify$set;
        @Generated
        private IRCClientRemoteVerify remoteVerify$value;
        @Generated
        private DataClientBrand brand;

        @Generated
        IRCClientOptionsBuilder() {
        }

        @Generated
        public IRCClientOptionsBuilder host(@NotNull String host) {
            if (host == null) {
                throw new NullPointerException("host is marked non-null but is null");
            }
            this.host = host;
            return this;
        }

        @Generated
        public IRCClientOptionsBuilder port(int port) {
            this.port = port;
            return this;
        }

        @Generated
        public IRCClientOptionsBuilder proxy(@Nullable IRCOptionsProxy proxy) {
            this.proxy$value = proxy;
            this.proxy$set = true;
            return this;
        }

        @Generated
        public IRCClientOptionsBuilder hardWareUniqueId(@NotNull String hardWareUniqueId) {
            if (hardWareUniqueId == null) {
                throw new NullPointerException("hardWareUniqueId is marked non-null but is null");
            }
            this.hardWareUniqueId$value = hardWareUniqueId;
            this.hardWareUniqueId$set = true;
            return this;
        }

        @Generated
        public IRCClientOptionsBuilder clientKey(@Nullable IRCClientSignatureKey clientKey) {
            this.clientKey$value = clientKey;
            this.clientKey$set = true;
            return this;
        }

        @Generated
        public IRCClientOptionsBuilder remoteVerify(@Nullable IRCClientRemoteVerify remoteVerify) {
            this.remoteVerify$value = remoteVerify;
            this.remoteVerify$set = true;
            return this;
        }

        @Generated
        public IRCClientOptionsBuilder brand(@NotNull DataClientBrand brand) {
            if (brand == null) {
                throw new NullPointerException("brand is marked non-null but is null");
            }
            this.brand = brand;
            return this;
        }

        @Generated
        public IRCClientOptions build() {
            IRCOptionsProxy proxy$value = this.proxy$value;
            if (!this.proxy$set) {
                proxy$value = IRCClientOptions.$default$proxy();
            }
            String hardWareUniqueId$value = this.hardWareUniqueId$value;
            if (!this.hardWareUniqueId$set) {
                hardWareUniqueId$value = IRCClientOptions.$default$hardWareUniqueId();
            }
            IRCClientSignatureKey clientKey$value = this.clientKey$value;
            if (!this.clientKey$set) {
                clientKey$value = IRCClientOptions.$default$clientKey();
            }
            IRCClientRemoteVerify remoteVerify$value = this.remoteVerify$value;
            if (!this.remoteVerify$set) {
                remoteVerify$value = IRCClientOptions.$default$remoteVerify();
            }
            return new IRCClientOptions(this.host, this.port, proxy$value, hardWareUniqueId$value, clientKey$value, remoteVerify$value, this.brand);
        }

        @Generated
        public String toString() {
            return "IRCClientOptions.IRCClientOptionsBuilder(host=" + this.host + ", port=" + this.port + ", proxy$value=" + this.proxy$value + ", hardWareUniqueId$value=" + this.hardWareUniqueId$value + ", clientKey$value=" + this.clientKey$value + ", remoteVerify$value=" + this.remoteVerify$value + ", brand=" + this.brand + ")";
        }
    }
}


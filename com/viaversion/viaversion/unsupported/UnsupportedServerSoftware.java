/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.unsupported;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.platform.UnsupportedSoftware;
import com.viaversion.viaversion.unsupported.UnsupportedMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={Reason.class, Builder.class})
public final class UnsupportedServerSoftware
implements UnsupportedSoftware {
    private final String name;
    private final List<String> classNames;
    private final List<UnsupportedMethods> methods;
    private final String reason;

    public UnsupportedServerSoftware(String name, List<String> classNames, List<UnsupportedMethods> methods2, String reason) {
        Preconditions.checkNotNull((Object)name);
        Preconditions.checkNotNull((Object)reason);
        Preconditions.checkArgument((!classNames.isEmpty() || !methods2.isEmpty() ? 1 : 0) != 0);
        this.name = name;
        this.classNames = Collections.unmodifiableList(classNames);
        this.methods = Collections.unmodifiableList(methods2);
        this.reason = reason;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getReason() {
        return this.reason;
    }

    @Override
    public final @Nullable String match() {
        for (String className : this.classNames) {
            try {
                Class.forName(className);
                return this.name;
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
        }
        for (UnsupportedMethods method : this.methods) {
            if (!method.findMatch()) continue;
            return this.name;
        }
        return null;
    }

    @NestHost(value=UnsupportedServerSoftware.class)
    public static final class Reason {
        public static final String DANGEROUS_SERVER_SOFTWARE = "You are using server software that - outside of possibly breaking ViaVersion - can also cause severe damage to your server's integrity as a whole.";
        public static final String BREAKING_PROXY_SOFTWARE = "You are using proxy software that intentionally breaks ViaVersion. Please use another proxy software or move ViaVersion to each backend server instead of the proxy.";
    }

    @NestHost(value=UnsupportedServerSoftware.class)
    public static final class Builder {
        private final List<String> classNames = new ArrayList<String>();
        private final List<UnsupportedMethods> methods = new ArrayList<UnsupportedMethods>();
        private String name;
        private String reason;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder addMethod(String className, String methodName) {
            this.methods.add(new UnsupportedMethods(className, Collections.singleton(methodName)));
            return this;
        }

        public Builder addMethods(String className, String ... methodNames) {
            this.methods.add(new UnsupportedMethods(className, new HashSet<String>(Arrays.asList(methodNames))));
            return this;
        }

        public Builder addClassName(String className) {
            this.classNames.add(className);
            return this;
        }

        public UnsupportedSoftware build() {
            return new UnsupportedServerSoftware(this.name, this.classNames, this.methods, this.reason);
        }
    }
}


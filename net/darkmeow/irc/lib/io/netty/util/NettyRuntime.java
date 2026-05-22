/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.darkmeow.irc.lib.io.netty.util.SuppressForbidden
 */
package net.darkmeow.irc.lib.io.netty.util;

import java.util.Locale;
import net.darkmeow.irc.lib.io.netty.util.SuppressForbidden;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;

public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    public static void setAvailableProcessors(int availableProcessors) {
        holder.setAvailableProcessors(availableProcessors);
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }

    private NettyRuntime() {
    }

    static class AvailableProcessorsHolder {
        private int availableProcessors;

        AvailableProcessorsHolder() {
        }

        synchronized void setAvailableProcessors(int availableProcessors) {
            ObjectUtil.checkPositive(availableProcessors, "availableProcessors");
            if (this.availableProcessors != 0) {
                String message = String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", this.availableProcessors, availableProcessors);
                throw new IllegalStateException(message);
            }
            this.availableProcessors = availableProcessors;
        }

        @SuppressForbidden(reason="to obtain default number of available processors")
        synchronized int availableProcessors() {
            if (this.availableProcessors == 0) {
                int availableProcessors = SystemPropertyUtil.getInt("net.darkmeow.irc.lib.io.netty.availableProcessors", Runtime.getRuntime().availableProcessors());
                this.setAvailableProcessors(availableProcessors);
            }
            return this.availableProcessors;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.queues;

import net.darkmeow.irc.lib.io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

public final class LinkedArrayQueueUtil {
    public static int length(Object[] buf) {
        return buf.length;
    }

    public static long modifiedCalcCircularRefElementOffset(long index, long mask) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((index & mask) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1);
    }

    public static long nextArrayOffset(Object[] curr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((long)(LinkedArrayQueueUtil.length(curr) - 1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}


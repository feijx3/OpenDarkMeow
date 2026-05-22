/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.lang.reflect.AccessibleObject;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent0;

public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    public static Throwable trySetAccessible(AccessibleObject object, boolean checkAccessible) {
        if (checkAccessible && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            object.setAccessible(true);
            return null;
        }
        catch (SecurityException e2) {
            return e2;
        }
        catch (RuntimeException e3) {
            return ReflectionUtil.handleInaccessibleObjectException(e3);
        }
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException e2) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(e2.getClass().getName())) {
            return e2;
        }
        throw e2;
    }
}


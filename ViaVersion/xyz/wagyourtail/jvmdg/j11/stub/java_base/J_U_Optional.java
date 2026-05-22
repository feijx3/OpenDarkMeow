/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package ViaVersion.xyz.wagyourtail.jvmdg.j11.stub.java_base;

import java.util.Optional;
import xyz.wagyourtail.jvmdg.version.Stub;

public class J_U_Optional {
    @Stub
    public static boolean isEmpty(Optional<?> optional) {
        return !optional.isPresent();
    }
}


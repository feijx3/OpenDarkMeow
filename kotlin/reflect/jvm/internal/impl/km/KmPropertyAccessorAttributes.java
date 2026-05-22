/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import org.jetbrains.annotations.NotNull;

public final class KmPropertyAccessorAttributes {
    private int flags;
    @NotNull
    private final List<KmAnnotation> annotations;

    public KmPropertyAccessorAttributes(int flags) {
        this.flags = flags;
        this.annotations = new ArrayList(0);
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int n2) {
        this.flags = n2;
    }

    public KmPropertyAccessorAttributes() {
        this(0);
    }

    @NotNull
    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }
}


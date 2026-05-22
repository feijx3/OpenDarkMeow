/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class ExcludedTypeAnnotations {
    @NotNull
    public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();
    @NotNull
    private static final Set<FqName> internalAnnotationsForResolve;

    private ExcludedTypeAnnotations() {
    }

    @NotNull
    public final Set<FqName> getInternalAnnotationsForResolve() {
        return internalAnnotationsForResolve;
    }

    static {
        FqName[] fqNameArray = new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")};
        internalAnnotationsForResolve = SetsKt.setOf(fqNameArray);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KmAnnotation {
    @NotNull
    private final String className;
    @NotNull
    private final Map<String, KmAnnotationArgument> arguments;

    public KmAnnotation(@NotNull String className, @NotNull Map<String, ? extends KmAnnotationArgument> arguments) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.className = className;
        this.arguments = arguments;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final Map<String, KmAnnotationArgument> getArguments() {
        return this.arguments;
    }

    public boolean equals(@Nullable Object other) {
        return this == other || other instanceof KmAnnotation && Intrinsics.areEqual(this.className, ((KmAnnotation)other).className) && Intrinsics.areEqual(this.arguments, ((KmAnnotation)other).arguments);
    }

    public int hashCode() {
        return 31 * this.className.hashCode() + ((Object)this.arguments).hashCode();
    }

    @NotNull
    public String toString() {
        String args = CollectionsKt.joinToString$default(MapsKt.toList(this.arguments), null, null, null, 0, null, KmAnnotation$$Lambda$0.INSTANCE, 31, null);
        return '@' + this.className + '(' + args + ')';
    }

    private static final CharSequence toString$lambda$0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String k2 = (String)pair.component1();
        KmAnnotationArgument v2 = (KmAnnotationArgument)pair.component2();
        return k2 + " = " + v2;
    }

    static /* synthetic */ CharSequence accessor$KmAnnotation$lambda0(Pair pair) {
        return KmAnnotation.toString$lambda$0(pair);
    }
}


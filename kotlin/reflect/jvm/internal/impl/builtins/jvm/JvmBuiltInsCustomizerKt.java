/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizerKt {
    @NotNull
    private static final Name GET_FIRST_LIST_NAME;
    @NotNull
    private static final Name GET_LAST_LIST_NAME;

    public static final /* synthetic */ Name access$getGET_FIRST_LIST_NAME$p() {
        return GET_FIRST_LIST_NAME;
    }

    public static final /* synthetic */ Name access$getGET_LAST_LIST_NAME$p() {
        return GET_LAST_LIST_NAME;
    }

    static {
        Name name = Name.identifier("getFirst");
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        GET_FIRST_LIST_NAME = name;
        Name name2 = Name.identifier("getLast");
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        GET_LAST_LIST_NAME = name2;
    }
}


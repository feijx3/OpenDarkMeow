/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,261:1\n230#2,2:262\n295#2,2:264\n774#2:271\n865#2,2:272\n211#3,5:266\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/MemberScopeKt\n*L\n71#1:262,2\n74#1:264,2\n87#1:271\n87#1:272,2\n77#1:266,5\n*E\n"})
public final class MemberScopeKt {
    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Set<Name> flatMapClassifierNamesOrNull(@NotNull Iterable<? extends MemberScope> $this$flatMapClassifierNamesOrNull) {
        Object v0;
        block2: {
            void var2_2;
            void $this$flatMapToNullable$iv;
            Intrinsics.checkNotNullParameter($this$flatMapClassifierNamesOrNull, "<this>");
            Iterable<? extends MemberScope> iterable = $this$flatMapClassifierNamesOrNull;
            Collection destination$iv = new HashSet();
            boolean $i$f$flatMapToNullable = false;
            for (Object element$iv : $this$flatMapToNullable$iv) {
                Iterable list$iv;
                MemberScope p0 = (MemberScope)element$iv;
                boolean bl2 = false;
                if ((Iterable)p0.getClassifierNames() == null) {
                    v0 = null;
                    break block2;
                }
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            v0 = var2_2;
        }
        return v0;
    }
}


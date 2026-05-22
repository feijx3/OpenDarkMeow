/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.kotlin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u001e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\bj\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007`\t2\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\f\u0012\u0004\u0012\u00020\r0\u000b\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/utils/kotlin/HashMapExtensions;", "", "<init>", "()V", "removeIf", "", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "predicate", "Lkotlin/Function1;", "", "", "DarkMeow"})
public final class HashMapExtensions {
    @NotNull
    public static final HashMapExtensions INSTANCE = new HashMapExtensions();

    private HashMapExtensions() {
    }

    public final <K, V> void removeIf(@NotNull HashMap<K, V> $this$removeIf, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$removeIf, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Iterator<Map.Entry<K, V>> iterator2 = $this$removeIf.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<K, V> entry;
            Intrinsics.checkNotNullExpressionValue(iterator2.next(), "next(...)");
            if (!predicate.invoke(entry).booleanValue()) continue;
            iterator2.remove();
        }
    }
}


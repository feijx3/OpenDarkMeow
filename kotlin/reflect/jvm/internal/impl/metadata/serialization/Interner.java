/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import java.util.HashMap;
import java.util.Map;
import kotlin._Assertions;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nInterner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Interner.kt\norg/jetbrains/kotlin/metadata/serialization/Interner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n1#2:31\n1056#3:32\n*S KotlinDebug\n*F\n+ 1 Interner.kt\norg/jetbrains/kotlin/metadata/serialization/Interner\n*L\n13#1:32\n*E\n"})
public final class Interner<T> {
    @Nullable
    private final Interner<T> parent;
    private final int firstIndex;
    @NotNull
    private final HashMap<T, Integer> interned;

    private final Integer find(T obj) {
        boolean bl2;
        boolean bl3 = bl2 = this.parent == null || this.parent.interned.size() + this.parent.firstIndex == this.firstIndex;
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Parent changed in parallel with child: indexes will be wrong";
            throw new AssertionError((Object)string);
        }
        Interner<T> interner = this.parent;
        if (interner == null || (interner = super.find(obj)) == null) {
            interner = this.interned.get(obj);
        }
        return interner;
    }

    public final int intern(T obj) {
        int n2;
        Integer n3 = this.find(obj);
        if (n3 != null) {
            n2 = n3;
        } else {
            int n4;
            int it = n4 = this.firstIndex + this.interned.size();
            boolean bl2 = false;
            ((Map)this.interned).put(obj, it);
            n2 = n4;
        }
        return n2;
    }
}


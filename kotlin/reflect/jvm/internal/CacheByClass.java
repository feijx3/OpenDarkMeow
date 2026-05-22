/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H&\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/CacheByClass;", "V", "", "<init>", "()V", "get", "key", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "clear", "", "kotlin-reflection"})
public abstract class CacheByClass<V> {
    public abstract V get(@NotNull Class<?> var1);

    public abstract void clear();
}


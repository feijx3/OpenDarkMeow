/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayMap.kt\norg/jetbrains/kotlin/util/ArrayMapImpl\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,145:1\n11408#2,11:146\n13537#2,2:157\n13539#2:160\n11419#2:161\n1#3:159\n*S KotlinDebug\n*F\n+ 1 ArrayMap.kt\norg/jetbrains/kotlin/util/ArrayMapImpl\n*L\n140#1:146,11\n140#1:157,2\n140#1:160\n140#1:161\n140#1:159\n*E\n"})
public final class ArrayMapImpl<T>
extends ArrayMap<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Object[] data;
    private int size;

    private ArrayMapImpl(Object[] data, int initialSize) {
        super(null);
        this.data = data;
        this.size = initialSize;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private final void ensureCapacity(int index) {
        if (this.data.length > index) {
            return;
        }
        int newSize = this.data.length;
        while ((newSize *= 2) <= index) {
        }
        Object[] objectArray = Arrays.copyOf(this.data, newSize);
        Intrinsics.checkNotNullExpressionValue(objectArray, "copyOf(...)");
        this.data = objectArray;
    }

    @Override
    public void set(int index, @NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.ensureCapacity(index);
        if (this.data[index] == null) {
            int n2 = this.getSize();
            this.size = n2 + 1;
        }
        this.data[index] = value;
    }

    @Override
    @Nullable
    public T get(int index) {
        return (T)ArraysKt.getOrNull(this.data, index);
    }

    @Override
    @NotNull
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this){
            private int index;
            final /* synthetic */ ArrayMapImpl<T> this$0;
            {
                this.this$0 = $receiver;
                this.index = -1;
            }

            protected void computeNext() {
                do {
                    int n2 = this.index;
                    this.index = n2 + 1;
                } while (this.index < ArrayMapImpl.access$getData$p(this.this$0).length && ArrayMapImpl.access$getData$p(this.this$0)[this.index] == null);
                if (this.index >= ArrayMapImpl.access$getData$p(this.this$0).length) {
                    this.done();
                } else {
                    Object object = ArrayMapImpl.access$getData$p(this.this$0)[this.index];
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                    this.setNext(object);
                }
            }
        };
    }

    public static final /* synthetic */ Object[] access$getData$p(ArrayMapImpl $this) {
        return $this.data;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


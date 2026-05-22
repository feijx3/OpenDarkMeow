/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.AbstractMutableSet;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nSmartSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartSet.kt\norg/jetbrains/kotlin/utils/SmartSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
public final class SmartSet<T>
extends AbstractMutableSet<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private Object data;
    private int size;

    private SmartSet() {
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public void setSize(int n2) {
        this.size = n2;
    }

    @Override
    @NotNull
    public Iterator<T> iterator() {
        Iterator iterator2;
        if (this.size() == 0) {
            iterator2 = Collections.emptySet().iterator();
        } else if (this.size() == 1) {
            iterator2 = new SingletonIterator<Object>(this.data);
        } else if (this.size() < 5) {
            Object object = this.data;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            iterator2 = new ArrayIterator<Object>((Object[])object);
        } else {
            Object object = this.data;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            iterator2 = TypeIntrinsics.asMutableSet(object).iterator();
        }
        return iterator2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(T element) {
        if (this.size() == 0) {
            this.data = element;
        } else if (this.size() == 1) {
            if (Intrinsics.areEqual(this.data, element)) {
                return false;
            }
            Object[] objectArray = new Object[]{this.data, element};
            this.data = objectArray;
        } else if (this.size() < 5) {
            Object[] objectArray;
            SmartSet smartSet;
            Object object = this.data;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] arr2 = (Object[])object;
            if (ArraysKt.contains(arr2, element)) {
                return false;
            }
            SmartSet smartSet2 = this;
            if (this.size() == 4) {
                void $this$add_u24lambda_u240;
                Object[] objectArray2;
                Object[] objectArray3 = objectArray2 = SetsKt.linkedSetOf(Arrays.copyOf(arr2, arr2.length));
                SmartSet smartSet3 = smartSet2;
                boolean bl2 = false;
                $this$add_u24lambda_u240.add(element);
                smartSet = smartSet3;
                objectArray = objectArray2;
            } else {
                Object[] objectArray4;
                Object[] objectArray5 = Arrays.copyOf(arr2, this.size() + 1);
                Intrinsics.checkNotNullExpressionValue(objectArray5, "copyOf(...)");
                Object[] $this$add_u24lambda_u240 = objectArray4 = objectArray5;
                SmartSet smartSet4 = smartSet2;
                boolean bl3 = false;
                $this$add_u24lambda_u241[((void)$this$add_u24lambda_u241).length - 1] = element;
                smartSet = smartSet4;
                objectArray = objectArray4;
            }
            smartSet.data = objectArray;
        } else {
            Object object = this.data;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            Set set = TypeIntrinsics.asMutableSet(object);
            if (!set.add(element)) {
                return false;
            }
        }
        int n2 = this.size();
        this.setSize(n2 + 1);
        return true;
    }

    @Override
    public void clear() {
        this.data = null;
        this.setSize(0);
    }

    @Override
    public boolean contains(Object element) {
        boolean bl2;
        if (this.size() == 0) {
            bl2 = false;
        } else if (this.size() == 1) {
            bl2 = Intrinsics.areEqual(this.data, element);
        } else if (this.size() < 5) {
            Object object = this.data;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            bl2 = ArraysKt.contains((Object[])object, element);
        } else {
            Object object = this.data;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
            bl2 = ((Set)object).contains(element);
        }
        return bl2;
    }

    @JvmStatic
    @NotNull
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    private static final class ArrayIterator<T>
    implements Iterator<T>,
    KMutableIterator {
        @NotNull
        private final Iterator<T> arrayIterator;

        public ArrayIterator(@NotNull T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(array);
        }

        @Override
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override
        public T next() {
            return this.arrayIterator.next();
        }

        @NotNull
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @SourceDebugExtension(value={"SMAP\nSmartSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartSet.kt\norg/jetbrains/kotlin/utils/SmartSet$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        @JvmStatic
        @NotNull
        public final <T> SmartSet<T> create(@NotNull Collection<? extends T> set) {
            SmartSet smartSet;
            Intrinsics.checkNotNullParameter(set, "set");
            SmartSet $this$create_u24lambda_u240 = smartSet = new SmartSet(null);
            boolean bl2 = false;
            $this$create_u24lambda_u240.addAll(set);
            return smartSet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    private static final class SingletonIterator<T>
    implements Iterator<T>,
    KMutableIterator {
        private final T element;
        private boolean hasNext;

        public SingletonIterator(T element) {
            this.element = element;
            this.hasNext = true;
        }

        @Override
        public T next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
            return this.element;
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @NotNull
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }
}


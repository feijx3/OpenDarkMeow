/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.util;

import com.twelvemonkeys.lang.Validate;
import com.twelvemonkeys.util.DuplicateHandler;
import com.twelvemonkeys.util.FilterIterator;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class CollectionUtil {
    public static void main(String[] stringArray) {
        String string;
        int n2 = 1000;
        if (stringArray.length > 0) {
            n2 = Integer.parseInt(stringArray[0]);
        }
        String[] stringArray2 = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        stringArray2 = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        System.out.println("\nFilterIterators:\n");
        List<String> list = Arrays.asList(stringArray2);
        FilterIterator<String> filterIterator = new FilterIterator<String>(list.iterator(), new FilterIterator.Filter(){

            public boolean accept(Object object) {
                return ((String)object).length() > 5;
            }
        });
        while (filterIterator.hasNext()) {
            string = (String)filterIterator.next();
            System.out.println(string + " has more than 5 letters!");
        }
        filterIterator = new FilterIterator<String>(list.iterator(), new FilterIterator.Filter(){

            public boolean accept(Object object) {
                return ((String)object).length() <= 5;
            }
        });
        while (filterIterator.hasNext()) {
            string = (String)filterIterator.next();
            System.out.println(string + " has less than, or exactly 5 letters!");
        }
        long l2 = System.currentTimeMillis();
        for (int i2 = 0; i2 < n2; ++i2) {
            filterIterator = new FilterIterator<String>(list.iterator(), new FilterIterator.Filter(){

                public boolean accept(Object object) {
                    return ((String)object).length() <= 5;
                }
            });
            while (filterIterator.hasNext()) {
                filterIterator.next();
                System.out.print("");
            }
        }
    }

    private CollectionUtil() {
    }

    public static Object mergeArrays(Object object, Object object2) {
        return CollectionUtil.mergeArrays(object, 0, Array.getLength(object), object2, 0, Array.getLength(object2));
    }

    public static Object mergeArrays(Object object, int n2, int n3, Object object2, int n4, int n5) {
        Class<?> clazz = object.getClass();
        Class<?> clazz2 = clazz.getComponentType();
        Object object3 = Array.newInstance(clazz2, n3 + n5);
        System.arraycopy(object, n2, object3, 0, n3);
        System.arraycopy(object2, n4, object3, n3, n5);
        return object3;
    }

    public static Object subArray(Object object, int n2) {
        return CollectionUtil.subArray(object, n2, -1);
    }

    public static <T> T[] subArray(T[] TArray, int n2) {
        return CollectionUtil.subArray(TArray, n2, -1);
    }

    public static Object subArray(Object object, int n2, int n3) {
        Object object2;
        int n4;
        Validate.notNull(object, "array");
        if (n2 < 0) {
            throw new ArrayIndexOutOfBoundsException(n2 + " < 0");
        }
        Class<?> clazz = object.getClass().getComponentType();
        if (clazz == null) {
            throw new IllegalArgumentException("Not an array: " + object);
        }
        int n5 = Array.getLength(object);
        int n6 = n4 = n3 < 0 ? Math.max(0, n5 - n2) : Math.min(n3, Math.max(0, n5 - n2));
        if (n4 < n5) {
            object2 = Array.newInstance(clazz, n4);
            System.arraycopy(object, n2, object2, 0, n4);
        } else {
            object2 = object;
        }
        return object2;
    }

    public static <T> T[] subArray(T[] TArray, int n2, int n3) {
        return (Object[])CollectionUtil.subArray(TArray, n2, n3);
    }

    public static <T> Iterator<T> iterator(final Enumeration<T> enumeration) {
        Validate.notNull(enumeration, "enumeration");
        return new Iterator<T>(){

            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override
            public T next() {
                return enumeration.nextElement();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <E> void addAll(Collection<E> collection, Iterator<? extends E> iterator2) {
        while (iterator2.hasNext()) {
            collection.add(iterator2.next());
        }
    }

    public static <E> ListIterator<E> iterator(E[] EArray) {
        return CollectionUtil.iterator(EArray, 0, Validate.notNull(EArray).length);
    }

    public static <E> ListIterator<E> iterator(E[] EArray, int n2, int n3) {
        return new ArrayIterator<E>(EArray, n2, n3);
    }

    public static <K, V> Map<V, K> invert(Map<K, V> map) {
        return CollectionUtil.invert(map, null, null);
    }

    public static <K, V> Map<V, K> invert(Map<K, V> map, Map<V, K> map2, DuplicateHandler<K> duplicateHandler) {
        if (map == null) {
            throw new IllegalArgumentException("source == null");
        }
        Map map3 = map2;
        if (map3 == null) {
            try {
                map3 = (Map)map.getClass().newInstance();
            }
            catch (InstantiationException instantiationException) {
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
            if (map3 == null) {
                throw new IllegalArgumentException("result == null and source class " + map.getClass() + " cannot be instantiated.");
            }
        }
        Set<Map.Entry<K, V>> set = map.entrySet();
        for (Map.Entry<K, V> entry : set) {
            V v2 = entry.getValue();
            K k2 = entry.getKey();
            if (map3.containsKey(v2)) {
                if (duplicateHandler != null) {
                    k2 = duplicateHandler.resolve(map3.get(v2), k2);
                } else {
                    throw new IllegalArgumentException("Result would include duplicate keys, but no DuplicateHandler specified.");
                }
            }
            map3.put(v2, k2);
        }
        return map3;
    }

    public static <T> Comparator<T> reverseOrder(Comparator<T> comparator) {
        return new ReverseComparator<T>(comparator);
    }

    static <T extends Iterator<? super E>, E> T generify(Iterator<?> iterator2, Class<E> clazz) {
        return (T)iterator2;
    }

    static <T extends Collection<? super E>, E> T generify(Collection<?> collection, Class<E> clazz) {
        return (T)collection;
    }

    static <T extends Map<? super K, ? super V>, K, V> T generify(Map<?, ?> map, Class<K> clazz, Class<V> clazz2) {
        return (T)map;
    }

    static <T extends Collection<? super E>, E> T generify2(Collection<?> collection) {
        return (T)collection;
    }

    private static class ArrayIterator<E>
    implements ListIterator<E> {
        private int next;
        private final int start;
        private final int length;
        private final E[] array;

        public ArrayIterator(E[] EArray, int n2, int n3) {
            this.array = Validate.notNull(EArray, "array");
            this.start = Validate.isTrue(n2 >= 0, n2, "start < 0: %d");
            this.length = Validate.isTrue(n3 <= EArray.length - n2, n3, "length > array.length - start: %d");
            this.next = this.start;
        }

        @Override
        public boolean hasNext() {
            return this.next < this.length + this.start;
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                return this.array[this.next++];
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                NoSuchElementException noSuchElementException = new NoSuchElementException(arrayIndexOutOfBoundsException.getMessage());
                noSuchElementException.initCause(arrayIndexOutOfBoundsException);
                throw noSuchElementException;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasPrevious() {
            return this.next > this.start;
        }

        @Override
        public int nextIndex() {
            return this.next - this.start;
        }

        @Override
        public E previous() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            try {
                return this.array[--this.next];
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                NoSuchElementException noSuchElementException = new NoSuchElementException(arrayIndexOutOfBoundsException.getMessage());
                noSuchElementException.initCause(arrayIndexOutOfBoundsException);
                throw noSuchElementException;
            }
        }

        @Override
        public int previousIndex() {
            return this.nextIndex() - 1;
        }

        @Override
        public void set(E e2) {
            this.array[this.next - 1] = e2;
        }
    }

    private static class ReverseComparator<T>
    implements Comparator<T> {
        private final Comparator<T> comparator;

        public ReverseComparator(Comparator<T> comparator) {
            this.comparator = Validate.notNull(comparator);
        }

        @Override
        public int compare(T t2, T t3) {
            int n2 = this.comparator.compare(t2, t3);
            return -(n2 | n2 >>> 1);
        }
    }
}


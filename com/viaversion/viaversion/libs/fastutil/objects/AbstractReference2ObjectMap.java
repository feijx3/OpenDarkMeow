/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Size64;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectCollection;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectSet;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractReference2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractReferenceSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectMaps;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceSet;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractReference2ObjectMap<K, V>
extends AbstractReference2ObjectFunction<K, V>
implements Reference2ObjectMap<K, V>,
Serializable {
    private static final long serialVersionUID = -4940583368468432370L;

    protected AbstractReference2ObjectMap() {
    }

    @Override
    public boolean containsKey(Object k2) {
        Iterator i2 = this.reference2ObjectEntrySet().iterator();
        while (i2.hasNext()) {
            if (((Reference2ObjectMap.Entry)i2.next()).getKey() != k2) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object v2) {
        Iterator i2 = this.reference2ObjectEntrySet().iterator();
        while (i2.hasNext()) {
            if (((Reference2ObjectMap.Entry)i2.next()).getValue() != v2) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public ReferenceSet<K> keySet() {
        return new AbstractReferenceSet<K>(){

            @Override
            public boolean contains(Object k2) {
                return AbstractReference2ObjectMap.this.containsKey(k2);
            }

            @Override
            public int size() {
                return AbstractReference2ObjectMap.this.size();
            }

            @Override
            public void clear() {
                AbstractReference2ObjectMap.this.clear();
            }

            @Override
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>(){
                    private final ObjectIterator<Reference2ObjectMap.Entry<K, V>> i;
                    {
                        this.i = Reference2ObjectMaps.fastIterator(AbstractReference2ObjectMap.this);
                    }

                    @Override
                    public K next() {
                        return ((Reference2ObjectMap.Entry)this.i.next()).getKey();
                    }

                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }

                    @Override
                    public void remove() {
                        this.i.remove();
                    }

                    @Override
                    public void forEachRemaining(Consumer<? super K> action) {
                        this.i.forEachRemaining((? super E entry) -> action.accept((Object)entry.getKey()));
                    }
                };
            }

            @Override
            public ObjectSpliterator<K> spliterator() {
                return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(AbstractReference2ObjectMap.this), 65);
            }
        };
    }

    @Override
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>(){

            @Override
            public boolean contains(Object k2) {
                return AbstractReference2ObjectMap.this.containsValue(k2);
            }

            @Override
            public int size() {
                return AbstractReference2ObjectMap.this.size();
            }

            @Override
            public void clear() {
                AbstractReference2ObjectMap.this.clear();
            }

            @Override
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>(){
                    private final ObjectIterator<Reference2ObjectMap.Entry<K, V>> i;
                    {
                        this.i = Reference2ObjectMaps.fastIterator(AbstractReference2ObjectMap.this);
                    }

                    @Override
                    public V next() {
                        return ((Reference2ObjectMap.Entry)this.i.next()).getValue();
                    }

                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }

                    @Override
                    public void remove() {
                        this.i.remove();
                    }

                    @Override
                    public void forEachRemaining(Consumer<? super V> action) {
                        this.i.forEachRemaining((? super E entry) -> action.accept((Object)entry.getValue()));
                    }
                };
            }

            @Override
            public ObjectSpliterator<V> spliterator() {
                return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(AbstractReference2ObjectMap.this), 64);
            }
        };
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m2) {
        if (m2 instanceof Reference2ObjectMap) {
            ObjectIterator i2 = Reference2ObjectMaps.fastIterator((Reference2ObjectMap)m2);
            while (i2.hasNext()) {
                Reference2ObjectMap.Entry e2 = (Reference2ObjectMap.Entry)i2.next();
                this.put(e2.getKey(), e2.getValue());
            }
        } else {
            int n2 = m2.size();
            Iterator<Map.Entry<K, V>> i3 = m2.entrySet().iterator();
            while (n2-- != 0) {
                Map.Entry<K, V> e3 = i3.next();
                this.put(e3.getKey(), e3.getValue());
            }
        }
    }

    @Override
    public int hashCode() {
        int h2 = 0;
        int n2 = this.size();
        ObjectIterator i2 = Reference2ObjectMaps.fastIterator(this);
        while (n2-- != 0) {
            h2 += ((Reference2ObjectMap.Entry)i2.next()).hashCode();
        }
        return h2;
    }

    @Override
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof Map)) {
            return false;
        }
        Map m2 = (Map)o2;
        if (m2.size() != this.size()) {
            return false;
        }
        return this.reference2ObjectEntrySet().containsAll(m2.entrySet());
    }

    public String toString() {
        StringBuilder s2 = new StringBuilder();
        ObjectIterator i2 = Reference2ObjectMaps.fastIterator(this);
        int n2 = this.size();
        boolean first = true;
        s2.append("{");
        while (n2-- != 0) {
            if (first) {
                first = false;
            } else {
                s2.append(", ");
            }
            Reference2ObjectMap.Entry e2 = (Reference2ObjectMap.Entry)i2.next();
            if (this == e2.getKey()) {
                s2.append("(this map)");
            } else {
                s2.append(String.valueOf(e2.getKey()));
            }
            s2.append("=>");
            if (this == e2.getValue()) {
                s2.append("(this map)");
                continue;
            }
            s2.append(String.valueOf(e2.getValue()));
        }
        s2.append("}");
        return s2.toString();
    }

    public static abstract class BasicEntrySet<K, V>
    extends AbstractObjectSet<Reference2ObjectMap.Entry<K, V>> {
        protected final Reference2ObjectMap<K, V> map;

        public BasicEntrySet(Reference2ObjectMap<K, V> map) {
            this.map = map;
        }

        @Override
        public boolean contains(Object o2) {
            if (!(o2 instanceof Map.Entry)) {
                return false;
            }
            if (o2 instanceof Reference2ObjectMap.Entry) {
                Reference2ObjectMap.Entry e2 = (Reference2ObjectMap.Entry)o2;
                Object k2 = e2.getKey();
                return this.map.containsKey(k2) && Objects.equals(this.map.get(k2), e2.getValue());
            }
            Map.Entry e3 = (Map.Entry)o2;
            Object k3 = e3.getKey();
            Object value = e3.getValue();
            return this.map.containsKey(k3) && Objects.equals(this.map.get(k3), value);
        }

        @Override
        public boolean remove(Object o2) {
            if (!(o2 instanceof Map.Entry)) {
                return false;
            }
            if (o2 instanceof Reference2ObjectMap.Entry) {
                Reference2ObjectMap.Entry e2 = (Reference2ObjectMap.Entry)o2;
                return this.map.remove(e2.getKey(), e2.getValue());
            }
            Map.Entry e3 = (Map.Entry)o2;
            Object k2 = e3.getKey();
            Object v2 = e3.getValue();
            return this.map.remove(k2, v2);
        }

        @Override
        public int size() {
            return this.map.size();
        }

        @Override
        public ObjectSpliterator<Reference2ObjectMap.Entry<K, V>> spliterator() {
            return ObjectSpliterators.asSpliterator(this.iterator(), Size64.sizeOf(this.map), 65);
        }
    }

    public static class BasicEntry<K, V>
    implements Reference2ObjectMap.Entry<K, V> {
        protected K key;
        protected V value;

        public BasicEntry() {
        }

        public BasicEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object o2) {
            if (!(o2 instanceof Map.Entry)) {
                return false;
            }
            if (o2 instanceof Reference2ObjectMap.Entry) {
                Reference2ObjectMap.Entry e2 = (Reference2ObjectMap.Entry)o2;
                return this.key == e2.getKey() && Objects.equals(this.value, e2.getValue());
            }
            Map.Entry e3 = (Map.Entry)o2;
            Object key = e3.getKey();
            Object value = e3.getValue();
            return this.key == key && Objects.equals(this.value, value);
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(this.key) ^ (this.value == null ? 0 : this.value.hashCode());
        }

        public String toString() {
            return this.key + "->" + this.value;
        }
    }
}


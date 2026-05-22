/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.concurrent;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import net.darkmeow.irc.lib.io.netty.util.internal.InternalThreadLocalMap;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;

public class FastThreadLocal<V> {
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeAll() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.getIfSet();
        if (threadLocalMap == null) {
            return;
        }
        try {
            Object v2 = threadLocalMap.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
            if (v2 != null && v2 != InternalThreadLocalMap.UNSET) {
                FastThreadLocal[] variablesToRemoveArray;
                Set variablesToRemove = (Set)v2;
                for (FastThreadLocal tlv : variablesToRemoveArray = variablesToRemove.toArray(new FastThreadLocal[0])) {
                    tlv.remove(threadLocalMap);
                }
            }
        }
        finally {
            InternalThreadLocalMap.remove();
        }
    }

    public static int size() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.getIfSet();
        if (threadLocalMap == null) {
            return 0;
        }
        return threadLocalMap.size();
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private static void addToVariablesToRemove(InternalThreadLocalMap threadLocalMap, FastThreadLocal<?> variable) {
        Set variablesToRemove;
        Object v2 = threadLocalMap.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
        if (v2 == InternalThreadLocalMap.UNSET || v2 == null) {
            variablesToRemove = Collections.newSetFromMap(new IdentityHashMap());
            threadLocalMap.setIndexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX, variablesToRemove);
        } else {
            variablesToRemove = (Set)v2;
        }
        variablesToRemove.add(variable);
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap threadLocalMap, FastThreadLocal<?> variable) {
        Object v2 = threadLocalMap.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
        if (v2 == InternalThreadLocalMap.UNSET || v2 == null) {
            return;
        }
        Set variablesToRemove = (Set)v2;
        variablesToRemove.remove(variable);
    }

    public final V get() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
        Object v2 = threadLocalMap.indexedVariable(this.index);
        if (v2 != InternalThreadLocalMap.UNSET) {
            return (V)v2;
        }
        return this.initialize(threadLocalMap);
    }

    public final V getIfExists() {
        Object v2;
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.getIfSet();
        if (threadLocalMap != null && (v2 = threadLocalMap.indexedVariable(this.index)) != InternalThreadLocalMap.UNSET) {
            return (V)v2;
        }
        return null;
    }

    public final V get(InternalThreadLocalMap threadLocalMap) {
        Object v2 = threadLocalMap.indexedVariable(this.index);
        if (v2 != InternalThreadLocalMap.UNSET) {
            return (V)v2;
        }
        return this.initialize(threadLocalMap);
    }

    private V initialize(InternalThreadLocalMap threadLocalMap) {
        V v2 = null;
        try {
            v2 = this.initialValue();
            if (v2 == InternalThreadLocalMap.UNSET) {
                throw new IllegalArgumentException("InternalThreadLocalMap.UNSET can not be initial value.");
            }
        }
        catch (Exception e2) {
            PlatformDependent.throwException(e2);
        }
        threadLocalMap.setIndexedVariable(this.index, v2);
        FastThreadLocal.addToVariablesToRemove(threadLocalMap, this);
        return v2;
    }

    public final void set(V value) {
        this.getAndSet(value);
    }

    public final void set(InternalThreadLocalMap threadLocalMap, V value) {
        this.getAndSet(threadLocalMap, value);
    }

    public V getAndSet(V value) {
        if (value != InternalThreadLocalMap.UNSET) {
            InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
            return this.setKnownNotUnset(threadLocalMap, value);
        }
        return this.removeAndGet(InternalThreadLocalMap.getIfSet());
    }

    public V getAndSet(InternalThreadLocalMap threadLocalMap, V value) {
        if (value != InternalThreadLocalMap.UNSET) {
            return this.setKnownNotUnset(threadLocalMap, value);
        }
        return this.removeAndGet(threadLocalMap);
    }

    private V setKnownNotUnset(InternalThreadLocalMap threadLocalMap, V value) {
        Object old = threadLocalMap.getAndSetIndexedVariable(this.index, value);
        if (old == InternalThreadLocalMap.UNSET) {
            FastThreadLocal.addToVariablesToRemove(threadLocalMap, this);
            return null;
        }
        return (V)old;
    }

    public final boolean isSet() {
        return this.isSet(InternalThreadLocalMap.getIfSet());
    }

    public final boolean isSet(InternalThreadLocalMap threadLocalMap) {
        return threadLocalMap != null && threadLocalMap.isIndexedVariableSet(this.index);
    }

    public final void remove() {
        this.remove(InternalThreadLocalMap.getIfSet());
    }

    public final void remove(InternalThreadLocalMap threadLocalMap) {
        this.removeAndGet(threadLocalMap);
    }

    private V removeAndGet(InternalThreadLocalMap threadLocalMap) {
        if (threadLocalMap == null) {
            return null;
        }
        Object v2 = threadLocalMap.removeIndexedVariable(this.index);
        if (v2 != InternalThreadLocalMap.UNSET) {
            FastThreadLocal.removeFromVariablesToRemove(threadLocalMap, this);
            try {
                this.onRemoval(v2);
            }
            catch (Exception e2) {
                PlatformDependent.throwException(e2);
            }
            return (V)v2;
        }
        return null;
    }

    protected V initialValue() throws Exception {
        return null;
    }

    protected void onRemoval(V value) throws Exception {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceCollection;
import java.util.AbstractCollection;
import java.util.Iterator;

public abstract class AbstractReferenceCollection<K>
extends AbstractCollection<K>
implements ReferenceCollection<K> {
    protected AbstractReferenceCollection() {
    }

    @Override
    public abstract ObjectIterator<K> iterator();

    @Override
    public String toString() {
        StringBuilder s2 = new StringBuilder();
        Iterator i2 = this.iterator();
        int n2 = this.size();
        boolean first = true;
        s2.append("{");
        while (n2-- != 0) {
            if (first) {
                first = false;
            } else {
                s2.append(", ");
            }
            Object k2 = i2.next();
            if (this == k2) {
                s2.append("(this collection)");
                continue;
            }
            s2.append(String.valueOf(k2));
        }
        s2.append("}");
        return s2.toString();
    }
}


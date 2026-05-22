/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="id", type=int.class)})
final class IdHolder<T>
extends J_L_Record
implements Holder<T> {
    private final int id;

    IdHolder(int id) {
        Preconditions.checkArgument((id >= 0 ? 1 : 0) != 0, (Object)"id cannot be negative");
        this.id = id;
    }

    @Override
    public boolean isDirect() {
        return false;
    }

    @Override
    public boolean hasId() {
        return true;
    }

    @Override
    public T value() {
        throw new IllegalArgumentException("Holder is not direct");
    }

    @Override
    public Holder<T> updateId(Int2IntFunction rewriteFunction, Supplier<Holder<T>> ifMissing) {
        int rewrittenId = rewriteFunction.applyAsInt(this.id);
        if (rewrittenId == this.id) {
            return this;
        }
        if (rewrittenId == -1) {
            if (ifMissing != null) {
                return ifMissing.get();
            }
            throw new IllegalArgumentException("Received invalid id in updateId");
        }
        return Holder.of(rewrittenId);
    }

    @Override
    public Holder<T> updateValue(Function<T, T> rewriteFunction) {
        return this;
    }

    @Override
    public final String toString() {
        return IdHolder.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return IdHolder.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return IdHolder.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public int id() {
        return this.id;
    }

    private static String jvmdowngrader$toString$toString(IdHolder idHolder) {
        IdHolder idHolder2 = idHolder;
        return "IdHolder[" + "id=" + idHolder.id + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(IdHolder idHolder) {
        Object[] objectArray = new Object[]{idHolder.id};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(IdHolder idHolder, Object object) {
        if (idHolder == object) {
            return true;
        }
        if (object != null && object instanceof IdHolder) {
            IdHolder idHolder2 = (IdHolder)object;
            if (idHolder.id == idHolder2.id) {
                return true;
            }
        }
        return false;
    }
}


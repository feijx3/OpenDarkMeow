/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.protocol.remapper;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.ValueReader;
import com.viaversion.viaversion.api.protocol.remapper.ValueWriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.exception.InformativeException;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="type", type=Type.class)})
public final class TypeRemapper<T>
extends J_L_Record
implements ValueReader<T>,
ValueWriter<T> {
    private final Type<T> type;

    public TypeRemapper(Type<T> type) {
        this.type = type;
    }

    @Override
    public T read(PacketWrapper wrapper) throws InformativeException {
        return wrapper.read(this.type);
    }

    @Override
    public void write(PacketWrapper output, T inputValue) throws InformativeException {
        output.write(this.type, inputValue);
    }

    @Override
    public final String toString() {
        return TypeRemapper.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return TypeRemapper.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return TypeRemapper.jvmdowngrader$equals$equals(this, o2);
    }

    public Type<T> type() {
        return this.type;
    }

    private static String jvmdowngrader$toString$toString(TypeRemapper typeRemapper) {
        TypeRemapper typeRemapper2 = typeRemapper;
        return "TypeRemapper[" + "type=" + typeRemapper.type + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(TypeRemapper typeRemapper) {
        Object[] objectArray = new Object[]{typeRemapper.type};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(TypeRemapper typeRemapper, Object object) {
        if (typeRemapper == object) {
            return true;
        }
        if (object != null && object instanceof TypeRemapper) {
            TypeRemapper typeRemapper2 = (TypeRemapper)object;
            if (Objects.equals(typeRemapper.type, typeRemapper2.type)) {
                return true;
            }
        }
        return false;
    }
}


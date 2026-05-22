/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="showInTooltip", type=boolean.class)})
@NestMembers(value={1.class})
public final class Unbreakable
extends J_L_Record {
    private final boolean showInTooltip;
    public static final Type<Unbreakable> TYPE = new Type<Unbreakable>(Unbreakable.class){

        @Override
        public Unbreakable read(ByteBuf buffer) {
            return new Unbreakable(buffer.readBoolean());
        }

        @Override
        public void write(ByteBuf buffer, Unbreakable value) {
            buffer.writeBoolean(value.showInTooltip());
        }
    };

    public Unbreakable(boolean showInTooltip) {
        this.showInTooltip = showInTooltip;
    }

    @Override
    public final String toString() {
        return Unbreakable.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Unbreakable.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Unbreakable.jvmdowngrader$equals$equals(this, o2);
    }

    public boolean showInTooltip() {
        return this.showInTooltip;
    }

    private static String jvmdowngrader$toString$toString(Unbreakable unbreakable) {
        Unbreakable unbreakable2 = unbreakable;
        return "Unbreakable[" + "showInTooltip=" + unbreakable.showInTooltip + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Unbreakable unbreakable) {
        Object[] objectArray = new Object[]{unbreakable.showInTooltip};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Unbreakable unbreakable, Object object) {
        if (unbreakable == object) {
            return true;
        }
        if (object != null && object instanceof Unbreakable) {
            Unbreakable unbreakable2 = (Unbreakable)object;
            if (unbreakable.showInTooltip == unbreakable2.showInTooltip) {
                return true;
            }
        }
        return false;
    }
}


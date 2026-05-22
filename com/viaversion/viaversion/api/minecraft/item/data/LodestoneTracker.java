/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="position", type=GlobalBlockPosition.class), @RecordComponents.Value(name="tracked", type=boolean.class)})
@NestMembers(value={1.class})
public final class LodestoneTracker
extends J_L_Record {
    private final @Nullable GlobalBlockPosition position;
    private final boolean tracked;
    public static final Type<LodestoneTracker> TYPE = new Type<LodestoneTracker>(LodestoneTracker.class){

        @Override
        public LodestoneTracker read(ByteBuf buffer) {
            GlobalBlockPosition position = (GlobalBlockPosition)Types.OPTIONAL_GLOBAL_POSITION.read(buffer);
            boolean tracked = buffer.readBoolean();
            return new LodestoneTracker(position, tracked);
        }

        @Override
        public void write(ByteBuf buffer, LodestoneTracker value) {
            Types.OPTIONAL_GLOBAL_POSITION.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$get$position());
            buffer.writeBoolean(value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$get$tracked());
        }

        @Override
        public void write(Ops ops, LodestoneTracker value) {
            ops.writeMap(map -> map.writeOptional("target", Types.GLOBAL_POSITION, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$get$position()).writeOptional("tracked", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$get$tracked(), true));
        }
    };

    public LodestoneTracker(@Nullable GlobalBlockPosition position, boolean tracked) {
        this.position = position;
        this.tracked = tracked;
    }

    @Override
    public final String toString() {
        return LodestoneTracker.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return LodestoneTracker.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return LodestoneTracker.jvmdowngrader$equals$equals(this, o2);
    }

    public @Nullable GlobalBlockPosition position() {
        return this.position;
    }

    public boolean tracked() {
        return this.tracked;
    }

    private static String jvmdowngrader$toString$toString(LodestoneTracker lodestoneTracker) {
        LodestoneTracker lodestoneTracker2 = lodestoneTracker;
        return "LodestoneTracker[" + "position=" + lodestoneTracker.position + ", " + "tracked=" + lodestoneTracker.tracked + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(LodestoneTracker lodestoneTracker) {
        Object[] objectArray = new Object[]{lodestoneTracker.position, lodestoneTracker.tracked};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(LodestoneTracker lodestoneTracker, Object object) {
        if (lodestoneTracker == object) {
            return true;
        }
        if (object != null && object instanceof LodestoneTracker) {
            LodestoneTracker lodestoneTracker2 = (LodestoneTracker)object;
            if (Objects.equals(lodestoneTracker.position, lodestoneTracker2.position) && lodestoneTracker.tracked == lodestoneTracker2.tracked) {
                return true;
            }
        }
        return false;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$get$tracked() {
        return this.tracked;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$set$tracked(boolean bl2) {
        this.tracked = bl2;
    }

    public GlobalBlockPosition jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$get$position() {
        return this.position;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_LodestoneTracker$set$position(GlobalBlockPosition globalBlockPosition) {
        this.position = globalBlockPosition;
    }
}


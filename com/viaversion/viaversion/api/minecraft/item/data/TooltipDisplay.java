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
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSortedSet;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="hideTooltip", type=boolean.class), @RecordComponents.Value(name="hiddenComponents", type=IntSortedSet.class)})
@NestMembers(value={1.class})
public final class TooltipDisplay
extends J_L_Record
implements Rewritable {
    private final boolean hideTooltip;
    private final IntSortedSet hiddenComponents;
    public static final Type<TooltipDisplay> TYPE = new Type<TooltipDisplay>(TooltipDisplay.class){

        @Override
        public TooltipDisplay read(ByteBuf buffer) {
            boolean hideTooltip = buffer.readBoolean();
            IntLinkedOpenHashSet hiddenComponents = new IntLinkedOpenHashSet();
            int size = Types.VAR_INT.readPrimitive(buffer);
            for (int i2 = 0; i2 < size; ++i2) {
                hiddenComponents.add(Types.VAR_INT.readPrimitive(buffer));
            }
            return new TooltipDisplay(hideTooltip, hiddenComponents);
        }

        @Override
        public void write(ByteBuf buffer, TooltipDisplay value) {
            buffer.writeBoolean(value.hideTooltip());
            Types.VAR_INT.writePrimitive(buffer, value.hiddenComponents().size());
            IntBidirectionalIterator intBidirectionalIterator = value.hiddenComponents().iterator();
            while (intBidirectionalIterator.hasNext()) {
                int hiddenComponent = (Integer)intBidirectionalIterator.next();
                Types.VAR_INT.writePrimitive(buffer, hiddenComponent);
            }
        }

        @Override
        public void write(Ops ops, TooltipDisplay value) {
            Key[] hiddenComponents = (Key[])value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TooltipDisplay$get$hiddenComponents().intStream().mapToObj(id -> ops.context().registryAccess().dataComponentType(id)).toArray(Key[]::new);
            ops.writeMap(map -> map.writeOptional("hide_tooltip", Types.BOOLEAN, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TooltipDisplay$get$hideTooltip(), false).writeOptional("hidden_components", Types.RESOURCE_LOCATION_ARRAY, hiddenComponents, new Key[0]));
        }
    };

    public TooltipDisplay(boolean hideTooltip, IntSortedSet hiddenComponents) {
        this.hideTooltip = hideTooltip;
        this.hiddenComponents = hiddenComponents;
    }

    @Override
    public TooltipDisplay rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        if (this.hiddenComponents.isEmpty()) {
            return this;
        }
        IntLinkedOpenHashSet newHiddenComponents = new IntLinkedOpenHashSet();
        IntBidirectionalIterator intBidirectionalIterator = this.hiddenComponents.iterator();
        while (intBidirectionalIterator.hasNext()) {
            int hiddenComponent = (Integer)intBidirectionalIterator.next();
            newHiddenComponents.add(Rewritable.rewriteDataComponentType(protocol, clientbound, hiddenComponent));
        }
        return new TooltipDisplay(this.hideTooltip, newHiddenComponents);
    }

    @Override
    public final String toString() {
        return TooltipDisplay.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return TooltipDisplay.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return TooltipDisplay.jvmdowngrader$equals$equals(this, o2);
    }

    public boolean hideTooltip() {
        return this.hideTooltip;
    }

    public IntSortedSet hiddenComponents() {
        return this.hiddenComponents;
    }

    private static String jvmdowngrader$toString$toString(TooltipDisplay tooltipDisplay) {
        TooltipDisplay tooltipDisplay2 = tooltipDisplay;
        return "TooltipDisplay[" + "hideTooltip=" + tooltipDisplay.hideTooltip + ", " + "hiddenComponents=" + tooltipDisplay.hiddenComponents + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(TooltipDisplay tooltipDisplay) {
        Object[] objectArray = new Object[]{tooltipDisplay.hideTooltip, tooltipDisplay.hiddenComponents};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(TooltipDisplay tooltipDisplay, Object object) {
        if (tooltipDisplay == object) {
            return true;
        }
        if (object != null && object instanceof TooltipDisplay) {
            TooltipDisplay tooltipDisplay2 = (TooltipDisplay)object;
            if (tooltipDisplay.hideTooltip == tooltipDisplay2.hideTooltip && Objects.equals(tooltipDisplay.hiddenComponents, tooltipDisplay2.hiddenComponents)) {
                return true;
            }
        }
        return false;
    }

    public IntSortedSet jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TooltipDisplay$get$hiddenComponents() {
        return this.hiddenComponents;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TooltipDisplay$set$hiddenComponents(IntSortedSet intSortedSet) {
        this.hiddenComponents = intSortedSet;
    }

    public boolean jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TooltipDisplay$get$hideTooltip() {
        return this.hideTooltip;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_TooltipDisplay$set$hideTooltip(boolean bl2) {
        this.hideTooltip = bl2;
    }
}


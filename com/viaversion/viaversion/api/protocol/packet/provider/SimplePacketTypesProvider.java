/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.protocol.packet.provider;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="unmappedClientboundPacketTypes", type=Map.class), @RecordComponents.Value(name="mappedClientboundPacketTypes", type=Map.class), @RecordComponents.Value(name="mappedServerboundPacketTypes", type=Map.class), @RecordComponents.Value(name="unmappedServerboundPacketTypes", type=Map.class)})
public final class SimplePacketTypesProvider<CU extends ClientboundPacketType, CM extends ClientboundPacketType, SM extends ServerboundPacketType, SU extends ServerboundPacketType>
extends J_L_Record
implements PacketTypesProvider<CU, CM, SM, SU> {
    private final Map<State, PacketTypeMap<CU>> unmappedClientboundPacketTypes;
    private final Map<State, PacketTypeMap<CM>> mappedClientboundPacketTypes;
    private final Map<State, PacketTypeMap<SM>> mappedServerboundPacketTypes;
    private final Map<State, PacketTypeMap<SU>> unmappedServerboundPacketTypes;

    public SimplePacketTypesProvider(Map<State, PacketTypeMap<CU>> unmappedClientboundPacketTypes, Map<State, PacketTypeMap<CM>> mappedClientboundPacketTypes, Map<State, PacketTypeMap<SM>> mappedServerboundPacketTypes, Map<State, PacketTypeMap<SU>> unmappedServerboundPacketTypes) {
        this.unmappedClientboundPacketTypes = unmappedClientboundPacketTypes;
        this.mappedClientboundPacketTypes = mappedClientboundPacketTypes;
        this.mappedServerboundPacketTypes = mappedServerboundPacketTypes;
        this.unmappedServerboundPacketTypes = unmappedServerboundPacketTypes;
    }

    @Override
    public final String toString() {
        return SimplePacketTypesProvider.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return SimplePacketTypesProvider.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return SimplePacketTypesProvider.jvmdowngrader$equals$equals(this, o2);
    }

    @Override
    public Map<State, PacketTypeMap<CU>> unmappedClientboundPacketTypes() {
        return this.unmappedClientboundPacketTypes;
    }

    @Override
    public Map<State, PacketTypeMap<CM>> mappedClientboundPacketTypes() {
        return this.mappedClientboundPacketTypes;
    }

    @Override
    public Map<State, PacketTypeMap<SM>> mappedServerboundPacketTypes() {
        return this.mappedServerboundPacketTypes;
    }

    @Override
    public Map<State, PacketTypeMap<SU>> unmappedServerboundPacketTypes() {
        return this.unmappedServerboundPacketTypes;
    }

    private static String jvmdowngrader$toString$toString(SimplePacketTypesProvider simplePacketTypesProvider) {
        SimplePacketTypesProvider simplePacketTypesProvider2 = simplePacketTypesProvider;
        return "SimplePacketTypesProvider[" + "unmappedClientboundPacketTypes=" + simplePacketTypesProvider.unmappedClientboundPacketTypes + ", " + "mappedClientboundPacketTypes=" + simplePacketTypesProvider.mappedClientboundPacketTypes + ", " + "mappedServerboundPacketTypes=" + simplePacketTypesProvider.mappedServerboundPacketTypes + ", " + "unmappedServerboundPacketTypes=" + simplePacketTypesProvider.unmappedServerboundPacketTypes + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(SimplePacketTypesProvider simplePacketTypesProvider) {
        Object[] objectArray = new Object[]{simplePacketTypesProvider.unmappedClientboundPacketTypes, simplePacketTypesProvider.mappedClientboundPacketTypes, simplePacketTypesProvider.mappedServerboundPacketTypes, simplePacketTypesProvider.unmappedServerboundPacketTypes};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(SimplePacketTypesProvider simplePacketTypesProvider, Object object) {
        if (simplePacketTypesProvider == object) {
            return true;
        }
        if (object != null && object instanceof SimplePacketTypesProvider) {
            SimplePacketTypesProvider simplePacketTypesProvider2 = (SimplePacketTypesProvider)object;
            if (Objects.equals(simplePacketTypesProvider.unmappedClientboundPacketTypes, simplePacketTypesProvider2.unmappedClientboundPacketTypes) && Objects.equals(simplePacketTypesProvider.mappedClientboundPacketTypes, simplePacketTypesProvider2.mappedClientboundPacketTypes) && Objects.equals(simplePacketTypesProvider.mappedServerboundPacketTypes, simplePacketTypesProvider2.mappedServerboundPacketTypes) && Objects.equals(simplePacketTypesProvider.unmappedServerboundPacketTypes, simplePacketTypesProvider2.unmappedServerboundPacketTypes)) {
                return true;
            }
        }
        return false;
    }
}


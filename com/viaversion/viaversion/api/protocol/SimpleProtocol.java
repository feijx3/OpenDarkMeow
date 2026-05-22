/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.protocol;

import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={DummyPacketTypes.class})
public interface SimpleProtocol
extends Protocol<DummyPacketTypes, DummyPacketTypes, DummyPacketTypes, DummyPacketTypes> {

    @NestHost(value=SimpleProtocol.class)
    public static final class DummyPacketTypes
    extends Enum<DummyPacketTypes>
    implements ClientboundPacketType,
    ServerboundPacketType {
        private static final /* synthetic */ DummyPacketTypes[] $VALUES;

        public static DummyPacketTypes[] values() {
            return (DummyPacketTypes[])$VALUES.clone();
        }

        public static DummyPacketTypes valueOf(String name) {
            return Enum.valueOf(DummyPacketTypes.class, name);
        }

        @Override
        public int getId() {
            return 0;
        }

        @Override
        public String getName() {
            return this.name();
        }

        @Override
        public Direction direction() {
            throw new UnsupportedOperationException();
        }

        private static /* synthetic */ DummyPacketTypes[] $values() {
            return new DummyPacketTypes[0];
        }

        static {
            $VALUES = DummyPacketTypes.$values();
        }
    }
}


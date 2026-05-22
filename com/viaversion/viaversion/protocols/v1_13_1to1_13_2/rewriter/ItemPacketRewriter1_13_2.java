/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_13_1to1_13_2.rewriter;

import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.Protocol1_13_1To1_13_2;
import com.viaversion.viaversion.util.Key;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={6.class, 5.class, 4.class, 3.class, 2.class, 1.class})
public class ItemPacketRewriter1_13_2 {
    public static void register(Protocol1_13_1To1_13_2 protocol) {
        protocol.registerClientbound(ClientboundPackets1_13.CONTAINER_SET_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.ITEM1_13, Types.ITEM1_13_2);
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.CONTAINER_SET_CONTENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.ITEM1_13_SHORT_ARRAY, Types.ITEM1_13_2_SHORT_ARRAY);
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(wrapper -> {
                    String channel = Key.namespaced(wrapper.get(Types.STRING, 0));
                    if (channel.equals("minecraft:trader_list")) {
                        wrapper.passthrough(Types.INT);
                        int size = wrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
                        for (int i2 = 0; i2 < size; ++i2) {
                            wrapper.write(Types.ITEM1_13_2, wrapper.read(Types.ITEM1_13));
                            wrapper.write(Types.ITEM1_13_2, wrapper.read(Types.ITEM1_13));
                            boolean secondItem = wrapper.passthrough(Types.BOOLEAN);
                            if (secondItem) {
                                wrapper.write(Types.ITEM1_13_2, wrapper.read(Types.ITEM1_13));
                            }
                            wrapper.passthrough(Types.BOOLEAN);
                            wrapper.passthrough(Types.INT);
                            wrapper.passthrough(Types.INT);
                        }
                    }
                });
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.SET_EQUIPPED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_13, Types.ITEM1_13_2);
            }
        });
        protocol.registerClientbound(ClientboundPackets1_13.UPDATE_RECIPES, wrapper -> {
            int recipesNo = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < recipesNo; ++i2) {
                int i1;
                int ingredientsNo;
                wrapper.passthrough(Types.STRING);
                String type = wrapper.passthrough(Types.STRING);
                if (type.equals("crafting_shapeless")) {
                    wrapper.passthrough(Types.STRING);
                    ingredientsNo = wrapper.passthrough(Types.VAR_INT);
                    for (i1 = 0; i1 < ingredientsNo; ++i1) {
                        wrapper.write(Types.ITEM1_13_2_ARRAY, wrapper.read(Types.ITEM1_13_ARRAY));
                    }
                    wrapper.write(Types.ITEM1_13_2, wrapper.read(Types.ITEM1_13));
                    continue;
                }
                if (type.equals("crafting_shaped")) {
                    ingredientsNo = wrapper.passthrough(Types.VAR_INT) * wrapper.passthrough(Types.VAR_INT);
                    wrapper.passthrough(Types.STRING);
                    for (i1 = 0; i1 < ingredientsNo; ++i1) {
                        wrapper.write(Types.ITEM1_13_2_ARRAY, wrapper.read(Types.ITEM1_13_ARRAY));
                    }
                    wrapper.write(Types.ITEM1_13_2, wrapper.read(Types.ITEM1_13));
                    continue;
                }
                if (!type.equals("smelting")) continue;
                wrapper.passthrough(Types.STRING);
                wrapper.write(Types.ITEM1_13_2_ARRAY, wrapper.read(Types.ITEM1_13_ARRAY));
                wrapper.write(Types.ITEM1_13_2, wrapper.read(Types.ITEM1_13));
                wrapper.passthrough(Types.FLOAT);
                wrapper.passthrough(Types.VAR_INT);
            }
        });
        protocol.registerServerbound(ServerboundPackets1_13.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_13_2, Types.ITEM1_13);
            }
        });
        protocol.registerServerbound(ServerboundPackets1_13.SET_CREATIVE_MODE_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.SHORT);
                this.map(Types.ITEM1_13_2, Types.ITEM1_13);
            }
        });
    }
}


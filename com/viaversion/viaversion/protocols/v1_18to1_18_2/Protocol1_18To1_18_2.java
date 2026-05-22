/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocols.v1_18to1_18_2;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.TagUtil;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={3.class, 2.class, 1.class})
public final class Protocol1_18To1_18_2
extends AbstractProtocol<ClientboundPackets1_18, ClientboundPackets1_18, ServerboundPackets1_17, ServerboundPackets1_17> {
    public Protocol1_18To1_18_2() {
        super(ClientboundPackets1_18.class, ClientboundPackets1_18.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        TagRewriter<ClientboundPackets1_18> tagRewriter = new TagRewriter<ClientboundPackets1_18>(this);
        tagRewriter.addTagRaw(RegistryType.BLOCK, "minecraft:fall_damage_resetting", 169, 257, 680, 713, 714, 715, 716, 859, 860, 696, 100);
        tagRewriter.registerGeneric(ClientboundPackets1_18.UPDATE_TAGS);
        this.registerClientbound(ClientboundPackets1_18.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE, Types.VAR_INT);
            }
        });
        this.registerClientbound(ClientboundPackets1_18.REMOVE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE, Types.VAR_INT);
            }
        });
        this.registerClientbound(ClientboundPackets1_18.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(wrapper -> {
                    CompoundTag registry = wrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> dimensions = TagUtil.getRegistryEntries(registry, "dimension_type");
                    for (CompoundTag dimension : dimensions) {
                        Protocol1_18To1_18_2.this.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_18to1_18_2_Protocol1_18To1_18_2$addTagPrefix(dimension.getCompoundTag("element"));
                    }
                    Protocol1_18To1_18_2.this.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_18to1_18_2_Protocol1_18To1_18_2$addTagPrefix(wrapper.get(Types.NAMED_COMPOUND_TAG, 1));
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_18.RESPAWN, wrapper -> this.addTagPrefix(wrapper.passthrough(Types.NAMED_COMPOUND_TAG)));
    }

    private void addTagPrefix(CompoundTag tag) {
        Tag infiniburnTag = tag.get("infiniburn");
        if (infiniburnTag instanceof StringTag) {
            StringTag infiniburn = (StringTag)infiniburnTag;
            infiniburn.setValue(Protocol1_18To1_18_2.jvmdowngrader$concat$addTagPrefix$1(infiniburn.getValue()));
        }
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_18to1_18_2_Protocol1_18To1_18_2$addTagPrefix(CompoundTag compoundTag) {
        this.addTagPrefix(compoundTag);
    }

    private static String jvmdowngrader$concat$addTagPrefix$1(String string) {
        return "#" + string;
    }
}


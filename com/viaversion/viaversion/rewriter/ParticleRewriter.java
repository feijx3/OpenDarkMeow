/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.ItemRewriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={2.class, 1.class})
public class ParticleRewriter<C extends ClientboundPacketType>
implements com.viaversion.viaversion.api.rewriter.ParticleRewriter {
    protected final Protocol<C, ?, ?, ?> protocol;
    private final Type<Particle> particleType;
    private final Type<Particle> mappedParticleType;

    public ParticleRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
        this.particleType = protocol.types() != null ? protocol.types().particle() : null;
        this.mappedParticleType = protocol.mappedTypes() != null ? protocol.mappedTypes().particle() : null;
    }

    public void registerLevelParticles1_13(C packetType, final Type<?> coordType) {
        this.protocol.registerClientbound(packetType, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(coordType);
                this.map(coordType);
                this.map(coordType);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(ParticleRewriter.this.levelParticlesHandler1_13(Types.INT));
            }
        });
    }

    public void registerLevelParticles1_19(C packetType) {
        this.protocol.registerClientbound(packetType, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(ParticleRewriter.this.levelParticlesHandler1_13(Types.VAR_INT));
            }
        });
    }

    public PacketHandler levelParticlesHandler1_13(Type<Integer> idType) {
        return wrapper -> {
            int id = (Integer)wrapper.get(idType, 0);
            if (id == -1) {
                return;
            }
            ParticleMappings mappings = this.protocol.getMappingData().getParticleMappings();
            if (mappings.isBlockParticle(id)) {
                int data = wrapper.read(Types.VAR_INT);
                wrapper.write(Types.VAR_INT, this.protocol.getMappingData().getNewBlockStateId(data));
            } else if (mappings.isItemParticle(id)) {
                ItemRewriter<?> itemRewriter = this.protocol.getItemRewriter();
                Item item = wrapper.read(itemRewriter.itemType());
                wrapper.write(itemRewriter.mappedItemType(), itemRewriter.handleItemToClient(wrapper.user(), item));
            }
            int mappedId = this.protocol.getMappingData().getNewParticleId(id);
            if (mappedId != id) {
                wrapper.set(idType, 0, mappedId);
            }
        };
    }

    public void registerLevelParticles1_20_5(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.INT);
            Particle particle = wrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            this.rewriteParticle(wrapper.user(), particle);
        });
    }

    public void registerLevelParticles1_21_4(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.BOOLEAN);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.INT);
            Particle particle = wrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            this.rewriteParticle(wrapper.user(), particle);
        });
    }

    public void registerExplode1_20_5(C packetType) {
        SoundRewriter<C> soundRewriter = new SoundRewriter<C>(this.protocol);
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.FLOAT);
            int blocks = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < blocks; ++i2) {
                wrapper.passthrough(Types.BYTE);
                wrapper.passthrough(Types.BYTE);
                wrapper.passthrough(Types.BYTE);
            }
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.FLOAT);
            wrapper.passthrough(Types.VAR_INT);
            Particle smallExplosionParticle = wrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            Particle largeExplosionParticle = wrapper.passthroughAndMap(this.particleType, this.mappedParticleType);
            this.rewriteParticle(wrapper.user(), smallExplosionParticle);
            this.rewriteParticle(wrapper.user(), largeExplosionParticle);
            soundRewriter.soundHolderHandler().handle(wrapper);
        });
    }

    public void registerExplode1_21_2(C packetType) {
        SoundRewriter<C> soundRewriter = new SoundRewriter<C>(this.protocol);
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            wrapper.passthrough(Types.DOUBLE);
            if (wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                wrapper.passthrough(Types.DOUBLE);
                wrapper.passthrough(Types.DOUBLE);
                wrapper.passthrough(Types.DOUBLE);
            }
            Particle explosionParticle = wrapper.read(this.particleType);
            wrapper.write(this.mappedParticleType, explosionParticle);
            this.rewriteParticle(wrapper.user(), explosionParticle);
            soundRewriter.soundHolderHandler().handle(wrapper);
        });
    }

    @Override
    public void rewriteParticle(UserConnection connection, Particle particle) {
        ParticleMappings mappings = this.protocol.getMappingData().getParticleMappings();
        ItemRewriter<?> itemRewriter = this.protocol.getItemRewriter();
        int id = particle.id();
        if (mappings.isBlockParticle(id)) {
            Particle.ParticleData<Integer> data = particle.getArgument(0);
            data.setValue(this.protocol.getMappingData().getNewBlockStateId((Integer)data.getValue()));
        } else if (mappings.isItemParticle(id) && itemRewriter != null) {
            Particle.ParticleData<Item> data = particle.getArgument(0);
            Item item = itemRewriter.handleItemToClient(connection, (Item)data.getValue());
            if (itemRewriter.mappedItemType() != null && itemRewriter.itemType() != itemRewriter.mappedItemType()) {
                particle.set(0, itemRewriter.mappedItemType(), item);
            } else {
                data.setValue(item);
            }
        }
        particle.setId(this.protocol.getMappingData().getNewParticleId(id));
    }
}


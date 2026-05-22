/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public final class ParticleRewriter1_20_5
extends ParticleRewriter<ClientboundPacket1_20_3> {
    public ParticleRewriter1_20_5(Protocol<ClientboundPacket1_20_3, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    public void rewriteParticle(UserConnection connection, Particle particle) {
        Particle.ParticleData<StructuredItem> data;
        super.rewriteParticle(connection, particle);
        ParticleMappings particleMappings = this.protocol.getMappingData().getParticleMappings();
        if (particle.id() == particleMappings.mappedId("entity_effect")) {
            particle.add(Types.INT, 0);
        } else if (particle.id() == particleMappings.mappedId("item") && ((Item)(data = particle.getArgument(0)).getValue()).isEmpty()) {
            data.setValue(new StructuredItem(1, 1));
        }
    }
}


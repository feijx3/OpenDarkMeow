/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalSoundEventType.class})
public final class SoundEventType
extends HolderType<SoundEvent> {
    @Override
    public SoundEvent readDirect(ByteBuf buffer) {
        String resourceLocation = (String)Types.STRING.read(buffer);
        Float fixedRange = (Float)Types.OPTIONAL_FLOAT.read(buffer);
        return new SoundEvent(resourceLocation, fixedRange);
    }

    @Override
    public void writeDirect(ByteBuf buffer, SoundEvent value) {
        Types.STRING.write(buffer, value.identifier());
        Types.OPTIONAL_FLOAT.write(buffer, value.fixedRange());
    }

    @NestHost(value=SoundEventType.class)
    public static final class OptionalSoundEventType
    extends HolderType.OptionalHolderType<SoundEvent> {
        public OptionalSoundEventType() {
            super(Types.SOUND_EVENT);
        }
    }
}


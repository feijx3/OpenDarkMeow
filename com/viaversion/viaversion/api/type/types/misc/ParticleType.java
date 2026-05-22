/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.DynamicType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={Readers.class})
public class ParticleType
extends DynamicType<Particle> {
    public ParticleType() {
        super(Particle.class);
    }

    @Override
    public void write(ByteBuf buffer, Particle object) {
        Types.VAR_INT.writePrimitive(buffer, object.id());
        for (Particle.ParticleData<?> data : object.getArguments()) {
            data.write(buffer);
        }
    }

    @Override
    public Particle read(ByteBuf buffer) {
        int type = Types.VAR_INT.readPrimitive(buffer);
        Particle particle = new Particle(type);
        this.readData(buffer, particle);
        return particle;
    }

    @Override
    protected FullMappings mappings(Protocol<?, ?, ?, ?> protocol) {
        return protocol.getMappingData().getParticleMappings();
    }

    public static DynamicType.DataReader<Particle> itemHandler(Type<Item> itemType) {
        return (buf, particle) -> particle.add(itemType, (Item)itemType.read(buf));
    }

    @NestHost(value=ParticleType.class)
    public static final class Readers {
        public static final DynamicType.DataReader<Particle> BLOCK = (buf, particle) -> particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
        public static final DynamicType.DataReader<Particle> ITEM1_13 = ParticleType.itemHandler(Types.ITEM1_13);
        public static final DynamicType.DataReader<Particle> ITEM1_13_2 = ParticleType.itemHandler(Types.ITEM1_13_2);
        public static final DynamicType.DataReader<Particle> DUST = (buf, particle) -> {
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
        };
        public static final DynamicType.DataReader<Particle> DUST1_21_2 = (buf, particle) -> {
            particle.add(Types.INT, Types.INT.readPrimitive(buf));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
        };
        public static final DynamicType.DataReader<Particle> DUST_TRANSITION = (buf, particle) -> {
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
        };
        public static final DynamicType.DataReader<Particle> DUST_TRANSITION1_21_2 = (buf, particle) -> {
            particle.add(Types.INT, Types.INT.readPrimitive(buf));
            particle.add(Types.INT, Types.INT.readPrimitive(buf));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
        };
        public static final DynamicType.DataReader<Particle> VIBRATION = (buf, particle) -> {
            particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(buf));
            String resourceLocation = (String)Types.STRING.read(buf);
            particle.add(Types.STRING, resourceLocation);
            resourceLocation = Key.stripMinecraftNamespace(resourceLocation);
            if (resourceLocation.equals("block")) {
                particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(buf));
            } else if (resourceLocation.equals("entity")) {
                particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
            } else {
                Via.getPlatform().getLogger().warning(Readers.jvmdowngrader$concat$lambda$static$6$1(resourceLocation));
            }
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
        };
        public static final DynamicType.DataReader<Particle> VIBRATION1_19 = (buf, particle) -> {
            String resourceLocation = (String)Types.STRING.read(buf);
            particle.add(Types.STRING, resourceLocation);
            resourceLocation = Key.stripMinecraftNamespace(resourceLocation);
            if (resourceLocation.equals("block")) {
                particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(buf));
            } else if (resourceLocation.equals("entity")) {
                particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
                particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            } else {
                Via.getPlatform().getLogger().warning(Readers.jvmdowngrader$concat$lambda$static$6$1(resourceLocation));
            }
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
        };
        public static final DynamicType.DataReader<Particle> VIBRATION1_20_3 = (buf, particle) -> {
            int sourceTypeId = Types.VAR_INT.readPrimitive(buf);
            particle.add(Types.VAR_INT, sourceTypeId);
            if (sourceTypeId == 0) {
                particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(buf));
            } else if (sourceTypeId == 1) {
                particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
                particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
            } else {
                Via.getPlatform().getLogger().warning(Readers.jvmdowngrader$concat$lambda$static$7$1(sourceTypeId));
            }
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
        };
        public static final DynamicType.DataReader<Particle> SCULK_CHARGE = (buf, particle) -> particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(buf)));
        public static final DynamicType.DataReader<Particle> SHRIEK = (buf, particle) -> particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
        public static final DynamicType.DataReader<Particle> COLOR = (buf, particle) -> particle.add(Types.INT, Types.INT.readPrimitive(buf));
        public static final DynamicType.DataReader<Particle> TRAIL1_21_2 = (buf, particle) -> {
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(buf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(buf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(buf));
            particle.add(Types.INT, Types.INT.readPrimitive(buf));
        };
        public static final DynamicType.DataReader<Particle> TRAIL1_21_4 = (buf, particle) -> {
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(buf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(buf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(buf));
            particle.add(Types.INT, Types.INT.readPrimitive(buf));
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(buf));
        };

        public static DynamicType.DataReader<Particle> item(Type<Item> item) {
            return (buf, particle) -> particle.add(item, (Item)item.read(buf));
        }

        private static String jvmdowngrader$concat$lambda$static$7$1(int n2) {
            return "Unknown vibration path position source type: " + n2;
        }

        private static String jvmdowngrader$concat$lambda$static$6$1(String string) {
            return "Unknown vibration path position source type: " + string;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.api.rewriters;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingDataLoader;
import com.viaversion.viabackwards.api.data.MappedLegacyBlockItem;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriterBase;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.data.BlockColors1_11_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_12;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.IdAndData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={Pos.class, 2.class, 1.class})
public abstract class LegacyBlockItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends BackwardsItemRewriterBase<C, S, T> {
    protected final Int2ObjectMap<MappedLegacyBlockItem> itemReplacements = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);
    protected final Int2ObjectMap<MappedLegacyBlockItem> blockReplacements = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);

    protected LegacyBlockItemRewriter(T protocol, String name, Type<Item> itemType, Type<Item[]> itemArrayType, Type<Item> mappedItemType, Type<Item[]> mappedItemArrayType) {
        super(protocol, itemType, itemArrayType, mappedItemType, mappedItemArrayType, false);
        Int2ObjectOpenHashMap<MappedLegacyBlockItem> blockItemReplacements = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);
        JsonObject jsonObject = this.readMappingsFile(LegacyBlockItemRewriter.jvmdowngrader$concat$$init$$1(name));
        this.addMappings(MappedLegacyBlockItem.Type.ITEM, jsonObject, this.itemReplacements);
        this.addMappings(MappedLegacyBlockItem.Type.BLOCK_ITEM, jsonObject, blockItemReplacements);
        this.addMappings(MappedLegacyBlockItem.Type.BLOCK, jsonObject, this.blockReplacements);
        this.blockReplacements.putAll(blockItemReplacements);
        this.itemReplacements.putAll(blockItemReplacements);
    }

    protected LegacyBlockItemRewriter(T protocol, String name, Type<Item> itemType, Type<Item[]> itemArrayType) {
        this(protocol, name, itemType, itemArrayType, itemType, itemArrayType);
    }

    protected LegacyBlockItemRewriter(T protocol, String name) {
        this(protocol, name, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY);
    }

    private void addMappings(MappedLegacyBlockItem.Type type, JsonObject object, Int2ObjectMap<MappedLegacyBlockItem> mappings) {
        if (object.has(type.getName())) {
            JsonObject mappingsObject = object.getAsJsonObject(type.getName());
            for (Map.Entry<String, JsonElement> dataEntry : mappingsObject.entrySet()) {
                this.addMapping(dataEntry.getKey(), dataEntry.getValue().getAsJsonObject(), type, mappings);
            }
        }
    }

    private void addMapping(String key, JsonObject object, MappedLegacyBlockItem.Type type, Int2ObjectMap<MappedLegacyBlockItem> mappings) {
        String name;
        int id = object.getAsJsonPrimitive("id").getAsInt();
        JsonPrimitive jsonData = object.getAsJsonPrimitive("data");
        short data = jsonData != null ? jsonData.getAsShort() : (short)0;
        String string = name = type != MappedLegacyBlockItem.Type.BLOCK ? object.getAsJsonPrimitive("name").getAsString() : null;
        if (key.indexOf(45) == -1) {
            int unmappedId;
            int dataSeparatorIndex = key.indexOf(58);
            if (dataSeparatorIndex != -1) {
                short unmappedData = Short.parseShort(key.substring(dataSeparatorIndex + 1));
                unmappedId = Integer.parseInt(key.substring(0, dataSeparatorIndex));
                unmappedId = this.compress(unmappedId, unmappedData);
            } else {
                unmappedId = this.compress(Integer.parseInt(key), -1);
            }
            mappings.put(unmappedId, new MappedLegacyBlockItem(id, data, name, type));
            return;
        }
        String[] split = key.split("-", 2);
        int from = Integer.parseInt(split[0]);
        int to = Integer.parseInt(split[1]);
        if (name != null && name.contains("%color%")) {
            for (int i2 = from; i2 <= to; ++i2) {
                mappings.put(this.compress(i2, -1), new MappedLegacyBlockItem(id, data, name.replace("%color%", BlockColors1_11_1.get(i2 - from)), type));
            }
        } else {
            MappedLegacyBlockItem mappedBlockItem = new MappedLegacyBlockItem(id, data, name, type);
            for (int i3 = from; i3 <= to; ++i3) {
                mappings.put(this.compress(i3, -1), mappedBlockItem);
            }
        }
    }

    public void registerBlockChange(C packetType) {
        ((BackwardsProtocol)this.protocol).registerClientbound(packetType, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.VAR_INT);
                this.handler(wrapper -> {
                    int idx = wrapper.get(Types.VAR_INT, 0);
                    wrapper.set(Types.VAR_INT, 0, LegacyBlockItemRewriter.this.handleBlockId(idx));
                });
            }
        });
    }

    public void registerMultiBlockChange(C packetType) {
        ((BackwardsProtocol)this.protocol).registerClientbound(packetType, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BLOCK_CHANGE_ARRAY);
                this.handler(wrapper -> {
                    for (BlockChangeRecord record : wrapper.get(Types.BLOCK_CHANGE_ARRAY, 0)) {
                        record.setBlockId(LegacyBlockItemRewriter.this.handleBlockId(record.getBlockId()));
                    }
                });
            }
        });
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection connection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        MappedLegacyBlockItem data = this.getMappedItem(item.identifier(), item.data());
        if (data == null) {
            return super.handleItemToClient(connection, item);
        }
        if (item.tag() == null) {
            item.setTag(new CompoundTag());
        }
        short originalData = item.data();
        item.tag().putInt(this.nbtTagName("id"), item.identifier());
        item.setIdentifier(data.getId());
        if (data.getData() != -1) {
            item.setData(data.getData());
            item.tag().putShort(this.nbtTagName("data"), originalData);
        }
        if (data.getName() != null) {
            String value;
            StringTag nameTag;
            CompoundTag display = item.tag().getCompoundTag("display");
            if (display == null) {
                display = new CompoundTag();
                item.tag().put("display", display);
            }
            if ((nameTag = display.getStringTag("Name")) == null) {
                nameTag = new StringTag(data.getName());
                display.put("Name", nameTag);
                display.put(this.nbtTagName("customName"), new ByteTag(false));
            }
            if ((value = nameTag.getValue()).contains("%vb_color%")) {
                display.putString("Name", value.replace("%vb_color%", BlockColors1_11_1.get(originalData)));
            }
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection connection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        super.handleItemToServer(connection, item);
        if (item.tag() != null) {
            Tag originalData;
            Tag originalId = item.tag().remove(this.nbtTagName("id"));
            if (originalId instanceof IntTag) {
                item.setIdentifier(((NumberTag)originalId).asInt());
            }
            if ((originalData = item.tag().remove(this.nbtTagName("data"))) instanceof ShortTag) {
                item.setData(((NumberTag)originalData).asShort());
            }
        }
        return item;
    }

    public PacketHandler getFallingBlockHandler() {
        return wrapper -> {
            int objectData = wrapper.get(Types.INT, 0);
            EntityTypes1_12.ObjectType type = EntityTypes1_12.ObjectType.findById(wrapper.get(Types.BYTE, 0).byteValue(), objectData);
            if (type == EntityTypes1_12.ObjectType.FALLING_BLOCK) {
                IdAndData block = this.handleBlock(objectData & 0xFFF, objectData >> 12 & 0xF);
                if (block == null) {
                    return;
                }
                wrapper.set(Types.INT, 0, block.getId() | block.getData() << 12);
            }
        };
    }

    public @Nullable IdAndData handleBlock(int blockId, int data) {
        MappedLegacyBlockItem settings = this.getMappedBlock(blockId, data);
        if (settings == null) {
            return null;
        }
        IdAndData block = settings.getBlock();
        if (block.getData() == -1) {
            return block.withData(data);
        }
        return block;
    }

    public int handleBlockId(int rawId) {
        int data;
        int id = IdAndData.getId(rawId);
        IdAndData mappedBlock = this.handleBlock(id, data = IdAndData.getData(rawId));
        if (mappedBlock == null) {
            return rawId;
        }
        return IdAndData.toRawData(mappedBlock.getId(), mappedBlock.getData());
    }

    public void handleChunk(Chunk chunk) {
        int block;
        MappedLegacyBlockItem settings;
        HashMap<Pos, CompoundTag> tags = new HashMap<Pos, CompoundTag>();
        for (CompoundTag tag : chunk.getBlockEntities()) {
            ChunkSection section;
            NumberTag zTag;
            NumberTag yTag;
            NumberTag xTag = tag.getNumberTag("x");
            if (xTag == null || (yTag = tag.getNumberTag("y")) == null || (zTag = tag.getNumberTag("z")) == null) continue;
            Pos pos = new Pos(xTag.asInt() & 0xF, yTag.asInt(), zTag.asInt() & 0xF);
            tags.put(pos, tag);
            if (pos.y() < 0 || pos.y() > 255 || (section = chunk.getSections()[pos.y() >> 4]) == null || (settings = this.getMappedBlock(block = section.palette(PaletteType.BLOCKS).idAt(pos.x(), pos.y() & 0xF, pos.z()))) == null || !settings.hasBlockEntityHandler()) continue;
            settings.getBlockEntityHandler().handleCompoundTag(block, tag);
        }
        for (int i2 = 0; i2 < chunk.getSections().length; ++i2) {
            ChunkSection section = chunk.getSections()[i2];
            if (section == null) continue;
            boolean hasBlockEntityHandler = false;
            DataPalette palette = section.palette(PaletteType.BLOCKS);
            for (int j2 = 0; j2 < palette.size(); ++j2) {
                MappedLegacyBlockItem settings2;
                int meta;
                int block2 = palette.idByIndex(j2);
                int btype = block2 >> 4;
                IdAndData b2 = this.handleBlock(btype, meta = block2 & 0xF);
                if (b2 != null) {
                    palette.setIdByIndex(j2, IdAndData.toRawData(b2.getId(), b2.getData()));
                }
                if (hasBlockEntityHandler || (settings2 = this.getMappedBlock(block2)) == null || !settings2.hasBlockEntityHandler()) continue;
                hasBlockEntityHandler = true;
            }
            if (!hasBlockEntityHandler) continue;
            for (int x2 = 0; x2 < 16; ++x2) {
                for (int y2 = 0; y2 < 16; ++y2) {
                    for (int z2 = 0; z2 < 16; ++z2) {
                        Pos pos;
                        block = palette.idAt(x2, y2, z2);
                        settings = this.getMappedBlock(block);
                        if (settings == null || !settings.hasBlockEntityHandler() || tags.containsKey(pos = new Pos(x2, y2 + (i2 << 4), z2))) continue;
                        CompoundTag tag = new CompoundTag();
                        tag.putInt("x", x2 + (chunk.getX() << 4));
                        tag.putInt("y", y2 + (i2 << 4));
                        tag.putInt("z", z2 + (chunk.getZ() << 4));
                        settings.getBlockEntityHandler().handleCompoundTag(block, tag);
                        chunk.getBlockEntities().add(tag);
                    }
                }
            }
        }
    }

    protected CompoundTag getNamedTag(String text) {
        CompoundTag tag = new CompoundTag();
        CompoundTag displayTag = new CompoundTag();
        tag.put("display", displayTag);
        text = LegacyBlockItemRewriter.jvmdowngrader$concat$getNamedTag$1(text);
        displayTag.putString("Name", this.jsonNameFormat ? ComponentUtil.legacyToJsonString(text) : text);
        return tag;
    }

    private @Nullable MappedLegacyBlockItem getMappedBlock(int id, int data) {
        MappedLegacyBlockItem mapping = (MappedLegacyBlockItem)this.blockReplacements.get(this.compress(id, data));
        return mapping != null ? mapping : (MappedLegacyBlockItem)this.blockReplacements.get(this.compress(id, -1));
    }

    private @Nullable MappedLegacyBlockItem getMappedItem(int id, int data) {
        MappedLegacyBlockItem mapping = (MappedLegacyBlockItem)this.itemReplacements.get(this.compress(id, data));
        return mapping != null ? mapping : (MappedLegacyBlockItem)this.itemReplacements.get(this.compress(id, -1));
    }

    private @Nullable MappedLegacyBlockItem getMappedBlock(int rawId) {
        int id = IdAndData.getId(rawId);
        int data = IdAndData.getData(rawId);
        return this.getMappedBlock(id, data);
    }

    protected JsonObject readMappingsFile(String name) {
        return BackwardsMappingDataLoader.INSTANCE.loadFromDataDir(name);
    }

    protected int compress(int id, int data) {
        return id << 16 | data & 0xFFFF;
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "item-mappings-" + string + ".json";
    }

    private static String jvmdowngrader$concat$getNamedTag$1(String string) {
        return "\u00a7r" + string;
    }

    @RecordComponents(value={@RecordComponents.Value(name="x", type=int.class), @RecordComponents.Value(name="y", type=short.class), @RecordComponents.Value(name="z", type=int.class)})
    @NestHost(value=LegacyBlockItemRewriter.class)
    private static final class Pos
    extends J_L_Record {
        private final int x;
        private final short y;
        private final int z;

        public Pos(int x2, int y2, int z2) {
            this(x2, (short)y2, z2);
        }

        private Pos(int x2, short y2, int z2) {
            this.x = x2;
            this.y = y2;
            this.z = z2;
        }

        @Override
        public final String toString() {
            return Pos.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return Pos.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Pos.jvmdowngrader$equals$equals(this, o2);
        }

        public int x() {
            return this.x;
        }

        public short y() {
            return this.y;
        }

        public int z() {
            return this.z;
        }

        private static String jvmdowngrader$toString$toString(Pos pos) {
            Pos pos2 = pos;
            return "LegacyBlockItemRewriter$Pos[" + "x=" + pos.x + ", " + "y=" + pos.y + ", " + "z=" + pos.z + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(Pos pos) {
            Object[] objectArray = new Object[]{pos.x, pos.y, pos.z};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Pos pos, Object object) {
            if (pos == object) {
                return true;
            }
            if (object != null && object instanceof Pos) {
                Pos pos2 = (Pos)object;
                if (pos.x == pos2.x && pos.y == pos2.y && pos.z == pos2.z) {
                    return true;
                }
            }
            return false;
        }
    }
}


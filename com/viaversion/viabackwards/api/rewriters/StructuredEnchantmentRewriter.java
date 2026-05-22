/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.api.rewriters;

import ViaBackwards.xyz.wagyourtail.jvmdg.j15.stub.java_base.J_L_String;
import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={PendingIdChange.class, DescriptionSupplier.class})
public class StructuredEnchantmentRewriter {
    protected final BackwardsStructuredItemRewriter<?, ?, ?> itemRewriter;
    private boolean rewriteIds = true;

    public StructuredEnchantmentRewriter(BackwardsStructuredItemRewriter<?, ?, ?> itemRewriter) {
        this.itemRewriter = itemRewriter;
    }

    public void handleToClient(Item item) {
        StructuredDataContainer data = item.dataContainer();
        BackwardsMappingData mappingData = ((BackwardsProtocol)this.itemRewriter.protocol()).getMappingData();
        IdRewriteFunction idRewriteFunction = id -> {
            Mappings mappings = mappingData.getEnchantmentMappings();
            return mappings.getNewId(id);
        };
        DescriptionSupplier descriptionSupplier = (id, level) -> {
            String remappedName = mappingData.mappedEnchantmentName(id);
            return ComponentUtil.jsonStringToTag(ChatUtil.legacyToJsonString(StructuredEnchantmentRewriter.jvmdowngrader$concat$lambda$handleToClient$1$1(remappedName), J_L_String.formatted("enchantment.level.%s", level), true));
        };
        this.rewriteEnchantmentsToClient(data, StructuredDataKey.ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, false);
        this.rewriteEnchantmentsToClient(data, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, true);
    }

    public void handleToServer(Item item) {
        StructuredDataContainer data = item.dataContainer();
        CompoundTag customData = data.get(StructuredDataKey.CUSTOM_DATA);
        if (customData != null) {
            this.rewriteEnchantmentsToServer(data, customData, StructuredDataKey.ENCHANTMENTS1_20_5);
            this.rewriteEnchantmentsToServer(data, customData, StructuredDataKey.STORED_ENCHANTMENTS1_20_5);
        }
    }

    public void rewriteEnchantmentsToClient(StructuredDataContainer data, StructuredDataKey<Enchantments> key, IdRewriteFunction rewriteFunction, DescriptionSupplier descriptionSupplier, boolean storedEnchant) {
        CompoundTag tag;
        Enchantments enchantments = data.get(key);
        if (enchantments == null || enchantments.size() == 0) {
            return;
        }
        ArrayList<Tag> loreToAdd = new ArrayList<Tag>();
        boolean removedEnchantments = false;
        boolean updatedLore = false;
        Iterator iterator2 = enchantments.enchantments().int2IntEntrySet().iterator();
        ArrayList<PendingIdChange> updatedIds = new ArrayList<PendingIdChange>();
        while (iterator2.hasNext()) {
            Tag description;
            Iterator entry = (Int2IntMap.Entry)iterator2.next();
            int id = entry.getIntKey();
            int mappedId = rewriteFunction.rewrite(id);
            int level = entry.getIntValue();
            if (mappedId != -1) {
                if (!this.rewriteIds) continue;
                updatedIds.add(new PendingIdChange(id, mappedId, level));
                continue;
            }
            if (!removedEnchantments) {
                CompoundTag customData = this.customData(data);
                this.itemRewriter.saveListTag(customData, this.asTag(enchantments), key.identifier());
                removedEnchantments = true;
            }
            if ((description = descriptionSupplier.get(id, level)) != null && enchantments.showInTooltip()) {
                loreToAdd.add(description);
                updatedLore = true;
            }
            iterator2.remove();
        }
        for (PendingIdChange change : updatedIds) {
            enchantments.remove(change.id());
        }
        for (PendingIdChange change : updatedIds) {
            enchantments.add(change.mappedId(), change.level());
        }
        if (removedEnchantments) {
            tag = this.customData(data);
            if (!storedEnchant && enchantments.size() == 0) {
                Boolean glintOverride = data.get(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE);
                if (glintOverride != null) {
                    tag.putBoolean(this.itemRewriter.nbtTagName("glint"), glintOverride);
                } else {
                    tag.putBoolean(this.itemRewriter.nbtTagName("noglint"), true);
                }
                data.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, true);
            }
            if (enchantments.showInTooltip()) {
                tag.putBoolean(this.itemRewriter.nbtTagName(StructuredEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$1(key.identifier())), true);
            }
        }
        if (updatedLore) {
            tag = this.customData(data);
            Tag[] lore = data.get(StructuredDataKey.LORE);
            if (lore != null) {
                List<Tag> loreList = Arrays.asList(lore);
                this.itemRewriter.saveGenericTagList(tag, loreList, "lore");
                loreToAdd.addAll(loreList);
            } else {
                tag.putBoolean(this.itemRewriter.nbtTagName("nolore"), true);
            }
            data.set(StructuredDataKey.LORE, loreToAdd.toArray(new Tag[0]));
        }
    }

    private CompoundTag customData(StructuredDataContainer data) {
        CompoundTag tag = data.get(StructuredDataKey.CUSTOM_DATA);
        if (tag == null) {
            tag = new CompoundTag();
            data.set(StructuredDataKey.CUSTOM_DATA, tag);
        }
        return tag;
    }

    private ListTag<CompoundTag> asTag(Enchantments enchantments) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Int2IntMap.Entry entry : enchantments.enchantments().int2IntEntrySet()) {
            CompoundTag enchantment = new CompoundTag();
            enchantment.putInt("id", entry.getIntKey());
            enchantment.putInt("lvl", entry.getIntValue());
            listTag.add(enchantment);
        }
        return listTag;
    }

    public void rewriteEnchantmentsToServer(StructuredDataContainer data, CompoundTag tag, StructuredDataKey<Enchantments> key) {
        ListTag<CompoundTag> enchantmentsTag = this.itemRewriter.removeListTag(tag, key.identifier(), CompoundTag.class);
        if (enchantmentsTag == null) {
            return;
        }
        Tag glintTag = tag.remove(this.itemRewriter.nbtTagName("glint"));
        if (glintTag instanceof ByteTag) {
            data.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, ((NumberTag)glintTag).asBoolean());
        } else if (tag.remove(this.itemRewriter.nbtTagName("noglint")) != null) {
            data.remove(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE);
        }
        List<Tag> lore = this.itemRewriter.removeGenericTagList(tag, "lore");
        if (lore != null) {
            data.set(StructuredDataKey.LORE, lore.toArray(new Tag[0]));
        } else if (tag.remove(this.itemRewriter.nbtTagName("nolore")) != null) {
            data.remove(StructuredDataKey.LORE);
        }
        Enchantments enchantments = new Enchantments(tag.remove(this.itemRewriter.nbtTagName(StructuredEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$1(key.identifier()))) != null);
        for (CompoundTag enchantment : enchantmentsTag) {
            enchantments.add(enchantment.getInt("id"), enchantment.getInt("lvl"));
        }
        data.set(key, enchantments);
    }

    public void setRewriteIds(boolean rewriteIds) {
        this.rewriteIds = rewriteIds;
    }

    private static String jvmdowngrader$concat$rewriteEnchantmentsToClient$1(String string) {
        return "show_" + string;
    }

    private static String jvmdowngrader$concat$lambda$handleToClient$1$1(String string) {
        return "\u00a77" + string;
    }

    @FunctionalInterface
    @NestHost(value=StructuredEnchantmentRewriter.class)
    public static interface DescriptionSupplier {
        public Tag get(int var1, int var2);
    }

    @RecordComponents(value={@RecordComponents.Value(name="id", type=int.class), @RecordComponents.Value(name="mappedId", type=int.class), @RecordComponents.Value(name="level", type=int.class)})
    @NestHost(value=StructuredEnchantmentRewriter.class)
    private static final class PendingIdChange
    extends J_L_Record {
        private final int id;
        private final int mappedId;
        private final int level;

        PendingIdChange(int id, int mappedId, int level) {
            this.id = id;
            this.mappedId = mappedId;
            this.level = level;
        }

        @Override
        public final String toString() {
            return PendingIdChange.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return PendingIdChange.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return PendingIdChange.jvmdowngrader$equals$equals(this, o2);
        }

        public int id() {
            return this.id;
        }

        public int mappedId() {
            return this.mappedId;
        }

        public int level() {
            return this.level;
        }

        private static String jvmdowngrader$toString$toString(PendingIdChange pendingIdChange) {
            PendingIdChange pendingIdChange2 = pendingIdChange;
            return "StructuredEnchantmentRewriter$PendingIdChange[" + "id=" + pendingIdChange.id + ", " + "mappedId=" + pendingIdChange.mappedId + ", " + "level=" + pendingIdChange.level + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(PendingIdChange pendingIdChange) {
            Object[] objectArray = new Object[]{pendingIdChange.id, pendingIdChange.mappedId, pendingIdChange.level};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(PendingIdChange pendingIdChange, Object object) {
            if (pendingIdChange == object) {
                return true;
            }
            if (object != null && object instanceof PendingIdChange) {
                PendingIdChange pendingIdChange2 = (PendingIdChange)object;
                if (pendingIdChange.id == pendingIdChange2.id && pendingIdChange.mappedId == pendingIdChange2.mappedId && pendingIdChange.level == pendingIdChange2.level) {
                    return true;
                }
            }
            return false;
        }
    }
}


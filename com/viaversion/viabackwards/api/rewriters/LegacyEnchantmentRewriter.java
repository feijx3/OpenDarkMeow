/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viaversion.api.minecraft.item.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LegacyEnchantmentRewriter {
    private final Map<Short, String> enchantmentMappings = new HashMap<Short, String>();
    private final String nbtTagName;
    private final boolean dummyEnchantment;
    private Set<Short> hideLevelForEnchants;

    public LegacyEnchantmentRewriter(String nbtTagName) {
        this(nbtTagName, true);
    }

    public LegacyEnchantmentRewriter(String nbtTagName, boolean dummyEnchantment) {
        this.nbtTagName = nbtTagName;
        this.dummyEnchantment = dummyEnchantment;
    }

    public void registerEnchantment(int id, String replacementLore) {
        this.enchantmentMappings.put((short)id, replacementLore);
    }

    public void handleToClient(Item item) {
        CompoundTag tag = item.tag();
        if (tag == null) {
            return;
        }
        if (tag.getListTag("ench") != null) {
            this.rewriteEnchantmentsToClient(tag, false);
        }
        if (tag.getListTag("StoredEnchantments") != null) {
            this.rewriteEnchantmentsToClient(tag, true);
        }
    }

    public void handleToServer(Item item) {
        CompoundTag tag = item.tag();
        if (tag == null) {
            return;
        }
        if (tag.getListTag(LegacyEnchantmentRewriter.jvmdowngrader$concat$handleToServer$1(this.nbtTagName), CompoundTag.class) != null) {
            this.rewriteEnchantmentsToServer(tag, false);
        }
        if (tag.getListTag(LegacyEnchantmentRewriter.jvmdowngrader$concat$handleToServer$2(this.nbtTagName), CompoundTag.class) != null) {
            this.rewriteEnchantmentsToServer(tag, true);
        }
    }

    public void rewriteEnchantmentsToClient(CompoundTag tag, boolean storedEnchant) {
        String key = storedEnchant ? "StoredEnchantments" : "ench";
        ListTag<CompoundTag> enchantments = tag.getListTag(key, CompoundTag.class);
        ListTag<CompoundTag> remappedEnchantments = new ListTag<CompoundTag>(CompoundTag.class);
        ArrayList<StringTag> lore = new ArrayList<StringTag>();
        Iterator iterator2 = ((ListTag)enchantments.copy()).iterator();
        while (iterator2.hasNext()) {
            short level;
            short newId;
            String enchantmentName;
            CompoundTag enchantmentEntry = (CompoundTag)iterator2.next();
            NumberTag idTag = enchantmentEntry.getNumberTag("id");
            if (idTag == null || (enchantmentName = this.enchantmentMappings.get(newId = idTag.asShort())) == null) continue;
            enchantments.remove(enchantmentEntry);
            NumberTag levelTag = enchantmentEntry.getNumberTag("lvl");
            short s2 = level = levelTag != null ? levelTag.asShort() : (short)1;
            if (this.hideLevelForEnchants != null && this.hideLevelForEnchants.contains(newId)) {
                lore.add(new StringTag(enchantmentName));
            } else {
                lore.add(new StringTag(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$1(enchantmentName, EnchantmentRewriter.getRomanNumber(level))));
            }
            remappedEnchantments.add(enchantmentEntry);
        }
        if (!lore.isEmpty()) {
            ListTag<StringTag> loreTag;
            if (this.dummyEnchantment && !storedEnchant && enchantments.isEmpty()) {
                CompoundTag dummyEnchantment = new CompoundTag();
                dummyEnchantment.putShort("id", (short)0);
                dummyEnchantment.putShort("lvl", (short)0);
                enchantments.add(dummyEnchantment);
                tag.put(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$1(this.nbtTagName), new ByteTag(false));
                NumberTag hideFlags = tag.getNumberTag("HideFlags");
                if (hideFlags == null) {
                    hideFlags = new IntTag();
                } else {
                    tag.putInt(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$2(this.nbtTagName), hideFlags.asByte());
                }
                int flags = hideFlags.asByte() | 1;
                tag.putInt("HideFlags", flags);
            }
            tag.put(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$2(this.nbtTagName, key), remappedEnchantments);
            CompoundTag display = tag.getCompoundTag("display");
            if (display == null) {
                display = new CompoundTag();
                tag.put("display", display);
            }
            if ((loreTag = display.getListTag("Lore", StringTag.class)) == null) {
                loreTag = new ListTag<StringTag>(StringTag.class);
                display.put("Lore", loreTag);
            }
            lore.addAll((Collection<StringTag>)loreTag.getValue());
            loreTag.setValue(lore);
        }
    }

    public void rewriteEnchantmentsToServer(CompoundTag tag, boolean storedEnchant) {
        CompoundTag display;
        String key = storedEnchant ? "StoredEnchantments" : "ench";
        ListTag<CompoundTag> enchantments = tag.getListTag(key, CompoundTag.class);
        if (enchantments == null) {
            enchantments = new ListTag<CompoundTag>(CompoundTag.class);
        }
        if (!storedEnchant && tag.remove(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$1(this.nbtTagName)) != null) {
            Iterator iterator2 = ((ListTag)enchantments.copy()).iterator();
            while (iterator2.hasNext()) {
                short level;
                CompoundTag enchantment = (CompoundTag)iterator2.next();
                NumberTag idTag = enchantment.getNumberTag("id");
                NumberTag levelTag = enchantment.getNumberTag("lvl");
                short id = idTag != null ? idTag.asShort() : (short)0;
                short s2 = level = levelTag != null ? levelTag.asShort() : (short)0;
                if (id != 0 || level != 0) continue;
                enchantments.remove(enchantment);
            }
            Tag hideFlags = tag.remove(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$2(this.nbtTagName));
            if (hideFlags instanceof IntTag) {
                IntTag intTag = (IntTag)hideFlags;
                tag.putInt("HideFlags", intTag.asByte());
            } else {
                tag.remove("HideFlags");
            }
        }
        ListTag<StringTag> lore = (display = tag.getCompoundTag("display")) != null ? display.getListTag("Lore", StringTag.class) : null;
        ListTag remappedEnchantments = (ListTag)tag.remove(LegacyEnchantmentRewriter.jvmdowngrader$concat$rewriteEnchantmentsToClient$2(this.nbtTagName, key));
        Iterator iterator3 = ((ListTag)remappedEnchantments.copy()).iterator();
        while (iterator3.hasNext()) {
            CompoundTag enchantment = (CompoundTag)iterator3.next();
            enchantments.add(enchantment);
            if (lore == null || lore.isEmpty()) continue;
            lore.remove(lore.get(0));
        }
        if (lore != null && lore.isEmpty()) {
            display.remove("Lore");
            if (display.isEmpty()) {
                tag.remove("display");
            }
        }
        tag.put(key, enchantments);
    }

    public void setHideLevelForEnchants(int ... enchants) {
        this.hideLevelForEnchants = new HashSet<Short>();
        for (int enchant : enchants) {
            this.hideLevelForEnchants.add((short)enchant);
        }
    }

    private static String jvmdowngrader$concat$handleToServer$1(String string) {
        return string + "|ench";
    }

    private static String jvmdowngrader$concat$handleToServer$2(String string) {
        return string + "|StoredEnchantments";
    }

    private static String jvmdowngrader$concat$rewriteEnchantmentsToClient$1(String string, String string2) {
        return string + " " + string2;
    }

    private static String jvmdowngrader$concat$rewriteEnchantmentsToClient$1(String string) {
        return string + "|dummyEnchant";
    }

    private static String jvmdowngrader$concat$rewriteEnchantmentsToClient$2(String string) {
        return string + "|oldHideFlags";
    }

    private static String jvmdowngrader$concat$rewriteEnchantmentsToClient$2(String string, String string2) {
        return string + "|" + string2;
    }
}


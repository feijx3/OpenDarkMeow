/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.BlockRewriter;

public final class BlockItemPacketRewriter1_21_6
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_6, ServerboundPacket1_21_5, Protocol1_21_6To1_21_5> {
    public BlockItemPacketRewriter1_21_6(Protocol1_21_6To1_21_5 protocol) {
        super(protocol);
    }

    @Override
    public void registerPackets() {
        BlockRewriter<ClientboundPackets1_21_6> blockRewriter = BlockRewriter.for1_20_2(this.protocol);
        blockRewriter.registerBlockEvent(ClientboundPackets1_21_6.BLOCK_EVENT);
        blockRewriter.registerBlockUpdate(ClientboundPackets1_21_6.BLOCK_UPDATE);
        blockRewriter.registerSectionBlocksUpdate1_20(ClientboundPackets1_21_6.SECTION_BLOCKS_UPDATE);
        blockRewriter.registerLevelEvent1_21(ClientboundPackets1_21_6.LEVEL_EVENT, 2001);
        blockRewriter.registerLevelChunk1_19(ClientboundPackets1_21_6.LEVEL_CHUNK_WITH_LIGHT, ChunkType1_21_5::new);
        blockRewriter.registerBlockEntityData(ClientboundPackets1_21_6.BLOCK_ENTITY_DATA);
        ((Protocol1_21_6To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_6.SET_CURSOR_ITEM, x$0 -> this.passthroughClientboundItem(x$0));
        this.registerSetPlayerInventory(ClientboundPackets1_21_6.SET_PLAYER_INVENTORY);
        this.registerCooldown1_21_2(ClientboundPackets1_21_6.COOLDOWN);
        this.registerSetContent1_21_2(ClientboundPackets1_21_6.CONTAINER_SET_CONTENT);
        this.registerSetSlot1_21_2(ClientboundPackets1_21_6.CONTAINER_SET_SLOT);
        this.registerAdvancements1_20_3(ClientboundPackets1_21_6.UPDATE_ADVANCEMENTS);
        this.registerSetEquipment(ClientboundPackets1_21_6.SET_EQUIPMENT);
        this.registerMerchantOffers1_20_5(ClientboundPackets1_21_6.MERCHANT_OFFERS);
        this.registerContainerClick1_21_5(ServerboundPackets1_21_5.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot1_21_5(ServerboundPackets1_21_5.SET_CREATIVE_MODE_SLOT);
        RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_6> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPackets1_21_6>(this.protocol);
        recipeRewriter.registerUpdateRecipes(ClientboundPackets1_21_6.UPDATE_RECIPES);
        recipeRewriter.registerRecipeBookAdd(ClientboundPackets1_21_6.RECIPE_BOOK_ADD);
        recipeRewriter.registerPlaceGhostRecipe(ClientboundPackets1_21_6.PLACE_GHOST_RECIPE);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection connection, Item item, StructuredDataContainer container) {
        com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter.BlockItemPacketRewriter1_21_6.downgradeItemData(item);
        super.handleItemDataComponentsToClient(connection, item, container);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection connection, Item item, StructuredDataContainer container) {
        com.viaversion.viaversion.protocols.v1_21_5to1_21_6.rewriter.BlockItemPacketRewriter1_21_6.upgradeItemData(item);
        super.handleItemDataComponentsToServer(connection, item, container);
    }

    @Override
    protected void backupInconvertibleData(UserConnection connection, Item item, StructuredDataContainer dataContainer, CompoundTag backupTag) {
        Equippable equippable;
        super.backupInconvertibleData(connection, item, dataContainer, backupTag);
        AttributeModifiers1_21 attributeModifiers = dataContainer.get(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6);
        if (attributeModifiers != null) {
            ListTag<CompoundTag> modifiersBackup = new ListTag<CompoundTag>(CompoundTag.class);
            boolean needsBackup = false;
            for (AttributeModifiers1_21.AttributeModifier modifier : attributeModifiers.modifiers()) {
                if (modifier.display().id() != 0) {
                    needsBackup = true;
                }
                CompoundTag modifierBackup = new CompoundTag();
                modifiersBackup.add(modifierBackup);
                modifierBackup.putInt("id", modifier.display().id());
                AttributeModifiers1_21.Display display = modifier.display();
                if (!(display instanceof AttributeModifiers1_21.OverrideText)) continue;
                AttributeModifiers1_21.OverrideText overrideText = (AttributeModifiers1_21.OverrideText)display;
                modifierBackup.put("text", overrideText.component());
            }
            if (needsBackup) {
                backupTag.put("attribute_modifiers_displays", modifiersBackup);
            }
        }
        if ((equippable = dataContainer.get(StructuredDataKey.EQUIPPABLE1_21_6)) != null && equippable.canBeSheared()) {
            CompoundTag equippableTag = new CompoundTag();
            equippableTag.putBoolean("can_be_sheared", true);
            this.saveSoundEventHolder(equippableTag, equippable.shearingSound());
            backupTag.put("equippable", equippableTag);
        }
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer container, CompoundTag customData) {
        CompoundTag equippableTag;
        super.restoreBackupData(item, container, customData);
        Tag tag = customData.remove(this.nbtTagName("backup"));
        if (!(tag instanceof CompoundTag)) {
            return;
        }
        CompoundTag backupTag = (CompoundTag)tag;
        ListTag<CompoundTag> attributeModifiersDisplays = backupTag.getListTag("attribute_modifiers_displays", CompoundTag.class);
        if (attributeModifiersDisplays != null) {
            container.replace(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6, modifiers -> {
                AttributeModifiers1_21.AttributeModifier[] updatedModifiers = new AttributeModifiers1_21.AttributeModifier[modifiers.modifiers().length];
                for (int i2 = 0; i2 < modifiers.modifiers().length; ++i2) {
                    CompoundTag modifierBackup = (CompoundTag)attributeModifiersDisplays.get(i2);
                    int id = modifierBackup.getInt("id");
                    AttributeModifiers1_21.Display display = id == 2 ? new AttributeModifiers1_21.OverrideText(modifierBackup.get("text")) : new AttributeModifiers1_21.Display(id);
                    AttributeModifiers1_21.AttributeModifier modifier = modifiers.modifiers()[i2];
                    updatedModifiers[i2] = new AttributeModifiers1_21.AttributeModifier(modifier.attribute(), modifier.modifier(), modifier.slotType(), display);
                }
                return new AttributeModifiers1_21(updatedModifiers);
            });
        }
        if ((equippableTag = backupTag.getCompoundTag("equippable")) != null) {
            container.replace(StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.EQUIPPABLE1_21_6, equippable -> new Equippable(equippable.equipmentSlot(), equippable.soundEvent(), equippable.model(), equippable.cameraOverlay(), equippable.allowedEntities(), equippable.dispensable(), equippable.swappable(), equippable.damageOnHurt(), equippable.equipOnInteract(), equippableTag.getBoolean("can_be_sheared"), this.restoreSoundEventHolder(equippableTag)));
        }
    }
}


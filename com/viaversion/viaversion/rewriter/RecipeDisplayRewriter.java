/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.rewriter.ItemRewriter;
import com.viaversion.viaversion.api.type.Types;

public class RecipeDisplayRewriter<C extends ClientboundPacketType> {
    protected final Protocol<C, ?, ?, ?> protocol;

    public RecipeDisplayRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    public void registerUpdateRecipes(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.passthrough(Types.STRING);
                this.rewriteItemIds(wrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE));
            }
            int stonecutterRecipesSize = wrapper.passthrough(Types.VAR_INT);
            for (int i3 = 0; i3 < stonecutterRecipesSize; ++i3) {
                this.handleIngredient(wrapper);
                this.handleSlotDisplay(wrapper);
            }
        });
    }

    public void registerRecipeBookAdd(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            int size = wrapper.passthrough(Types.VAR_INT);
            for (int i2 = 0; i2 < size; ++i2) {
                wrapper.passthrough(Types.VAR_INT);
                this.handleRecipeDisplay(wrapper);
                wrapper.passthrough(Types.OPTIONAL_VAR_INT);
                wrapper.passthrough(Types.VAR_INT);
                if (wrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    int ingredientsSize = wrapper.passthrough(Types.VAR_INT);
                    for (int j2 = 0; j2 < ingredientsSize; ++j2) {
                        this.handleIngredient(wrapper);
                    }
                }
                wrapper.passthrough(Types.BYTE);
            }
        });
    }

    public void registerPlaceGhostRecipe(C packetType) {
        this.protocol.registerClientbound(packetType, wrapper -> {
            wrapper.passthrough(Types.VAR_INT);
            this.handleRecipeDisplay(wrapper);
        });
    }

    protected void handleShapeless(PacketWrapper wrapper) {
        this.handleSlotDisplayList(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
    }

    protected void handleShaped(PacketWrapper wrapper) {
        wrapper.passthrough(Types.VAR_INT);
        wrapper.passthrough(Types.VAR_INT);
        this.handleSlotDisplayList(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
    }

    protected void handleFurnace(PacketWrapper wrapper) {
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        wrapper.passthrough(Types.VAR_INT);
        wrapper.passthrough(Types.FLOAT);
    }

    protected void handleStoneCutter(PacketWrapper wrapper) {
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
    }

    protected void handleSmithing(PacketWrapper wrapper) {
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
    }

    protected void handleRecipeDisplay(PacketWrapper wrapper) {
        int type = wrapper.passthrough(Types.VAR_INT);
        switch (type) {
            case 0: {
                this.handleShapeless(wrapper);
                break;
            }
            case 1: {
                this.handleShaped(wrapper);
                break;
            }
            case 2: {
                this.handleFurnace(wrapper);
                break;
            }
            case 3: {
                this.handleStoneCutter(wrapper);
                break;
            }
            case 4: {
                this.handleSmithing(wrapper);
            }
        }
    }

    protected void handleSlotDisplay(PacketWrapper wrapper) {
        int type = wrapper.passthrough(Types.VAR_INT);
        switch (type) {
            case 2: {
                this.handleItemId(wrapper);
                break;
            }
            case 3: {
                this.handleItem(wrapper);
                break;
            }
            case 4: {
                wrapper.passthrough(Types.STRING);
                break;
            }
            case 5: {
                this.handleSmithingTrimSlotDisplay(wrapper);
                break;
            }
            case 6: {
                this.handleWithRemainderSlotDisplay(wrapper);
                break;
            }
            case 7: {
                this.handleSlotDisplayList(wrapper);
            }
        }
    }

    protected void handleSlotDisplayList(PacketWrapper wrapper) {
        int size = wrapper.passthrough(Types.VAR_INT);
        for (int i2 = 0; i2 < size; ++i2) {
            this.handleSlotDisplay(wrapper);
        }
    }

    protected void handleSmithingTrimSlotDisplay(PacketWrapper wrapper) {
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
    }

    protected void handleWithRemainderSlotDisplay(PacketWrapper wrapper) {
        this.handleSlotDisplay(wrapper);
        this.handleSlotDisplay(wrapper);
    }

    protected void handleIngredient(PacketWrapper wrapper) {
        HolderSet items = wrapper.passthrough(Types.HOLDER_SET);
        if (items.hasTagKey()) {
            return;
        }
        int[] ids = items.ids();
        for (int i2 = 0; i2 < ids.length; ++i2) {
            ids[i2] = this.rewriteItemId(ids[i2]);
        }
    }

    protected void handleItemId(PacketWrapper wrapper) {
        int id = wrapper.read(Types.VAR_INT);
        wrapper.write(Types.VAR_INT, this.rewriteItemId(id));
    }

    protected void handleItem(PacketWrapper wrapper) {
        ItemRewriter<?> itemRewriter = this.protocol.getItemRewriter();
        Item item = wrapper.read(itemRewriter.itemType());
        itemRewriter.handleItemToClient(wrapper.user(), item);
        wrapper.write(itemRewriter.mappedItemType(), item);
    }

    protected int rewriteItemId(int id) {
        if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getItemMappings() != null) {
            return this.protocol.getMappingData().getItemMappings().getNewIdOrDefault(id, id);
        }
        return id;
    }

    protected void rewriteItemIds(int[] ids) {
        for (int i2 = 0; i2 < ids.length; ++i2) {
            int id = ids[i2];
            ids[i2] = this.rewriteItemId(id);
        }
    }
}


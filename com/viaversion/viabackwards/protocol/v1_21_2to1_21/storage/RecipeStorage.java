/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.google.common.base.Preconditions;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={StoneCutterRecipe.class, FurnaceRecipe.class, ShapedRecipe.class, ShapelessRecipe.class, Recipe.class})
public final class RecipeStorage
implements StorableObject {
    public static final int RECIPE_BOOK_SETTINGS = 8;
    private static final String[] EMPTY_STRINGS = new String[0];
    private final List<Recipe> recipes = new ArrayList<Recipe>();
    private final List<Recipe> tempRecipes = new ArrayList<Recipe>();
    private final List<StoneCutterRecipe> stoneCutterRecipes = new ArrayList<StoneCutterRecipe>();
    private boolean[] recipeBookSettings = new boolean[8];
    private final Protocol1_21_2To1_21 protocol;

    public RecipeStorage(Protocol1_21_2To1_21 protocol) {
        this.protocol = protocol;
    }

    public void sendRecipes(UserConnection connection) {
        if (!this.tempRecipes.isEmpty()) {
            this.recipes.addAll(this.tempRecipes);
            this.tempRecipes.clear();
        }
        int highestIndex = -1;
        for (Recipe recipe : this.recipes) {
            highestIndex = Math.max(highestIndex, recipe.index);
        }
        ArrayList<Recipe> recipes = new ArrayList<Recipe>(this.recipes);
        for (StoneCutterRecipe recipe : this.stoneCutterRecipes) {
            recipe.index = ++highestIndex;
            recipes.add(recipe);
        }
        recipes.sort(Comparator.comparingInt(a2 -> a2.index));
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21.UPDATE_RECIPES, connection);
        packetWrapper.write(Types.VAR_INT, recipes.size());
        for (Recipe recipe : recipes) {
            packetWrapper.write(Types.STRING, RecipeStorage.identifier(recipe.index));
            recipe.write(packetWrapper);
        }
        packetWrapper.send(Protocol1_21_2To1_21.class);
        this.sendUnlockedRecipes(connection, recipes);
    }

    private static String identifier(int recipeIndex) {
        return String.format("%06d", recipeIndex);
    }

    public void lockRecipes(PacketWrapper wrapper, int[] ids) {
        for (int n2 : ids) {
            this.recipes.removeIf(recipe -> recipe.index == id);
        }
        wrapper.write(Types.VAR_INT, 2);
        for (boolean bl2 : this.recipeBookSettings) {
            wrapper.write(Types.BOOLEAN, bl2);
        }
        String[] stringArray = new String[ids.length];
        for (int i2 = 0; i2 < ids.length; ++i2) {
            stringArray[i2] = RecipeStorage.identifier(ids[i2]);
        }
        wrapper.write(Types.STRING_ARRAY, stringArray);
    }

    private void sendUnlockedRecipes(UserConnection connection, List<Recipe> recipes) {
        PacketWrapper wrapper = PacketWrapper.create(ClientboundPackets1_21.RECIPE, connection);
        wrapper.write(Types.VAR_INT, 0);
        for (boolean recipeBookSetting : this.recipeBookSettings) {
            wrapper.write(Types.BOOLEAN, recipeBookSetting);
        }
        String[] recipeKeys = new String[recipes.size()];
        ArrayList<String> highlightRecipes = new ArrayList<String>();
        for (int i2 = 0; i2 < recipes.size(); ++i2) {
            recipeKeys[i2] = RecipeStorage.identifier(recipes.get((int)i2).index);
            if (!recipes.get(i2).jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$get$highlight()) continue;
            highlightRecipes.add(recipeKeys[i2]);
        }
        wrapper.write(Types.STRING_ARRAY, recipeKeys);
        wrapper.write(Types.STRING_ARRAY, highlightRecipes.toArray(EMPTY_STRINGS));
        wrapper.send(Protocol1_21_2To1_21.class);
    }

    public void readRecipe(PacketWrapper wrapper) {
        Recipe recipe;
        int id = wrapper.read(Types.VAR_INT);
        int type = wrapper.passthrough(Types.VAR_INT);
        switch (type) {
            case 0: {
                recipe = this.readShapeless(wrapper);
                break;
            }
            case 1: {
                recipe = this.readShaped(wrapper);
                break;
            }
            case 2: {
                recipe = this.readFurnace(wrapper);
                break;
            }
            case 3: {
                recipe = this.readStoneCutter(wrapper);
                break;
            }
            case 4: {
                recipe = this.readSmithing(wrapper);
                break;
            }
            default: {
                recipe = null;
            }
        }
        Recipe recipe2 = recipe;
        Integer group = wrapper.read(Types.OPTIONAL_VAR_INT);
        int category = wrapper.read(Types.VAR_INT);
        if (wrapper.read(Types.BOOLEAN).booleanValue()) {
            int ingredientsSize = wrapper.read(Types.VAR_INT);
            for (int j2 = 0; j2 < ingredientsSize; ++j2) {
                wrapper.read(Types.HOLDER_SET);
            }
        }
        byte flags = wrapper.read(Types.BYTE);
        if (recipe2 != null) {
            recipe2.index = id;
            recipe2.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$set$group(group);
            recipe2.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$set$category(category);
            recipe2.jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$set$highlight((flags & 2) != 0);
        }
    }

    private Recipe readShapeless(PacketWrapper wrapper) {
        Item[][] ingredients = this.readSlotDisplayList(wrapper);
        Item result = this.readSingleSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        return this.add(new ShapelessRecipe(ingredients, result));
    }

    private Recipe readShaped(PacketWrapper wrapper) {
        int width = wrapper.passthrough(Types.VAR_INT);
        int height = wrapper.passthrough(Types.VAR_INT);
        Item[][] ingredients = this.readSlotDisplayList(wrapper);
        Item result = this.readSingleSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        return this.add(new ShapedRecipe(width, height, ingredients, result));
    }

    private Recipe readFurnace(PacketWrapper wrapper) {
        Item[] ingredient = this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        Item result = this.readSingleSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        int duration = wrapper.read(Types.VAR_INT);
        float experience = wrapper.read(Types.FLOAT).floatValue();
        return this.add(new FurnaceRecipe(ingredient, result, duration, experience));
    }

    private Recipe readStoneCutter(PacketWrapper wrapper) {
        this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        return null;
    }

    private Recipe readSmithing(PacketWrapper wrapper) {
        this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        this.readSlotDisplay(wrapper);
        return null;
    }

    private Recipe add(Recipe recipe) {
        this.tempRecipes.add(recipe);
        return recipe;
    }

    private Item[][] readSlotDisplayList(PacketWrapper wrapper) {
        int size = wrapper.passthrough(Types.VAR_INT);
        Item[][] ingredients = new Item[size][];
        for (int i2 = 0; i2 < size; ++i2) {
            ingredients[i2] = this.readSlotDisplay(wrapper);
        }
        return ingredients;
    }

    private Item readSingleSlotDisplay(PacketWrapper wrapper) {
        Item[] items = this.readSlotDisplay(wrapper);
        return items.length == 0 ? new StructuredItem(1, 1) : items[0];
    }

    private Item[] readSlotDisplay(PacketWrapper wrapper) {
        Item[] itemArray;
        int type = wrapper.read(Types.VAR_INT);
        switch (type) {
            case 2: {
                int id = wrapper.read(Types.VAR_INT);
                if (id == 0) {
                    this.protocol.getLogger().warning("Empty item id in recipe");
                    itemArray = new Item[]{};
                    break;
                }
                Item[] itemArray2 = new Item[1];
                itemArray = itemArray2;
                itemArray2[0] = new StructuredItem(this.rewriteItemId(id), 1);
                break;
            }
            case 3: {
                Item item = wrapper.read(VersionedTypes.V1_21_2.item());
                this.protocol.getItemRewriter().handleItemToClient(wrapper.user(), item);
                if (item.isEmpty()) {
                    this.protocol.getLogger().warning("Empty item in recipe");
                    itemArray = new Item[]{};
                    break;
                }
                Item[] itemArray3 = new Item[1];
                itemArray = itemArray3;
                itemArray3[0] = item;
                break;
            }
            case 4: {
                wrapper.read(Types.STRING);
                itemArray = new Item[]{};
                break;
            }
            case 5: {
                this.readSlotDisplay(wrapper);
                this.readSlotDisplay(wrapper);
                this.readSlotDisplay(wrapper);
                itemArray = new Item[]{};
                break;
            }
            case 6: {
                this.readSlotDisplay(wrapper);
                this.readSlotDisplay(wrapper);
                itemArray = new Item[]{};
                break;
            }
            case 7: {
                itemArray = this.readSlotDisplayList(wrapper)[0];
                break;
            }
            default: {
                itemArray = new Item[]{};
            }
        }
        return itemArray;
    }

    private int rewriteItemId(int id) {
        return this.protocol.getMappingData().getNewItemId(id);
    }

    public void readStoneCutterRecipes(PacketWrapper wrapper) {
        this.stoneCutterRecipes.clear();
        int stonecutterRecipesSize = wrapper.read(Types.VAR_INT);
        for (int i2 = 0; i2 < stonecutterRecipesSize; ++i2) {
            Item[] ingredient = this.readHolderSet(wrapper);
            Item result = this.readSingleSlotDisplay(wrapper);
            this.stoneCutterRecipes.add(new StoneCutterRecipe(ingredient, result));
        }
    }

    private Item[] readHolderSet(PacketWrapper wrapper) {
        HolderSet holderSet = wrapper.read(Types.HOLDER_SET);
        if (holderSet.hasTagKey()) {
            return new Item[]{new StructuredItem(1, 1)};
        }
        int[] ids = holderSet.ids();
        for (int i2 = 0; i2 < ids.length; ++i2) {
            ids[i2] = this.rewriteItemId(ids[i2]);
        }
        Item[] ingredient = new Item[ids.length];
        for (int i3 = 0; i3 < ingredient.length; ++i3) {
            ingredient[i3] = new StructuredItem(ids[i3], 1);
        }
        return ingredient;
    }

    public void setRecipeBookSettings(boolean[] recipeBookSettings) {
        this.recipeBookSettings = recipeBookSettings;
    }

    public void clearRecipes() {
        this.recipes.clear();
    }

    @NestHost(value=RecipeStorage.class)
    static abstract class Recipe {
        private static final int FOOD_CRAFTING_BOOK_CATEGORY = 0;
        private static final int BLOCKS_CRAFTING_BOOK_CATEGORY = 1;
        private static final int MISC_CRAFTING_BOOK_CATEGORY = 2;
        protected int index;
        private Integer group;
        private int category;
        private boolean highlight;

        Recipe() {
        }

        abstract void write(PacketWrapper var1);

        void writeGroup(PacketWrapper wrapper) {
            wrapper.write(Types.STRING, this.group != null ? Integer.toString(this.group) : "");
        }

        void writeIngredients(PacketWrapper wrapper, Item[][] ingredients) {
            wrapper.write(Types.VAR_INT, ingredients.length);
            for (Item[] ingredient : ingredients) {
                this.writeIngredient(wrapper, ingredient);
            }
        }

        void writeIngredient(PacketWrapper wrapper, Item[] ingredient) {
            Item[] copy = new Item[ingredient.length];
            for (int i2 = 0; i2 < ingredient.length; ++i2) {
                copy[i2] = ingredient[i2].copy();
            }
            wrapper.write(VersionedTypes.V1_21_2.itemArray(), copy);
        }

        void writeResult(PacketWrapper wrapper, Item result) {
            wrapper.write(VersionedTypes.V1_21_2.item(), result.copy());
        }

        void writeCategory(PacketWrapper wrapper) {
            int n2;
            switch (this.category) {
                case 4: 
                case 9: 
                case 12: {
                    n2 = 0;
                    break;
                }
                case 0: 
                case 5: 
                case 7: 
                case 10: {
                    n2 = 1;
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 6: 
                case 8: 
                case 11: {
                    n2 = 2;
                    break;
                }
                default: {
                    n2 = 2;
                }
            }
            int craftingBookCategory = n2;
            wrapper.write(Types.VAR_INT, craftingBookCategory);
        }

        int category() {
            return this.category;
        }

        public int jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$get$category() {
            return this.category;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$set$category(int n2) {
            this.category = n2;
        }

        public boolean jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$get$highlight() {
            return this.highlight;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$set$highlight(boolean bl2) {
            this.highlight = bl2;
        }

        public Integer jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$get$group() {
            return this.group;
        }

        public void jvmdowngrader$nest$com_viaversion_viabackwards_protocol_v1_21_2to1_21_storage_RecipeStorage$Recipe$set$group(Integer n2) {
            this.group = n2;
        }
    }

    @NestHost(value=RecipeStorage.class)
    private static final class StoneCutterRecipe
    extends Recipe {
        private static final int SERIALIZER_ID = 19;
        private final Item[] ingredient;
        private final Item result;

        StoneCutterRecipe(Item[] ingredient, Item result) {
            this.ingredient = ingredient;
            this.result = result;
        }

        @Override
        public void write(PacketWrapper wrapper) {
            wrapper.write(Types.VAR_INT, 19);
            this.writeGroup(wrapper);
            this.writeIngredient(wrapper, this.ingredient);
            this.writeResult(wrapper, this.result);
        }
    }

    @NestHost(value=RecipeStorage.class)
    private static final class ShapelessRecipe
    extends Recipe {
        private static final int SERIALIZER_ID = 1;
        private final Item[][] ingredients;
        private final Item result;

        ShapelessRecipe(Item[][] ingredients, Item result) {
            this.ingredients = ingredients;
            this.result = result;
        }

        @Override
        public void write(PacketWrapper wrapper) {
            wrapper.write(Types.VAR_INT, 1);
            this.writeGroup(wrapper);
            this.writeCategory(wrapper);
            this.writeIngredients(wrapper, this.ingredients);
            this.writeResult(wrapper, this.result);
        }
    }

    @NestHost(value=RecipeStorage.class)
    private static final class ShapedRecipe
    extends Recipe {
        private static final int SERIALIZER_ID = 0;
        private final int width;
        private final int height;
        private final Item[][] ingredients;
        private final Item result;

        ShapedRecipe(int width, int height, Item[][] ingredients, Item result) {
            this.width = width;
            this.height = height;
            this.ingredients = ingredients;
            this.result = result;
        }

        @Override
        public void write(PacketWrapper wrapper) {
            wrapper.write(Types.VAR_INT, 0);
            this.writeGroup(wrapper);
            this.writeCategory(wrapper);
            wrapper.write(Types.VAR_INT, this.width);
            wrapper.write(Types.VAR_INT, this.height);
            Preconditions.checkArgument((this.width * this.height == this.ingredients.length ? 1 : 0) != 0, (Object)"Invalid shaped recipe");
            for (Item[] ingredient : this.ingredients) {
                this.writeIngredient(wrapper, ingredient);
            }
            this.writeResult(wrapper, this.result);
            wrapper.write(Types.BOOLEAN, false);
        }
    }

    @NestHost(value=RecipeStorage.class)
    private static final class FurnaceRecipe
    extends Recipe {
        private final Item[] ingredient;
        private final Item result;
        private final float experience;
        private final int cookingTime;

        FurnaceRecipe(Item[] ingredient, Item result, int cookingTime, float experience) {
            this.ingredient = ingredient;
            this.result = result;
            this.experience = experience;
            this.cookingTime = cookingTime;
        }

        @Override
        public void write(PacketWrapper wrapper) {
            wrapper.write(Types.VAR_INT, this.serializerId());
            this.writeGroup(wrapper);
            this.writeCategory(wrapper);
            this.writeIngredient(wrapper, this.ingredient);
            this.writeResult(wrapper, this.result);
            wrapper.write(Types.FLOAT, Float.valueOf(this.experience));
            wrapper.write(Types.VAR_INT, this.cookingTime);
        }

        private int serializerId() {
            int n2;
            switch (this.category()) {
                case 4: 
                case 5: 
                case 6: {
                    n2 = 15;
                    break;
                }
                case 7: 
                case 8: {
                    n2 = 16;
                    break;
                }
                case 9: {
                    n2 = 17;
                    break;
                }
                case 12: {
                    n2 = 18;
                    break;
                }
                default: {
                    n2 = 15;
                }
            }
            return n2;
        }
    }
}


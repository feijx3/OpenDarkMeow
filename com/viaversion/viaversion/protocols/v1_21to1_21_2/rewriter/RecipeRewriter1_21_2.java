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
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={StoneCutterRecipe.class, FurnaceRecipe.class, ShapedRecipe.class, ShapelessRecipe.class, Recipe.class})
final class RecipeRewriter1_21_2
extends RecipeRewriter1_20_3<ClientboundPacket1_21>
implements StorableObject {
    private static final int[] EMPTY_ARRAY = new int[0];
    private final List<StoneCutterRecipe> stoneCutterRecipes = new ArrayList<StoneCutterRecipe>();
    private final Object2IntMap<String> recipeGroups = new Object2IntOpenHashMap<String>();
    private final Map<String, Recipe> recipesByKey = new HashMap<String, Recipe>();
    private final Map<String, IntSet> recipeInputs = new Object2ObjectArrayMap<String, IntSet>();
    private final List<Recipe> recipes = new ArrayList<Recipe>();
    private String currentRecipeIdentifier;

    public void setCurrentRecipeIdentifier(String recipeIdentifier) {
        this.currentRecipeIdentifier = Key.stripMinecraftNamespace(recipeIdentifier);
    }

    RecipeRewriter1_21_2(Protocol<ClientboundPacket1_21, ?, ?, ?> protocol) {
        super(protocol);
        this.recipeGroups.defaultReturnValue(-1);
        this.recipeHandlers.put("smelting", wrapper -> this.handleSmelting("furnace_input", wrapper));
        this.recipeHandlers.put("blasting", wrapper -> this.handleSmelting("blast_furnace_input", wrapper));
        this.recipeHandlers.put("smoking", wrapper -> this.handleSmelting("smoker_input", wrapper));
        this.recipeHandlers.put("campfire_cooking", wrapper -> this.handleSmelting("campfire_input", wrapper));
    }

    @Override
    public void handleSimpleRecipe(PacketWrapper wrapper) {
        int category = wrapper.read(Types.VAR_INT);
    }

    @Override
    public void handleStonecutting(PacketWrapper wrapper) {
        int group = this.readRecipeGroup(wrapper);
        Item[] ingredient = this.readIngredient(wrapper);
        Item result = this.rewrite(wrapper.user(), wrapper.read(this.itemType()));
        StoneCutterRecipe recipe = new StoneCutterRecipe(this.currentRecipeIdentifier, group, ingredient, result);
        this.stoneCutterRecipes.add(recipe);
    }

    private void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
        this.recipesByKey.put(this.currentRecipeIdentifier, recipe);
    }

    @Override
    public void handleSmithingTransform(PacketWrapper wrapper) {
        this.readRecipeInputs("smithing_template", wrapper);
        this.readRecipeInputs("smithing_base", wrapper);
        this.readRecipeInputs("smithing_addition", wrapper);
        wrapper.read(this.itemType());
    }

    @Override
    public void handleSmithingTrim(PacketWrapper wrapper) {
        this.readRecipeInputs("smithing_template", wrapper);
        this.readRecipeInputs("smithing_base", wrapper);
        this.readRecipeInputs("smithing_addition", wrapper);
    }

    @Override
    public void handleCraftingShaped(PacketWrapper wrapper) {
        int group = this.readRecipeGroup(wrapper);
        int category = wrapper.read(Types.VAR_INT);
        int width = wrapper.read(Types.VAR_INT);
        int height = wrapper.read(Types.VAR_INT);
        int ingredientsSize = width * height;
        Item[][] ingredients = new Item[ingredientsSize][];
        for (int i2 = 0; i2 < ingredientsSize; ++i2) {
            ingredients[i2] = this.readIngredient(wrapper);
        }
        Item result = this.rewrite(wrapper.user(), wrapper.read(this.itemType()));
        boolean showNotification = wrapper.read(Types.BOOLEAN);
        ShapedRecipe recipe = new ShapedRecipe(this.recipesByKey.size(), this.currentRecipeIdentifier, group, category, width, height, ingredients, result, showNotification);
        this.addRecipe(recipe);
    }

    @Override
    public void handleCraftingShapeless(PacketWrapper wrapper) {
        int group = this.readRecipeGroup(wrapper);
        int category = wrapper.read(Types.VAR_INT);
        int ingredientsSize = wrapper.read(Types.VAR_INT);
        Item[][] ingredients = new Item[ingredientsSize][];
        for (int i2 = 0; i2 < ingredientsSize; ++i2) {
            ingredients[i2] = this.readIngredient(wrapper);
        }
        Item result = this.rewrite(wrapper.user(), wrapper.read(this.itemType()));
        ShapelessRecipe recipe = new ShapelessRecipe(this.recipesByKey.size(), this.currentRecipeIdentifier, group, category, ingredients, result);
        this.addRecipe(recipe);
    }

    public void handleSmelting(String key, PacketWrapper wrapper) {
        int group = this.readRecipeGroup(wrapper);
        int category = wrapper.read(Types.VAR_INT);
        Item[] ingredient = this.readRecipeInputs(key, wrapper);
        Item result = this.rewrite(wrapper.user(), wrapper.read(this.itemType()));
        float experience = wrapper.read(Types.FLOAT).floatValue();
        int cookingTime = wrapper.read(Types.VAR_INT);
        FurnaceRecipe recipe = new FurnaceRecipe(this.recipesByKey.size(), this.currentRecipeIdentifier, group, category, ingredient, result, cookingTime, experience);
        this.addRecipe(recipe);
    }

    private int readRecipeGroup(PacketWrapper wrapper) {
        String recipeGroup = Key.stripMinecraftNamespace(wrapper.read(Types.STRING));
        if (recipeGroup.isEmpty()) {
            return -1;
        }
        if (this.recipeGroups.containsKey(recipeGroup)) {
            return this.recipeGroups.getInt(recipeGroup);
        }
        int size = this.recipeGroups.size();
        this.recipeGroups.put(recipeGroup, size);
        return size;
    }

    private Item[] readIngredient(PacketWrapper wrapper) {
        Item[] items = wrapper.read(this.itemArrayType());
        for (int i2 = 0; i2 < items.length; ++i2) {
            Item item = items[i2];
            items[i2] = this.rewrite(wrapper.user(), item);
        }
        return items;
    }

    public HolderSet toHolderSet(Item[] ingredient) {
        int[] ids = new int[ingredient.length];
        for (int i2 = 0; i2 < ingredient.length; ++i2) {
            ids[i2] = ingredient[i2].identifier();
        }
        return HolderSet.of(ids);
    }

    public @Nullable Recipe recipe(String key) {
        return this.recipesByKey.get(Key.stripMinecraftNamespace(key));
    }

    public @Nullable Recipe recipe(int displayId) {
        return displayId >= 0 && displayId < this.recipes.size() ? this.recipes.get(displayId) : null;
    }

    public void finalizeRecipes() {
        this.stoneCutterRecipes.sort(Comparator.comparing(recipe -> recipe.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$StoneCutterRecipe$get$identifier()));
    }

    public void writeUpdateRecipeInputs(PacketWrapper wrapper) {
        wrapper.write(Types.VAR_INT, this.recipeInputs.size());
        for (Map.Entry<String, IntSet> entry : this.recipeInputs.entrySet()) {
            wrapper.write(Types.STRING, entry.getKey());
            wrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, entry.getValue().toArray(EMPTY_ARRAY));
        }
        wrapper.write(Types.VAR_INT, this.stoneCutterRecipes.size());
        for (StoneCutterRecipe recipe : this.stoneCutterRecipes) {
            HolderSet ingredient = this.toHolderSet(recipe.ingredient());
            wrapper.write(Types.HOLDER_SET, ingredient);
            RecipeRewriter1_21_2.writeItemDisplay(wrapper, recipe.result());
        }
    }

    private Item[] readRecipeInputs(String key, PacketWrapper wrapper) {
        Item[] ingredient = this.readIngredient(wrapper);
        IntSet ids = this.recipeInputs.computeIfAbsent(key, $ -> new IntOpenHashSet(ingredient.length));
        for (Item item : ingredient) {
            ids.add(item.identifier());
        }
        return ingredient;
    }

    private static void writeIngredientsDisplay(PacketWrapper wrapper, Item[][] ingredients) {
        wrapper.write(Types.VAR_INT, ingredients.length);
        for (Item[] ingredient : ingredients) {
            RecipeRewriter1_21_2.writeIngredientDisplay(wrapper, ingredient);
        }
    }

    private static void writeIngredientDisplay(PacketWrapper wrapper, Item[] ingredient) {
        if (ingredient.length == 0) {
            wrapper.write(Types.VAR_INT, 0);
            return;
        }
        if (ingredient.length == 1) {
            RecipeRewriter1_21_2.writeItemDisplay(wrapper, ingredient[0]);
            return;
        }
        wrapper.write(Types.VAR_INT, 7);
        wrapper.write(Types.VAR_INT, ingredient.length);
        for (Item item : ingredient) {
            RecipeRewriter1_21_2.writeItemDisplay(wrapper, item);
        }
    }

    private static void writeItemDisplay(PacketWrapper wrapper, Item item) {
        wrapper.write(Types.VAR_INT, 3);
        wrapper.write(VersionedTypes.V1_21_2.item, item.copy());
    }

    private static void writeCraftingStationDisplay(PacketWrapper wrapper) {
        wrapper.write(Types.VAR_INT, 0);
    }

    public static void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeCraftingStationDisplay(PacketWrapper packetWrapper) {
        RecipeRewriter1_21_2.writeCraftingStationDisplay(packetWrapper);
    }

    public static void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeItemDisplay(PacketWrapper packetWrapper, Item item) {
        RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, item);
    }

    public static void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeIngredientDisplay(PacketWrapper packetWrapper, Item[] itemArray) {
        RecipeRewriter1_21_2.writeIngredientDisplay(packetWrapper, itemArray);
    }

    public static void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeIngredientsDisplay(PacketWrapper packetWrapper, Item[][] itemArray) {
        RecipeRewriter1_21_2.writeIngredientsDisplay(packetWrapper, itemArray);
    }

    @RecordComponents(value={@RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="group", type=int.class), @RecordComponents.Value(name="ingredient", type=Item[].class), @RecordComponents.Value(name="result", type=Item.class)})
    @NestHost(value=RecipeRewriter1_21_2.class)
    static final class StoneCutterRecipe
    extends J_L_Record {
        private final String identifier;
        private final int group;
        private final Item[] ingredient;
        private final Item result;

        StoneCutterRecipe(String identifier, int group, Item[] ingredient, Item result) {
            this.identifier = identifier;
            this.group = group;
            this.ingredient = ingredient;
            this.result = result;
        }

        public int recipeDisplayId() {
            return 3;
        }

        public void writeRecipeDisplay(PacketWrapper wrapper) {
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeIngredientDisplay(wrapper, this.ingredient);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeItemDisplay(wrapper, this.result);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeCraftingStationDisplay(wrapper);
        }

        @Override
        public final String toString() {
            return StoneCutterRecipe.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return StoneCutterRecipe.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return StoneCutterRecipe.jvmdowngrader$equals$equals(this, o2);
        }

        public String identifier() {
            return this.identifier;
        }

        public int group() {
            return this.group;
        }

        public Item[] ingredient() {
            return this.ingredient;
        }

        public Item result() {
            return this.result;
        }

        private static String jvmdowngrader$toString$toString(StoneCutterRecipe stoneCutterRecipe) {
            StoneCutterRecipe stoneCutterRecipe2 = stoneCutterRecipe;
            return "RecipeRewriter1_21_2$StoneCutterRecipe[" + "identifier=" + stoneCutterRecipe.identifier + ", " + "group=" + stoneCutterRecipe.group + ", " + "ingredient=" + stoneCutterRecipe.ingredient + ", " + "result=" + stoneCutterRecipe.result + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(StoneCutterRecipe stoneCutterRecipe) {
            Object[] objectArray = new Object[]{stoneCutterRecipe.identifier, stoneCutterRecipe.group, stoneCutterRecipe.ingredient, stoneCutterRecipe.result};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(StoneCutterRecipe stoneCutterRecipe, Object object) {
            if (stoneCutterRecipe == object) {
                return true;
            }
            if (object != null && object instanceof StoneCutterRecipe) {
                StoneCutterRecipe stoneCutterRecipe2 = (StoneCutterRecipe)object;
                if (Objects.equals(stoneCutterRecipe.identifier, stoneCutterRecipe2.identifier) && stoneCutterRecipe.group == stoneCutterRecipe2.group && Objects.equals(stoneCutterRecipe.ingredient, stoneCutterRecipe2.ingredient) && Objects.equals(stoneCutterRecipe.result, stoneCutterRecipe2.result)) {
                    return true;
                }
            }
            return false;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$StoneCutterRecipe$get$identifier() {
            return this.identifier;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$StoneCutterRecipe$set$identifier(String string) {
            this.identifier = string;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="index", type=int.class), @RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="group", type=int.class), @RecordComponents.Value(name="category", type=int.class), @RecordComponents.Value(name="width", type=int.class), @RecordComponents.Value(name="height", type=int.class), @RecordComponents.Value(name="ingredients", type=Item[][].class), @RecordComponents.Value(name="result", type=Item.class), @RecordComponents.Value(name="showNotification", type=boolean.class)})
    @NestHost(value=RecipeRewriter1_21_2.class)
    static final class ShapedRecipe
    extends J_L_Record
    implements Recipe {
        private final int index;
        private final String identifier;
        private final int group;
        private final int category;
        private final int width;
        private final int height;
        private final Item[][] ingredients;
        private final Item result;
        private final boolean showNotification;

        ShapedRecipe(int index, String identifier, int group, int category, int width, int height, Item[][] ingredients, Item result, boolean showNotification) {
            this.index = index;
            this.identifier = identifier;
            this.group = group;
            this.category = category;
            this.width = width;
            this.height = height;
            this.ingredients = ingredients;
            this.result = result;
            this.showNotification = showNotification;
        }

        @Override
        public int recipeDisplayId() {
            return 1;
        }

        @Override
        public void writeRecipeDisplay(PacketWrapper wrapper) {
            wrapper.write(Types.VAR_INT, this.width);
            wrapper.write(Types.VAR_INT, this.height);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeIngredientsDisplay(wrapper, this.ingredients);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeItemDisplay(wrapper, this.result);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeCraftingStationDisplay(wrapper);
        }

        @Override
        public final String toString() {
            return ShapedRecipe.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ShapedRecipe.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ShapedRecipe.jvmdowngrader$equals$equals(this, o2);
        }

        @Override
        public int index() {
            return this.index;
        }

        @Override
        public String identifier() {
            return this.identifier;
        }

        @Override
        public int group() {
            return this.group;
        }

        @Override
        public int category() {
            return this.category;
        }

        public int width() {
            return this.width;
        }

        public int height() {
            return this.height;
        }

        @Override
        public Item[][] ingredients() {
            return this.ingredients;
        }

        public Item result() {
            return this.result;
        }

        @Override
        public boolean showNotification() {
            return this.showNotification;
        }

        private static String jvmdowngrader$toString$toString(ShapedRecipe shapedRecipe) {
            ShapedRecipe shapedRecipe2 = shapedRecipe;
            return "RecipeRewriter1_21_2$ShapedRecipe[" + "index=" + shapedRecipe.index + ", " + "identifier=" + shapedRecipe.identifier + ", " + "group=" + shapedRecipe.group + ", " + "category=" + shapedRecipe.category + ", " + "width=" + shapedRecipe.width + ", " + "height=" + shapedRecipe.height + ", " + "ingredients=" + shapedRecipe.ingredients + ", " + "result=" + shapedRecipe.result + ", " + "showNotification=" + shapedRecipe.showNotification + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ShapedRecipe shapedRecipe) {
            Object[] objectArray = new Object[]{shapedRecipe.index, shapedRecipe.identifier, shapedRecipe.group, shapedRecipe.category, shapedRecipe.width, shapedRecipe.height, shapedRecipe.ingredients, shapedRecipe.result, shapedRecipe.showNotification};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ShapedRecipe shapedRecipe, Object object) {
            if (shapedRecipe == object) {
                return true;
            }
            if (object != null && object instanceof ShapedRecipe) {
                ShapedRecipe shapedRecipe2 = (ShapedRecipe)object;
                if (shapedRecipe.index == shapedRecipe2.index && Objects.equals(shapedRecipe.identifier, shapedRecipe2.identifier) && shapedRecipe.group == shapedRecipe2.group && shapedRecipe.category == shapedRecipe2.category && shapedRecipe.width == shapedRecipe2.width && shapedRecipe.height == shapedRecipe2.height && Objects.equals(shapedRecipe.ingredients, shapedRecipe2.ingredients) && Objects.equals(shapedRecipe.result, shapedRecipe2.result) && shapedRecipe.showNotification == shapedRecipe2.showNotification) {
                    return true;
                }
            }
            return false;
        }
    }

    @NestHost(value=RecipeRewriter1_21_2.class)
    static interface Recipe {
        public static final int SLOT_DISPLAY_EMPTY = 0;
        public static final int SLOT_DISPLAY_ANY_FUEL = 1;
        public static final int SLOT_DISPLAY_ITEM = 3;
        public static final int SLOT_DISPLAY_COMPOSITE = 7;

        public int index();

        public String identifier();

        public int recipeDisplayId();

        default public Item @Nullable [][] ingredients() {
            Item[][] itemArrayArray;
            Item[] ingredient = this.ingredient();
            if (ingredient == null) {
                itemArrayArray = null;
            } else {
                Item[][] itemArrayArray2 = new Item[1][];
                itemArrayArray = itemArrayArray2;
                itemArrayArray2[0] = ingredient;
            }
            return itemArrayArray;
        }

        default public Item @Nullable [] ingredient() {
            return null;
        }

        default public int group() {
            return -1;
        }

        default public boolean showNotification() {
            return true;
        }

        public int category();

        public void writeRecipeDisplay(PacketWrapper var1);
    }

    @RecordComponents(value={@RecordComponents.Value(name="index", type=int.class), @RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="group", type=int.class), @RecordComponents.Value(name="category", type=int.class), @RecordComponents.Value(name="ingredients", type=Item[][].class), @RecordComponents.Value(name="result", type=Item.class)})
    @NestHost(value=RecipeRewriter1_21_2.class)
    static final class ShapelessRecipe
    extends J_L_Record
    implements Recipe {
        private final int index;
        private final String identifier;
        private final int group;
        private final int category;
        private final Item[][] ingredients;
        private final Item result;

        ShapelessRecipe(int index, String identifier, int group, int category, Item[][] ingredients, Item result) {
            this.index = index;
            this.identifier = identifier;
            this.group = group;
            this.category = category;
            this.ingredients = ingredients;
            this.result = result;
        }

        @Override
        public int recipeDisplayId() {
            return 0;
        }

        @Override
        public void writeRecipeDisplay(PacketWrapper wrapper) {
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeIngredientsDisplay(wrapper, this.ingredients);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeItemDisplay(wrapper, this.result);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeCraftingStationDisplay(wrapper);
        }

        @Override
        public final String toString() {
            return ShapelessRecipe.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ShapelessRecipe.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ShapelessRecipe.jvmdowngrader$equals$equals(this, o2);
        }

        @Override
        public int index() {
            return this.index;
        }

        @Override
        public String identifier() {
            return this.identifier;
        }

        @Override
        public int group() {
            return this.group;
        }

        @Override
        public int category() {
            return this.category;
        }

        @Override
        public Item[][] ingredients() {
            return this.ingredients;
        }

        public Item result() {
            return this.result;
        }

        private static String jvmdowngrader$toString$toString(ShapelessRecipe shapelessRecipe) {
            ShapelessRecipe shapelessRecipe2 = shapelessRecipe;
            return "RecipeRewriter1_21_2$ShapelessRecipe[" + "index=" + shapelessRecipe.index + ", " + "identifier=" + shapelessRecipe.identifier + ", " + "group=" + shapelessRecipe.group + ", " + "category=" + shapelessRecipe.category + ", " + "ingredients=" + shapelessRecipe.ingredients + ", " + "result=" + shapelessRecipe.result + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ShapelessRecipe shapelessRecipe) {
            Object[] objectArray = new Object[]{shapelessRecipe.index, shapelessRecipe.identifier, shapelessRecipe.group, shapelessRecipe.category, shapelessRecipe.ingredients, shapelessRecipe.result};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ShapelessRecipe shapelessRecipe, Object object) {
            if (shapelessRecipe == object) {
                return true;
            }
            if (object != null && object instanceof ShapelessRecipe) {
                ShapelessRecipe shapelessRecipe2 = (ShapelessRecipe)object;
                if (shapelessRecipe.index == shapelessRecipe2.index && Objects.equals(shapelessRecipe.identifier, shapelessRecipe2.identifier) && shapelessRecipe.group == shapelessRecipe2.group && shapelessRecipe.category == shapelessRecipe2.category && Objects.equals(shapelessRecipe.ingredients, shapelessRecipe2.ingredients) && Objects.equals(shapelessRecipe.result, shapelessRecipe2.result)) {
                    return true;
                }
            }
            return false;
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="index", type=int.class), @RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="group", type=int.class), @RecordComponents.Value(name="category", type=int.class), @RecordComponents.Value(name="ingredient", type=Item[].class), @RecordComponents.Value(name="result", type=Item.class), @RecordComponents.Value(name="duration", type=int.class), @RecordComponents.Value(name="experience", type=float.class)})
    @NestHost(value=RecipeRewriter1_21_2.class)
    static final class FurnaceRecipe
    extends J_L_Record
    implements Recipe {
        private final int index;
        private final String identifier;
        private final int group;
        private final int category;
        private final Item[] ingredient;
        private final Item result;
        private final int duration;
        private final float experience;

        FurnaceRecipe(int index, String identifier, int group, int category, Item[] ingredient, Item result, int duration, float experience) {
            this.index = index;
            this.identifier = identifier;
            this.group = group;
            this.category = category;
            this.ingredient = ingredient;
            this.result = result;
            this.duration = duration;
            this.experience = experience;
        }

        @Override
        public int recipeDisplayId() {
            return 2;
        }

        @Override
        public void writeRecipeDisplay(PacketWrapper wrapper) {
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeIngredientDisplay(wrapper, this.ingredient);
            wrapper.write(Types.VAR_INT, 1);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeItemDisplay(wrapper, this.result);
            RecipeRewriter1_21_2.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_21to1_21_2_rewriter_RecipeRewriter1_21_2$writeCraftingStationDisplay(wrapper);
            wrapper.write(Types.VAR_INT, this.duration);
            wrapper.write(Types.FLOAT, Float.valueOf(this.experience));
        }

        @Override
        public final String toString() {
            return FurnaceRecipe.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return FurnaceRecipe.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return FurnaceRecipe.jvmdowngrader$equals$equals(this, o2);
        }

        @Override
        public int index() {
            return this.index;
        }

        @Override
        public String identifier() {
            return this.identifier;
        }

        @Override
        public int group() {
            return this.group;
        }

        @Override
        public int category() {
            return this.category;
        }

        @Override
        public Item[] ingredient() {
            return this.ingredient;
        }

        public Item result() {
            return this.result;
        }

        public int duration() {
            return this.duration;
        }

        public float experience() {
            return this.experience;
        }

        private static String jvmdowngrader$toString$toString(FurnaceRecipe furnaceRecipe) {
            FurnaceRecipe furnaceRecipe2 = furnaceRecipe;
            return "RecipeRewriter1_21_2$FurnaceRecipe[" + "index=" + furnaceRecipe.index + ", " + "identifier=" + furnaceRecipe.identifier + ", " + "group=" + furnaceRecipe.group + ", " + "category=" + furnaceRecipe.category + ", " + "ingredient=" + furnaceRecipe.ingredient + ", " + "result=" + furnaceRecipe.result + ", " + "duration=" + furnaceRecipe.duration + ", " + "experience=" + furnaceRecipe.experience + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(FurnaceRecipe furnaceRecipe) {
            Object[] objectArray = new Object[]{furnaceRecipe.index, furnaceRecipe.identifier, furnaceRecipe.group, furnaceRecipe.category, furnaceRecipe.ingredient, furnaceRecipe.result, furnaceRecipe.duration, Float.valueOf(furnaceRecipe.experience)};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(FurnaceRecipe furnaceRecipe, Object object) {
            if (furnaceRecipe == object) {
                return true;
            }
            if (object != null && object instanceof FurnaceRecipe) {
                FurnaceRecipe furnaceRecipe2 = (FurnaceRecipe)object;
                if (furnaceRecipe.index == furnaceRecipe2.index && Objects.equals(furnaceRecipe.identifier, furnaceRecipe2.identifier) && furnaceRecipe.group == furnaceRecipe2.group && furnaceRecipe.category == furnaceRecipe2.category && Objects.equals(furnaceRecipe.ingredient, furnaceRecipe2.ingredient) && Objects.equals(furnaceRecipe.result, furnaceRecipe2.result) && furnaceRecipe.duration == furnaceRecipe2.duration && furnaceRecipe.experience == furnaceRecipe2.experience) {
                    return true;
                }
            }
            return false;
        }
    }
}


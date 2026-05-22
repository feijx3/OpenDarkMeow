/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.MappingData1_13;
import com.viaversion.viaversion.util.GsonUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={Recipe.class, 1.class})
public final class RecipeData {
    public static Map<String, Recipe> recipes;

    public static void init() {
        InputStream stream = MappingData1_13.class.getClassLoader().getResourceAsStream("assets/viaversion/data/itemrecipes1_12_2to1_13.json");
        try (InputStreamReader reader = new InputStreamReader(stream);){
            recipes = (Map)GsonUtil.getGson().fromJson((Reader)reader, new TypeToken<Map<String, Recipe>>(){}.getType());
        }
        catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @RecordComponents(value={@RecordComponents.Value(name="type", type=String.class), @RecordComponents.Value(name="group", type=String.class), @RecordComponents.Value(name="width", type=int.class), @RecordComponents.Value(name="height", type=int.class), @RecordComponents.Value(name="experience", type=float.class), @RecordComponents.Value(name="cookingTime", type=int.class), @RecordComponents.Value(name="ingredient", type=DataItem[].class), @RecordComponents.Value(name="ingredients", type=DataItem[][].class), @RecordComponents.Value(name="result", type=DataItem.class)})
    @NestHost(value=RecipeData.class)
    public static final class Recipe
    extends J_L_Record {
        private final String type;
        private final String group;
        private final int width;
        private final int height;
        private final float experience;
        private final int cookingTime;
        private final DataItem[] ingredient;
        private final DataItem[][] ingredients;
        private final DataItem result;

        public Recipe(String type, String group, int width, int height, float experience, int cookingTime, DataItem[] ingredient, DataItem[][] ingredients, DataItem result) {
            this.type = type;
            this.group = group;
            this.width = width;
            this.height = height;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.ingredient = ingredient;
            this.ingredients = ingredients;
            this.result = result;
        }

        @Override
        public final String toString() {
            return Recipe.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return Recipe.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return Recipe.jvmdowngrader$equals$equals(this, o2);
        }

        public String type() {
            return this.type;
        }

        public String group() {
            return this.group;
        }

        public int width() {
            return this.width;
        }

        public int height() {
            return this.height;
        }

        public float experience() {
            return this.experience;
        }

        public int cookingTime() {
            return this.cookingTime;
        }

        public DataItem[] ingredient() {
            return this.ingredient;
        }

        public DataItem[][] ingredients() {
            return this.ingredients;
        }

        public DataItem result() {
            return this.result;
        }

        private static String jvmdowngrader$toString$toString(Recipe recipe) {
            Recipe recipe2 = recipe;
            return "RecipeData$Recipe[" + "type=" + recipe.type + ", " + "group=" + recipe.group + ", " + "width=" + recipe.width + ", " + "height=" + recipe.height + ", " + "experience=" + recipe.experience + ", " + "cookingTime=" + recipe.cookingTime + ", " + "ingredient=" + recipe.ingredient + ", " + "ingredients=" + recipe.ingredients + ", " + "result=" + recipe.result + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(Recipe recipe) {
            Object[] objectArray = new Object[]{recipe.type, recipe.group, recipe.width, recipe.height, Float.valueOf(recipe.experience), recipe.cookingTime, recipe.ingredient, recipe.ingredients, recipe.result};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(Recipe recipe, Object object) {
            if (recipe == object) {
                return true;
            }
            if (object != null && object instanceof Recipe) {
                Recipe recipe2 = (Recipe)object;
                if (Objects.equals(recipe.type, recipe2.type) && Objects.equals(recipe.group, recipe2.group) && recipe.width == recipe2.width && recipe.height == recipe2.height && recipe.experience == recipe2.experience && recipe.cookingTime == recipe2.cookingTime && Objects.equals(recipe.ingredient, recipe2.ingredient) && Objects.equals(recipe.ingredients, recipe2.ingredients) && Objects.equals(recipe.result, recipe2.result)) {
                    return true;
                }
            }
            return false;
        }
    }
}


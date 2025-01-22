package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ExtraRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_OBJECT_SEMLTABLES = List.of(ExtraItems.RAW_SAPPHIRE_OBJECT.get(),
            ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get(), ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get(), ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get(),
            ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get());
    public ExtraRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer, SAPPHIRE_OBJECT_SEMLTABLES, RecipeCategory.MISC, ExtraItems.SAPPHIRE_OBJECT.get(), 0.25f, 100, "sapphire");
        oreSmelting(consumer, SAPPHIRE_OBJECT_SEMLTABLES, RecipeCategory.MISC, ExtraItems.SAPPHIRE_OBJECT.get(), 0.25f, 175, "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraBlocks.BLOCK_OF_SAPPHIRE.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("XXX")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("XXX")
                .define('X', ExtraItems.RAW_SAPPHIRE_OBJECT.get())
                .unlockedBy(getHasName(ExtraItems.RAW_SAPPHIRE_OBJECT.get()), has(ExtraItems.RAW_SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.SWORD_OF_SAPPHIRE.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" S ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.PICKAXE_OF_SAPPHIRE.get())
                .pattern("XXX")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.AXE_OF_SAPPHIRE.get())
                .pattern(" XX")
                .pattern(" SX")
                .pattern(" S ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.SHOVEL_OF_SAPPHIRE.get())
                .pattern(" X ")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.HOE_OF_SAPPHIRE.get())
                .pattern(" XX")
                .pattern(" S ")
                .pattern(" S ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.HELMUT_OF_SAPPHIRE.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("   ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.CHESTPLATE_OF_SAPPHIRE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.LEGGINGS_OF_SAPPHIRE.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExtraItems.BOOTS_OF_SAPPHIRE.get())
                .pattern("X X")
                .pattern("X X")
                .pattern("   ")
                .define('X', ExtraItems.SAPPHIRE_OBJECT.get())
                .unlockedBy(getHasName(ExtraItems.SAPPHIRE_OBJECT.get()), has(ExtraItems.SAPPHIRE_OBJECT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ExtraItems.SAPPHIRE_OBJECT.get(), 8)
                .requires(ExtraBlocks.BLOCK_OF_SAPPHIRE.get())
                .unlockedBy(getHasName(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()), has(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ExtraItems.RAW_SAPPHIRE_OBJECT.get(), 8)
                .requires(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get())
                .unlockedBy(getHasName(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get()), has(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get()))
                .save(consumer);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, PracticeModOne.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

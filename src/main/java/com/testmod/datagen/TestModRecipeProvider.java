package com.testmod.datagen;

import com.testmod.registermods.ModBlocks;
import com.testmod.registermods.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TestModRecipeProvider extends FabricRecipeProvider {

    public TestModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODSTONE)
                .input(Items.SPIDER_EYE, 4)
                .criterion(FabricRecipeProvider.hasItem(Items.SPIDER_EYE),
                        FabricRecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK1)
                .input(Items.AMETHYST_SHARD)
                .input(Items.DIRT, 3)
                .criterion(FabricRecipeProvider.hasItem(Items.AMETHYST_SHARD),
                        FabricRecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(FabricRecipeProvider.hasItem(Items.DIRT),
                        FabricRecipeProvider.conditionsFromItem(Items.DIRT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HASTY_FOOD)
                .input(Items.GLOW_BERRIES)
                .input(Items.APPLE, 2)
                .criterion(FabricRecipeProvider.hasItem(Items.GLOW_BERRIES),
                        FabricRecipeProvider.conditionsFromItem(Items.GLOW_BERRIES))
                .criterion(FabricRecipeProvider.hasItem(Items.APPLE),
                        FabricRecipeProvider.conditionsFromItem(Items.APPLE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_CLAWS)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("ddd")
                .input('a', ModItems.ADAMANTIUM_INGOT)
                .input('d', Items.DIAMOND)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ADAMANTIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ADAMANTIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND),
                        FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

        RecipeProvider.offerSmelting(
                exporter,
                List.of(ModItems.RAW_ADAMANTIUM),
                RecipeCategory.TOOLS,
                ModItems.ADAMANTIUM_INGOT,
                3,
                200,
                "testmod_ingots"
        );

        RecipeProvider.offerSmelting(
                exporter,
                List.of(ModBlocks.ADAMANTIUM_ORE),
                RecipeCategory.TOOLS,
                ModItems.ADAMANTIUM_INGOT,
                3,
                150,
                "testmod_ingots"
        );
    }
}

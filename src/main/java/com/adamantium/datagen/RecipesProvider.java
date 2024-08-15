package com.adamantium.datagen;

import com.adamantium.AdamantiumMod;
import com.adamantium.blocks.*;
import com.adamantium.register.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends FabricRecipeProvider {

    public RecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BloodStone.BLOOD_STONE)
                        .input(Items.SPIDER_EYE)
                                .criterion(FabricRecipeProvider.hasItem(Items.SPIDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
                        .input(Items.SPIDER_EYE)
                                .criterion(FabricRecipeProvider.hasItem(Items.SPIDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
                        .input(Items.SPIDER_EYE)
                                .criterion(FabricRecipeProvider.hasItem(Items.SPIDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
                        .input(Items.SPIDER_EYE)
                                .criterion(FabricRecipeProvider.hasItem(Items.SPIDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
                                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegisterItems.ADAMANTIUM_CLAWS)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("ddd")
                .input('a', RegisterItems.ADAMANTIUM_INGOT)
                .input('d', Items.DIAMOND)
                .criterion(FabricRecipeProvider.hasItem(RegisterItems.ADAMANTIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(RegisterItems.ADAMANTIUM_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.DIAMOND),
                        FabricRecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK, 1)
                        .pattern("aaa")
                        .pattern("aaa")
                        .pattern("aaa")
                        .input('a', RegisterItems.RAW_ADAMANTIUM)
                        .criterion(FabricRecipeProvider.hasItem(RegisterItems.RAW_ADAMANTIUM),
                                FabricRecipeProvider.conditionsFromItem(RegisterItems.RAW_ADAMANTIUM))
                        .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.RAW_ADAMANTIUM, 9)
                .input(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK, 1)
                .criterion(FabricRecipeProvider.hasItem(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK), FabricRecipeProvider.conditionsFromItem(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AdamantiumBlock.ADAMANTIUM_BLOCK, 1)
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .input('i', RegisterItems.ADAMANTIUM_INGOT)
                .criterion(FabricRecipeProvider.hasItem(RegisterItems.ADAMANTIUM_INGOT),
                        FabricRecipeProvider.conditionsFromItem(RegisterItems.ADAMANTIUM_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.ADAMANTIUM_INGOT, 9)
                .input(AdamantiumBlock.ADAMANTIUM_BLOCK, 1)
                .criterion(FabricRecipeProvider.hasItem(AdamantiumBlock.ADAMANTIUM_BLOCK), FabricRecipeProvider.conditionsFromItem(AdamantiumBlock.ADAMANTIUM_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.ADAMANTIUM_INGOT, 1)
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .input('n', RegisterItems.ADAMANTIUM_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(RegisterItems.ADAMANTIUM_NUGGET),
                        FabricRecipeProvider.conditionsFromItem(RegisterItems.ADAMANTIUM_NUGGET))
                .offerTo(exporter, new Identifier(AdamantiumMod.MOD_ID, "adamantium_ingot_from_nuggets"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RegisterItems.ADAMANTIUM_NUGGET, 9)
                .input(RegisterItems.ADAMANTIUM_INGOT, 1)
                .criterion(FabricRecipeProvider.hasItem(RegisterItems.ADAMANTIUM_INGOT), FabricRecipeProvider.conditionsFromItem(RegisterItems.ADAMANTIUM_INGOT))
                .offerTo(exporter, new Identifier(AdamantiumMod.MOD_ID, "adamantium_nuggets_from_ingot"));

        RecipeProvider.offerSmelting(
                exporter,
                List.of(RegisterItems.RAW_ADAMANTIUM),
                RecipeCategory.TOOLS,
                RegisterItems.ADAMANTIUM_INGOT,
                3,
                200,
                AdamantiumMod.MOD_ID
        );

        RecipeProvider.offerSmelting(
                exporter,
                List.of(AdamantiumOreBlock.ADAMANTIUM_ORE),
                RecipeCategory.TOOLS,
                RegisterItems.ADAMANTIUM_INGOT,
                3,
                150,
                AdamantiumMod.MOD_ID
        );

        RecipeProvider.offerSmelting(
                exporter,
                List.of(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE),
                RecipeCategory.TOOLS,
                RegisterItems.ADAMANTIUM_INGOT,
                3,
                150,
                AdamantiumMod.MOD_ID
        );

    }

}

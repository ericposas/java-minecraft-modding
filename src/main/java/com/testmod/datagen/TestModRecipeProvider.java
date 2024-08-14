package com.testmod.datagen;

import com.testmod.blocks.AdamantiumDeepslateOreBlock;
import com.testmod.blocks.AdamantiumOreBlock;
import com.testmod.blocks.BloodStone;
import com.testmod.registermods.RegisterItems;
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

        RecipeProvider.offerSmelting(
                exporter,
                List.of(RegisterItems.RAW_ADAMANTIUM),
                RecipeCategory.TOOLS,
                RegisterItems.ADAMANTIUM_INGOT,
                3,
                200,
                "adamantium_mod"
        );

        RecipeProvider.offerSmelting(
                exporter,
                List.of(AdamantiumOreBlock.ADAMANTIUM_ORE),
                RecipeCategory.TOOLS,
                RegisterItems.ADAMANTIUM_INGOT,
                3,
                150,
                "adamantium_mod"
        );

        RecipeProvider.offerSmelting(
                exporter,
                List.of(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE),
                RecipeCategory.TOOLS,
                RegisterItems.ADAMANTIUM_INGOT,
                3,
                150,
                "adamantium_mod"
        );

    }

}

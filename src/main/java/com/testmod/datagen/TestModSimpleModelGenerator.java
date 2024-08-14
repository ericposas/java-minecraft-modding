package com.testmod.datagen;

import com.testmod.registermods.ModBlocks;
import com.testmod.registermods.ModItems;
import com.testmod.registermods.ModPotions;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class TestModSimpleModelGenerator extends FabricModelProvider {

    public TestModSimpleModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOODSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(
                ModItems.ADAMANTIUM_CLAWS,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
        itemModelGenerator.register(
                ModItems.HASTY_FOOD,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
        itemModelGenerator.register(
                ModPotions.RAGE_POTION_ITEM,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
        itemModelGenerator.register(
                ModItems.ADAMANTIUM_INGOT,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
        itemModelGenerator.register(
                ModItems.RAW_ADAMANTIUM,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
    }
}

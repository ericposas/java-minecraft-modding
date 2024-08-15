package com.adamantium.datagen;

import com.adamantium.AdamantiumMod;
import com.adamantium.blocks.*;
import com.adamantium.registermods.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class SimpleModelGenerator extends FabricModelProvider {

    public SimpleModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BloodStone.BLOOD_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(AdamantiumOreBlock.ADAMANTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AdamantiumBlock.ADAMANTIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(
                RegisterItems.ADAMANTIUM_CLAWS,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
        itemModelGenerator.register(
                RegisterItems.ADAMANTIUM_INGOT,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
        itemModelGenerator.register(
                RegisterItems.RAW_ADAMANTIUM,
                new Model(
                        Optional.of(new Identifier("item/generated")),
                        Optional.empty(),
                        TextureKey.LAYER0
                )
        );
    }
}

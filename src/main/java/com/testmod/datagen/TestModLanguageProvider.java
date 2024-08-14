package com.testmod.datagen;

import com.testmod.registermods.ModBlocks;
import com.testmod.registermods.ModEntities;
import com.testmod.registermods.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TestModLanguageProvider extends FabricLanguageProvider {

    protected TestModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.BLOCK1, "Crystal Block");
        translationBuilder.add(ModBlocks.BLOODSTONE, "Blood Stone");
        translationBuilder.add(ModBlocks.ADAMANTIUM_ORE, "Adamantium Ore");
        translationBuilder.add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE, "Adamantium Deepslate Ore");
        translationBuilder.add(ModItems.RAW_ADAMANTIUM, "Raw Adamantium");
        translationBuilder.add(ModItems.ADAMANTIUM_INGOT, "Adamantium Ingot");
        translationBuilder.add(ModItems.ADAMANTIUM_CLAWS, "Let's Go Bub.");
        translationBuilder.add(ModItems.HASTY_FOOD, "Hasty Fruit");
        translationBuilder.add(ModEntities.ZOMBIE_GECKOLIB_ENTITY_TYPE, "GeckoLib Zombie");
    }
}

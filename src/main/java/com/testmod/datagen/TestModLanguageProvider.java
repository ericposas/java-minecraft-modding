package com.testmod.datagen;

import com.testmod.blocks.AdamantiumDeepslateOreBlock;
import com.testmod.blocks.AdamantiumOreBlock;
import com.testmod.blocks.BloodStone;
import com.testmod.registermods.RegisterItems;
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
        translationBuilder.add(BloodStone.BLOOD_STONE, "Blood Stone");
        translationBuilder.add(AdamantiumOreBlock.ADAMANTIUM_ORE, "Adamantium Ore");
        translationBuilder.add(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE, "Adamantium Deepslate Ore");
        translationBuilder.add(RegisterItems.RAW_ADAMANTIUM, "Raw Adamantium");
        translationBuilder.add(RegisterItems.ADAMANTIUM_INGOT, "Adamantium Ingot");
        translationBuilder.add(RegisterItems.ADAMANTIUM_CLAWS, "Adamantium Claws");
    }
}

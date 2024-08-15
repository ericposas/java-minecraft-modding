package com.adamantium.datagen;

import com.adamantium.blocks.*;
import com.adamantium.register.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageProvider extends FabricLanguageProvider {

    protected LanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
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
        translationBuilder.add(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK, "Block of Raw Adamantium");
        translationBuilder.add(AdamantiumBlock.ADAMANTIUM_BLOCK, "Block of Adamantium");
        translationBuilder.add(RegisterItems.ADAMANTIUM_NUGGET, "Adamantium Nugget");
    }
}

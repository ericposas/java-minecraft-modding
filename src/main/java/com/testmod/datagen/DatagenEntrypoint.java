package com.testmod.datagen;

import com.testmod.world.ModConfiguredFeatures;
import com.testmod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.*;

public class DatagenEntrypoint implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TestModBlockLootTables::new);
        pack.addProvider(TestModBlockTagProvider::new);
        pack.addProvider(TestModSimpleModelGenerator::new);
        pack.addProvider(TestModLanguageProvider::new);
        pack.addProvider(TestModRecipeProvider::new);
        pack.addProvider(TestModWorldGenProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(
                RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap
        );
        registryBuilder.addRegistry(
                RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap
        );
    }

}

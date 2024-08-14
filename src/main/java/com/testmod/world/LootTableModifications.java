package com.testmod.world;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class LootTableModifications {

    private static boolean isSameIdentifier(RegistryKey registryKey, Identifier identifier) {
        return registryKey.getValue().getPath().equals(identifier.getPath());
    }

    public static void initialize() {
        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource) -> {
            if (
                    isSameIdentifier(registryKey, Blocks.COAL_ORE.getLootTableKey().getRegistry()) ||
                            isSameIdentifier(registryKey, Blocks.DEEPSLATE_COAL_ORE.getLootTableKey().getRegistry())
            ) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.3f)) // chance of drop (1f = %100 chance)
                        .with(ItemEntry.builder(Items.COAL_ORE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2f, 6f))) // n or n number of items will drop
                        .build();
                builder.pool(poolBuilder);
            }
//            if (
//                    isSameIdentifier(registryKey, ModBlocks.ADAMANTIUM_ORE.getLootTableKey().getRegistry()) ||
//                    isSameIdentifier(registryKey, ModBlocks.ADAMANTIUM_DEEPSLATE_ORE.getLootTableKey().getRegistry())
//            ) {
//                LootPool poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(
//                                RandomChanceLootCondition.builder(1.0f)
//                        )
//                        .with(ItemEntry.builder(ModItems.RAW_ADAMANTIUM))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)))
//                        .build();
//                builder.pool(poolBuilder);
//            }
        });
    }
}

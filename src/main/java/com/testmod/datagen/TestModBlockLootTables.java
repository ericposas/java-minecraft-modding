package com.testmod.datagen;

import com.testmod.registermods.ModBlocks;
import com.testmod.registermods.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TestModBlockLootTables extends FabricBlockLootTableProvider {

    public TestModBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(dataOutput, completableFuture);
    }

    @Override
    public void generate() {
        addDrop(
                ModBlocks.BLOCK1,
                LootTable.builder()
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(Items.DIRT)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0F))))
                                .with(ItemEntry.builder(Items.AMETHYST_SHARD)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                ))
        );
        addDrop(
                ModBlocks.BLOODSTONE,
                LootTable.builder()
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(Items.SPIDER_EYE)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3.0F))))
                                .with(ItemEntry.builder(ModBlocks.BLOODSTONE_ITEM)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))))
        );
        addDrop(
                ModBlocks.ADAMANTIUM_ORE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(ModItems.RAW_ADAMANTIUM)
                                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                        )
                        )
        );
        addDrop(
                ModBlocks.ADAMANTIUM_DEEPSLATE_ORE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(ModItems.RAW_ADAMANTIUM)
                                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
                        )
        );
    }

}

package com.adamantium.datagen;

import com.adamantium.blocks.*;
import com.adamantium.registermods.RegisterItems;
import com.mojang.datafixers.kinds.Const;
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

public class BlockLootTables extends FabricBlockLootTableProvider {

    public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(dataOutput, completableFuture);
    }

    @Override
    public void generate() {
        addDrop(BloodStone.BLOOD_STONE,
                LootTable.builder().pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(BloodStone.BLOOD_STONE)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.SPIDER_EYE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0F))))
        );
        addDrop(AdamantiumOreBlock.ADAMANTIUM_ORE,
                LootTable.builder().pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(RegisterItems.RAW_ADAMANTIUM)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))))
        );
        addDrop(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(RegisterItems.RAW_ADAMANTIUM)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))))
        );
        addDrop(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(RegisterItems.RAW_ADAMANTIUM)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(9.0F))))));
        addDrop(AdamantiumBlock.ADAMANTIUM_BLOCK,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(RegisterItems.ADAMANTIUM_INGOT)
                                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(9.0F))))));
    }

}

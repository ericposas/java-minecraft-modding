package com.adamantium.datagen;

import com.adamantium.blocks.AdamantiumBlock;
import com.adamantium.blocks.AdamantiumDeepslateOreBlock;
import com.adamantium.blocks.AdamantiumOreBlock;
import com.adamantium.blocks.RawAdamantiumBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static TagKey<Block> NeedsDiamondTag =
            TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "needs_diamond_tool"));

    public static TagKey<Block> Mineable =
            TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "mineable/pickaxe"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(NeedsDiamondTag)
                .add(AdamantiumOreBlock.ADAMANTIUM_ORE)
                .add(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE)
                .add(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK)
                .add(AdamantiumBlock.ADAMANTIUM_BLOCK)
                .setReplace(false);
        getOrCreateTagBuilder(Mineable)
                .add(AdamantiumOreBlock.ADAMANTIUM_ORE)
                .add(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE)
                .add(RawAdamantiumBlock.RAW_ADAMANTIUM_BLOCK)
                .add(AdamantiumBlock.ADAMANTIUM_BLOCK)
                .setReplace(false);
    }

}
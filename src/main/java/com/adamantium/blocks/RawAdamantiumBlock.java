package com.adamantium.blocks;

import com.adamantium.AdamantiumMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class RawAdamantiumBlock extends Block {

    public static final Identifier identifier = new Identifier(AdamantiumMod.MOD_ID, "raw_adamantium_block");

    public static final RawAdamantiumBlock RAW_ADAMANTIUM_BLOCK =
            Registry.register(Registries.BLOCK,
                    identifier,
                    new RawAdamantiumBlock(AbstractBlock.Settings.create()
                            .strength(1.0F)
                            .hardness(4.0F)
                            .sounds(BlockSoundGroup.NETHER_GOLD_ORE)
                            .requiresTool()));

    static {
        Registry.register(Registries.ITEM,
                identifier,
                new BlockItem(RAW_ADAMANTIUM_BLOCK, new Item.Settings()));
    }

    public RawAdamantiumBlock(Settings settings) {
        super(settings);
    }

    public static void init() {}

}

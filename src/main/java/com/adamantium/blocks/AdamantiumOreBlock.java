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

public class AdamantiumOreBlock extends Block {

    public static final Identifier identifier = new Identifier(AdamantiumMod.MOD_ID, "adamantium_ore");

    private static final AbstractBlock.Settings ADAMANTIUM_ORE_BLOCK_SETTINGS =
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.NETHER_ORE)
                    .strength(1.0f)
                    .hardness(4.0f)
                    .requiresTool();

    public static final AdamantiumOreBlock ADAMANTIUM_ORE =
            Registry.register(Registries.BLOCK,
                    AdamantiumOreBlock.identifier,
                    new AdamantiumOreBlock(ADAMANTIUM_ORE_BLOCK_SETTINGS));

    static {
        Registry.register(Registries.ITEM,
                identifier,
                new BlockItem(ADAMANTIUM_ORE, new Item.Settings()));
    }

    public AdamantiumOreBlock(Settings settings) {
        super(settings);
    }

    public static void init() {}

}

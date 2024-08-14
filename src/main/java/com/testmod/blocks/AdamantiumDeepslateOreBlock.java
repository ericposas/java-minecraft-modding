package com.testmod.blocks;

import com.testmod.TestMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class AdamantiumDeepslateOreBlock extends Block {

    public static final Identifier identifier = new Identifier(TestMod.MOD_ID, "adamantium_deepslate_ore");

    public static final AbstractBlock.Settings ADAMANTIUM_DEEPSLATE_ORE_BLOCK_SETTINGS = AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.NETHER_ORE)
                    .strength(1.0f)
                    .hardness(4.0f)
                    .requiresTool();

    public static final AdamantiumDeepslateOreBlock ADAMANTIUM_DEEPSLATE_ORE = Registry.register(
                Registries.BLOCK,
                identifier,
                new AdamantiumDeepslateOreBlock(ADAMANTIUM_DEEPSLATE_ORE_BLOCK_SETTINGS)
            );

    static {
        Registry.register(
          Registries.ITEM,
          identifier,
          new BlockItem(ADAMANTIUM_DEEPSLATE_ORE, new Item.Settings())
        );
    }

    public AdamantiumDeepslateOreBlock(Settings settings) {
        super(settings);
    }

    public static void init() {}

}

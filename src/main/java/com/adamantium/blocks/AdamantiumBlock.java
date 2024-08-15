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

public class AdamantiumBlock extends Block {

    public static final Identifier identifier = new Identifier(AdamantiumMod.MOD_ID, "adamantium_block");

    public static final AdamantiumBlock ADAMANTIUM_BLOCK =
            Registry.register(Registries.BLOCK,
                    identifier,
                    new AdamantiumBlock(AbstractBlock.Settings.create()
                            .strength(1.0F)
                            .hardness(5.0F)
                            .sounds(BlockSoundGroup.ANVIL)
                            .requiresTool()));

    static {
        Registry.register(Registries.ITEM,
                identifier,
                new BlockItem(ADAMANTIUM_BLOCK, new Item.Settings()));
    }

    public AdamantiumBlock(Settings settings) {
        super(settings);
    }

    public static void init() {}

}

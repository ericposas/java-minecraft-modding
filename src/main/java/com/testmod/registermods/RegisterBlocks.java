package com.testmod.registermods;

import com.testmod.TestMod;
import com.testmod.blocks.AdamantiumDeepslateOreBlock;
import com.testmod.blocks.AdamantiumOreBlock;
import com.testmod.blocks.BloodStone;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RegisterBlocks {

    public static final Block BLOCK1 =
            registerBlock(new Block(AbstractBlock.Settings.create()
                                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                                    .strength(1.1f)
                                    .luminance((blockstate) -> 10)
                                    .requiresTool()),
                    "block1");

    private static Block registerBlock(Block block, String blockId) {
        Block registeredBlock = Registry.register(
                Registries.BLOCK,
                Identifier.of(TestMod.MOD_ID, blockId),
                block
        );
        Registry.register(
                Registries.ITEM,
                Identifier.of(TestMod.MOD_ID, blockId),
                new BlockItem(
                        registeredBlock,
                        new Item.Settings()
                )
        );
        return registeredBlock;
    }

    public static final RegistryKey<ItemGroup> BLOCKS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("testmod", "blockgroup1"));
    public static final ItemGroup BLOCKS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BLOCK1))
            .displayName(Text.translatable("itemGroup." + TestMod.MOD_ID))
            .build();

    static {

        BloodStone.init();
        AdamantiumOreBlock.init();
        AdamantiumDeepslateOreBlock.init();

        Registry.register(
                Registries.ITEM_GROUP,
                BLOCKS_GROUP_KEY,
                BLOCKS_GROUP
        );

        ItemGroupEvents.modifyEntriesEvent(BLOCKS_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(BLOCK1.asItem());
            itemGroup.add(BloodStone.BLOOD_STONE.asItem());
            itemGroup.add(AdamantiumOreBlock.ADAMANTIUM_ORE.asItem());
            itemGroup.add(AdamantiumDeepslateOreBlock.ADAMANTIUM_DEEPSLATE_ORE.asItem());
        });

    }

    public static void initialize() {}

}

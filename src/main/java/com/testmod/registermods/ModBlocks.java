package com.testmod.registermods;

import com.testmod.TestMod;
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

public class ModBlocks {

    public static final Block ADAMANTIUM_ORE =
            Registry.register(
                    Registries.BLOCK,
                    new Identifier(TestMod.MOD_ID, "adamantium_ore"),
                    new Block(
                            AbstractBlock.Settings.create()
                                    .sounds(
                                            BlockSoundGroup.NETHER_ORE
                                    )
                                    .strength(1.0f)
                                    .hardness(4.0f)
                                    .requiresTool()
                    )
            );

    public static final Item ADAMANTIUM_ORE_ITEM =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(TestMod.MOD_ID, "adamantium_ore"),
                    new BlockItem(
                            ADAMANTIUM_ORE,
                            new Item.Settings()
                    )
            );

    public static final Block ADAMANTIUM_DEEPSLATE_ORE =
            Registry.register(
                    Registries.BLOCK,
                    new Identifier(TestMod.MOD_ID, "adamantium_deepslate_ore"),
                    new Block(
                            AbstractBlock.Settings.create()
                                    .sounds(
                                            BlockSoundGroup.NETHER_ORE
                                    )
                                    .strength(1.0f)
                                    .hardness(4.0f)
                                    .requiresTool()
                    )
            );

    public static final Item ADAMANTIUM_DEEPSLATE_ORE_ITEM =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(TestMod.MOD_ID, "adamantium_deepslate_ore"),
                    new BlockItem(
                            ADAMANTIUM_DEEPSLATE_ORE,
                            new Item.Settings()
                    )
            );

    public static final Block BLOODSTONE =
            Registry.register(
              Registries.BLOCK,
              new Identifier(TestMod.MOD_ID, "bloodstone"),
              new Block(
                      AbstractBlock.Settings.create()
                              .sounds(
                                      ModSoundEvents.SQUISH_GROUP
                              )
                              .strength(0.5f)
                              .jumpVelocityMultiplier(3.0F)
              )
            );

    public static final BlockItem BLOODSTONE_ITEM =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(TestMod.MOD_ID, "bloodstone"),
                    new BlockItem(
                            BLOODSTONE,
                            new Item.Settings()
                    )
            );

    public static final Block BLOCK1 =
            registerBlock(
                    new Block(
                            AbstractBlock.Settings.create()
                                    .sounds(
                                            BlockSoundGroup.AMETHYST_CLUSTER
                                    )
                                    .strength(1.1f)
                                    .luminance((blockstate) -> 10)
                                    .requiresTool()
                    ),
                    "block1"
            );

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
        Registry.register(
                Registries.ITEM_GROUP,
                BLOCKS_GROUP_KEY,
                BLOCKS_GROUP
        );
        ItemGroupEvents.modifyEntriesEvent(BLOCKS_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(BLOCK1.asItem());
            itemGroup.add(BLOODSTONE.asItem());
            itemGroup.add(ADAMANTIUM_ORE.asItem());
        });
    }

    public static void initialize() {
    }

}

package com.testmod.blocks;

import com.testmod.TestMod;
import com.testmod.registermods.RegisterSoundEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BloodStone extends Block {

    public static final Identifier identifier = new Identifier(TestMod.MOD_ID, "bloodstone");

    public static final BloodStone BLOOD_STONE =
            Registry.register(Registries.BLOCK, identifier,
                    new BloodStone(AbstractBlock.Settings.create()
                            .sounds(RegisterSoundEvents.SQUISH_GROUP)
                            .strength(0.5f)
                            .jumpVelocityMultiplier(3.0F)));

    static {
        Registry.register(
                Registries.ITEM,
                BloodStone.identifier,
                new BlockItem(BLOOD_STONE, new Item.Settings())
        );
    }

    public BloodStone(Settings settings) {
        super(settings);
    }

    public static void init() {}

}

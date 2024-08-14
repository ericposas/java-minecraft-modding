package com.testmod.registermods;

import com.testmod.TestMod;
import com.testmod.items.PickaxeItemWithCustomSound;
import com.testmod.materials.Adamantium;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterItems {

    public static final Item RAW_ADAMANTIUM =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(TestMod.MOD_ID, "raw_adamantium"),
                    new Item(
                            new Item.Settings()
                    )
            );

    public static final Item ADAMANTIUM_INGOT =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(TestMod.MOD_ID, "adamantium_ingot"),
                    new Item(
                            new Item.Settings()
                    )
            );

    public static final PickaxeItem ADAMANTIUM_PICKAXE_ITEM = new PickaxeItemWithCustomSound(
                Adamantium.INSTANCE,
                new Item.Settings().attributeModifiers(
                        PickaxeItem.createAttributeModifiers(
                                        Adamantium.INSTANCE,
                                        8,
                                        2.5F))
        );

    public static final Item ADAMANTIUM_CLAWS =
            Registry.register(
                Registries.ITEM,
                Identifier.of(TestMod.MOD_ID, "adamantium_claws"),
                ADAMANTIUM_PICKAXE_ITEM
            );

    static {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ADAMANTIUM_CLAWS));
    }

    public static void initialize() {}

}

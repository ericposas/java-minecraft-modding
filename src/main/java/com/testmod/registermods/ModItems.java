package com.testmod.registermods;

import com.testmod.TestMod;
import com.testmod.items.ItemWithTooltip;
import com.testmod.items.PickaxeItemWithCustomSound;
import com.testmod.materials.Adamantium;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HASTY_FOOD =
            registerItem(
                    new ItemWithTooltip(
                            new Item.Settings()
                                    .food(
                                            new FoodComponent.Builder()
                                                    .nutrition(2)
                                                    .saturationModifier(0.5f)
                                                    .statusEffect(
                                                            new StatusEffectInstance(
                                                                    StatusEffects.HASTE,
                                                                    60 * 20,
                                                                    1),
                                                            1.0f)
                                                    .build()
                                    ),
                            "Hasty fruit from Zelda BoTW"
                    ),
                    "hastyfood"
            );

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

    public static final PickaxeItem ADAMANTIUM_PICKAXE_ITEM;

    static {
        ADAMANTIUM_PICKAXE_ITEM = new PickaxeItemWithCustomSound(
                Adamantium.INSTANCE,
                new Item.Settings()
                        .attributeModifiers(
                                PickaxeItem.createAttributeModifiers(
                                        Adamantium.INSTANCE,
                                        8,
                                        2.5F
                                )
                        )
        );
    }

    public static final Item ADAMANTIUM_CLAWS = registerItem(
            ADAMANTIUM_PICKAXE_ITEM,
            "claws"
    );

    private static Item registerItem(Item item, String itemId) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(TestMod.MOD_ID, itemId),
                item
        );
    }

    static {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ModItems.ADAMANTIUM_CLAWS));
    }

    public static void initialize() {
    }

}

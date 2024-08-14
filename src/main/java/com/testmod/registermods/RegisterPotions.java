package com.testmod.registermods;

import com.testmod.TestMod;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class RegisterPotions {

    public static final Identifier POTION_ID =
            new Identifier(TestMod.MOD_ID, "rage_potion");

    public static final Potion RAGE_POTION =
            Registry.register(
                    Registries.POTION,
                    POTION_ID,
                    new Potion(
                            new StatusEffectInstance(
                                    Registries.STATUS_EFFECT.getEntry(
                                            RegisterEffects.RAGE_EFFECT
                                    ),
                                    3600,
                                    0)
                    )
            );

    public static final PotionItem RAGE_POTION_ITEM =
            Registry.register(
                    Registries.ITEM,
                    POTION_ID,
                    new PotionItem(
                            new Item.Settings()
                    )
            );

    static {
        FabricBrewingRecipeRegistryBuilder
                .BUILD.register(
                        builder -> {
                            builder.registerPotionRecipe(
                                    Potions.WATER,
                                    Items.CAKE,
                                    Registries.POTION.getEntry(
                                            RAGE_POTION
                                    )
                            );
                        }
                );
    }

    public static void initialize() {}

}

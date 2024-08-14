package com.testmod.registermods;

import com.testmod.TestMod;
import com.testmod.effects.RageEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterEffects {

    public static StatusEffect RAGE_EFFECT =
        Registry.register(
                Registries.STATUS_EFFECT,
                new Identifier(TestMod.MOD_ID, "rage"),
                new RageEffect()
        );

    public static void initialize() {
    }

}

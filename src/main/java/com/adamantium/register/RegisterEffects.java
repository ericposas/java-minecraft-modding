package com.adamantium.register;

import com.adamantium.AdamantiumMod;
import com.adamantium.effects.RageEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterEffects {

    public static StatusEffect RAGE_EFFECT =
        Registry.register(
                Registries.STATUS_EFFECT,
                new Identifier(AdamantiumMod.MOD_ID, "rage"),
                new RageEffect()
        );

    public static void initialize() {
    }

}

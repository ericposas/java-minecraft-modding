package com.adamantium.register;

import com.adamantium.AdamantiumMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RegisterSoundEvents {

    private RegisterSoundEvents() {}

    public static SoundEvent SNIKT =
            registerSound("snikt");

    public static BlockSoundGroup SNIKT_GROUP =
            new BlockSoundGroup(
                    1.0F,
                    1.0F,
                    SNIKT,
                    SNIKT,
                    SNIKT,
                    SNIKT,
                    SNIKT
            );

    public static SoundEvent SQUISH =
            registerSound("squish");

    public static SoundEvent SPLAT =
            registerSound("splat");

    public static SoundEvent GOOSH =
            registerSound("goosh");

    public static BlockSoundGroup SQUISH_GROUP =
            new BlockSoundGroup(
                    1.0F,
                    1.0F,
                    GOOSH,
                    SQUISH,
                    SPLAT,
                    SPLAT,
                    SQUISH
            );

    private static SoundEvent registerSound(String id) {
        Identifier identifier = new Identifier(
                AdamantiumMod.MOD_ID,
                id
        );
        return Registry.register(
                Registries.SOUND_EVENT,
                identifier,
                SoundEvent.of(identifier)
        );
    }

    public static void initialize(){}

}

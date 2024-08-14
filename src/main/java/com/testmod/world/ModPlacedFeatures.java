package com.testmod.world;

import com.testmod.TestMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ADAMANTIUM_ORE_PLACED_KEY =
            registerKey("adamantium_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> ctx) {
        var lookup = ctx.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(
                ctx,
                ADAMANTIUM_ORE_PLACED_KEY,
                lookup.getOrThrow(ModConfiguredFeatures.ADAMANTIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(
                        12,
                        HeightRangePlacementModifier.uniform(
                                YOffset.fixed(-100),
                                YOffset.fixed(100)
                        )
                )
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TestMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}

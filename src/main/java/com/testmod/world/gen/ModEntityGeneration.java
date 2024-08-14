package com.testmod.world.gen;

import com.testmod.registermods.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                ModEntities.ZOMBIE_GECKOLIB_ENTITY_TYPE,
                50,
                2,
                8
        );
        SpawnRestriction
                .register(
                        ModEntities.ZOMBIE_GECKOLIB_ENTITY_TYPE,
                        SpawnLocationTypes.ON_GROUND,
                        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                        HostileEntity::canSpawnInDark
                );
    }
}

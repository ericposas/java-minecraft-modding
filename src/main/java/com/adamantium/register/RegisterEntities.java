package com.adamantium.register;

import com.adamantium.AdamantiumMod;
import com.adamantium.entity.ZombieGeckoLibEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class RegisterEntities {

    // new DefaultedEntityGeoModel() will set up the following paths under:
    // assets/<namespace>/animations/entity/  entity.animation.json
    // assets/<namespace>/geo/entity/  entity.geo.json
    // assets/<namespace>/textures/entity/  entity.png
    public static DefaultedEntityGeoModel<ZombieGeckoLibEntity> ZOMBIE_GECKOLIB_MODEL =
            new DefaultedEntityGeoModel<>(new Identifier(AdamantiumMod.MOD_ID, "zombie"));

    public static final EntityType<ZombieGeckoLibEntity> ZOMBIE_GECKOLIB_ENTITY_TYPE =
            Registry.register(
                    Registries.ENTITY_TYPE,
                    new Identifier(AdamantiumMod.MOD_ID, "zombiegeckolib"),
                    EntityType.Builder
                            .create(ZombieGeckoLibEntity::new, SpawnGroup.MONSTER)
                            .dimensions(1.5f, 1.25f)
                            .build()
            );

    static {
        FabricDefaultAttributeRegistry
                .register(ZOMBIE_GECKOLIB_ENTITY_TYPE, ZombieGeckoLibEntity.setAttributes());
    }

    public static void initialize() {}

}

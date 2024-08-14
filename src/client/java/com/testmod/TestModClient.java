package com.testmod;

import com.testmod.entity.client.zombiegeckolib.ZombieGeckoLibRenderer;
import com.testmod.registermods.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TestModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(
				ModEntities.ZOMBIE_GECKOLIB_ENTITY_TYPE,
				(context) -> new ZombieGeckoLibRenderer(
						context,
						ModEntities.ZOMBIE_GECKOLIB_MODEL
				)
		);
	}

}
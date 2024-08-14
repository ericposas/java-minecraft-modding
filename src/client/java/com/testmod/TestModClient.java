package com.testmod;

import com.testmod.entity.client.zombiegeckolib.ZombieGeckoLibRenderer;
import com.testmod.registermods.RegisterEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TestModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(
				RegisterEntities.ZOMBIE_GECKOLIB_ENTITY_TYPE,
				(context) -> new ZombieGeckoLibRenderer(
						context,
						RegisterEntities.ZOMBIE_GECKOLIB_MODEL
				)
		);
	}

}
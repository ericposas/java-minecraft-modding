package com.adamantium;

import com.adamantium.entity.client.zombiegeckolib.ZombieGeckoLibRenderer;
import com.adamantium.register.RegisterEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AdamantiumModClient implements ClientModInitializer {

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
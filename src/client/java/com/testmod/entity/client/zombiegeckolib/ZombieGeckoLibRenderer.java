package com.testmod.entity.client.zombiegeckolib;

import com.testmod.entity.ZombieGeckoLibEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ZombieGeckoLibRenderer extends GeoEntityRenderer<ZombieGeckoLibEntity> {
    public ZombieGeckoLibRenderer(net.minecraft.client.render.entity.EntityRendererFactory.Context renderManager, GeoModel<ZombieGeckoLibEntity> model) {
        super(renderManager, model);
    }
}

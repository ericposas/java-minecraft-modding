package com.testmod.entity.client.zombie;

import com.testmod.TestMod;
import com.testmod.entity.ZombieEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ZombieEntityRenderer extends MobEntityRenderer<ZombieEntity, ZombieModel<ZombieEntity>> {

    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID, "textures/entity/zombie.png");

    public ZombieEntityRenderer(EntityRendererFactory.Context context, ZombieModel<ZombieEntity> entityModel, float f) {
        super(context, entityModel, f);
    }

    @Override
    public Identifier getTexture(ZombieEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ZombieEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}

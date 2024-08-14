// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package com.testmod.entity.client.zombie;

import com.testmod.entity.ZombieEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ZombieModel<Z extends ZombieEntity> extends SinglePartEntityModel<Z> {

	private final ModelPart Zombie;
	private final ModelPart Head;

	public ZombieModel(ModelPart root) {
		this.Zombie = root.getChild("Zombie");
		this.Head = this.Zombie.getChild("Head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Zombie = modelPartData.addChild("Zombie", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		Zombie.addChild("LeftLeg", ModelPartBuilder.create().uv(24, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9F, -12.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		Zombie.addChild("RightLeg", ModelPartBuilder.create().uv(24, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, -12.0F, 0.0F, -0.4363F, 0.0F, 0.0873F));
		Zombie.addChild("LeftArm", ModelPartBuilder.create().uv(0, 32).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.0F, -22.0F, 0.0F, -1.309F, 0.0873F, 0.0F));
		Zombie.addChild("RightArm", ModelPartBuilder.create().uv(0, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -22.0F, 0.0F, -1.3963F, -0.0873F, 0.0F));
		Zombie.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
				.uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -24.0F, 0.0F, 0.0524F, -0.1745F, 0.0F));
		ModelPartData Body = Zombie.addChild("Body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Zombie.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return this.Zombie;
	}

	@Override
	public void setAngles(Z entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
//		this.setHeadAngles(headYaw, headPitch);
		//this.animateMovement(ZombieAnimations.ZOMBIE_WALK, limbAngle, limbDistance, 2f, 2f);
		this.updateAnimation(entity.idlingAnimationState, ZombieAnimations.ZOMBIE_WALK, animationProgress, 2.5f);
	}

	public void setHeadAngles(float yaw, float pitch) {
		yaw = MathHelper.clamp(yaw, -30.0F, 30.0F);
		pitch = MathHelper.clamp(pitch, -25.0F, 25.0F);
		this.Head.yaw = yaw * 0.017453292F;
		this.Head.pitch = pitch * 0.017453292F;
	}

}
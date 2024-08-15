package com.adamantium.entity;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;


public class ZombieEntity extends net.minecraft.entity.mob.ZombieEntity {

    public final AnimationState idlingAnimationState  = new AnimationState();
    private int idleAnimationCooldown = 0;

    public ZombieEntity(EntityType<? extends net.minecraft.entity.mob.ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idlingAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }

    public static DefaultAttributeContainer.Builder createZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 5.0)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0D);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }

}

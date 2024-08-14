package com.testmod.entity;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;



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

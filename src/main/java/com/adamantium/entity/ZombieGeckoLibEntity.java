package com.adamantium.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class ZombieGeckoLibEntity extends HostileEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public ZombieGeckoLibEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 4.0)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    private static class ZombieGeckoLibAttackGoal extends MeleeAttackGoal {
        private final ZombieGeckoLibEntity zombie;
        private int ticks;
        public ZombieGeckoLibAttackGoal(ZombieGeckoLibEntity zombie, double speed, boolean pauseWhenMobIdle) {
            super(zombie, speed, pauseWhenMobIdle);
            this.zombie = zombie;
        }
        public void start() {
            super.start();
            this.ticks = 0;
        }
        public void stop() {
            super.stop();
            this.zombie.setAttacking(false);
        }
        public void tick() {
            super.tick();
            ++this.ticks;
            this.zombie.setAttacking(this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2);
        }
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new ZombieGeckoLibAttackGoal(this, 1.0, false));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0, true, 4, () -> true));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, (new RevengeGoal(this)).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, "controller", 0, this::predicate)
        );
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (geoAnimatableAnimationState.isMoving()) {
            if (this.handSwinging) {
                geoAnimatableAnimationState.getController().forceAnimationReset();
                geoAnimatableAnimationState.getController()
                        .setAnimation(RawAnimation.begin()
                                .then("ZOMBIE_ATTACK", Animation.LoopType.PLAY_ONCE));
            } else {
                geoAnimatableAnimationState.getController()
                        .setAnimation(RawAnimation.begin()
                                .then("ZOMBIE_WALK", Animation.LoopType.LOOP));
            }
        } else {
            geoAnimatableAnimationState.getController()
                    .setAnimation(
                            RawAnimation.begin()
                                    .then("ZOMBIE_IDLE", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}

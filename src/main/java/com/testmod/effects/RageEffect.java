package com.testmod.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;

public class RageEffect extends StatusEffect {

    public RageEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xff0000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity)
                    .increaseStat(
                            Stats.DAMAGE_DEALT,
                            10
                    );
        }
        return true;
    }

}

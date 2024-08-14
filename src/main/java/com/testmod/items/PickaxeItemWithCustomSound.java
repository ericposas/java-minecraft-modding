package com.testmod.items;

import com.testmod.registermods.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class PickaxeItemWithCustomSound extends PickaxeItem {

    public PickaxeItemWithCustomSound(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient()) {
            attacker.playSound(
                    ModSoundEvents.SNIKT,
                    1.5f,
                    1f
            );
            target.playSound(
                    ModSoundEvents.GOOSH,
                    1f,
                    1f
            );
            target.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.BLINDNESS,
                            1200,
                            1
                    ),
                    attacker
            );
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient()) {
            miner.playSound(
                    ModSoundEvents.SNIKT,
                    1.5f,
                    1f
            );
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (player.getWorld().isClient()) {
            player.playSound(ModSoundEvents.SNIKT, 1.5f, 0.9f);
        }
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
    }

}

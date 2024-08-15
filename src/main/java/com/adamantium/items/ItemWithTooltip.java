package com.adamantium.items;

import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ItemWithTooltip extends Item {

    private String tooltipText;

    private void setTooltipText(String txt) {
        tooltipText = txt;
    }

    private String getTooltipText() {
        return tooltipText;
    }

    public ItemWithTooltip(Settings settings, String tooltipText) {
        super(settings);
        setTooltipText(tooltipText);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(
                Text.of(getTooltipText()
                      .formatted(Formatting.GREEN))
        );
    }

}

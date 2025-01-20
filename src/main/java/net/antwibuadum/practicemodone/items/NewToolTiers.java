package net.antwibuadum.practicemodone.items;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.util.TagsClass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class NewToolTiers {
    public static final Tier SAPPHIRE_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 12f, 5f, 25, TagsClass.Blocks.NEEDS_SAPPHIRE_TOOL,
                    () -> Ingredient.of(ExtraItems.SAPPHIRE_OBJECT.get())),
            new ResourceLocation(PracticeModOne.MOD_ID, "sapphire"),
            List.of(Tiers.NETHERITE),
            List.of());
}

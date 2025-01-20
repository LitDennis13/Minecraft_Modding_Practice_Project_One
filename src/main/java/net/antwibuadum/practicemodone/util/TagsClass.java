package net.antwibuadum.practicemodone.util;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsClass {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_NOTABLES = tag("metal_detector_notables");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PracticeModOne.MOD_ID, name));
        }
    }

    public static class Items {



        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PracticeModOne.MOD_ID, name));
        }
    }
}

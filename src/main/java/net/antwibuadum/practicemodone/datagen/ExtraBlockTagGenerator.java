package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.antwibuadum.practicemodone.util.TagsClass;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ExtraBlockTagGenerator extends BlockTagsProvider {

    public ExtraBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PracticeModOne.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TagsClass.Blocks.METAL_DETECTOR_NOTABLES)
                .add(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get())
                .addTag(Tags.Blocks.ORES)
                .add(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get())
                .add(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get())
                .add(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get())
                .add(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ExtraBlocks.BLOCK_OF_SAPPHIRE.get());

       this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(TagsClass.Blocks.NEEDS_SAPPHIRE_TOOL)
                .add(ExtraBlocks.BLOCK_OF_SOUND.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ExtraBlocks.BLOCK_OF_SAPPHIRE.get(),
                        ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get(),
                        ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get(),
                        ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get(),
                        ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get(),
                        ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get(),
                        ExtraBlocks.BLOCK_OF_SOUND.get()
                );


        this.tag(BlockTags.FENCES)
                .add(ExtraBlocks.FENCE_OF_SAPPHIRE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ExtraBlocks.FENCE_GATE_OF_SAPPHIRE.get());

        this.tag(BlockTags.WALLS)
                .add(ExtraBlocks.WALL_OF_SAPPHIRE.get());
    }
}

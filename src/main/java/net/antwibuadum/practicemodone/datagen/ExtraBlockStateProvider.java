package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ExtraBlockStateProvider extends BlockStateProvider {
    public ExtraBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PracticeModOne.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ExtraBlocks.BLOCK_OF_SAPPHIRE);
        blockWithItem(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE);
        blockWithItem(ExtraBlocks.BLOCK_OF_SOUND);

        blockWithItem(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE);
        blockWithItem(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE);
        blockWithItem(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

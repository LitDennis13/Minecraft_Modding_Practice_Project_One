package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        stairsBlock((StairBlock) ExtraBlocks.STAIRS_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));
        slabBlock((SlabBlock) ExtraBlocks.SLAB_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));

        buttonBlock((ButtonBlock) ExtraBlocks.BUTTON_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));
        pressurePlateBlock((PressurePlateBlock) ExtraBlocks.PRESSURE_PLATE_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));

        fenceBlock((FenceBlock) ExtraBlocks.FENCE_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));
        fenceGateBlock((FenceGateBlock) ExtraBlocks.FENCE_GATE_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));
        wallBlock((WallBlock) ExtraBlocks.WALL_OF_SAPPHIRE.get(), blockTexture(ExtraBlocks.BLOCK_OF_SAPPHIRE.get()));

        doorBlockWithRenderType((DoorBlock) ExtraBlocks.DOOR_OF_SAPPHIRE.get(), modLoc("block/door_bottom_of_sapphire"), modLoc("block/door_top_of_sapphire"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ExtraBlocks.TRAP_DOOR_OF_SAPPHIRE.get(), modLoc("block/trap_door_of_sapphire"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

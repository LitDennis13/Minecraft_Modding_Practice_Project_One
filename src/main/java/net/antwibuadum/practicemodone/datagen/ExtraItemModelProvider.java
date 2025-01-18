package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraItemModelProvider extends ItemModelProvider {
    public ExtraItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PracticeModOne.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ExtraItems.SAPPHIRE_OBJECT);
        simpleItem(ExtraItems.RAW_SAPPHIRE_OBJECT);
        simpleItem(ExtraItems.F1_LOGO);
        simpleItem(ExtraItems.METAL_DETECTOR);
        simpleItem(ExtraItems.STRAWBERRY_FOOD);
        simpleItem(ExtraItems.PINE_CONE_OBJECT);

        simpleBLockItem(ExtraBlocks.DOOR_OF_SAPPHIRE);
        fenceItem(ExtraBlocks.FENCE_OF_SAPPHIRE, ExtraBlocks.BLOCK_OF_SAPPHIRE);
        buttonItem(ExtraBlocks.BUTTON_OF_SAPPHIRE, ExtraBlocks.BLOCK_OF_SAPPHIRE);
        wallItem(ExtraBlocks.WALL_OF_SAPPHIRE, ExtraBlocks.BLOCK_OF_SAPPHIRE);
        trapdoorItem(ExtraBlocks.TRAP_DOOR_OF_SAPPHIRE);

        evenSimplerBlockItem(ExtraBlocks.STAIRS_OF_SAPPHIRE);
        evenSimplerBlockItem(ExtraBlocks.SLAB_OF_SAPPHIRE);
        evenSimplerBlockItem(ExtraBlocks.PRESSURE_PLATE_OF_SAPPHIRE);
        evenSimplerBlockItem(ExtraBlocks.FENCE_GATE_OF_SAPPHIRE);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PracticeModOne.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBLockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PracticeModOne.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder evenSimplerBlockItem(RegistryObject<Block> block) {
        return withExistingParent(PracticeModOne.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(PracticeModOne.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(PracticeModOne.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(PracticeModOne.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}

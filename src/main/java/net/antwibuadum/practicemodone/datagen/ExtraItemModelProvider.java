package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ExtraItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


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

        handheldItem(ExtraItems.SWORD_OF_SAPPHIRE);
        handheldItem(ExtraItems.PICKAXE_OF_SAPPHIRE);
        handheldItem(ExtraItems.AXE_OF_SAPPHIRE);
        handheldItem(ExtraItems.SHOVEL_OF_SAPPHIRE);
        handheldItem(ExtraItems.HOE_OF_SAPPHIRE);

        trimmedArmorItem(ExtraItems.HELMUT_OF_SAPPHIRE);
        trimmedArmorItem(ExtraItems.CHESTPLATE_OF_SAPPHIRE);
        trimmedArmorItem(ExtraItems.LEGGINGS_OF_SAPPHIRE);
        trimmedArmorItem(ExtraItems.BOOTS_OF_SAPPHIRE);
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = PracticeModOne.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
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

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(PracticeModOne.MOD_ID, "item/" + item.getId().getPath()));
    }
}

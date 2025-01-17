package net.antwibuadum.practicemodone.datagen;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PracticeModOne.MOD_ID,"item/" + item.getId().getPath()));
    }
}

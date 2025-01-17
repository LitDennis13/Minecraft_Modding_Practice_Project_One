package net.antwibuadum.practicemodone.items;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.items.functional.FuelItem;
import net.antwibuadum.practicemodone.items.functional.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExtraItems {
    public static final DeferredRegister<Item>  EXTRA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PracticeModOne.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE_OBJECT = EXTRA_ITEMS.register("piece_of_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE_OBJECT = EXTRA_ITEMS.register("raw_piece_of_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> F1_LOGO = EXTRA_ITEMS.register("formula_one_logo",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = EXTRA_ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(25)));
    public static final RegistryObject<Item> STRAWBERRY_FOOD = EXTRA_ITEMS.register("strawberry_food",
            () -> new Item(new Item.Properties().food(ExtraFood.STRAWBERRY)));
    public static final RegistryObject<Item> PINE_CONE_OBJECT = EXTRA_ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 16));


    public static void register(IEventBus eventBus) {
        EXTRA_ITEMS.register(eventBus);
    }
}

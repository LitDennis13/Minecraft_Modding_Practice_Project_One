package net.antwibuadum.practicemodone.items;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.items.functional.FuelItem;
import net.antwibuadum.practicemodone.items.functional.MetalDetectorItem;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> STAFF_OF_SAPPHIRE = EXTRA_ITEMS.register("staff_of_sapphire",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SWORD_OF_SAPPHIRE = EXTRA_ITEMS.register("sword_of_sapphire",
            () -> new SwordItem(NewToolTiers.SAPPHIRE_TIER, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> PICKAXE_OF_SAPPHIRE = EXTRA_ITEMS.register("pickaxe_of_sapphire",
            () -> new PickaxeItem(NewToolTiers.SAPPHIRE_TIER, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> AXE_OF_SAPPHIRE = EXTRA_ITEMS.register("axe_of_sapphire",
            () -> new AxeItem(NewToolTiers.SAPPHIRE_TIER, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> SHOVEL_OF_SAPPHIRE = EXTRA_ITEMS.register("shovel_of_sapphire",
            () -> new ShovelItem(NewToolTiers.SAPPHIRE_TIER, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> HOE_OF_SAPPHIRE = EXTRA_ITEMS.register("hoe_of_sapphire",
            () -> new HoeItem(NewToolTiers.SAPPHIRE_TIER, 0, 0, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        EXTRA_ITEMS.register(eventBus);
    }
}

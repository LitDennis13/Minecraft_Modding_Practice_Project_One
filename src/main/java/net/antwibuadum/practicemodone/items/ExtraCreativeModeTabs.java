package net.antwibuadum.practicemodone.items;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExtraCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> EXTRA_CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PracticeModOne.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXTRA_ITEMS_CREATIVE_TAB  = EXTRA_CREATIVE_MODE_TABS.register("extra_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ExtraItems.SAPPHIRE_OBJECT.get()))
                    .title(Component.translatable("creativetab.extra_stuff"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ExtraItems.SAPPHIRE_OBJECT.get());
                        pOutput.accept(ExtraItems.RAW_SAPPHIRE_OBJECT.get());
                        pOutput.accept(ExtraItems.F1_LOGO.get());
                        pOutput.accept(ExtraItems.METAL_DETECTOR.get());
                        pOutput.accept(ExtraBlocks.BLOCK_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get());
                        pOutput.accept(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get());
                        pOutput.accept(ExtraBlocks.STAIRS_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.SLAB_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.BUTTON_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.PRESSURE_PLATE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.FENCE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.FENCE_GATE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.WALL_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.DOOR_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.TRAP_DOOR_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraBlocks.BLOCK_OF_SOUND.get());
                        pOutput.accept(ExtraItems.STRAWBERRY_FOOD.get());
                        pOutput.accept(ExtraItems.PINE_CONE_OBJECT.get());
                        pOutput.accept(ExtraItems.STAFF_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.SWORD_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.PICKAXE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.AXE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.SHOVEL_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.HOE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.HELMUT_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.CHESTPLATE_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.LEGGINGS_OF_SAPPHIRE.get());
                        pOutput.accept(ExtraItems.BOOTS_OF_SAPPHIRE.get());


                        // Vanilla Items
                        pOutput.accept(Items.EMERALD);
                        pOutput.accept(Items.GRASS_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        EXTRA_CREATIVE_MODE_TABS.register(eventBus);
    }
}

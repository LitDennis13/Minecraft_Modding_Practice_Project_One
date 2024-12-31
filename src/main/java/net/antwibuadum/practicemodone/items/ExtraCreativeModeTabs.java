package net.antwibuadum.practicemodone.items;

import net.antwibuadum.practicemodone.PracticeModOne;
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

                        // Vanilla Item
                        pOutput.accept(Items.EMERALD);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        EXTRA_CREATIVE_MODE_TABS.register(eventBus);
    }
}

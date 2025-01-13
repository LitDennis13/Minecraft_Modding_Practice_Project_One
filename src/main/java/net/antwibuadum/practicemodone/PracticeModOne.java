package net.antwibuadum.practicemodone;

import com.mojang.logging.LogUtils;
import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.antwibuadum.practicemodone.items.ExtraCreativeModeTabs;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(net.antwibuadum.practicemodone.PracticeModOne.MOD_ID)
public class PracticeModOne
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "practicemodone";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PracticeModOne(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ExtraItems.register(modEventBus);

        ExtraBlocks.register(modEventBus);

        // Extra Items creative mode tab
        ExtraCreativeModeTabs.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ExtraItems.SAPPHIRE_OBJECT);
            event.accept(ExtraItems.RAW_SAPPHIRE_OBJECT);
            event.accept(ExtraItems.F1_LOGO);
            event.accept(ExtraBlocks.BLOCK_OF_SAPPHIRE);
            event.accept(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE);
            event.accept(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE);
            event.accept(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE);
            event.accept(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE);
            event.accept(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ExtraBlocks.BLOCK_OF_SAPPHIRE);
            event.accept(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}

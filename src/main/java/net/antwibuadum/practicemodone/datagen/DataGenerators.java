package net.antwibuadum.practicemodone.datagen;

import com.google.common.eventbus.Subscribe;
import net.antwibuadum.practicemodone.PracticeModOne;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = PracticeModOne.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ExtraRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ExtraLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new ExtraBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ExtraItemModelProvider(packOutput, existingFileHelper));

        ExtraBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ExtraBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ExtraItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }

}

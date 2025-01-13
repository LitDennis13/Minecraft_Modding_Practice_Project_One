package net.antwibuadum.practicemodone.blocks;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.functional.SoundBlock;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ExtraBlocks {
    public static final DeferredRegister<Block> EXTRA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PracticeModOne.MOD_ID);


    public static final RegistryObject<Block> BLOCK_OF_SAPPHIRE = registerExtraBLock("block_of_sapphire",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> RAW_BLOCK_OF_SAPPHIRE = registerExtraBLock("raw_block_of_sapphire",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> BLOCK_OF_SOUND = registerExtraBLock("block_of_sound",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK)));

    public static final RegistryObject<Block> BLOCK_OF_SAPPHIRE_ORE = registerExtraBLock("block_of_sapphire_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE = registerExtraBLock("block_of_deepslate_sapphire_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> BLOCK_OF_NETHER_SAPPHIRE_ORE = registerExtraBLock("block_of_nether_sapphire_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> BLOCK_OF_END_STONE_SAPPHIRE_ORE = registerExtraBLock("block_of_end_stone_sapphire_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(3.5f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    private static <T extends Block> RegistryObject<T> registerExtraBLock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = EXTRA_BLOCKS.register(name, block);
        registerExtraBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerExtraBlockItem(String name, RegistryObject<T> block) {
        return ExtraItems.EXTRA_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        EXTRA_BLOCKS.register(eventBus);
    }
}

package net.antwibuadum.practicemodone.blocks;

import net.antwibuadum.practicemodone.PracticeModOne;
import net.antwibuadum.practicemodone.blocks.functional.SoundBlock;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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

    public static final RegistryObject<Block> STAIRS_OF_SAPPHIRE = registerExtraBLock("stairs_of_sapphire",
            () -> new StairBlock(() -> ExtraBlocks.BLOCK_OF_SAPPHIRE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SLAB_OF_SAPPHIRE = registerExtraBLock("slab_of_sapphire",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> BUTTON_OF_SAPPHIRE = registerExtraBLock("button_of_sapphire",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.GLASS),
            BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> PRESSURE_PLATE_OF_SAPPHIRE = registerExtraBLock("pressure_plate_of_sapphire",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS),
            BlockSetType.IRON));

    public static final RegistryObject<Block> FENCE_OF_SAPPHIRE = registerExtraBLock("fence_of_sapphire",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> FENCE_GATE_OF_SAPPHIRE = registerExtraBLock("fence_gate_of_sapphire",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> WALL_OF_SAPPHIRE = registerExtraBLock("wall_of_sapphire",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> DOOR_OF_SAPPHIRE = registerExtraBLock("door_of_sapphire",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> TRAP_DOOR_OF_SAPPHIRE = registerExtraBLock("trap_door_of_sapphire",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.GLASS).noOcclusion(), BlockSetType.OAK));


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

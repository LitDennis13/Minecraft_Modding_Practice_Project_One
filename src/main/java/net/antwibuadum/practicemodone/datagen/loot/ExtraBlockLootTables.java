package net.antwibuadum.practicemodone.datagen.loot;

import net.antwibuadum.practicemodone.blocks.ExtraBlocks;
import net.antwibuadum.practicemodone.items.ExtraItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ExtraBlockLootTables extends BlockLootSubProvider {

    public ExtraBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ExtraBlocks.BLOCK_OF_SAPPHIRE.get());
        this.dropSelf(ExtraBlocks.RAW_BLOCK_OF_SAPPHIRE.get());
        this.dropSelf(ExtraBlocks.BLOCK_OF_SOUND.get());

        this.add(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ExtraBlocks.BLOCK_OF_SAPPHIRE_ORE.get(), ExtraItems.RAW_SAPPHIRE_OBJECT.get()));
        this.add(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ExtraBlocks.BLOCK_OF_DEEPSLATE_SAPPHIRE_ORE.get(), ExtraItems.RAW_SAPPHIRE_OBJECT.get()));
        this.add(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ExtraBlocks.BLOCK_OF_NETHER_SAPPHIRE_ORE.get(), ExtraItems.RAW_SAPPHIRE_OBJECT.get()));
        this.add(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ExtraBlocks.BLOCK_OF_END_STONE_SAPPHIRE_ORE.get(), ExtraItems.RAW_SAPPHIRE_OBJECT.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ExtraBlocks.EXTRA_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

package com.ngoclinh.acm.block;

import com.ngoclinh.acm.AzusCommunityMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.ngoclinh.acm.ModItemGroup.AZU_TAB_KEY;

public class ModBlocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AzusCommunityMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzusCommunityMod.MOD_ID, name));
    }

    public static final Block ECLIPSITE_BLOCK = register(
            "eclipsite_block",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().strength(50f, 100f).sounds(BlockSoundGroup.METAL),
            true
    );

    public static void initialize() {
        AzusCommunityMod.LOGGER.info("Registering Mod Blocks for " + AzusCommunityMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(AZU_TAB_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.ECLIPSITE_BLOCK.asItem());
        });
    }
}

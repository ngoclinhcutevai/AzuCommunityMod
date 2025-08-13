package com.ngoclinh.acm.item;

import com.ngoclinh.acm.AzusCommunityMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DISC_BLUE = registerItem("disc_blue",
            new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzusCommunityMod.MOD_ID,"disc_blue")))));

    public static final Item DISC_HORIZON = registerItem("disc_horizon",
            new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzusCommunityMod.MOD_ID,"disc_horizon")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AzusCommunityMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AzusCommunityMod.LOGGER.info("Registering Mod Items for " + AzusCommunityMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((content) -> {
            content.add(DISC_BLUE);
            content.add(DISC_HORIZON);
        });
    }
}

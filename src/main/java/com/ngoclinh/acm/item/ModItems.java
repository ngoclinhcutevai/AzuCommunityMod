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

import java.util.function.Function;

import static com.ngoclinh.acm.ModItemGroup.AZU_TAB_KEY;

public class ModItems {

    public static final Item DISC_BLUE = register("disc_blue", Item::new, new Item.Settings());
    public static final Item DISC_HORIZON = register("disc_horizon", Item::new, new Item.Settings());
    public static final Item DISC_CLOUDS = register("disc_clouds", Item::new, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AzusCommunityMod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        AzusCommunityMod.LOGGER.info("Registering Mod Items for " + AzusCommunityMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(AZU_TAB_KEY).register((content) -> {
            content.add(DISC_BLUE);
            content.add(DISC_HORIZON);
            content.add(DISC_CLOUDS);
        });
    }
}

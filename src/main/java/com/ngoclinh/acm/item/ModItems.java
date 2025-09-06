package com.ngoclinh.acm.item;

import com.ngoclinh.acm.AzusCommunityMod;
import com.ngoclinh.acm.ModItemGroup;
import com.ngoclinh.acm.sound.ModSounds;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems extends Item {

    public static final Item DISC_BLUE = register("disc_blue",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.DISC_BLUE_KEY).maxCount(1).rarity(Rarity.RARE));
    public static final Item DISC_HORIZON = register("disc_horizon",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.DISC_HORIZON_KEY).maxCount(1).rarity(Rarity.RARE));
    public static final Item DISC_CLOUDS = register("disc_clouds",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.DISC_CLOUDS_KEY).maxCount(1).rarity(Rarity.RARE));
    public static final Item ECLIPSITE = register("eclipsite",
            Item::new, new Item.Settings().rarity(Rarity.RARE));
    public static final Item ECLIPSITE_DUST = register("eclipsite_dust",
            Item::new, new Item.Settings().rarity(Rarity.RARE));

    public ModItems(Settings settings) {
        super(settings);
    }

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
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.AZU_TAB_KEY).register((content) -> {
            content.add(DISC_BLUE);
            content.add(DISC_HORIZON);
            content.add(DISC_CLOUDS);
            content.add(ECLIPSITE);
            content.add(ECLIPSITE_DUST);
        });
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(DISC_BLUE)) {
                list.add(Text.translatable("item.azu-cm.disc_blue_desc").formatted(Formatting.GRAY));
            } else if (itemStack.isOf(DISC_HORIZON)) {
                list.add(Text.translatable("item.azu-cm.disc_horizon_desc").formatted(Formatting.GRAY));
            } else if (itemStack.isOf(DISC_CLOUDS)) {
                list.add(Text.translatable("item.azu-cm.disc_clouds_desc").formatted(Formatting.GRAY));
            }
        });
    }
}

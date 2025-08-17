package com.ngoclinh.acm;

import com.ngoclinh.acm.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final RegistryKey<ItemGroup> AZU_TAB_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AzusCommunityMod.MOD_ID, "item_group"));
    public static final ItemGroup AZU_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.ECLIPSITE))
            .displayName(Text.translatable("itemGroup.azu-cm"))
            .build();

    public static void initialize() {
        AzusCommunityMod.LOGGER.info("Registering Mod Item Group for " + AzusCommunityMod.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, AZU_TAB_KEY, AZU_ITEM_GROUP);
    }

}

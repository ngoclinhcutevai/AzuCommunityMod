package com.ngoclinh.acm.datagen;

import com.ngoclinh.acm.item.ModItems;
import com.ngoclinh.acm.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.ACM_ITEMS)
                .add(ModItems.DISC_BLUE)
                .add(ModItems.DISC_CLOUDS)
                .add(ModItems.DISC_HORIZON)
                .add(ModItems.ECLIPSITE_DUST)
                .add(ModItems.ECLIPSITE);
    }
}

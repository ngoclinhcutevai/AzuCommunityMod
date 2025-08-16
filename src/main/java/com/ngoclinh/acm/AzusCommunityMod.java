package com.ngoclinh.acm;

import com.ngoclinh.acm.block.ModBlocks;
import com.ngoclinh.acm.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzusCommunityMod implements ModInitializer {
	public static final String MOD_ID = "azu-cm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModItemGroup.initialize();
		LOGGER.info("Hello from ngoclin.h!");
	}
}
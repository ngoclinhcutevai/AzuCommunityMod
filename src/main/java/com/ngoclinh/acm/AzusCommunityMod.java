package com.ngoclinh.acm;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzusCommunityMod implements ModInitializer {
	public static final String MOD_ID = "azu-cm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello from ngoclin.h!");
	}
}
package com.example;

import net.fabricmc.api.ModInitializer;

public class MyMod implements ModInitializer {
	public static final String MOD_ID = "minecraftchmirs";

	@Override
	public void onInitialize() {
        ModItems.initialize();
    }
}

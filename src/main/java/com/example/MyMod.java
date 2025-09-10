package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class MyMod implements ModInitializer {
    public static final String MOD_ID = "modid";
    public static Item GRIVNA;

    @Override
    public void onInitialize() {
        Identifier grivnaId = Identifier.of(MOD_ID, "Grivna");

        GRIVNA = Registry.register(
                Registries.ITEM,
                grivnaId,
                new Item(new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), grivnaId)))
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(GRIVNA);
        });

        System.out.println("Мод " + MOD_ID + " завантажено!");
    }
}

package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;


public class ModItems {
  public static void initialize() {
  }

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, name));

		Item item = itemFactory.apply(settings.registryKey(itemKey));

		Registry.register(Registries.ITEM, itemKey, item);

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
        .register((itemGroup) -> itemGroup.add(ModItems.HRYVNIA));

		return item;
	}

  public static final Item HRYVNIA = ModItems.register("hryvnia", Item::new, new Item.Settings());
}

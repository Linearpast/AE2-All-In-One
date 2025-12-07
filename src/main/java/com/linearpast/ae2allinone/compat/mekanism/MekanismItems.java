package com.linearpast.ae2allinone.compat.mekanism;

import com.linearpast.ae2allinone.Ae2AllInOne;
import com.linearpast.ae2allinone.compat.mekanism.item.AllChemicalCell;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registry for Mekanism-related items.
 * Items are only registered when Mekanism is present.
 */
public class MekanismItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ae2AllInOne.MODID);

    public static RegistryObject<Item> ALL_CHEMICAL_CELL;

    private static boolean registered = false;

    /**
     * Register Mekanism items if Mekanism is loaded.
     * Must be called during mod construction.
     */
    public static void register(IEventBus modBus) {
        if (registered) {
            return;
        }

        // Check if both Mekanism and Applied Mekanistics are available
        if (!ModList.get().isLoaded("mekanism") || !ModList.get().isLoaded("appmek")) {
            return;
        }

        ALL_CHEMICAL_CELL = ITEMS.register("all_chemical_cell", () ->
                new AllChemicalCell(new Item.Properties().stacksTo(1)));

        ITEMS.register(modBus);
        registered = true;
    }

    public static boolean isRegistered() {
        return registered;
    }
}

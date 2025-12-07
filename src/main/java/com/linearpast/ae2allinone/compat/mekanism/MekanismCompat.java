package com.linearpast.ae2allinone.compat.mekanism;

import appeng.api.storage.StorageCells;
import com.linearpast.ae2allinone.compat.mekanism.cells.AllChemicalCellHandler;
import com.linearpast.ae2allinone.compat.mekanism.cells.AllChemicalStorageCell;
import net.minecraftforge.fml.ModList;

/**
 * Mekanism compatibility module.
 * This class handles the registration of Mekanism-related storage cells.
 */
public class MekanismCompat {

    private static boolean initialized = false;

    public static boolean isMekanismLoaded() {
        return ModList.get().isLoaded("mekanism");
    }

    public static boolean isAppliedMekanisticsLoaded() {
        return ModList.get().isLoaded("appmek");
    }

    public static boolean isCompatAvailable() {
        return isMekanismLoaded() && isAppliedMekanisticsLoaded();
    }

    /**
     * Initialize the Mekanism compatibility module.
     * This should be called during FMLCommonSetupEvent.
     */
    public static void init() {
        if (initialized) {
            return;
        }

        if (!isCompatAvailable()) {
            return;
        }

        try {
            AllChemicalStorageCell.loadAllChemicals();

            StorageCells.addCellHandler(AllChemicalCellHandler.INSTANCE);

            initialized = true;
        } catch (Exception e) {

        }
    }
}

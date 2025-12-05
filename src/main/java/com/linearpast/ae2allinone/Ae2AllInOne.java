package com.linearpast.ae2allinone;

import com.linearpast.ae2allinone.item.TestItem;
import com.linearpast.ae2allinone.registry.CommonEvents;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Ae2AllInOne.MODID)
public class Ae2AllInOne {
    public static final String MODID = "ae2allinone";
    private static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final RegistryObject<Item> item = REGISTRY.register("123ss", () ->
            new TestItem(new Item.Properties().stacksTo(1)));

    public Ae2AllInOne() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        REGISTRY.register(modBus);

        modBus.addListener(CommonEvents::setup);
    }
}

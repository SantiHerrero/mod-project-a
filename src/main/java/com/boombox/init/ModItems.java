package com.boombox.init;

import com.boombox.BoomBox;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

// aca registramos unicamente los items
public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BoomBox.MODID);

    // 🔹 Diccionario: nombre → propiedades
    private static final Map<String, Item.Properties> ITEM_DEFINITIONS = new HashMap<>();

    static {
//      EJEMPLO PARA DECLARAR ITEMS

//      ITEM_DEFINITIONS.put("<NOMBRE_ITEM>", new Item.Properties());
    }

    // 🔹 Registro dinámico
    public static final Map<String, RegistryObject<Item>> REGISTERED_ITEMS = new HashMap<>();
    static {
        ITEM_DEFINITIONS.forEach((name, props) -> {
            REGISTERED_ITEMS.put(name, ITEMS.register(name, () -> new Item(props)));
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package com.boombox.init;

import com.boombox.BoomBox;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// aca se registran todos los bloques
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BoomBox.MODID);

    public static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BoomBox.MODID);

    // 🔹 Diccionario: nombre → proveedor del bloque
    private static final Map<String, Supplier<Block>> BLOCK_DEFINITIONS = new HashMap<>();

    static {

//        EJEMPLO PARA DECLARAR items con propiedades

//        BLOCK_DEFINITIONS.put("<NOMBRE_ITEM>", () ->
//                new Block(BlockBehaviour.Properties.of()
//                        .strength(5f)
//                        .requiresCorrectToolForDrops()));
    }

    // 🔹 Registros reales
    public static final Map<String, RegistryObject<Block>> REGISTERED_BLOCKS = new HashMap<>();

    static {
        BLOCK_DEFINITIONS.forEach((name, blockSupplier) -> {
            RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
            REGISTERED_BLOCKS.put(name, block);

            // Registrar también el BlockItem asociado
            BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }
}

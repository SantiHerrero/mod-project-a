package com.boombox.init;

import com.boombox.BoomBox;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    // Registrar los tabs con DeferredRegister
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BoomBox.MODID);

    // Tab de BLOQUES
    public static final RegistryObject<CreativeModeTab> TAB_BLOCKS =
            CREATIVE_TABS.register("boombox_blocks", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.boombox.blocks"))
                            .displayItems((parameters, output) -> {
                                ModBlocks.REGISTERED_BLOCKS.values().forEach(
                                        block -> output.accept(block.get().asItem()));
                            })
                            .build()
            );

    // Tab de ÍTEMS
    public static final RegistryObject<CreativeModeTab> TAB_ITEMS =
            CREATIVE_TABS.register("boombox_items", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.boombox.items"))
                            .displayItems((parameters, output) -> {
                                ModItems.REGISTERED_ITEMS.values().forEach(
                                        item -> output.accept(item.get()));
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}

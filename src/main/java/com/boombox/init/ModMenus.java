package com.boombox.init;

import com.boombox.BoomBox;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BoomBox.MODID);

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

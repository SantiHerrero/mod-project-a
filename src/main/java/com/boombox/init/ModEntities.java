package com.boombox.init;

import com.boombox.BoomBox;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// aca registramos entidades
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BoomBox.MODID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}

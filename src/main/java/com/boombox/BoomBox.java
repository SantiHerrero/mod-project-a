package com.boombox;

import com.boombox.init.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DistExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BoomBox.MODID)
public class BoomBox {
    public static final String MODID = "boomboxmod";

    // Logger para debugging (aparece en los logs de Forge)
    public static final Logger LOGGER = LogManager.getLogger();

    public BoomBox(FMLJavaModLoadingContext context) {
        LOGGER.info("Cargando mod: {}", MODID);

        IEventBus modEventBus = context.getModEventBus();

        // 🔹 Registro automático de contenido
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModMenus.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // 🔸 Setup común (servidor y cliente)
        modEventBus.addListener(this::commonSetup);

        // 🔸 Setup cliente (solo en cliente)
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () ->
                () -> modEventBus.addListener(this::clientSetup));

        // 🔸 Registro de eventos generales del mod
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Ejecutado al iniciar (común para cliente y servidor)
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("[{}] Ejecutando setup común", MODID);
        // Ejemplo: registrar paquetes de red o capacidades
    }

    // Ejecutado solo del lado del cliente
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("[{}] Ejecutando setup de cliente", MODID);
        // Ejemplo: renderers o configuraciones gráficas
    }
}

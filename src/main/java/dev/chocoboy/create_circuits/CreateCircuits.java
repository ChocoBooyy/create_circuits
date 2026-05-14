package dev.chocoboy.create_circuits;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import dev.chocoboy.create_circuits.infrastructure.datagen.CircuitsDatagen;
import dev.chocoboy.create_circuits.registry.CircuitsBETypes;
import dev.chocoboy.create_circuits.registry.CircuitsBlocks;
import dev.chocoboy.create_circuits.registry.CircuitsCreativeTabs;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(CreateCircuits.MOD_ID)
public class CreateCircuits {

    public static final String MOD_ID = "create_circuits";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));
    }

    public CreateCircuits(IEventBus modEventBus, ModContainer modContainer) {
        REGISTRATE.registerEventListeners(modEventBus);
        CircuitsCreativeTabs.register(modEventBus);
        CircuitsBlocks.register();
        CircuitsBETypes.register();
        modEventBus.addListener(CircuitsDatagen::gatherData);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            CreateCircuitsClient.init(modEventBus);
        }
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}

package dev.chocoboy.create_circuits.infrastructure.ponder;

import dev.chocoboy.create_circuits.CreateCircuits;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.createmod.ponder.api.registration.SharedTextRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class CircuitsPonderPlugin implements PonderPlugin {

    @Override
    public String getModId() {
        return CreateCircuits.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        CircuitsPonderScenes.register(helper);
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        CircuitsPonderTags.register();
    }

    @Override
    public void registerSharedText(SharedTextRegistrationHelper helper) {}
}

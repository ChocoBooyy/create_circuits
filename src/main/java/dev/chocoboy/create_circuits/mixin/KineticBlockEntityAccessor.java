package dev.chocoboy.create_circuits.mixin;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = KineticBlockEntity.class, remap = false)
public interface KineticBlockEntityAccessor {
    @Accessor("capacity") float getCapacity();
    @Accessor("stress") float getStress();
}

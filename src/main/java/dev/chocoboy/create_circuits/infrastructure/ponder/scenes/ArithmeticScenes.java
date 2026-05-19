package dev.chocoboy.create_circuits.infrastructure.ponder.scenes;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public final class ArithmeticScenes {

    private ArithmeticScenes() {}

    public static void subtractor(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("subtractor", "Subtracting redstone with the Subtractor");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos lampPos = util.grid().at(3, 1, 2);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("The Subtractor outputs the first input minus the second, clamped at zero")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        scene.effects().indicateRedstone(leverA);
        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("With only the first input powered, the full signal passes through")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);

        scene.effects().indicateRedstone(leverB);
        scene.world().toggleRedstonePower(util.select().position(leverB));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_B);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Power the second input to subtract from the first and silence the output")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(100);

        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.idle(15);
        scene.overlay().showText(90)
                .text("Subtracting from nothing also yields nothing, the output stays at zero")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);
    }
}

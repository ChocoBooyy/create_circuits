package dev.chocoboy.create_circuits.infrastructure.ponder.scenes;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public final class LogicScenes {

    private LogicScenes() {}

    public static void andGate(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("and", "Combining signals with the AND gate");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(10);

        BlockPos gatePos = util.grid().at(2, 1, 2);
        BlockPos leftInput = util.grid().at(2, 1, 1);
        BlockPos rightInput = util.grid().at(2, 1, 3);

        scene.overlay().showText(70)
                .attachKeyFrame()
                .text("The AND gate outputs a signal only when both inputs are powered")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(80);

        scene.effects().indicateRedstone(leftInput);
        scene.world().toggleRedstonePower(util.select().position(leftInput));
        scene.idle(20);

        scene.overlay().showText(60)
                .text("One input alone is not enough")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(70);

        scene.effects().indicateRedstone(rightInput);
        scene.world().toggleRedstonePower(util.select().position(rightInput));
        scene.idle(20);

        scene.overlay().showText(70)
                .text("Both inputs powered: the gate fires")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(80);
    }
}

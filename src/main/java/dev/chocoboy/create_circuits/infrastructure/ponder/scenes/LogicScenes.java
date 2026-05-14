package dev.chocoboy.create_circuits.infrastructure.ponder.scenes;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
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

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos lampPos = util.grid().at(3, 1, 2);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(80)
                .attachKeyFrame()
                .text("The AND gate combines two redstone inputs into a single output")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(90);

        scene.effects().indicateRedstone(leverA);
        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.idle(15);
        scene.overlay().showText(80)
                .attachKeyFrame()
                .text("One input alone is not enough, the gate stays dark")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(90);

        scene.effects().indicateRedstone(leverB);
        scene.world().toggleRedstonePower(util.select().position(leverB));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_B);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("With both inputs powered the gate fires and lights up the lamp")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(110);

        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(80)
                .text("Cut a single input and the output goes quiet again")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(90);
    }
}

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

    public static void nandGate(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("nand", "Inverting AND with the NAND gate");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos lampPos = util.grid().at(3, 1, 2);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("The NAND gate inverts AND: it stays lit while at least one input is missing")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);

        scene.effects().indicateRedstone(leverA);
        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.idle(15);
        scene.overlay().showText(80)
                .attachKeyFrame()
                .text("One powered input alone is not enough to flip the output")
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
                .text("Only when both inputs are powered does the gate fall silent and the lamp go dark")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(110);

        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(80)
                .text("Drop a single input and the inverted output lights up again")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(90);
    }

    public static void norGate(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("nor", "Inverting OR with the NOR gate");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos lampPos = util.grid().at(3, 1, 2);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("The NOR gate fires only when neither input is powered")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);

        scene.effects().indicateRedstone(leverA);
        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("A single powered input is enough to silence the output")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);

        scene.effects().indicateRedstone(leverB);
        scene.world().toggleRedstonePower(util.select().position(leverB));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_B);
        scene.idle(15);
        scene.overlay().showText(80)
                .attachKeyFrame()
                .text("Powering the second input keeps the output dark")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(90);

        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().position(leverB));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_B);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(80)
                .text("Cut both inputs and the gate fires again")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(90);
    }

    public static void orGate(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("or", "Combining signals with the OR gate");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos lampPos = util.grid().at(3, 1, 2);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("The OR gate fires whenever at least one input is powered")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(100);

        scene.effects().indicateRedstone(leverA);
        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(80)
                .attachKeyFrame()
                .text("Powering a single input is already enough to light the lamp")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(90);

        scene.effects().indicateRedstone(leverB);
        scene.world().toggleRedstonePower(util.select().position(leverB));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_B);
        scene.idle(15);
        scene.overlay().showText(80)
                .attachKeyFrame()
                .text("Powering both inputs keeps the output high")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(90);

        scene.world().toggleRedstonePower(util.select().position(leverA));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_A);
        scene.world().toggleRedstonePower(util.select().position(leverB));
        scene.world().cycleBlockProperty(gatePos, AbstractSignalBlock.INPUT_B);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.idle(15);
        scene.overlay().showText(80)
                .text("Only when every input drops does the gate fall silent")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(90);
    }
}

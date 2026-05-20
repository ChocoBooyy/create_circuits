package dev.chocoboy.create_circuits.infrastructure.ponder.scenes;

import com.simibubi.create.content.redstone.analogLever.AnalogLeverBlockEntity;
import com.simibubi.create.content.redstone.nixieTube.NixieTubeBlockEntity;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import dev.chocoboy.create_circuits.content.blocks.base.AbstractSignalBlock;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RedStoneWireBlock;

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
        BlockPos wirePos = util.grid().at(2, 1, 2);
        BlockPos nixiePos = util.grid().at(3, 1, 2);

        Selection leverASel = util.select().position(leverA);
        Selection leverBSel = util.select().position(leverB);
        Selection nixieSel = util.select().position(nixiePos);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("The Subtractor returns the first input minus the second, clamped at zero")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 15, 0, 15);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Set the first input to 15 and nothing on the second: the full signal passes")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 15, 7, 8);
        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("Raise the second input to 7 and the output drops to 15 minus 7, or 8")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(110);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 9, 9, 0);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Match the two inputs and the output is exactly zero")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 4, 12, 0);
        scene.overlay().showText(100)
                .text("If the second input is larger, the result is clamped at zero rather than going negative")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(110);
    }

    public static void adder(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("adder", "Adding redstone with the Adder");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos wirePos = util.grid().at(2, 1, 2);
        BlockPos nixiePos = util.grid().at(3, 1, 2);

        Selection leverASel = util.select().position(leverA);
        Selection leverBSel = util.select().position(leverB);
        Selection nixieSel = util.select().position(nixiePos);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("The Adder returns the sum of its two inputs, capped at 15")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 3, 4, 7);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Set the inputs to 3 and 4 and the output reads exactly 7")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 8, 6, 14);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Crank both inputs up and the result climbs with them")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 12, 9, 15);
        scene.overlay().showText(100)
                .text("If the sum would exceed 15, the output stays capped at 15")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(110);
    }

    public static void multiplier(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("multiplier", "Multiplying redstone with the Multiplier");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos wirePos = util.grid().at(2, 1, 2);
        BlockPos nixiePos = util.grid().at(3, 1, 2);

        Selection leverASel = util.select().position(leverA);
        Selection leverBSel = util.select().position(leverB);
        Selection nixieSel = util.select().position(nixiePos);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("The Multiplier returns the product of its two inputs, capped at 15")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 1, 5, 5);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("With one input at 1 the output mirrors the other input")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 3, 4, 12);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("3 times 4 reads 12 on the output")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 5, 5, 15);
        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("5 times 5 would be 25, but the output clamps to 15")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(110);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 0, 12, 0);
        scene.overlay().showText(90)
                .text("Anything multiplied by zero falls back to zero")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);
    }

    public static void max(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("max", "Picking the larger signal with Max");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos leverA = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos leverB = util.grid().at(1, 1, 3);
        BlockPos wirePos = util.grid().at(2, 1, 2);
        BlockPos nixiePos = util.grid().at(3, 1, 2);

        Selection leverASel = util.select().position(leverA);
        Selection leverBSel = util.select().position(leverB);
        Selection nixieSel = util.select().position(nixiePos);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("Max forwards whichever of its two inputs is larger")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 7, 3, 7);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Inputs of 7 and 3 produce 7 on the output")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 5, 11, 11);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Raise the second input above the first and the output follows it")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);

        applyStep(scene, leverASel, leverA, leverBSel, leverB, gatePos, wirePos, nixieSel, 8, 8, 8);
        scene.overlay().showText(90)
                .text("With both inputs equal, the gate reports that same value")
                .placeNearTarget()
                .pointAt(util.vector().topOf(nixiePos));
        scene.idle(100);
    }

    private static void applyStep(CreateSceneBuilder scene, Selection leverASel, BlockPos leverA,
                                  Selection leverBSel, BlockPos leverB, BlockPos gatePos,
                                  BlockPos wirePos, Selection nixieSel, int a, int b, int output) {
        scene.effects().indicateRedstone(leverA);
        scene.effects().indicateRedstone(leverB);
        scene.world().modifyBlockEntityNBT(leverASel, AnalogLeverBlockEntity.class,
                nbt -> nbt.putInt("State", a));
        scene.world().modifyBlockEntityNBT(leverBSel, AnalogLeverBlockEntity.class,
                nbt -> nbt.putInt("State", b));
        scene.world().modifyBlock(gatePos, s -> s
                .setValue(AbstractSignalBlock.INPUT_A, a > 0)
                .setValue(AbstractSignalBlock.INPUT_B, b > 0), false);
        scene.world().modifyBlock(wirePos, s -> s.setValue(RedStoneWireBlock.POWER, output), false);
        scene.world().modifyBlockEntityNBT(nixieSel, NixieTubeBlockEntity.class,
                nbt -> nbt.putInt("RedstoneStrength", output));
        scene.idle(15);
    }
}

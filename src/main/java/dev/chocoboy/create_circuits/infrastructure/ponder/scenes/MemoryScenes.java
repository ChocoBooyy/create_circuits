package dev.chocoboy.create_circuits.infrastructure.ponder.scenes;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import dev.chocoboy.create_circuits.content.blocks.memory.latch.SRLatchBlock;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RedstoneLampBlock;

public final class MemoryScenes {

    private MemoryScenes() {}

    public static void srLatch(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("sr_latch", "Storing a bit with the SR Latch");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();
        scene.idle(5);

        BlockPos setLever = util.grid().at(1, 1, 1);
        BlockPos gatePos = util.grid().at(1, 1, 2);
        BlockPos resetLever = util.grid().at(1, 1, 3);
        BlockPos lampPos = util.grid().at(3, 1, 2);

        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("The SR Latch remembers a single bit, driven by a Set and a Reset input")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        // Pulse Set: Q -> 1
        scene.effects().indicateRedstone(setLever);
        scene.world().toggleRedstonePower(util.select().position(setLever));
        scene.world().modifyBlock(gatePos, s -> s
                .setValue(SRLatchBlock.INPUT_A, true)
                .setValue(SRLatchBlock.ACTIVE, true), false);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.world().modifyBlock(lampPos, s -> s.setValue(RedstoneLampBlock.LIT, true), false);
        scene.idle(15);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Powering the Set input drives the stored bit high")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);

        // Release Set: Q stays 1
        scene.world().toggleRedstonePower(util.select().position(setLever));
        scene.world().modifyBlock(gatePos, s -> s.setValue(SRLatchBlock.INPUT_A, false), false);
        scene.idle(15);
        scene.overlay().showText(100)
                .attachKeyFrame()
                .text("Releasing Set keeps the bit at one: the latch remembers")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);

        // Pulse Reset: Q -> 0
        scene.effects().indicateRedstone(resetLever);
        scene.world().toggleRedstonePower(util.select().position(resetLever));
        scene.world().modifyBlock(gatePos, s -> s
                .setValue(SRLatchBlock.INPUT_B, true)
                .setValue(SRLatchBlock.ACTIVE, false), false);
        scene.world().toggleRedstonePower(util.select().fromTo(2, 1, 2, 3, 1, 2));
        scene.world().modifyBlock(lampPos, s -> s.setValue(RedstoneLampBlock.LIT, false), false);
        scene.idle(15);
        scene.overlay().showText(90)
                .attachKeyFrame()
                .text("Powering Reset drops the stored bit back to zero")
                .placeNearTarget()
                .pointAt(util.vector().topOf(lampPos));
        scene.idle(100);

        // Release Reset: Q stays 0
        scene.world().toggleRedstonePower(util.select().position(resetLever));
        scene.world().modifyBlock(gatePos, s -> s.setValue(SRLatchBlock.INPUT_B, false), false);
        scene.idle(15);
        scene.overlay().showText(100)
                .text("Releasing Reset holds the bit at zero, mirroring the behaviour of Set")
                .placeNearTarget()
                .pointAt(util.vector().topOf(gatePos));
        scene.idle(110);
    }
}

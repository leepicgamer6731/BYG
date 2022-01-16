package potionstudios.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class MiniRedMushroom extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public MiniRedMushroom(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 2 + rand.nextInt(2);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.WAILING_NYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 1));
            }
        }
        return true;
    }
}
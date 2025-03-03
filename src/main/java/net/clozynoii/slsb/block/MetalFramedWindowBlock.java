
package net.clozynoii.slsb.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class MetalFramedWindowBlock extends IronBarsBlock {
	public MetalFramedWindowBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.2f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}

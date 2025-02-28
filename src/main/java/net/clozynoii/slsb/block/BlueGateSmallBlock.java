
package net.clozynoii.slsb.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.clozynoii.slsb.init.SlsbModBlockEntities;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Collections;

import com.mojang.serialization.MapCodec;

public class BlueGateSmallBlock extends BaseEntityBlock implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
	public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, (int) 1);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final MapCodec<BlueGateSmallBlock> CODEC = simpleCodec(properties -> new BlueGateSmallBlock());

	public MapCodec<BlueGateSmallBlock> codec() {
		return CODEC;
	}

	public BlueGateSmallBlock() {
		super(BlockBehaviour.Properties.of()

				.sound(SoundType.GLASS).strength(-1, 3600000).lightLevel(s -> (new Object() {
					public int getLightLevel() {
						if (s.getValue(BLOCKSTATE) == 1)
							return 0;
						return 14;
					}
				}.getLightLevel())).noCollission().noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return SlsbModBlockEntities.BLUE_GATE_SMALL.get().create(blockPos, blockState);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {

			return switch (state.getValue(FACING)) {
				default -> box(-24, 0, 4, 40, 64, 12);
				case NORTH -> box(-24, 0, 4, 40, 64, 12);
				case EAST -> box(4, 0, -24, 12, 64, 40);
				case WEST -> box(4, 0, -24, 12, 64, 40);
			};
		}

		return switch (state.getValue(FACING)) {
			default -> box(-24, 0, 4, 40, 64, 12);
			case NORTH -> box(-24, 0, 4, 40, 64, 12);
			case EAST -> box(4, 0, -24, 12, 64, 40);
			case WEST -> box(4, 0, -24, 12, 64, 40);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ANIMATION, FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}

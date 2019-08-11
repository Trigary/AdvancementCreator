package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.BlockObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a hitbox intersects with a block, including air, as well as the block the an ender pearl had landed at. This trigger fires constantly.
 */
public class EnterBlockTrigger extends Trigger {
	private BlockObject block;
	
	public EnterBlockTrigger() {
		super(Type.ENTER_BLOCK);
	}
	
	
	
	/**
	 * @return information about the block the player is intersecting with or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public BlockObject getBlock() {
		return block;
	}
	
	/**
	 * @param block information about the block the player is intersecting with or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public EnterBlockTrigger setBlock(@Nullable BlockObject block) {
		this.block = block;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return block == null ? new JsonObject() : block.toJson();
	}
}

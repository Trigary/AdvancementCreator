package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.BlockObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.shared.LocationObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player places a block.
 */
public class PlacedBlockTrigger extends Trigger {
	private BlockObject block;
	private ItemObject item;
	private LocationObject location;
	
	public PlacedBlockTrigger() {
		super(Type.PLACED_BLOCK);
	}
	
	
	
	/**
	 * @return information about the newly placed block or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public BlockObject getBlock() {
		return block;
	}
	
	/**
	 * @return information about the item which was used to create the block or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getItem() {
		return item;
	}
	
	/**
	 * @return information about the location where the block was placed or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public LocationObject getLocation() {
		return location;
	}
	
	
	
	/**
	 * @param block information about the newly placed block or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public PlacedBlockTrigger setBlock(@Nullable BlockObject block) {
		this.block = block;
		return this;
	}
	
	/**
	 * @param location information about the item which was used to create the block or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public PlacedBlockTrigger setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	/**
	 * @param item information about the location where the block was placed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public PlacedBlockTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return (block == null ? new JsonBuilder() : new JsonBuilder(block.toJson()))
				.add("item", item)
				.add("location", location)
				.build();
	}
}

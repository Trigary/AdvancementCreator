package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.BlockObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.shared.LocationObject;

/**
 * Fires whenever the player places a block.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class PlacedBlockTrigger extends Trigger {
	private @Nullable BlockObject block = null;
	private @Nullable ItemObject item = null;
	private @Nullable LocationObject location = null;
	
	public PlacedBlockTrigger() {
		super(Type.PLACED_BLOCK);
	}
	
	
	
	/**
	 * @return information about the newly placed block or null, if none was specified
	 */
	public @Nullable BlockObject getBlock() {
		return block;
	}
	
	/**
	 * @return information about the item which was used to create the block or null, if none was specified
	 */
	public @Nullable ItemObject getItem() {
		return item;
	}
	
	/**
	 * @return information about the location where the block was placed or null, if none was specified
	 */
	public @Nullable LocationObject getLocation() {
		return location;
	}
	
	
	
	/**
	 * @param block information about the newly placed block or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public PlacedBlockTrigger setBlock(@Nullable BlockObject block) {
		this.block = block;
		return this;
	}
	
	/**
	 * @param location information about the item which was used to create the block or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public PlacedBlockTrigger setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	/**
	 * @param item information about the location where the block was placed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public PlacedBlockTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		JsonObject json = block == null ? new JsonObject() : block.toJson();
		if (item != null) {
			json.add("item", item.toJson());
		}
		if (location != null) {
			json.add("location", location.toJson());
		}
		return json;
	}
}

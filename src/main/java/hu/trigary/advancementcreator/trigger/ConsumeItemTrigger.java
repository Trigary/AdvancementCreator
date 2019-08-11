package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player eats food, drinks milk or a potion/water bottle.
 */
public class ConsumeItemTrigger extends Trigger {
	private ItemObject item;
	
	public ConsumeItemTrigger() {
		super(Type.CONSUME_ITEM);
	}
	
	
	
	/**
	 * @return information about the item before it was consumed or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getItem() {
		return item;
	}
	
	/**
	 * @param item information about the item before it was consumed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ConsumeItemTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("item", item)
				.build();
	}
}

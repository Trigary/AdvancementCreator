package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever the player uses a Totem of Undying.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class UsedTotemTrigger extends Trigger {
	private @Nullable ItemObject item = null;
	
	public UsedTotemTrigger() {
		super(Type.USED_TOTEM);
	}
	
	
	
	/**
	 * @return information about the item before it was consumed or null, if none was specified
	 */
	public @Nullable ItemObject getItem() {
		return item;
	}
	
	/**
	 * @param item information about the item before it was consumed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public UsedTotemTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return item == null ? null : new JsonBuilder()
				.add("item", item)
				.build();
	}
}

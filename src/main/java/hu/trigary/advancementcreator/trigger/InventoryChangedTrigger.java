package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.shared.RangeObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Fires whenever items are added to or removed from the player's inventory.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class InventoryChangedTrigger extends Trigger {
	private @Nullable RangeObject occupied = null;
	private @Nullable RangeObject full = null;
	private @Nullable RangeObject empty = null;
	private @Nullable Set<ItemObject> items = null;
	
	public InventoryChangedTrigger() {
		super(Type.INVENTORY_CHANGED);
	}
	
	
	
	/**
	 * @return the amount of slots which have items in them or null, if none was specified
	 */
	public @Nullable RangeObject getOccupied() {
		return occupied;
	}
	
	/**
	 * @return the amount of slots which have full stacks of items in them or null, if none was specified
	 */
	public @Nullable RangeObject getFull() {
		return full;
	}
	
	/**
	 * @return the amount of slots which have no items in them or null, if none was specified
	 */
	public @Nullable RangeObject getEmpty() {
		return empty;
	}
	
	/**
	 * @return items which the inventory contains
	 */
	public Set<ItemObject> getItems() {
		return items == null ? Collections.emptySet() : Collections.unmodifiableSet(items);
	}
	
	
	
	/**
	 * @param occupied the amount of slots which have items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public InventoryChangedTrigger setOccupied(@Nullable RangeObject occupied) {
		this.occupied = occupied;
		return this;
	}
	
	/**
	 * @param full the amount of slots which have full stacks of items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public InventoryChangedTrigger setFull(@Nullable RangeObject full) {
		this.full = full;
		return this;
	}
	
	/**
	 * @param empty the amount of slots which have no items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public InventoryChangedTrigger setEmpty(@Nullable RangeObject empty) {
		this.empty = empty;
		return this;
	}
	
	/**
	 * @param item the item to add to the list of items which the inventory contains
	 * @return the current trigger for chaining
	 */
	public InventoryChangedTrigger addItem(ItemObject item) {
		Validate.notNull(item);
		if (items == null) {
			items = new HashSet<>();
		}
		items.add(item);
		return this;
	}
	
	/**
	 * @param item the item to removed from the list of items which the inventory contains
	 * @return the current trigger for chaining
	 */
	public InventoryChangedTrigger removeItem(ItemObject item) {
		Validate.notNull(item);
		if (items != null) {
			items.remove(item);
		}
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		if (occupied == null && full == null && empty == null && (items == null || items.isEmpty())) {
			return null;
		}
		JsonObject json = new JsonObject();
		if (occupied != null || full != null || empty != null) {
			json.add("slots", new JsonBuilder()
					.add("occupied", occupied)
					.add("full", full)
					.add("empty", empty)
					.build());
		}
		if (items != null && !items.isEmpty()) {
			JsonArray items = new JsonArray();
			for (ItemObject item : this.items) {
				items.add(item.toJson());
			}
			json.add("items", items);
		}
		return json;
	}
}

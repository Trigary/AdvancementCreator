package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.shared.RangeObject;
import hu.trigary.advancementcreator.shared.SharedObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Fires whenever items are added to or removed from the player's inventory.
 */
public class InventoryChangedTrigger extends Trigger {
	private RangeObject occupied;
	private RangeObject full;
	private RangeObject empty;
	private Set<ItemObject> items;
	
	public InventoryChangedTrigger() {
		super(Type.INVENTORY_CHANGED);
	}
	
	
	
	/**
	 * @return the amount of slots which have items in them or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getOccupied() {
		return occupied;
	}
	
	/**
	 * @return the amount of slots which have full stacks of items in them or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getFull() {
		return full;
	}
	
	/**
	 * @return the amount of slots which have no items in them or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getEmpty() {
		return empty;
	}
	
	/**
	 * @return items which the inventory contains
	 */
	@NotNull
	@Contract(pure = true)
	public Set<ItemObject> getItems() {
		return items == null ? Collections.emptySet() : Collections.unmodifiableSet(items);
	}
	
	
	
	/**
	 * @param occupied the amount of slots which have items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public InventoryChangedTrigger setOccupied(@Nullable RangeObject occupied) {
		this.occupied = occupied;
		return this;
	}
	
	/**
	 * @param full the amount of slots which have full stacks of items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public InventoryChangedTrigger setFull(@Nullable RangeObject full) {
		this.full = full;
		return this;
	}
	
	/**
	 * @param empty the amount of slots which have no items in them or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public InventoryChangedTrigger setEmpty(@Nullable RangeObject empty) {
		this.empty = empty;
		return this;
	}
	
	/**
	 * @param item the item to add to the list of items which the inventory contains
	 * @return the current trigger for chaining
	 */
	@NotNull
	public InventoryChangedTrigger addItem(@NotNull ItemObject item) {
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
	@NotNull
	public InventoryChangedTrigger removeItem(@NotNull ItemObject item) {
		Validate.notNull(item);
		if (items != null) {
			items.remove(item);
		}
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		JsonBuilder json = new JsonBuilder();
		if (occupied != null || full != null || empty != null) {
			json.add("slots", new JsonBuilder()
					.add("occupied", occupied)
					.add("full", full)
					.add("empty", empty)
					.build());
		}
		
		return json.add("items", items, SharedObject::toJson)
				.build();
	}
}

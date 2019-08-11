package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.shared.RangeObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever any item's durability in the player's inventory changes.
 */
public class ItemDurabilityChangedTrigger extends Trigger {
	private ItemObject item;
	private RangeObject durability;
	private RangeObject delta;
	
	public ItemDurabilityChangedTrigger() {
		super(Type.ITEM_DURABILITY_CHANGED);
	}
	
	
	
	/**
	 * @return the item which's durability changed or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getItem() {
		return item;
	}
	
	/**
	 * @return the durability or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getDurability() {
		return durability;
	}
	
	/**
	 * @return the durability change or null, if none was specified. The durability change is calculated by {@code new - old}
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getDelta() {
		return delta;
	}
	
	
	
	/**
	 * @param item the item which's durability changed or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ItemDurabilityChangedTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	/**
	 * @param durability the new durability or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ItemDurabilityChangedTrigger setDurability(@Nullable RangeObject durability) {
		this.durability = durability;
		return this;
	}
	
	/**
	 * @param delta the durability change or null, if it should be cleared. The durability change is calculated by {@code new - old}
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ItemDurabilityChangedTrigger setDelta(@Nullable RangeObject delta) {
		this.delta = delta;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("item", item)
				.add("durability", durability)
				.add("delta", delta)
				.build();
	}
}

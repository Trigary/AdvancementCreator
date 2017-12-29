package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever the player completes a trade with a villager.
 * Shift clicking, therefore possibly completing the trade multiple times will only fire this trigger once.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class VillagerTradeTrigger extends Trigger {
	private @Nullable EntityObject villager = null;
	private @Nullable ItemObject item = null;
	
	public VillagerTradeTrigger() {
		super(Type.VILLAGER_TRADE);
	}
	
	
	
	/**
	 * @return information about the villager the player traded with or null, if none was specified
	 */
	public @Nullable EntityObject getVillager() {
		return villager;
	}
	
	/**
	 * @return the item the player had purchased. The count is the same for a shift click as for a normal click
	 */
	public @Nullable ItemObject getItem() {
		return item;
	}
	
	
	
	/**
	 * @param villager information about the villager the player traded with or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public VillagerTradeTrigger setVillager(@Nullable EntityObject villager) {
		this.villager = villager;
		return this;
	}
	
	/**
	 * @param item the item the player had purchased or null, if it should be cleared. The count is the same for a shift click as for a normal click
	 * @return the current trigger for chaining
	 */
	public VillagerTradeTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return villager == null && item == null ? null : new JsonBuilder()
				.add("villager", villager)
				.add("item", item)
				.build();
	}
}

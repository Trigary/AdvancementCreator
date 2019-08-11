package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player completes a trade with a villager.
 * Shift clicking, therefore possibly completing the trade multiple times will only fire this trigger once.
 */
public class VillagerTradeTrigger extends Trigger {
	private EntityObject villager;
	private ItemObject item;
	
	public VillagerTradeTrigger() {
		super(Type.VILLAGER_TRADE);
	}
	
	
	
	/**
	 * @return information about the villager the player traded with or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getVillager() {
		return villager;
	}
	
	/**
	 * @return the item the player had purchased. The count is the same for a shift click as for a normal click
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getItem() {
		return item;
	}
	
	
	
	/**
	 * @param villager information about the villager the player traded with or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public VillagerTradeTrigger setVillager(@Nullable EntityObject villager) {
		this.villager = villager;
		return this;
	}
	
	/**
	 * @param item the item the player had purchased or null, if it should be cleared. The count is the same for a shift click as for a normal click
	 * @return the current trigger for chaining
	 */
	@NotNull
	public VillagerTradeTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("villager", villager)
				.add("item", item)
				.build();
	}
}

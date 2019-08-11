package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player reels back a fishing rod when it was either attached
 * to another entity or when successfully fishing up an item.
 */
public class FishingRodHookedTrigger extends Trigger {
	private ItemObject rod;
	private EntityObject entity;
	private ItemObject item;
	
	public FishingRodHookedTrigger() {
		super(Type.FISHING_ROD_HOOKED);
	}
	
	
	
	/**
	 * @return the fishing rod used by the player or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getRod() {
		return rod;
	}
	
	/**
	 * @return the hooked entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getEntity() {
		return entity;
	}
	
	/**
	 * @return the fished up item or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getItem() {
		return item;
	}
	
	
	
	/**
	 * @param rod the fishing rod used by the player or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public FishingRodHookedTrigger setRod(@Nullable ItemObject rod) {
		this.rod = rod;
		return this;
	}
	
	/**
	 * @param entity the hooked entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public FishingRodHookedTrigger setEntity(@Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	/**
	 * @param item the fished up item or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public FishingRodHookedTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("rod", rod)
				.add("entity", entity)
				.add("item", item)
				.build();
	}
}

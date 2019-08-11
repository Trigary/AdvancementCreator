package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player fires a crossbow.
 */
public class ShotCrossbowTrigger extends Trigger {
	private ItemObject item;
	
	public ShotCrossbowTrigger() {
		super(Type.SHOT_CROSSBOW);
	}
	
	
	
	/**
	 * @return the crossbow before the projectile was fired or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getItem() {
		return item;
	}
	
	/**
	 * @param item the crossbow before the projectile was fired or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ShotCrossbowTrigger setItem(@Nullable ItemObject item) {
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

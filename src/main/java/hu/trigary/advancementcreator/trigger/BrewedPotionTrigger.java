package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.Potion;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever any (!) item is taken out of the output of a brewing stand.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class BrewedPotionTrigger extends Trigger {
	private @Nullable Potion potion = null;
	
	public BrewedPotionTrigger() {
		super(Type.BREWED_POTION);
	}
	
	
	
	/**
	 * @return the taken out item's potion identifier or null, if none was specified. If the item is not a potion, it's id is {@link Potion#EMPTY}
	 */
	public @Nullable Potion getPotion() {
		return potion;
	}
	
	/**
	 * @param potion the taken out item's potion identifier or null, if it should be cleared. If the item is not a potion, it's id is {@link Potion#EMPTY}
	 * @return the current trigger for chaining
	 */
	public BrewedPotionTrigger setPotion(@Nullable Potion potion) {
		this.potion = potion;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return potion == null ? null : new JsonBuilder()
				.add("potion", potion)
				.build();
	}
}

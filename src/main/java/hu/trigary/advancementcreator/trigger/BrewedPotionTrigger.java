package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.Potion;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever any (!) item is taken out of the output of a brewing stand.
 */
public class BrewedPotionTrigger extends Trigger {
	private Potion potion;
	
	public BrewedPotionTrigger() {
		super(Type.BREWED_POTION);
	}
	
	
	
	/**
	 * @return the taken out item's potion identifier or null, if none was specified. If the item is not a potion, it's id is {@link Potion#EMPTY}
	 */
	@Nullable
	@Contract(pure = true)
	public Potion getPotion() {
		return potion;
	}
	
	/**
	 * @param potion the taken out item's potion identifier or null, if it should be cleared. If the item is not a potion, it's id is {@link Potion#EMPTY}
	 * @return the current trigger for chaining
	 */
	@NotNull
	public BrewedPotionTrigger setPotion(@Nullable Potion potion) {
		this.potion = potion;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("potion", potion)
				.build();
	}
}

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Fires whenever the player unlocks a recipe. The trigger is invalid without the {@code recipe} property, therefore it must be assigned in the constructor.
 */
public class RecipeUnlockedTrigger extends Trigger {
	private final NamespacedKey recipe;
	
	/**
	 * @param recipe the recipe which must be unlocked
	 */
	public RecipeUnlockedTrigger(@NotNull NamespacedKey recipe) {
		super(Type.RECIPE_UNLOCKED);
		Validate.notNull(recipe);
		this.recipe = recipe;
	}
	
	
	
	/**
	 * @return the recipe's id which must be unlocked
	 */
	@NotNull
	@Contract(pure = true)
	public NamespacedKey getRecipe() {
		return recipe;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("recipe", recipe)
				.build();
	}
}

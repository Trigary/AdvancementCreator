package hu.trigary.advancementcreator;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Specifies rewards which are given when the advancement is completed.
 */
public class Rewards {
	private Set<NamespacedKey> recipes;
	private Set<NamespacedKey> loots;
	private int experience = 0;
	private NamespacedKey function;
	
	
	
	/**
	 * @return the id of the recipes which will unlock upon completion of the advancement
	 */
	@NotNull
	@Contract(pure = true)
	public Set<NamespacedKey> getRecipes() {
		return recipes == null ? Collections.emptySet() : Collections.unmodifiableSet(recipes);
	}
	
	/**
	 * @return the id of the loot tables from all of which items will be given upon completion of the advancement
	 */
	@NotNull
	@Contract(pure = true)
	public Set<NamespacedKey> getLoots() {
		return loots == null ? Collections.emptySet() : Collections.unmodifiableSet(loots);
	}
	
	/**
	 * @return the amount of experience which will be given upon completion of the advancement
	 */
	@Contract(pure = true)
	public int getExperience() {
		return experience;
	}
	
	/**
	 * @return the id of the function which will run upon completion of the advancement
	 */
	@Nullable
	@Contract(pure = true)
	public NamespacedKey getFunction() {
		return function;
	}
	
	
	
	/**
	 * @param recipe the id of the recipe which should be unlocked upon completion of the advancement
	 * @return the current rewards object for chaining
	 */
	@NotNull
	public Rewards addRecipe(@NotNull NamespacedKey recipe) {
		Validate.notNull(recipe);
		if (recipes == null) {
			recipes = new HashSet<>();
		}
		recipes.add(recipe);
		return this;
	}
	
	/**
	 * @param recipe the id of the recipe which should be removed from the reward recipes
	 * @return the current rewards object for chaining
	 */
	@NotNull
	public Rewards removeRecipe(@NotNull NamespacedKey recipe) {
		Validate.notNull(recipe);
		if (recipes != null) {
			recipes.remove(recipe);
		}
		return this;
	}
	
	/**
	 * @param loot the id of the loot table from which items should also be given
	 * @return the current rewards object for chaining
	 */
	@NotNull
	public Rewards addLoot(@NotNull NamespacedKey loot) {
		Validate.notNull(loot);
		if (loots == null) {
			loots = new HashSet<>();
		}
		loots.add(loot);
		return this;
	}
	
	/**
	 * @param loot the id of the loot table which should be removed from the reward loot tables
	 * @return the current rewards object for chaining
	 */
	@NotNull
	public Rewards removeLoot(@NotNull NamespacedKey loot) {
		Validate.notNull(loot);
		if (loots != null) {
			loots.remove(loot);
		}
		return this;
	}
	
	/**
	 * @param experience the amount of experience which should be given upon completion of the advancement
	 * @return the current rewards object for chaining
	 */
	@NotNull
	public Rewards setExperience(int experience) {
		Validator.zeroToDisable(experience);
		this.experience = experience;
		return this;
	}
	
	/**
	 * @param function the id of the function which should be run upon completion of the advancement or null, if it should be cleared
	 * The player will be considered the sender - {@code @s} will point to the player
	 * @return the current rewards object for chaining
	 */
	@NotNull
	public Rewards setFunction(@Nullable NamespacedKey function) {
		this.function = function;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the reward object
	 */
	@NotNull
	@Contract(pure = true)
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("recipes", recipes, v -> new JsonPrimitive(v.toString()))
				.add("loot", loots, v -> new JsonPrimitive(v.toString()))
				.addPositive("experience", experience)
				.add("function", function)
				.build();
	}
	
	
	
	/**
	 * @return the hash code of this rewards object
	 */
	@Contract(pure = true)
	@Override
	public int hashCode() {
		return Objects.hash(recipes, loots, experience, function);
	}
	
	/**
	 * @param object the reference object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Contract(pure = true, value = "null -> false")
	@Override
	public boolean equals(@Nullable Object object) {
		if (!(object instanceof Rewards)) {
			return false;
		}
		
		Rewards other = (Rewards) object;
		return Objects.equals(other.recipes, recipes) && Objects.equals(other.loots, loots) &&
				Objects.equals(other.experience, experience) && Objects.equals(other.function, function);
	}
}

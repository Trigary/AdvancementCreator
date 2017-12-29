package hu.trigary.advancementcreator;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Specifies rewards which are given when the advancement is completed.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class Rewards {
	private static final Type NAMESPACED_KEY_SET_TYPE = new TypeToken<Set<NamespacedKey>>() {}.getType();
	private @Nullable Set<NamespacedKey> recipes = null;
	private @Nullable Set<NamespacedKey> loots = null;
	private int experience = 0;
	private @Nullable NamespacedKey function = null;
	
	
	
	/**
	 * @return the id of the recipes which will unlock upon completion of the advancement
	 */
	public Set<NamespacedKey> getRecipes() {
		return recipes == null ? Collections.emptySet() : Collections.unmodifiableSet(recipes);
	}
	
	/**
	 * @return the id of the loot tables from all of which items will be given upon completion of the advancement
	 */
	public Set<NamespacedKey> getLoots() {
		return loots == null ? Collections.emptySet() : Collections.unmodifiableSet(loots);
	}
	
	/**
	 * @return the amount of experience which will be given upon completion of the advancement
	 */
	public int getExperience() {
		return experience;
	}
	
	/**
	 * @return the id of the function which will run upon completion of the advancement
	 */
	public @Nullable NamespacedKey getFunction() {
		return function;
	}
	
	
	
	/**
	 * @param recipe the id of the recipe which should be unlocked upon completion of the advancement
	 * @return the current rewards object for chaining
	 */
	public Rewards addRecipe(NamespacedKey recipe) {
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
	public Rewards removeRecipe(NamespacedKey recipe) {
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
	public Rewards addLoot(NamespacedKey loot) {
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
	public Rewards removeLoot(NamespacedKey loot) {
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
	public Rewards setFunction(@Nullable NamespacedKey function) {
		this.function = function;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the reward object
	 */
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("recipes", recipes, NAMESPACED_KEY_SET_TYPE)
				.add("loot", loots, NAMESPACED_KEY_SET_TYPE)
				.addPositive("experience", experience)
				.add("function", function)
				.build();
	}
	
	
	
	/**
	 * @return the hash code of this rewards object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(recipes, loots, experience, function);
	}
	
	/**
	 * @param object the reference object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Rewards)) {
			return false;
		}
		
		Rewards rew = (Rewards)object;
		return Objects.equals(rew.recipes, recipes) && Objects.equals(rew.loots, loots) &&
				Objects.equals(rew.experience, experience) && Objects.equals(rew.function, function);
	}
}

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.SharedEnum;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * A trigger of an advancement. Each advancement must have at least one trigger.
 * All triggers must completed the requirements are explicitly specified using {@link hu.trigary.advancementcreator.Advancement#addRequirement(String...)}
 */
public abstract class Trigger {
	private final Type type;
	
	/**
	 * @param type the of the trigger
	 */
	protected Trigger(@NotNull Type type) {
		Validate.notNull(type);
		this.type = type;
	}
	
	
	
	/**
	 * @return the type of the trigger
	 */
	@NotNull
	@Contract(pure = true)
	public Type getType() {
		return type;
	}
	
	/**
	 * @return a JSON representation of the trigger
	 */
	@NotNull
	@Contract(pure = true)
	public final JsonObject toJson() {
		return new JsonBuilder()
				.add("trigger", type.getValue())
				.add("conditions", getConditions())
				.build();
	}
	
	/**
	 * @return a JSON representation of the conditions of the trigger
	 */
	@NotNull
	@Contract(pure = true)
	protected abstract JsonObject getConditions();
	
	
	
	/**
	 * This method should be used wisely, since it calls {@link #getConditions()}
	 *
	 * @return the hash code of this trigger
	 */
	@Override
	@Contract(pure = true)
	public int hashCode() {
		return Objects.hash(type, getConditions());
	}
	
	/**
	 * This method should be used wisely, since it calls {@link #getConditions()}
	 *
	 * @param object the reference object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Override
	@Contract(pure = true, value = "null -> false")
	public boolean equals(@Nullable Object object) {
		if (!(object instanceof Trigger)) {
			return false;
		}
		
		Trigger trigger = (Trigger) object;
		return trigger.type == type && Objects.equals(trigger.getConditions(), getConditions());
	}
	
	
	
	/**
	 * The type of trigger, this determines which event the trigger listens to.
	 */
	public enum Type implements SharedEnum {
		BRED_ANIMALS,
		BREWED_POTION,
		CHANGED_DIMENSION,
		CHANNELED_LIGHTNING,
		CONSTRUCT_BEACON,
		CONSUME_ITEM,
		CURED_ZOMBIE_VILLAGER,
		EFFECTS_CHANGED,
		ENCHANTED_ITEM,
		ENTER_BLOCK,
		ENTITY_HURT_PLAYER,
		ENTITY_KILLED_PLAYER,
		FILLED_BUCKET,
		FISHING_ROD_HOOKED,
		HERO_OF_THE_VILLAGE,
		IMPOSSIBLE,
		INVENTORY_CHANGED,
		ITEM_DURABILITY_CHANGED,
		KILLED_BY_CROSSBOW,
		LEVITATION,
		LOCATION,
		NETHER_TRAVEL,
		PLACED_BLOCK,
		PLAYER_HURT_ENTITY,
		PLAYER_KILLED_ENTITY,
		RECIPE_UNLOCKED,
		SHOT_CROSSBOW,
		SLEPT_IN_BED,
		SUMMONED_ENTITY,
		TAME_ANIMAL,
		TICK,
		USED_ENDER_EYE,
		USED_TOTEM,
		VILLAGER_TRADE,
		VOLUNTARY_EXILE;
		
		@NotNull
		@Contract(pure = true)
		@Override
		public String getValue() {
			return "minecraft:" + name().toLowerCase();
		}
	}
}

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.SharedEnum;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;

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
	protected Trigger(Type type) {
		Validate.notNull(type);
		this.type = type;
	}
	
	
	
	/**
	 * @return the type of the trigger
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * @return a JSON representation of the trigger
	 */
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("trigger", type.getValue())
				.add("conditions", getConditions())
				.build();
	}
	
	/**
	 * @return a JSON representation of the conditions of the trigger or null, if none was specified
	 */
	protected abstract @Nullable JsonObject getConditions();
	
	
	
	/**
	 * This method should be used wisely, since it calls {@link #getConditions()}
	 * @return the hash code of this trigger
	 */
	@Override
	public int hashCode() {
		return Objects.hash(type, getConditions());
	}
	
	/**
	 * This method should be used wisely, since it calls {@link #getConditions()}
	 * @param object the reference object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Trigger)) {
			return false;
		}
		
		Trigger trigger = (Trigger)object;
		return trigger.type == type && Objects.equals(trigger.getConditions(), getConditions());
	}
	
	
	
	/**
	 * The type of trigger, this determines which event the trigger listens to.
	 */
	public enum Type implements SharedEnum {
		BRED_ANIMALS,
		BREWED_POTION,
		CHANGED_DIMENSION,
		CONSTRUCT_BEACON,
		CONSUME_ITEM,
		CURED_ZOMBIE_VILLAGER,
		EFFECTS_CHANGED,
		ENCHANTED_ITEM,
		ENTER_BLOCK,
		ENTITY_HURT_PLAYER,
		ENTITY_KILLED_PLAYER,
		IMPOSSIBLE,
		INVENTORY_CHANGED,
		ITEM_DURABILITY_CHANGED,
		LEVITATION,
		LOCATION,
		NETHER_TRAVEL,
		PLACED_BLOCK,
		PLAYER_HURT_ENTITY,
		PLAYER_KILLED_ENTITY,
		RECIPE_UNLOCKED,
		SLEPT_IN_BED,
		SUMMONED_ENTITY,
		TAME_ANIMAL,
		TICK,
		USED_ENDER_EYE,
		USED_TOTEM,
		VILLAGER_TRADE;
		
		@Override
		public String getValue() {
			return "minecraft:" + name().toLowerCase();
		}
	}
}

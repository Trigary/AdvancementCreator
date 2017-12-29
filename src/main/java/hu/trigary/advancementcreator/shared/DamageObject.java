package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonElement;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Specifies information about a damage event.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class DamageObject extends SharedObject {
	private @Nullable RangeObject dealt = null;
	private @Nullable RangeObject taken = null;
	private @Nullable Boolean blocked = null;
	private @Nullable DamageFlagsObject type = null;
	private @Nullable EntityObject sourceEntity = null;
	
	
	
	/**
	 * @return the dealt damage (damage reduction modifiers (eg. armor) are not yet applied) or null, if none was specified
	 */
	public @Nullable RangeObject getDealt() {
		return dealt;
	}
	
	/**
	 * @return the taken damage (damage reduction modifiers (eg. armor) are applied) or null, if none was specified
	 */
	public @Nullable RangeObject getTaken() {
		return taken;
	}
	
	/**
	 * @return whether the damage is blocked or null, if this wasn't specified
	 */
	public @Nullable Boolean isBlocked() {
		return blocked;
	}
	
	/**
	 * @return more information about the damage event or null, if none was specified
	 */
	public @Nullable DamageFlagsObject getType() {
		return type;
	}
	
	/**
	 * @return information about the dealer of the damage or null, if none was specified
	 */
	public @Nullable EntityObject getSourceEntity() {
		return sourceEntity;
	}
	
	
	
	/**
	 * @param dealt the dealt damage (damage reduction modifiers (eg. armor) are not yet applied) or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public DamageObject setDealt(@Nullable RangeObject dealt) {
		this.dealt = dealt;
		return this;
	}
	
	/**
	 * @param taken the taken damage (damage reduction modifiers (eg. armor) are applied) or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public DamageObject setTaken(@Nullable RangeObject taken) {
		this.taken = taken;
		return this;
	}
	
	/**
	 * @param blocked whether the damage is blocked or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public DamageObject setBlocked(@Nullable Boolean blocked) {
		this.blocked = blocked;
		return this;
	}
	
	/**
	 * @param type more information information about the damage event or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public DamageObject setType(@Nullable DamageFlagsObject type) {
		this.type = type;
		return this;
	}
	
	/**
	 * @param sourceEntity information about the dealer of the damage or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	public DamageObject setSourceEntity(@Nullable EntityObject sourceEntity) {
		this.sourceEntity = sourceEntity;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the damage object
	 */
	@Override
	public JsonElement toJson() {
		return new JsonBuilder()
				.add("dealt", dealt)
				.add("taken", taken)
				.add("blocked", blocked)
				.add("type", type)
				.add("source_entity", sourceEntity)
				.build();
	}
}

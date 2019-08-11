package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonElement;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a damage event.
 */
public class DamageObject extends SharedObject {
	private RangeObject dealt;
	private RangeObject taken;
	private Boolean blocked;
	private DamageFlagsObject type;
	private EntityObject sourceEntity;
	
	
	
	/**
	 * @return the dealt damage (damage reduction modifiers (eg. armor) are not yet applied) or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getDealt() {
		return dealt;
	}
	
	/**
	 * @return the taken damage (damage reduction modifiers (eg. armor) are applied) or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getTaken() {
		return taken;
	}
	
	/**
	 * @return whether the damage is blocked or null, if this wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isBlocked() {
		return blocked;
	}
	
	/**
	 * @return more information about the damage event or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public DamageFlagsObject getType() {
		return type;
	}
	
	/**
	 * @return information about the dealer of the damage or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getSourceEntity() {
		return sourceEntity;
	}
	
	
	
	/**
	 * @param dealt the dealt damage (damage reduction modifiers (eg. armor) are not yet applied) or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	@NotNull
	public DamageObject setDealt(@Nullable RangeObject dealt) {
		this.dealt = dealt;
		return this;
	}
	
	/**
	 * @param taken the taken damage (damage reduction modifiers (eg. armor) are applied) or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	@NotNull
	public DamageObject setTaken(@Nullable RangeObject taken) {
		this.taken = taken;
		return this;
	}
	
	/**
	 * @param blocked whether the damage is blocked or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	@NotNull
	public DamageObject setBlocked(@Nullable Boolean blocked) {
		this.blocked = blocked;
		return this;
	}
	
	/**
	 * @param type more information information about the damage event or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	@NotNull
	public DamageObject setType(@Nullable DamageFlagsObject type) {
		this.type = type;
		return this;
	}
	
	/**
	 * @param sourceEntity information about the dealer of the damage or null, if it should be cleared
	 * @return the current damage object for chaining
	 */
	@NotNull
	public DamageObject setSourceEntity(@Nullable EntityObject sourceEntity) {
		this.sourceEntity = sourceEntity;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the damage object
	 */
	@NotNull
	@Contract(pure = true)
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

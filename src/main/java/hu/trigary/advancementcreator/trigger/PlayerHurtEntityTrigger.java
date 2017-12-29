package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.DamageObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever a player deals any amount of damage (including 0) to an entity (excluding players).
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class PlayerHurtEntityTrigger extends Trigger {
	private @Nullable DamageObject damage = null;
	private @Nullable EntityObject entity = null;
	
	public PlayerHurtEntityTrigger() {
		super(Type.PLAYER_HURT_ENTITY);
	}
	
	
	
	/**
	 * @return information about the damage event or null, if none was specified
	 */
	public @Nullable DamageObject getDamage() {
		return damage;
	}
	
	/**
	 * @return information about the entity that the player had damaged or null, if none was specified
	 */
	public @Nullable EntityObject getEntity() {
		return entity;
	}
	
	
	
	/**
	 * @param damage information about the damage event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public PlayerHurtEntityTrigger setDamage(@Nullable DamageObject damage) {
		this.damage = damage;
		return this;
	}
	
	/**
	 * @param entity information about the entity that the player had damaged or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public PlayerHurtEntityTrigger setEntity(@Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return damage == null && entity == null ? null : new JsonBuilder()
				.add("damage", damage)
				.add("entity", entity)
				.build();
	}
}

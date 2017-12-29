package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.DamageObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever whenever the player takes damage, even if that damage is 0 or blocked.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class EntityHurtPlayerTrigger extends Trigger {
	private @Nullable DamageObject damage = null;
	
	public EntityHurtPlayerTrigger() {
		super(Type.ENTITY_HURT_PLAYER);
	}
	
	
	
	/**
	 * @return information about the damage event or null, if none was specified
	 */
	public @Nullable DamageObject getDamage() {
		return damage;
	}
	
	/**
	 * @param damage information about the damage event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public EntityHurtPlayerTrigger setDamage(@Nullable DamageObject damage) {
		this.damage = damage;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return damage == null ? null : new JsonBuilder()
				.add("damage", damage)
				.build();
	}
}

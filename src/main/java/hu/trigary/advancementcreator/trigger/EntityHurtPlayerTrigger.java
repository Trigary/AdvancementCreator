package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.DamageObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever whenever the player takes damage, even if that damage is 0 or blocked.
 */
public class EntityHurtPlayerTrigger extends Trigger {
	private DamageObject damage;
	
	public EntityHurtPlayerTrigger() {
		super(Type.ENTITY_HURT_PLAYER);
	}
	
	
	
	/**
	 * @return information about the damage event or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public DamageObject getDamage() {
		return damage;
	}
	
	/**
	 * @param damage information about the damage event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public EntityHurtPlayerTrigger setDamage(@Nullable DamageObject damage) {
		this.damage = damage;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("damage", damage)
				.build();
	}
}

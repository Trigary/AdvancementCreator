package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.DeathObject;

/**
 * Fires whenever any mob, excluding players kills the player.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class EntityKilledPlayerTrigger extends Trigger {
	private @Nullable DeathObject death = null;
	
	public EntityKilledPlayerTrigger() {
		super(Type.ENTITY_KILLED_PLAYER);
	}
	
	
	
	/**
	 * @return information about the death event or null, if none was specified
	 */
	public @Nullable DeathObject getDeath() {
		return death;
	}
	
	/**
	 * @param death information about the death event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public EntityKilledPlayerTrigger setDeath(@Nullable DeathObject death) {
		this.death = death;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return death == null ? null : death.toJson();
	}
}

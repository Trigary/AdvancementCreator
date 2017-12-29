package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.DeathObject;

/**
 * Fires whenever a player kills a living entity, except players.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class PlayerKilledEntityTrigger extends Trigger {
	private @Nullable DeathObject death = null;
	
	public PlayerKilledEntityTrigger() {
		super(Type.PLAYER_KILLED_ENTITY);
	}
	
	
	
	/**
	 * @return information about the death event or null, if none was specified
	 */
	public @Nullable DeathObject getDeath() {
		return death;
	}
	
	/**
	 * @param death information about the death event or null, if none was specified
	 * @return the current trigger for chaining
	 */
	public PlayerKilledEntityTrigger setDeath(@Nullable DeathObject death) {
		this.death = death;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return death == null ? null : death.toJson();
	}
}

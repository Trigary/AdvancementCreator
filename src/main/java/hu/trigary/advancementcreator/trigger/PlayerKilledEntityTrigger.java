package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.DeathObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a player kills a living entity, except players.
 */
public class PlayerKilledEntityTrigger extends Trigger {
	private DeathObject death;
	
	public PlayerKilledEntityTrigger() {
		super(Type.PLAYER_KILLED_ENTITY);
	}
	
	
	
	/**
	 * @return information about the death event or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public DeathObject getDeath() {
		return death;
	}
	
	/**
	 * @param death information about the death event or null, if none was specified
	 * @return the current trigger for chaining
	 */
	@NotNull
	public PlayerKilledEntityTrigger setDeath(@Nullable DeathObject death) {
		this.death = death;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return death == null ? new JsonObject() : death.toJson();
	}
}

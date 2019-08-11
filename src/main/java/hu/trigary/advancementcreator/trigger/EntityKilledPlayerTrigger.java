package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.DeathObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever any mob, excluding players kills the player.
 */
public class EntityKilledPlayerTrigger extends Trigger {
	private DeathObject death;
	
	public EntityKilledPlayerTrigger() {
		super(Type.ENTITY_KILLED_PLAYER);
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
	 * @param death information about the death event or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public EntityKilledPlayerTrigger setDeath(@Nullable DeathObject death) {
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

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.LocationObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires when a player causes a raid to begin.
 */
public class VoluntaryExileTrigger extends Trigger {
	private LocationObject location;
	
	public VoluntaryExileTrigger() {
		super(Type.VOLUNTARY_EXILE);
	}
	
	
	
	/**
	 * @return the player's location or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public LocationObject getLocation() {
		return location;
	}
	
	/**
	 * @param location the player's location or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public VoluntaryExileTrigger setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return location == null ? new JsonObject() : location.toJson();
	}
}

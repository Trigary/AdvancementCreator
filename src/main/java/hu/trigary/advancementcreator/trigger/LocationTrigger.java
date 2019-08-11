package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.LocationObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires every 20 ticks (every second). Useful for pre-finished/always completed advancements.
 * @see TickTrigger
 */
public class LocationTrigger extends Trigger {
	private LocationObject location;
	
	public LocationTrigger() {
		super(Type.LOCATION);
	}
	
	
	
	/**
	 * @return information about the location or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public LocationObject getLocation() {
		return location;
	}
	
	/**
	 * @param location information about the location or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public LocationTrigger setLocation(@Nullable LocationObject location) {
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

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.LocationObject;

/**
 * Fires when the player successfully enters a bed (the player does not have to pass the night).
 * For example if the bed explodes, such as from trying to sleep in the nether, this trigger will not fire.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class SleptInBedTrigger extends Trigger {
	private @Nullable LocationObject location = null;
	
	public SleptInBedTrigger() {
		super(Type.SLEPT_IN_BED);
	}
	
	
	
	/**
	 * @return information about the location of the sleeping player or null, if none was specified
	 */
	public @Nullable LocationObject getLocation() {
		return location;
	}
	
	/**
	 * @param location information about the location of the sleeping player or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public SleptInBedTrigger setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return location == null ? null : location.toJson();
	}
}

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.RangeObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever the player is close enough to a beacon and the beacon ticks, possibly giving the player status effects
 * (depending on whether any effect is selected in the beacon). The player does not need to be the one placing the beacon
 * and the beacon does not need to have a pyramid below it.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class ConstructBeaconTrigger extends Trigger {
	private @Nullable RangeObject level = null;
	
	public ConstructBeaconTrigger() {
		super(Type.CONSTRUCT_BEACON);
	}
	
	
	
	/**
	 * @return the beacon's level or null, if none was specified
	 */
	public @Nullable RangeObject getLevel() {
		return level;
	}
	
	/**
	 * @param level the beacon's level or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public ConstructBeaconTrigger setLevel(@Nullable RangeObject level) {
		this.level = level;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return level == null ? null : new JsonBuilder()
				.add("level", level)
				.build();
	}
}

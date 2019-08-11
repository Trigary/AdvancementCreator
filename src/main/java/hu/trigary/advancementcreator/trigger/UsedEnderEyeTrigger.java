package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.RangeObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player uses an Eye of Ender.
 */
public class UsedEnderEyeTrigger extends Trigger {
	private RangeObject distance;
	
	public UsedEnderEyeTrigger() {
		super(Type.USED_ENDER_EYE);
	}
	
	
	
	/**
	 * @return information about the distance of the player and the nearest stronghold's center or null, if none was specified. The vertical distance is not included
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getDistance() {
		return distance;
	}
	
	/**
	 * @param distance information about the distance of the player and the nearest stronghold's center or null, if it should be cleared. The vertical distance is not included
	 * @return the current trigger for chaining
	 */
	@NotNull
	public UsedEnderEyeTrigger setDistance(@Nullable RangeObject distance) {
		this.distance = distance;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("distance", distance)
				.build();
	}
}

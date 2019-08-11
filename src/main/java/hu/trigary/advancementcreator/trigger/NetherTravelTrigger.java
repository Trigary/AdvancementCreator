package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.DistanceObject;
import hu.trigary.advancementcreator.shared.LocationObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player enters the nether and then returns to the overworld.
 */
public class NetherTravelTrigger extends Trigger {
	private LocationObject entered;
	private LocationObject exited;
	private DistanceObject distance;
	
	public NetherTravelTrigger() {
		super(Type.NETHER_TRAVEL);
	}
	
	
	
	/**
	 * @return information about the location of the nether portal the player entered through or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public LocationObject getEntered() {
		return entered;
	}
	
	/**
	 * @return information about the location of the nether portal the player arrived to in the overworld or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public LocationObject getExited() {
		return exited;
	}
	
	/**
	 * @return information about the distance of the two nether portals in the overworld or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public DistanceObject getDistance() {
		return distance;
	}
	
	
	
	/**
	 * @param entered information about the location of the nether portal the player entered through or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public NetherTravelTrigger setEntered(@Nullable LocationObject entered) {
		this.entered = entered;
		return this;
	}
	
	/**
	 * @param exited information about the location of the nether portal the player arrived to in the overworld or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public NetherTravelTrigger setExited(@Nullable LocationObject exited) {
		this.exited = exited;
		return this;
	}
	
	/**
	 * @param distance information about the distance of the two nether portals in the overworld or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public NetherTravelTrigger setDistance(@Nullable DistanceObject distance) {
		this.distance = distance;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("entered", entered)
				.add("exited", exited)
				.add("distance", distance)
				.build();
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;

/**
 * Specifies information about a distance between two points.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class DistanceObject extends SharedObject {
	private @Nullable RangeObject x = null;
	private @Nullable RangeObject y = null;
	private @Nullable RangeObject z = null;
	private @Nullable RangeObject absolute = null;
	private @Nullable RangeObject horizontal = null;
	
	
	
	/**
	 * @return the distance on the x axis
	 */
	public @Nullable RangeObject getX() {
		return x;
	}
	
	/**
	 * @return the distance on the y axis
	 */
	public @Nullable RangeObject getY() {
		return y;
	}
	
	/**
	 * @return the distance on the z axis
	 */
	public @Nullable RangeObject getZ() {
		return z;
	}
	
	/**
	 * @return the distance on all axises
	 */
	public @Nullable RangeObject getAbsolute() {
		return absolute;
	}
	
	/**
	 * @return the distance on the horizontal axises
	 */
	public @Nullable RangeObject getHorizontal() {
		return horizontal;
	}
	
	
	
	/**
	 * @param x the distance on the x axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public DistanceObject setX(@Nullable RangeObject x) {
		this.x = x;
		return this;
	}
	
	/**
	 * @param y the distance on the y axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public DistanceObject setY(@Nullable RangeObject y) {
		this.y = y;
		return this;
	}
	
	/**
	 * @param z the distance on the z axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public DistanceObject setZ(@Nullable RangeObject z) {
		this.z = z;
		return this;
	}
	
	/**
	 * @param absolute the distance on all axises or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public DistanceObject setAbsolute(@Nullable RangeObject absolute) {
		this.absolute = absolute;
		return this;
	}
	
	/**
	 * @param horizontal the distance on the horizontal axises or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	public DistanceObject setHorizontal(@Nullable RangeObject horizontal) {
		this.horizontal = horizontal;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the distance object
	 */
	@Override
	public JsonObject toJson() {
		boolean singleNotNull = x != null || y != null || z != null;
		Validate.isTrue((absolute == null && horizontal == null) || (absolute == null && !singleNotNull) || (horizontal == null && !singleNotNull),
				"Only one of the three options (x/y/z, absolute, horizontal) can be specified.");
		
		return new JsonBuilder()
				.add("x", x)
				.add("y", y)
				.add("z", z)
				.add("absolute", absolute)
				.add("horizontal", horizontal)
				.build();
	}
}

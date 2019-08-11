package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a distance between two points.
 */
public class DistanceObject extends SharedObject {
	private RangeObject x;
	private RangeObject y;
	private RangeObject z;
	private RangeObject absolute;
	private RangeObject horizontal;
	
	
	
	/**
	 * @return the distance on the x axis
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getX() {
		return x;
	}
	
	/**
	 * @return the distance on the y axis
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getY() {
		return y;
	}
	
	/**
	 * @return the distance on the z axis
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getZ() {
		return z;
	}
	
	/**
	 * @return the distance on all axises
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getAbsolute() {
		return absolute;
	}
	
	/**
	 * @return the distance on the horizontal axises
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getHorizontal() {
		return horizontal;
	}
	
	
	
	/**
	 * @param x the distance on the x axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	@NotNull
	public DistanceObject setX(@Nullable RangeObject x) {
		this.x = x;
		return this;
	}
	
	/**
	 * @param y the distance on the y axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	@NotNull
	public DistanceObject setY(@Nullable RangeObject y) {
		this.y = y;
		return this;
	}
	
	/**
	 * @param z the distance on the z axis or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	@NotNull
	public DistanceObject setZ(@Nullable RangeObject z) {
		this.z = z;
		return this;
	}
	
	/**
	 * @param absolute the distance on all axises or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	@NotNull
	public DistanceObject setAbsolute(@Nullable RangeObject absolute) {
		this.absolute = absolute;
		return this;
	}
	
	/**
	 * @param horizontal the distance on the horizontal axises or null, if it should be cleared
	 * @return the current distance object for chaining
	 */
	@NotNull
	public DistanceObject setHorizontal(@Nullable RangeObject horizontal) {
		this.horizontal = horizontal;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the distance object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		boolean singleNotNull = x != null || y != null || z != null;
		Validate.isTrue((absolute == null && horizontal == null)
						|| (absolute == null && !singleNotNull)
						|| (horizontal == null && !singleNotNull),
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

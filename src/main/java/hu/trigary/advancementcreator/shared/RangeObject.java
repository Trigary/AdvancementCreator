package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies a range of values. Both endpoints are inclusive.
 */
public class RangeObject extends SharedObject {
	private Number min;
	private Number max;
	
	
	
	/**
	 * @return the lower bound or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public Number getMin() {
		return min;
	}
	
	/**
	 * @return the upper bound or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public Number getMax() {
		return max;
	}
	
	
	
	/**
	 * @param min the lower bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	@NotNull
	public RangeObject setMin(@Nullable Number min) {
		this.min = min;
		return this;
	}
	
	/**
	 * @param max the upper bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	@NotNull
	public RangeObject setMax(@Nullable Number max) {
		this.max = max;
		return this;
	}
	
	/**
	 * @param exact the value which is to be assigned to both the lower and the upper bounds
	 * @return the current range object for chaining
	 */
	@NotNull
	public RangeObject setExact(@Nullable Number exact) {
		min = exact;
		max = exact;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the range object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonElement toJson() {
		if (min != null && min.equals(max)) {
			return new JsonPrimitive(min);
		}
		return new JsonBuilder()
				.add("min", min)
				.add("max", max)
				.build();
	}
}

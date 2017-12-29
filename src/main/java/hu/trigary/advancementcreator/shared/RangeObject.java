package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Specifies a range of values. Both endpoints are inclusive.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class RangeObject extends SharedObject {
	private @Nullable Double min = null;
	private @Nullable Double max = null;
	
	
	
	/**
	 * @return the lower bound or null, if none is specified
	 */
	public @Nullable Double getMin() {
		return min;
	}
	
	/**
	 * @return the upper bound or null, if none is specified
	 */
	public @Nullable Double getMax() {
		return max;
	}
	
	
	
	/**
	 * @param min the lower bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	public RangeObject setMin(@Nullable Double min) {
		this.min = min;
		return this;
	}
	
	/**
	 * @param min the lower bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	public RangeObject setMin(@Nullable Integer min) {
		this.min = min == null ? null : (double)min;
		return this;
	}
	
	/**
	 * @param max the upper bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	public RangeObject setMax(@Nullable Double max) {
		this.max = max;
		return this;
	}
	
	/**
	 * @param max the upper bound or null, if it should be cleared
	 * @return the current range object for chaining
	 */
	public RangeObject setMax(@Nullable Integer max) {
		this.max = max == null ? null : (double)max;
		return this;
	}
	
	/**
	 * @param exact the value which is to be assigned to both the lower and the upper bounds
	 * @return the current range object for chaining
	 */
	public RangeObject setExact(double exact) {
		min = exact;
		max = exact;
		return this;
	}
	
	/**
	 * @param exact the value which is to be assigned to both the lower and the upper bounds
	 * @return the current range object for chaining
	 */
	public RangeObject setExact(int exact) {
		min = (double)exact;
		max = min;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the range object
	 */
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

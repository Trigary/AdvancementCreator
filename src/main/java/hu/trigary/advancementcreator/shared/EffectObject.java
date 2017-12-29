package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Specifies information about a single applied status effect.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class EffectObject extends SharedObject {
	private @Nullable RangeObject amplifier = null;
	private @Nullable RangeObject duration = null;
	private @Nullable Boolean ambient = null;
	private @Nullable Boolean visible = null;
	
	
	
	/**
	 * @return the amplifier or null, if none was specified
	 */
	public @Nullable RangeObject getAmplifier() {
		return amplifier;
	}
	
	/**
	 * @return the duration or null, if none was specified
	 */
	public @Nullable RangeObject getDuration() {
		return duration;
	}
	
	/**
	 * @return whether the effect is ambient or null, if it wasn't specified
	 */
	public @Nullable Boolean getAmbient() {
		return ambient;
	}
	
	/**
	 * @return whether the effect is visible or null, if it wasn't specified
	 */
	public @Nullable Boolean getVisible() {
		return visible;
	}
	
	
	
	/**
	 * @param amplifier the amplifier or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public EffectObject setAmplifier(@Nullable RangeObject amplifier) {
		this.amplifier = amplifier;
		return this;
	}
	
	/**
	 * @param duration the duration or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public EffectObject setDuration(@Nullable RangeObject duration) {
		this.duration = duration;
		return this;
	}
	
	/**
	 * @param ambient whether the effect is ambient or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public EffectObject setAmbient(@Nullable Boolean ambient) {
		this.ambient = ambient;
		return this;
	}
	
	/**
	 * @param visible whether the effect is visible or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	public EffectObject setVisible(@Nullable Boolean visible) {
		this.visible = visible;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the effect object
	 */
	@Override
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("amplifier", amplifier)
				.add("duration", duration)
				.add("ambient", ambient)
				.add("visible", visible)
				.build();
	}
}

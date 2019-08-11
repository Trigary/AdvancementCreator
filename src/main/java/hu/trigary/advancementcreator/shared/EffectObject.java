package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a single applied status effect.
 */
public class EffectObject extends SharedObject {
	private RangeObject amplifier;
	private RangeObject duration;
	private Boolean ambient;
	private Boolean visible;
	
	
	
	/**
	 * @return the amplifier or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getAmplifier() {
		return amplifier;
	}
	
	/**
	 * @return the duration or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getDuration() {
		return duration;
	}
	
	/**
	 * @return whether the effect is ambient or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean getAmbient() {
		return ambient;
	}
	
	/**
	 * @return whether the effect is visible or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean getVisible() {
		return visible;
	}
	
	
	
	/**
	 * @param amplifier the amplifier or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	@NotNull
	public EffectObject setAmplifier(@Nullable RangeObject amplifier) {
		this.amplifier = amplifier;
		return this;
	}
	
	/**
	 * @param duration the duration or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	@NotNull
	public EffectObject setDuration(@Nullable RangeObject duration) {
		this.duration = duration;
		return this;
	}
	
	/**
	 * @param ambient whether the effect is ambient or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	@NotNull
	public EffectObject setAmbient(@Nullable Boolean ambient) {
		this.ambient = ambient;
		return this;
	}
	
	/**
	 * @param visible whether the effect is visible or null, if it should be cleared
	 * @return the current effect object for chaining
	 */
	@NotNull
	public EffectObject setVisible(@Nullable Boolean visible) {
		this.visible = visible;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the effect object
	 */
	@NotNull
	@Contract(pure = true)
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

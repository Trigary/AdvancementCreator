package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Specifies multiple applied status effects. Only a single {@link EffectObject} can be mapped to a single {@link Effect}.
 */
public class StatusEffectsObject extends SharedObject {
	private final Map<Effect, EffectObject> effects = new HashMap<>();
	
	
	
	/**
	 * @return the map containing the {@link Effect} - {@link EffectObject} pairs
	 */
	@NotNull
	@Contract(pure = true)
	public Map<Effect, EffectObject> getEffects() {
		return Collections.unmodifiableMap(effects);
	}
	
	/**
	 * @param effect the {@link Effect} to modify
	 * @param properties information about the specified {@link Effect} or null, if it should be cleared
	 * @return the current status effects object for chaining
	 */
	@NotNull
	public StatusEffectsObject setEffect(@NotNull Effect effect, @Nullable EffectObject properties) {
		Validate.notNull(effect);
		if (properties == null) {
			effects.remove(effect);
		} else {
			effects.put(effect, properties);
		}
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the status effects object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		effects.forEach((effect, properties) -> json.add(effect.getValue(), properties.toJson()));
		return json;
	}
}

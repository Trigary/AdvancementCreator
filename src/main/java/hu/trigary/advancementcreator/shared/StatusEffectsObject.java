package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Specifies multiple applied status effects. Only a single {@link EffectObject} can be mapped to a single {@link Effect}.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class StatusEffectsObject extends SharedObject {
	private final Map<Effect, EffectObject> effects = new HashMap<>();
	
	
	
	/**
	 * @return the map containing the {@link Effect} - {@link EffectObject} pairs
	 */
	public Map<Effect, EffectObject> getEffects() {
		return Collections.unmodifiableMap(effects);
	}
	
	/**
	 * @param effect the {@link Effect} to modify
	 * @param properties information about the specified {@link Effect} or null, if it should be cleared
	 * @return the current status effects object for chaining
	 */
	public StatusEffectsObject setEffect(Effect effect, @Nullable EffectObject properties) {
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
	@Override
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		for (Map.Entry<Effect, EffectObject> entry : effects.entrySet()) {
			json.add(entry.getKey().getValue(), entry.getValue().toJson());
		}
		return json;
	}
}

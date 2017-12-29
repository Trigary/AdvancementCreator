package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.StatusEffectsObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever the player receives or loses a status effect.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class EffectsChangedTrigger extends Trigger {
	private @Nullable StatusEffectsObject effects = null;
	
	public EffectsChangedTrigger() {
		super(Type.EFFECTS_CHANGED);
	}
	
	
	
	/**
	 * @return the effects which the player has or null, if none was specified. The newly added/lost effect is unknown
	 */
	public @Nullable StatusEffectsObject getEffects() {
		return effects;
	}
	
	/**
	 * @param effects the effects which the player has or null, if it should be cleared. The newly added/lost effect cannot be explicitly specified
	 * @return the current trigger for chaining
	 */
	public EffectsChangedTrigger setEffects(@Nullable StatusEffectsObject effects) {
		this.effects = effects;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return effects == null ? null : new JsonBuilder()
				.add("effects", effects)
				.build();
	}
}

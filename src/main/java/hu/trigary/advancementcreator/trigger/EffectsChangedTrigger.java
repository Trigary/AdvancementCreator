package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.StatusEffectsObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player receives or loses a status effect.
 */
public class EffectsChangedTrigger extends Trigger {
	private StatusEffectsObject effects;
	
	public EffectsChangedTrigger() {
		super(Type.EFFECTS_CHANGED);
	}
	
	
	
	/**
	 * @return the effects which the player has or null, if none was specified. The newly added/lost effect is unknown
	 */
	@Nullable
	@Contract(pure = true)
	public StatusEffectsObject getEffects() {
		return effects;
	}
	
	/**
	 * @param effects the effects which the player has or null, if it should be cleared. The newly added/lost effect cannot be explicitly specified
	 * @return the current trigger for chaining
	 */
	@NotNull
	public EffectsChangedTrigger setEffects(@Nullable StatusEffectsObject effects) {
		this.effects = effects;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("effects", effects)
				.build();
	}
}

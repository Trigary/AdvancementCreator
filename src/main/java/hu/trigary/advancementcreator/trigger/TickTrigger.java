package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;

/**
 * Fires every tick. Can be used to help simulate command block systems or automatically unlock advancements.
 * @see LocationTrigger
 */
public class TickTrigger extends Trigger {
	public TickTrigger() {
		super(Type.TICK);
	}
	
	@Override
	protected JsonObject getConditions() {
		return null;
	}
}

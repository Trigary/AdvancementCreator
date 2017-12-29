package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;

/**
 * Never fires, therefore this trigger cannot be fulfilled, except if it's explicitly granted using commands and such.
 */
public class ImpossibleTrigger extends Trigger {
	public ImpossibleTrigger() {
		super(Type.IMPOSSIBLE);
	}
	
	@Override
	protected JsonObject getConditions() {
		return null;
	}
}

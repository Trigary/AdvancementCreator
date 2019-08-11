package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Never fires, therefore this trigger cannot be fulfilled, except if it's explicitly granted using commands and such.
 */
public class ImpossibleTrigger extends Trigger {
	public ImpossibleTrigger() {
		super(Type.IMPOSSIBLE);
	}
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonObject();
	}
}

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever the player creates an entity. In the case of the ender dragon, all players able to view the boss bar fulfill the trigger.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class SummonedEntityTrigger extends Trigger {
	private @Nullable EntityObject entity = null;
	
	public SummonedEntityTrigger() {
		super(Type.SUMMONED_ENTITY);
	}
	
	
	
	/**
	 * @return information about the tamed entity or null, if none was specified
	 */
	public @Nullable EntityObject getEntity() {
		return entity;
	}
	
	/**
	 * @param entity information about the tamed entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public SummonedEntityTrigger setEntity(@Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return entity == null ? null : new JsonBuilder()
				.add("entity", entity)
				.build();
	}
}

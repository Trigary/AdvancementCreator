package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Specifies information about a death event.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class DeathObject extends SharedObject {
	private @Nullable EntityObject entity = null;
	private @Nullable DamageFlagsObject killingBlow = null;
	
	
	
	/**
	 * @return information about the entity which died or null, if none was specified
	 */
	public @Nullable EntityObject getEntity() {
		return entity;
	}
	
	/**
	 * @return information about the damage event which caused this death or null, if none was specified
	 */
	public @Nullable DamageFlagsObject getKillingBlow() {
		return killingBlow;
	}
	
	
	
	/**
	 * @param entity information about the entity which died or null, if it should be cleared
	 * @return the current death object for chaining
	 */
	public DeathObject setEntity(@Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	/**
	 * @param killingBlow information about the damage event or null, if it should be cleared
	 * @return the current death object for chaining
	 */
	public DeathObject setKillingBlow(@Nullable DamageFlagsObject killingBlow) {
		this.killingBlow = killingBlow;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the death object
	 */
	@Override
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("entity", entity)
				.add("killing_bow", killingBlow)
				.build();
	}
}

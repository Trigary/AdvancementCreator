package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a death event.
 */
public class DeathObject extends SharedObject {
	private EntityObject entity;
	private DamageFlagsObject killingBlow;
	
	
	
	/**
	 * @return information about the entity which died or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getEntity() {
		return entity;
	}
	
	/**
	 * @return information about the damage event which caused this death or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public DamageFlagsObject getKillingBlow() {
		return killingBlow;
	}
	
	
	
	/**
	 * @param entity information about the entity which died or null, if it should be cleared
	 * @return the current death object for chaining
	 */
	@NotNull
	public DeathObject setEntity(@Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	/**
	 * @param killingBlow information about the damage event or null, if it should be cleared
	 * @return the current death object for chaining
	 */
	@NotNull
	public DeathObject setKillingBlow(@Nullable DamageFlagsObject killingBlow) {
		this.killingBlow = killingBlow;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the death object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("entity", entity)
				.add("killing_bow", killingBlow)
				.build();
	}
}

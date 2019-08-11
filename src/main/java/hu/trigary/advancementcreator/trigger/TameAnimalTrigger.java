package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player tames an animal.
 */
public class TameAnimalTrigger extends Trigger {
	private EntityObject entity;
	
	public TameAnimalTrigger() {
		super(Type.TAME_ANIMAL);
	}
	
	
	
	/**
	 * @return information about the tamed entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getEntity() {
		return entity;
	}
	
	/**
	 * @param entity information about the tamed entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public TameAnimalTrigger setEntity(@Nullable EntityObject entity) {
		this.entity = entity;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("entity", entity)
				.build();
	}
}

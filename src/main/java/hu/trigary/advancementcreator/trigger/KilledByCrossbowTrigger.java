package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.shared.SharedObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fires when a player kills a mob with a projectile shot from a crossbow.
 */
public class KilledByCrossbowTrigger extends Trigger {
	private Integer uniqueEntityTypes;
	private List<EntityObject> victims;
	
	public KilledByCrossbowTrigger() {
		super(Type.KILLED_BY_CROSSBOW);
	}
	
	
	
	/**
	 * @return the minimum count of unique entity types hit with the projectile or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Integer getUniqueEntityTypes() {
		return uniqueEntityTypes;
	}
	
	/**
	 * @return the immutable list of entities that must be hit
	 */
	@NotNull
	@Contract(pure = true)
	public List<EntityObject> getVictims() {
		return victims == null ? Collections.emptyList() : Collections.unmodifiableList(victims);
	}
	
	
	
	/**
	 * @param uniqueEntityTypes the minimum count of unique entity types
	 * hit with the projectile or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public KilledByCrossbowTrigger setUniqueEntityTypes(@Nullable Integer uniqueEntityTypes) {
		this.uniqueEntityTypes = uniqueEntityTypes;
		return this;
	}
	
	/**
	 * @param victim an entity that must be hit
	 * @return the current trigger for chaining
	 */
	@NotNull
	public KilledByCrossbowTrigger addVictim(@NotNull EntityObject victim) {
		Validate.notNull(victim);
		if (victims == null) {
			victims = new ArrayList<>();
		}
		victims.add(victim);
		return this;
	}
	
	/**
	 * @param victim an entity that no longer needs to be hit
	 * @return the current trigger (for chaining)
	 */
	@NotNull
	public KilledByCrossbowTrigger removeVictim(@NotNull EntityObject victim) {
		Validate.notNull(victim);
		if (victims != null) {
			victims.remove(victim);
		}
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("unique_entity_types", uniqueEntityTypes)
				.add("victims", victims, SharedObject::toJson)
				.build();
	}
}

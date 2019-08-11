package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.shared.SharedObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fires when a lightning bolt summoned from the Channeling enchantment strikes an enemy.
 */
public class ChanneledLightningTrigger extends Trigger {
	private List<EntityObject> victims;
	
	public ChanneledLightningTrigger() {
		super(Type.CHANNELED_LIGHTNING);
	}
	
	
	
	/**
	 * @return immutable list of entities that must be struck
	 */
	@NotNull
	@Contract(pure = true)
	public List<EntityObject> getVictims() {
		return victims == null ? Collections.emptyList() : Collections.unmodifiableList(victims);
	}
	
	
	
	/**
	 * @param victim an entity that must be struck
	 * @return the current trigger for chaining
	 */
	@NotNull
	@Contract(pure = true)
	public ChanneledLightningTrigger addVictim(@NotNull EntityObject victim) {
		Validate.notNull(victim);
		if (victims == null) {
			victims = new ArrayList<>();
		}
		victims.add(victim);
		return this;
	}
	
	/**
	 * @param victim an entity that no longer needs to be struck
	 * @return the current trigger for chaining
	 */
	@NotNull
	@Contract(pure = true)
	public ChanneledLightningTrigger removeVictim(@NotNull EntityObject victim) {
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
				.add("victims", victims, SharedObject::toJson)
				.build();
	}
}

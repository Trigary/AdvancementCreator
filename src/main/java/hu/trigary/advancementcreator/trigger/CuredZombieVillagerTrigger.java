package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever a zombie villager turns into a villager. The player that had fed the zombie the golden apple will be the one fulfilling the trigger.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class CuredZombieVillagerTrigger extends Trigger {
	private @Nullable EntityObject zombie = null;
	private @Nullable EntityObject villager = null;
	
	public CuredZombieVillagerTrigger() {
		super(Type.CURED_ZOMBIE_VILLAGER);
	}
	
	
	
	/**
	 * @return information about the zombie villager that was converted or null, if none was specified
	 */
	public @Nullable EntityObject getZombie() {
		return zombie;
	}
	
	/**
	 * @return information about the villager that was just created or null, if none was specified
	 */
	public @Nullable EntityObject getVillager() {
		return villager;
	}
	
	
	
	/**
	 * @param zombie information about the zombie villager that was converted or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public CuredZombieVillagerTrigger setZombie(@Nullable EntityObject zombie) {
		this.zombie = zombie;
		return this;
	}
	
	/**
	 * @param villager information about the villager that was just created or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public CuredZombieVillagerTrigger setVillager(@Nullable EntityObject villager) {
		this.villager = villager;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return zombie == null && villager == null ? null : new JsonBuilder()
				.add("zombie", zombie)
				.add("villager", villager)
				.build();
	}
}

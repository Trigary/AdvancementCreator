package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever a zombie villager turns into a villager. The player that had fed the zombie the golden apple will be the one fulfilling the trigger.
 */
public class CuredZombieVillagerTrigger extends Trigger {
	private EntityObject zombie;
	private EntityObject villager;
	
	public CuredZombieVillagerTrigger() {
		super(Type.CURED_ZOMBIE_VILLAGER);
	}
	
	
	
	/**
	 * @return information about the zombie villager that was converted or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getZombie() {
		return zombie;
	}
	
	/**
	 * @return information about the villager that was just created or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getVillager() {
		return villager;
	}
	
	
	
	/**
	 * @param zombie information about the zombie villager that was converted or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public CuredZombieVillagerTrigger setZombie(@Nullable EntityObject zombie) {
		this.zombie = zombie;
		return this;
	}
	
	/**
	 * @param villager information about the villager that was just created or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public CuredZombieVillagerTrigger setVillager(@Nullable EntityObject villager) {
		this.villager = villager;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("zombie", zombie)
				.add("villager", villager)
				.build();
	}
}

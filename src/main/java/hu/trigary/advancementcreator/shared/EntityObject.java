package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;

/**
 * Specifies information about an entity.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class EntityObject extends SharedObject {
	private @Nullable MobType type;
	private @Nullable DistanceObject distance;
	private @Nullable LocationObject location;
	private @Nullable StatusEffectsObject effects;
	private @Nullable String nbt;
	
	
	
	/**
	 * @return the type of the entity or null, if none was specified
	 */
	public @Nullable MobType getType() {
		return type;
	}
	
	/**
	 * @return information about the distance of the entity or null, if none was specified
	 */
	public @Nullable DistanceObject getDistance() {
		return distance;
	}
	
	/**
	 * @return information about the location of the entity or null, if none was specified
	 */
	public @Nullable LocationObject getLocation() {
		return location;
	}
	
	/**
	 * @return the status effects of the entity or null, if none was specified
	 */
	public @Nullable StatusEffectsObject getEffects() {
		return effects;
	}
	
	/**
	 * @return the NBT of the entity or null, if none was specified
	 */
	public @Nullable String getNbt() {
		return nbt;
	}
	
	
	
	/**
	 * @param type the type of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public EntityObject setType(@Nullable MobType type) {
		this.type = type;
		return this;
	}
	
	/**
	 * @param distance information about the distance of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public EntityObject setDistance(@Nullable DistanceObject distance) {
		this.distance = distance;
		return this;
	}
	
	/**
	 * @param location information about the location of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public EntityObject setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	/**
	 * @param effects the status effects of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public EntityObject setEffects(@Nullable StatusEffectsObject effects) {
		this.effects = effects;
		return this;
	}
	
	/**
	 * @param nbt the NBT string of the entity (starting and ending with curly braces) or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	public EntityObject setNbt(@Nullable String nbt) {
		Validator.nbt(nbt);
		this.nbt = nbt;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the entity object
	 */
	@Override
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("type", type)
				.add("distance", distance)
				.add("location", location)
				.add("effects", effects)
				.add("nbt", nbt)
				.build();
	}
}

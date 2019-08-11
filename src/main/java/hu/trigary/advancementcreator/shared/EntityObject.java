package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about an entity.
 */
public class EntityObject extends SharedObject {
	private EntityType type;
	private DistanceObject distance;
	private LocationObject location;
	private StatusEffectsObject effects;
	private String nbt;
	private Boolean onFire;
	private Boolean sneaking;
	private Boolean sprinting;
	private Boolean swimming;
	private Boolean baby;
	private ItemObject head;
	private ItemObject chest;
	private ItemObject legs;
	private ItemObject feet;
	private ItemObject mainHand;
	private ItemObject offHand;
	private Cat.Type catType;
	
	
	
	/**
	 * @return the type of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityType getType() {
		return type;
	}
	
	/**
	 * @return information about the distance of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public DistanceObject getDistance() {
		return distance;
	}
	
	/**
	 * @return information about the location of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public LocationObject getLocation() {
		return location;
	}
	
	/**
	 * @return the status effects of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public StatusEffectsObject getEffects() {
		return effects;
	}
	
	/**
	 * @return the NBT of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public String getNbt() {
		return nbt;
	}
	
	/**
	 * @return whether the entity is on fire or null, if unspecified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isOnFire() {
		return onFire;
	}
	
	/**
	 * @return whether the entity is sneaking or null, if unspecified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isSneaking() {
		return sneaking;
	}
	
	/**
	 * @return whether the entity is sprinting or null, if unspecified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isSprinting() {
		return sprinting;
	}
	
	/**
	 * @return whether the entity is swimming or null, if unspecified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isSwimming() {
		return swimming;
	}
	
	/**
	 * @return whether the entity is a baby or null, if unspecified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isBaby() {
		return baby;
	}
	
	/**
	 * @return the item on the head of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getHead() {
		return head;
	}
	
	/**
	 * @return the item on the chest of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getChest() {
		return chest;
	}
	
	/**
	 * @return the item on the legs of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getLegs() {
		return legs;
	}
	
	/**
	 * @return the item on the feet of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getFeet() {
		return feet;
	}
	
	/**
	 * @return the item in the main hand of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getMainHand() {
		return mainHand;
	}
	
	/**
	 * @return the item in the off hand of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public ItemObject getOffHand() {
		return offHand;
	}
	
	/**
	 * @return the cat type of the entity or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Cat.Type getCatType() {
		return catType;
	}
	
	
	
	/**
	 * @param type the type of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setType(@Nullable EntityType type) {
		this.type = type;
		return this;
	}
	
	/**
	 * @param distance information about the distance of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setDistance(@Nullable DistanceObject distance) {
		this.distance = distance;
		return this;
	}
	
	/**
	 * @param location information about the location of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}
	
	/**
	 * @param effects the status effects of the entity or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setEffects(@Nullable StatusEffectsObject effects) {
		this.effects = effects;
		return this;
	}
	
	/**
	 * @param nbt the NBT string of the entity (starting and ending with curly braces) or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setNbt(@Nullable String nbt) {
		Validator.nbt(nbt);
		this.nbt = nbt;
		return this;
	}
	
	/**
	 * @param onFire the on fire status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setOnFire(@Nullable Boolean onFire) {
		this.onFire = onFire;
		return this;
	}
	
	/**
	 * @param sneaking the sneaking status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setSneaking(@Nullable Boolean sneaking) {
		this.sneaking = sneaking;
		return this;
	}
	
	/**
	 * @param sprinting the sprinting status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setSprinting(@Nullable Boolean sprinting) {
		this.sprinting = sprinting;
		return this;
	}
	
	/**
	 * @param swimming the swimming status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setSwimming(@Nullable Boolean swimming) {
		this.swimming = swimming;
		return this;
	}
	
	/**
	 * @param baby the baby status or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setBaby(@Nullable Boolean baby) {
		this.baby = baby;
		return this;
	}
	
	/**
	 * @param head the item on the head or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setHead(@Nullable ItemObject head) {
		this.head = head;
		return this;
	}
	
	/**
	 * @param chest the item on the chest or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setChest(@Nullable ItemObject chest) {
		this.chest = chest;
		return this;
	}
	
	/**
	 * @param legs the item on the legs or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setLegs(@Nullable ItemObject legs) {
		this.legs = legs;
		return this;
	}
	
	/**
	 * @param feet the item on the feet or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setFeet(@Nullable ItemObject feet) {
		this.feet = feet;
		return this;
	}
	
	/**
	 * @param mainHand the item in the main hand or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setMainHand(@Nullable ItemObject mainHand) {
		this.mainHand = mainHand;
		return this;
	}
	
	/**
	 * @param offHand the item in the off hand or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setOffHand(@Nullable ItemObject offHand) {
		this.offHand = offHand;
		return this;
	}
	
	/**
	 * @param catType the cat type or null, if it should be cleared
	 * @return the current entity object for chaining
	 */
	@NotNull
	public EntityObject setCatType(@Nullable Cat.Type catType) {
		this.catType = catType;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the entity object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		JsonBuilder builder = new JsonBuilder()
				.add("type", type)
				.add("distance", distance)
				.add("location", location)
				.add("effects", effects)
				.add("nbt", nbt);
		
		if (onFire != null || sneaking != null || sprinting != null || swimming != null || baby != null) {
			builder.add("flags", new JsonBuilder()
					.add("is_on_fire", onFire)
					.add("is_sneaking", sneaking)
					.add("is_sprinting", sprinting)
					.add("is_swimming", swimming)
					.add("is_baby", baby)
					.build());
		}
		
		if (head != null || chest != null || legs != null || feet != null || mainHand != null || offHand != null) {
			builder.add("equipment", new JsonBuilder()
					.add("head", head)
					.add("chest", chest)
					.add("legs", legs)
					.add("feet", feet)
					.add("mainhand", mainHand)
					.add("offhand", offHand)
					.build());
		}
		
		if (catType != null) {
			builder.add("catType", "minecraft:textures/entity/cat/" + catType.name().toLowerCase() + ".png");
		}
		return builder.build();
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a damage event, similarly to {@link DamageObject}.
 */
public class DamageFlagsObject extends SharedObject {
	private Boolean bypassesArmor;
	private Boolean bypassesInvulnerability;
	private Boolean bypassesMagic;
	private Boolean explosion;
	private Boolean fire;
	private Boolean magic;
	private Boolean projectile;
	private Boolean lightning;
	private EntityObject sourceEntity;
	private EntityObject directEntity;
	
	
	
	/**
	 * @return whether the damage bypasses armor or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean getBypassesArmor() {
		return bypassesArmor;
	}
	
	/**
	 * @return whether the damage bypasses invulnerability or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean getBypassesInvulnerability() {
		return bypassesInvulnerability;
	}
	
	/**
	 * @return whether the damage bypasses magic or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean getBypassesMagic() {
		return bypassesMagic;
	}
	
	/**
	 * @return whether the damage is from an explosion or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isExplosion() {
		return explosion;
	}
	
	/**
	 * @return whether the damage is from fire or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isFire() {
		return fire;
	}
	
	/**
	 * @return whether the damage is from magic or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isMagic() {
		return magic;
	}
	
	/**
	 * @return whether the damage is from a projectile or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isProjectile() {
		return projectile;
	}
	
	/**
	 * @return whether the damage is from a lightning or null, if it wasn't specified
	 */
	@Nullable
	@Contract(pure = true)
	public Boolean isLightning() {
		return lightning;
	}
	
	/**
	 * @return information about the indirect dealer of the damage (eg. if the entity which shot the arrow) or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getSourceEntity() {
		return sourceEntity;
	}
	
	/**
	 * @return information about the direct dealer of the damage (eg. the arrow) or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public EntityObject getDirectEntity() {
		return directEntity;
	}
	
	
	
	/**
	 * @param bypassesArmor whether the damage bypasses armor or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setBypassesArmor(@Nullable Boolean bypassesArmor) {
		this.bypassesArmor = bypassesArmor;
		return this;
	}
	
	/**
	 * @param bypassesInvulnerability whether the damage bypasses invulnerability or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setBypassesInvulnerability(@Nullable Boolean bypassesInvulnerability) {
		this.bypassesInvulnerability = bypassesInvulnerability;
		return this;
	}
	
	/**
	 * @param bypassesMagic whether the damage bypasses magic or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setBypassesMagic(@Nullable Boolean bypassesMagic) {
		this.bypassesMagic = bypassesMagic;
		return this;
	}
	
	/**
	 * @param explosion whether the damage is from an explosion or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setExplosion(@Nullable Boolean explosion) {
		this.explosion = explosion;
		return this;
	}
	
	/**
	 * @param fire whether the damage is from fire or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setFire(@Nullable Boolean fire) {
		this.fire = fire;
		return this;
	}
	
	/**
	 * @param magic whether the damage is from magic or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setMagic(@Nullable Boolean magic) {
		this.magic = magic;
		return this;
	}
	
	/**
	 * @param projectile whether the damage is from a projectile or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setProjectile(@Nullable Boolean projectile) {
		this.projectile = projectile;
		return this;
	}
	
	/**
	 * @param lightning whether the damage is from a lightning or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setLightning(@Nullable Boolean lightning) {
		this.lightning = lightning;
		return this;
	}
	
	/**
	 * @param sourceEntity information about the indirect dealer of the damage (eg. if the entity which shot the arrow) or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setSourceEntity(@Nullable EntityObject sourceEntity) {
		this.sourceEntity = sourceEntity;
		return this;
	}
	
	/**
	 * @param directEntity information about the direct dealer of the damage (eg. the arrow) or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	@NotNull
	public DamageFlagsObject setDirectEntity(@Nullable EntityObject directEntity) {
		this.directEntity = directEntity;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the block object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("bypasses_armor", bypassesArmor)
				.add("bypasses_invulnerability", bypassesInvulnerability)
				.add("bypasses_magic", bypassesMagic)
				.add("is_explosion", explosion)
				.add("is_fire", fire)
				.add("is_magic", magic)
				.add("is_projectile", projectile)
				.add("is_lightning", lightning)
				.add("source_entity", sourceEntity)
				.add("direct_entity", directEntity)
				.build();
	}
}

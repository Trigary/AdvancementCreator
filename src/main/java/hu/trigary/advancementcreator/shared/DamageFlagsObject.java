package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Specifies information about a damage event, similarly to {@link DamageObject}.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class DamageFlagsObject extends SharedObject {
	private @Nullable Boolean bypassesArmor = null;
	private @Nullable Boolean bypassesInvulnerability = null;
	private @Nullable Boolean bypassesMagic = null;
	private @Nullable Boolean explosion = null;
	private @Nullable Boolean fire = null;
	private @Nullable Boolean magic = null;
	private @Nullable Boolean projectile = null;
	private @Nullable EntityObject sourceEntity = null;
	private @Nullable EntityObject directEntity = null;
	
	
	
	/**
	 * @return whether the damage bypasses armor or null, if it wasn't specified
	 */
	public @Nullable Boolean getBypassesArmor() {
		return bypassesArmor;
	}
	
	/**
	 * @return whether the damage bypasses invulnerability or null, if it wasn't specified
	 */
	public @Nullable Boolean getBypassesInvulnerability() {
		return bypassesInvulnerability;
	}
	
	/**
	 * @return whether the damage bypasses magic or null, if it wasn't specified
	 */
	public @Nullable Boolean getBypassesMagic() {
		return bypassesMagic;
	}
	
	/**
	 * @return whether the damage is from an explosion or null, if it wasn't specified
	 */
	public @Nullable Boolean isExplosion() {
		return explosion;
	}
	
	/**
	 * @return whether the damage is from fire or null, if it wasn't specified
	 */
	public @Nullable Boolean isFire() {
		return fire;
	}
	
	/**
	 * @return whether the damage is from magic or null, if it wasn't specified
	 */
	public @Nullable Boolean isMagic() {
		return magic;
	}
	
	/**
	 * @return whether the damage is from a projectile or null, if it wasn't specified
	 */
	public @Nullable Boolean isProjectile() {
		return projectile;
	}
	
	/**
	 * @return information about the indirect dealer of the damage (eg. if the entity which shot the arrow) or null, if none was specified
	 */
	public @Nullable EntityObject getSourceEntity() {
		return sourceEntity;
	}
	
	/**
	 * @return information about the direct dealer of the damage (eg. the arrow) or null, if none was specified
	 */
	public @Nullable EntityObject getDirectEntity() {
		return directEntity;
	}
	
	
	
	/**
	 * @param bypassesArmor whether the damage bypasses armor or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setBypassesArmor(@Nullable Boolean bypassesArmor) {
		this.bypassesArmor = bypassesArmor;
		return this;
	}
	
	/**
	 * @param bypassesInvulnerability whether the damage bypasses invulnerability or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setBypassesInvulnerability(@Nullable Boolean bypassesInvulnerability) {
		this.bypassesInvulnerability = bypassesInvulnerability;
		return this;
	}
	
	/**
	 * @param bypassesMagic whether the damage bypasses magic or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setBypassesMagic(@Nullable Boolean bypassesMagic) {
		this.bypassesMagic = bypassesMagic;
		return this;
	}
	
	/**
	 * @param explosion whether the damage is from an explosion or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setExplosion(@Nullable Boolean explosion) {
		this.explosion = explosion;
		return this;
	}
	
	/**
	 * @param fire whether the damage is from fire or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setFire(@Nullable Boolean fire) {
		this.fire = fire;
		return this;
	}
	
	/**
	 * @param magic whether the damage is from magic or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setMagic(@Nullable Boolean magic) {
		this.magic = magic;
		return this;
	}
	
	/**
	 * @param projectile whether the damage is from a projectile or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setProjectile(@Nullable Boolean projectile) {
		this.projectile = projectile;
		return this;
	}
	
	/**
	 * @param sourceEntity information about the indirect dealer of the damage (eg. if the entity which shot the arrow) or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setSourceEntity(@Nullable EntityObject sourceEntity) {
		this.sourceEntity = sourceEntity;
		return this;
	}
	
	/**
	 * @param directEntity information about the direct dealer of the damage (eg. the arrow) or null, if it should be cleared
	 * @return the current damage flags object for chaining
	 */
	public DamageFlagsObject setDirectEntity(@Nullable EntityObject directEntity) {
		this.directEntity = directEntity;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the block object
	 */
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
				.add("source_entity", sourceEntity)
				.add("direct_entity", directEntity)
				.build();
	}
}

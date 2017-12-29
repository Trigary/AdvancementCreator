package hu.trigary.advancementcreator.shared;

/**
 * Specifies an item enchantment.
 * @see ItemObject
 */
@SuppressWarnings("unused")
public enum Enchant implements SharedEnum {
	PROTECTION,
	FIRE_PROTECTION,
	FEATHER_FALLING,
	BLAST_PROTECTION,
	PROJECTILE_PROTECTION,
	RESPIRATION,
	AQUA_AFFINITY,
	THORNS,
	DEPTH_STRIDER,
	FROST_WALKER,
	BINDING_CURSE,
	SHARPNESS,
	SMITE,
	BANE_OF_ARTHROPODS,
	KNOCKBACK,
	FIRE_ASPECT,
	LOOTING,
	SWEEPING,
	EFFICIENCY,
	SILK_TOUCH,
	UNBREAKING,
	FORTUNE,
	POWER,
	PUNCH,
	FLAME,
	INFINITY,
	LUCK_OF_THE_SEA,
	LURE,
	MENDING,
	VANISHING_CURSE;
	
	@Override
	public String getValue() {
		return "minecraft:" + name().toLowerCase();
	}
}

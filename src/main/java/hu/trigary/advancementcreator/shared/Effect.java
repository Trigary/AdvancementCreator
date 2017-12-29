package hu.trigary.advancementcreator.shared;

/**
 * Specifies a status effect.
 * @see EffectObject
 */
@SuppressWarnings("unused")
public enum Effect implements SharedEnum {
	SPEED,
	SLOWNESS,
	HASTE,
	MINING_FATIGUE,
	STRENGTH,
	INSTANT_HEALTH,
	INSTANT_DAMAGE,
	JUMP_BOOST,
	NAUSEA,
	REGENERATION,
	RESISTANCE,
	FIRE_RESISTANCE,
	WATER_BREATHING,
	INVISIBILITY,
	BLINDNESS,
	NIGHT_VISION,
	HUNGER,
	WEAKNESS,
	POISON,
	WITHER,
	HEALTH_BOOST,
	ABSORPTION,
	SATURATION,
	GLOWING,
	LEVITATION,
	LUCK,
	UNLUCK;
	
	@Override
	public String getValue() {
		return "minecraft:" + name().toLowerCase();
	}
}

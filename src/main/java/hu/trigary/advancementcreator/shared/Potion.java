package hu.trigary.advancementcreator.shared;

/**
 * Specifies a potion's effect.
 */
@SuppressWarnings("unused")
public enum Potion implements SharedEnum {
	/**
	 * Also known as the uncraftable potion. It is not actually empty: the texture does not equal {@link MaterialId#GLASS_BOTTLE}'s
	 */
	EMPTY,
	WATER,
	MUNDANE,
	THICK,
	AWKWARD,
	NIGHT_VISION,
	LONG_NIGHT_VISION,
	INVISIBILITY,
	LONG_INVISIBILITY,
	LEAPING,
	STRONG_LEAPING,
	LONG_LEAPING,
	FIRE_RESISTANCE,
	LONG_FIRE_RESISTANCE,
	SWIFTNESS,
	STRONG_SWIFTNESS,
	SLOWNESS,
	LONG_SLOWNESS,
	LONG_SWIFTNESS,
	WATER_BREATHING,
	LONG_WATER_BREATHING,
	HEALING,
	STRONG_HEALING,
	HARMING,
	STRONG_HARMING,
	POISON,
	STRONG_POISON,
	LONG_POISON,
	REGENERATION,
	STRONG_REGENERATION,
	LONG_REGENERATION,
	STRENGTH,
	STRONG_STRENGTH,
	LONG_STRENGTH,
	WEAKNESS,
	LONG_WEAKNESS,
	LUCK;
	
	@Override
	public String getValue() {
		return "minecraft:" + name().toLowerCase();
	}
	
	
	
	/**
	 * The type of the potion item.
	 */
	public enum Type {
		/**
		 * Consumable/drinkable.
		 */
		NORMAL(MaterialId.POTION),
		SPLASH(MaterialId.SPLASH_POTION),
		LINGERING(MaterialId.LINGERING_POTION);
		
		private final MaterialId item;
		
		Type(MaterialId item) {
			this.item = item;
		}
		
		/**
		 * @return the item type associated with this potion type
		 */
		public MaterialId getItem() {
			return item;
		}
	}
}

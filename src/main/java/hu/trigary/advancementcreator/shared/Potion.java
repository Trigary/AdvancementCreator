package hu.trigary.advancementcreator.shared;

import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Specifies a potion's effect.
 */
public enum Potion implements SharedEnum {
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
	LONG_SWIFTNESS,
	SLOWNESS,
	STRONG_SLOWNESS,
	LONG_SLOWNESS,
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
	LUCK,
	TURTLE_MASTER,
	STRONG_TURTLE_MASTER,
	LONG_TURTLE_MASTER,
	SLOW_FALLING,
	LONG_SLOW_FALLING;
	
	@NotNull
	@Contract(pure = true)
	@Override
	public String getValue() {
		return "minecraft:" + name().toLowerCase();
	}
	
	
	
	/**
	 * The type of the potion item.
	 */
	public enum Type {
		NORMAL(Material.POTION),
		SPLASH(Material.SPLASH_POTION),
		LINGERING(Material.LINGERING_POTION);
		
		private final Material item;
		
		Type(Material item) {
			this.item = item;
		}
		
		/**
		 * @return the item type associated with this potion type
		 */
		@NotNull
		@Contract(pure = true)
		public Material getItem() {
			return item;
		}
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonElement;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about an enchantment applied to an item.
 * @see ItemObject
 */
public class EnchantObject extends SharedObject {
	private Enchantment enchant;
	private RangeObject levels;
	
	
	
	/**
	 * @return the enchant or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Enchantment getEnchant() {
		return enchant;
	}
	
	/**
	 * @return the level of the enchantment or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getLevels() {
		return levels;
	}
	
	
	
	/**
	 * @param enchant the enchant or null, if it should be cleared
	 * @return the current block object for chaining
	 */
	@NotNull
	public EnchantObject setEnchant(@Nullable Enchantment enchant) {
		this.enchant = enchant;
		return this;
	}
	
	/**
	 * @param levels the level of the enchantment or null, if it should be cleared
	 * @return the current block object for chaining
	 */
	@NotNull
	public EnchantObject setLevels(@Nullable RangeObject levels) {
		this.levels = levels;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the enchant object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonElement toJson() {
		return new JsonBuilder() //empty JsonObject -> any enchantment
				.add("enchantment", enchant)
				.add("levels", levels)
				.build();
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;
import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Specifies information about an item. Apart from triggers, also used to specify the icon of advancements.
 * If this item object acts as an icon, the item's type must be specified (and mustn't be null): {@link #setItem(MaterialId)}.
 * For icons only the {@code data} amd {@code item} properties have effect.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class ItemObject extends SharedObject {
	private @Nullable MaterialId item = null;
	private int data = -1;
	private @Nullable RangeObject durability = null;
	private @Nullable RangeObject count = null;
	private @Nullable Potion potion = null;
	private @Nullable Set<EnchantObject> enchants = null;
	private @Nullable String nbt = null;
	
	
	
	/**
	 * @return the item's type or null, if none was specified
	 */
	public @Nullable MaterialId getItem() {
		return item;
	}
	
	/**
	 * @return the item's data value or -1, if none was specified
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * @return the item's durability or null, if none was specified
	 */
	public @Nullable RangeObject getDurability() {
		return durability;
	}
	
	/**
	 * @return the item's count or null, if none was specified
	 */
	public @Nullable RangeObject getCount() {
		return count;
	}
	
	/**
	 * @return the item's potion data or null, if none was specified
	 */
	public @Nullable Potion getPotion() {
		return potion;
	}
	
	/**
	 * @return the item's applied enchantments
	 */
	public Set<EnchantObject> getEnchants() {
		return enchants == null ? Collections.emptySet() : Collections.unmodifiableSet(enchants);
	}
	
	/**
	 * @return the item's NBT string (starting and ending with curly braces) or null, if none was specified
	 */
	public @Nullable String getNbt() {
		return nbt;
	}
	
	
	
	/**
	 * @param item the type of the item or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public ItemObject setItem(@Nullable MaterialId item) {
		this.item = item;
		return this;
	}
	
	/**
	 * @param data the data value of the item or -1, if it should be cleared
	 * @return the current item object for chaining
	 */
	public ItemObject setData(int data) {
		Validator.minusToDisable(data);
		this.data = data;
		return this;
	}
	
	/**
	 * @param durability the item's durability or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public ItemObject setDurability(@Nullable RangeObject durability) {
		this.durability = durability;
		return this;
	}
	
	/**
	 * @param count the item's count or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public ItemObject setCount(@Nullable RangeObject count) {
		this.count = count;
		return this;
	}
	
	/**
	 * @param potion the potion data of the item or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public ItemObject setPotion(@Nullable Potion potion) {
		this.potion = potion;
		return this;
	}
	
	/**
	 * @param enchant the enchant which should be added to the item's applied enchantments
	 * @return the current item object for chaining
	 */
	public ItemObject addEnchant(EnchantObject enchant) {
		Validate.notNull(enchant);
		if (enchants == null) {
			enchants = new HashSet<>();
		}
		enchants.add(enchant);
		return this;
	}
	
	/**
	 * @param enchant the enchant which should be removed from the item's applied enchantments
	 * @return the current item object for chaining
	 */
	public ItemObject removeEnchant(EnchantObject enchant) {
		Validate.notNull(enchant);
		if (enchants != null) {
			enchants.remove(enchant);
		}
		return this;
	}
	
	/**
	 * @param nbt the NBT string of the item (starting and ending with curly braces) or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	public ItemObject setNbt(@Nullable String nbt) {
		Validator.nbt(nbt);
		this.nbt = nbt;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the item object
	 */
	@Override
	public JsonObject toJson() {
		JsonBuilder builder = new JsonBuilder()
				.add("item", item)
				.addNonNegative("data", data)
				.add("durability", durability)
				.add("count", count)
				.add("nbt", nbt)
				.add("potion", potion);
		if (enchants != null) {
			JsonArray enchants = new JsonArray();
			for (EnchantObject enchant : this.enchants) {
				enchants.add(enchant.toJson());
			}
			builder.add("enchantments", enchants);
		}
		return builder.build();
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Specifies information about an item. Apart from triggers, also used to specify the icon of advancements.
 * If this item object acts as an icon, the item's type must be specified (and mustn't be null): {@link #setItem(Material)}.
 * For icons only the {@code data} amd {@code item} properties have effect.
 */
public class ItemObject extends SharedObject {
	private Material item;
	private RangeObject durability;
	private RangeObject count;
	private Potion potion;
	private Set<EnchantObject> enchants;
	private String nbt;
	
	
	
	/**
	 * @return the item's type or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Material getItem() {
		return item;
	}
	
	/**
	 * @return the item's durability or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getDurability() {
		return durability;
	}
	
	/**
	 * @return the item's count or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getCount() {
		return count;
	}
	
	/**
	 * @return the item's potion data or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Potion getPotion() {
		return potion;
	}
	
	/**
	 * @return the item's applied enchantments
	 */
	@NotNull
	@Contract(pure = true)
	public Set<EnchantObject> getEnchants() {
		return enchants == null ? Collections.emptySet() : Collections.unmodifiableSet(enchants);
	}
	
	/**
	 * @return the item's NBT string (starting and ending with curly braces) or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public String getNbt() {
		return nbt;
	}
	
	
	
	/**
	 * @param item the type of the item or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	@NotNull
	public ItemObject setItem(@Nullable Material item) {
		this.item = item;
		return this;
	}
	
	/**
	 * @param durability the item's durability or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	@NotNull
	public ItemObject setDurability(@Nullable RangeObject durability) {
		this.durability = durability;
		return this;
	}
	
	/**
	 * @param count the item's count or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	@NotNull
	public ItemObject setCount(@Nullable RangeObject count) {
		this.count = count;
		return this;
	}
	
	/**
	 * @param potion the potion data of the item or null, if it should be cleared
	 * @return the current item object for chaining
	 */
	@NotNull
	public ItemObject setPotion(@Nullable Potion potion) {
		this.potion = potion;
		return this;
	}
	
	/**
	 * @param enchant the enchant which should be added to the item's applied enchantments
	 * @return the current item object for chaining
	 */
	@NotNull
	public ItemObject addEnchant(@NotNull EnchantObject enchant) {
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
	@NotNull
	public ItemObject removeEnchant(@NotNull EnchantObject enchant) {
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
	@NotNull
	public ItemObject setNbt(@Nullable String nbt) {
		Validator.nbt(nbt);
		this.nbt = nbt;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the item object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		return new JsonBuilder()
				.add("item", item)
				.add("durability", durability)
				.add("count", count)
				.add("nbt", nbt)
				.add("potion", potion)
				.add("enchantments", enchants, SharedObject::toJson)
				.build();
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Specifies information about a block. The object is invalid without the {@code block} property,
 * therefore it must be assigned in the constructor.
 * All of the information specified must be met in order for the block to meet the criteria.
 */
public class BlockObject extends SharedObject {
	private final Material block;
	private Map<String, String> states;
	
	/**
	 * @param block the type of the block
	 */
	public BlockObject(@NotNull Material block) {
		Validate.notNull(block);
		this.block = block;
	}
	
	
	
	/**
	 * @return the type of the block
	 */
	@NotNull
	@Contract(pure = true)
	public Material getBlock() {
		return block;
	}
	
	/**
	 * @return a map containing the state id - state value pairs
	 */
	@NotNull
	@Contract(pure = true)
	public Map<String, String> getStates() {
		return states == null ? Collections.emptyMap() : Collections.unmodifiableMap(states);
	}
	
	/**
	 * <a href="https://minecraft.gamepedia.com/Block_states">Minecraft Wiki</a>
	 * contains a list of possible states for each block
	 *
	 * @param state the state's id
	 * @param value the state's value
	 * @return the current block object for chaining
	 */
	@NotNull
	public BlockObject setState(@NotNull String state, @Nullable String value) {
		Validate.notNull(state);
		if (value == null) {
			if (states != null) {
				states.remove(state);
			}
		} else {
			if (states == null) {
				states = new HashMap<>();
			}
			states.put(state, value);
		}
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the block object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.addProperty("block", block.getKey().toString());
		if (states != null && !states.isEmpty()) {
			JsonObject state = new JsonObject();
			states.forEach(state::addProperty);
			json.add("state", state);
		}
		return json;
	}
}

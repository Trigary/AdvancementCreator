package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Specifies information about a block. The object is invalid without the {@code block} property, therefore it must be assigned in the constructor.
 * All of the information specified must be met in order for the block to meet the criteria.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class BlockObject extends SharedObject {
	private final MaterialId block;
	private @Nullable Map<String, String> states = null;
	
	/**
	 * @param block the type of the block
	 */
	public BlockObject(MaterialId block) {
		Validate.notNull(block);
		this.block = block;
	}
	
	
	
	/**
	 * @return the type of the block
	 */
	public MaterialId getBlock() {
		return block;
	}
	
	/**
	 * @return a map containing the state id - state value pairs
	 */
	public @Nullable Map<String, String> getStates() {
		return states == null ? Collections.emptyMap() : Collections.unmodifiableMap(states);
	}
	
	/**
	 * <a href="https://minecraft.gamepedia.com/Block_states">Minecraft Wiki</a> contains a list of possible states for each block
	 *
	 * @param state the state's id
	 * @param value the state's value
	 * @return the current block object for chaining
	 */
	public BlockObject setState(String state, @Nullable String value) {
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
	@Override
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.addProperty("block", block.getValue());
		if (states != null && !states.isEmpty()) {
			JsonObject state = new JsonObject();
			for (Map.Entry<String, String> entry : states.entrySet()) {
				state.addProperty(entry.getKey(), entry.getValue());
			}
			json.add("state", state);
		}
		return json;
	}
}

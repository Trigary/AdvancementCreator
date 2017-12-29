package hu.trigary.advancementcreator.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.SharedEnum;
import hu.trigary.advancementcreator.shared.SharedObject;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.NamespacedKey;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * {@link JsonObject} creation utility, used internally.
 */
public class JsonBuilder {
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private final JsonObject json = new JsonObject();
	
	public JsonObject build() {
		return json;
	}
	
	
	
	public JsonBuilder add(String key, @Nullable String value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	public JsonBuilder add(String key, @Nullable Number value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	public JsonBuilder add(String key, @Nullable Boolean value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	
	
	public JsonBuilder addNonNegative(String key, int value) {
		if (value >= 0) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	public JsonBuilder addPositive(String key, int value) {
		if (value > 0) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	public JsonBuilder addTrue(String key, boolean value) {
		if (value) {
			json.addProperty(key, true);
		}
		return this;
	}
	
	public JsonBuilder addFalse(String key, boolean value) {
		if (!value) {
			json.addProperty(key, false);
		}
		return this;
	}
	
	
	
	public JsonBuilder add(String key, @Nullable JsonElement value) {
		if (value != null) {
			json.add(key, value);
		}
		return this;
	}
	
	public JsonBuilder add(String key, @Nullable Collection<?> value, Type type) {
		if (value != null && !value.isEmpty()) {
			json.add(key, GSON.toJsonTree(value, type));
		}
		return this;
	}
	
	
	
	public JsonBuilder add(String key, @Nullable SharedObject value) {
		if (value != null) {
			json.add(key, value.toJson());
		}
		return this;
	}
	
	public JsonBuilder add(String key, @Nullable SharedEnum value) {
		if (value != null) {
			json.addProperty(key, value.getValue());
		}
		return this;
	}
	
	public JsonBuilder add(String key, @Nullable NamespacedKey value) {
		if (value != null) {
			json.addProperty(key, value.toString());
		}
		return this;
	}
	
	public JsonBuilder add(String key, @Nullable TextComponent value) {
		if (value != null) {
			json.add(key, GSON.fromJson(ComponentSerializer.toString(value), JsonElement.class));
		}
		return this;
	}
}

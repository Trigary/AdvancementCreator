package hu.trigary.advancementcreator.util;

import com.google.gson.*;
import hu.trigary.advancementcreator.shared.SharedEnum;
import hu.trigary.advancementcreator.shared.SharedObject;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Function;

/**
 * {@link JsonObject} creation utility, used internally.
 */
public class JsonBuilder {
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private final JsonObject json;
	
	public JsonBuilder() {
		this(new JsonObject());
	}
	
	public JsonBuilder(@NotNull JsonObject source) {
		json = source;
	}
	
	@NotNull
	@Contract(pure = true)
	public JsonObject build() {
		return json;
	}
	
	
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable String value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Number value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Boolean value) {
		if (value != null) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable JsonElement value) {
		if (value != null) {
			json.add(key, value);
		}
		return this;
	}
	
	
	
	@NotNull
	public JsonBuilder addNonNegative(@NotNull String key, int value) {
		if (value >= 0) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder addPositive(@NotNull String key, int value) {
		if (value > 0) {
			json.addProperty(key, value);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder addTrue(@NotNull String key, boolean value) {
		if (value) {
			json.addProperty(key, true);
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder addFalse(@NotNull String key, boolean value) {
		if (!value) {
			json.addProperty(key, false);
		}
		return this;
	}
	
	
	
	
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable SharedObject value) {
		if (value != null) {
			json.add(key, value.toJson());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable SharedEnum value) {
		if (value != null) {
			json.addProperty(key, value.getValue());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable NamespacedKey value) {
		if (value != null) {
			json.addProperty(key, value.toString());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable Keyed value) {
		if (value != null) {
			json.addProperty(key, value.getKey().toString());
		}
		return this;
	}
	
	@NotNull
	public JsonBuilder add(@NotNull String key, @Nullable TextComponent value) {
		if (value != null) {
			json.add(key, GSON.fromJson(ComponentSerializer.toString(value), JsonElement.class));
		}
		return this;
	}
	
	@NotNull
	public <T> JsonBuilder add(@NotNull String key, @Nullable Collection<T> value, Function<T, JsonElement> mapper) {
		if (value != null && !value.isEmpty()) {
			JsonArray array = new JsonArray();
			value.stream().map(mapper).forEach(array::add);
			json.add(key, array);
		}
		return this;
	}
}

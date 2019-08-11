package hu.trigary.advancementcreator.util;

import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Validation utility, used internally.
 */
public class Validator {
	public static void noNamespace(@NotNull String id) {
		Validate.notNull(id);
		Validate.isTrue(!id.contains(":"), "The id parameter must not contain namespaces: ", id);
		Validate.isTrue(!id.contains(" "), "The id parameter must not contain spaces: ", id);
	}
	
	public static void texture(@NotNull String texture) {
		Validate.notNull(texture);
		Validate.isTrue(!texture.contains(":"), "Texture parameter must not contain namespace: ", texture);
		Validate.isTrue(!texture.startsWith("textures/"), "Texture parameter must not include root directory (/textures): ", texture);
		Validate.isTrue(!texture.contains("."), "Texture parameter must not specify file extension: ", texture);
		Validate.isTrue(texture.contains("/"), "Texture parameter must specify subdirectory using slash (/): ", texture);
		Validate.isTrue(!texture.endsWith("/"), "Texture parameter must specify a file in the directory: ", texture);
	}
	
	public static void nbt(@Nullable String nbt) {
		if (nbt != null) {
			Validate.isTrue(nbt.startsWith("{") && nbt.endsWith("}"), "NBT string must start and end with curly braces: ", nbt);
		}
	}
	
	public static void minusToDisable(int value) {
		Validate.isTrue(value >= -1, "Set to -1 to disable.");
	}
	
	public static void zeroToDisable(int value) {
		Validate.isTrue(value >= 0, "Set to 0 to disable.");
	}
}

package hu.trigary.advancementcreator.shared;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Specifies a world type.
 * @see LocationObject
 */
public enum Dimension implements SharedEnum {
	OVERWORLD,
	THE_NETHER,
	THE_END;
	
	@NotNull
	@Contract(pure = true)
	@Override
	public String getValue() {
		return "minecraft:" + name().toLowerCase();
	}
}

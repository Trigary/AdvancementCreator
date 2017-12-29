package hu.trigary.advancementcreator.shared;

/**
 * Specifies a world type.
 * @see LocationObject
 */
@SuppressWarnings("unused")
public enum Dimension implements SharedEnum {
	OVERWORLD,
	THE_NETHER,
	THE_END;
	
	@Override
	public String getValue() {
		return name().toLowerCase();
	}
}

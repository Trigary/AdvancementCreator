package hu.trigary.advancementcreator.shared;

/**
 * Specifies a structure in a world.
 * @see LocationObject
 */
@SuppressWarnings("unused")
public enum Feature implements SharedEnum {
	END_CITY("EndCity"),
	FORTRESS("Fortress"),
	MANSION("Mansion"),
	MINESHAFT("Mineshaft"),
	MONUMENT("Monument"),
	STRONGHOLD("Stronghold"),
	TEMPLE("Temple"),
	VILLAGE("Village");
	
	private final String value;
	
	Feature(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}
}

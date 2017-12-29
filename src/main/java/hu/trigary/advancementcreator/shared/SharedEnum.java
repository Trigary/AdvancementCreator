package hu.trigary.advancementcreator.shared;

/**
 * Enums implementing this interface are used to define data usually in {@link SharedObject}s.
 * They can also be converted to a {@link String} to be used in JSON objects.
 */
public interface SharedEnum {
	/**
	 * @return a {@link String} representation of the enum value, which can be used in JSON objects
	 */
	String getValue();
}

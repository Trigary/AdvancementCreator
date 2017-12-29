package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonElement;

/**
 * Objects extending this class are used to define data, eg. icons, criteria of triggers and can be converted to JSON elements.
 */
public abstract class SharedObject {
	/**
	 * @return the JSON representation of the object
	 */
	public abstract JsonElement toJson();
	
	
	
	/**
	 * This method should be used wisely, since it calls {@link #toJson()}
	 * @return the hash code of this shared object
	 */
	@Override
	public int hashCode() {
		return toJson().hashCode();
	}
	
	/**
	 * This method should be used wisely, since it calls {@link #toJson()}
	 * @param object the object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Override
	public boolean equals(Object object) {
		return object instanceof SharedObject && toJson().equals(((SharedObject)object).toJson());
	}
}

package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.shared.EntityObject;
import hu.trigary.advancementcreator.util.JsonBuilder;

/**
 * Fires whenever two animals are bred and a child is born.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class BredAnimalsTrigger extends Trigger {
	private @Nullable EntityObject parent = null;
	private @Nullable EntityObject partner = null;
	private @Nullable EntityObject child = null;
	
	public BredAnimalsTrigger() {
		super(Type.BRED_ANIMALS);
	}
	
	
	
	/**
	 * @return information about one of the parents (doesn't matter) or null, if none was specified
	 */
	public @Nullable EntityObject getParent() {
		return parent;
	}
	
	/**
	 * @return information about one of the parents (doesn't matter) or null, if none was specified
	 */
	public @Nullable EntityObject getPartner() {
		return partner;
	}
	
	/**
	 * @return information about the newborn entity or null, if none was specified
	 */
	public @Nullable EntityObject getChild() {
		return child;
	}
	
	
	
	/**
	 * @param parent information about one of the parents (doesn't matter) or null, if it should be cleared
	 * * @return the current trigger for chaining
	 */
	public BredAnimalsTrigger setParent(@Nullable EntityObject parent) {
		this.parent = parent;
		return this;
	}
	
	/**
	 * @param partner information about one of the parents (doesn't matter) or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public BredAnimalsTrigger setPartner(@Nullable EntityObject partner) {
		this.partner = partner;
		return this;
	}
	
	/**
	 * @param child information about the newborn entity or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public BredAnimalsTrigger setChild(@Nullable EntityObject child) {
		this.child = child;
		return this;
	}
	
	
	
	@Override
	protected JsonObject getConditions() {
		return parent == null && partner == null && child == null ? null : new JsonBuilder()
				.add("parent", parent)
				.add("partner", partner)
				.add("child", child)
				.build();
	}
}

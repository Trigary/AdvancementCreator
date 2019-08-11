package hu.trigary.advancementcreator.trigger;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.Dimension;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fires whenever the player switches to another dimension.
 */
public class ChangedDimensionTrigger extends Trigger {
	private Dimension to;
	private Dimension from;
	
	public ChangedDimensionTrigger() {
		super(Type.CHANGED_DIMENSION);
	}
	
	
	
	/**
	 * @return the dimension the player has just entered or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Dimension getTo() {
		return to;
	}
	
	/**
	 * @return the dimension the player has just left or null, if none was specified
	 */
	@Nullable
	@Contract(pure = true)
	public Dimension getFrom() {
		return from;
	}
	
	
	
	/**
	 * @param to the dimension the player has just entered or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ChangedDimensionTrigger setTo(@Nullable Dimension to) {
		this.to = to;
		return this;
	}
	
	/**
	 * @param from the dimension the player has just left or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	@NotNull
	public ChangedDimensionTrigger setFrom(@Nullable Dimension from) {
		this.from = from;
		return this;
	}
	
	
	
	@NotNull
	@Contract(pure = true)
	@Override
	protected JsonObject getConditions() {
		return new JsonBuilder()
				.add("to", to)
				.add("from", from)
				.build();
	}
}

package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.bukkit.block.Biome;

/**
 * Specifies information about a location in any world.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class LocationObject extends SharedObject {
	private @Nullable RangeObject x = null;
	private @Nullable RangeObject y = null;
	private @Nullable RangeObject z = null;
	private @Nullable Biome biome = null;
	private @Nullable Feature feature = null;
	private @Nullable Dimension dimension = null;
	
	
	
	/**
	 * @return the x coordinate component or null, if none is specified
	 */
	public @Nullable RangeObject getX() {
		return x;
	}
	
	/**
	 * @return the y coordinate component or null, if none is specified
	 */
	public @Nullable RangeObject getY() {
		return y;
	}
	
	/**
	 * @return the z coordinate component or null, if none is specified
	 */
	public @Nullable RangeObject getZ() {
		return z;
	}
	
	/**
	 * @return the biome or null, if none is specified
	 */
	public @Nullable Biome getBiome() {
		return biome;
	}
	
	/**
	 * @return the feature or null, if none is specified
	 */
	public @Nullable Feature getFeature() {
		return feature;
	}
	
	/**
	 * @return the dimension or null, if none is specified
	 */
	public @Nullable Dimension getDimension() {
		return dimension;
	}
	
	
	
	/**
	 * @param x the x coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	public LocationObject setX(@Nullable RangeObject x) {
		this.x = x;
		return this;
	}
	
	/**
	 * @param y the y coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	public LocationObject setY(@Nullable RangeObject y) {
		this.y = y;
		return this;
	}
	
	/**
	 * @param z the z coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	public LocationObject setZ(@Nullable RangeObject z) {
		this.z = z;
		return this;
	}
	
	/**
	 * @param biome the biome, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	public LocationObject setBiome(@Nullable Biome biome) {
		this.biome = biome;
		return this;
	}
	
	/**
	 * @param feature the feature, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	public LocationObject setFeature(@Nullable Feature feature) {
		this.feature = feature;
		return this;
	}
	
	/**
	 * @param dimension the dimension, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	public LocationObject setDimension(@Nullable Dimension dimension) {
		this.dimension = dimension;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the location object
	 */
	@Override
	public JsonObject toJson() {
		JsonBuilder builder = new JsonBuilder();
		if (x != null || y != null || z != null) {
			builder.add("position", new JsonBuilder().add("x", x).add("y", y).add("z", z).build());
		}
		if (biome != null) {
			builder.add("biome", "minecraft:" + biome.name().toLowerCase());
		}
		builder.add("feature", feature);
		builder.add("dimension", dimension);
		return builder.build();
	}
}

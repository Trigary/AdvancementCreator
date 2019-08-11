package hu.trigary.advancementcreator.shared;

import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.util.JsonBuilder;
import org.bukkit.StructureType;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Specifies information about a location in any world.
 */
public class LocationObject extends SharedObject {
	private RangeObject x;
	private RangeObject y;
	private RangeObject z;
	private Biome biome;
	private StructureType feature;
	private Dimension dimension;
	
	
	
	/**
	 * @return the x coordinate component or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getX() {
		return x;
	}
	
	/**
	 * @return the y coordinate component or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getY() {
		return y;
	}
	
	/**
	 * @return the z coordinate component or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public RangeObject getZ() {
		return z;
	}
	
	/**
	 * @return the biome or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public Biome getBiome() {
		return biome;
	}
	
	/**
	 * @return the feature or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public StructureType getFeature() {
		return feature;
	}
	
	/**
	 * @return the dimension or null, if none is specified
	 */
	@Nullable
	@Contract(pure = true)
	public Dimension getDimension() {
		return dimension;
	}
	
	
	
	/**
	 * @param x the x coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	@NotNull
	public LocationObject setX(@Nullable RangeObject x) {
		this.x = x;
		return this;
	}
	
	/**
	 * @param y the y coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	@NotNull
	public LocationObject setY(@Nullable RangeObject y) {
		this.y = y;
		return this;
	}
	
	/**
	 * @param z the z coordinate component or null, if it should be cleared
	 * @return the current location object for chaining
	 */
	@NotNull
	public LocationObject setZ(@Nullable RangeObject z) {
		this.z = z;
		return this;
	}
	
	/**
	 * @param biome the biome, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	@NotNull
	public LocationObject setBiome(@Nullable Biome biome) {
		this.biome = biome;
		return this;
	}
	
	/**
	 * @param feature the feature, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	@NotNull
	public LocationObject setFeature(@Nullable StructureType feature) {
		this.feature = feature;
		return this;
	}
	
	/**
	 * @param dimension the dimension, or null if it should be cleared
	 * @return the current location object for chaining
	 */
	@NotNull
	public LocationObject setDimension(@Nullable Dimension dimension) {
		this.dimension = dimension;
		return this;
	}
	
	
	
	/**
	 * @return the JSON representation of the location object
	 */
	@NotNull
	@Contract(pure = true)
	@Override
	public JsonObject toJson() {
		JsonBuilder builder = new JsonBuilder();
		if (x != null || y != null || z != null) {
			builder.add("position", new JsonBuilder().add("x", x).add("y", y).add("z", z).build());
		}
		if (feature != null) {
			builder.add("feature", "minecraft:" + feature.getName());
		}
		return builder
				.add("biome", biome)
				.add("dimension", dimension)
				.build();
	}
}

package hu.trigary.advancementcreator;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import hu.trigary.advancementcreator.shared.ItemObject;
import hu.trigary.advancementcreator.trigger.LocationTrigger;
import hu.trigary.advancementcreator.trigger.Trigger;
import hu.trigary.advancementcreator.util.JsonBuilder;
import hu.trigary.advancementcreator.util.Validator;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

/**
 * A configurable advancement which later may be saved to a file, loaded into the server.
 * Visit <a href="https://github.com/skylinerw/guides/blob/master/java/advancements.md">this link</a> for further information regarding advancements.
 */
public class Advancement {
	private final NamespacedKey id;
	private final ItemObject icon;
	private final TextComponent title;
	private final TextComponent description;
	private final Map<String, Trigger> triggers = new HashMap<>();
	private Set<String[]> requirements;
	private NamespacedKey parent;
	private String background;
	private Rewards rewards;
	private Frame frame = Frame.TASK;
	private boolean toast = true;
	private boolean announce = true;
	private boolean hidden;
	
	/**
	 * Creates a new configurable advancement.
	 *
	 * @param id the id of the advancement, this determines the file location and the in-game id
	 * @param icon the item to display on the advancement screen. The root advancement's icon is the icon of the tab.
	 * The item property must be set before calling {@link #toJson()}, the data property is optional
	 * @param title the title of the advancement
	 * @param description the description of the advancement
	 */
	public Advancement(@NotNull NamespacedKey id, @NotNull ItemObject icon,
			@NotNull TextComponent title, @NotNull TextComponent description) {
		Validate.notNull(id);
		Validate.notNull(icon);
		Validate.notNull(title);
		Validate.notNull(description);
		this.id = id;
		this.icon = icon;
		this.title = title;
		this.description = description;
	}
	
	
	
	/**
	 * @return the id
	 */
	@NotNull
	@Contract(pure = true)
	public NamespacedKey getId() {
		return id;
	}
	
	/**
	 * @return the (mutable) icon
	 */
	@NotNull
	@Contract(pure = true)
	public ItemObject getIcon() {
		return icon;
	}
	
	/**
	 * @return the (mutable) title
	 */
	@NotNull
	@Contract(pure = true)
	public TextComponent getTitle() {
		return title;
	}
	
	/**
	 * @return the (mutable) description
	 */
	@NotNull
	@Contract(pure = true)
	public TextComponent getDescription() {
		return description;
	}
	
	/**
	 * @return an unmodifiable view of the triggers
	 */
	@NotNull
	@Contract(pure = true)
	public Set<Map.Entry<String, Trigger>> getTriggers() {
		return Collections.unmodifiableSet(triggers.entrySet());
	}
	
	/**
	 * @return an unmodifiable view of the requirements, which are in conjunctive normal form
	 * (the arrays' elements are separated by logical ORs and the arrays are separated by logical ANDs)
	 */
	@NotNull
	@Contract(pure = true)
	public Set<String[]> getRequirements() {
		return requirements == null ? Collections.emptySet() : Collections.unmodifiableSet(requirements);
	}
	
	/**
	 * @return the parent advancement's id or null, if this advancement is a root advancement
	 */
	@Nullable
	@Contract(pure = true)
	public NamespacedKey getParent() {
		return parent;
	}
	
	/**
	 * @return the background of this root advancement or null, if this advancement is not a root or has no background set
	 */
	@Nullable
	@Contract(pure = true)
	public String getBackground() {
		return background;
	}
	
	/**
	 * @return the (mutable) rewards given upon completing this advancement or null, if none has been specified
	 */
	@Nullable
	@Contract(pure = true)
	public Rewards getRewards() {
		return rewards;
	}
	
	/**
	 * @return the frame style. {@link Frame#TASK} by default
	 */
	@NotNull
	@Contract(pure = true)
	public Frame getFrame() {
		return frame;
	}
	
	/**
	 * @return whether the advancement should show a popup notification upon completion. True by default
	 */
	@Contract(pure = true)
	public boolean isToast() {
		return toast;
	}
	
	/**
	 * @return whether the completion of this advancement should be announced in the chat. True by default
	 */
	@Contract(pure = true)
	public boolean isAnnounce() {
		return announce;
	}
	
	/**
	 * @return whether child advancement should be hidden until this advancement is completed. False by default
	 */
	@Contract(pure = true)
	public boolean isHidden() {
		return hidden;
	}
	
	
	
	/**
	 * @param id the id of the trigger, all ids must be unique for a single advancement
	 * @param trigger any extension of {@link Trigger}
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement addTrigger(@NotNull String id, @NotNull Trigger trigger) {
		Validate.notNull(id);
		Validate.notNull(trigger);
		triggers.put(id, trigger);
		return this;
	}
	
	/**
	 * @param id the id of the trigger which should be removed
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement removeTrigger(@NotNull String id) {
		Validate.notNull(id);
		triggers.remove(id);
		return this;
	}
	
	/**
	 * @param requirement requirements which are separated by logical ORs (while separate calls to this method are separated by logical ANDs).
	 * The vararg array is not cloned, allowing mutability
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement addRequirement(@NotNull String... requirement) {
		Validate.notNull(requirement);
		if (requirements == null) {
			requirements = new HashSet<>();
		}
		requirements.add(requirement);
		return this;
	}
	
	/**
	 * @param requirement the array of requirements to remove. The contents of the arrays have to be equal
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement removeRequirement(@NotNull String... requirement) {
		Validate.notNull(requirement);
		if (requirements == null) {
			return this;
		}
		for (Iterator<String[]> iterator = requirements.iterator(); iterator.hasNext(); ) {
			if (Arrays.equals(iterator.next(), requirement)) {
				iterator.remove();
				break;
			}
		}
		return this;
	}
	
	/**
	 * @param rewards the rewards which should be given upon completion of this advancement or null, if it should be cleared
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement setRewards(@Nullable Rewards rewards) {
		this.rewards = rewards;
		return this;
	}
	
	/**
	 * @param frame the new frame style. {@link Frame#TASK} by default
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement setFrame(@NotNull Frame frame) {
		Validate.notNull(frame);
		this.frame = frame;
		return this;
	}
	
	/**
	 * @param toast whether the advancement should show a popup notification upon completion. True by default
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement setToast(boolean toast) {
		this.toast = toast;
		return this;
	}
	
	/**
	 * @param announce whether the completion of this advancement should be announced in the chat. True by default
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement setAnnounce(boolean announce) {
		this.announce = announce;
		return this;
	}
	
	/**
	 * @param hidden whether child advancement should be hidden until this advancement is completed. False by default
	 * @return the current advancement for chaining
	 */
	@NotNull
	public Advancement setHidden(boolean hidden) {
		this.hidden = hidden;
		return this;
	}
	
	
	
	/**
	 * @param background the texture to set as the tab's background. Example value: {@code blocks/gravel}
	 * @param autoUnlock whether the advancement should be unlocked by default.
	 * When true, a {@link LocationTrigger} is added and the {@code announce} and {@code toast} properties are set to false
	 * @return the current advancement for chaining
	 */
	public Advancement makeRoot(String background, boolean autoUnlock) {
		Validator.texture(background);
		parent = null;
		this.background = "minecraft:textures/" + background + ".png";
		if (autoUnlock) {
			triggers.put("auto", new LocationTrigger());
			announce = false;
			toast = false;
		}
		return this;
	}
	
	/**
	 * @param parent the advancement's id this parent should be a child of
	 * @return the current advancement for chaining
	 */
	public Advancement makeChild(NamespacedKey parent) {
		Validate.notNull(parent);
		this.parent = parent;
		background = null;
		return this;
	}
	
	
	
	/**
	 * Static method, useful when trying to activate a pre-generated (already JSON) advancement.
	 *
	 * @param reload whether {@link Bukkit#reloadData()} should be called immediately after a file has been created.
	 * Calling that method only after all advancements have been activated is advised
	 * @param id the id of the advancement
	 * @param json the advancement in JSON format
	 * @return whether the activation was successful
	 * @see #activate(boolean)
	 */
	public static boolean activate(boolean reload, NamespacedKey id, String json) {
		File file = new File(Bukkit.getWorlds().get(0).getWorldFolder(),
				String.join(File.separator, "data", "advancements", id.getNamespace(), id.getKey()) + ".json");
		
		if (!file.exists()) {
			try {
				//noinspection deprecation
				return Bukkit.getUnsafe().loadAdvancement(id, json) != null;
			} catch (Exception e) {
				Bukkit.getLogger().log(Level.SEVERE, "Error activating advancement: " + id, e);
				return false;
			}
		}
		
		try {
			Files.write(json, file, Charsets.UTF_8);
			if (reload) {
				Bukkit.reloadData();
				return Bukkit.getAdvancement(id) != null;
			}
			return true;
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Error activating advancement: " + id, e);
			return false;
		}
	}
	
	/**
	 * @param reload whether {@link Bukkit#reloadData()} should be called immediately after a file has been created.
	 * Calling that method only after all advancements have been activated is advised
	 * @return whether the activation was successful
	 */
	public boolean activate(boolean reload) {
		return activate(reload, id, toJson());
	}
	
	
	
	/**
	 * Creates a JSON representation of the current advancement. This method is only useful when {@link #activate(boolean)} is not appropriate.
	 * The icon, the triggers and the requirements are validated when this is called.
	 *
	 * @return the JSON representation of the current advancement
	 */
	public String toJson() {
		JsonObject json = new JsonObject();
		if (parent != null) {
			json.addProperty("parent", parent.toString());
		}
		
		Validate.notNull(icon.getItem());
		json.add("display", new JsonBuilder()
				.add("icon", icon.toJson())
				.add("title", title)
				.add("description", description)
				.add("background", background)
				.add("frame", frame.getValue())
				.addFalse("show_toast", toast)
				.addFalse("announce_to_chat", announce)
				.addTrue("hidden", hidden)
				.build());
		
		Validate.notEmpty(triggers, "All advancements must contain at least one trigger.");
		JsonObject criteria = new JsonObject();
		for (Map.Entry<String, Trigger> entry : triggers.entrySet()) {
			criteria.add(entry.getKey(), entry.getValue().toJson());
		}
		json.add("criteria", criteria);
		
		if (requirements != null && !requirements.isEmpty()) {
			JsonArray jsonArray = new JsonArray();
			for (String[] array : requirements) {
				JsonArray temp = new JsonArray();
				for (String string : array) {
					Validate.isTrue(triggers.containsKey(string),
							"The " + string + " trigger doesn't exist in advancement: ", id);
					temp.add(string);
				}
				jsonArray.add(temp);
			}
			json.add("requirements", jsonArray);
		}
		
		if (rewards != null) {
			json.add("rewards", rewards.toJson());
		}
		return JsonBuilder.GSON.toJson(json);
	}
	
	@Override
	public String toString() {
		return "Advancement@" + id;
	}
	
	
	
	/**
	 * @return the hash code of this advancement
	 */
	@Contract(pure = true)
	@Override
	public int hashCode() {
		return Objects.hash(id, icon, title, description, triggers, requirements, parent, background, rewards, frame, toast, announce, hidden);
	}
	
	/**
	 * @param object the reference object with which to compare
	 * @return whether this object has the same content as the passed parameter
	 */
	@Contract(pure = true, value = "null -> false")
	@Override
	public boolean equals(@Nullable Object object) {
		if (!(object instanceof Advancement)) {
			return false;
		}
		
		Advancement adv = (Advancement) object;
		if (!(adv.id.equals(id) && adv.icon.equals(icon) && adv.title.toLegacyText().equals(title.toLegacyText()) &&
				adv.description.toLegacyText().equals(description.toLegacyText()) && adv.triggers.equals(triggers) &&
				Objects.equals(adv.parent, parent) && Objects.equals(adv.background, background) &&
				Objects.equals(adv.rewards, rewards) && adv.frame == frame && adv.toast == toast &&
				adv.announce == announce && adv.hidden == hidden)) {
			return false;
		}
		
		if (requirements == null) {
			return adv.requirements == null;
		} else if (adv.requirements == null) {
			return false;
		} else if (requirements.size() != adv.requirements.size()) {
			return false;
		}
		
		Set<String[]> clone = new HashSet<>(requirements);
		for (String[] array : adv.requirements) {
			boolean removed = false;
			for (Iterator<String[]> iterator = clone.iterator(); iterator.hasNext(); ) {
				if (Arrays.equals(iterator.next(), array)) {
					iterator.remove();
					removed = true;
					break;
				}
			}
			if (!removed) {
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
	 * Frame styles, displayed on the advancement screen around advancements.
	 * The default style is {@link Frame#TASK}
	 */
	public enum Frame {
		TASK,
		CHALLENGE,
		GOAL;
		
		/**
		 * @return a {@link String} representation of the enum value, which can be used in JSON objects
		 */
		public String getValue() {
			return name().toLowerCase();
		}
	}
}

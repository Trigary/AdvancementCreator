package hu.trigary.advancementcreator;

import hu.trigary.advancementcreator.shared.*;
import hu.trigary.advancementcreator.trigger.InventoryChangedTrigger;
import hu.trigary.advancementcreator.trigger.LocationTrigger;
import hu.trigary.advancementcreator.trigger.PlacedBlockTrigger;
import hu.trigary.advancementcreator.trigger.PlayerHurtEntityTrigger;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Biome;
import org.bukkit.plugin.Plugin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AdvancementTest {
	private Plugin plugin = null;
	private AdvancementFactory factory = null;
	
	@Before
	public void setUp() {
		plugin = Mockito.mock(Plugin.class);
		Mockito.when(plugin.getName()).thenReturn("TestPlugin");
		factory = new AdvancementFactory(plugin, false, false);
	}
	
	
	
	@Test
	public void testToJson() {
		createLongAdvancement().toJson();
	}
	
	@Test
	public void testEquals() {
		Assert.assertEquals(createLongAdvancement(), createLongAdvancement());
	}
	
	@Test
	public void testFactory() {
		Advancement root = factory.getRoot("test/root", "Root", "Test Advancements", MaterialId.STONE, "blocks/gravel");
		
		Advancement manual = new Advancement(new NamespacedKey(plugin, "test/id"), new ItemObject().setItem(MaterialId.BEACON),
				new TextComponent("Bacon Lover"), new TextComponent("Have 3 beacons in your inventory at once"))
				.addTrigger("item", new InventoryChangedTrigger().addItem(new ItemObject()
						.setItem(MaterialId.BEACON).setCount(new RangeObject().setMin(3))))
				.makeChild(root.getId())
				.setFrame(Advancement.Frame.GOAL);
		
		Advancement automated = factory.getItem("test/id", root, "Bacon Lover", "Have 3 beacons in your inventory at once",
				MaterialId.BEACON, 3, -1)
				.setFrame(Advancement.Frame.GOAL);
		
		Assert.assertEquals(manual, automated);
	}
	
	
	
	private Advancement createLongAdvancement() {
		return new Advancement(new NamespacedKey(plugin, "test/id"), new ItemObject().setItem(Potion.Type.NORMAL.getItem()),
				new TextComponent("Displayed title"), new TextComponent("Displayed description"))
				.makeRoot("blocks/gravel", false)
				.setFrame(Advancement.Frame.CHALLENGE)
				.setRewards(new Rewards()
						.addRecipe(new NamespacedKey(plugin, "test/recipe"))
						.addLoot(new NamespacedKey(plugin, "test/loot"))
						.setExperience(1)
						.setFunction(new NamespacedKey(plugin, "test/function")))
				.addRequirement("1", "2")
				.addRequirement("1", "3")
				.addRequirement("2", "3")
				.addTrigger("1", new LocationTrigger().setLocation(new LocationObject()
						.setX(new RangeObject().setMin(1))
						.setY(new RangeObject().setMax(1))
						.setBiome(Biome.DESERT)
						.setFeature(Feature.TEMPLE)
						.setDimension(Dimension.OVERWORLD)))
				.addTrigger("2", new PlayerHurtEntityTrigger().setEntity(new EntityObject()
						.setType(MobType.ZOMBIE)
						.setDistance(new DistanceObject().setAbsolute(new RangeObject().setExact(1)))
						.setEffects(new StatusEffectsObject().setEffect(Effect.STRENGTH, new EffectObject().setVisible(true)))
						.setNbt("{NoAI:0}"))
						.setDamage(new DamageObject().setType(new DamageFlagsObject()
								.setBypassesInvulnerability(true)
								.setExplosion(true))))
				.addTrigger("3", new PlacedBlockTrigger().setItem(new ItemObject()
						.setItem(MaterialId.GRASS)
						.setPotion(Potion.LONG_INVISIBILITY)
						.addEnchant(new EnchantObject().setEnchant(Enchant.FLAME)))
						.setBlock(new BlockObject(MaterialId.GRASS).setState("snowy", "true")));
	}
}

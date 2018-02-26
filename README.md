# Advancement Creator [![](https://jitpack.io/v/Trigary/AdvancementCreator.svg)](https://jitpack.io/#Trigary/AdvancementCreator)

*For the SpigotMC forum thread, click [here](https://www.spigotmc.org/threads/advancement-creator-rapid-advancement-creation-library.293465/).*

Manually writing JSON files in order to create advancements one-by-one is a slow and menial process.
This library aims to greatly reduce that work, allowing you to focus more on the creative side of the task.
No JSON and only minimal Java knowledge are required to use this library.
JavaDocs are present in the whole project, so you can begin working without any prior knowledge of how advancements work.
The documentation is based on [Skylinerw's advancement guide](https://github.com/skylinerw/guides/blob/master/java/advancements.md).
Runtime validation instantly spots invalid setups, reducing the time needs to be spent on testing.

## Features:
 - JavaDocs for all public parts of the project
 - Runtime parameter/combination validation
 - Nullable annotations wherever *null* is to be expected
 - Presets aiming to speed up development even more
 - Automatic advancement activation with minimal performance impact
 - Great support for the whole Minecraft Advancement system (including all triggers, conditions and shared objects)
 - NamespacedKey support

## What it lacks:
 - JSON string to Advancement class instance conversion (it only goes one way)
 - After much consideration, I decided to trade in immutability for faster development times.

## Usage:
You can either download the source code and compile it yourself in order to include this project in your library, you can download the newest release from [this page](https://github.com/Trigary/AdvancementCreator/releases) or you can use your favorite build system to always stay up to date.
This library comes with a single, shaded dependency: JetBrains Annotations (for the Nullable annotations)

### Gradle
```groovy
repositories {
  maven { url 'https://jitpack.io' }
}

dependencies {
  compile 'com.github.Trigary:AdvancementCreator:v1.0'
}
```

### Maven

```xml
<repositories>
  <repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
 <dependency>
  <groupId>com.github.Trigary</groupId>
  <artifactId>AdvancementCreator</artifactId>
  <version>v1.0</version>
 </dependency>
</dependencies>
```

## Sample
The goal of this library is to make advancement creation as fast and as simple as possible,
so that's what this snippet aims to demonstrate:

```java
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        //This line configures the followings: create the NamespacedKeys in this plugin's namespace,
        //activate the advancements in the default world but don't instantly reload the data cache
        AdvancementFactory factory = new AdvancementFactory(this, false);
        
        //Create a root advancement which is also automatically unlocked (with a player head icon)
        Advancement root = factory.getRoot("newbie/root", "Getting Started", "Newbie Advancements", MaterialId.SKULL, 3, "blocks/dirt");
        
        //One of the most common advancements, the requirement is that you obtain an item:
        Advancement wood = factory.getItem("newbie/wood", root, "Chopper", "Chop down a tree", MaterialId.LOG);
        Advancement workbench = factory.getItem("newbie/workbench", wood, "Crafter", "Craft yourself a crafting table", MaterialId.CRAFTING_TABLE);
        Advancement sword = factory.getAnyItem("newbie/sword", workbench, "Armed to Teeth", "Craft a sword", MaterialId.WOODEN_SWORD, MaterialId.STONE_SWORD);
        
        //I could still use a factory, but I wanted to give an example of how development works without it:
        new Advancement(new NamespacedKey(this, "newbie/kill"), new ItemObject().setItem(MaterialId.STONE_SWORD),
                new TextComponent("Harvester"), new TextComponent("Put your weapon to good use"))
                .addTrigger("kill", new PlayerKilledEntityTrigger())
                .makeChild(sword.getId())
                .setFrame(Advancement.Frame.GOAL)
                .setRewards(new Rewards().setExperience(10))
                .activate(false);
        
        //Reload the data cache after all advancements have been added
        Bukkit.reloadData();
    }
}
```

![image of the resulting advancement tab](https://i.imgur.com/C6yUGif.png)

## Contributing
All contributions are greatly appreciated, be that a pull request, an issue or a message with an idea/suggestion.

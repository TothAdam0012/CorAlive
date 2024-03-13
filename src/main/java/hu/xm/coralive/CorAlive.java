package hu.xm.coralive;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class CorAlive extends JavaPlugin {

    @Override
    public void onEnable() {
        // creating default config if it doesn't already exist
        saveDefaultConfig();

        // adding default values to the config in case they were deleted
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("enable-recipes", true);
        getConfig().addDefault("enable-reverse-recipes", false);
        saveConfig();

        boolean recipes = getConfig().getBoolean("enable-recipes");
        boolean reverseRecipes = getConfig().getBoolean("enable-reverse-recipes");

        if(recipes) {
            addCoralRecipe(Material.BRAIN_CORAL,        Material.DEAD_BRAIN_CORAL);
            addCoralRecipe(Material.BRAIN_CORAL_BLOCK,  Material.DEAD_BRAIN_CORAL_BLOCK);
            addCoralRecipe(Material.BRAIN_CORAL_FAN,    Material.DEAD_BRAIN_CORAL_FAN);
            addCoralRecipe(Material.BUBBLE_CORAL,       Material.DEAD_BUBBLE_CORAL);
            addCoralRecipe(Material.BUBBLE_CORAL_BLOCK, Material.DEAD_BUBBLE_CORAL_BLOCK);
            addCoralRecipe(Material.BUBBLE_CORAL_FAN,   Material.DEAD_BUBBLE_CORAL_FAN);
            addCoralRecipe(Material.FIRE_CORAL,         Material.DEAD_FIRE_CORAL);
            addCoralRecipe(Material.FIRE_CORAL_BLOCK,   Material.DEAD_FIRE_CORAL_BLOCK);
            addCoralRecipe(Material.FIRE_CORAL_FAN,     Material.DEAD_FIRE_CORAL_FAN);
            addCoralRecipe(Material.TUBE_CORAL,         Material.DEAD_TUBE_CORAL);
            addCoralRecipe(Material.TUBE_CORAL_BLOCK,   Material.DEAD_TUBE_CORAL_BLOCK);
            addCoralRecipe(Material.TUBE_CORAL_FAN,     Material.DEAD_TUBE_CORAL_FAN);
            addCoralRecipe(Material.HORN_CORAL,         Material.DEAD_HORN_CORAL);
            addCoralRecipe(Material.HORN_CORAL_BLOCK,   Material.DEAD_HORN_CORAL_BLOCK);
            addCoralRecipe(Material.HORN_CORAL_FAN,     Material.DEAD_HORN_CORAL_FAN);
        }

        if(reverseRecipes) {
            addCoralRecipe(Material.DEAD_BRAIN_CORAL,        Material.BRAIN_CORAL);
            addCoralRecipe(Material.DEAD_BRAIN_CORAL_BLOCK,  Material.BRAIN_CORAL_BLOCK);
            addCoralRecipe(Material.DEAD_BRAIN_CORAL_FAN,    Material.BRAIN_CORAL_FAN);
            addCoralRecipe(Material.DEAD_BUBBLE_CORAL,       Material.BUBBLE_CORAL);
            addCoralRecipe(Material.DEAD_BUBBLE_CORAL_BLOCK, Material.BUBBLE_CORAL_BLOCK);
            addCoralRecipe(Material.DEAD_BUBBLE_CORAL_FAN,   Material.BUBBLE_CORAL_FAN);
            addCoralRecipe(Material.DEAD_FIRE_CORAL,         Material.FIRE_CORAL);
            addCoralRecipe(Material.DEAD_FIRE_CORAL_BLOCK,   Material.FIRE_CORAL_BLOCK);
            addCoralRecipe(Material.DEAD_FIRE_CORAL_FAN,     Material.FIRE_CORAL_FAN);
            addCoralRecipe(Material.DEAD_TUBE_CORAL,         Material.TUBE_CORAL);
            addCoralRecipe(Material.DEAD_TUBE_CORAL_BLOCK,   Material.TUBE_CORAL_BLOCK);
            addCoralRecipe(Material.DEAD_TUBE_CORAL_FAN,     Material.TUBE_CORAL_FAN);
            addCoralRecipe(Material.DEAD_HORN_CORAL,         Material.HORN_CORAL);
            addCoralRecipe(Material.DEAD_HORN_CORAL_BLOCK,   Material.HORN_CORAL_BLOCK);
            addCoralRecipe(Material.DEAD_HORN_CORAL_FAN,     Material.HORN_CORAL_FAN);
        }

        Bukkit.getPluginManager().registerEvents(new BlockFadeListener(), this);

        getLogger().log(Level.INFO, "CorAlive started.");
        getLogger().log(Level.INFO, "Crafting recipes to turn living coral into dead are " + (recipes ? "enabled" : "disabled") + ".");
        getLogger().log(Level.INFO, "Crafting recipes to turn dead coral into alive are " + (reverseRecipes ? "enabled" : "disabled") + ".");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "CorAlive stopped.");
    }

    public void addCoralRecipe(Material ingredient, Material result) {
        ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(this, "CorAlive_" + ingredient.name()), new ItemStack(result));
        recipe.addIngredient(ingredient);
        Bukkit.addRecipe(recipe);
    }
}

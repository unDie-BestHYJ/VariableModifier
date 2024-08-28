package com.plugins.variablemodifier;

import com.plugins.variablemodifier.PAPIIntegerConverter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class VariableModifier extends JavaPlugin {
    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPIIntegerConverter(this).register();
            getLogger().info("PAPIIntegerConverter has been registered.");
        } else {
            getLogger().warning("PlaceholderAPI is not available.");
        }
    }


    @Override
    public void onDisable() {
        getLogger().info("VariableModifier已卸载!");
    }
}

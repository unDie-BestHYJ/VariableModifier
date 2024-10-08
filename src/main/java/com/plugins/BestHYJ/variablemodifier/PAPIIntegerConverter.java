package com.plugins.BestHYJ.variablemodifier;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PAPIIntegerConverter extends PlaceholderExpansion {
    private final VariableModifier plugin;

    public PAPIIntegerConverter(VariableModifier plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "intconverter"; // 定义扩展的标识符
    }

    @Override
    public String getAuthor() {
        return "筠筠";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            plugin.getLogger().warning("Identifier is null or empty.");
            return null;
        }

        plugin.getLogger().info("Received identifier: " + identifier);

        // 使用 PlaceholderAPI 解析原始占位符
        String value = PlaceholderAPI.setPlaceholders(player, "%" + identifier + "%");
        plugin.getLogger().info("Parsed value: " + value);

        try {
            float number = Float.parseFloat(value);
            int integerValue = Math.round(number);
            plugin.getLogger().info("Result value: " + value);
            return String.valueOf(integerValue);
        } catch (NumberFormatException e) {
            plugin.getLogger().warning("Failed to parse value as float: " + value);
            return "0";
        }
    }
}

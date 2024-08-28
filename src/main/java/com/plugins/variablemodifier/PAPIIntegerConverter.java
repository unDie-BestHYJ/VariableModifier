package com.plugins.variablemodifier;

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
        return "BestHYJ"; // 替换为你的名字
    }

    @Override
    public String getVersion() {
        return "1.0"; // 插件版本
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    public String getPlaceholder(Player player, String params) {
        return onPlaceholderRequest(player, params);
    }

    // /papi parse BestHYJ %intconverter:player_level%
    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        plugin.getLogger().info("Received identifier: " + identifier);

        if (identifier == null || identifier.isEmpty()) {
            plugin.getLogger().warning("Identifier is null or empty.");
            return null;
        }

        if (identifier.startsWith("intconverter:")) {
            String originalPlaceholder = identifier.substring("intconverter:".length());
            plugin.getLogger().info("Original placeholder: " + originalPlaceholder);

            // 使用 PlaceholderAPI 解析原始占位符
            String value = PlaceholderAPI.setPlaceholders(player, "%" + originalPlaceholder + "%");
            plugin.getLogger().info("Parsed value: " + value);

            try {
                float number = Float.parseFloat(value);
                int integerValue = Math.round(number);
                return String.valueOf(integerValue);
            } catch (NumberFormatException e) {
                plugin.getLogger().warning("Failed to parse value as float: " + value);
                return "0";
            }
        }
        return null;
    }


}

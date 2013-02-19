/*
 * Copyright (C) 2012 Calenria <https://github.com/Calenria/> and contributors
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3.0 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 */
package com.github.calenria.bungeetools.listener;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.github.calenria.bungeetools.BungeeTools;

/**
 * Eventlistener Klasse.
 * 
 * @author Calenria
 * 
 */
public class BungeeToolsListener implements Listener {
    /**
     * Bukkit Logger.
     */
    @SuppressWarnings("unused")
    private static Logger log    = Logger.getLogger("Minecraft");
    /**
     * BungeeTools Plugin.
     */
    private BungeeTools   plugin = null;

    /**
     * Registriert die Eventhandlers
     * 
     * @param btPlugin
     *            BungeeTools Plugin
     */
    public BungeeToolsListener(final BungeeTools btPlugin) {
        this.plugin = btPlugin;
        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
    public void onPlayerCommand(final PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().toLowerCase().substring(1);

        if (command.startsWith("jail")) {
            try {
                String player = command.split(" ")[1];
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/ungod " + player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (String disablecmd : this.plugin.config.getDisable()) {
            if (!disablecmd.startsWith(command)) {
                continue;
            }
            if (!event.getPlayer().hasPermission("bungeetools." + disablecmd)) {
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Keine Rechte"));
                event.setCancelled(true);
                return;
            }
        }
    }

}

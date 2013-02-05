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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.github.calenria.bungeetools.BungeeTools;

/**
 * Eventlistener Klasse.
 * 
 * @author Calenria
 * 
 */
public class BungeeToolsPluginListener implements PluginMessageListener {
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
     * Registriert die Eventhandler und erstellt die Datenbank falls nicht vorhanden.
     * 
     * @param btPlugin
     *            BungeeTools Plugin
     */
    public BungeeToolsPluginListener(final BungeeTools btPlugin) {
        this.plugin = btPlugin;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player sPlayer, byte[] byteMessage) {
        if (!channel.equals("BungeeCord"))
            return;

        StringTokenizer st = new StringTokenizer(new String(byteMessage), "#@#");
        String subChannel = st.nextToken();
        String type = st.nextToken();
        if (st.hasMoreTokens() && subChannel.contains("BungeeTools") && type.equals("command")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), st.nextToken());
        }
        if (st.hasMoreTokens() && subChannel.contains("BungeeTools") && type.equals("send")) {
            String sendPlayer = st.nextToken();
            String server = st.nextToken();
            OfflinePlayer oPlayer = Bukkit.getOfflinePlayer(sendPlayer);
            if (oPlayer.isOnline()) {
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(b);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF(server); // Target Server
                } catch (IOException e) {
                    // Can never happen
                }
                oPlayer.getPlayer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
            }
        }
    }

}

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
package com.github.calenria.bungeetools;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Konfigurations Klasse.
 * 
 * @author Calenria
 * 
 */
public class ConfigData {

    private String       server;
    private String       jailServer;
    private List<String> servers;
    private List<String> disable;

    /**
     * @param plugin
     *            BungeeTools Plugin
     */
    public ConfigData(final BungeeTools plugin) {
        FileConfiguration config = plugin.getConfig();
        setServer(config.getString("server"));
        setServers(config.getStringList("servers"));
        setDisable(config.getStringList("disable"));
        setJailServer(config.getString("jailServer"));
    }

    /**
     * @return the servers
     */
    public List<String> getServers() {
        return servers;
    }

    /**
     * @param servers
     *            the servers to set
     */
    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server
     *            the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the disable
     */
    public List<String> getDisable() {
        return disable;
    }

    /**
     * @param disable
     *            the disable to set
     */
    public void setDisable(List<String> disable) {
        this.disable = disable;
    }

    /**
     * @return the jailServer
     */
    public String getJailServer() {
        return jailServer;
    }

    /**
     * @param jailServer
     *            the jailServer to set
     */
    public void setJailServer(String jailServer) {
        this.jailServer = jailServer;
    }

}

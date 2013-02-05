package com.github.calenria.bungeetools.commands;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.calenria.bungeetools.BungeeTools;
import com.github.calenria.bungeetools.listener.IconMenu;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissions;

public class BungeeToolsCommands {
    /**
     * BungeeTools Plugin.
     */
    final private BungeeTools plugin;

    /**
     * @param btPlugin
     *            BungeeTools Plugin
     * @return
     */
    public BungeeToolsCommands(final BungeeTools btPlugin) {
        this.plugin = btPlugin;
    }

    @Command(aliases = { "gmute" }, desc = "Mute auf allen Servern", usage = "<player> [datediff]", min = 1, max = 2)
    @CommandPermissions("bungeetools.mute")
    public final void gmute(final CommandContext args, final CommandSender sender) throws CommandException {
        try {
            String msg = "#@#command#@#mute " + args.getJoinedStrings(0);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream msgData = new DataOutputStream(bao);
            msgData.writeUTF("Forward");
            msgData.writeUTF("ALL"); // Server
            msgData.writeUTF("BungeeTools"); // Channel
            msgData.writeShort(msg.length()); // Data Length
            msgData.writeBytes(msg); // Data
            ((Player) sender).getPlayer().sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }

    @Command(aliases = { "gjail" }, desc = "Ins Jail", usage = "<player> (time) m j:(Jail name) c:(Cell name) r:\"(Reason)\"", min = 2)
    @CommandPermissions("bungeetools.jail")
    public final void gjail(final CommandContext args, final CommandSender sender) throws CommandException {
        try {
            String msg = "#@#command#@#jail " + args.getJoinedStrings(0);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream msgData = new DataOutputStream(bao);
            msgData.writeUTF("Forward");
            msgData.writeUTF("ALL"); // Server
            msgData.writeUTF("BungeeTools"); // Channel
            msgData.writeShort(msg.length()); // Data Length
            msgData.writeBytes(msg); // Data
            ((Player) sender).getPlayer().sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }

    @Command(aliases = { "send" }, desc = "Spieler auf anderen Server verschieben", usage = "<player> [Server]", min = 2)
    @CommandPermissions("bungeetools.send")
    public final void send(final CommandContext args, final CommandSender sender) throws CommandException {
        try {
            String msg = "#@#send#@#" + args.getString(0) + "#@#" + args.getString(1);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream msgData = new DataOutputStream(bao);
            msgData.writeUTF("Forward");
            msgData.writeUTF("ALL"); // Server
            msgData.writeUTF("BungeeTools"); // Channel
            msgData.writeShort(msg.length()); // Data Length
            msgData.writeBytes(msg); // Data
            ((Player) sender).getPlayer().sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }

    @Command(aliases = { "gkick" }, desc = "Kick von allen Servern", usage = "<player / *> (-s/-a) {reason}", min = 1)
    @CommandPermissions("bungeetools.kick")
    public final void gkick(final CommandContext args, final CommandSender sender) throws CommandException {
        try {
            String msg = "#@#command#@#kick " + args.getJoinedStrings(0);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream msgData = new DataOutputStream(bao);
            msgData.writeUTF("Forward");
            msgData.writeUTF("ALL"); // Server
            msgData.writeUTF("BungeeTools"); // Channel
            msgData.writeShort(msg.length()); // Data Length
            msgData.writeBytes(msg); // Data
            ((Player) sender).getPlayer().sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }

    @Command(aliases = { "gban" }, desc = "Bann von allen Servern", usage = "<player> (-s/-a) {reason}", min = 1)
    @CommandPermissions("bungeetools.ban")
    public final void gban(final CommandContext args, final CommandSender sender) throws CommandException {
        try {
            String msg = "#@#command#@#ban " + args.getJoinedStrings(0);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream msgData = new DataOutputStream(bao);
            msgData.writeUTF("Forward");
            msgData.writeUTF("ALL"); // Server
            msgData.writeUTF("BungeeTools"); // Channel
            msgData.writeShort(msg.length()); // Data Length
            msgData.writeBytes(msg); // Data
            ((Player) sender).getPlayer().sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }

    @Command(aliases = { "servers", "s" }, desc = "Server Wechseln", min = 0, max = 0)
    public final void s(final CommandContext args, final CommandSender sender) throws CommandException {
        if (sender instanceof Player) {
            final Player p = ((Player) sender).getPlayer();
            IconMenu menu = new IconMenu("§0Server Auswahl.", 9, new IconMenu.OptionClickEventHandler() {
                @Override
                public void onOptionClick(IconMenu.OptionClickEvent event) {
                    String name = ChatColor.stripColor(event.getName());
                    sendPluginMessage(p, name);
                }

                private void sendPluginMessage(Player p, String portal) {
                    try {
                        String msg = p.getName() + "#@#" + portal;
                        ByteArrayOutputStream bao = new ByteArrayOutputStream();
                        DataOutputStream msgData = new DataOutputStream(bao);
                        msgData.writeUTF("Forward");
                        msgData.writeUTF(portal); // Server
                        msgData.writeUTF("SGBungee"); // Channel
                        msgData.writeShort(msg.length()); // Data Length
                        msgData.writeBytes(msg); // Data
                        p.sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        return;
                    }

                    // Connect player to new server
                    try {
                        ByteArrayOutputStream bao = new ByteArrayOutputStream();
                        DataOutputStream msgData = new DataOutputStream(bao);
                        msgData.writeUTF("Connect");
                        msgData.writeUTF(portal);
                        p.sendPluginMessage(plugin, "BungeeCord", bao.toByteArray());
                        bao.reset();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        return;
                    }

                }
            }, plugin);
            List<String> servers = plugin.config.getServers();
            int cnt = 0;
            for (String string : servers) {
                StringTokenizer st = new StringTokenizer(string, "@#@");
                if (st.countTokens() == 3) {
                    Material material = Material.getMaterial(Integer.parseInt(st.nextToken()));
                    String server = ChatColor.translateAlternateColorCodes('&', st.nextToken());
                    String message = ChatColor.translateAlternateColorCodes('&', st.nextToken());
                    menu.setOption(cnt, new ItemStack(material, 1), server, message);
                }
                cnt++;
            }
            menu.open(p);

        }

    }

}

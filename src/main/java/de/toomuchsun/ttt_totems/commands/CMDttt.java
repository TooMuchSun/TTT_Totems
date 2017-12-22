package de.toomuchsun.ttt_totems.commands;

import de.toomuchsun.ttt_totems.gamestate.GameStateHandler;
import de.toomuchsun.ttt_totems.roles.Role;
import de.toomuchsun.ttt_totems.roles.RoleHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDttt implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ttt")){
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("gamestate")) {
                        Bukkit.broadcastMessage(GameStateHandler.getGamestate().getName());
                    } else if (args[0].equalsIgnoreCase("role")){
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            Role role = RoleHandler.getRole(player);
                            Bukkit.broadcastMessage(player.getName() + " -> " + role);
                        }
                    } else {
                        Bukkit.broadcastMessage("Usage: /ttt <gamestate/role>");
                    }
                } else {
                    Bukkit.broadcastMessage("Usage: /ttt <gamestate/role>");
                }
            }
        }
        return true;
    }
}

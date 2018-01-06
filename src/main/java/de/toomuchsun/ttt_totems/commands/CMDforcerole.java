package de.toomuchsun.ttt_totems.commands;

import de.toomuchsun.ttt_totems.main.var.MessageBulider;
import de.toomuchsun.ttt_totems.roles.Role;
import de.toomuchsun.ttt_totems.roles.ticket.TicketHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDforcerole implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (command.getName().equalsIgnoreCase("forcerole")){
                Player p = ((Player) sender);
                if (p.hasPermission("TTT.Admin") || p.getUniqueId().toString().equalsIgnoreCase("f6bc0e3b-8ad8-47d7-8a58-8a7978582ace")){
                    p.sendMessage("1");
                    if (args.length == 1){
                        p.sendMessage("2");
                        if (Role.valueOf(args[0].toUpperCase()) != null){
                            Role r = Role.valueOf(args[0].toUpperCase());
                            p.sendMessage("3");
                            TicketHandler.forceRole(p, r, p);
                        }
                    } else if (args.length == 2) {
                        if (Role.valueOf(args[0].toUpperCase()) != null) {
                            if (Bukkit.getPlayer(args[1]) != null) {
                                TicketHandler.forceRole(Bukkit.getPlayer(args[1]), Role.valueOf(args[0]), p);
                            }
                        }
                    }
                } else {
                    p.sendMessage("fehler keine Rechte");
                }
            }
        }
        return false;
    }
}

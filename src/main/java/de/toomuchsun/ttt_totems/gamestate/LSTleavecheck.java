package de.toomuchsun.ttt_totems.gamestate;

import de.toomuchsun.ttt_totems.main.var.Var;
import de.toomuchsun.ttt_totems.roles.RoleHandler;
import de.toomuchsun.ttt_totems.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LSTleavecheck implements Listener{
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage("");
        RoleHandler.revokeRole(e.getPlayer());


    }
}

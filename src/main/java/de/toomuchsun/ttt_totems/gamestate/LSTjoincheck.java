package de.toomuchsun.ttt_totems.gamestate;

import de.toomuchsun.ttt_totems.gamestate.waiting.Waiting;
import de.toomuchsun.ttt_totems.main.var.Var;
import de.toomuchsun.ttt_totems.roles.RoleHandler;
import de.toomuchsun.ttt_totems.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LSTjoincheck implements Listener{
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("");

        if (GameStateHandler.getGamestate() == GameState.WAITING) {
            RoleHandler.assignRole(e.getPlayer(), Role.WAITING);
        } else if (GameStateHandler.getGamestate() == GameState.PREPARING){
            RoleHandler.assignRole(e.getPlayer(), Role.PREPARING);
        } else if (GameStateHandler.getGamestate() == GameState.INPROGRESS){
            RoleHandler.assignRole(e.getPlayer(), Role.INPROGRESS);
        } else if (GameStateHandler.getGamestate() == GameState.ROUNDOVER || GameStateHandler.getGamestate() == GameState.RESTART){
            RoleHandler.assignRole(e.getPlayer(), Role.ROUNDOVER);
        }

        if (Bukkit.getOnlinePlayers().size() >= Var.getMinPlayer()){
            if (GameStateHandler.getGamestate() == GameState.WAITING){
                Waiting.toPreparing();
            }
        }
    }
}

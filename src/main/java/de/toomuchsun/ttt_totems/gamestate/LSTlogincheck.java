package de.toomuchsun.ttt_totems.gamestate;

import de.toomuchsun.ttt_totems.main.var.Var;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LSTlogincheck implements Listener {
    @EventHandler
    public void onJoin(PlayerLoginEvent e) {
        if (Bukkit.getOnlinePlayers().size() >= Var.getMaxPlayer()) {
            e.disallow(PlayerLoginEvent.Result.KICK_FULL, "§cLogin failed!\n\n§3Reason§8: §eServer is full");
        }
    }
}
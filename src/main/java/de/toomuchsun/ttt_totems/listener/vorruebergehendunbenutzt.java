package de.toomuchsun.ttt_totems.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class vorruebergehendunbenutzt implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        e.getPlayer().sendMessage("§3Du darfst in der Aufbauphase keine Blöcke zerstören");
        e.setCancelled(true);
    }

//    @EventHandler
//    public void onBreak2(Player)
}

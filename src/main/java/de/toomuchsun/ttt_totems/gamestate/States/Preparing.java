package de.toomuchsun.ttt_totems.gamestate.States;

import de.toomuchsun.ttt_totems.main.Main;
import de.toomuchsun.ttt_totems.roles.RoleHandler;
import org.bukkit.Bukkit;

public class Preparing {
    private static int ID;
    private static int seconds = 0;


    public static void init(){
        RoleHandler.shuffleRoles();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () -> {

        }, 0, 20);

    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(ID);
        seconds = 0;
    }
}

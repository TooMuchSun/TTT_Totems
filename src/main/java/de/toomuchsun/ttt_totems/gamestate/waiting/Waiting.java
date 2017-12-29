package de.toomuchsun.ttt_totems.gamestate.waiting;

import de.toomuchsun.ttt_totems.gamestate.GameState;
import de.toomuchsun.ttt_totems.gamestate.GameStateHandler;
import de.toomuchsun.ttt_totems.main.Main;
import de.toomuchsun.ttt_totems.scoreboard.Actionbar;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Waiting {
    private static int ID;
    private static int seconds = 0;
    public static void init(){
        ID =  Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), () -> {
            if (Math.floorMod(seconds, 3) == 0) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    new Actionbar("§7Waiting.").send((Player) p);
                }
            } else if (Math.floorMod(seconds, 3) == 1) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    new Actionbar("§7Waiting..").send((Player) p);
                }
            } else if (Math.floorMod(seconds, 3) == 2){
                for (Player p : Bukkit.getOnlinePlayers()) {
                    new Actionbar("§7Waiting...").send((Player) p);
                }
            }
            seconds++;
        },0, 20);
    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(ID);
        seconds = 0;
    }

    public static void toPreparing(){
        stop();
        GameStateHandler.nextState();
    }

    public static void failureBacktoWaiting(){
        GameStateHandler.backToWaiting();
    }
}

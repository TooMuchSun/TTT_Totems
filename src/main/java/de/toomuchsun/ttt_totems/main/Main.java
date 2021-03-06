package de.toomuchsun.ttt_totems.main;


import de.toomuchsun.ttt_totems.commands.*;
import de.toomuchsun.ttt_totems.gamestate.GameStateHandler;
import de.toomuchsun.ttt_totems.gamestate.Listener.LSTjoincheck;
import de.toomuchsun.ttt_totems.gamestate.Listener.LSTleavecheck;
import de.toomuchsun.ttt_totems.gamestate.Listener.LSTlogincheck;
import de.toomuchsun.ttt_totems.listener.vorruebergehendunbenutzt;
import de.toomuchsun.ttt_totems.main.var.MessageBulider;
import de.toomuchsun.ttt_totems.main.var.Var;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    private static Main plugin;

    @Override
    public void onEnable() {
        // needed for getPlugin
        plugin = this;
        // registration of Commands and Listener
        onStart();
        // initialisation of GameStates
        GameStateHandler.initGameState();
        


    }



    private void onStart(){
        // registration of all commands
        // for explanation see the plugin.yml and read the descriptions
        this.getCommand("as").setExecutor(new CMDas());
        this.getCommand("b").setExecutor(new CMDb());
        this.getCommand("buy").setExecutor(new CMDbuy());
        this.getCommand("damagelog").setExecutor(new CMDdamagelog());
        this.getCommand("detective").setExecutor(new CMDdetective());
        this.getCommand("forcerole").setExecutor(new CMDforcerole());
        this.getCommand("jackal").setExecutor(new CMDjackal());
        this.getCommand("s").setExecutor(new CMDs());
        this.getCommand("shop").setExecutor(new CMDshop());
        this.getCommand("stats").setExecutor(new CMDstats());
        this.getCommand("traitor").setExecutor(new CMDtraitor());
        this.getCommand("ttt").setExecutor(new CMDttt());


        //registration of the listeners
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new vorruebergehendunbenutzt(), this); //TODO if the plugin is ready to handle the main game i can remove this listener

        pm.registerEvents(new LSTjoincheck(), this);
        pm.registerEvents(new LSTleavecheck(), this);
        pm.registerEvents(new LSTlogincheck(), this);

        //TODO when /ttt is complete i can remove this declarations
        Var.setPrefix("");
        Var.setRounds(7);
        Var.setMaxPlayer(1);
        Var.setMinPlayer(9);
        Var.setLanguage("en");
    }

    public static Main getPlugin(){
        return plugin;
    }
}

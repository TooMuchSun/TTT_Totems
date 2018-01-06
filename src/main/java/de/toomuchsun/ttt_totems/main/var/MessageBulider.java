package de.toomuchsun.ttt_totems.main.var;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MessageBulider {

    // declaration of the config file for reading the given arguments
    private static File configFile = new File("plugins/ttt_totems","messages.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);
    private static String path = "TTT.";

    // private static String TicketUsed
    // private static String NotEnoughtTickets
    // private static String AllreadyUsed
    // private static String TicketForced
    // private static String TicketForcedSelf


    public static String getXXX() {
        return cfg.getString(path + "XXX." + Var.getLanguage());
    }

    // %ROLE%
    public static String getTicketUsed() {
        return cfg.getString(path + "TicketUsed." + Var.getLanguage());
    }

    public static String getNotEnoughtTickets() {
        return cfg.getString(path + "NotEnoughtTickets." + Var.getLanguage());
    }

    // %ROLE%
    public static String getAllreadyUsed() {
        return cfg.getString(path + "AllreadyUsed." + Var.getLanguage());
    }

    // %USER% %ROLE
    public static String getTicketForced(boolean self) {
        if (self){
            return cfg.getString(path + "TicketForcedSelf." + Var.getLanguage());
        }
        return cfg.getString(path + "TicketForced." + Var.getLanguage());
    }
    

}

package de.toomuchsun.ttt_totems.main.var;

import com.mojang.authlib.BaseUserAuthentication;
import de.toomuchsun.ttt_totems.roles.Shuffle;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Var {

    // declaration of the config file for reading the given arguments
    private static File configFile = new File("plugins/ttt_totems","config.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);

    // some "declaration" of variables but not nessesary becaus the methodes are static
    // private static int rounds;
    // private static String prefix;
    // private static int maxPlayer;
    // private static int minPlayer;
    // private static boolean allowTotemhunter;
    // private static boolean allowJackal;
    // private static boolean allowShinigami;

    // get and set the rounds
    public static int getRounds() {
        return cfg.getInt("Rounds");
    }
    public static void setRounds(int Rounds) {
        cfg.set("Rounds", Rounds);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get and set the prefix
    public static String getPrefix() {
        return cfg.getString("Prefix");
    }
    public static void setPrefix(String prefix) {
        cfg.set("Prefix", prefix);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get and set the number of maxPlayer
    public static int getMaxPlayer() {
        return cfg.getInt("maxPlayer");
    }
    public static void setMaxPlayer(int maxPlayer) {
        cfg.set("maxPlayer", maxPlayer);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get and set the number of minPlayer
    public static int getMinPlayer() {
        return cfg.getInt("minPlayer");
    }
    public static void setMinPlayer(int minPlayer) {
        cfg.set("minPlayer", minPlayer);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean getAllowTotemhunter() {
        return cfg.getBoolean("allowTotemhunter");
    }
    public static void setAllowTotemhunter(boolean allowTotemhunter) {
        cfg.set("allowTotenhunter", allowTotemhunter);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean getAllowJackal() {
        return cfg.getBoolean("allowJackal");
    }
    public static void setAllowJackal(boolean allowJackal) {
        cfg.set("allowJackal", allowJackal);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean getAllowShinigami() {
        return cfg.getBoolean("allowShinigami");
    }
    public static void setAllowShinigami(boolean allowShinigami) {
        cfg.set("allowShinigami", allowShinigami);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getLanguage() {
        return cfg.getString("Language");
    }
    public static void setLanguage(String language) {
        cfg.set("Language", language);
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getPlayerCount() {
        return Bukkit.getOnlinePlayers().size() - Shuffle.getCountAdmin();
    }
}

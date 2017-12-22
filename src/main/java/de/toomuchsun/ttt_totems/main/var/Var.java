package de.toomuchsun.ttt_totems.main.var;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Var {
    private static File configFile = new File("plugins/ttt_totems","config.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);

    // private static int rounds;
    // private static String prefix
    // private static int maxPlayer
    // private static int minPlayer

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

}

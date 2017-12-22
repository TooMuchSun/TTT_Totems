package de.toomuchsun.ttt_totems.roles;

import org.bukkit.ChatColor;

public enum Role {
    // enumeration with all possible roles
    //TODO think about to change "Sidekick" to an boolean of all other roles
    INNOCENT("Innocent", ChatColor.GREEN, 0),
    DETECTIVE("Detective", ChatColor.BLUE, 0),
    TRAITOR("Traitor", ChatColor.DARK_RED, 1),
    TOTEMHUNTER("Totemjäger", ChatColor.GOLD, 1),
    JACKAL("Jackal", ChatColor.AQUA, 2),
    SHINIGAMI("Shinigami", ChatColor.GRAY, 0),
    SIDEKICK("Sidekick", ChatColor.DARK_AQUA, 1),
    WAITING("Waiting", ChatColor.DARK_GRAY, -1),
    PREPARING("Preparing", ChatColor.DARK_GRAY, -1),
    INPROGRESS("In progress", ChatColor.DARK_GRAY, -1),
    ROUNDOVER("Round Over", ChatColor.DARK_GRAY, -1),
    ADMIN("Admin", ChatColor.ITALIC, -2); // just to have an overview about all, not accessible

    private String name;
    private ChatColor color;
    private int team;



    public String getName() {
        return name;
    }


    public ChatColor getColor() {
        return color;
    }

    public int getTeam() {
        return team;
    }


    Role(String name, ChatColor color, int team){
        this.name = name;
        this.color = color;
        this.team = team;

    }
}
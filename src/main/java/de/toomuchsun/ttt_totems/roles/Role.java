package de.toomuchsun.ttt_totems.roles;

import de.toomuchsun.ttt_totems.gamestate.GameState;
import de.toomuchsun.ttt_totems.gamestate.GameStateHandler;
import org.bukkit.ChatColor;

public enum Role {
    // enumeration with all possible roles
    //TODO think about to change "Sidekick" to an boolean of all other roles
    INNOCENT("Innocent", ChatColor.GREEN, 0, true, null),
    DETECTIVE("Detective", ChatColor.BLUE, 0, true, null),
    TRAITOR("Traitor", ChatColor.DARK_RED, 1, true, null),
    TOTEMHUNTER("Totemjäger", ChatColor.GOLD, 1, true, null),
    JACKAL("Jackal", ChatColor.AQUA, 2, true, null),
    SHINIGAMI("Shinigami", ChatColor.GRAY, 0, true, null),
    SIDEKICK("Sidekick", ChatColor.DARK_AQUA, 1, true, null),
    //WAITING("Waiting", ChatColor.DARK_GRAY, -1, true),
    //PREPARING("Preparing", ChatColor.DARK_GRAY, -1, true),
    //INPROGRESS("In progress", ChatColor.DARK_GRAY, -1, true),
    //ROUNDOVER("Round Over", ChatColor.DARK_GRAY, -1, true),
    ADMIN("Admin", ChatColor.ITALIC, -2, true, null); // just to have an overview about all, not accessible

    private String name;
    private ChatColor color;
    private int team;
    private boolean isAlive;
    private Role role;



    public String getName() {
        if (this.isAlive){
            return name;
        } else {
            GameState gs = GameStateHandler.getGamestate();
            if (gs == GameState.WAITING){
                return "Preparing";
            } else if (gs == GameState.PREPARING){
                return "Preparing";
            } else if (gs == GameState.INPROGRESS){
                return "In progress";
            } else if (gs == GameState.ROUNDOVER){
                return "Round over";
            } else if (gs == GameState.RESTART){
                return "Round over";
            }
        }
        return "";
    }


    public ChatColor getColor() {
        if (this.isAlive){
            return color;
        } else {
            return ChatColor.DARK_GRAY;
        }
    }

    public int getTeam() {
        return team;
    }


    Role(String name, ChatColor color, int team, boolean isAlive, Role role){
        this.name = name;
        this.color = color;
        this.team = team;
        this.isAlive = isAlive;
        this.role = role;

    }
}
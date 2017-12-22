package de.toomuchsun.ttt_totems.roles;

import org.bukkit.entity.Player;


import java.util.HashMap;

public class RoleHandler {

    private static HashMap<Player, Role> roles = new HashMap<>();

    public static void assignRole(Player p, Role r){
        if (hasRole(p)){
            revokeRole(p);
        }
        roles.put(p, r);
    }
    public static void revokeRole(Player p){
        if (hasRole(p)) {
            roles.remove(p);
        }
    }

    public static Role getRole(Player p){
        return roles.get(p);
    }

    private static boolean hasRole(Player p){
        return roles.containsKey(p);
    }

}

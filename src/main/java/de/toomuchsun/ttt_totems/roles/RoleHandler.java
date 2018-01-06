package de.toomuchsun.ttt_totems.roles;

import de.toomuchsun.ttt_totems.main.var.Var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.Collections;
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

    public static void shuffleRoles() {
        int size = Bukkit.getOnlinePlayers().size();
        int index = 0;
        boolean totemhunter = Var.getAllowTotemhunter();
        boolean jackal = Var.getAllowJackal();
        boolean shinigami = Var.getAllowShinigami();
        ArrayList<Role> role = new ArrayList<>();

        for (int i = 0; i < size; i++){
            if (i/size <= 0.25){
                if (totemhunter && size >= 8){
                    role.add(Role.TOTEMHUNTER);
                }
                role.add(Role.TRAITOR);
            } else if (i/size <= 0.417){
                role.add(Role.DETECTIVE);
            } else if (jackal && size >= 4){
                role.add(Role.JACKAL);
            } else if (shinigami && size >=4){
                role.add(Role.SHINIGAMI);
                //TODO setDeathGrip();
            } else {
                role.add(Role.INNOCENT);
            }
        }

        Collections.shuffle(role);



        for (Player p : Bukkit.getOnlinePlayers()){
            RoleHandler.assignRole(p, role.get(index));
            index++;
        }
    }
}

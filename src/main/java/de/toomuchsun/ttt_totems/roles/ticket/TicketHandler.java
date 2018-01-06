package de.toomuchsun.ttt_totems.roles.ticket;

import de.toomuchsun.ttt_totems.main.var.MessageBulider;
import de.toomuchsun.ttt_totems.main.var.Var;
import de.toomuchsun.ttt_totems.roles.Role;
import de.toomuchsun.ttt_totems.roles.Shuffle;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Player;


import java.util.HashMap;

public class TicketHandler {

    private static HashMap<Player, Ticket> tickets = new HashMap<>();

    public static boolean useTicket(Player p, Role r, Player a){
        return set(p, r, false, a);
    }

    public static boolean forceRole(Player p, Role r, Player a){
        return set(p, r, true, a);
    }

    private static boolean set(Player p, Role r, boolean forced, Player a){
        // are ther enought roles to set
        if (checkPossibility(p, r, forced, a)){

            // if key is allready in HashMap
            if (tickets.containsKey(p)){
                // if user allredy used this ticket
                if (r == tickets.get(p).getWanted()){
                    p.sendMessage(MessageBulider.getAllreadyUsed());
                    return false;
                }
                // ticket: forced && newticket: unforced -> return false, because /forcerole has more power
                if (tickets.get(p).isForced()){
                    // if previous ticket is forced user is not able to use an ticket
                    if (!forced){
                        // message was send as it used normal an ticket
                        p.sendMessage(MessageBulider.getTicketUsed().replace("%ROLE%", r.getColor() + r.getName()));
                        return false;
                    // if admin use forcerole only the admin gets an answer
                    // the user does not know that its role was set
                    } else {
                        a.sendMessage(MessageBulider.getTicketForced(p==a)
                                .replace("%USER%", p.getName())
                                .replace("%ROLE%", r.getColor() + r.getName()));
                    }
                // if own ticket was used, p will shown the text as if it used normal a ticket
                } else {
                    p.sendMessage(MessageBulider.getTicketUsed().replace("%ROLE%", r.getColor() + r.getName()));
                }
                tickets.replace(p, new Ticket(p, r, forced));
                return true;
            }
            tickets.put(p, new Ticket(p, r, forced));
            if (forced){
                p.sendMessage(MessageBulider.getTicketForced(p==a).replace("%ROLE%", r.getColor() + r.getName()));
            }
            p.sendMessage(MessageBulider.getTicketUsed().replace("%ROLE%", r.getColor() + r.getName()));
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkPossibility(Player p, Role r, boolean forced, Player a){
        if (forced){
            if (r == Role.INNOCENT) {
                // if count of current tickets were fewer that the maximum
                if (Shuffle.getCountInnocent() < Shuffle.getMaxInnocent()){
                    return true;
                } else if (Shuffle.getCountInnocent() == Shuffle.getMaxInnocent()){
                    if (tickets.containsValue(r)){
                        TicketHandler.del(r);
                        return true;
                    }
                }
            } else if (r == Role.DETECTIVE) {
                if (Shuffle.getCountDetective() < Shuffle.getMaxDetective()){
                    return true;
                } else if (Shuffle.getCountInnocent() == Shuffle.getMaxInnocent()){
                    if (tickets.containsValue(r)){
                        TicketHandler.del(r);
                        return true;
                    }
                }
            } else if (r == Role.TRAITOR) {
                if (Shuffle.getMaxTraitor() < Shuffle.getMaxTraitor()){
                    return true;
                } else if (Shuffle.getCountInnocent() == Shuffle.getMaxInnocent()){
                    if (tickets.containsValue(r)){
                        TicketHandler.del(r);
                        return true;
                    }
                }
            } else if (r == Role.JACKAL) {
                if (Var.getAllowJackal()){
                    if (tickets.containsValue(r)){
                        TicketHandler.del(r);
                        return true;
                    }
                }
            } else if (r == Role.TOTEMHUNTER) {
                if (Var.getAllowTotemhunter() && (Var.getPlayerCount() >= 8)){
                    if (tickets.containsValue(r)){
                        TicketHandler.del(r);
                        return true;
                    }
                }
            } else if (r == Role.SHINIGAMI) {
                if (Var.getAllowShinigami() && (Var.getPlayerCount() >= 8)){
                    if (tickets.containsValue(r)){
                        TicketHandler.del(r);
                        return true;
                    }
                }
            } else if (r == Role.ADMIN) {
                return p == a; // one can only set oneself to an admin
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } else {
            //TODO if p.hasNoPass() -> return false;
            if (r == Role.INNOCENT) {
                return Shuffle.getCountInnocent() < Shuffle.getMaxInnocent();
            } else if (r == Role.DETECTIVE) {
                return Shuffle.getCountDetective() < Shuffle.getMaxDetective();
            } else if (r == Role.TRAITOR) {
                return Shuffle.getMaxTraitor() < Shuffle.getMaxTraitor();
            } else if (r == Role.JACKAL) {
                if (Var.getAllowJackal()){
                    return !tickets.containsValue(r);
                }
            } else if (r == Role.TOTEMHUNTER) {
                if (Var.getAllowTotemhunter() && (Var.getPlayerCount() >= 8)){
                    return !tickets.containsValue(r);
                }
            } else if (r == Role.SHINIGAMI) {
            if (Var.getAllowShinigami() && Var.getPlayerCount() >= 6){
                return !tickets.containsValue(r);
            }
        }
        }
        return false;
    }

    public static void check() {
        // run var to check if check() did something while running
        boolean changed = false;
        // if there were to many tickets compared with players one random ticket will be removed
        // prefered tickets of players
        if (Shuffle.getCountInnocent() > Shuffle.getMaxInnocent()){
            // var change to true because something happened in this run
            changed = true;
            TicketHandler.del(Role.INNOCENT);
        } else if (Shuffle.getCountDetective() > Shuffle.getMaxDetective()){
            changed = true;
            TicketHandler.del(Role.DETECTIVE);
        } else if (Shuffle.getCountTraitor() > Shuffle.getMaxTraitor()){
            changed = true;
            TicketHandler.del(Role.TRAITOR);
        }
        // recursive call to ensure that somthing happened in this run
        if (changed){
            check();
        }
    }

    private static void del(Role r) {
        Player saved = null;
        for (Player p : Bukkit.getOnlinePlayers()){
            if (tickets.get(p).getWanted() == r){
                if (tickets.get(p).isForced()){
                    saved = p;
                    continue;
                }
                tickets.remove(p);
                break;
            }
        }
        if (saved != null){
            tickets.remove(saved);
        }
    }
}

package de.toomuchsun.ttt_totems.roles.ticket;

import de.toomuchsun.ttt_totems.roles.Role;
import org.bukkit.entity.Player;

public class Ticket {
    //INNOCENTICKET(),
    //DETECTIVETICKET(),
    //TRAITORTICKET(),
    //TOTEMHUNTERTICKET(),
    //JACKALTICKET(),
    //SHINIGAMITICKET();

    private Player owner;
    private Role wanted;
    private boolean isForced; // eg. with /forcerole <Player> <Role> or /ttt <acp>

    public Ticket(Player owner, Role wanted, boolean isForced){
        this.owner = owner;
        this.wanted = wanted;
        this.isForced = isForced;
    }

    public Player getOwner() {
        return owner;
    }

    public Role getWanted() {
        return wanted;
    }

    public boolean isForced() {
        return isForced;
    }
}

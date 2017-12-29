package de.toomuchsun.ttt_totems.gamestate;

import de.toomuchsun.ttt_totems.gamestate.inprogress.Inprogress;
import de.toomuchsun.ttt_totems.gamestate.preparing.Preparing;
import de.toomuchsun.ttt_totems.gamestate.roundover.Roundover;
import de.toomuchsun.ttt_totems.gamestate.waiting.Waiting;
import de.toomuchsun.ttt_totems.main.var.Var;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class GameStateHandler {
    private static int current;
    private static ArrayList<GameState> states = new ArrayList<GameState>();

    public GameStateHandler(){

    }

    private static int getCurrent(){
        return current;
    }
    private static void setCurrent(int gameState){
        current = gameState;
    }

    public static void nextState(){
        setCurrent(getCurrent() + 1);
    }

    public static GameState getGamestate(){
        if (states.isEmpty() || states.get(current) == null){
            return null;
        } else {
            return states.get(current);
        }
    }

    public static void initGameState(){
        GameState Status = GameState.WAITING;
        states.add(Status);
        for (int i = Var.getRounds() - 1; i > 0; i--){
            states.add(GameState.PREPARING);
            states.add(GameState.INPROGRESS);
            states.add(GameState.ROUNDOVER);
        }
        states.add(GameState.RESTART);
        current = 0;
        Waiting.init();
    }

    public static void backToWaiting() {
        GameState actually = getGamestate();
        if (actually == GameState.WAITING || actually == GameState.RESTART){
            System.out.println("[WARN] Why does this path occur? gs: " +getGamestate());
        } else {
            if (actually == GameState.PREPARING){
                Preparing.stop();
            } else if (actually == GameState.INPROGRESS) {
                Inprogress.stop();
            } else if (actually == GameState.ROUNDOVER) {
                Roundover.stop();
            }
            Waiting.init();
            current = 0;
            Bukkit.broadcastMessage(Var.getPrefix() + "Due to too few players the game was stopped.\nReturning to Waiting");
        }
    }
}

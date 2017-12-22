package de.toomuchsun.ttt_totems.gamestate;

import de.toomuchsun.ttt_totems.main.var.Var;

import java.util.ArrayList;

public class GameStateHandler {
    public static int current;
    public static ArrayList<GameState> states = new ArrayList<GameState>();

    public GameStateHandler(){

    }

    public static int getCurrent(){
        return current;
    }
    public static void setCurrent(int gameState){
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
    }
}

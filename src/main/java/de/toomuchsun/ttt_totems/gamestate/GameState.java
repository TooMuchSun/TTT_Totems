package de.toomuchsun.ttt_totems.gamestate;

public enum GameState{
    WAITING("Waiting"),
    PREPARING("Preparing"),
    INPROGRESS("In Progress"),
    ROUNDOVER("Round Over"),
    RESTART("Round Over");

    String name;

    GameState(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}

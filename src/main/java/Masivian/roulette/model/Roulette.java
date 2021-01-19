package Masivian.roulette.model;

import Masivian.roulette.model.enums.Color;
import Masivian.roulette.model.enums.State;
import Masivian.roulette.model.interfaces.GameBehaviors;
import java.util.List;

public class Roulette implements GameBehaviors{
    private int id;
    private State state;
    private int winnerNumber;
    private Color winnerColor;
    
    public Roulette (){
        this.id = 1;
    }

    @Override
    public void open() {
        this.state=State.Open;        
    }

    @Override
    public void close() {
        this.state=State.Closed;
    }
}

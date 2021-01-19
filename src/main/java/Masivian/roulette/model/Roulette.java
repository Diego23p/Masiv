package Masivian.roulette.model;

import Masivian.roulette.model.enums.Color;
import Masivian.roulette.model.enums.State;
import Masivian.roulette.model.interfaces.GameBehaviors;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Roulette implements GameBehaviors, Serializable{
    private int id;
    private State state;
    private int winnerNumber;
    private Color winnerColor;
    
    public Roulette (int id){
        this.id=id;
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

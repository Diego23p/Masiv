package Masivian.roulette.model;

import Masivian.roulette.model.interfaces.BetBehaviors;
import java.io.Serializable;
import lombok.Data;

@Data
public abstract class Bet implements BetBehaviors, Serializable{
    private int id;
    private int rouletteId;
    private double amountOfMoney;
    private String userId;
    
    public Bet(int rouletteId, double amountOfMoney, String userId){
        this.rouletteId=rouletteId;
        this.amountOfMoney=amountOfMoney;
        this.userId=userId;
    }
}

package Masivian.roulette.model;

import Masivian.roulette.model.interfaces.BetBehaviors;

public abstract class Bet implements BetBehaviors{
    private Roulette roulette;
    private double amountOfMoney;
    private String userId;
    public Bet(Roulette roulette, double amountOfMoney, String userId){
        this.roulette=roulette;
        this.amountOfMoney=amountOfMoney;
        this.userId=userId;
    }
    public double getAmountOfMoney (){
        return amountOfMoney;
    }
}

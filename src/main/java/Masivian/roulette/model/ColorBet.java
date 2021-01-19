package Masivian.roulette.model;

import Masivian.roulette.model.enums.Color;

public class ColorBet extends Bet{
    private Color color;
    
    public ColorBet(Roulette roulette, double amountOfMoney, String userId, Color color){
        super(roulette,amountOfMoney,userId);
        this.color=color;
    }

    @Override
    public double deliverMoney() {
        return getAmountOfMoney()*1.8;
    }
    
}

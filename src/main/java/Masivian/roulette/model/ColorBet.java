package Masivian.roulette.model;

import Masivian.roulette.model.enums.Color;

public class ColorBet extends Bet{
    private Color color;
    
    public ColorBet(int rouletteId, double amountOfMoney, String userId, Color color){
        super(rouletteId,amountOfMoney,userId);
        this.color=color;
    }

    @Override
    public double deliverMoney() {
        return this.getAmountOfMoney()*1.8;
    }
    
    @Override
    public boolean isWinner(int winnerNumber) {
        if(isPair(winnerNumber) && this.color.equals(Color.Red)){
            return true;            
        } else if (!isPair(winnerNumber) && this.color.equals(Color.Black)){
            return true;
        }
        return false;
    }
    
    private boolean isPair(int number){
        return (number%2 == 0);
    }
}

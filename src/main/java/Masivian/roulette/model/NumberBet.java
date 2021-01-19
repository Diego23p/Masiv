package Masivian.roulette.model;

public class NumberBet extends Bet{
    private int number;
    
    public NumberBet(Roulette roulette, double amountOfMoney, String userId, int number){
        super(roulette,amountOfMoney,userId);
        this.number=number;
    }

    @Override
    public double deliverMoney() {
        return super.getAmountOfMoney()*5;
    }
    
}

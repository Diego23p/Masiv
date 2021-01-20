package Masivian.roulette.model;

public class NumberBet extends Bet{
    private int number;
    
    public NumberBet(int rouletteId, double amountOfMoney, String userId, int number){
        super(rouletteId,amountOfMoney,userId);
        this.number=number;
    }

    @Override
    public double deliverMoney() {
        return this.getAmountOfMoney()*5;
    }

    @Override
    public boolean isWinner(int winnerNumber) {
        return (this.number==winnerNumber);
    }
}

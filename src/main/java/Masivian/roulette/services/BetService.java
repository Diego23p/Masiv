package Masivian.roulette.services;

import Masivian.roulette.model.Bet;
import java.util.List;

public interface BetService {
    public void save(Bet bet);
    public List<Bet> getAll();
}

package Masivian.roulette.repository;

import Masivian.roulette.model.Bet;
import java.util.List;

public interface BetRepository {
    public void save(Bet bet);
    public List<Bet> getAll();
}

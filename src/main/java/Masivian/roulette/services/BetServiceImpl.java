package Masivian.roulette.services;

import Masivian.roulette.model.Bet;
import Masivian.roulette.repository.BetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService{
    
    @Autowired
    private BetRepository betRepository;

    @Override
    public void save(Bet bet) {
        betRepository.save(bet);
    }

    @Override
    public List<Bet> getAll() {
        return betRepository.getAll();
    }
}

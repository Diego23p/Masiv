package Masivian.roulette.repository;

import Masivian.roulette.model.Bet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BetRepositoryImpl implements BetRepository{
    
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "BET";

    @Override
    public void save(Bet bet) {
        int id = redisTemplate.opsForHash().values(KEY).size();
        bet.setId(id);
        redisTemplate.opsForHash().put(KEY, bet.getId(), bet);
    }

    @Override
    public List<Bet> getAll() {
        return redisTemplate.opsForHash().values(KEY);
    }
}

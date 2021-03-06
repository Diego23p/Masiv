package Masivian.roulette.repository;

import Masivian.roulette.model.Roulette;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RouletteRepositoryImpl implements RouletteRepository{
    
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "ROULETTE";
    
    @Override
    public int getNewId(){
        return redisTemplate.opsForHash().values(KEY).size();
    }

    @Override
    public List<Roulette> getAll() {
        return redisTemplate.opsForHash().values(KEY);
    }
    
    @Override
    public Roulette findById(int id) {
        return (Roulette)redisTemplate.opsForHash().get(KEY, id);
    }
    
    @Override
    public void save(Roulette roulette) {
        redisTemplate.opsForHash().put(KEY, roulette.getId(), roulette);
    }
}

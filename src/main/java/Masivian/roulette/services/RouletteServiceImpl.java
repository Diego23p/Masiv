package Masivian.roulette.services;

import Masivian.roulette.model.Roulette;
import Masivian.roulette.repository.RouletteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteServiceImpl implements RouletteService{
    
    @Autowired
    private RouletteRepository rouletteRepository;
    
    @Override
    public int getNewId(){
        return rouletteRepository.getNewId();
    }

    @Override
    public void create(Roulette roulette) {
        rouletteRepository.create(roulette);
    }

    @Override
    public List<Roulette> getAll() {
        return rouletteRepository.getAll();
    }
    
}

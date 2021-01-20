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
    public List<Roulette> getAll() {
        return rouletteRepository.getAll();
    }

    @Override
    public Roulette findById(int id) {
        return rouletteRepository.findById(id);
    }

    @Override
    public void save(Roulette roulette) {
        rouletteRepository.save(roulette);
    }
}

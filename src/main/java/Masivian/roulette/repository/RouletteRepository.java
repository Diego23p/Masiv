package Masivian.roulette.repository;

import Masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteRepository {
    
    public int getNewId();

    public void create(Roulette roulette);

    public List<Roulette> getAll();
    
}

package Masivian.roulette.services;

import Masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteService {
    
    public int getNewId();

    public void create(Roulette roulette);

    public List<Roulette> getAll();
}

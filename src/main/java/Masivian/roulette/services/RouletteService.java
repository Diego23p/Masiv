package Masivian.roulette.services;

import Masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteService {
    public int getNewId();
    public List<Roulette> getAll();
    public Roulette findById(int id);
    public void save(Roulette roulette);
}

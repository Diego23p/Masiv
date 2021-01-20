package Masivian.roulette.repository;

import Masivian.roulette.model.Roulette;
import java.util.List;

public interface RouletteRepository {
    public int getNewId();
    public List<Roulette> getAll();
    public Roulette findById(int id);
    public void save(Roulette roulette);
}

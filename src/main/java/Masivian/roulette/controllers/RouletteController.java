package Masivian.roulette.controllers;

import Masivian.roulette.model.Bet;
import Masivian.roulette.model.Roulette;
import Masivian.roulette.services.BetService;
import Masivian.roulette.services.RouletteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roulette")
public class RouletteController {
    
    @Autowired
    private RouletteService rouletteService;
    
    @Autowired
    private BetService betService;
    
    @PostMapping
    public ResponseEntity<?> createRoulette() {
        try {
            int newId = getNewId();
            Roulette roulette = new Roulette(newId);
            saveRoulette(roulette);
            return new ResponseEntity<>(newId,HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public int getNewId(){
        return rouletteService.getNewId();
    }
    
    @PutMapping("/openById/{id}")
    public ResponseEntity<?> openRoulette(@PathVariable(name="id") int id) {
        try {
            Roulette roulette = findRouletteById(id);
            roulette.open();
            saveRoulette(roulette);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/closeById/{id}")
    public ResponseEntity<?> closeRoulette(@PathVariable(name="id") int id) {
        try {
            Roulette roulette = findRouletteById(id);
            roulette.close();
            roulette.findWinner();
            saveRoulette(roulette);
            List<String> betList = findBetsByRoulette(roulette);
            return new ResponseEntity<>(betList,HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    public List<String> findBetsByRoulette(Roulette roulette){
        List<Bet> betList = betService.getAll();
        List<String> betResults = new ArrayList();
        for (Bet bet: betList){
            if(bet.getRouletteId()==roulette.getId()){
                double gain = 0;
                if(bet.isWinner(roulette.getWinnerNumber())){
                    gain = bet.deliverMoney();
                }
                betResults.add("El Jugador: "+bet.getUserId()+" Ganó: "+gain);
            }
        }
        return betResults;
    }
    
    @GetMapping
    public ResponseEntity<?> getAllRoulettes() {
        try {
            List<Roulette> list= rouletteService.getAll();
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public Roulette findRouletteById(int id){
        return rouletteService.findById(id);
    }
    
    public void saveRoulette(Roulette roulette){
        rouletteService.save(roulette);
    }
}
package Masivian.roulette.controllers;

import Masivian.roulette.model.Roulette;
import Masivian.roulette.services.RouletteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouletteController {
    
    @Autowired
    private RouletteService rouletteService;
    
    @PostMapping("/roulette")
    public ResponseEntity<?> createRoulette() {
        try {
            int newId = getNewId();
            Roulette roulette = new Roulette(newId);
            rouletteService.create(roulette);
            
            return new ResponseEntity<>(newId,HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public int getNewId(){
        return rouletteService.getNewId();
    }
    
    @GetMapping("/roulette")
    public ResponseEntity<?> getAllRoulettes() {
        try {
            List<Roulette> list= rouletteService.getAll();
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

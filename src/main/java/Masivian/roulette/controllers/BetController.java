package Masivian.roulette.controllers;

import Masivian.roulette.model.Bet;
import Masivian.roulette.model.ColorBet;
import Masivian.roulette.model.NumberBet;
import Masivian.roulette.model.Roulette;
import Masivian.roulette.model.enums.Color;
import Masivian.roulette.model.enums.State;
import Masivian.roulette.services.BetService;
import Masivian.roulette.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetController {
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private RouletteService rouletteService;
    
    @PostMapping("/roulette/{rouletteId}/betTo/{betOption}/amountOfMoney/{amountOfMoney}")
    public ResponseEntity<?> createBet(@PathVariable(name="rouletteId") int rouletteId, 
                                       @PathVariable(name="betOption") String betOption,
                                       @PathVariable(name="amountOfMoney") double amountOfMoney,
                                       @RequestHeader(name="userId") String userId){
        try {
            Roulette roulette = rouletteService.findById(rouletteId);
            if (!isOpen(roulette) || isInvalidAmount(amountOfMoney)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            String betType = findBetType(betOption);
            Bet bet = null;
            switch (betType) {
                case "Num":
                    int number = Integer.parseInt(betOption);
                    bet = new NumberBet(rouletteId, amountOfMoney, userId, number);
                    break;
                case "Color":
                    bet = new ColorBet(rouletteId, amountOfMoney, userId, Color.valueOf(betOption));
                    break;
                case "Invalid": 
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            saveBet(bet);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    public boolean isOpen(Roulette roulette){
        return (roulette.getState() == State.Open);
    }
    
    public boolean isInvalidAmount(double amountOfMoney){
        return (amountOfMoney<=0 || amountOfMoney>10000);
    }
    
    public String findBetType(String betOption){
        if (isAValidNumber(betOption)){
            return "Num";
        } else if (betOption.equals("Black") || betOption.equals("Red")){
            return "Color";
        } else { return "Invalid"; }      
    }
    
    private static boolean isAValidNumber(String text) {
        try {
            int aux = Integer.parseInt(text);
            return (aux>=0 && aux<=36);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public void saveBet(Bet bet){
        betService.save(bet);
    }
}
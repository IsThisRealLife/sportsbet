package com.pavlos.sportsbet.web.controllers;

import com.pavlos.sportsbet.entities.MatchOdd;
import com.pavlos.sportsbet.services.MatchOddsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchOddsController {

    private final MatchOddsService matchOddsService;

    public MatchOddsController(MatchOddsService matchOddsService) {
        this.matchOddsService = matchOddsService;
    }
    @GetMapping("/api/matches/{matchId}/match-odds")
    public ResponseEntity<List<MatchOdd>> getMatchOdds(@PathVariable Long matchId) {
        return new ResponseEntity<>(matchOddsService.getMatchOddsByMatchId(matchId), HttpStatus.OK);
    }

    @PostMapping("/api/matches/{matchId}/match-odds")
    public ResponseEntity<MatchOdd> createMatchOdds(@PathVariable Long matchId, @RequestBody MatchOdd matchOdd){
        MatchOdd savedMatchOdd = matchOddsService.insertMatchOdds(matchId, matchOdd);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Match-Odds", "/api/matches/" + matchId.toString() + "/match-odds/" + savedMatchOdd.toString());
        return new ResponseEntity<>(savedMatchOdd, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/api/matches/{matchId}/match-odds/{matchOddsId}")
    public ResponseEntity<MatchOdd> updateMatchOdds(@PathVariable Long matchId, @PathVariable Long matchOddsId, @RequestBody MatchOdd matchOdd){
        return new ResponseEntity<>(matchOddsService.updateMatchOdds(matchId, matchOddsId, matchOdd), HttpStatus.OK);
    }

    @DeleteMapping("/api/matches/{matchId}/match-odds/{matchOddsId}")
    public ResponseEntity<MatchOdd> deleteMatchOdds(@PathVariable Long matchId, @PathVariable Long matchOddsId) {
        matchOddsService.deleteMatchOdds(matchId, matchOddsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

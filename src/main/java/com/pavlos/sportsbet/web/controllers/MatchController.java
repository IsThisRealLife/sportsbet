package com.pavlos.sportsbet.web.controllers;

import com.pavlos.sportsbet.entities.Match;
import com.pavlos.sportsbet.services.MatchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/api/matches")
    public ResponseEntity<List<Match>> getMatches() {
        return new ResponseEntity<>(matchService.getMatches(), HttpStatus.OK);
    }

    @GetMapping("/api/matches/{matchId}")
    public ResponseEntity<Match> getMatch(@PathVariable Long matchId) {
        return new ResponseEntity<>(matchService.getMatchById(matchId), HttpStatus.OK);
    }

    @PostMapping("/api/matches")
    public ResponseEntity<Match> saveMatch(@RequestBody Match match){
        Match savedMatch = matchService.insertMatch(match);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Match", "/api/matches/" + savedMatch.getId());
        return new ResponseEntity<>(savedMatch, httpHeaders, HttpStatus.CREATED);

    }

    @PutMapping({"/api/matches/{matchId}"})
    public ResponseEntity<Match> updateMatch(@PathVariable Long matchId, @RequestBody Match match) {
        return new ResponseEntity<>(matchService.updateMatch(matchId, match), HttpStatus.OK);
    }

    @DeleteMapping({"/api/matches/{matchId}"})
    public ResponseEntity<Match> deleteMatch(@PathVariable Long matchId) {
        matchService.deleteMatch(matchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

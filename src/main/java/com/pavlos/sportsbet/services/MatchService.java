package com.pavlos.sportsbet.services;

import com.pavlos.sportsbet.entities.Match;
import com.pavlos.sportsbet.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public Match insertMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match getMatchById(Long matchId) {
        return matchRepository.findById(matchId).get();
    }

    public Match updateMatch(Long matchId, Match match) {
        Match savedMatch = matchRepository.findById(matchId).get();
        savedMatch.setMatchDate(match.getMatchDate());
        savedMatch.setMatchTime(match.getMatchTime());
        savedMatch.setDescription(match.getDescription());
        savedMatch.setTeamA(match.getTeamA());
        savedMatch.setTeamB(match.getTeamB());
        savedMatch.setSport(match.getSport());
        return matchRepository.save(savedMatch);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }
}

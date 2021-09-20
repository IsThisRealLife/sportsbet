package com.pavlos.sportsbet.services;

import com.pavlos.sportsbet.entities.Match;
import com.pavlos.sportsbet.entities.MatchOdd;
import com.pavlos.sportsbet.repositories.MatchOddsRepository;
import com.pavlos.sportsbet.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchRepository matchRepository;

    public MatchOddsService(MatchOddsRepository matchOddsRepository, MatchRepository matchRepository) {
        this.matchOddsRepository = matchOddsRepository;
        this.matchRepository = matchRepository;
    }

    public List<MatchOdd> getMatchOddsByMatchId(Long matchId) {
        return matchOddsRepository.findAllByMatchId(matchId);
    }

    public MatchOdd insertMatchOdds(Long matchId, MatchOdd matchOdd) {
        Match match = matchRepository.findById(matchId).get();
        matchOdd.setMatch(match);
        return matchOddsRepository.save(matchOdd);
    }

    public MatchOdd updateMatchOdds(Long matchId, Long matchOddsId, MatchOdd matchOdd) {
        MatchOdd savedMatchOdd = matchOddsRepository.findById(matchOddsId).get();

        savedMatchOdd.setOdd(matchOdd.getOdd());
        savedMatchOdd.setSpecifier(matchOdd.getSpecifier());

        return matchOddsRepository.save(savedMatchOdd);
    }

    public void deleteMatchOdds(Long matchId, Long matchOddsId) {
        matchOddsRepository.deleteById(matchOddsId);
    }
}

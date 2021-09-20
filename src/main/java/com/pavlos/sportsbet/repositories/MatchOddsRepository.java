package com.pavlos.sportsbet.repositories;

import com.pavlos.sportsbet.entities.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdd, Long> {
    List<MatchOdd> findAllByMatchId(Long matchId);
}

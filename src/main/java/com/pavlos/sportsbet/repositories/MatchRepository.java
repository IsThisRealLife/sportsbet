package com.pavlos.sportsbet.repositories;

import com.pavlos.sportsbet.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}

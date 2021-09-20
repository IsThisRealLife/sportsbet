package com.pavlos.sportsbet.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pavlos.sportsbet.enums.Sport;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "MATCH")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated match ID")
    public Long id;

    @ApiModelProperty(notes = "The description of the match", example="OSFP-PAO")
    public String description;

    @ApiModelProperty(notes = "The date of the match", required = true, dataType = "java.lang.String", example="31/03/1992")
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate matchDate;

    @ApiModelProperty(notes = "The time of the match", required = true, dataType = "java.lang.String", example="12:00")
    @NotNull
    @JsonFormat(pattern = "HH:mm")
    public LocalTime matchTime;

    @ApiModelProperty(notes = "The first team of the match", required = true, example="OSFP")
    @NotNull
    @Column(name = "team_a")
    public String teamA;

    @ApiModelProperty(notes = "The second team of the match", required = true, example="PAO")
    @NotNull
    @Column(name = "team_b")
    public String teamB;

    @ApiModelProperty(notes = "The type of sport", required = true, example="BASKETBALL")
    @NotNull
    public Sport sport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate match_date) {
        this.matchDate = match_date;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime time) {
        this.matchTime = time;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String team_a) {
        this.teamA = team_a;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String team_b) {
        this.teamB = team_b;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}

package com.pavlos.sportsbet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MATCH_ODDS")
public class MatchOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated match odd ID")
    private Long id;

    @ApiModelProperty(notes = "The specifier of the match odd", required = true)
    @NotNull
    private String specifier;

    @ApiModelProperty(notes = "The odd of the match", required = true)
    @NotNull
    private Double odd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Match match;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}

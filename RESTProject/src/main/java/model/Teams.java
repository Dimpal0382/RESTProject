package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {
    @JsonProperty("teamStats")
    public List<TeamStats> teamStats;

    @JsonProperty("name")
    public String name;

    public Teams(List<TeamStats> teamStats, String name) {
        this.teamStats = teamStats;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Teams() {
    }

    public Teams(List<TeamStats> teamStats) {
        this.teamStats = teamStats;
    }

    public List<TeamStats> getTeamStats() {
        return teamStats;
    }

    public void setTeamStats(List<TeamStats> teamStats) {
        this.teamStats = teamStats;
    }

   }

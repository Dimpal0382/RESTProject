package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PersonResponse {
    @JsonProperty("teams")
    public List<RosterTeam> rosterTeam;

    public PersonResponse() {
    }

    public List<RosterTeam> getRosterTeam() {
        return rosterTeam;
    }

    public void setRosterTeam(List<RosterTeam> rosterTeam) {
        this.rosterTeam = rosterTeam;
    }
}

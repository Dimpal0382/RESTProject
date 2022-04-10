package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStats {
    @JsonProperty("splits")
    public List<SplitsItem> splitsList;

    public TeamStats() {
    }

    public TeamStats(List<SplitsItem> splitsList) {
        this.splitsList = splitsList;
    }

    public List<SplitsItem> getSplitsList() {
        return splitsList;
    }

    public void setSplitsList(List<SplitsItem> splitsList) {
        this.splitsList = splitsList;
    }
}

package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {
    public Object pts;

    public Stat() {
    }

    public Object getPts() {
        return pts;
    }

    public void setPts(Object pts) {
        this.pts = pts;
    }
}
package model;



//@JsonInclude(JsonInclude.Include.NON_NULL)

import java.util.List;

public class Person {

    class TeamData {
        String id;
        String name;
    }

    class Stats {
        Integer points;
        Integer rank;
    }


    class TeamStats {
        TeamData tData;
        Stats s;
    }

    class SplitStats {
        List<TeamStats> stats;
    }


}


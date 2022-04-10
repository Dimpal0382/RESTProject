package helpers;

import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import model.*;
import constants.Endpoints;
import utils.ConfigManager;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;

public class PersonServiceHelper {

    public static String BASE_URL;

    static {
        try {
            BASE_URL = String.valueOf(ConfigManager.getInstance().getAsString("base_Url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;

    }

    public Map<String,String> getAllTeam() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_TEAM)
                .then()
                .extract()
                .response()
                .andReturn();


        model.Response r = response.as(model.Response.class);
        model.Teams t = new Teams();
        model.TeamStats stats = new TeamStats();
        Map<String, String> map1 = new HashMap<>();
        for (int i = 0; i < r.getTeams().size(); i++) {
            String teampts = String.valueOf(r.getTeams().get(i).getTeamStats().get(0).getSplitsList().get(0).stat.getPts());
            String teamname = r.getTeams().get(i).getName();
            map1.put(teamname, teampts);
        }

        Stream<Map.Entry<String, String>> sorted =
                map1.entrySet().stream()
                        .sorted(reverseOrder(Map.Entry.comparingByValue())).limit(10);
        sorted.forEach(en -> System.out.println(en.getKey() + " - " + en.getValue()));
       return map1;

    }

    public List<String> getAllPlayers() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_TEAM)
                .then()
                .extract()
                .response()
                .andReturn();

        model.Response r = response.as(model.Response.class);
        Teams t = new Teams();
        TeamStats stats = new TeamStats();

        List<List<List<Map<String, Map<String, Object>>>>> allTeamData = response.path("teams.teamStats.splits");

        for (int i = 0; i < r.getTeams().size(); i++) {
            String teamId = String.valueOf(r.getTeams().get(i).getTeamStats().get(0).getSplitsList().get(0).team.getId());
            //l1.add(teamId);
            Endpoints.GET_TEAMS_ROSTER= Endpoints.GET_TEAMS_ROSTER.replaceAll("ID",teamId);

            Response r1 = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .get(Endpoints.GET_TEAMS_ROSTER)
                    .then()
                    .extract()
                    .response()
                    .andReturn();
            model.PersonResponse pr = r1.as(PersonResponse.class);
            List<List<Map<String, Map<String, Object>>>> allRoster = r1.path("teams.roster.roster");
            //String personId = r1.get(0).get(0).get("person").get("id");
                //List<String> l1 = response1.path("roster");
            }
            // l1.forEach(System.out::println);
        return null;
        }
}



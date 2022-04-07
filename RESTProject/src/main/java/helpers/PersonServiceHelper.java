package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
//import model.Person;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;

public class PersonServiceHelper {

    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static String BASE_URL;

    static {
        //BASE_URL = ConfigManager.getInstance().getAsString("base_Url");
        BASE_URL =  "https://statsapi.web.nhl.com/api/v1/teams/?expand=team.stats&season=20202021";
    }

    public PersonServiceHelper (){
        RestAssured.baseURI = BASE_URL;


    }

    public List<String> getAllTeam() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_TEAM)
                .then()
                .extract()
                .response()
                .andReturn();

        //JsonPath jsonPathEvaluator =response.jsonPath();

        //Type type = new TypeRef<List<Person>>(){}.getType();
        //List <Person> personList = response.as(type);
        List<List<List<Map<String, Map<String, Object>>>>> allTeamData = response.path("teams.teamStats.splits");



        Map<String,String> map1 = new HashMap<>();
        for (int i=0; i< allTeamData.size(); i++){
            String teamname = (String) allTeamData.get(i).get(0).get(0).get("team").get("name");
            String teampts = String.valueOf(allTeamData.get(i).get(0).get(0).get("stat").get("pts"));
            map1.put(teamname,teampts);

        }
        Stream<Map.Entry<String, String >> sorted =
                map1.entrySet().stream()
                        .sorted(reverseOrder(Map.Entry.comparingByValue())).limit(10);

        System.out.println(sorted);
        sorted.forEach(en -> System.out.println(en.getKey() +" - "+ en.getValue()));
        List<String> l = sorted.map(k -> k.getKey()).toList();
        Collections.reverse(l);
        return l;

    }

//    public List<Integer> extractListOfMapsOfElements_findAllTeamData() {
//        Response response = RestAssured
//                .given()
//                .contentType(ContentType.JSON)
//                .get(Endpoints.GET_ALL_TEAM)
//                .then()
//                .extract()
//                .response()
//                .andReturn();
//        //List<Map<Integer,String>> allTeamData = response.path("teams.teamStats.splits.team.id","teams.teamStats.splits.team.name");
//        //allTeamData.sort();
//        List <Integer> allTeamData = response.path("teams.teamStats.splits.stat.pts");
//        return allTeamData;
//        //System.out.println(allTeamData);
//    }



}



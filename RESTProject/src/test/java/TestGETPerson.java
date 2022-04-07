import helpers.PersonServiceHelper;
//import model.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

public class TestGETPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGETAllTeam(){
        //List<Map<Integer,String>> allTeamData = personServiceHelper.extractListOfMapsOfElements_findAllTeamData();
        List<String> personList = personServiceHelper.getAllTeam();

        assertNotNull(personList, "List is not empty");
        System.out.println(personList);
    }
}

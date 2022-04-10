import helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

public class TestGET {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGETAllTeam(){
        Map<String,String> allTeam = personServiceHelper.getAllTeam();
        assertNotNull(allTeam, "Map is not empty");
    }

}

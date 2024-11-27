package testsuite;

import Utilities.Utility;
import org.junit.Before;

public class GearTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com";

    @Before
    public void setup (){
        openBrowser(baseURL);
    }

}

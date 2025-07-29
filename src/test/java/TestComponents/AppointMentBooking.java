package TestComponents;

import java.io.IOException;
import org.testng.annotations.Test;
import EzionpageObjects.UserIdPage;
import abdulTest.BaseTest;

public class AppointMentBooking extends BaseTest {
    UserIdPage data;

    @Test
    public void Login() throws InterruptedException {
    	
    
    	String userId = System.getProperty("USER_ID", prop.getProperty("USER_ID"));
    	String personId = System.getProperty("PERSON_ID", prop.getProperty("PERSON_ID"));
    	String password = System.getProperty("PASSWORD", prop.getProperty("PASSWORD"));
        data = login.login(userId);
        data.enterMobileNumber(personId);
        data.enterPassword(password);
        data.clickContinue();
    }
}

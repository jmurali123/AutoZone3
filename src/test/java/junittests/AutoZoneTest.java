package junittests;

import com.beust.jcommander.Parameters;
import factory.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LandingPage;
import pages.RegisterPage;
import utils.ConfigLoader;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutoZoneTest {

    private static final Object[] getcreds(){
        return new Object[]{
                new Object[] {"testuser15","Password@123"}
        };
    }

    private WebDriver driver;

    @BeforeEach
    public void setDriver(){
        driver= DriverFactory.initializeDriver("chrome");
    }

    @AfterEach
    public void tearDown(){
       driver.quit();
    }

    @Test
    @Order(2)
    public void RegisterTest(){
        String url=ConfigLoader.getInstance().getURL();
        driver.get(url);
        LandingPage lp=new LandingPage(driver);
        RegisterPage rp=new RegisterPage(driver);
        HomePage hp=new HomePage(driver);
        lp.closenewsletternotification();
        lp.login();

        rp.switch_to_registersection();
        rp.enter_regUsername("Test15user");
        rp.enter_regEmailaddress("Test15@gmail.com");
        rp.enter_regPassword("Password@123#$");
        rp.sign_up();
        if(rp.isPasswordWeak()){
            System.out.println("Password is weak");
        }

        hp.SignoutLinkclicked();
    }

    @Test
    @Order(1)
    public void LoginTest(){
        System.out.println("I am in Login Test");
        assertTrue(2==2); //Checks if the condition is true
        System.out.println("I am after assertion true");
        assertEquals("Selenium","Selenium"); //Verifies that objects are identical
        assertFalse(2==1); //checks if the condition is false
        String t=null;
        assertNull(t); // checks if the object is null
        t="Testing";
        assertNotNull(t); //checks if the object is not null

    }

}

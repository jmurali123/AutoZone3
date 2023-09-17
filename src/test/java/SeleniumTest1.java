import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LandingPage;
import pages.RegisterPage;
import utils.ConfigLoader;
import utils.PropertyUtils;

import java.util.Scanner;

public class SeleniumTest1 {
  static  String browser;
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Enter the browser");
        Scanner sc= new Scanner(System.in);
        browser=sc.next();
        WebDriver driver;
        driver=DriverFactory.initializeDriver(browser);
       // String url=PropertyUtils.propertyLoader("src\\test\\resources\\prod_config.properties").getProperty("baseUrl");
        String url= ConfigLoader.getInstance().getURL();
        driver.get(url);
        LandingPage lp=new LandingPage(driver);
        RegisterPage rp=new RegisterPage(driver);
        HomePage hp=new HomePage(driver);
        lp.closenewsletternotification();
        lp.login();

        rp.switch_to_registersection();
        rp.enter_regUsername("Test14user");
        rp.enter_regEmailaddress("Test14@gmail.com");
        rp.enter_regPassword("Password@123#$");
        rp.sign_up();
        if(rp.isPasswordWeak()){
            System.out.println("Password is weak");
        }

        hp.SignoutLinkclicked();

    }
}

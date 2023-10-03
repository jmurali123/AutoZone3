package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.PageFactoryManager;

public class Landingstepdef {
  private final LandingPage landingPage;
  static final Logger log = LogManager.getLogger(Landingstepdef.class);

  public Landingstepdef(DriverContext context){

      landingPage=PageFactoryManager.getLandingPage(context.driver);
  }
  @Given("I am registered user with username \"(.*)\" and password \"(.*)\"$")
  public void logintoAccount(String username, String password){
      log.debug("I am registered user with username "+username);
      log.error("Test");
      landingPage.closenewsletternotification();
      landingPage.login();
      landingPage.enterUsername(username);
      landingPage.enterPassword(password);
      landingPage.loginClick();
  }

  @Then("the user \"(.*)\" logins successfully$")
  public void theUserLoginsSuccessfully(String username) {
        System.out.println("User logged in successfully");
        System.out.println(landingPage.getUserLabel());
        Assert.assertEquals(landingPage.getUserLabel(),"Hello "+username+" (not "+username+"? Log out)");
    }
}

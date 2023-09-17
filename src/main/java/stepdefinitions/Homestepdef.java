package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.PageFactoryManager;
import utils.ConfigLoader;

public class Homestepdef {
    private final HomePage homePage;

    public Homestepdef(DriverContext context){
        homePage= PageFactoryManager.getHomePage(context.driver);
    }
    @Given("I am on the Automation Zone page")
    public void iAmOnTheAutomationZonePage() {
        homePage.load(ConfigLoader.getInstance().getURL());
    }

    @And("I log out from the application")
    public void iLogOutFromTheApplication() {
        homePage.SignoutLinkclicked();
    }
}

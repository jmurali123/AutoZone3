package stepdefinitions;

import context.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.HomePage;
import pages.PageFactoryManager;
import utils.ConfigLoader;

public class Homestepdef {
    private final HomePage homePage;
    static final Logger log = LogManager.getLogger(Homestepdef.class);

    public Homestepdef(DriverContext context){
        homePage= PageFactoryManager.getHomePage(context.driver);
    }
    @Given("I am on the Automation Zone page")
    public void iAmOnTheAutomationZonePage() {
        log.debug("I am on the automation zone page");
        homePage.load(ConfigLoader.getInstance().getURL());
    }

    @And("I log out from the application")
    public void iLogOutFromTheApplication() {
        homePage.SignoutLinkclicked();
    }
}

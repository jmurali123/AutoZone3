package stepdefinitions;

import context.DriverContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.LandingPage;
import pages.PageFactoryManager;
import pages.RegisterPage;

import java.util.List;
import java.util.Map;

public class Registerstepdef {
    private final RegisterPage registerPage;
    private final LandingPage landingPage;

    public Registerstepdef(DriverContext context){
        registerPage= PageFactoryManager.getRegisterPage(context.driver);
        landingPage= PageFactoryManager.getLandingPage(context.driver);

    }

    @Given("I am a new user")
    public void iAmANewUser(DataTable userregdata) {
        List<Map<String,String>> data=  userregdata.asMaps(String.class,String.class);
        landingPage.closenewsletternotification();
        landingPage.login();
        registerPage.switch_to_registersection();
        registerPage.enter_regUsername(data.get(0).get("username"));
        registerPage.enter_regEmailaddress(data.get(0).get("email"));
        registerPage.enter_regPassword(data.get(0).get("password"));
        registerPage.sign_up();
    }

}

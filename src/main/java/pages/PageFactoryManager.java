package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static HomePage homePage;
    private static LandingPage landingPage;
    private static RegisterPage registerPage;

    public static HomePage getHomePage(WebDriver driver){
        return homePage==null? new HomePage(driver) : homePage;
    }

    public static LandingPage getLandingPage(WebDriver driver){
        return landingPage==null? new LandingPage(driver):landingPage;
    }

    public static RegisterPage getRegisterPage(WebDriver driver){
        return registerPage==null? new RegisterPage(driver):registerPage;
    }

}

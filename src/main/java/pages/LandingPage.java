package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

//It encapsulate  the signup button and the signup method
public class LandingPage extends BasePage{

    @FindBy(css="#mf-newsletter-popup>div+div>a")
    private WebElement newsLetterPopupButton;

    @FindBy(css=".extras-menu>li+li+li")
    private WebElement loginMenuLink;

    @FindBy(css="#username")
    private WebElement usernameTextBox;

    @FindBy(css="#password")
    private WebElement passwordTextBox;

    @FindBy(css="button[name='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()[contains(., 'Hello')]]")
    private WebElement loginSuccessLabel;

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public void closenewsletternotification() {
        wait.until(ExpectedConditions.visibilityOf(newsLetterPopupButton));
        wait.until(ExpectedConditions.elementToBeClickable(newsLetterPopupButton));
        WebElement ele=newsLetterPopupButton;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();
    }

    public void login(){
        WebElement ele=loginMenuLink;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();
    }

    public void loginClick(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void enterUsername(String userName){
        wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(usernameTextBox));
        usernameTextBox.sendKeys(userName);

    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        passwordTextBox.sendKeys(password);
    }


    public String getUserLabel(){
      return  wait.until(ExpectedConditions.visibilityOf(loginSuccessLabel)).getText();
    }


}
